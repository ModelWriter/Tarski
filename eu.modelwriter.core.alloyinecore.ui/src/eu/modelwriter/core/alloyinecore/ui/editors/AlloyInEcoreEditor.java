package eu.modelwriter.core.alloyinecore.ui.editors;

import org.eclipse.ui.editors.text.TextEditor;

public class AlloyInEcoreEditor extends TextEditor {

  private ColorManager colorManager;

  public AlloyInEcoreEditor() {
    super();
    colorManager = new ColorManager();
    setSourceViewerConfiguration(new DocConfiguration(colorManager));
    setDocumentProvider(new DocumentProvider());
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
