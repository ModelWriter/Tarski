package eu.modelwriter.marker.command.visualization;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.services.ISourceProviderService;

import eu.modelwriter.configuration.alloy.discovery.AlloyDiscovering;
import eu.modelwriter.configuration.alloy.reasoning.AlloyNextSolution;
import eu.modelwriter.configuration.alloy.validation.AlloyValidator;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;

public class VizDiscoverytAtomHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {

    final IWorkbenchWindow activeWorkbenchWindow = HandlerUtil.getActiveWorkbenchWindow(event);
    final ISourceProviderService service =
        activeWorkbenchWindow.getService(ISourceProviderService.class);
    final AnalysisSourceProvider sourceProvider =
        (AnalysisSourceProvider) service.getSourceProvider(AnalysisSourceProvider.STATE);
    sourceProvider.setAnalysis();

    final Thread thread = new Thread(new Runnable() {
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
