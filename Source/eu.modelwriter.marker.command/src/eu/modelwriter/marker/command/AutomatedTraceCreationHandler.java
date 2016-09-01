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
import eu.modelwriter.configuration.synthesis.AutomatedTraceCreator;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;

public class AutomatedTraceCreationHandler extends AbstractHandler {
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final String filePath = MarkerPage.settings.get("alloyFile");
    final AutomatedTraceCreator creator = new AutomatedTraceCreator();
    try {
      TraceRepo.get().updateSpec(filePath);
      creator.automate();
      Visualization.showViz();
      final MessageDialog warningdialog = new MessageDialog(MarkerActivator.getShell(),
          "Automated Trace Creation", null, "Automated Trace Creation has been successfully done.",
          MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      if (warningdialog.open() != 0) {
        return null;
      }
    } catch (final TraceException e) {
      final MessageDialog warningdialog =
          new MessageDialog(MarkerActivator.getShell(), "Automated Trace Creation", null,
              e.getMessage(), MessageDialog.WARNING, new String[] {"OK"}, 0);
      if (warningdialog.open() != 0) {
        return null;
      }
    }

    return null;
  }

  // unused
  public IFile getFile() {
    IFile file = null;
    final ISelection selection =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
    if (selection != null && selection instanceof TreeSelection) {
      final TreeSelection treeSelection = (TreeSelection) selection;
      file = (IFile) treeSelection.getFirstElement();
    }
    return file;
  }
}
