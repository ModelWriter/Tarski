package eu.modelwriter.marker.ui.internal.wizards.markerwizard;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerTypeElement;

public class MarkerTreeViewLabelProvider extends LabelProvider {

  @Override
  public Image getImage(Object element) {
    ImageRegistry imageRegistry = MarkerActivator.getDefault().getImageRegistry();
    return imageRegistry.get(MarkerActivator.Images.IMAGE_SIG_ID);

  }

  @Override
  public String getText(Object element) {
    if (element instanceof MarkerTypeElement) {
      MarkerTypeElement typeElement = (MarkerTypeElement) element;
      return typeElement.getType();
    }
    return null;
  }
}
