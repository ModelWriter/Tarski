package eu.modelwriter.core.alloyinecore.ui.editor.reconciling;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.ui.ASTErrorListener;
import eu.modelwriter.core.alloyinecore.ui.Activator;
import eu.modelwriter.core.alloyinecore.ui.editor.AIEEditor;

public class AIESyntacticReconcilingStrategy
    implements IReconcilingStrategy, IReconcilingStrategyExtension, ASTErrorListener {

  private List<Annotation> annotations = new ArrayList<>();
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
    attachErrorListener();
  }

  protected void attachErrorListener() {
    Activator.getDefault().getModelManager().addErrorListener(this);
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

  protected void createAnnotation(final Token offendingToken, final String msg,
      final String annotationType) {
    final Annotation annotation = new Annotation(annotationType, true, msg);
    getAnnotationModel().connect(document);
    getAnnotationModel().addAnnotation(annotation, new Position(offendingToken.getStartIndex(),
        offendingToken.getStopIndex() - offendingToken.getStartIndex() + 1));
    getAnnotationModel().disconnect(document);
    annotations.add(annotation);
  }

  @SuppressWarnings("unused")
  private void createErrorMarker(final Token offendingToken, final String message) {
    try {
      final IMarker m = iFile.createMarker(AIEEditor.PARSER_ERROR_MARKER);
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
      URI uri = URI.createPlatformResourceURI(iFile.getFullPath().toString(), true);
      removeOldAnnotations();
      Activator.getDefault().getModelManager().parseDocument(document, uri);
    } catch (final Exception e1) {
      e1.printStackTrace();
    }
  }

  protected void removeOldAnnotations() {
    final IAnnotationModel annotationModel = getAnnotationModel();
    annotationModel.connect(document);
    annotations.forEach(anno -> annotationModel.removeAnnotation(anno));
    annotationModel.disconnect(document);
    annotations.clear();
  }

  @SuppressWarnings("unused")
  private void removeOldMarkers() {
    try {
      iFile.deleteMarkers(AIEEditor.PARSER_ERROR_MARKER, true, IResource.DEPTH_INFINITE);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onSyntaxError(Token offendingSymbol, String msg) {
    createAnnotation((Token) offendingSymbol, msg, AIEEditor.PARSER_ERROR_ANNOTATION);
  }

  @Override
  public void onTypeError(String message, Set<Token> relatedElements) {
    relatedElements
        .forEach(e -> createAnnotation(e, message, AIEEditor.TYPE_ERROR_ANNOTATION));
  }

  @Override
  public void onTypeWarning(String message, Set<Token> relatedElements) {
    relatedElements
        .forEach(e -> createAnnotation(e, message, AIEEditor.TYPE_WARNING_ANNOTATION));
  }

}
