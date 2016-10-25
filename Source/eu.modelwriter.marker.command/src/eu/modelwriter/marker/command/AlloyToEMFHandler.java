package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;

import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.alloy.trace.TraceManager;
import eu.modelwriter.configuration.alloy2emf.AlloyToEMF;
import eu.modelwriter.marker.MarkerActivator;

public class AlloyToEMFHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    final String alloyFilePath = AlloyParseUtil.getSelectedFile().getRawLocation().toString();
    try {
      TraceManager.get().loadSpec(alloyFilePath);
      AlloyToEMF alloy2emf = new AlloyToEMF(alloyFilePath);
      alloy2emf.start();
    } catch (TraceException e) {
      final MessageDialog warningdialog = new MessageDialog(MarkerActivator.getShell(),
          "Alloy To EMF", null, e.getMessage(), MessageDialog.WARNING, new String[] {"OK"}, 0);
      if (warningdialog.open() != 0) {
        return null;
      }
    }
    return null;
  }
}
