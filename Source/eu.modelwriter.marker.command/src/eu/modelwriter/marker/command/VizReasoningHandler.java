package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import eu.modelwriter.configuration.alloy.reasoning.AlloyReasoning;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;

public class VizReasoningHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    Thread thread = new Thread(new Runnable() {

      @Override
      public void run() {
        AlloyReasoning alloyReasoning = new AlloyReasoning();
        alloyReasoning.reasoning();
        Visualization.showViz();
      }
    });
    thread.start();
    return true;
  }

}
