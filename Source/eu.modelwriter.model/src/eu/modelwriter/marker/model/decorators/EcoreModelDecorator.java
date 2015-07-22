package eu.modelwriter.marker.model.decorators;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;

import eu.modelwriter.markers.internal.FileDecorator;
import eu.modelwriter.markers.internal.MarkerFactory;
import eu.modelwriter.writer.xml.XMLDOMHelper;

public class EcoreModelDecorator extends LabelProvider implements ILightweightLabelDecorator {

  public static final String ICON = "/icons/Black.gif";
  private static Color color = new Color(null, 255, 192, 0);

  @Override
  public void decorate(Object resource, IDecoration decoration) {

    if (resource instanceof ENamedElement) {
      ENamedElement namedElement = (ENamedElement) resource;
      Resource eResource = namedElement.eResource();
      if (eResource == null)
        return;
      URI eUri = eResource.getURI();
      IResource iResource = null;
      if (eUri.isPlatformResource()) {
        String platformString = eUri.toPlatformString(true);
        iResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
      }

      String xpath = XMLDOMHelper.findNodeAndGetXPath(namedElement.getName(),
          iResource.getLocation().toFile().getAbsolutePath());
      IMarker marker = MarkerFactory.findMarkerByXpath(iResource, xpath);
      if (marker != null) {
        decoration.addOverlay(ImageDescriptor.createFromFile(FileDecorator.class, ICON),
            IDecoration.BOTTOM_RIGHT);
        decoration.setForegroundColor(color);
      }
    }
  }
}
