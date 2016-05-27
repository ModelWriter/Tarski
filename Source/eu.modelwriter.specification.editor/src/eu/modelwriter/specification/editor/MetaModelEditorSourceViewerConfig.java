package eu.modelwriter.specification.editor;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.Reconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;

import completion.CodeCompletionProcessor;
import completion.FactCompletionProcessor;
import completion.LocateCompletionProcessor;
import reconciling.FactReconcilingStrategy;
import reconciling.SyntacticReconcilingStrategy;
import scanner.CodeScanner;
import scanner.CommentScanner;
import scanner.FactScanner;
import scanner.LocateScanner;
import scanner.MetaModelPartitionScanner;

public class MetaModelEditorSourceViewerConfig extends TextSourceViewerConfiguration {

  private final IEditorPart editor;

  public MetaModelEditorSourceViewerConfig(final IEditorPart editor) {
    this.editor = editor;
  }

  @Override
  public String[] getConfiguredContentTypes(final ISourceViewer sourceViewer) {
    return MetaModelPartitionScanner.PARTITION_TYPES;
  }

  /**
   * Create and set some specifications of content assistant. We define our completion processor
   * as @CodeCompletionProcessor.
   */
  @Override
  public IContentAssistant getContentAssistant(final ISourceViewer sourceViewer) {
    final ContentAssistant assistant = new ContentAssistant();
    assistant.setContentAssistProcessor(new CodeCompletionProcessor(),
        IDocument.DEFAULT_CONTENT_TYPE);
    assistant.setContentAssistProcessor(new FactCompletionProcessor(),
        MetaModelPartitionScanner.META_MODEL_FACT);
    assistant.setContentAssistProcessor(new LocateCompletionProcessor(),
        MetaModelPartitionScanner.META_MODEL_LOCATE);
    assistant.setAutoActivationDelay(500);
    assistant.enableAutoActivation(true);
    assistant.enableAutoInsert(true);
    assistant.setProposalPopupOrientation(IContentAssistant.PROPOSAL_OVERLAY);
    assistant.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_ABOVE);

    return assistant;
  }

  /**
   * We set presentation reconciler and it's damagers and repairers. This requires for syntax
   * highlighting that used partition scanner.
   */
  @Override
  public IPresentationReconciler getPresentationReconciler(final ISourceViewer sourceViewer) {
    final PresentationReconciler reconciler = new PresentationReconciler();

    // Code Partition
    DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new CodeScanner());
    reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
    reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

    // Comment Partition
    dr = new DefaultDamagerRepairer(new CommentScanner());
    reconciler.setDamager(dr, MetaModelPartitionScanner.META_MODEL_COMMENT);
    reconciler.setRepairer(dr, MetaModelPartitionScanner.META_MODEL_COMMENT);

    // Fact Partition
    dr = new DefaultDamagerRepairer(new FactScanner());
    reconciler.setDamager(dr, MetaModelPartitionScanner.META_MODEL_FACT);
    reconciler.setRepairer(dr, MetaModelPartitionScanner.META_MODEL_FACT);

    // Locate Partition
    dr = new DefaultDamagerRepairer(new LocateScanner());
    reconciler.setDamager(dr, MetaModelPartitionScanner.META_MODEL_LOCATE);
    reconciler.setRepairer(dr, MetaModelPartitionScanner.META_MODEL_LOCATE);

    return reconciler;
  }

  /**
   * We set reconciler and it's strategy for reconciling.
   *
   * @MetaModelValidationReconcilingStrategy we set our strategy while editing. It may be both
   *                                         incremental and full.
   */
  @Override
  public IReconciler getReconciler(final ISourceViewer sourceViewer) {
    Reconciler reconciler = null;
    if (sourceViewer != null) {
      reconciler = new Reconciler();
      reconciler.setReconcilingStrategy(new SyntacticReconcilingStrategy(sourceViewer, this.editor),
          IDocument.DEFAULT_CONTENT_TYPE);
      reconciler.setReconcilingStrategy(new FactReconcilingStrategy(sourceViewer, this.editor),
          MetaModelPartitionScanner.META_MODEL_FACT);
      reconciler.setDelay(250);
      reconciler.setProgressMonitor(new NullProgressMonitor());
    }
    return reconciler;
  }
}
