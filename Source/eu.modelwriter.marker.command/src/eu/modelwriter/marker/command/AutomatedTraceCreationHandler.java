package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.alloy.trace.Traces;
import eu.modelwriter.configuration.synthesis.AutomatedTraceCreator;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;

public class AutomatedTraceCreationHandler extends AbstractHandler {
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    // Check if specification is loaded
    if (MarkerPage.settings.get("alloyFile") == null) {
      new MessageDialog(MarkerActivator.getShell(), "Automated Trace Creation", null,
          "Load the specification first.", MessageDialog.WARNING, new String[] {"OK"}, 0).open();
    } else {
      try {
        Traces.getRepo().load(MarkerPage.settings.get("alloyFile"));
        AutomatedTraceCreator creator = new AutomatedTraceCreator();
        creator.setUser(true);
        creator.schedule();
        creator.addJobChangeListener(new JobChangeAdapter() {
          @Override
          public void done(IJobChangeEvent event) {
            if (event.getResult() == Status.OK_STATUS) {
              Display.getDefault().asyncExec(new Runnable() {

                @Override
                public void run() {
                  Visualization.showViz();
                }
              });
            }
          }
        });
      } catch (TraceException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

}
