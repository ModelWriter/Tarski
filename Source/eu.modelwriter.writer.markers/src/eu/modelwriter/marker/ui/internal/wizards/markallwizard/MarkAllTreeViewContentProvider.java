package eu.modelwriter.marker.ui.internal.wizards.markallwizard;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class MarkAllTreeViewContentProvider implements ITreeContentProvider {

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

    try {
      if (parentElement instanceof IProject) {
        return ((IProject) parentElement).members();
      } else if (parentElement instanceof IFolder) {
        return ((IFolder) parentElement).members();
      } else {
        return null;
      }
    } catch (CoreException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Object getParent(Object element) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {

    try {
      if (element instanceof IProject) {
        if (((IProject) element).isOpen())
          if (((IProject) element).members().length != 0)
            return true;
          else
            return false;
      } else if (element instanceof IFolder) {
        if (((IFolder) element).members().length != 0)
          return true;
        else
          return false;
      } else
        return false;
    } catch (CoreException e) {
      e.printStackTrace();
    }
    return false;
  }
}
