package eu.modelwriter.core.alloyinecore.ui.editor.instance.reconciling;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.texteditor.ITextEditor;

import eu.modelwriter.core.alloyinecore.ui.Activator;
import eu.modelwriter.core.alloyinecore.ui.editor.reconciling.AIESyntacticReconcilingStrategy;

public class AIEInstanceSyntacticReconcilingStrategy extends AIESyntacticReconcilingStrategy {

  public AIEInstanceSyntacticReconcilingStrategy(final ISourceViewer sourceViewer,
      final ITextEditor editor) {
    super(sourceViewer, editor);
  }

  @Override
  protected void attachErrorListener() {
    Activator.getDefault().getInstanceManager().addErrorListener(this);
  }

  @Override
  public void reconcile(final IRegion partition) {
    try {
      URI uri = URI.createPlatformResourceURI(iFile.getFullPath().toString(), true);
      removeOldAnnotations();
      Activator.getDefault().getInstanceManager().parseDocument(document, uri);
    } catch (final Exception e1) {
      e1.printStackTrace();
    }
  }
}
