package eu.modelwriter.core.alloyinecore.ui.editor;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModuleContext;
import eu.modelwriter.core.alloyinecore.structure.Element;
import eu.modelwriter.core.alloyinecore.ui.editor.color.AIEColorManager;
import eu.modelwriter.core.alloyinecore.ui.editor.document.AIEDocumentProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.outline.AIEContentOutlinePage;
import eu.modelwriter.core.alloyinecore.ui.editor.partition.IAIEPartitions;
import eu.modelwriter.core.alloyinecore.ui.editor.util.EditorUtils;

public class AIEEditor extends TextEditor {

  public static final String editorID =
      "eu.modelwriter.core.alloyinecore.ui.editors.AlloyInEcoreEditor";
  public static final String PARSER_ERROR_ANNOTATION_TYPE =
      "eu.modelwriter.core.alloyinecore.ui.editor.parsererror";
  public static final String PARSER_ERROR_MARKER_TYPE =
      "eu.modelwriter.core.alloyinecore.ui.editor.parseerrormarker";

  private final AIEColorManager aIEColorManager;
  private AIEContentOutlinePage outlinePage;
  private Element<ModuleContext> parsedModule;

  public AIEEditor() {
    aIEColorManager = new AIEColorManager();
    setSourceViewerConfiguration(
        new AIESourceViewerConfiguration(aIEColorManager, this, IAIEPartitions.AIE_PARTITIONING));
    setDocumentProvider(new AIEDocumentProvider());
  }

  @Override
  protected void handleCursorPositionChanged() {
    super.handleCursorPositionChanged();
    final String[] cursorPosition = getCursorPosition().split(" : ");
    try {
      final int line = Integer.parseInt(cursorPosition[0]) - 1;
      final int column = Integer.parseInt(cursorPosition[1]) - 1;
      final int offset =
          getDocumentProvider().getDocument(getEditorInput()).getLineOffset(line) + column;
      if (outlinePage != null && offset != outlinePage.getSelectionOffset()) {
        outlinePage.selectElement(findElement(line + 1, offset));
      }
    } catch (final NumberFormatException e) {
      e.printStackTrace();
    } catch (final BadLocationException e) {
      e.printStackTrace();
    }
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
        outlinePage = new AIEContentOutlinePage(getDocumentProvider(), this);
        if (parsedModule != null) {
          outlinePage.refresh(parsedModule);
        }
      }
      return (T) outlinePage;
    }
    return super.getAdapter(adapter);
  }

  public void setModule(final Element<ModuleContext> module, final boolean refreshOutline) {
    parsedModule = module;
    Display.getDefault().asyncExec(new Runnable() {

      @Override
      public void run() {
        if (outlinePage != null && refreshOutline) {
          outlinePage.refresh(parsedModule);
        }
        handleCursorPositionChanged();
      }
    });
  }

  @SuppressWarnings({"rawtypes"})
  public Element findElement(final int line, final int offset) {
    return EditorUtils.findElement(parsedModule, line, offset);
  }
}
