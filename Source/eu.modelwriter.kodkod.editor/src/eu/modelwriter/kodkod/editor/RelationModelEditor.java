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

  private static Frame frame;
  private static Composite animationEditor;

  public static void addGraphToFrame(final JPanel graph) {
    if (RelationModelEditor.frame == null) {
      RelationModelEditor.frame = SWT_AWT.new_Frame(RelationModelEditor.animationEditor);
    }
    RelationModelEditor.frame.removeAll();
    RelationModelEditor.frame.revalidate();
    graph.revalidate();
    RelationModelEditor.frame.add(graph);
  }

  KodKodEditor kodKodEditor;

  @Override
  protected void createPages() {
    this.kodKodEditor = new KodKodEditor();
    RelationModelEditor.animationEditor = new Composite(this.getContainer(), SWT.EMBEDDED);
    RelationModelEditor.frame = null;

    try {
      int pageIndex = this.addPage(this.kodKodEditor, this.getEditorInput());
      this.setPageText(pageIndex, "Page 1");
      pageIndex = this.addPage(RelationModelEditor.animationEditor);
      this.setPageText(pageIndex, "Page 2");
    } catch (final PartInitException e) {
      e.printStackTrace();
    }
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
