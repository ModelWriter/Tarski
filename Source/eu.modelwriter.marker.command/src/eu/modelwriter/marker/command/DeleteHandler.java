package eu.modelwriter.marker.command;

import java.util.ArrayList;
import java.util.List;

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

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkElementUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.internal.MarkerUpdater;
import eu.modelwriter.marker.ui.internal.wizards.selectionwizard.SelectionWizard;

public class DeleteHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    try {
      ISelection selection =
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

      IFile file = (IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
          .getActiveEditor().getEditorInput().getAdapter(IFile.class);

      IEditorPart editor =
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

      IMarker beDeleted = null;

      if (selection instanceof ITextSelection) {
        TextSelection textSelection = (TextSelection) selection;

        ArrayList<IMarker> markerList = MarkerFactory.findMarkersInSelection(file, textSelection);
        if (markerList != null) {
          if (markerList.size() == 1) {
            beDeleted = markerList.get(0);
          } else if (markerList.size() > 1) {
            SelectionWizard selectionWizard = new SelectionWizard(markerList);
            WizardDialog selectionDialog =
                new WizardDialog(MarkerActivator.getShell(), selectionWizard);
            if (selectionDialog.open() == 1)
              return null;
            beDeleted = selectionWizard.getSelectedMarker();
          }
        }

        if (beDeleted != null && beDeleted.exists()) {

          String markerText = MarkElementUtilities.getMessage(beDeleted);
          if (MarkElementUtilities.getLeaderId(beDeleted) != null) {
            String markerGroupId = MarkElementUtilities.getGroupId(beDeleted);
            List<IMarker> markers = MarkerFactory.findMarkersByGroupId(file, markerGroupId);

            for (int i = markers.size() - 1; i >= 0; i--) {
              MarkerUpdater.updateTargetsToDelete(markers.get(i));
              MarkerUpdater.updateSourcesToDelete(markers.get(i));
              AnnotationFactory.removeAnnotation(markers.get(i), editor);
              markers.get(i).delete();
            }
            MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
                "Mark will be deleted by this wizard.", null,
                "\"" + markerText + "\" has been seleceted to be unmarked",
                MessageDialog.INFORMATION, new String[] {"OK"}, 0);
            dialog.open();
          } else {
            MarkerUpdater.updateTargetsToDelete(beDeleted);
            MarkerUpdater.updateSourcesToDelete(beDeleted);

            AnnotationFactory.removeAnnotation(beDeleted, editor);

            MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
                "Mark will be deleted by this wizard.", null,
                "\"" + markerText + "\" has been seleceted to be unmarked",
                MessageDialog.INFORMATION, new String[] {"OK"}, 0);
            beDeleted.delete();
            dialog.open();
          }
        }
      } else if (selection instanceof ITreeSelection) {
        ITreeSelection treeSelection = (ITreeSelection) selection;
        if (selection != null && editor instanceof EcoreEditor) {
          if (treeSelection.getFirstElement() instanceof ENamedElement
              && ((ENamedElement) treeSelection.getFirstElement()).getName() != null
              && !((ENamedElement) treeSelection.getFirstElement()).getName().isEmpty()) {

            URI uri = EcoreUtil.getURI((ENamedElement) treeSelection.getFirstElement());

            beDeleted = MarkerFactory.findMarkersByUri(file, uri.toString());
            if (beDeleted != null && beDeleted.exists()) {
              MarkerUpdater.updateTargetsToDelete(beDeleted);
              MarkerUpdater.updateSourcesToDelete(beDeleted);

              MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
                  "Mark will be deleted by this wizard", null,
                  "\"" + MarkElementUtilities.getMessage(beDeleted)
                      + "\" has been seleceted to be unmarked",
                  MessageDialog.INFORMATION, new String[] {"OK"}, 0);
              beDeleted.delete();
              dialog.open();
            }
          } else if (!((EObject) treeSelection.getFirstElement() instanceof EModelElement)) {
            URI uri = EcoreUtil.getURI((EObject) treeSelection.getFirstElement());
            beDeleted = MarkerFactory.findMarkersByUri(file, uri.toString());
            if (beDeleted != null && beDeleted.exists()) {
              MarkerUpdater.updateTargetsToDelete(beDeleted);
              MarkerUpdater.updateSourcesToDelete(beDeleted);

              MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
                  "Mark will be deleted by this wizard", null,
                  "\"" + MarkElementUtilities.getMessage(beDeleted)
                      + "\" has been seleceted to be unmarked",
                  MessageDialog.INFORMATION, new String[] {"OK"}, 0);
              beDeleted.delete();
              dialog.open();
            }
          }
        }

        EcoreEditor ecEditor;
        MultiPageEditorPart mpepEditor;
        ITextEditor iteEditor = null;
        if (editor instanceof EcoreEditor) {
          ecEditor = (EcoreEditor) editor;
          ecEditor.getViewer().refresh();
        } else {
          if (editor instanceof ITextEditor) {
            iteEditor = (ITextEditor) editor;
          } else {
            mpepEditor = (MultiPageEditorPart) editor;
            IEditorPart[] editors = mpepEditor.findEditors(mpepEditor.getEditorInput());
            iteEditor = (ITextEditor) editors[0];
          }
          IDocumentProvider idp = iteEditor.getDocumentProvider();
          idp.resetDocument(iteEditor.getEditorInput());
        }
      }

      MarkerFactory.refreshProjectExp();

    } catch (CoreException e) {
      e.printStackTrace();
    }
    return null;
  }
}
