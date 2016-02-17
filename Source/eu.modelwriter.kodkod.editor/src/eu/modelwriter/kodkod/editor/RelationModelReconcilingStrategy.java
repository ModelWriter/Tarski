package eu.modelwriter.kodkod.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
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
    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        try {
          RelationModelReconcilingStrategy.this.manager =
              new SynchronizationManager(RelationModelReconcilingStrategy.this.document);
        } catch (final BadLocationException e) {
          e.printStackTrace();
        }
      }
    });
  }

  @Override
  public void reconcile(final DirtyRegion dirtyRegion, final IRegion subRegion) {
    this.reconcile(dirtyRegion);
  }

  @Override
  public void reconcile(final IRegion partition) {
    if (this.document == null) {
      return;
    }

    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        RelationModelReconcilingStrategy.this.manager
            .evaluate(RelationModelReconcilingStrategy.this.document, partition);
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
