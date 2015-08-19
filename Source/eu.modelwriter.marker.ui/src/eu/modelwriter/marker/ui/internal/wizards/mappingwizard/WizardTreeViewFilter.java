package eu.modelwriter.marker.ui.internal.wizards.mappingwizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import eu.modelwriter.marker.internal.MarkerFactory;

public class WizardTreeViewFilter extends ViewerFilter {

  @Override
  public boolean select(Viewer viewer, Object parentElement, Object element) {

    if (element instanceof IProject) {
      IProject project = (IProject) element;
      if (!project.isOpen() || MarkerFactory.findMarkers(project).isEmpty()) {
        return false;
      }
    } else if (element instanceof IFolder) {
      IFolder folder = (IFolder) element;
      if (MarkerFactory.findMarkers(folder).isEmpty()) {
        return false;
      }
    } else if (element instanceof IFile) {
      IFile file = (IFile) element;
      if (MarkerFactory.findMarkers(file).isEmpty()) {
        return false;
      }
    } else
      return true;
    return true;
  }
}
