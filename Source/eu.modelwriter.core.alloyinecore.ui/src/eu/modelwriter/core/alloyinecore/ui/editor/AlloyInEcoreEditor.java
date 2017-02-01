package eu.modelwriter.core.alloyinecore.ui.editor;

import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.CommonToken;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModuleContext;
import eu.modelwriter.core.alloyinecore.structure.Element;
import eu.modelwriter.core.alloyinecore.ui.EditorUtils;
import eu.modelwriter.core.alloyinecore.ui.outline.AIEContentOutlinePage;

public class AlloyInEcoreEditor extends TextEditor {

  public static final String PARSER_ERROR_ANNOTATION_TYPE =
      "eu.modelwriter.core.alloyinecore.ui.editor.parsererror";
  public static final String PARSER_ERROR_MARKER_TYPE =
      "eu.modelwriter.core.alloyinecore.ui.editor.parseerrormarker";

  private ColorManager colorManager;
  private AIEContentOutlinePage outlinePage;
  private Element<ModuleContext> parsedModule;
  private ProjectionAnnotationModel annotationModel;
  private Annotation[] oldAnnotations;
  private HashMap<ProjectionAnnotation, Position> projectionAnnotations =
      new HashMap<ProjectionAnnotation, Position>();

  public AlloyInEcoreEditor() {
    colorManager = new ColorManager();
    setSourceViewerConfiguration(new ViewerConfiguration(colorManager, this));
    setDocumentProvider(new AlloyInEcoreDocumentProvider());
  }

  @Override
  protected ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
    ISourceViewer viewer =
        new ProjectionViewer(parent, ruler, getOverviewRuler(), isOverviewRulerVisible(), styles);
    // ensure decoration support has been created and configured.
    getSourceViewerDecorationSupport(viewer);
    return viewer;
  }

  @Override
  public void createPartControl(Composite parent) {
    super.createPartControl(parent);
    ProjectionViewer projectionViewer = (ProjectionViewer) getSourceViewer();

    ProjectionSupport projectionSupport =
        new ProjectionSupport(projectionViewer, getAnnotationAccess(), getSharedColors());
    projectionSupport.install();

    // turn projection mode on
    projectionViewer.doOperation(ProjectionViewer.TOGGLE);

    annotationModel = projectionViewer.getProjectionAnnotationModel();
  }

  @Override
  protected void handleCursorPositionChanged() {
    super.handleCursorPositionChanged();
    String[] cursorPosition = getCursorPosition().split(" : ");
    try {
      int line = Integer.parseInt(cursorPosition[0]) - 1;
      int column = Integer.parseInt(cursorPosition[1]) - 1;
      int offset = getDocumentProvider().getDocument(getEditorInput()).getLineOffset(line) + column;
      if (outlinePage != null && offset != outlinePage.getSelectionOffset())
        outlinePage.selectElement(findElement(line + 1, offset));
    } catch (NumberFormatException e) {
      e.printStackTrace();
    } catch (BadLocationException e) {
      e.printStackTrace();
    }
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  private void calculateFoldingPositions(Element element) {
    List<Element> ownedElements = element.getOwnedElements();
    for (Element ownedElement : ownedElements) {
      Position position = getFoldablePosition(ownedElement);
      if (position != null) {
        ProjectionAnnotation annotation = new ProjectionAnnotation();
        if (ownedElement instanceof eu.modelwriter.core.alloyinecore.structure.Annotation)
          annotation.markCollapsed();
        projectionAnnotations.put(annotation, position);
      }
      calculateFoldingPositions(ownedElement);
    }
  }

  @SuppressWarnings("rawtypes")
  private Position getFoldablePosition(Element element) {
    int startIndex = element.getContext().getStart().getStartIndex();
    int stopIndex = 0;
    int stopLine = element.getLine();
    // find last token
    for (int i = element.getContext().getChildCount() - 1; i >= 0; i--) {
      if (element.getContext().getChild(i).getPayload() instanceof CommonToken) {
        CommonToken lastToken = (CommonToken) element.getContext().getChild(i).getPayload();
        stopIndex = lastToken.getStopIndex();
        stopLine = lastToken.getLine();
        break;
      }
    }
    if (stopIndex != 0 && stopLine != element.getLine())
      return new Position(startIndex, stopIndex - startIndex + 1);
    else
      return null;
  }

  public void updateFoldingStructure() {
    Annotation[] annotations = projectionAnnotations.keySet().toArray(new Annotation[0]);
    annotationModel.modifyAnnotations(oldAnnotations, projectionAnnotations, null);
    oldAnnotations = annotations;
  }

  @Override
  public void dispose() {
    colorManager.dispose();
    super.dispose();
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T getAdapter(Class<T> adapter) {
    if (IContentOutlinePage.class.equals(adapter)) {
      if (outlinePage == null) {
        outlinePage = new AIEContentOutlinePage(getDocumentProvider(), this);
        if (parsedModule != null)
          outlinePage.refresh(parsedModule);
      }
      return (T) outlinePage;
    }
    return super.getAdapter(adapter);
  }

  public void setModule(Element<ModuleContext> module, boolean refreshOutline) {
    parsedModule = module;
    Display.getDefault().asyncExec(new Runnable() {

      @Override
      public void run() {
        // Update folding positions
        projectionAnnotations.clear();
        calculateFoldingPositions(parsedModule);
        updateFoldingStructure();
        // Refresh the outline
        if (outlinePage != null && refreshOutline)
          outlinePage.refresh(parsedModule);
        handleCursorPositionChanged();
      }
    });
  }

  @SuppressWarnings({"rawtypes"})
  public Element findElement(int line, int offset) {
    return EditorUtils.findElement(parsedModule, line, offset);
  }
}
