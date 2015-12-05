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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.ActionSelectionDialog;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MappingWizard;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerWizard;

public class AddRemoveTypeCommand {
  private static ArrayList<IMarker> candidateToTypeChanging;
  static IMarker marker;

  private static void addRemoveType() {
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

    IMarker selectedMarker = AddRemoveTypeCommand.marker;
    selectedMarker = MarkUtilities.getLeaderOfMarker(selectedMarker);

    if (selectedMarker != null && selectedMarker.exists()) {
      AddRemoveTypeCommand.findCandidateToTypeChangingMarkers(selectedMarker);
      if (actionSelectionDialog.getReturnCode() == IDialogConstants.YES_ID) {
        AddRemoveTypeCommand.addType(selectedMarker);
      } else if (actionSelectionDialog.getReturnCode() == IDialogConstants.NO_ID) {
        final MessageDialog warningDialog = new MessageDialog(new Shell(), "Warning!", null,
            "If you remove marker's type, all relations of this marker has been removed! Do you want to continue to remove marker's type?",
            MessageDialog.WARNING, new String[] {"YES", "NO"}, 0);
        final int returnCode = warningDialog.open();
        if (returnCode != 0) {
          return;
        }
        AddRemoveTypeCommand.removeType(selectedMarker);
      }
    } else {
      final MessageDialog dialog =
          new MessageDialog(new Shell(), "There is no marker in this position", null,
              "Please select valid marker", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();
      return;
    }
  }

  private static void addType(final IMarker selectedMarker) {
    final MarkerWizard markerWizard = new MarkerWizard(selectedMarker);
    final WizardDialog dialog = new WizardDialog(new Shell(), markerWizard);
    dialog.open();
  }

  /**
   * @param selectedMarker from text
   */
  private static void findCandidateToTypeChangingMarkers(final IMarker selectedMarker) {
    AddRemoveTypeCommand.candidateToTypeChanging.add(selectedMarker);

    final Map<IMarker, String> fieldsSources =
        AlloyUtilities.getRelationsOfSecondSideMarker(selectedMarker);
    final ArrayList<IMarker> relationsSources =
        AlloyUtilities.getSourcesOfMarkerAtRelations(selectedMarker);

    for (final IMarker iMarker : fieldsSources.keySet()) {
      AddRemoveTypeCommand.candidateToTypeChanging.add(iMarker);
    }

    for (final IMarker iMarker : relationsSources) {
      AddRemoveTypeCommand.candidateToTypeChanging.add(iMarker);
    }
  }

  private static void removeType(IMarker selectedMarker) {
    selectedMarker = MappingWizard.convertAnnotationType(selectedMarker, true, true);

    IMarker marker = null;
    for (int i = 1; i < AddRemoveTypeCommand.candidateToTypeChanging.size(); i++) {
      marker = AddRemoveTypeCommand.candidateToTypeChanging.get(i);
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

  public static void run(final IMarker marker) {
    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        AddRemoveTypeCommand.marker = marker;
        if (AlloyUtilities.isExists()) {
          AddRemoveTypeCommand.candidateToTypeChanging = new ArrayList<IMarker>();
          AddRemoveTypeCommand.addRemoveType();
          Visualization.showViz(Visualization.container);
        } else {
          final MessageDialog infoDialog = new MessageDialog(new Shell(), "System Information",
              null, "You dont have any registered alloy file to system.", MessageDialog.INFORMATION,
              new String[] {"OK"}, 0);
          infoDialog.open();
        }
      }
    });
    return;
  }
}
