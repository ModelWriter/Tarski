package eu.modelwriter.traceability.validation.editor.base;

import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class ValidationConfiguration extends SourceViewerConfiguration {
  // private XMLDoubleClickStrategy doubleClickStrategy;
  private final ColorManager colorManager;

  public ValidationConfiguration(final ColorManager colorManager) {
    this.colorManager = colorManager;
  }

  @Override
  public String[] getConfiguredContentTypes(final ISourceViewer sourceViewer) {
    return ValidationPartitionScanner.PARTITION_TYPES;
  }

  // @Override
  // public ITextDoubleClickStrategy getDoubleClickStrategy(final ISourceViewer sourceViewer,
  // final String contentType) {
  // if (this.doubleClickStrategy == null) {
  // this.doubleClickStrategy = new XMLDoubleClickStrategy();
  // }
  // return this.doubleClickStrategy;
  // }

  @Override
  public IPresentationReconciler getPresentationReconciler(final ISourceViewer sourceViewer) {
    final PresentationReconciler reconciler = new PresentationReconciler();

    // VALIDATION_MODEL PARTITION
    DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new ModelScanner(this.colorManager));
    reconciler.setDamager(dr, ValidationPartitionScanner.VALIDATION_MODEL);
    reconciler.setRepairer(dr, ValidationPartitionScanner.VALIDATION_MODEL);

    // VALIDATION_SENTENCES PARTITION
    dr = new DefaultDamagerRepairer(new SentencesScanner(this.colorManager));
    reconciler.setDamager(dr, ValidationPartitionScanner.VALIDATION_SENTENCES);
    reconciler.setRepairer(dr, ValidationPartitionScanner.VALIDATION_SENTENCES);

    // VALIDATION_COMMENT PARTITION
    dr = new DefaultDamagerRepairer(new CommentScanner(this.colorManager));
    reconciler.setDamager(dr, ValidationPartitionScanner.VALIDATION_COMMENT);
    reconciler.setRepairer(dr, ValidationPartitionScanner.VALIDATION_COMMENT);

    return reconciler;
  }
}
