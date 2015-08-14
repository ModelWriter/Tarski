package eu.modelwriter.marker.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
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
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.MarkerUtilities;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkerFactory;
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
        if (markerList.size() == 1)
          beDeleted = markerList.get(0);
        else if (markerList.size() > 1) {
          SelectionWizard selectionWizard = new SelectionWizard(markerList);
          WizardDialog selectionDialog =
              new WizardDialog(MarkerActivator.getShell(), selectionWizard);
          if (selectionDialog.open() == 1)
            return null;
          beDeleted = selectionWizard.getSelectedMarker();
        }

        if (beDeleted != null && beDeleted.exists()) {

          String markerText = (String) beDeleted.getAttribute(IMarker.TEXT);
          if (beDeleted.getAttribute(MarkerFactory.LEADER_ID) != null) {
            String markerGroupId = (String) beDeleted.getAttribute(MarkerFactory.GROUP_ID);
            List<IMarker> markers = MarkerFactory.findMarkersByGroupId(file, markerGroupId);

            for (int i = markers.size() - 1; i >= 0; i--) {
              updateTargets(markers.get(i));
              updateTargets(markers.get(i));
              MarkerFactory.removeAnnotation(markers.get(i), editor);
              markers.get(i).delete();
            }
            MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
                "Mark will be deleted by this wizard.", null,
                "\"" + markerText + "\" has been seleceted to be unmarked",
                MessageDialog.INFORMATION, new String[] {"OK"}, 0);
            dialog.open();
          } else {
            updateTargets(beDeleted);
            updateSources(beDeleted);

            MarkerFactory.removeAnnotation(beDeleted, editor);

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
              updateTargets(beDeleted);
              updateSources(beDeleted);

              MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
                  "Mark will be deleted by this wizard", null,
                  "\"" + beDeleted.getAttribute(IMarker.TEXT)
                      + "\" has been seleceted to be unmarked",
                  MessageDialog.INFORMATION, new String[] {"OK"}, 0);
              beDeleted.delete();
              dialog.open();
            }
          } else if (!((EObject) treeSelection.getFirstElement() instanceof EModelElement)) {
            URI uri = EcoreUtil.getURI((EObject) treeSelection.getFirstElement());
            beDeleted = MarkerFactory.findMarkersByUri(file, uri.toString());
            if (beDeleted != null && beDeleted.exists()) {
              updateTargets(beDeleted);
              updateSources(beDeleted);

              MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
                  "Mark will be deleted by this wizard", null,
                  "\"" + beDeleted.getAttribute(IMarker.TEXT)
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
    } catch (CoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public void updateTargets(IMarker beDeleted) {
    try {
      if (beDeleted.getAttribute(MarkElement.getTargetAttributeName()) != null) {
        ArrayList<MarkElement> targetElements = Serialization.getInstance() // güncellenen
            // marker
            // ın
            // targetları
            // alındı.
            .fromString((String) (beDeleted).getAttribute(MarkElement.getTargetAttributeName()));

        for (MarkElement targetElement : targetElements) {

          IMarker targetMarker = MarkElement.getiMarker(targetElement);

          if (targetMarker.getAttribute(MarkElement.getSourceAttributeName()) != null) {

            ArrayList<MarkElement> sourceElementsofTarget = Serialization.getInstance().fromString(
                (String) (targetMarker).getAttribute(MarkElement.getSourceAttributeName()));

            for (int i = sourceElementsofTarget.size() - 1; i >= 0; i--) {
              if (sourceElementsofTarget.get(i).getId()
                  .equals(beDeleted.getAttribute(IMarker.SOURCE_ID))) {
                sourceElementsofTarget.remove(i);
              }
            }

            targetMarker.setAttribute(MarkElement.getSourceAttributeName(),
                Serialization.getInstance().toString(sourceElementsofTarget));
          }
        }

        // TargetView.setColumns(null);
      }
    } catch (ClassNotFoundException | CoreException | IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void updateSources(IMarker beDeleted) {
    try {
      if (beDeleted.getAttribute(MarkElement.getSourceAttributeName()) != null) {
        ArrayList<MarkElement> sourceElements = Serialization.getInstance() // güncellenen
            // marker
            // ın
            // sourceları
            // alındı.
            .fromString((String) (beDeleted).getAttribute(MarkElement.getSourceAttributeName()));

        for (MarkElement sourceElement : sourceElements) {

          IMarker sourceMarker = MarkElement.getiMarker(sourceElement);

          if (sourceMarker.getAttribute(MarkElement.getTargetAttributeName()) != null) {
            ArrayList<MarkElement> targetElementsofSource = Serialization.getInstance().fromString(
                (String) (sourceMarker).getAttribute(MarkElement.getTargetAttributeName()));

            for (int i = targetElementsofSource.size() - 1; i >= 0; i--) {
              if (targetElementsofSource.get(i).getId()
                  .equals(beDeleted.getAttribute(IMarker.SOURCE_ID)))
                targetElementsofSource.remove(i);
            }

            sourceMarker.setAttribute(MarkElement.getTargetAttributeName(),
                Serialization.getInstance().toString(targetElementsofSource));

            if (sourceMarker.getType().equals(MarkerFactory.MARKER_MAPPING)
                && targetElementsofSource.size() == 0) {
              IEditorPart part =
                  IDE.openEditor(MarkerActivator.getActiveWorkbenchWindow().getActivePage(),
                      MarkElement.getiMarker(sourceElement), false);
              Map<String, Object> attributes =
                  MarkElement.getiMarker(sourceElement).getAttributes();
              IResource res = MarkElement.getiMarker(sourceElement).getResource();
              MarkerFactory.removeAnnotation(MarkElement.getiMarker(sourceElement), part);
              MarkElement.getiMarker(sourceElement).delete();
              MarkerUtilities.createMarker(res, attributes, MarkerFactory.MARKER_MARKING);
              IMarker newMarker = MarkerFactory.findMarkerBySourceId(res,
                  (String) attributes.get(IMarker.SOURCE_ID));
              MarkerFactory.addAnnotation(newMarker, part, MarkerFactory.ANNOTATION_MARKING);
            }
          }

        }
        // SourceView.setColumns(null);
      }
    } catch (ClassNotFoundException | CoreException | IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
