package eu.modelwriter.marker.ui.internal;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;

public class MetaModelEditorSourceViewerConfig extends TextSourceViewerConfiguration {

  @Override
  public String[] getConfiguredContentTypes(final ISourceViewer sourceViewer) {
    return MetaModelPartitionScanner.PARTITION_TYPES;
  }

  @Override
  public IContentAssistant getContentAssistant(final ISourceViewer sourceViewer) {
    final ContentAssistant assistant = new ContentAssistant();
    assistant.setContentAssistProcessor(new CodeCompletionProcessor(),
        IDocument.DEFAULT_CONTENT_TYPE);
    assistant.enableAutoActivation(true);
    assistant.enableAutoInsert(true);
    assistant.setProposalPopupOrientation(IContentAssistant.PROPOSAL_OVERLAY);
    assistant.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_ABOVE);

    return assistant;
  }

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

    return reconciler;
  }
}
