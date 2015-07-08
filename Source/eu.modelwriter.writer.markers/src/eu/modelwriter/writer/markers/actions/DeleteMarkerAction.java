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

import eu.modelwriter.writer.markers.MarkerActivator;

public class DeleteMarkerAction implements IEditorActionDelegate {

	public DeleteMarkerAction() {
		super();
	}

	@Override
	public void run(IAction action) {
		try {
			TextSelection selection = MarkerFactory.getTextSelection();
			IFile file = (IFile) MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);

			MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark will be deleted by this wizard.",
					null, "\"" + selection.getText() + "\" has been seleceted to be unmarked",
					MessageDialog.INFORMATION, new String[] { "OK" }, 0);
			dialog.open();

			IMarker beDeleted = MarkerFactory.findMarker(file, selection.getOffset());
			if (beDeleted.exists()) {
				beDeleted.delete();
			}

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
