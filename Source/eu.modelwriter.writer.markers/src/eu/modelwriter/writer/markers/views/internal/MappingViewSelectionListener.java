package eu.modelwriter.writer.markers.views.internal;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;

public class MappingViewSelectionListener implements ISelectionListener {
	private Viewer viewer;
	private IWorkbenchPart part;

	public MappingViewSelectionListener(Viewer v, IWorkbenchPart p) {
		this.viewer = v;
		this.part = p;
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// if (part != this.part) {
		// Object selected = ((IStructuredSelection)
		// selection).getFirstElement();
		// Object current = ((IStructuredSelection)
		// viewer.getSelection()).getFirstElement();
		// if (selected != current /* && selected instanceof IMarker */) {
		// viewer.setSelection(selection);
		// if (viewer instanceof StructuredViewer) {
		// ((StructuredViewer) viewer).reveal(selected);
		// }
		// }
		// }
	}

}
