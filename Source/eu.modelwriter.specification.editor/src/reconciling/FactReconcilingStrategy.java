package reconciling;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.ui.texteditor.SimpleMarkerAnnotation;

import eu.modelwriter.configuration.internal.AlloyUtilities;

public class FactReconcilingStrategy extends MetaModelReconcilingStrategy {

  public FactReconcilingStrategy(final ISourceViewer sourceViewer, final IEditorPart editor) {
    super(sourceViewer, editor);
  }

  private void addNewMarker(final String errored, final int line,
      final IRegion lineInformationOfOffset) {
    final int offset = lineInformationOfOffset.getOffset();
    final int length = lineInformationOfOffset.getLength();
    final String message = errored + " cannot be resolved as a relation";

    IMarker marker = null;
    try {
      marker = this.createErrorMarker(line, offset, length, message);
    } catch (final CoreException e1) {
      e1.printStackTrace();
    }
    final SimpleMarkerAnnotation ma = new SimpleMarkerAnnotation(this.MME_ANNOT_TYPE, marker);

    this.getAnnotationModel().connect(this.document);
    this.getAnnotationModel().addAnnotation(ma, new Position(offset, length));
    this.getAnnotationModel().disconnect(this.document);
  }

  private IMarker createErrorMarker(final int line, final int offset, final int length,
      final String message) throws CoreException {
    final HashMap<String, Object> map = new HashMap<String, Object>();
    MarkerUtilities.setLineNumber(map, line);
    MarkerUtilities.setCharStart(map, offset);
    MarkerUtilities.setCharEnd(map, offset + length);
    MarkerUtilities.setMessage(map, message);

    MarkerUtilities.createMarker(this.file, map, this.MME_MARKER_TYPE);

    return this.getErrorMarker(this.file);
  }

  private IMarker getErrorMarker(final IFile file) throws CoreException {
    final IMarker[] markers =
        file.findMarkers(this.MME_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
    if (markers.length == 0) {
      return null;
    } else {
      return markers[0];
    }
  }

  @Override
  public void reconcile(final DirtyRegion dirtyRegion, final IRegion subRegion) {
    this.removeOldMarker();
    try {
      final IRegion lineInformationOfOffset =
          this.document.getLineInformationOfOffset(dirtyRegion.getOffset());
      final String dirtyLine = this.document.get(lineInformationOfOffset.getOffset(),
          lineInformationOfOffset.getLength());
      final int line = this.document.getLineOfOffset(lineInformationOfOffset.getOffset());

      final int at = dirtyLine.indexOf("@");
      String errored = "";
      if (at != -1) {
        errored = dirtyLine.substring(at + 1).trim();
      }

      for (final String relation : AlloyUtilities.getFieldNames()) {
        if (errored.equals(relation)) {
          this.removeOldMarker();
          return;
        }
      }
      this.addNewMarker(errored, line, lineInformationOfOffset);
    } catch (final BadLocationException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void reconcile(final IRegion partition) {
    if (this.document == null) {
      return;
    }
  }

  private void removeOldMarker() {
    final IAnnotationModel annoModel = this.getAnnotationModel();
    annoModel.connect(this.document);

    IMarker oldMarker = null;
    try {
      oldMarker = this.getErrorMarker(this.file);
    } catch (final CoreException e) {
      e.printStackTrace();
    }

    if (oldMarker != null) {
      @SuppressWarnings("unchecked")
      final Iterator<Annotation> iter = annoModel.getAnnotationIterator();
      Annotation beRemoved = null;
      while (iter.hasNext()) {
        beRemoved = iter.next();
        annoModel.removeAnnotation(beRemoved);
      }
      annoModel.disconnect(this.document);
      try {
        oldMarker.delete();
      } catch (final CoreException e) {
        e.printStackTrace();
      }
    }
  }
}
