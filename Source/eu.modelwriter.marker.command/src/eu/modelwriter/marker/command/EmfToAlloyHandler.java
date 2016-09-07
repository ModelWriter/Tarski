package eu.modelwriter.marker.command;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.configuration.emf2alloy.EMFToAlloy;
import eu.modelwriter.marker.MarkerActivator;

public class EmfToAlloyHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    try {
      IFile file = getFile();
      if (file != null) {
        EMFToAlloy emfToAlloy = new EMFToAlloy(file);
        emfToAlloy.start();
      }
    } catch (IOException e) {
      final MessageDialog warningdialog =
          new MessageDialog(MarkerActivator.getShell(), "Alloy Example To EMF", null,
              e.getMessage(), MessageDialog.WARNING, new String[] {"OK"}, 0);
      if (warningdialog.open() != 0) {
        return null;
      }
      e.printStackTrace();
    }


    return null;
  }

  public IFile getFile() {
    final ISelection selection =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
    if (selection != null && selection instanceof TreeSelection) {
      final TreeSelection treeSelection = (TreeSelection) selection;
      final IFile file = (IFile) treeSelection.getFirstElement();
      return file;
    }
    return null;
  }
}
