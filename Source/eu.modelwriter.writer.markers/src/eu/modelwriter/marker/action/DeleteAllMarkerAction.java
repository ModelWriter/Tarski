package eu.modelwriter.marker.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Source;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

import eu.modelwriter.marker.Activator;
import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.internal.Serialization;

public class DeleteAllMarkerAction implements IEditorActionDelegate {

  public DeleteAllMarkerAction() {
    super();
  }

  @Override
  public void run(IAction action) {
    try {
      TextSelection selection = MarkerFactory.getTextSelection();
      IFile file = (IFile) Activator.getEditor().getEditorInput().getAdapter(IFile.class);

      IMarker beDeleted = MarkerFactory.findMarkerByOffset(file, selection.getOffset());

      if (beDeleted != null) {
        String markerId = (String) beDeleted.getAttribute(MarkerFactory.GROUP_ID);
        String markerText = (String) beDeleted.getAttribute(IMarker.TEXT);

        updateTargets(beDeleted);
        updateTargets(beDeleted);

        beDeleted.delete();



        List<IMarker> markers = MarkerFactory.findMarkers(file);

        for (int i = markers.size() - 1; i >= 0; i--) {
          if (markerId.equals(markers.get(i).getAttribute(MarkerFactory.GROUP_ID))) {
            updateTargets(markers.get(i));
            updateTargets(markers.get(i));
            markers.get(i).delete();
          }
        }

        MessageDialog dialog =
            new MessageDialog(Activator.getShell(), "Mark will be deleted by this wizard.", null,
                "\"" + markerText + "\" has been seleceted to be unmarked",
                MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();

        MultiPageEditorPart mpepEditor;
        ITextEditor iteEditor;
        if (Activator.getEditor() instanceof MultiPageEditorPart) {
          mpepEditor = (MultiPageEditorPart) Activator.getEditor();
          IEditorPart[] editors = mpepEditor.findEditors(mpepEditor.getEditorInput());
          iteEditor = (ITextEditor) editors[0];
        } else
          iteEditor = (ITextEditor) Activator.getEditor();

        IDocumentProvider idp = iteEditor.getDocumentProvider();
        idp.resetDocument(iteEditor.getEditorInput());

        // ITextEditor editor = (ITextEditor)
        // MarkerActivator.getEditor();
        // IDocumentProvider idp = editor.getDocumentProvider();
        // idp.resetDocument(editor.getEditorInput());
      }

    } catch (CoreException e) {
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
