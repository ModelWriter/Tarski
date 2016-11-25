package eu.modelwriter.marker.command.visualization;

import javax.swing.JOptionPane;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.services.ISourceProviderService;

import edu.mit.csail.sdg.alloy4.Err;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider.AnalysisType;
import eu.modelwriter.configuration.alloy.discovery.AlloyOtherSolutionDiscovering;
import eu.modelwriter.configuration.alloy.reasoning.AlloyOtherSolutionReasoning;
import eu.modelwriter.configuration.specificreasoning.AlloyOtherSolutionReasoningForAtom;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;

public class VizNextSolutionHandler extends AbstractHandler {
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final IWorkbenchWindow activeWorkbenchWindow = HandlerUtil.getActiveWorkbenchWindow(event);
    final ISourceProviderService service =
        activeWorkbenchWindow.getService(ISourceProviderService.class);
    final AnalysisSourceProvider sourceProvider =
        (AnalysisSourceProvider) service.getSourceProvider(AnalysisSourceProvider.ANALYSIS_STATE);

    final Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        boolean success = true;
        sourceProvider.setProcessing();
        if (sourceProvider.getAnalysisType() == AnalysisType.REASON_RELATION) {
          try {
            success = AlloyOtherSolutionReasoning.getInstance().next();
          } catch (final Err e) {
            success = false;
          }
        } else if (sourceProvider.getAnalysisType() == AnalysisType.DISCOVER_ATOM) {
          try {
            success = AlloyOtherSolutionDiscovering.getInstance().next();
          } catch (final Err e) {
            success = false;
          }
        } else if (sourceProvider.getAnalysisType() == AnalysisType.REASON_RELATION_FOR_ATOM) {
          try {
            success = AlloyOtherSolutionReasoningForAtom.getInstance().next();
          } catch (final Err e) {
            success = false;
          }
        }
        sourceProvider.setActive(sourceProvider.getAnalysisType());
        if (!success) {
          JOptionPane.showMessageDialog(null, "There is not any other next solution.",
              "Next Solution", JOptionPane.INFORMATION_MESSAGE);
        }
        Visualization.showViz();
      }
    });
    thread.start();
    return true;
  }
}
