package eu.modelwriter.marker.ui.views.masterview;

import java.net.URL;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkElementUtilities;

public class MasterViewTreeLabelProvider extends LabelProvider {

  private ImageDescriptor mDescriptor =
      getImageDescriptor("org.eclipse.ui", "/icons/full/eview16/tasks_tsk.gif");

  @Override
  public String getText(Object element) {
    if (element instanceof MarkElement) {
      MarkElement markedElement = (MarkElement) element;
      IMarker marked = markedElement.getiMarker();
      return MarkElementUtilities.getMessage(marked);
    } else
      return "Unknown type: " + element.getClass();
  }

  @Override
  public Image getImage(Object element) {
    return mDescriptor.createImage();
  }

  public static ImageDescriptor getImageDescriptor(final String bundleID, final String path) {
    assert(bundleID != null) : "No bundle defined";
    assert(path != null) : "No path defined";

    // if the bundle is not ready then there is no image
    final Bundle bundle = Platform.getBundle(bundleID);
    final int bundleState = bundle.getState();
    if ((bundleState != Bundle.ACTIVE) && (bundleState != Bundle.STARTING)
        && (bundleState != Bundle.RESOLVED))
      return null;

    // look for the image (this will check both the plugin and fragment
    // folders
    final URL imagePath = FileLocator.find(bundle, new Path(path), null);

    if (imagePath != null)
      return ImageDescriptor.createFromURL(imagePath);

    return null;
  }
}
