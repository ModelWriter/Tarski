package eu.modelwriter.marker.ui.internal.wizards.mdtoreqifwizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.Specification;

public class MarkdownToReqifFilter extends ViewerFilter {

  @Override
  public boolean select(Viewer viewer, Object parentElement, Object element) {
    if (element instanceof IProject) {
      IProject iProject = (IProject) element;
      if (!iProject.isOpen()) {
        return false;
      } else {
        try {
          for (IResource iResource : iProject.members()) {
            if ((iResource.getType() == IResource.FILE) && (iResource.getFileExtension() != null)
                && iResource.getFileExtension().equals("reqif")) {
              return true;
            }
          }
          return false;
        } catch (CoreException e) {
          e.printStackTrace();
        }
      }
    } else if (element instanceof IFolder) {
      IFolder iFolder = (IFolder) element;
      try {
        for (IResource iResource : iFolder.members()) {
          if ((iResource.getType() == IResource.FILE) && (iResource.getFileExtension() != null)
              && iResource.getFileExtension().equals("reqif")) {
            return true;
          }
        }
        return false;
      } catch (CoreException e) {
        e.printStackTrace();
      }
    } else if (element instanceof IFile) {
      IFile iFile = (IFile) element;
      if ((iFile.getFileExtension() != null) && iFile.getFileExtension().equals("reqif")) {
        return true;
      }
    } else if (element instanceof Specification) {
      return true;
    } else if (element instanceof SpecHierarchy) {
      return true;
    }
    return false;
  }
}
