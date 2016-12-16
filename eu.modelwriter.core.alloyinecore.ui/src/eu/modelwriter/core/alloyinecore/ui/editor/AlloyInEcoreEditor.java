package eu.modelwriter.core.alloyinecore.ui.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.editors.text.TextEditor;

import eu.modelwriter.core.alloyinecore.ui.model.AlloyInEcoreDocument;

public class AlloyInEcoreEditor extends TextEditor {

  private ColorManager colorManager;

  public AlloyInEcoreEditor() {
    super();
    colorManager = new ColorManager();
    setSourceViewerConfiguration(new ViewerConfiguration(colorManager));
    setDocumentProvider(new DocumentProvider());
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

  @Override
  public void doSave(IProgressMonitor progressMonitor) {
    DocumentProvider documentProvider = (DocumentProvider) getDocumentProvider();
    AlloyInEcoreDocument document = (AlloyInEcoreDocument) documentProvider.getDocument();
    boolean success = document.saveInEcore();
    if (success) {
      progressMonitor.done();
    }
  }

}
