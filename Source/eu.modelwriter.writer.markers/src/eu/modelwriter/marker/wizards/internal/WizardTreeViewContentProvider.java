package eu.modelwriter.marker.wizards.internal;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import eu.modelwriter.marker.internal.MarkerFactory;

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
      try {
        return ((IProject) parentElement).members();
      } catch (CoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else if (parentElement instanceof IFolder)
      try {
        return ((IFolder) parentElement).members();
      } catch (CoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    else if (parentElement instanceof IFile) {
      return MarkerFactory.findAllMarkers((IFile) parentElement).toArray();
    } else {
      return null;
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

    if (element instanceof IProject) {
      try {
        if (((IProject) element).isOpen())
          if (((IProject) element).members().length != 0)
            return true;
          else
            return false;
      } catch (CoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else if (element instanceof IMarker) {
      return false;
    } else if (element instanceof IFolder) {
      try {
        if (((IFolder) element).members().length != 0)
          return true;
        else
          return false;
      } catch (CoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else if (element instanceof IFile)
      if (!((List<IMarker>) (MarkerFactory.findAllMarkers((IFile) element))).isEmpty())
        return true;
      else
        return false;

    return false;
  }

}
