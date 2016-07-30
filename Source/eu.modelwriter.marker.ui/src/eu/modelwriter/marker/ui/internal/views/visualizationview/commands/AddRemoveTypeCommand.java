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
package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardDialog;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.ActionSelectionDialog;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MappingWizard;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerWizard;

public class AddRemoveTypeCommand implements Runnable {
  private ArrayList<IMarker> candidateToTypeChanging;
  private final IMarker marker;

  public AddRemoveTypeCommand(final IMarker marker) {
    this.marker = marker;
  }

  private void addRemoveType() {
    if (!MarkerPage.isParsed()) {
      final MessageDialog parseCtrlDialog =
          new MessageDialog(Activator.getShell(), "Type Information", null,
              "You dont have any marker type registered to system! \n"
                  + "Please parse an alloy file first",
              MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      parseCtrlDialog.open();
      return;
    }

    final ActionSelectionDialog actionSelectionDialog =
        new ActionSelectionDialog(Activator.getShell());
    actionSelectionDialog.open();
    if (actionSelectionDialog.getReturnCode() == IDialogConstants.CANCEL_ID) {
      return;
    }

    IMarker selectedMarker = this.marker;
    selectedMarker = MarkUtilities.getLeaderOfMarker(selectedMarker);

    if (selectedMarker != null && selectedMarker.exists()) {
      this.findCandidateToTypeChangingMarkers(selectedMarker);
      if (actionSelectionDialog.getReturnCode() == IDialogConstants.YES_ID) {
        AddRemoveTypeCommand.addType(selectedMarker);
      } else if (actionSelectionDialog.getReturnCode() == IDialogConstants.NO_ID) {
        final MessageDialog warningDialog =
            new MessageDialog(Activator.getShell(), "Warning!", null,
                "If you remove marker's type, all relations of this marker has been removed! Do you want to continue to remove marker's type?",
                MessageDialog.WARNING, new String[] {"YES", "NO"}, 0);
        final int returnCode = warningDialog.open();
        if (returnCode != 0) {
          return;
        }
        this.removeType(selectedMarker);
      }
    } else {
      final MessageDialog dialog =
          new MessageDialog(Activator.getShell(), "There is no marker in this position", null,
              "Please select valid marker", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();
      return;
    }
  }

  private static void addType(final IMarker selectedMarker) {
    final MarkerWizard markerWizard = new MarkerWizard(selectedMarker);
    final WizardDialog dialog = new WizardDialog(Activator.getShell(), markerWizard);
    dialog.open();
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

    final MessageDialog removeSuccessDialog = new MessageDialog(Activator.getShell(),
        "Removing Type Action", null, "Selected marker's type has been removed.",
        MessageDialog.INFORMATION, new String[] {"OK"}, 0);
    removeSuccessDialog.open();
  }

  @Override
  public void run() {
    if (AlloyUtilities.isExists()) {
      this.candidateToTypeChanging = new ArrayList<IMarker>();
      this.addRemoveType();
    } else {
      final MessageDialog infoDialog = new MessageDialog(Activator.getShell(), "System Information",
          null, "You dont have any registered alloy file to system.", MessageDialog.INFORMATION,
          new String[] {"OK"}, 0);
      infoDialog.open();
    }
  }
}
