package eu.modelwriter.writer.markers.actions;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

import eu.modelwriter.writer.markers.MarkerActivator;

public class DeleteAllMarkerAction implements IEditorActionDelegate {

	public DeleteAllMarkerAction() {
		super();
	}

	@Override
	public void run(IAction action) {
		try {
			TextSelection selection = MarkerFactory.getTextSelection();
			IFile file = (IFile) MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);

			IMarker beDeleted = MarkerFactory.findMarker(file, selection.getOffset());
			String markerText = (String) beDeleted.getAttribute(IMarker.TEXT);
			if (beDeleted.exists()) {
				beDeleted.delete();
			}

			List<IMarker> markers = MarkerFactory.findMarkers(file);

			for (int i = markers.size() - 1; i >= 0; i--) {
				if (markerText.equals(markers.get(i).getAttribute(IMarker.TEXT)))
					markers.get(i).delete();
			}

			MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark will be deleted by this wizard.",
					null, "\"" + markerText + "\" has been seleceted to be unmarked", MessageDialog.INFORMATION,
					new String[] { "OK" }, 0);
			dialog.open();

			ITextEditor editor = MarkerActivator.getEditor();
			IDocumentProvider idp = editor.getDocumentProvider();
			idp.resetDocument(editor.getEditorInput());

		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		// TODO Auto-generated method stub

	}

}
