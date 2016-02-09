package eu.modelwriter.kodkod.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.swt.widgets.Display;

import eu.modelwriter.kodkod.editor.manager.SynchronizationManager;

public class RelationModelReconcilingStrategy
    implements IReconcilingStrategy, IReconcilingStrategyExtension {

  private IDocument document;
  private SynchronizationManager manager;

  public RelationModelReconcilingStrategy(final IDocument document) {
    this.document = document;
  }

  @Override
  public void initialReconcile() {
    if (this.document == null) {
      return;
    }
    this.manager = new SynchronizationManager();
    this.reconcile(new Region(0, this.document.getLength()));
  }

  // when we make incremental parser we'll get some line region in here.
  @Override
  public void reconcile(final DirtyRegion dirtyRegion, final IRegion subRegion) {
    this.reconcile(subRegion);
  }

  @Override
  public void reconcile(final IRegion partition) {
    if (this.document == null) {
      return;
    }
    // we are parsing full document when we have parsers for each partition then we'll change here.
    // final ParseTest test = new ParseTest();
    // test.parseKodkod(RelationModelReconcilingStrategy.this.document.get());
    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        RelationModelReconcilingStrategy.this.manager
            .evaluate(RelationModelReconcilingStrategy.this.document);
      }
    });
  }

  @Override
  public void setDocument(final IDocument document) {
    this.document = document;
  }

  @Override
  public void setProgressMonitor(final IProgressMonitor monitor) {
    // do nothing
  }
}
