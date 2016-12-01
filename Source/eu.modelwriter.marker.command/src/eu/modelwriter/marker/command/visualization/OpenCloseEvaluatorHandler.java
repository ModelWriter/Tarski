package eu.modelwriter.marker.command.visualization;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import eu.modelwriter.configuration.alloy.analysis.StaticAlloyAnalysisManager;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;

public class OpenCloseEvaluatorHandler extends AbstractHandler {
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        if (StaticAlloyAnalysisManager.isEvaluatorOpen()) {
          Visualization.evaluatorOpen = false;
          StaticAlloyAnalysisManager.closeEvaluator();
        } else {
          Visualization.evaluatorOpen = true;
          StaticAlloyAnalysisManager.openEvaluator();
        }
        Visualization.showViz();
      }
    });
    thread.start();
    return true;
  }
}
