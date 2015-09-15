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

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.internal.MarkerUpdater;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MappingWizard;
import eu.modelwriter.marker.ui.internal.wizards.selectionwizard.SelectionWizard;

public class DeleteAllHandler extends AbstractHandler {
  IEditorPart editor;
  IFile file;
  ISelection selection;
  private ArrayList<IMarker> candidateToTypeChanging;

  private void deleteFromAlloyXML(IMarker beDeleted) {
    if (AlloyUtilities.isExists()) {
      AlloyUtilities.removeMarker(beDeleted);
      AlloyUtilities.removeRelationOfMarker(beDeleted);
    }
  }

  private void deleteMarkers() {
    MessageDialog warningDialog = new MessageDialog(MarkerActivator.getShell(), "Warning!", null,
        "If you delete markers, all relations of these markers has been removed! Do you want to continue to delete markers?",
        MessageDialog.WARNING, new String[] {"YES", "NO"}, 0);
    if (warningDialog.open() == 1) {
      return;
    }

    this.editor =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    this.file = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .getActiveEditor().getEditorInput().getAdapter(IFile.class);
    this.selection =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

    try {
      IMarker beDeleted = this.getMarker();
      if ((beDeleted != null) && beDeleted.exists()) {
        this.findCandidateToTypeChangingMarkers(beDeleted);
        for (IMarker iMarker : this.candidateToTypeChanging) {
          MappingWizard.convertAnnotationType(iMarker, true,
              MarkUtilities.compare(iMarker, beDeleted));
        }
        String markerText = MarkUtilities.getMessage(beDeleted);

        if (MarkUtilities.getGroupId(beDeleted) != null) {
          String markerGroupId = MarkUtilities.getGroupId(beDeleted);
          List<IMarker> markers = MarkerFactory.findMarkersByGroupId(this.file, markerGroupId);

          for (int i = markers.size() - 1; i >= 0; i--) {
            this.deleteFromAlloyXML(markers.get(i));
            MarkerUpdater.updateTargetsToAllDelete(markers.get(i));
            MarkerUpdater.updateSourcesToAllDelete(markers.get(i));
            AnnotationFactory.removeAnnotation(markers.get(i), this.editor);
            markers.get(i).delete();
          }
        } else {
          this.deleteFromAlloyXML(beDeleted);
          MarkerUpdater.updateTargetsToDelete(beDeleted);
          MarkerUpdater.updateSourcesToDelete(beDeleted);
          AnnotationFactory.removeAnnotation(beDeleted, this.editor);
          beDeleted.delete();
        }
        MessageDialog dialog =
            new MessageDialog(MarkerActivator.getShell(), "Mark will be deleted by this wizard",
                null, "\"" + markerText + "\" has been selected to be unmarked",
                MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
      }

    } catch (CoreException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    this.candidateToTypeChanging = new ArrayList<IMarker>();
    this.deleteMarkers();
    this.refresh();
    return null;
  }

  /**
   * @param selectedMarker from text
   */
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

  private IMarker getMarker() {
    IMarker beDeleted = null;
    if (this.selection instanceof ITextSelection) {
      TextSelection textSelection = (TextSelection) this.selection;

      ArrayList<IMarker> markerList =
          MarkerFactory.findMarkersInSelection(this.file, textSelection);
      if (markerList != null) {
        if (markerList.size() == 1) {
          beDeleted = markerList.get(0);
        } else if (markerList.size() > 1) {
          SelectionWizard selectionWizard = new SelectionWizard(markerList);
          WizardDialog selectionDialog =
              new WizardDialog(MarkerActivator.getShell(), selectionWizard);
          if (selectionDialog.open() == 1) {
            return null;
          }
          beDeleted = selectionWizard.getSelectedMarker();
        }
      }
    } else if (this.selection instanceof ITreeSelection) {
      ITreeSelection treeSelection = (ITreeSelection) this.selection;
      if ((this.selection != null) && (this.editor instanceof EcoreEditor)) {
        if ((treeSelection.getFirstElement() instanceof ENamedElement)
            && (((ENamedElement) treeSelection.getFirstElement()).getName() != null)
            && !((ENamedElement) treeSelection.getFirstElement()).getName().isEmpty()) {

          URI uri = EcoreUtil.getURI((ENamedElement) treeSelection.getFirstElement());

          beDeleted = MarkerFactory.findMarkersByUri(this.file, uri.toString());
        } else if (!((EObject) treeSelection.getFirstElement() instanceof EModelElement)) {
          URI uri = EcoreUtil.getURI((EObject) treeSelection.getFirstElement());
          beDeleted = MarkerFactory.findMarkersByUri(this.file, uri.toString());
        }
      }
    }
    return beDeleted;
  }

  private void refresh() {
    ITextEditor iteEditor = null;
    if (this.editor instanceof EcoreEditor) {
      EcoreEditor ecEditor = (EcoreEditor) this.editor;
      ecEditor.getViewer().refresh();
    } else {
      if (this.editor instanceof ITextEditor) {
        iteEditor = (ITextEditor) this.editor;
      } else {
        MultiPageEditorPart mpepEditor = (MultiPageEditorPart) this.editor;
        IEditorPart[] editors = mpepEditor.findEditors(mpepEditor.getEditorInput());
        iteEditor = (ITextEditor) editors[0];
      }
      IDocumentProvider idp = iteEditor.getDocumentProvider();
      try {
        idp.resetDocument(iteEditor.getEditorInput());
      } catch (CoreException e) {
        e.printStackTrace();
      }
    }
    MarkerFactory.refreshProjectExp();

  }
}
