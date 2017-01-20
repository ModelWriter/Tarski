package eu.modelwriter.core.alloyinecore.ui.editor;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.Reconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.DefaultAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.ui.texteditor.ITextEditor;

import eu.modelwriter.core.alloyinecore.ui.editor.reconciling.AIESyntacticReconcilingStrategy;

public class ViewerConfiguration extends SourceViewerConfiguration {
  private Scanner scanner;
  private ColorManager colorManager;
  private ITextEditor editor;

  public ViewerConfiguration(ColorManager colorManager, ITextEditor editor) {
    this.colorManager = colorManager;
    this.editor = editor;
  }

  @Override
  public ITextHover getTextHover(ISourceViewer sourceViewer, String contentType) {
    return null;
  }

  @Override
  public IAnnotationHover getOverviewRulerAnnotationHover(ISourceViewer sourceViewer) {
    return new DefaultAnnotationHover();
  }

  @Override
  public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
    return new DefaultAnnotationHover();
  }

  @Override
  public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
    return PartitionScanner.ALL_PARTITIONS;
  }

  protected Scanner getScanner() {
    if (scanner == null) {
      scanner = new Scanner(colorManager);
      scanner.setDefaultReturnToken(
          new Token(new TextAttribute(colorManager.getColor(ColorConstants.DEFAULT))));
    }
    return scanner;
  }

  @Override
  public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
    PresentationReconciler reconciler = new PresentationReconciler();

    DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getScanner());

    dr = new DefaultDamagerRepairer(getScanner());
    reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
    reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

    dr = new DefaultDamagerRepairer(getScanner());
    reconciler.setDamager(dr, PartitionScanner.PACKAGE);
    reconciler.setRepairer(dr, PartitionScanner.PACKAGE);

    dr = new DefaultDamagerRepairer(getScanner());
    reconciler.setDamager(dr, PartitionScanner.CLASS);
    reconciler.setRepairer(dr, PartitionScanner.CLASS);
    return reconciler;
  }

  @Override
  public IReconciler getReconciler(ISourceViewer sourceViewer) {
    Reconciler reconciler = null;
    if (sourceViewer != null) {
      reconciler = new Reconciler();
      AIESyntacticReconcilingStrategy strategy =
          new AIESyntacticReconcilingStrategy(sourceViewer, editor);
      reconciler.setReconcilingStrategy(strategy, IDocument.DEFAULT_CONTENT_TYPE);
      reconciler.setReconcilingStrategy(strategy, PartitionScanner.PACKAGE);
      reconciler.setReconcilingStrategy(strategy, PartitionScanner.CLASS);
      reconciler.setDelay(250);
      reconciler.setProgressMonitor(new NullProgressMonitor());
    }
    return reconciler;
  }

}
