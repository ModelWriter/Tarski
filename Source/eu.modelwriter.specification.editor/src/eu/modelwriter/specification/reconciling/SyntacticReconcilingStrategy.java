package eu.modelwriter.specification.reconciling;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

import edu.mit.csail.sdg.alloy4.Err;
import eu.modelwriter.configuration.alloy.AlloyParserForMetamodel;

public class SyntacticReconcilingStrategy extends MetaModelReconcilingStrategy {

  public SyntacticReconcilingStrategy(final ISourceViewer sourceViewer, final IEditorPart editor) {
    super(sourceViewer, editor);
  }

  /**
   * We add new error marker and annotation related to error which alloy parser is giving us.
   *
   * @param e the exception which is parse operation occurred
   */
  private void addNewMarker(final Err e) {
    final int line = e.pos.y;
    int offset = 0;
    final int length = e.pos.x2 - e.pos.x + 1;
    final String message = e.getLocalizedMessage();
    try {
      offset = this.document.getLineOffset(line - 1) + e.pos.x - 1;
    } catch (final BadLocationException e1) {
      e1.printStackTrace();
    }

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

  /**
   * Because of Alloy Parser stop parsing when it found an error the document might has just one
   * error marker
   *
   * @param file 'the resource which is used for searching error marker'
   * @return founded error marker
   * @throws CoreException - if this method fails. Reasons include:
   *         <ul>
   *         <li>This resource does not exist.</li>
   *         <li>This resource is a project that is not open.</li>
   *         </ul>
   */
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
        tempFile = File.createTempFile("tempAlloy", ".mw",
            this.file.getRawLocation().removeLastSegments(1).toFile());
        final PrintWriter writer = new PrintWriter(tempFile);
        writer.write(this.document.get(), 0, this.document.getLength());
        writer.close();
      } catch (final IOException e) {
        e.printStackTrace();
      }

      new AlloyParserForMetamodel(tempFile.getAbsolutePath(), this.file.getName());
      this.removeOldMarker();
    } catch (final Err e) {
      this.removeOldMarker();
      this.addNewMarker(e);
    } finally {
      if (tempFile.exists()) {
        tempFile.delete();
      }
    }
  }

  /**
   * If parser parse specification without finding errors or if reconcile method called again then
   * remove old error marker.
   */
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
