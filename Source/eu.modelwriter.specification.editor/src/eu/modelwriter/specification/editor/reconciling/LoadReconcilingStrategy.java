package eu.modelwriter.specification.editor.reconciling;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TypedRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.IEditorPart;

import eu.modelwriter.configuration.internal.EditorUtilities;
import eu.modelwriter.specification.editor.scanner.MetaModelPartitionScanner;

public class LoadReconcilingStrategy extends MetaModelReconcilingStrategy {

  private IAnnotationModel annotationModel;

  public LoadReconcilingStrategy(ISourceViewer sourceViewer, IEditorPart editor) {
    super(sourceViewer, editor);
  }

  @Override
  public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
    if (this.document == null)
      return;
    final TypedRegion tr = (TypedRegion) subRegion;
    if (tr.getType().equals(MetaModelPartitionScanner.META_MODEL_LOADINSTANCE)
        || tr.getType().equals(MetaModelPartitionScanner.META_MODEL_LOADMODEL))
      this.reconcile(subRegion);

    return;
  }

  @Override
  public void reconcile(IRegion partition) {

    try {
      this.removeOldAnnotations();
      final List<String> modelLines = EditorUtilities.getPartitionsByType(document,
          MetaModelPartitionScanner.META_MODEL_LOADMODEL);
      for (String line : modelLines) {
        if (!line.contains(" as ")) {
          addNewAnnotation(
              "Alias missing. Add \"as\" keyword after path. \n e.g. -- loadInstance@/path/to/file.xmi as file",
              partition.getOffset() - 1, 0);
        } else if (line.substring(line.indexOf("as ") + 3).length() <= 1) {
          addNewAnnotation(
              "Alias name missing. Add name after \"as\" keyword. \n e.g. -- loadInstance@/path/to/file.xmi as file",
              partition.getOffset() - 1, 0);
        }
      }

      final List<String> instanceLines = EditorUtilities.getPartitionsByType(document,
          MetaModelPartitionScanner.META_MODEL_LOADINSTANCE);
      for (String line : instanceLines) {
        if (!line.contains(" as ")) {
          addNewAnnotation(
              "Alias missing. Add \"as\" keyword after path. \n e.g. -- loadInstance@/path/to/file.xmi as file",
              partition.getOffset() - 1, 0);
        } else if (line.substring(line.indexOf("as ") + 3).length() < 2) {
          addNewAnnotation(
              "Alias name missing. Add name after \"as\" keyword. \n e.g. -- loadInstance@/path/to/file.xmi as file",
              partition.getOffset() - 1, 0);
        }
      }
    } catch (BadLocationException e) {
      e.printStackTrace();
    }
  }

  /**
   * If parser parse specification without finding errors or if reconcile method called again then
   * remove old error annotation.
   *
   * @param offset
   */
  private void removeOldAnnotations() {
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

  private void addNewAnnotation(String message, int offset, int length)
      throws BadLocationException {
    final Annotation annotation = new Annotation(this.MME_PARSE_ANNOT_TYPE, true, message);
    this.annotationModel.connect(this.document);
    this.annotationModel.addAnnotation(annotation, new Position(offset, length));
    this.annotationModel.disconnect(this.document);
  }

  @Override
  public void setDocument(final IDocument document) {
    super.setDocument(document);
    this.annotationModel = this.getAnnotationModel();
    // this.removeOldAnnotations();
  }
}
