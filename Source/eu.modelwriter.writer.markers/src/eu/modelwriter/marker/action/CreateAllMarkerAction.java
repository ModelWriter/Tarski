package eu.modelwriter.marker.action;

import java.util.UUID;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

import eu.modelwriter.marker.Activator;
import eu.modelwriter.marker.internal.MarkerFactory;

public class CreateAllMarkerAction implements IEditorActionDelegate {

  public CreateAllMarkerAction() {
    super();
  }

  @Override
  public void setActiveEditor(IAction action, IEditorPart editor) {}

  /*
   * This action creates a new marker for the given IFile
   */
  @Override
  public void run(IAction action) {
    try {
      TextSelection selection = MarkerFactory.getTextSelection();
      IFile file = (IFile) Activator.getEditor().getEditorInput().getAdapter(IFile.class);
      String content = MarkerFactory.getCurrentEditorContent();
      int index = 0;
      int offset = 0;
      int lenght = selection.getLength();
      String id = UUID.randomUUID().toString();
      String leader_id = UUID.randomUUID().toString();
      while ((offset = content.indexOf(selection.getText(), index)) != -1) {
        TextSelection nextSelection = new TextSelection(MarkerFactory.getDocument(), offset, lenght);
        if (MarkerFactory.findMarkerByOffset(file, offset) == null) {
          IMarker mymarker = MarkerFactory.createMarker(file, nextSelection);
          mymarker.setAttribute(MarkerFactory.GROUP_ID, id);
          if (selection.getOffset()==offset){
            mymarker.setAttribute(MarkerFactory.LEADER_ID, leader_id);
          }
          MarkerFactory.addAnnotation(mymarker, nextSelection, Activator.getEditor());
        }
        index = offset + lenght;
      }

      MessageDialog dialog = new MessageDialog(Activator.getShell(),
          "Mark Information will be provided by this wizard.", null,
          "\"" + selection.getText() + "\" has been seleceted to be marked",
          MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();

    } catch (CoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {}

}
