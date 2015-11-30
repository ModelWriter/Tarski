package eu.modelwriter.marker.ui.internal;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.part.MultiPageEditorPart;

public class MetaModelEditor extends MultiPageEditorPart {
  private TextEditor editor;

  void createPage0() {
    try {
      this.editor = new TextEditor();
      final int index = this.addPage(this.editor, this.getEditorInput());
      this.setPageText(index, this.editor.getTitle());
    } catch (final PartInitException e) {
      ErrorDialog.openError(this.getSite().getShell(), "  Error creating nested text editor", null,
          e.getStatus());
    }
  }

  void createPage1() {

  }

  @Override
  protected void createPages() {
    this.createPage0();
    this.createPage1();
  }

  @Override
  public void doSave(final IProgressMonitor monitor) {
    // nothing
  }

  @Override
  public void doSaveAs() {
    // nothing
  }

  @Override
  public boolean isSaveAsAllowed() {
    // nothing
    return false;
  }


}
