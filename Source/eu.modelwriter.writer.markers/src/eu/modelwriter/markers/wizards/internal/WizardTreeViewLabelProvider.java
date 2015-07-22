package eu.modelwriter.markers.wizards.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE.SharedImages;

public class WizardTreeViewLabelProvider extends LabelProvider {

  // Label provider state: preserve case of file names/directories
  boolean preserveCase;
  // The listeners
  private List<ILabelProviderListener> listeners = new ArrayList<ILabelProviderListener>();

  @Override
  public String getText(Object element) {

    if (element instanceof IResource) {
      return ((IResource) element).getName();
    } else if (element instanceof IMarker) {
      try {
        return (String) ((IMarker) element).getAttribute(IMarker.MESSAGE);
      } catch (CoreException e) {
        e.printStackTrace();
      }
    } else {
      return "Unknown type: " + element.getClass();
    }
    return null;

  }

  /**
   * Sets the preserve case attribute
   * 
   * @param preserveCase the preserve case attribute
   */
  public void setPreserveCase(boolean preserveCase) {
    this.preserveCase = preserveCase;

    // Since this attribute affects how the labels are computed,
    // notify all the listeners of the change.
    LabelProviderChangedEvent event = new LabelProviderChangedEvent(this);
    for (int i = 0, n = listeners.size(); i < n; i++) {
      ILabelProviderListener ilpl = listeners.get(i);
      ilpl.labelProviderChanged(event);
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
    else if (element instanceof IMarker)
      return PlatformUI.getWorkbench().getSharedImages().getImage(SharedImages.IMG_OPEN_MARKER);

    return null;

  }

}
