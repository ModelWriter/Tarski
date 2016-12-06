package eu.modelwriter.marker.command.visualization;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import eu.modelwriter.configuration.alloy.analysis.StaticAlloyAnalysisManager;

public class AnalysisFilterHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        if (StaticAlloyAnalysisManager.isAnalysisFilterOpen()) {
          StaticAlloyAnalysisManager.closeAnalysisFilter();
        } else {
          StaticAlloyAnalysisManager.openAnalysisFilter();
        }
      }
    });
    thread.start();
    return true;
  }
}
