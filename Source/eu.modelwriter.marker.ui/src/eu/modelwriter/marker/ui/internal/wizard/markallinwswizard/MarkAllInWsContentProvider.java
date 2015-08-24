package eu.modelwriter.marker.ui.internal.wizard.markallinwswizard;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class MarkAllInWsContentProvider implements ITreeContentProvider {

  @Override
  public void dispose() {}

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

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
      if (((IProject) parentElement).isOpen()) {
        try {
          return ((IProject) parentElement).members();
        } catch (CoreException e) {
          e.printStackTrace();
        }
      }
    } else if (parentElement instanceof IFolder) {
      try {
        return ((IFolder) parentElement).members();
      } catch (CoreException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @Override
  public Object getParent(Object element) {
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {
    if (element instanceof IProject) {
      try {
        if (((IProject) element).isOpen()) {
          if (((IProject) element).members().length != 0)
            return true;
          else
            return false;
        }
      } catch (CoreException e) {
        e.printStackTrace();
      }
    } else if (element instanceof IFolder) {
      try {
        if (((IFolder) element).members().length != 0)
          return true;
        else
          return false;
      } catch (CoreException e) {
        e.printStackTrace();
      }
    }
    return false;
  }
}
