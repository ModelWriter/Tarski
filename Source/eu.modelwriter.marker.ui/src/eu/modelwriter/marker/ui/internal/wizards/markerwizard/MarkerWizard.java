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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.configuration.internal.CreateMarkerWithType;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MappingWizard;

public class MarkerWizard extends Wizard {

  private MarkerPage page;
  private ISelection selection;
  private IFile file;
  private IMarker marker;
  private ArrayList<IMarker> candidateToTypeChanging;

  public MarkerWizard(IMarker marker) {
    this.marker = marker;
  }

  public MarkerWizard(ISelection selection, IFile file) {
    super();
    this.selection = selection;
    this.file = file;
  }

  @Override
  public void addPages() {
    this.page = new MarkerPage();
    super.addPages();
    this.addPage(this.page);
  }

  private void findCandidateToTypeChangingMarkers(IMarker selectedMarker) {
    this.candidateToTypeChanging.add(selectedMarker);

    Map<IMarker, String> fieldsSources =
        AlloyUtilities.getRelationsOfSecondSideMarker(selectedMarker);
    ArrayList<IMarker> relationsSources =
        AlloyUtilities.getSourcesOfMarkerAtRelations(selectedMarker);

    for (IMarker iMarker : fieldsSources.keySet()) {
      this.candidateToTypeChanging.add(iMarker);
    }

    for (IMarker iMarker : relationsSources) {
      this.candidateToTypeChanging.add(iMarker);
    }
  }

  @Override
  public String getWindowTitle() {
    return "Marking with Tag";
  }

  @Override
  public boolean performFinish() {
    this.candidateToTypeChanging = new ArrayList<IMarker>();
    this.findCandidateToTypeChangingMarkers(this.marker);
    if (MarkerPage.markTreeViewer.getTree().getSelection().length == 1) {
      if (MarkerPage.markTreeViewer.getTree().getSelection()[0].getText().endsWith("{abs}")) {
        MessageDialog dialog =
            new MessageDialog(MarkerActivator.getShell(), "Marker Type Information", null,
                "Selected type is not appropriate because it is marked as Abstact",
                MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
        return false;
      }

      if (!MarkerPage.markTreeViewer.getTree().getItems()[0]
          .equals(MarkerPage.markTreeViewer.getTree().getSelection()[0])) {
        if (this.selection != null) {
          CreateMarkerWithType.createMarker(this.file, this.selection,
              MarkerPage.markTreeViewer.getTree().getSelection()[0].getText());
          MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
              "Marker Type Information", null, "Marker has been created with selected type",
              MessageDialog.INFORMATION, new String[] {"OK"}, 0);
          dialog.open();
        } else {
          for (IMarker iMarker : this.candidateToTypeChanging) {
            MappingWizard.convertAnnotationType(iMarker, true,
                MarkUtilities.compare(iMarker, this.marker));
          }
          AlloyUtilities.removeAllRelationsOfMarker(this.marker);
          AlloyUtilities.removeRelationOfMarker(this.marker);
          if (MarkUtilities.getGroupId(this.marker) != null) {
            List<IMarker> list = MarkerFactory.findMarkersByGroupId(this.marker.getResource(),
                MarkUtilities.getGroupId(this.marker));
            for (IMarker iMarker : list) {
              AlloyUtilities.removeTypeFromMarker(iMarker);
              MarkUtilities.setType(iMarker,
                  MarkerPage.markTreeViewer.getTree().getSelection()[0].getText());
              if (MarkUtilities.getLeaderId(iMarker) != null) {
                AlloyUtilities.addTypeToMarker(iMarker);
              }
              AlloyUtilities.addMarkerToRepository(this.marker);
            }
          } else {
            AlloyUtilities.removeTypeFromMarker(this.marker);
            MarkUtilities.setType(this.marker,
                MarkerPage.markTreeViewer.getTree().getSelection()[0].getText());
            AlloyUtilities.addTypeToMarker(this.marker);
            AlloyUtilities.addMarkerToRepository(this.marker);
          }

          MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
              "Marker Type Information", null, "Selected type added to selected marker",
              MessageDialog.INFORMATION, new String[] {"OK"}, 0);
          dialog.open();
        }
        return true;
      } else {
        MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
            "Marker Type Information", null, "Please select a valid marker type.",
            MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
        return false;
      }
    } else {
      MessageDialog dialog =
          new MessageDialog(MarkerActivator.getShell(), "Marker Type Information", null,
              "Please select one marker type.", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();
      return false;
    }
  }
}
