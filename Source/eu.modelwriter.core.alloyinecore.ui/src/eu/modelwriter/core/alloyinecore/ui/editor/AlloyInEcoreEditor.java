package eu.modelwriter.core.alloyinecore.ui.editor;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.editors.text.TextEditor;

public class AlloyInEcoreEditor extends TextEditor {

  private ColorManager colorManager;

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

  @Override
  protected void initializeEditor() {
    super.initializeEditor();
  }
}
