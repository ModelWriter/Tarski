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
package eu.modelwriter.marker.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.ActionSelectionDialog;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MappingWizard;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerWizard;
import eu.modelwriter.marker.ui.internal.wizards.selectionwizard.SelectionWizard;

public class AddRemoveTypeHandler extends AbstractHandler {
  public static String COMMAND_ID = "eu.modelwriter.marker.command.addremovetype";
  IFile file;
  ISelection selection;
  private ArrayList<IMarker> candidateToTypeChanging;

  private void addRemoveType() {
    this.file = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .getActiveEditor().getEditorInput().getAdapter(IFile.class);
    this.selection =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

    if (!MarkerPage.isParsed()) {
      final MessageDialog parseCtrlDialog = new MessageDialog(new Shell(), "Type Information", null,
          "You dont have any marker type registered to system! \n"
              + "Please parse an alloy file first",
          MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      parseCtrlDialog.open();
      return;
    }

    final ActionSelectionDialog actionSelectionDialog = new ActionSelectionDialog(new Shell());
    actionSelectionDialog.open();
    if (actionSelectionDialog.getReturnCode() == IDialogConstants.CANCEL_ID) {
      return;
    }

    IMarker selectedMarker = this.getMarker();
    selectedMarker = MarkUtilities.getLeaderOfMarker(selectedMarker);

    if (selectedMarker != null && selectedMarker.exists()) {
      this.findCandidateToTypeChangingMarkers(selectedMarker);
      if (actionSelectionDialog.getReturnCode() == IDialogConstants.YES_ID) {
        this.addType(selectedMarker);
      } else if (actionSelectionDialog.getReturnCode() == IDialogConstants.NO_ID) {
        final MessageDialog warningDialog = new MessageDialog(new Shell(), "Warning!", null,
            "If you remove marker's type, all relations of this marker has been removed! Do you want to continue to remove marker's type?",
            MessageDialog.WARNING, new String[] {"YES", "NO"}, 0);
        final int returnCode = warningDialog.open();
        if (returnCode != 0) {
          return;
        }
        this.removeType(selectedMarker);
      }
      // MarkerUpdater.updateTargets(selectedMarker);
      // MarkerUpdater.updateSources(selectedMarker);
    } else {
      final MessageDialog dialog =
          new MessageDialog(new Shell(), "There is no marker in this position", null,
              "Please select valid marker", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();
      return;
    }
  }

  private void addType(final IMarker selectedMarker) {
    final MarkerWizard markerWizard = new MarkerWizard(selectedMarker);

    final WizardDialog dialog = new WizardDialog(new Shell(), markerWizard);
    dialog.open();
  }

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    if (AlloyUtilities.isExists()) {
      this.candidateToTypeChanging = new ArrayList<IMarker>();
      this.addRemoveType();
      if (Activator.getDefault().getWorkbench().getWorkbenchWindows()[0].getActivePage()
          .findView(Visualization.ID) != null) {
        Visualization.showViz(Visualization.container);
      }
    } else {
      final MessageDialog infoDialog = new MessageDialog(new Shell(), "System Information", null,
          "You dont have any registered alloy file to system.", MessageDialog.INFORMATION,
          new String[] {"OK"}, 0);
      infoDialog.open();
    }
    return null;
  }

  /**
   * @param selectedMarker from text
   */
  private void findCandidateToTypeChangingMarkers(final IMarker selectedMarker) {
    this.candidateToTypeChanging.add(selectedMarker);

    final Map<IMarker, String> fieldsSources =
        AlloyUtilities.getRelationsOfSecondSideMarker(selectedMarker);
    final ArrayList<IMarker> relationsSources =
        AlloyUtilities.getSourcesOfMarkerAtRelations(selectedMarker);

    for (final IMarker iMarker : fieldsSources.keySet()) {
      this.candidateToTypeChanging.add(iMarker);
    }

    for (final IMarker iMarker : relationsSources) {
      this.candidateToTypeChanging.add(iMarker);
    }
  }

  private IMarker getMarker() {
    IMarker selectedMarker = null;
    if (this.selection instanceof ITextSelection) {
      final ITextSelection textSelection = (ITextSelection) this.selection;

      final ArrayList<IMarker> markerList =
          MarkerFactory.findMarkersInSelection(this.file, textSelection);
      if (markerList != null) {
        if (markerList.size() == 1) {
          selectedMarker = markerList.get(0);
        } else if (markerList.size() > 1) {
          final SelectionWizard selectionWizard = new SelectionWizard(markerList);
          final WizardDialog selectionDialog = new WizardDialog(new Shell(), selectionWizard);
          if (selectionDialog.open() == 1) {
            return null;
          }
          selectedMarker = selectionWizard.getSelectedMarker();
        }
      }
    } else if (this.selection instanceof ITreeSelection) {
      final IEditorPart editor =
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
      final ITreeSelection treeSelection = (ITreeSelection) this.selection;
      if (this.selection != null
          && ((ITreeSelection) this.selection).getFirstElement() instanceof IMarker) {
        selectedMarker = (IMarker) ((ITreeSelection) this.selection).getFirstElement();
      } else if (this.selection != null && editor instanceof EcoreEditor) {
        if (treeSelection.getFirstElement() instanceof ENamedElement
            && ((ENamedElement) treeSelection.getFirstElement()).getName() != null
            && !((ENamedElement) treeSelection.getFirstElement()).getName().isEmpty()) {

          final URI uri = EcoreUtil.getURI((ENamedElement) treeSelection.getFirstElement());

          selectedMarker = MarkerFactory.findMarkersByUri(this.file, uri.toString());
        } else if (!((EObject) treeSelection.getFirstElement() instanceof EModelElement)) {
          final URI uri = EcoreUtil.getURI((EObject) treeSelection.getFirstElement());
          selectedMarker = MarkerFactory.findMarkersByUri(this.file, uri.toString());
        }
      }
    }
    return selectedMarker;
  }

  private void removeType(IMarker selectedMarker) {
    selectedMarker = MappingWizard.convertAnnotationType(selectedMarker, true, true);

    IMarker marker = null;
    for (int i = 1; i < this.candidateToTypeChanging.size(); i++) {
      marker = this.candidateToTypeChanging.get(i);
      MappingWizard.convertAnnotationType(marker, true,
          MarkUtilities.compare(marker, selectedMarker));
    }
    AlloyUtilities.removeAllRelationsOfMarker(selectedMarker);
    AlloyUtilities.removeRelationOfMarker(selectedMarker);
    if (MarkUtilities.getGroupId(selectedMarker) != null) {
      final List<IMarker> group = MarkerFactory.findMarkersByGroupId(selectedMarker.getResource(),
          MarkUtilities.getGroupId(selectedMarker));
      for (final IMarker iMarker : group) {
        AlloyUtilities.removeTypeFromMarker(iMarker);
        MarkUtilities.setType(iMarker, null);
      }
    } else {
      AlloyUtilities.removeTypeFromMarker(selectedMarker);
      MarkUtilities.setType(selectedMarker, null);
    }
    final MessageDialog removeSuccessDialog = new MessageDialog(new Shell(), "Removing Type Action",
        null, "Selected marker's type has been removed.", MessageDialog.INFORMATION,
        new String[] {"OK"}, 0);
    removeSuccessDialog.open();
  }
}
