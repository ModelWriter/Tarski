package eu.modelwriter.traceability.validation.editor.base;

import org.eclipse.ui.editors.text.TextEditor;

import eu.modelwriter.traceability.validation.editor.base.document.ValidationDocumentProvider;

public class ValidationEditor extends TextEditor {

  private final ColorManager colorManager;

  public ValidationEditor() {
    super();
    this.colorManager = new ColorManager();
    this.setSourceViewerConfiguration(new ValidationConfiguration(this.colorManager));
    this.setDocumentProvider(new ValidationDocumentProvider());
  }

  @Override
  public void dispose() {
    this.colorManager.dispose();
    super.dispose();
  }
}
