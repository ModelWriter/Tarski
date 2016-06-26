package eu.modelwriter.traceability.validation.editor.base;

import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

import eu.modelwriter.traceability.validation.editor.base.color.ColorManager;
import eu.modelwriter.traceability.validation.editor.base.completion.DefaultCompletionProcessor;
import eu.modelwriter.traceability.validation.editor.base.scanners.CommentScanner;
import eu.modelwriter.traceability.validation.editor.base.scanners.ModelScanner;
import eu.modelwriter.traceability.validation.editor.base.scanners.SentencesScanner;
import eu.modelwriter.traceability.validation.editor.base.scanners.ValidationPartitionScanner;

public class ValidationConfiguration extends SourceViewerConfiguration {

  private final ColorManager colorManager;

  public ValidationConfiguration(final ColorManager colorManager) {
    this.colorManager = colorManager;
  }

  @Override
  public IAutoEditStrategy[] getAutoEditStrategies(final ISourceViewer sourceViewer,
      final String contentType) {
    final IAutoEditStrategy strategy = new ValidationAutoEditStrategy();
    return new IAutoEditStrategy[] {strategy};
  }

  @Override
  public String[] getConfiguredContentTypes(final ISourceViewer sourceViewer) {
    return ValidationPartitionScanner.PARTITION_TYPES;
  }

  @Override
  public IContentAssistant getContentAssistant(final ISourceViewer sourceViewer) {
    final ContentAssistant assistant = new ContentAssistant();
    assistant.setContentAssistProcessor(new DefaultCompletionProcessor(),
        IDocument.DEFAULT_CONTENT_TYPE);
    assistant.setAutoActivationDelay(500);
    assistant.enableAutoActivation(true);
    assistant.enableAutoInsert(true);
    assistant.setProposalPopupOrientation(IContentAssistant.PROPOSAL_OVERLAY);
    assistant.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_ABOVE);

    return assistant;
  }

  @Override
  public IPresentationReconciler getPresentationReconciler(final ISourceViewer sourceViewer) {
    final PresentationReconciler reconciler = new PresentationReconciler();

    // VALIDATION_MODEL PARTITION
    DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new ModelScanner(this.colorManager));
    reconciler.setDamager(dr, ValidationPartitionScanner.VALIDATION_MODEL);
    reconciler.setRepairer(dr, ValidationPartitionScanner.VALIDATION_MODEL);

    // VALIDATION_SENTENCES PARTITION
    dr = new DefaultDamagerRepairer(new SentencesScanner(this.colorManager));
    reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
    reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

    // VALIDATION_COMMENT PARTITION
    dr = new DefaultDamagerRepairer(new CommentScanner(this.colorManager));
    reconciler.setDamager(dr, ValidationPartitionScanner.VALIDATION_COMMENT);
    reconciler.setRepairer(dr, ValidationPartitionScanner.VALIDATION_COMMENT);

    return reconciler;
  }
}
