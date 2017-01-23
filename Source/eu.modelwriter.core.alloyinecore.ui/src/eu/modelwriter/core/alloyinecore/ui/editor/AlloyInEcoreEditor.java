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
      int offset = getDocumentProvider().getDocument(getEditorInput())
          .getLineOffset(Integer.parseInt(cursorPosition[0]) - 1);
      offset += Integer.parseInt(cursorPosition[1]) - 1;
      if (offset != outlinePage.getSelectionOffset())
        findAndSelectOutlineElement(offset);
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
          outlinePage.setInput(parsedModule);
      }
      return (T) outlinePage;
    }
    return super.getAdapter(adapter);
  }

  public void setModule(Element<ModuleContext> module) {
    parsedModule = module;
    Display.getDefault().asyncExec(new Runnable() {

      @Override
      public void run() {
        if (outlinePage != null)
          outlinePage.setInput(parsedModule);
      }
    });
  }

  @SuppressWarnings({"rawtypes"})
  public Element findElement(Element element, int offset) {
    for (Object object : element.getOwnedElements()) {
      if (inContext(((Element) object).getContext(), offset)) {
        return findElement((Element) object, offset);
      }
    }
    return element;
  }

  public boolean inContext(ParserRuleContext context, int offset) {
    return context.start.getStartIndex() <= offset && context.stop.getStopIndex() >= offset;
  }

  @SuppressWarnings("rawtypes")
  public void findAndSelectOutlineElement(int offset) {
    Element selectedElement = findElement(parsedModule, offset);
    outlinePage.selectElement(selectedElement);
  }
}
