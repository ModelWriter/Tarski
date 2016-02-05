package eu.modelwriter.traceability.validation.core.crocopat.editor;

import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.editors.text.TextEditor;

public class RelationModelEditor extends TextEditor {
	@Override
	protected boolean affectsTextPresentation(final PropertyChangeEvent event) {
		return super.affectsTextPresentation(event);
	}

	@Override
	protected void initializeEditor() {
		super.initializeEditor();
		this.setSourceViewerConfiguration(new RelationModelEditorSourceViewerConfiguration());
		this.setDocumentProvider(new RelationModelDocumentProvider());
	}
}
