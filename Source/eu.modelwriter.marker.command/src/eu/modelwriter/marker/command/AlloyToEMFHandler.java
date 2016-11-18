package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.alloy.trace.TraceManager;
import eu.modelwriter.configuration.alloy2emf.AlloyToEMF;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;

public class AlloyToEMFHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final String alloyFilePath = MarkerPage.settings.get("alloyFile");
    try {
      TraceManager.get().loadSpec(alloyFilePath);
      final AlloyToEMF alloy2emf = new AlloyToEMF(alloyFilePath);
      alloy2emf.start();
      Display.getDefault().syncExec(new Runnable() {

        @Override
        public void run() {
          Visualization.showViz();
        }
      });
    } catch (final TraceException e) {
      final MessageDialog warningdialog = new MessageDialog(MarkerActivator.getShell(),
          "Alloy To EMF", null, e.getMessage(), MessageDialog.WARNING, new String[] {"OK"}, 0);
      if (warningdialog.open() != 0) {
        return null;
      }
    }
    return null;
  }
}
