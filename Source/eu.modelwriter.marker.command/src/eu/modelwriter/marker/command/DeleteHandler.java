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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

import eu.modelwriter.configuration.alloy.discovery.AlloyOtherSolutionDiscovering;
import eu.modelwriter.configuration.alloy.reasoning.AlloyOtherSolutionReasoning;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.configuration.specificreasoning.AlloyOtherSolutionReasoningForAtom;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.selectionwizard.SelectionWizard;

@SuppressWarnings("restriction")
public class DeleteHandler extends AbstractHandler {
  public static String COMMAND_ID = "eu.modelwriter.marker.command.delete";
  IEditorPart editor;
  IFile file;
  ISelection selection;
  IMarker marker;
  private ArrayList<IMarker> candidateToTypeChanging;

  private void checkImpactAndChangedMechanism(final IMarker beDeleted) {
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

  private void deleteFromAlloyXML(final IMarker beDeleted) {
    checkImpactAndChangedMechanism(beDeleted);
    AlloyUtilities.removeMarkerFromRepository(beDeleted);
    if (MarkUtilities.getGroupId(beDeleted) == null
        || MarkUtilities.getLeaderId(beDeleted) != null) {
      AlloyUtilities.removeTypeFromMarker(beDeleted);
      AlloyUtilities.removeRelationOfMarker(beDeleted);
    }
  }

  private void deleteMarker() {
    try {
      if (marker != null && marker.exists()) {
        final MessageDialog warningDialog =
            new MessageDialog(MarkerActivator.getShell(), "Warning!", null,
                "If you delete marker, all relations of this marker has been removed! Do you want to continue to delete marker?",
                MessageDialog.WARNING, new String[] {"YES", "NO"}, 0);
        if (warningDialog.open() != 0) {
          return;
        }

        findCandidateToTypeChangingMarkers(marker);
        final String sourceIdOfSelectedMarker = MarkUtilities.getSourceId(marker);

        for (final IMarker iMarker : candidateToTypeChanging) {
          AnnotationFactory.convertAnnotationType(iMarker, true,
              MarkUtilities.compare(MarkUtilities.getSourceId(iMarker), sourceIdOfSelectedMarker),
              AlloyUtilities.getTotalTargetCount(iMarker));
        }
        final String markerText = MarkUtilities.getText(marker);

        if (MarkUtilities.getLeaderId(marker) != null) {
          final String markerGroupId = MarkUtilities.getGroupId(marker);
          final List<IMarker> markers = MarkerFactory.findMarkersByGroupId(file, markerGroupId);

          for (int i = markers.size() - 1; i >= 0; i--) {
            deleteFromAlloyXML(markers.get(i));
            AnnotationFactory.removeAnnotation(markers.get(i));
            markers.get(i).delete();
          }
        } else {
          deleteFromAlloyXML(marker);
          AnnotationFactory.removeAnnotation(marker);
          marker.delete();
        }
        final MessageDialog dialog =
            new MessageDialog(MarkerActivator.getShell(), "Mark will be deleted by this wizard",
                null, "\"" + markerText + "\" has been selected to be unmarked",
                MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
      }
    } catch (final CoreException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    AlloyOtherSolutionReasoning.getInstance().finish();
    AlloyOtherSolutionDiscovering.getInstance().finish();
    AlloyOtherSolutionReasoningForAtom.getInstance().finish();

    if (AlloyUtilities.isExists()) {
      candidateToTypeChanging = new ArrayList<>();
      file = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
          .getEditorInput().getAdapter(IFile.class);
      selection =
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
      editor =
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
      marker = getMarkerFromEditor();

      deleteMarker();
      refresh();
    } else {
      final MessageDialog infoDialog = new MessageDialog(MarkerActivator.getShell(),
          "System Information", null, "You dont have any registered alloy file to system.",
          MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      infoDialog.open();
    }
    return null;
  }

  /**
   * @param selectedMarker from text
   */
  private void findCandidateToTypeChangingMarkers(final IMarker selectedMarker) {
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

  private IMarker getMarkerFromEditor() {
    IMarker beDeleted = null;
    if (selection != null) {
      if (selection instanceof ITextSelection) {
        final TextSelection textSelection = (TextSelection) selection;

        final ArrayList<IMarker> markerList =
            MarkerFactory.findMarkersInSelection(file, textSelection);
        if (markerList != null) {
          if (markerList.size() == 1) {
            beDeleted = markerList.get(0);
          } else if (markerList.size() > 1) {
            final SelectionWizard selectionWizard = new SelectionWizard(markerList);
            final WizardDialog selectionDialog =
                new WizardDialog(MarkerActivator.getShell(), selectionWizard);
            if (selectionDialog.open() == 1) {
              return null;
            }
            beDeleted = selectionWizard.getSelectedMarker();
          }
        }
      } else if (selection instanceof ITreeSelection) {
        final ITreeSelection treeSelection = (ITreeSelection) selection;
        if (((ITreeSelection) selection).getFirstElement() instanceof IMarker) {
          beDeleted = (IMarker) ((ITreeSelection) selection).getFirstElement();
        } else if (editor instanceof EcoreEditor) {
          if (treeSelection.getFirstElement() instanceof ENamedElement
              && ((ENamedElement) treeSelection.getFirstElement()).getName() != null
              && !((ENamedElement) treeSelection.getFirstElement()).getName().isEmpty()) {

            final URI uri = EcoreUtil.getURI((ENamedElement) treeSelection.getFirstElement());

            beDeleted = MarkerFactory.findMarkersByUri(file, uri.toString());
          } else if (!((EObject) treeSelection.getFirstElement() instanceof EModelElement)) {
            final URI uri = EcoreUtil.getURI((EObject) treeSelection.getFirstElement());
            beDeleted = MarkerFactory.findMarkersByUri(file, uri.toString());
          }
        } else if (editor instanceof CompilationUnitEditor) {
          beDeleted = MarkerFactory.findMarkerByOutlineTreeSelection(treeSelection, file);
        }
      }
    }
    return beDeleted;
  }

  private void refresh() {
    ITextEditor iteEditor = null;
    if (editor instanceof EcoreEditor) {
      final EcoreEditor ecEditor = (EcoreEditor) editor;
      ecEditor.getViewer().refresh();
    } else {
      if (editor instanceof ITextEditor) {
        iteEditor = (ITextEditor) editor;
      } else {
        final MultiPageEditorPart mpepEditor = (MultiPageEditorPart) editor;
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
    MarkerFactory.refreshProjectExp();
    if (Activator.getDefault().getWorkbench().getWorkbenchWindows()[0].getActivePage()
        .findView(Visualization.ID) != null) {
      Visualization.showViz();
    }
  }
}
