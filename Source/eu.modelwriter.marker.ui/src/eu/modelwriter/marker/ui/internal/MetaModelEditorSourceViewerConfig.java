package eu.modelwriter.marker.ui.internal;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;

public class MetaModelEditorSourceViewerConfig extends TextSourceViewerConfiguration {

  @Override
  public String[] getConfiguredContentTypes(final ISourceViewer sourceViewer) {
    return CommentScanner.PARTITION_TYPES;
  }

  @Override
  public IPresentationReconciler getPresentationReconciler(final ISourceViewer sourceViewer) {
    final PresentationReconciler reconciler = new PresentationReconciler();

    // Code Partition
    final DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new CodeScanner());
    reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
    reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

    // Comment Partition
    final NonRuleBasedDamagerRepairer ndr = new NonRuleBasedDamagerRepairer(
        new TextAttribute(new Color(Display.getCurrent(), new RGB(204, 0, 0))));
    reconciler.setDamager(ndr, CommentScanner.META_MODEL_COMMENT);
    reconciler.setRepairer(ndr, CommentScanner.META_MODEL_COMMENT);

    return reconciler;
  }
}
