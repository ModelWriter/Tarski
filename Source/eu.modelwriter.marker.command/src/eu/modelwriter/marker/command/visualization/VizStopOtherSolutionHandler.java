package eu.modelwriter.marker.command.visualization;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.services.ISourceProviderService;

import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider.AnalysisType;
import eu.modelwriter.configuration.alloy.discovery.AlloyOtherSolutionDiscovering;
import eu.modelwriter.configuration.alloy.reasoning.AlloyOtherSolutionReasoning;
import eu.modelwriter.configuration.alloy.validation.AlloyValidator;
import eu.modelwriter.configuration.specificreasoning.AlloyOtherSolutionReasoningForAtom;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;

public class VizStopOtherSolutionHandler extends AbstractHandler {
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final IWorkbenchWindow activeWorkbenchWindow = HandlerUtil.getActiveWorkbenchWindow(event);
    final ISourceProviderService service =
        activeWorkbenchWindow.getService(ISourceProviderService.class);
    final AnalysisSourceProvider sourceProvider =
        (AnalysisSourceProvider) service.getSourceProvider(AnalysisSourceProvider.ANALYSIS_STATE);
    sourceProvider.setPassive();

    final Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        if (sourceProvider.getAnalysisType() == AnalysisType.REASON_RELATION) {
          AlloyOtherSolutionReasoning.getInstance().finish();
        } else if (sourceProvider.getAnalysisType() == AnalysisType.DISCOVER_ATOM) {
          AlloyOtherSolutionDiscovering.getInstance().finish();
        } else if (sourceProvider.getAnalysisType() == AnalysisType.REASON_RELATION_FOR_ATOM) {
          AlloyOtherSolutionReasoningForAtom.getInstance().finish();
        }

        AlloyValidator.isCanceled = true;
        Visualization.showViz();
      }
    });
    thread.start();
    return true;
  }
}
