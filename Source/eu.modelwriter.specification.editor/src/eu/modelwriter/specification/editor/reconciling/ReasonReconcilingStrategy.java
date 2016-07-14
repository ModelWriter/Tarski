package eu.modelwriter.specification.editor.reconciling;

import java.util.Iterator;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.IEditorPart;

import eu.modelwriter.configuration.alloy.AlloyParserForMetamodel;
import eu.modelwriter.specification.editor.scanner.MetaModelPartitionScanner;

public class ReasonReconcilingStrategy extends MetaModelReconcilingStrategy {

  private IAnnotationModel annotationModel;

  private boolean isMatch = false;

  public ReasonReconcilingStrategy(final ISourceViewer sourceViewer, final IEditorPart editor) {
    super(sourceViewer, editor);
  }

  private void addNewAnnotation(final String errored, final int line,
      final IRegion lineInformationOfOffset) {
    final int offset = lineInformationOfOffset.getOffset();
    final int length = lineInformationOfOffset.getLength();
    final String message = errored + " cannot be resolved as a relation";

    final Annotation annotation = new Annotation(this.MME_REASON_ANNOT_TYPE, true, message);
    this.annotationModel.connect(this.document);
    this.annotationModel.addAnnotation(annotation, new Position(offset, length));
    this.annotationModel.disconnect(this.document);
  }

  @Override
  public void reconcile(final DirtyRegion dirtyRegion, final IRegion subRegion) {
    this.removeOldAnnotation(subRegion.getOffset());
    try {
      final IRegion lineInformationOfOffset =
          this.document.getLineInformationOfOffset(subRegion.getOffset());
      final String dirtyLine = this.document.get(lineInformationOfOffset.getOffset(),
          lineInformationOfOffset.getLength());
      final int line = this.document.getLineOfOffset(lineInformationOfOffset.getOffset());

      final int at = dirtyLine.indexOf("@");
      String errored = "";
      if (at != -1) {
        errored = dirtyLine.substring(at + 1).trim();
      } else {
        return;
      }

      if (errored.indexOf(".") == -1) {
        this.addNewAnnotation(errored, line, lineInformationOfOffset);
        this.isMatch = false;
        return;
      }

      final String sigName = errored.substring(0, errored.indexOf("."));
      final String relName = errored.substring(errored.indexOf(".") + 1);

      this.isMatch = false;
      for (final String sig : AlloyParserForMetamodel.getSigs()) {
        if (sigName.equals(sig)) {
          this.isMatch = true;
          break;
        }
      }

      if (this.isMatch == false) {
        this.addNewAnnotation(sigName, line, lineInformationOfOffset);
        return;
      }

      this.isMatch = false;
      for (final String relation : AlloyParserForMetamodel.getRels()) {
        if (relName.equals(relation)) {
          this.isMatch = true;
          break;
        }
      }

      if (this.isMatch == false) {
        this.addNewAnnotation(relName, line, lineInformationOfOffset);
        return;
      }
    } catch (final BadLocationException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void reconcile(final IRegion partition) {
    if (this.document == null) {
      return;
    }
    try {
      final ITypedRegion[] partitionRegions =
          this.document.computePartitioning(partition.getOffset(), partition.getLength());
      for (int i = 0; i < partitionRegions.length; i++) {
        if (partitionRegions[i].getType().equals(MetaModelPartitionScanner.META_MODEL_REASON)) {
          this.reconcile(null, partitionRegions[i]);
        }
      }
    } catch (final BadLocationException e) {
      e.printStackTrace();
    }
  }

  private void removeOldAnnotation(final int offset) {
    this.annotationModel.connect(this.document);

    final Iterator<Annotation> iter = this.annotationModel.getAnnotationIterator();
    Annotation beRemoved = null;
    while (iter.hasNext()) {
      beRemoved = iter.next();
      if (!beRemoved.getType().equals(this.MME_REASON_ANNOT_TYPE)) {
        continue;
      }
      final Position position = this.annotationModel.getPosition(beRemoved);

      if (position.getOffset() + position.getLength() == offset || position.includes(offset)) {
        this.annotationModel.removeAnnotation(beRemoved);
      }
    }
    this.annotationModel.disconnect(this.document);
  }

  @Override
  public void setDocument(final IDocument document) {
    super.setDocument(document);
    this.annotationModel = this.getAnnotationModel();
  }
}
