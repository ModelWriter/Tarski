package eu.modelwriter.core.alloyinecore.ui.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

public class AlloyInEcoreEditor extends TextEditor {

  private ColorManager colorManager;
  private AIEContentOutlinePage outlinePage;

  public AlloyInEcoreEditor() {
    super();
    colorManager = new ColorManager();
    setSourceViewerConfiguration(new ViewerConfiguration(colorManager));
    setDocumentProvider(new AlloyInEcoreDocumentProvider());
  }

  @Override
  public IEditorInput getEditorInput() {
    return super.getEditorInput();
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
        if (getEditorInput() != null)
          outlinePage.setInput(getEditorInput());
      }
      return (T) outlinePage;
    }
    return super.getAdapter(adapter);
  }

  @Override
  public void doSave(IProgressMonitor progressMonitor) {
    super.doSave(progressMonitor);
    // TODO update outline page?
  }

}
