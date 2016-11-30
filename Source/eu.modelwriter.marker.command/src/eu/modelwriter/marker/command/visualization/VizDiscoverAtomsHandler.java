package eu.modelwriter.marker.command.visualization;

import javax.swing.JOptionPane;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.services.ISourceProviderService;

import edu.mit.csail.sdg.alloy4.Err;
import eu.modelwriter.configuration.alloy.analysis.discovering.Discovering;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider.AnalysisType;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;

public class VizDiscoverAtomsHandler extends AbstractHandler {
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final IWorkbenchWindow activeWorkbenchWindow = HandlerUtil.getActiveWorkbenchWindow(event);
    final ISourceProviderService service =
        activeWorkbenchWindow.getService(ISourceProviderService.class);
    final AnalysisSourceProvider sourceProvider =
        (AnalysisSourceProvider) service.getSourceProvider(AnalysisSourceProvider.ANALYSIS_STATE);
    sourceProvider.setActive(AnalysisType.DISCOVER_ATOM);

    final Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        boolean success;
        try {
          success = Discovering.getInstance().start();
        } catch (final Err e) {
          success = false;
        }
        if (!success) {
          JOptionPane.showMessageDialog(null, "There is not any discovering.", "Discovering Atoms",
              JOptionPane.INFORMATION_MESSAGE);
          sourceProvider.setPassive();
        }
        Visualization.showViz();
      }
    });
    thread.start();
    return true;
  }
}
