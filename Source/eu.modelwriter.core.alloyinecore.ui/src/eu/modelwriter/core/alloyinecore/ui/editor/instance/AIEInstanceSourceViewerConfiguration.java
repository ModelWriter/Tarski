package eu.modelwriter.core.alloyinecore.ui.editor.instance;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.Reconciler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.texteditor.ITextEditor;

import eu.modelwriter.core.alloyinecore.ui.editor.AIESourceViewerConfiguration;
import eu.modelwriter.core.alloyinecore.ui.editor.color.IColorManager;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.reconciling.AIEInstanceSyntacticReconcilingStrategy;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.scanner.AIEInstanceCodeScanner;
import eu.modelwriter.core.alloyinecore.ui.editor.partition.IAIEPartitions;
import eu.modelwriter.core.alloyinecore.ui.editor.scanner.AIECodeScanner;

public class AIEInstanceSourceViewerConfiguration extends AIESourceViewerConfiguration {
  private AIEInstanceCodeScanner fCodeScanner;

  /**
   * Creates a new AlloyInEcore source viewer configuration for viewers in the given editor using
   * the given the color manager and the specified document partitioning.
   *
   * @param colorManager the color manager
   * @param editor the editor in which the configured viewer(s) will reside, or <code>null</code> if
   *        none
   * @param partitioning the document partitioning for this configuration, or <code>null</code> for
   *        the default partitioning
   */
  public AIEInstanceSourceViewerConfiguration(final IColorManager colorManager,
      final ITextEditor editor, final String partitioning) {
    super(colorManager, editor, partitioning);
  }

  /**
   * Initializes the scanners.
   */
  @Override
  protected void initializeScanners() {
    fCodeScanner = new AIEInstanceCodeScanner(getColorManager());
  }

  @Override
  protected AIECodeScanner getCodeScanner() {
    return fCodeScanner;
  }

  /*
   * @see SourceViewerConfiguration#getReconciler(ISourceViewer)
   */
  @Override
  public IReconciler getReconciler(final ISourceViewer sourceViewer) {
    final ITextEditor editor = getEditor();
    if (editor != null && editor.isEditable()) {
      final Reconciler reconciler = new Reconciler();
      final AIEInstanceSyntacticReconcilingStrategy strategy =
          new AIEInstanceSyntacticReconcilingStrategy(sourceViewer, editor);
      for (final String partition : IAIEPartitions.ALL_PARTITIONS) {
        reconciler.setReconcilingStrategy(strategy, partition);
      }
      reconciler.setDocumentPartitioning(IAIEPartitions.AIE_PARTITIONING);
      reconciler.setDelay(500);
      reconciler.setProgressMonitor(new NullProgressMonitor());
      return reconciler;
    }
    return null;
  }
}
