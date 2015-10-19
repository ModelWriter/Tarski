package eu.modelwriter.marker.ui.internal.wizards.creatingatomwizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE.SharedImages;

import eu.modelwriter.marker.internal.MarkUtilities;

public class CreatingAtomWizardLabelProvider extends LabelProvider {

  @Override
  public Image getImage(Object element) {
    if (element instanceof IProject) {
      if (((IProject) element).isOpen()) {
        return PlatformUI.getWorkbench().getSharedImages().getImage(SharedImages.IMG_OBJ_PROJECT);
      } else {
        return PlatformUI.getWorkbench().getSharedImages()
            .getImage(SharedImages.IMG_OBJ_PROJECT_CLOSED);
      }
    } else if (element instanceof IFolder) {
      return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
    } else if (element instanceof IFile) {
      return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
    } else if (element instanceof IMarker) {
      return PlatformUI.getWorkbench().getSharedImages().getImage(SharedImages.IMG_OPEN_MARKER);
    }

    return null;
  }

  @Override
  public String getText(Object element) {
    if (element instanceof IResource) {
      IResource iResource = (IResource) element;
      return iResource.getName();
    } else if (element instanceof IMarker) {
      IMarker iMarker = (IMarker) element;
      return MarkUtilities.getText(iMarker);
    } else {
      return "Unknown type: " + element.getClass();
    }
  }
}
