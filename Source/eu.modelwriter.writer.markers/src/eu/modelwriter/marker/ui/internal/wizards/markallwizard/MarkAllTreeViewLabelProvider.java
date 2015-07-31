package eu.modelwriter.marker.ui.internal.wizards.markallwizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE.SharedImages;

public class MarkAllTreeViewLabelProvider extends LabelProvider {

  @Override
  public String getText(Object element) {
    
    if (element instanceof IResource){
      return ((IResource) element).getName();
    }else {
      return "Unknown type: " + element.getClass();
    }
  }
  
  @Override
  public Image getImage(Object element) {
    if (element instanceof IProject)
      if (((IProject) element).isOpen())
        return PlatformUI.getWorkbench().getSharedImages().getImage(SharedImages.IMG_OBJ_PROJECT);
      else
        return PlatformUI.getWorkbench().getSharedImages()
            .getImage(SharedImages.IMG_OBJ_PROJECT_CLOSED);
    else if (element instanceof IFolder)
      return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
    else if (element instanceof IFile)
      return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);

    return null;

  }
}
