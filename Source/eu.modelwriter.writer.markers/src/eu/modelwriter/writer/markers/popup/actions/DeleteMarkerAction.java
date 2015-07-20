
package eu.modelwriter.writer.markers.popup.actions;

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

import eu.modelwriter.writer.markers.MarkerActivator;
import eu.modelwriter.writer.markers.internal.MarkerFactory;

public class DeleteMarkerAction implements IEditorActionDelegate {

  public DeleteMarkerAction() {
    super();
  }

  @Override
  public void run(IAction action) {
    try {
      TextSelection selection = MarkerFactory.getTextSelection();
      IFile file = (IFile) MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);

      IMarker beDeleted = MarkerFactory.findMarkerByOffset(file, selection.getOffset());

      if (beDeleted != null) {
        String markerText = (String) beDeleted.getAttribute(IMarker.TEXT);

        beDeleted.delete();

        MessageDialog dialog =
            new MessageDialog(MarkerActivator.getShell(), "Mark will be deleted by this wizard.",
                null, "\"" + markerText + "\" has been seleceted to be unmarked",
                MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();

        MultiPageEditorPart mpepEditor;
        ITextEditor iteEditor;
        if (MarkerActivator.getEditor() instanceof MultiPageEditorPart) {
          mpepEditor = (MultiPageEditorPart) MarkerActivator.getEditor();
          IEditorPart[] editors = mpepEditor.findEditors(mpepEditor.getEditorInput());
          iteEditor = (ITextEditor) editors[0];
        } else
          iteEditor = (ITextEditor) MarkerActivator.getEditor();

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

}
