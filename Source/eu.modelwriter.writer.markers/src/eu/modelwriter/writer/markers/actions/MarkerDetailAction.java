package eu.modelwriter.writer.markers.actions;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

import eu.modelwriter.writer.markers.MarkerActivator;
import eu.modelwriter.writer.markers.views.MappingView;

public class MarkerDetailAction implements IEditorActionDelegate {

	@Override
	public void run(IAction action) {
		TextSelection selection = MarkerFactory.getTextSelection();
		IFile file = (IFile) MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);

		IMarker beMapped = MarkerFactory.findMarker(file, selection.getOffset());
		ArrayList<MarkElement> markedElements = null;
		try {
			if (beMapped != null) {
				markedElements = Serialization.getInstance()
						.fromString((String) beMapped.getAttribute(MarkElement.getAttributeName()));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (markedElements != null) {
			MappingView.setColumns(markedElements);
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
