package eu.modelwriter.core.alloyinecore.ui.editor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class ViewerConfiguration extends SourceViewerConfiguration {
  private Scanner scanner;
  private ColorManager colorManager;

  public ViewerConfiguration(ColorManager colorManager) {
    this.colorManager = colorManager;
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

}
