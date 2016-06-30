package eu.modelwriter.marker.command.visualization;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import eu.modelwriter.configuration.alloy.reasoning.AlloyNextSolution;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;

public class VizNextSolutionHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    // TODO Discovery atom için next solution olunca aktif et

    Thread thread = new Thread(new Runnable() {

      @Override
      public void run() {
        AlloyNextSolution.getInstance().next();
        Visualization.showViz();
      }
    });
    thread.start();
    return true;
  }

}