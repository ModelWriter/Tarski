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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MappingWizard;

public class DeleteCommand {
  static IEditorPart editor;
  static IMarker marker;
  private static ArrayList<IMarker> candidateToTypeChanging;

  private static void checkImpactAndChangedMechanism(final IMarker beDeleted) {
    if (MarkUtilities.getType(beDeleted) != null) {
      final Map<IMarker, String> sourceRelationsOfDeleted =
          AlloyUtilities.getRelationsOfSecondSideMarker(beDeleted);
      for (final IMarker targetMarker : sourceRelationsOfDeleted.keySet()) {
        if (AlloyUtilities.getRelationsOfFirstSideMarker(targetMarker).size() == 1) {
          AlloyUtilities.unsetChanged(targetMarker);
        }
      }
    }
  }

  private static void deleteFromAlloyXML(final IMarker beDeleted) {
    DeleteCommand.checkImpactAndChangedMechanism(beDeleted);
    AlloyUtilities.removeMarkerFromRepository(beDeleted);
    if (MarkUtilities.getGroupId(beDeleted) == null
        || MarkUtilities.getLeaderId(beDeleted) != null) {
      AlloyUtilities.removeTypeFromMarker(beDeleted);
      AlloyUtilities.removeRelationOfMarker(beDeleted);
    }
  }

  private static void deleteMarker() {
    try {
      final IMarker beDeleted = DeleteCommand.marker;
      if (beDeleted != null && beDeleted.exists()) {
        final MessageDialog warningDialog = new MessageDialog(new Shell(), "Warning!", null,
            "If you delete marker, all relations of this marker has been removed! Do you want to continue to delete marker?",
            MessageDialog.WARNING, new String[] {"YES", "NO"}, 0);
        if (warningDialog.open() != 0) {
          return;
        }

        DeleteCommand.findCandidateToTypeChangingMarkers(beDeleted);
        final String sourceIdOfSelectedMarker = MarkUtilities.getSourceId(beDeleted);

        for (final IMarker iMarker : DeleteCommand.candidateToTypeChanging) {
          MappingWizard.convertAnnotationType(iMarker, true,
              MarkUtilities.compare(MarkUtilities.getSourceId(iMarker), sourceIdOfSelectedMarker));
        }
        final String markerText = MarkUtilities.getText(beDeleted);

        if (MarkUtilities.getLeaderId(beDeleted) != null) {
          final String markerGroupId = MarkUtilities.getGroupId(beDeleted);
          final List<IMarker> markers =
              MarkerFactory.findMarkersByGroupId(beDeleted.getResource(), markerGroupId);

          for (int i = markers.size() - 1; i >= 0; i--) {
            DeleteCommand.deleteFromAlloyXML(markers.get(i));
            AnnotationFactory.removeAnnotation(markers.get(i));
            markers.get(i).delete();
          }
        } else {
          DeleteCommand.deleteFromAlloyXML(beDeleted);
          AnnotationFactory.removeAnnotation(beDeleted);
          beDeleted.delete();
        }
        final MessageDialog dialog =
            new MessageDialog(new Shell(), "Mark will be deleted by this wizard", null,
                "\"" + markerText + "\" has been selected to be unmarked",
                MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
      }
    } catch (final CoreException e) {
      e.printStackTrace();
    }
  }

  /**
   * @param selectedMarker from text
   */
  private static void findCandidateToTypeChangingMarkers(final IMarker selectedMarker) {
    final Map<IMarker, String> fieldsSources =
        AlloyUtilities.getRelationsOfSecondSideMarker(selectedMarker);
    final ArrayList<IMarker> relationsSources =
        AlloyUtilities.getSourcesOfMarkerAtRelations(selectedMarker);

    for (final IMarker iMarker : fieldsSources.keySet()) {
      DeleteCommand.candidateToTypeChanging.add(iMarker);
    }

    for (final IMarker iMarker : relationsSources) {
      DeleteCommand.candidateToTypeChanging.add(iMarker);
    }
  }

  private static void refresh() {
    ITextEditor iteEditor = null;
    if (DeleteCommand.editor instanceof EcoreEditor) {
      final EcoreEditor ecEditor = (EcoreEditor) DeleteCommand.editor;
      ecEditor.getViewer().refresh();
    } else {
      if (DeleteCommand.editor instanceof ITextEditor) {
        iteEditor = (ITextEditor) DeleteCommand.editor;
      } else {
        final MultiPageEditorPart mpepEditor = (MultiPageEditorPart) DeleteCommand.editor;
        final IEditorPart[] editors = mpepEditor.findEditors(mpepEditor.getEditorInput());
        iteEditor = (ITextEditor) editors[0];
      }
      final IDocumentProvider idp = iteEditor.getDocumentProvider();
      try {
        idp.resetDocument(iteEditor.getEditorInput());
      } catch (final CoreException e) {
        e.printStackTrace();
      }
    }
    Visualization.showViz(Visualization.container);
    MarkerFactory.refreshProjectExp();
  }

  public static void run(final IMarker marker) {
    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        DeleteCommand.marker = marker;
        DeleteCommand.editor = MarkerFactory.getOpenEditorOfMarker(marker);
        if (AlloyUtilities.isExists()) {
          DeleteCommand.candidateToTypeChanging = new ArrayList<IMarker>();
          DeleteCommand.deleteMarker();
          DeleteCommand.refresh();
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
