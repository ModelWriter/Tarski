package eu.modelwriter.core.alloyinecore.ui.editor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.CommonToken;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.ui.ASTChangeListener;
import eu.modelwriter.core.alloyinecore.ui.ASTManager;
import eu.modelwriter.core.alloyinecore.ui.Activator;
import eu.modelwriter.core.alloyinecore.ui.editor.color.AIEColorManager;
import eu.modelwriter.core.alloyinecore.ui.editor.document.AIEDocument;
import eu.modelwriter.core.alloyinecore.ui.editor.document.AIEDocumentProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.outline.AIEContentOutlinePage;
import eu.modelwriter.core.alloyinecore.ui.editor.partition.IAIEPartitions;
import eu.modelwriter.core.alloyinecore.ui.editor.util.EditorUtils;

public class AIEEditor extends TextEditor implements ASTChangeListener {

  public static final String editorID =
      "eu.modelwriter.core.alloyinecore.ui.editors.AlloyInEcoreEditor";

  public static final String PARSER_ERROR_ANNOTATION =
      "eu.modelwriter.core.alloyinecore.ui.editor.parsererror";
  public static final String TYPE_ERROR_ANNOTATION =
      "eu.modelwriter.core.alloyinecore.ui.editor.typererror";
  public static final String TYPE_WARNING_ANNOTATION =
      "eu.modelwriter.core.alloyinecore.ui.editor.typewarning";
  public static final String PARSER_ERROR_MARKER =
      "eu.modelwriter.core.alloyinecore.ui.editor.parseerrormarker";

  @SuppressWarnings("rawtypes")
  protected Element rootElement;
  protected AIEColorManager aIEColorManager;
  private AIEContentOutlinePage outlinePage;
  private ProjectionAnnotationModel annotationModel;
  private Annotation[] oldAnnotations;
  protected HashMap<ProjectionAnnotation, Position> projectionAnnotations =
      new HashMap<ProjectionAnnotation, Position>();
  @SuppressWarnings("rawtypes")
  private HashMap<Element, ProjectionAnnotation> element2anno =
      new HashMap<Element, ProjectionAnnotation>();

  public AIEEditor() {
    aIEColorManager = new AIEColorManager();
    getManagerForEditor().addChangeListener(this);
    initEditor();
  }

  protected void initEditor() {
    setSourceViewerConfiguration(
        new AIESourceViewerConfiguration(aIEColorManager, this, IAIEPartitions.AIE_PARTITIONING));
    setDocumentProvider(new AIEDocumentProvider());
  }

  @SuppressWarnings("rawtypes")
  public Element getRootElement() {
    return rootElement;
  }

  @Override
  protected ISourceViewer createSourceViewer(final Composite parent, final IVerticalRuler ruler,
      final int styles) {
    final ISourceViewer viewer =
        new ProjectionViewer(parent, ruler, getOverviewRuler(), isOverviewRulerVisible(), styles);
    // ensure decoration support has been created and configured.
    getSourceViewerDecorationSupport(viewer);
    return viewer;
  }

  @Override
  public void createPartControl(final Composite parent) {
    super.createPartControl(parent);
    final ProjectionViewer projectionViewer = (ProjectionViewer) getSourceViewer();

    // final ProjectionSupport projectionSupport =
    // new ProjectionSupport(projectionViewer, getAnnotationAccess(), getSharedColors());
    // projectionSupport.install();

    // turn projection mode on
    // projectionViewer.doOperation(ProjectionViewer.TOGGLE);

    annotationModel = projectionViewer.getProjectionAnnotationModel();
  }

  @Override
  protected void handleCursorPositionChanged() {
    super.handleCursorPositionChanged();
    try {
      final String[] cursorPosition = getCursorPosition().split(" : ");
      final int line = Integer.parseInt(cursorPosition[0]) - 1;
      final int column = Integer.parseInt(cursorPosition[1]) - 1;
      final int offset =
          getDocumentProvider().getDocument(getEditorInput()).getLineOffset(line) + column;
      if (outlinePage != null && offset != outlinePage.getSelectionOffset()) {
        outlinePage.selectElement(findElement(line + 1, offset));
      }
    } catch (final NumberFormatException | ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
    } catch (final BadLocationException e) {
      e.printStackTrace();
    }
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  protected void calculateFoldingPositions(final Element element) {
    List<Element> ownedElements = element.getOwnedElements();
    for (Element ownedElement : ownedElements) {
      Position position = getFoldablePosition(ownedElement);
      if (position != null) {
        ProjectionAnnotation prevAnno = element2anno.get(ownedElement);
        ProjectionAnnotation annotation = new ProjectionAnnotation();
        if (prevAnno != null && prevAnno.isCollapsed()) {
          annotation.markCollapsed();
        }
        projectionAnnotations.put(annotation, position);
        element2anno.put(ownedElement, annotation);
      }
      calculateFoldingPositions(ownedElement);
    }
  }

  @SuppressWarnings("rawtypes")
  private Position getFoldablePosition(final Element element) {
    int startIndex = element.getContext().getStart().getStartIndex();
    // find last token
    CommonToken lastToken = null;
    for (int i = element.getContext().getChildCount() - 1; i >= 0; i--) {
      if (element.getContext().getChild(i).getPayload() instanceof CommonToken) {
        lastToken = (CommonToken) element.getContext().getChild(i).getPayload();
        break;
      }
    }
    try {
      if (lastToken != null && lastToken.getLine() != element.getLine()) {
        IDocument document = getDocumentProvider().getDocument(getEditorInput());
        int stopLine = document.getLineOfOffset(lastToken.getStopIndex());
        int lineSize = document.getNumberOfLines() - 1;
        int lenght = document.getLineOffset(lineSize > (stopLine + 1) ? (stopLine + 1) : stopLine)
            - startIndex;
        return new Position(startIndex, lenght);
      }
    } catch (BadLocationException e) {
      e.printStackTrace();
    }
    return null;
  }

  public void updateFoldingStructure() {
    final Annotation[] annotations = projectionAnnotations.keySet().toArray(new Annotation[0]);
    annotationModel.modifyAnnotations(oldAnnotations, projectionAnnotations, null);
    oldAnnotations = annotations;
  }

  @Override
  public void dispose() {
    aIEColorManager.dispose();
    super.dispose();
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T getAdapter(final Class<T> adapter) {
    if (IContentOutlinePage.class.equals(adapter)) {
      if (outlinePage == null) {
        outlinePage = new AIEContentOutlinePage(getDocumentProvider(), this, getManagerForEditor());
        if (rootElement != null) {
          outlinePage.refresh(rootElement);
        }
      }
      return (T) outlinePage;
    }
    return super.getAdapter(adapter);
  }

  protected ASTManager getManagerForEditor() {
    return Activator.getDefault().getModelManager();
  }

  @SuppressWarnings({"rawtypes"})
  public Element findElement(final int line, final int offset) {
    return EditorUtils.findElement(rootElement, line, offset);
  }

  public EcoreEditor openEcoreEditor() {
    try {
      IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
      if (page != null) {
        return (EcoreEditor) page.openEditor(getEditorInput(),
            "org.eclipse.emf.ecore.presentation.EcoreEditorID", true,
            IWorkbenchPage.MATCH_ID | IWorkbenchPage.MATCH_INPUT);
      }
    } catch (WorkbenchException e) {
      e.printStackTrace();
    }
    return null;
  }

  public void openEcoreEditorAndReveal(EObject eObject) {
    AIEDocument document = (AIEDocument) getDocumentProvider().getDocument(getEditorInput());
    EObject realEObject = EcoreUtil.getEObject(document.getEcoreRoot(),
        EcoreUtil.getURI(eObject).fragment().replace("//", ""));
    EcoreEditor ecoreEditor = openEcoreEditor();

    if (ecoreEditor != null) {
      ArrayList<Object> arrayList = new ArrayList<>();
      arrayList.add(realEObject);
      ecoreEditor.setSelectionToViewer(arrayList);
    }
  }

  @SuppressWarnings("rawtypes")
  @Override
  public void onASTChange(Element model) {
    this.rootElement = model;
    Display.getDefault().asyncExec(new Runnable() {

      @Override
      public void run() {
        // Update folding positions
        projectionAnnotations.clear();
      }
    });
  }
}
