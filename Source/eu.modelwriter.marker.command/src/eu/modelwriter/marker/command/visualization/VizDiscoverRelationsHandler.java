package eu.modelwriter.marker.command.visualization;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.services.ISourceProviderService;

import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider.ReasoningType;
import eu.modelwriter.configuration.alloy.reasoning.AlloyReasoning;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;

public class VizDiscoverRelationsHandler extends AbstractHandler {
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final IWorkbenchWindow activeWorkbenchWindow = HandlerUtil.getActiveWorkbenchWindow(event);
    final ISourceProviderService service =
        activeWorkbenchWindow.getService(ISourceProviderService.class);
    final AnalysisSourceProvider sourceProvider =
        (AnalysisSourceProvider) service.getSourceProvider(AnalysisSourceProvider.ANALYSIS_STATE);
    sourceProvider.setActive(ReasoningType.DISCOVER_RELATION);

    final Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        final AlloyReasoning alloyReasoning = new AlloyReasoning();
        final boolean reasoning = alloyReasoning.reasoning();
        if (!reasoning) {
          sourceProvider.setPassive();
        }

        Visualization.showViz();
      }
    });
    thread.start();
    return true;
  }
}
