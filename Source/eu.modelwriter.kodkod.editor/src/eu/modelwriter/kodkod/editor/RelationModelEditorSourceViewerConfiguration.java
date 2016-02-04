package eu.modelwriter.kodkod.editor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;

public class RelationModelEditorSourceViewerConfiguration extends TextSourceViewerConfiguration {

	private ColorManager manager;

	public RelationModelEditorSourceViewerConfiguration(ColorManager manager) {
		this.manager = manager;
	}

	@Override
	public String[] getConfiguredContentTypes(final ISourceViewer sourceViewer) {
		return RelationModelPartitionScanner.PARTITION_TYPES;
	}

	/**
	 * Create and set some specifications of content assistant. We define our
	 * completion processor as @CodeCompletionProcessor.
	 */
	@Override
	public IContentAssistant getContentAssistant(final ISourceViewer sourceViewer) {
		final ContentAssistant assistant = new ContentAssistant();
		assistant.setContentAssistProcessor(new CodeCompletionProcessor(), IDocument.DEFAULT_CONTENT_TYPE);
		assistant.setAutoActivationDelay(500);
		assistant.enableAutoActivation(true);
		assistant.enableAutoInsert(true);
		assistant.setProposalPopupOrientation(IContentAssistant.PROPOSAL_OVERLAY);
		assistant.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_ABOVE);

		return assistant;
	}

	/**
	 * We set presentation reconciler and it's damagers and repairers. This
	 * requires for syntax highlighting that used partition scanner.
	 */
	@Override
	public IPresentationReconciler getPresentationReconciler(final ISourceViewer sourceViewer) {
		final PresentationReconciler reconciler = new PresentationReconciler();

		// Comment Partition
		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new CommentScanner(manager));
		reconciler.setDamager(dr, RelationModelPartitionScanner.RELATION_MODEL_COMMENT);
		reconciler.setRepairer(dr, RelationModelPartitionScanner.RELATION_MODEL_COMMENT);

		// Options Partition
		dr = new DefaultDamagerRepairer(new OptionScanner(manager));
		reconciler.setDamager(dr, RelationModelPartitionScanner.RELATION_MODEL_OPTION);
		reconciler.setRepairer(dr, RelationModelPartitionScanner.RELATION_MODEL_OPTION);

		// Universe Partition
		dr = new DefaultDamagerRepairer(new UniverseScanner(manager));
		reconciler.setDamager(dr, RelationModelPartitionScanner.RELATION_MODEL_UNIVERSE);
		reconciler.setRepairer(dr, RelationModelPartitionScanner.RELATION_MODEL_UNIVERSE);

		// Relations Partition
		dr = new DefaultDamagerRepairer(new RelBoundScanner(manager));
		reconciler.setDamager(dr, RelationModelPartitionScanner.RELATION_MODEL_REL_BOUND);
		reconciler.setRepairer(dr, RelationModelPartitionScanner.RELATION_MODEL_REL_BOUND);

		// Default Partition(Formulas Partition)
		dr = new DefaultDamagerRepairer(new FormulasScanner(manager));
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		return reconciler;
	}

	/**
	 * We set reconciler and it's strategy for reconciling.
	 * 
	 * @MetaModelValidationReconcilingStrategy we set our strategy while
	 *                                         editing. It may be both
	 *                                         incremental and full.
	 */
	// @Override
	// public IReconciler getReconciler(final ISourceViewer sourceViewer) {
	// MonoReconciler reconciler = null;
	// if (sourceViewer != null) {
	// reconciler = new MonoReconciler(
	// new RelationModelValidationReconcilingStrategy(sourceViewer,
	// this.editor), false);
	// reconciler.setDelay(250);
	// reconciler.setProgressMonitor(new NullProgressMonitor());
	// }
	// return reconciler;
	// }
}
