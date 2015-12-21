package eu.modelwriter.specification.editor;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.ui.texteditor.SimpleMarkerAnnotation;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;

public class MetaModelValidationReconcilingStrategy
    implements IReconcilingStrategy, IReconcilingStrategyExtension {

  public static final String MME_ANNOT_TYPE = "eu.modelwriter.specification.editor.errorannotation";
  public static final String MME_MARKER_TYPE = "eu.modelwriter.specification.editor.errormarker";
  private IDocument document;
  private IFile file;
  private final ISourceViewer viewer;

  public MetaModelValidationReconcilingStrategy(final ISourceViewer viewer,
      final IEditorPart editor) {
    this.viewer = viewer;
    this.file = editor.getEditorInput().getAdapter(IFile.class);
  }
  
  private IAnnotationModel getAnnotationModel() {
    return this.viewer.getAnnotationModel();
  }
  
  /**
   * Because of Alloy Parser stop parsing when it found an error the document might has just one error marker
   * @param file the resource which is used for searching error marker
   * @return founded error marker
   * @throws CoreException - if this method fails. Reasons include: 
   * <ul>
   * <li> This resource does not exist.</li>
   * <li> This resource is a project that is not open.</li>
   * </ul>
   */
  private IMarker getErrorMarker(final IFile file) throws CoreException {
    final IMarker[] markers = file.findMarkers(
        MetaModelValidationReconcilingStrategy.MME_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
    if (markers.length == 0) {
      return null;
    } else {
      return markers[0];
    }
  }
  
  private IMarker createErrorMarker(final int line, final int offset, final int length,
      final String message) throws CoreException {
    final HashMap<String, Object> map = new HashMap<String, Object>();
    MarkerUtilities.setLineNumber(map, line);
    MarkerUtilities.setCharStart(map, offset);
    MarkerUtilities.setCharEnd(map, offset + length);
    MarkerUtilities.setMessage(map, message);

    MarkerUtilities.createMarker(this.file, map,
        MetaModelValidationReconcilingStrategy.MME_MARKER_TYPE);

    return this.getErrorMarker(this.file);
  }
  
  /**
   * We add new error marker and annotation related to error which alloy parser is giving us.
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
    };

    IMarker marker = null;
    try {
      marker = this.createErrorMarker(line, offset, length, message);
    } catch (final CoreException e1) {
      e1.printStackTrace();
    }
    final SimpleMarkerAnnotation ma =
        new SimpleMarkerAnnotation(MetaModelValidationReconcilingStrategy.MME_ANNOT_TYPE, marker);

    this.getAnnotationModel().connect(this.document);
    this.getAnnotationModel().addAnnotation(ma, new Position(offset, length));
    this.getAnnotationModel().disconnect(this.document);
  }
  
  @Override
  public void setProgressMonitor(IProgressMonitor monitor) {
    // do nothing
  }

  @Override
  public void initialReconcile() {
    if (this.document == null) {
      return;
    }
    this.reconcile(new Region(0, this.document.getLength()));
  }

  @Override
  public void setDocument(IDocument document) {
    this.document = document;
  }

  @Override
  public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
    this.reconcile(subRegion);
  }

  @Override
  public void reconcile(IRegion partition) {
    if (this.document == null) {
      return;
    }
    try {
      CompUtil.parseOneModule_fromString(this.document.get());
      this.removeOldMarker();
    } catch (final Err e) {
      this.removeOldMarker();
      this.addNewMarker(e);
    }
  }
  
  /**
   * If parser parse specification without finding errors or if reconcile method called again then remove old error marker. 
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
