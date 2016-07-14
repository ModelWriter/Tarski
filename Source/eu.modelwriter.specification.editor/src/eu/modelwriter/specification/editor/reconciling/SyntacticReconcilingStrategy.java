package eu.modelwriter.specification.editor.reconciling;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.IEditorPart;

import edu.mit.csail.sdg.alloy4.Err;
import eu.modelwriter.configuration.alloy.AlloyParserForMetamodel;
import eu.modelwriter.specification.editor.MetaModelEditor;
import eu.modelwriter.specification.editor.scanner.MetaModelPartitionScanner;

public class SyntacticReconcilingStrategy extends MetaModelReconcilingStrategy {

  private IAnnotationModel annotationModel;

  public SyntacticReconcilingStrategy(final ISourceViewer sourceViewer, final IEditorPart editor) {
    super(sourceViewer, editor);
  }

  /**
   * We add new error annotation related to error which alloy parser is giving us.
   *
   * @param e the exception which is parse operation occurred
   */
  private void addNewAnnotation(final Err e) {
    final int line = e.pos.y;
    int offset = 0;
    final int length = e.pos.x2 - e.pos.x + 1;
    final String message = e.getLocalizedMessage();
    try {
      offset = this.document.getLineOffset(line - 1) + e.pos.x - 1;
    } catch (final BadLocationException e1) {
      e1.printStackTrace();
    }

    final Annotation annotation = new Annotation(this.MME_PARSE_ANNOT_TYPE, true, message);
    this.annotationModel.connect(this.document);
    this.annotationModel.addAnnotation(annotation, new Position(offset, length));
    this.annotationModel.disconnect(this.document);
  }

  @Override
  public void reconcile(final DirtyRegion dirtyRegion, final IRegion subRegion) {
    if (this.document == null) {
      return;
    }
    try {
      if (this.document.getPartition(dirtyRegion.getOffset() - dirtyRegion.getLength()).getType()
          .equals(MetaModelPartitionScanner.META_MODEL_REASON)) {
        return;
      }
    } catch (final BadLocationException e) {
      e.printStackTrace();
    }
    this.reconcile(subRegion);
  }

  @Override
  public void reconcile(final IRegion partition) {
    if (this.document == null) {
      return;
    }

    File tempFile = null;
    try {
      try {
        tempFile = File.createTempFile("tempMetaModel", ".mw",
            this.file.getRawLocation().removeLastSegments(1).toFile());
        final PrintWriter writer = new PrintWriter(tempFile);
        writer.write(this.document.get(), 0, this.document.getLength());
        writer.close();
      } catch (final IOException e) {
        e.printStackTrace();
      }

      new AlloyParserForMetamodel(tempFile.getAbsolutePath(), this.file.getName());
      this.removeOldAnnotation();
      MetaModelEditor.refreshMetamodel(true);
    } catch (final Err e) {
      this.removeOldAnnotation();
      this.addNewAnnotation(e);
    } finally {
      if (tempFile.exists()) {
        tempFile.delete();
      }
    }
  }

  /**
   * If parser parse specification without finding errors or if reconcile method called again then
   * remove old error annotation.
   *
   * @param offset
   */
  private void removeOldAnnotation() {
    this.annotationModel.connect(this.document);

    final Iterator<Annotation> iter = this.annotationModel.getAnnotationIterator();
    Annotation beRemoved = null;
    while (iter.hasNext()) {
      beRemoved = iter.next();
      if (!beRemoved.getType().equals(this.MME_PARSE_ANNOT_TYPE)) {
        continue;
      }
      this.annotationModel.removeAnnotation(beRemoved);
    }
    this.annotationModel.disconnect(this.document);
  }

  @Override
  public void setDocument(final IDocument document) {
    super.setDocument(document);
    this.annotationModel = this.getAnnotationModel();
  }
}
