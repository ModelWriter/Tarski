package eu.modelwriter.marker.ui.internal.wizards.markallwizard;

import java.util.ArrayList;
import java.util.UUID;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.wizard.Wizard;

import eu.modelwriter.marker.Activator;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MarkAllWizard extends Wizard {

  public MarkAllPage page;
  public static ArrayList<IFile> checkedFiles;
  private ITextSelection selection;

  public MarkAllWizard(ITextSelection selection) {
    super();
    checkedFiles = new ArrayList<IFile>();
    this.selection = selection;
    setNeedsProgressMonitor(true);
  }

  @Override
  public String getWindowTitle() {

    return "Mark All Markers";
  }

  @Override
  public void addPages() {
    page = new MarkAllPage();
    super.addPages();
    this.addPage(page);
  }

  @Override
  public boolean performFinish() {
    try {
      for (IFile iFile : checkedFiles) {
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
            if (MarkerFactory.findMarkerByOffset(iFile, offset) == null) {
              IMarker mymarker = MarkerFactory.createMarker(iFile, nextSelection);
              mymarker.setAttribute(MarkerFactory.GROUP_ID, id);
              if (selection.getOffset() == offset) {
                mymarker.setAttribute(MarkerFactory.LEADER_ID, leader_id);
              }
              MarkerFactory.addAnnotation(mymarker, Activator.getEditor(),
                  MarkerFactory.ANNOTATION_MARKING);
            }
            index = offset + lenght;
          }

          MessageDialog dialog = new MessageDialog(Activator.getShell(),
              "Mark Information will be provided by this wizard.", null,
              "\"" + selection.getText() + "\" has been seleceted to be marked",
              MessageDialog.INFORMATION, new String[] {"OK"}, 0);
          dialog.open();
        } else {
          MessageDialog dialog = new MessageDialog(Activator.getShell(),
              "Mark Information will be provided by this wizard.", null,
              "Please select a valid information", MessageDialog.INFORMATION, new String[] {"OK"},
              0);
          dialog.open();
        }
        return true;
      }
    } catch (CoreException e) {
      e.printStackTrace();
    }

    return false;
  }

}
