package eu.modelwriter.core.alloyinecore.ui.editor;

import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModuleContext;
import eu.modelwriter.core.alloyinecore.structure.Element;
import eu.modelwriter.core.alloyinecore.ui.outline.AIEContentOutlinePage;

public class AlloyInEcoreEditor extends TextEditor {

  public static final String PARSER_ERROR_ANNOTATION_TYPE =
      "eu.modelwriter.core.alloyinecore.ui.editor.parsererror";
  public static final String PARSER_ERROR_MARKER_TYPE =
      "eu.modelwriter.core.alloyinecore.ui.editor.parseerrormarker";

  private ColorManager colorManager;
  private AIEContentOutlinePage outlinePage;
  private Element<ModuleContext> parsedModule;

  public AlloyInEcoreEditor() {
    colorManager = new ColorManager();
    ViewerConfiguration configuration = new ViewerConfiguration(colorManager, this);
    setSourceViewerConfiguration(configuration);
    setDocumentProvider(new AlloyInEcoreDocumentProvider());
  }

  @Override
  public String getContentDescription() {
    return null;
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
        outlinePage.selectElement(findElement(parsedModule, line + 1, offset));
    } catch (NumberFormatException e) {
      e.printStackTrace();
    } catch (BadLocationException e) {
      e.printStackTrace();
    }
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
        if (outlinePage != null && refreshOutline)
          outlinePage.refresh(parsedModule);
        handleCursorPositionChanged();
      }
    });
  }

  @SuppressWarnings({"rawtypes"})
  public Element findElement(Element element, int line, int offset) {
    for (Object object : element.getOwnedElements()) {
      if (inContext(((Element) object).getContext(), offset)) {
        return findElement((Element) object, line, offset);
      } else if (isSameLine(((Element) object).getContext(), line)) {
        return (Element) object;
      }
    }
    return element;
  }

  public boolean inContext(ParserRuleContext context, int offset) {
    return context.start.getStartIndex() <= offset && (context.stop.getStopIndex() + 1) >= offset;
  }

  private boolean isSameLine(ParserRuleContext context, int line) {
    ParserRuleContext parent = context.getParent();
    // To get ride of wrappers
    parent = parent != null && (parent.start.getStartIndex() == context.start.getStartIndex())
        ? parent.getParent() : parent;
    // if its same line with context and
    // context is not same line with its parent, 'cus we need parent if same line
    return line >= context.start.getLine() && line <= context.stop.getLine()
        && (parent != null && parent.start.getLine() != context.start.getLine());
  }
}
