package eu.modelwriter.marker.model.decorators;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;

import eu.modelwriter.marker.internal.FileDecorator;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.xml.XMLDOMHelper;

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
      if (iResource == null)
        return;

      String xpath = XMLDOMHelper.findNodeAndGetXPath(namedElement.getName(),
          iResource.getLocation().toFile().getAbsolutePath());
      IMarker marker = MarkerFactory.findMarkerByXpath(iResource, xpath);
      if (marker != null) {
        decoration.addOverlay(ImageDescriptor.createFromFile(FileDecorator.class, ICON),
            IDecoration.BOTTOM_RIGHT);
        decoration.setForegroundColor(color);
        // EClass or EDataType
        if (namedElement instanceof EClassifier) {
          System.out.println("Classifier: " + namedElement.getName());
          EClassifier eC = (EClassifier) namedElement;
          System.out.println(eC.getEPackage().getNsURI());
          System.out.println(eC.getClassifierID());
        }
        if (namedElement instanceof EStructuralFeature) {
          System.out.println("Structural Feature: " + namedElement.getName());
          EStructuralFeature eS = (EStructuralFeature) namedElement;
          System.out.println(eS.getEContainingClass().getName());
          System.out.println(eS.getFeatureID());
        }
      }
    }
  }
}
