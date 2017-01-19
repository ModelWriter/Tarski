package eu.modelwriter.core.alloyinecore.ui.editor.reconciling;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.texteditor.ITextEditor;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModuleContext;
import eu.modelwriter.core.alloyinecore.ui.editor.AlloyInEcoreEditor;

public class AIESyntacticReconcilingStrategy
    implements IReconcilingStrategy, IReconcilingStrategyExtension {

  protected final String PARSER_ERROR_TYPE =
      "eu.modelwriter.core.alloyinecore.ui.editor.parsererror";
  protected final String PARSER_ERROR_MARKER_TYPE =
      "eu.modelwriter.core.alloyinecore.ui.editor.parseerrormarker";

  private ISourceViewer sourceViewer;
  private ITextEditor editor;
  private IDocument document;
  private IFile iFile;

  public AIESyntacticReconcilingStrategy(ISourceViewer sourceViewer, ITextEditor editor) {
    this.sourceViewer = sourceViewer;
    this.editor = editor;
    iFile = editor.getEditorInput().getAdapter(IFile.class);
  }

  protected IAnnotationModel getAnnotationModel() {
    return sourceViewer.getAnnotationModel();
  }

  @Override
  public void setProgressMonitor(IProgressMonitor monitor) {}

  @Override
  public void initialReconcile() {
    if (document == null) {
      return;
    }
    this.reconcile(new Region(0, document.getLength()));
  }

  @Override
  public void setDocument(IDocument document) {
    this.document = document;
  }

  private void createErrorMarker(Token offendingToken, String message) {
    try {
      IMarker m = iFile.createMarker(PARSER_ERROR_MARKER_TYPE);
      m.setAttribute(IMarker.MESSAGE, message);
      m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
      m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
      m.setAttribute(IMarker.LINE_NUMBER, offendingToken.getLine());
      m.setAttribute(IMarker.CHAR_START, offendingToken.getCharPositionInLine());
      m.setAttribute(IMarker.CHAR_END, offendingToken.getCharPositionInLine()
          + (offendingToken.getStopIndex() - offendingToken.getStartIndex()) + 1);
    } catch (CoreException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
    if (document == null) {
      return;
    }
    this.reconcile(subRegion);
  }

  @Override
  public void reconcile(IRegion partition) {
    removeOldAnnotations();
    final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(new ANTLRInputStream(document.get()));
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens);
    parser.removeErrorListeners();
    parser.addErrorListener(new BaseErrorListener() {
      @Override
      public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
          int charPositionInLine, String msg, RecognitionException e) {
        createErrorMarker((Token) offendingSymbol, msg);
      }
    });
    ModuleContext module = parser.module();
    ((AlloyInEcoreEditor) editor).setModule(module);
  }

  /**
   * If parser parse specification without finding errors or if reconcile method called again then
   * remove old error annotation.
   *
   * @param offset
   */
  private void removeOldAnnotations() {
    try {
      iFile.deleteMarkers(PARSER_ERROR_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
    } catch (CoreException e) {
      e.printStackTrace();
    }
    // IAnnotationModel annotationModel = getAnnotationModel();
    // annotationModel.connect(document);
    //
    // final Iterator<Annotation> iter = annotationModel.getAnnotationIterator();
    // Annotation beRemoved = null;
    // while (iter.hasNext()) {
    // beRemoved = iter.next();
    // if (!beRemoved.getType().equals(PARSER_ERROR_TYPE)) {
    // continue;
    // }
    // annotationModel.removeAnnotation(beRemoved);
    // }
    // annotationModel.disconnect(document);
  }

}
