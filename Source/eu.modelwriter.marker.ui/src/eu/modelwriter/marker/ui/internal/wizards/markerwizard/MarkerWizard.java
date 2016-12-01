/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ferhat Erata - initial API and implementation H. Emre Kirmizi - initial API and
 * implementation Serhat Celik - initial API and implementation U. Anil Ozturk - initial API and
 * implementation
 *******************************************************************************/
package eu.modelwriter.marker.ui.internal.wizards.markerwizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;

import eu.modelwriter.configuration.alloy.analysis.StaticAlloyAnalysisManager;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.configuration.internal.CreateMarkerWithType;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MarkerWizard extends Wizard {

  private MarkerPage page;
  private ISelection selection;
  private IFile file;
  private IMarker selectedMarker;
  private ArrayList<IMarker> candidateToTypeChanging;

  public MarkerWizard(final IMarker marker) {
    super();
    selectedMarker = marker;
  }

  public MarkerWizard(final ISelection selection, final IFile file) {
    super();
    this.selection = selection;
    this.file = file;
  }

  @Override
  public void addPages() {
    page = new MarkerPage(getDoubleClickListener());
    addPage(page);
  }

  private void findCandidateToTypeChangingMarkers(final IMarker selectedMarker) {
    candidateToTypeChanging.add(selectedMarker);

    final Map<IMarker, String> fieldsSources =
        AlloyUtilities.getRelationsOfSecondSideMarker(selectedMarker);
    final ArrayList<IMarker> relationsSources =
        AlloyUtilities.getSourcesOfMarkerAtRelations(selectedMarker);

    for (final IMarker iMarker : fieldsSources.keySet()) {
      candidateToTypeChanging.add(iMarker);
    }

    for (final IMarker iMarker : relationsSources) {
      candidateToTypeChanging.add(iMarker);
    }
  }

  private IDoubleClickListener getDoubleClickListener() {
    return new IDoubleClickListener() {
      @Override
      public void doubleClick(final DoubleClickEvent event) {
        final IStructuredSelection selection = (IStructuredSelection) event.getSelection();
        final Object firstElement = selection.getFirstElement();
        if (MarkerPage.markTreeViewer.isExpandable(firstElement)) {
          final boolean expanded = MarkerPage.markTreeViewer.getExpandedState(firstElement);
          MarkerPage.markTreeViewer.setExpandedState(firstElement, !expanded);
        } else {
          MarkerWizard.this.performFinish();
          MarkerWizard.this.getContainer().getShell().close();
        }
      }
    };
  }

  @Override
  public String getWindowTitle() {
    return "Create a Trace Element with Type";
  }

  @Override
  public boolean performFinish() {
    StaticAlloyAnalysisManager.finishAnalysis();

    candidateToTypeChanging = new ArrayList<>();
    if (MarkerPage.markTreeViewer.getTree().getSelection().length == 1) {
      if (MarkerPage.markTreeViewer.getTree().getSelection()[0].getText().endsWith("{abs}")) {
        final MessageDialog dialog =
            new MessageDialog(MarkerActivator.getShell(), "Trace Type Information", null,
                "Selected type is not appropriate because it is marked as Abstact",
                MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
        return false;
      }

      if (!MarkerPage.markTreeViewer.getTree().getItems()[0]
          .equals(MarkerPage.markTreeViewer.getTree().getSelection()[0])) {
        if (selection != null) {
          CreateMarkerWithType.createMarker(file, selection,
              MarkerPage.markTreeViewer.getTree().getSelection()[0].getText());
          // MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
          // "Marker Type Information", null, "Marker has been created with selected type",
          // MessageDialog.INFORMATION, new String[] {"OK"}, 0);
          // dialog.open();
        } else {
          findCandidateToTypeChangingMarkers(selectedMarker);
          selectedMarker =
              AnnotationFactory.convertAnnotationType(selectedMarker, true, true,
                  AlloyUtilities.getTotalTargetCount(selectedMarker));

          IMarker marker = null;
          for (int i = 1; i < candidateToTypeChanging.size(); i++) {
            marker = candidateToTypeChanging.get(i);
            AnnotationFactory.convertAnnotationType(marker, true,
                MarkUtilities.compare(marker, selectedMarker),
                AlloyUtilities.getTotalTargetCount(marker));
          }
          AlloyUtilities.removeAllRelationsOfMarker(selectedMarker);
          AlloyUtilities.removeRelationOfMarker(selectedMarker);
          if (MarkUtilities.getGroupId(selectedMarker) != null) {
            final List<IMarker> list = MarkerFactory.findMarkersByGroupId(
                selectedMarker.getResource(), MarkUtilities.getGroupId(selectedMarker));
            for (final IMarker iMarker : list) {
              AlloyUtilities.removeTypeFromMarker(iMarker);
              MarkUtilities.setType(iMarker,
                  MarkerPage.markTreeViewer.getTree().getSelection()[0].getText());
              if (MarkUtilities.getLeaderId(iMarker) != null) {
                AlloyUtilities.addTypeToMarker(iMarker);
              }
              AlloyUtilities.addMarkerToRepository(selectedMarker);
            }
          } else {
            AlloyUtilities.removeTypeFromMarker(selectedMarker);
            MarkUtilities.setType(selectedMarker,
                MarkerPage.markTreeViewer.getTree().getSelection()[0].getText());
            AlloyUtilities.addTypeToMarker(selectedMarker);
            AlloyUtilities.addMarkerToRepository(selectedMarker);
          }

          // MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
          // "Marker Type Information", null, "Selected type added to selected marker",
          // MessageDialog.INFORMATION, new String[] {"OK"}, 0);
          // dialog.open();
        }
        return true;
      } else {
        final MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
            "Trace Type Information", null, "Please select a valid marker type.",
            MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
        return false;
      }
    } else {
      final MessageDialog dialog =
          new MessageDialog(MarkerActivator.getShell(), "Trace Type Information", null,
              "Please select one trace type.", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();
      return false;
    }
  }
}
