package eu.modelwriter.kodkod.editor;

import org.eclipse.ui.editors.text.TextEditor;

public class RelationModelEditor extends TextEditor {

  private final ColorManager colorManager;

  public RelationModelEditor() {
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

  // @Override
  // public void doSave(final IProgressMonitor progressMonitor) {
  // try {
  // UniverseCreator.create();
  // } catch (final BadLocationException e) {
  // e.printStackTrace();
  // }
  // super.doSave(progressMonitor);
  // }
}
