package eu.modelwriter.core.alloyinecore.ui.editor.reconciling;

import java.util.Iterator;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
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
import org.eclipse.ui.texteditor.ITextEditor;

import eu.modelwriter.core.alloyinecore.structure.model.Model;
import eu.modelwriter.core.alloyinecore.ui.editor.AIEEditor;
import eu.modelwriter.core.alloyinecore.ui.editor.util.EditorUtils;

public class AIESyntacticReconcilingStrategy
    implements IReconcilingStrategy, IReconcilingStrategyExtension {

  protected final ISourceViewer sourceViewer;
  protected final ITextEditor editor;
  protected IDocument document;
  protected final IFile iFile;
  protected boolean noErrors;

  public AIESyntacticReconcilingStrategy(final ISourceViewer sourceViewer,
      final ITextEditor editor) {
    this.sourceViewer = sourceViewer;
    this.editor = editor;
    iFile = editor.getEditorInput().getAdapter(IFile.class);
  }

  protected IAnnotationModel getAnnotationModel() {
    return sourceViewer.getAnnotationModel();
  }

  @Override
  public void setProgressMonitor(final IProgressMonitor monitor) {}

  @Override
  public void initialReconcile() {
    if (document == null) {
      return;
    }
    this.reconcile(new Region(0, document.getLength()));
  }

  @Override
  public void setDocument(final IDocument document) {
    this.document = document;
  }

  protected void createErrorAnnotation(final Token offendingToken, final String msg) {
    final Annotation annotation = new Annotation(AIEEditor.PARSER_ERROR_ANNOTATION_TYPE, true, msg);
    getAnnotationModel().connect(document);
    getAnnotationModel().addAnnotation(annotation, new Position(offendingToken.getStartIndex(),
        offendingToken.getStopIndex() - offendingToken.getStartIndex() + 1));
    getAnnotationModel().disconnect(document);
  }

  @SuppressWarnings("unused")
  private void createErrorMarker(final Token offendingToken, final String message) {
    try {
      final IMarker m = iFile.createMarker(AIEEditor.PARSER_ERROR_MARKER_TYPE);
      m.setAttribute(IMarker.MESSAGE, message);
      m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
      m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
      m.setAttribute(IMarker.LINE_NUMBER, offendingToken.getLine());
      m.setAttribute(IMarker.CHAR_START, offendingToken.getCharPositionInLine());
      m.setAttribute(IMarker.CHAR_END, offendingToken.getCharPositionInLine()
          + offendingToken.getStopIndex() - offendingToken.getStartIndex() + 1);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void reconcile(final DirtyRegion dirtyRegion, final IRegion subRegion) {
    if (document == null) {
      return;
    }
    this.reconcile(subRegion);
  }

  @Override
  public void reconcile(final IRegion partition) {
    try {
      noErrors = true;
      removeOldAnnotations();
      URI uri = URI.createPlatformResourceURI(iFile.getFullPath().toString(), true);
      final Model parsedModule = EditorUtils.parseDocument(document, uri, new BaseErrorListener() {
        @Override
        public void syntaxError(final Recognizer<?, ?> recognizer, final Object offendingSymbol,
            final int line, final int charPositionInLine, final String msg,
            final RecognitionException e) {
          noErrors = false;
          createErrorAnnotation((Token) offendingSymbol, msg);
        }
      });
      // Set module and refresh outline
      ((AIEEditor) editor).setModule(parsedModule, true);
    } catch (final Exception e1) {
      e1.printStackTrace();
    }
  }

  protected void removeOldAnnotations() {
    final IAnnotationModel annotationModel = getAnnotationModel();
    annotationModel.connect(document);

    final Iterator<Annotation> iter = annotationModel.getAnnotationIterator();
    Annotation beRemoved = null;
    while (iter.hasNext()) {
      beRemoved = iter.next();
      if (!beRemoved.getType().equals(AIEEditor.PARSER_ERROR_ANNOTATION_TYPE)) {
        continue;
      }
      annotationModel.removeAnnotation(beRemoved);
    }
    annotationModel.disconnect(document);
  }

  @SuppressWarnings("unused")
  private void removeOldMarkers() {
    try {
      iFile.deleteMarkers(AIEEditor.PARSER_ERROR_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
  }
}
