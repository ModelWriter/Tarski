
package eu.modelwriter.marker.action;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

import eu.modelwriter.marker.Activator;
import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.xml.XMLDOMHelper;

public class DeleteMarkerAction implements IEditorActionDelegate {

  public DeleteMarkerAction() {
    super();
  }

  @Override
  public void run(IAction action) {
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

          MarkerFactory.removeAnnotation(beDeleted, textSelection, editor);
          beDeleted.delete();

          MessageDialog dialog =
              new MessageDialog(Activator.getShell(), "Mark will be deleted by this wizard.", null,
                  "\"" + markerText + "\" has been seleceted to be unmarked",
                  MessageDialog.INFORMATION, new String[] {"OK"}, 0);
          dialog.open();
        }
      } else if (selection instanceof ITreeSelection) {
        ITreeSelection treeSelection = (ITreeSelection) selection;
        if (selection != null && editor instanceof EcoreEditor
            && treeSelection.getFirstElement() instanceof ENamedElement
            && ((ENamedElement) treeSelection.getFirstElement()).getName() != null
            && !((ENamedElement) treeSelection.getFirstElement()).getName().isEmpty()) {

          URI uri = EcoreUtil.getURI((ENamedElement) treeSelection.getFirstElement());

          beDeleted = MarkerFactory.findMarkersByUri(file, uri.toString());
          if (beDeleted != null && beDeleted.exists()) {
            updateTargets(beDeleted);
            updateSources(beDeleted);

            beDeleted.delete();
            MessageDialog dialog =
                new MessageDialog(Activator.getShell(), "Mark will be deleted by this wizard", null,
                    "\"" + ((ENamedElement) ((ITreeSelection) selection).getFirstElement())
                        .getName() + "\" has been seleceted to be unmarked",
                MessageDialog.INFORMATION, new String[] {"OK"}, 0);
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

    } catch (CoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setActiveEditor(IAction action, IEditorPart targetEditor) {
    // TODO Auto-generated method stub

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

          IMarker targetMarker = MarkElement.getMarker(targetElement);

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

          IMarker sourceMarker = MarkElement.getMarker(sourceElement);

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
