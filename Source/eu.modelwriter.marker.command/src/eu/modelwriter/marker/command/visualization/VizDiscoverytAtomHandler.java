package eu.modelwriter.marker.command.visualization;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import eu.modelwriter.configuration.alloy.discovery.AlloyDiscovering;
import eu.modelwriter.configuration.alloy.reasoning.AlloyNextSolution;
import eu.modelwriter.configuration.alloy.validation.AlloyValidator;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;

public class VizDiscoverytAtomHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    Thread thread = new Thread(new Runnable() {

      @Override
      public void run() {
        if (AlloyValidator.validate()) {
          if (AlloyValidator.isCanceled) {
            Visualization.showViz();
            return;
          }
          AlloyNextSolution.getInstance().finishNext();
          final AlloyDiscovering alloyDiscovering = new AlloyDiscovering();
          alloyDiscovering.discovering();

          Visualization.showViz();
        }
      }
    });
    thread.start();
    return true;
  }

}
