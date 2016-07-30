package eu.modelwriter.marker.command.visualization;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.services.ISourceProviderService;

import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider.AnalysisType;
import eu.modelwriter.configuration.alloy.discovery.AlloyNextSolutionDiscovering;
import eu.modelwriter.configuration.alloy.reasoning.AlloyNextSolutionReasoning;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;

public class VizNextSolutionHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {

    final IWorkbenchWindow activeWorkbenchWindow = HandlerUtil.getActiveWorkbenchWindow(event);
    final ISourceProviderService service =
        activeWorkbenchWindow.getService(ISourceProviderService.class);
    final AnalysisSourceProvider sourceProvider =
        (AnalysisSourceProvider) service.getSourceProvider(AnalysisSourceProvider.STATE);
    sourceProvider.setNext();

    final Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        if (sourceProvider.getAnalysisType() == AnalysisType.DISCOVER_RELATION) {
          AlloyNextSolutionReasoning.getInstance().next();
        } else if (sourceProvider.getAnalysisType() == AnalysisType.DISCOVER_ATOM) {
          AlloyNextSolutionDiscovering.getInstance().next();
        }
        Visualization.showViz();
      }
    });
    thread.start();

    return true;
  }
}
