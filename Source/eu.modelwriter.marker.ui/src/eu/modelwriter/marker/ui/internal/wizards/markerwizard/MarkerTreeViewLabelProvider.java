package eu.modelwriter.marker.ui.internal.wizards.markerwizard;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

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
