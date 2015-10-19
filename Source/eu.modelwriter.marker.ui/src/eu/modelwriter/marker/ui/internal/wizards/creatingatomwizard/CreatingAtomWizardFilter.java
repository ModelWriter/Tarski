package eu.modelwriter.marker.ui.internal.wizards.creatingatomwizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class CreatingAtomWizardFilter extends ViewerFilter {

  @Override
  public boolean select(Viewer viewer, Object parentElement, Object element) {
    if (element instanceof IProject) {
      IProject iProject = (IProject) element;
      try {
        if (iProject.isOpen() && iProject.members().length != 0
            && !MarkerFactory.findUntypedMarkers(iProject).isEmpty()) {
          return true;
        }
      } catch (CoreException e) {
        e.printStackTrace();
      }
      return false;
    } else if (element instanceof IFolder) {
      IFolder iFolder = (IFolder) element;
      try {
        if (iFolder.members().length != 0 && !MarkerFactory.findUntypedMarkers(iFolder).isEmpty()) {
          return true;
        }
      } catch (CoreException e) {
        e.printStackTrace();
      }
      return false;
    } else if (element instanceof IFile) {
      IFile iFile = (IFile) element;
      if (!MarkerFactory.findUntypedMarkers(iFile).isEmpty()) {
        return true;
      }
      return false;
    } else if (element instanceof IMarker) {
      IMarker iMarker = (IMarker) element;
      if (MarkUtilities.getType(iMarker) == null) {
        return true;
      }
      return false;
    }
    return false;
  }
}
