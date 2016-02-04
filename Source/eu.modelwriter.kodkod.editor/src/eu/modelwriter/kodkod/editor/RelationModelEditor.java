package eu.modelwriter.kodkod.editor;

import org.eclipse.ui.editors.text.TextEditor;

public class RelationModelEditor extends TextEditor {

	private ColorManager colorManager;

	public RelationModelEditor() {
		super();
		colorManager = new ColorManager();
		this.setSourceViewerConfiguration(new RelationModelEditorSourceViewerConfiguration(colorManager));
		this.setDocumentProvider(new RelationModelDocumentProvider());
	}

	@Override
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}
}
