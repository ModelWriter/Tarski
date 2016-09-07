package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.alloy.trace.TraceRepo;
import eu.modelwriter.configuration.alloy2emf.AlloyToEMF;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;

public class AlloyExampleToEMFHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    final String alloyFilePath = getFile();
    try {
      if (!alloyFilePath.equals(MarkerPage.settings.get("alloyFile")))
        throw new TraceException("Load the specification first.");

      TraceRepo.get().loadSpec(alloyFilePath);
      AlloyToEMF alloy2emf = new AlloyToEMF(alloyFilePath);
      alloy2emf.start();
    } catch (TraceException e) {
      final MessageDialog warningdialog =
          new MessageDialog(MarkerActivator.getShell(), "Alloy Example To EMF", null,
              e.getMessage(), MessageDialog.WARNING, new String[] {"OK"}, 0);
      if (warningdialog.open() != 0) {
        return null;
      }
    }
    return null;
  }

  public String getFile() {
    String result = null;
    final ISelection selection =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
    if (selection != null && selection instanceof TreeSelection) {
      final TreeSelection treeSelection = (TreeSelection) selection;
      final IFile file = (IFile) treeSelection.getFirstElement();
      result = file.getLocation().makeAbsolute().toOSString();
    }
    return result;
  }
}
