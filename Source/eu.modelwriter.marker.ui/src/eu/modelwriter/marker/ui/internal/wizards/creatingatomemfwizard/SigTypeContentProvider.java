package eu.modelwriter.marker.ui.internal.wizards.creatingatomemfwizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import eu.modelwriter.marker.internal.MarkerFactory;

public class SigTypeContentProvider implements ITreeContentProvider {

  @Override
  public void dispose() {}

  @Override
  public Object[] getChildren(Object parentElement) {
    if (parentElement instanceof IProject) {
      IProject iProject = (IProject) parentElement;
      try {
        return iProject.members();
      } catch (CoreException e) {
        e.printStackTrace();
      }
    } else if (parentElement instanceof IFolder) {
      IFolder iFolder = (IFolder) parentElement;
      try {
        return iFolder.members();
      } catch (CoreException e) {
        e.printStackTrace();
      }
    } else if (parentElement instanceof IFile) {
      IFile iFile = (IFile) parentElement;
      return MarkerFactory.findUntypedMarkers(iFile).toArray();
    } else {
      return null;
    }
    return null;
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
  public Object getParent(Object element) {
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {
    if (element instanceof IResource) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
}
