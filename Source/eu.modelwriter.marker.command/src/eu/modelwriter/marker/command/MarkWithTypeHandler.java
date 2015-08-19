package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerWizard;

public class MarkWithTypeHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {

    if (MarkerPage.settings.get("alloyFile") == null) {
      MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Type Information", null,
          "You dont have any marker type registered to system! \n"
              + "Please parse an alloy file first",
          MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();
      return null;
    }

    ISelection selection = MarkerFactory.getSelection();
    IFile file = (IFile) MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);
    ITextSelection textSelection = (ITextSelection) selection;
    if (selection instanceof ITextSelection && MarkerFactory.findMarkerWithAbsolutePosition(file,
        textSelection.getOffset(), textSelection.getOffset() + textSelection.getLength()) != null) {
      MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
          "In these area, there is already a marker", MessageDialog.WARNING, new String[] {"OK"},
          0);
      dialog.open();
      return null;
    }

    MarkerWizard markerWizard = new MarkerWizard(selection, file);

    WizardDialog dialog = new WizardDialog(MarkerActivator.getShell(), markerWizard);

    if (dialog.open() == org.eclipse.jface.window.Window.OK) {
      System.out.println("Ok pressed");
    } else {
      System.out.println("Cancel pressed");
    }

    return null;
  }
}
