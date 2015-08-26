package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.wizard.markallinwswizard.MarkAllInWsWizard;

public class MarkAllInWorkspaceHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    ISelection selection = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow()
        .getSelectionService().getSelection();
    IFile file = (IFile) MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);
    if (selection instanceof ITextSelection) {
      ITextSelection textSelection = (ITextSelection) selection;
      if (MarkerFactory.findMarkerWithAbsolutePosition(file, textSelection.getOffset(),
          textSelection.getOffset() + textSelection.getLength()) != null) {

        MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
            null, "In these area, there is already a marker", MessageDialog.WARNING,
            new String[] {"OK"}, 0);
        dialog.open();

        return null;
      } else {
        MarkAllInWsWizard markAllWsWizard = new MarkAllInWsWizard(textSelection, file);
        WizardDialog selectionDialog =
            new WizardDialog(MarkerActivator.getShell(), markAllWsWizard);
        if (selectionDialog.open() == Window.CANCEL) {
          return null;
        }
      }
    }
    return null;
  }
}
