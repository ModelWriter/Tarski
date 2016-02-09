package eu.modelwriter.kodkod.editor;

import java.awt.Frame;

import javax.swing.JPanel;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.part.MultiPageEditorPart;

import eu.modelwriter.kodkod.editor.manager.SynchronizationManager;

public class RelationModelEditor extends MultiPageEditorPart {

  private class KodKodEditor extends TextEditor {

    private final ColorManager colorManager;

    public KodKodEditor() {
      super();
      this.colorManager = new ColorManager();
      this.setSourceViewerConfiguration(
          new RelationModelEditorSourceViewerConfiguration(this.colorManager));
      this.setDocumentProvider(new RelationModelDocumentProvider());
    }

    @Override
    public void dispose() {
      this.colorManager.dispose();
      super.dispose();
    }
  }

  private Frame frame;

  @Override
  protected void createPages() {
    final KodKodEditor kodKodEditor = new KodKodEditor();
    final Composite animationEditor = new Composite(this.getContainer(), SWT.EMBEDDED);
    this.frame = null;

    try {
      int pageIndex = this.addPage(kodKodEditor, this.getEditorInput());
      this.setPageText(pageIndex, "Page 1");
      pageIndex = this.addPage(animationEditor);
      this.setPageText(pageIndex, "Page 2");
    } catch (final PartInitException e) {
      e.printStackTrace();
    }

    final SynchronizationManager manager = new SynchronizationManager();
    final JPanel graph = manager.getEditorInputFromVis(
        kodKodEditor.getDocumentProvider().getDocument(kodKodEditor.getEditorInput()));
    if (this.frame == null) {
      this.frame = SWT_AWT.new_Frame(animationEditor);
    }
    this.frame.add(graph);
  }

  @Override
  public void doSave(final IProgressMonitor monitor) {
    final IEditorPart editor = this.getActiveEditor();
    if (editor instanceof KodKodEditor) {
      editor.doSave(monitor);
    } else {
      // do nothing
    }
  }

  @Override
  public void doSaveAs() {
    // do nothing
  }

  @Override
  public boolean isSaveAsAllowed() {
    return false;
  }
}
