package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.window.Window;

import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.alloy.trace.TraceRepo;
import eu.modelwriter.configuration.synthesis.AutomatedTraceCreator;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;

public class AutomatedTraceCreationHandler extends AbstractHandler {
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final String filePath = AlloyParseUtil.getSelectedFile().getRawLocation().toOSString();
    final AutomatedTraceCreator creator = new AutomatedTraceCreator();
    final ProgressMonitorDialog dialog = new ProgressMonitorDialog(MarkerActivator.getShell());
    try {
      dialog.setCancelable(true);

      if (dialog.open() == Window.CANCEL)
        throw new TraceException("Progress cancelled.");

      if (!filePath.equals(MarkerPage.settings.get("alloyFile")))
        throw new TraceException("Load the specification first.");

      dialog.getProgressMonitor().beginTask(("Automated Trace Creation in progress..."), 3);

      TraceRepo.get().updateSpec(filePath);
      dialog.getProgressMonitor().worked(1);

      creator.automate();
      dialog.getProgressMonitor().worked(2);

      Visualization.showViz();
      dialog.getProgressMonitor().worked(3);
      dialog.close();
      //
      // final MessageDialog warningdialog = new MessageDialog(MarkerActivator.getShell(),
      // "Automated Trace Creation", null, "Automated Trace Creation has been successfully done.",
      // MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      // if (warningdialog.open() != 0) {
      // return null;
      // }
    } catch (final TraceException e) {
      dialog.close();
      final MessageDialog warningdialog =
          new MessageDialog(MarkerActivator.getShell(), "Automated Trace Creation", null,
              e.getMessage(), MessageDialog.WARNING, new String[] {"OK"}, 0);
      if (warningdialog.open() != 0) {
        return null;
      }
    }

    return null;
  }

}
