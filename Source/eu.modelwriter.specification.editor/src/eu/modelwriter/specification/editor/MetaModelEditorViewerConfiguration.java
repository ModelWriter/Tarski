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

import eu.modelwriter.specification.editor.completion.DefaultCompletionProcessor;
import eu.modelwriter.specification.editor.completion.DiscoverCompletionProcessor;
import eu.modelwriter.specification.editor.completion.FactCompletionProcessor;
import eu.modelwriter.specification.editor.completion.LoadCompletionProcessor;
import eu.modelwriter.specification.editor.completion.LocateCompletionProcessor;
import eu.modelwriter.specification.editor.completion.ReasonCompletionProcessor;
import eu.modelwriter.specification.editor.completion.SigCompletionProcessor;
import eu.modelwriter.specification.editor.completion.TraceCompletionProcessor;
import eu.modelwriter.specification.editor.reconciling.LoadReconcilingStrategy;
import eu.modelwriter.specification.editor.reconciling.ReasonReconcilingStrategy;
import eu.modelwriter.specification.editor.reconciling.SyntacticReconcilingStrategy;
import eu.modelwriter.specification.editor.scanner.CommentScanner;
import eu.modelwriter.specification.editor.scanner.DefaultScanner;
import eu.modelwriter.specification.editor.scanner.DiscoverScanner;
import eu.modelwriter.specification.editor.scanner.FactScanner;
import eu.modelwriter.specification.editor.scanner.LoadScanner;
import eu.modelwriter.specification.editor.scanner.LocateScanner;
import eu.modelwriter.specification.editor.scanner.MetaModelPartitionScanner;
import eu.modelwriter.specification.editor.scanner.ReasonScanner;
import eu.modelwriter.specification.editor.scanner.SigScanner;
import eu.modelwriter.specification.editor.scanner.TraceScanner;

public class MetaModelEditorViewerConfiguration extends TextSourceViewerConfiguration {

  private final IEditorPart editor;

  public MetaModelEditorViewerConfiguration(final IEditorPart editor) {
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
    assistant.setContentAssistProcessor(new DefaultCompletionProcessor(),
        IDocument.DEFAULT_CONTENT_TYPE);
    assistant.setContentAssistProcessor(new ReasonCompletionProcessor(),
        MetaModelPartitionScanner.META_MODEL_REASON);
    assistant.setContentAssistProcessor(new LocateCompletionProcessor(),
        MetaModelPartitionScanner.META_MODEL_LOCATE);
    assistant.setContentAssistProcessor(new LoadCompletionProcessor(),
        MetaModelPartitionScanner.META_MODEL_LOADMODEL);
    assistant.setContentAssistProcessor(new LoadCompletionProcessor(),
        MetaModelPartitionScanner.META_MODEL_LOADINSTANCE);
    assistant.setContentAssistProcessor(new SigCompletionProcessor(),
        MetaModelPartitionScanner.META_MODEL_SIG);
    assistant.setContentAssistProcessor(new FactCompletionProcessor(),
        MetaModelPartitionScanner.META_MODEL_FACT);
    assistant.setContentAssistProcessor(new DiscoverCompletionProcessor(),
        MetaModelPartitionScanner.META_MODEL_DISCOVER);
    assistant.setContentAssistProcessor(new TraceCompletionProcessor(),
        MetaModelPartitionScanner.META_MODEL_TRACE);
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

    // Default Partition
    DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new DefaultScanner());
    reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
    reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

    // Comment Partition
    dr = new DefaultDamagerRepairer(new CommentScanner());
    reconciler.setDamager(dr, MetaModelPartitionScanner.META_MODEL_COMMENT);
    reconciler.setRepairer(dr, MetaModelPartitionScanner.META_MODEL_COMMENT);

    // Reason Partition
    dr = new DefaultDamagerRepairer(new ReasonScanner());
    reconciler.setDamager(dr, MetaModelPartitionScanner.META_MODEL_REASON);
    reconciler.setRepairer(dr, MetaModelPartitionScanner.META_MODEL_REASON);

    // Locate Partition
    dr = new DefaultDamagerRepairer(new LocateScanner());
    reconciler.setDamager(dr, MetaModelPartitionScanner.META_MODEL_LOCATE);
    reconciler.setRepairer(dr, MetaModelPartitionScanner.META_MODEL_LOCATE);

    // Trace Partition
    dr = new DefaultDamagerRepairer(new TraceScanner());
    reconciler.setDamager(dr, MetaModelPartitionScanner.META_MODEL_TRACE);
    reconciler.setRepairer(dr, MetaModelPartitionScanner.META_MODEL_TRACE);

    // LoadModel Partition
    dr = new DefaultDamagerRepairer(new LoadScanner());
    reconciler.setDamager(dr, MetaModelPartitionScanner.META_MODEL_LOADMODEL);
    reconciler.setRepairer(dr, MetaModelPartitionScanner.META_MODEL_LOADMODEL);

    // LoadInstance Partition
    dr = new DefaultDamagerRepairer(new LoadScanner());
    reconciler.setDamager(dr, MetaModelPartitionScanner.META_MODEL_LOADINSTANCE);
    reconciler.setRepairer(dr, MetaModelPartitionScanner.META_MODEL_LOADINSTANCE);

    // Discover Partition
    dr = new DefaultDamagerRepairer(new DiscoverScanner());
    reconciler.setDamager(dr, MetaModelPartitionScanner.META_MODEL_DISCOVER);
    reconciler.setRepairer(dr, MetaModelPartitionScanner.META_MODEL_DISCOVER);

    // Sig Partition
    dr = new DefaultDamagerRepairer(new SigScanner());
    reconciler.setDamager(dr, MetaModelPartitionScanner.META_MODEL_SIG);
    reconciler.setRepairer(dr, MetaModelPartitionScanner.META_MODEL_SIG);

    // Fact Partition
    dr = new DefaultDamagerRepairer(new FactScanner());
    reconciler.setDamager(dr, MetaModelPartitionScanner.META_MODEL_FACT);
    reconciler.setRepairer(dr, MetaModelPartitionScanner.META_MODEL_FACT);

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
      reconciler.setReconcilingStrategy(new SyntacticReconcilingStrategy(sourceViewer, this.editor),
          MetaModelPartitionScanner.META_MODEL_SIG);
      reconciler.setReconcilingStrategy(new SyntacticReconcilingStrategy(sourceViewer, this.editor),
          MetaModelPartitionScanner.META_MODEL_FACT);
      reconciler.setReconcilingStrategy(new ReasonReconcilingStrategy(sourceViewer, this.editor),
          MetaModelPartitionScanner.META_MODEL_REASON);
      reconciler.setReconcilingStrategy(new LoadReconcilingStrategy(sourceViewer, this.editor),
          MetaModelPartitionScanner.META_MODEL_LOADMODEL);
      reconciler.setReconcilingStrategy(new LoadReconcilingStrategy(sourceViewer, this.editor),
          MetaModelPartitionScanner.META_MODEL_LOADINSTANCE);
      reconciler.setDelay(250);
      reconciler.setProgressMonitor(new NullProgressMonitor());
    }
    return reconciler;
  }
}
