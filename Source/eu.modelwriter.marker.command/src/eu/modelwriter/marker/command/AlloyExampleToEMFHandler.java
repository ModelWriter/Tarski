package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;

import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.alloy.trace.TraceRepo;
import eu.modelwriter.configuration.synthesis.AlloyToEMF;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;

public class AlloyExampleToEMFHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    final String alloyFilePath = MarkerPage.settings.get("alloyFile");
    AlloyToEMF alloy2emf = new AlloyToEMF(alloyFilePath);
    try {
      TraceRepo.get().loadSpec(alloyFilePath);
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

}
