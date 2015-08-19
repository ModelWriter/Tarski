package eu.modelwriter.marker.command;

import java.util.UUID;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkElementUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MarkAllHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    ISelection iselection =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
    IFile file = (IFile) MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);

    if (iselection instanceof ITreeSelection) {
      /* Mark action may will be */
    } else if (iselection instanceof ITextSelection) {
      ITextSelection selection = (ITextSelection) iselection;

      if (MarkerFactory.findMarkerWithAbsolutePosition(file, selection.getOffset(),
          selection.getOffset() + selection.getLength()) != null) {

        MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
            null, "In these area, there is already a marker", MessageDialog.WARNING,
            new String[] {"OK"}, 0);
        dialog.open();

        return null;
      } else {
        String content = MarkerFactory.getCurrentEditorContent();
        int index = 0;
        int offset = 0;
        int lenght = selection.getLength();
        String id = UUID.randomUUID().toString();
        String leader_id = UUID.randomUUID().toString();

        if (lenght != 0) {
          while ((offset = content.indexOf(selection.getText(), index)) != -1) {
            TextSelection nextSelection =
                new TextSelection(MarkerFactory.getDocument(), offset, lenght);
            if (MarkerFactory.findMarkerByOffset(file, offset) == null) {
              IMarker mymarker = MarkerFactory.createMarker(file, nextSelection);
              MarkElementUtilities.setGroupId(mymarker, id);
              if (selection.getOffset() == offset) {
                MarkElementUtilities.setLeaderId(mymarker, leader_id);
              }
              AnnotationFactory.addAnnotation(mymarker, MarkerActivator.getEditor(),
                  AnnotationFactory.ANNOTATION_MARKING);
            }
            index = offset + lenght;
          }

          MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
              "Mark Information will be provided by this wizard.", null,
              "\"" + selection.getText() + "\" has been seleceted to be marked",
              MessageDialog.INFORMATION, new String[] {"OK"}, 0);
          dialog.open();
        } else {
          MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
              "Mark Information will be provided by this wizard.", null,
              "Please select a valid information", MessageDialog.INFORMATION, new String[] {"OK"},
              0);
          dialog.open();
        }
      }
    }
    return null;
  }
}
