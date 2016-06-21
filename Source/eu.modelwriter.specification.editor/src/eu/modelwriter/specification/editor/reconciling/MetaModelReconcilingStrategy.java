package eu.modelwriter.specification.editor.reconciling;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.IEditorPart;

public abstract class MetaModelReconcilingStrategy
    implements IReconcilingStrategy, IReconcilingStrategyExtension {

  protected final String MME_ANNOT_TYPE = "eu.modelwriter.specification.editor.errorannotation";

  protected final String MME_MARKER_TYPE = "eu.modelwriter.specification.editor.errormarker";

  protected IDocument document;

  protected final IFile file;

  protected final ISourceViewer viewer;

  protected IProgressMonitor monitor;

  public MetaModelReconcilingStrategy(final ISourceViewer sourceViewer, final IEditorPart editor) {
    this.viewer = sourceViewer;
    this.file = editor.getEditorInput().getAdapter(IFile.class);
  }

  protected IAnnotationModel getAnnotationModel() {
    return this.viewer.getAnnotationModel();
  }

  @Override
  public void initialReconcile() {
    if (this.document == null) {
      return;
    }
    this.reconcile(new Region(0, this.document.getLength()));
  }

  @Override
  public void setDocument(final IDocument document) {
    this.document = document;
  }

  @Override
  public void setProgressMonitor(final IProgressMonitor monitor) {
    this.monitor = monitor;
  }
}
