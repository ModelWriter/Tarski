package eu.modelwriter.marker.command;

import java.io.IOException;
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
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkerFactory;

public class DeleteAllHandler extends AbstractHandler {

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

        beDeleted = MarkerFactory.findMarkerByOffset(file, textSelection.getOffset());
        if (beDeleted != null && beDeleted.exists()) {
          String markerText = (String) beDeleted.getAttribute(IMarker.TEXT);
          updateTargets(beDeleted);
          updateSources(beDeleted);

          if (beDeleted.getAttribute(MarkerFactory.GROUP_ID) != null) {
            String markerId = (String) beDeleted.getAttribute(MarkerFactory.GROUP_ID);
            List<IMarker> markers = MarkerFactory.findMarkers(file);

            for (int i = markers.size() - 1; i >= 0; i--) {
              if (markerId.equals(markers.get(i).getAttribute(MarkerFactory.GROUP_ID))) {
                updateTargets(markers.get(i));
                updateTargets(markers.get(i));
                MarkerFactory.removeAnnotation(markers.get(i), editor);
                markers.get(i).delete();
              }
            }

            MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
                "Mark will be deleted by this wizard.", null,
                "\"" + markerText + "\" has been seleceted to be unmarked",
                MessageDialog.INFORMATION, new String[] {"OK"}, 0);
            dialog.open();
          } else {
            MarkerFactory.removeAnnotation(beDeleted, editor);
            beDeleted.delete();
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

    } catch (CoreException e) {
      e.printStackTrace();
    }
    return null;
  }

  public void updateTargets(IMarker marker) {
    try {
      if (marker.getAttribute(MarkElement.getTargetAttributeName()) != null) {
        ArrayList<MarkElement> targetElements = Serialization.getInstance() // güncellenen
                                                                            // marker
                                                                            // ın
                                                                            // targetları
                                                                            // alındı.
            .fromString((String) (marker).getAttribute(MarkElement.getTargetAttributeName()));

        for (MarkElement targetElement : targetElements) {

          IMarker targetMarker = MarkElement.getiMarker(targetElement);

          if (targetMarker.getAttribute(MarkElement.getSourceAttributeName()) != null) {

            ArrayList<MarkElement> sourceElementsofTarget = Serialization.getInstance().fromString(
                (String) (targetMarker).getAttribute(MarkElement.getSourceAttributeName()));

            for (int i = sourceElementsofTarget.size() - 1; i >= 0; i--) {
              if (sourceElementsofTarget.get(i).getId()
                  .equals(marker.getAttribute(IMarker.SOURCE_ID)))
                sourceElementsofTarget.remove(i);
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

  public void updateSources(IMarker marker) {
    try {
      if (marker.getAttribute(MarkElement.getSourceAttributeName()) != null) {
        ArrayList<MarkElement> sourceElements = Serialization.getInstance() // güncellenen
            // marker
            // ın
            // sourceları
            // alındı.
            .fromString((String) (marker).getAttribute(MarkElement.getSourceAttributeName()));

        for (MarkElement sourceElement : sourceElements) {

          IMarker sourceMarker = MarkElement.getiMarker(sourceElement);

          if (sourceMarker.getAttribute(MarkElement.getTargetAttributeName()) != null) {
            ArrayList<MarkElement> targetElementsofSource = Serialization.getInstance().fromString(
                (String) (sourceMarker).getAttribute(MarkElement.getTargetAttributeName()));

            for (int i = targetElementsofSource.size() - 1; i >= 0; i--) {
              if (targetElementsofSource.get(i).getId()
                  .equals(marker.getAttribute(IMarker.SOURCE_ID)))
                targetElementsofSource.remove(i);
            }

            sourceMarker.setAttribute(MarkElement.getTargetAttributeName(),
                Serialization.getInstance().toString(targetElementsofSource));
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
