package eu.modelwriter.writer.markers.wizards.internal;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import eu.modelwriter.writer.markers.actions.MarkerFactory;

public class WizardTreeViewContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object inputElement) {

		if (inputElement instanceof Object[]) {
			return (Object[]) inputElement;
		} else {
			return new Object[0];
		}

	}

	@Override
	public Object[] getChildren(Object parentElement) {

		if (parentElement instanceof IProject) {
			return MarkerFactory.findAllMarkers((IProject) parentElement)
					.toArray();

		} else {
			return null;
		}
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {

		if (element instanceof IProject) {
			return ((IProject) element).exists();
		} else if (element instanceof IMarker) {
			return false;
		}

		return false;
	}

}
