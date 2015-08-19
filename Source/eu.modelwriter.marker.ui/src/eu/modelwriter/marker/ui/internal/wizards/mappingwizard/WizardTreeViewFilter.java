package eu.modelwriter.marker.ui.internal.wizards.mappingwizard;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import eu.modelwriter.marker.internal.MarkerFactory;

public class WizardTreeViewFilter extends ViewerFilter {

  @Override
  public boolean select(Viewer viewer, Object parentElement, Object element) {

    if (element instanceof IProject) {
      IProject project = (IProject) element;
      if (!project.isOpen()) {
        return false;
      } else {
        List<IMarker> list = MarkerFactory.findMarkers(project);
        if (list.isEmpty()
            || (list.size() == 1 && list.get(0).equals(MappingWizard.selectedMarker))) {
          return false;
        }
      }
    } else if (element instanceof IFolder) {
      IFolder folder = (IFolder) element;
      List<IMarker> list = MarkerFactory.findMarkers(folder);
      if (list.isEmpty()
          || (list.size() == 1 && list.get(0).equals(MappingWizard.selectedMarker))) {
        return false;
      }
    } else if (element instanceof IFile) {
      IFile file = (IFile) element;
      List<IMarker> list = MarkerFactory.findMarkers(file);
      if (list.isEmpty()
          || (list.size() == 1 && list.get(0).equals(MappingWizard.selectedMarker))) {
        return false;
      }
    } else
      return true;
    return true;
  }
}
