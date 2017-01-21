package eu.modelwriter.core.alloyinecore.ui.editor;

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
    super();
    colorManager = new ColorManager();
    setSourceViewerConfiguration(new ViewerConfiguration(colorManager, this));
    setDocumentProvider(new AlloyInEcoreDocumentProvider());
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
}
