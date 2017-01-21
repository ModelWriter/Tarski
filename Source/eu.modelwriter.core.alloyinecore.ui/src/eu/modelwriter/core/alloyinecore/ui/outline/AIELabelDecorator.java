package eu.modelwriter.core.alloyinecore.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

import eu.modelwriter.core.alloyinecore.structure.IVisibility;
import eu.modelwriter.core.alloyinecore.structure.Visibility;
import eu.modelwriter.core.alloyinecore.ui.Activator;

public class AIELabelDecorator implements ILightweightLabelDecorator {

  @Override
  public void addListener(ILabelProviderListener listener) {}

  @Override
  public void dispose() {}

  @Override
  public boolean isLabelProperty(Object element, String property) {
    return true;
  }

  @Override
  public void removeListener(ILabelProviderListener listener) {}

  @SuppressWarnings("rawtypes")
  @Override
  public void decorate(Object element, IDecoration decoration) {
    decoration.addSuffix(" asdsa");
    // Add multiplicity overlay
    boolean mulOverlay = false;
    if (element instanceof eu.modelwriter.core.alloyinecore.structure.Object) {
      EObject eObject = ((eu.modelwriter.core.alloyinecore.structure.Object) element).getEObject();
      if (eObject instanceof ETypedElement) {
        ETypedElement typedElement = (ETypedElement) eObject;
        String overlayName = getOverlayName(typedElement);
        ImageDescriptor overlayDesc =
            Activator.getDefault().getImageRegistry().getDescriptor(overlayName);
        if (mulOverlay = (overlayDesc != null))
          decoration.addOverlay(overlayDesc, IDecoration.BOTTOM_RIGHT);
      }
    }
    // Add visibility overlay
    if (element instanceof IVisibility) {
      Visibility visibility = ((IVisibility) element).getVisibility();
      String overlayName = visibility.name().toString();
      ImageDescriptor overlayDesc =
          Activator.getDefault().getImageRegistry().getDescriptor(overlayName);
      if (overlayDesc != null)
        decoration.addOverlay(overlayDesc,
            mulOverlay ? IDecoration.TOP_LEFT : IDecoration.BOTTOM_RIGHT);
    }
  }

  private String getOverlayName(ETypedElement typedElement) {
    String overlayName = "EOccurrence";
    String lower = "";
    String upper = "";
    if (typedElement.getLowerBound() == 0)
      lower = "Zero";
    else if (typedElement.getLowerBound() == 1)
      lower = "One";
    else if (typedElement.getLowerBound() != 0 && typedElement.getLowerBound() != 1)
      lower = "N";

    if (typedElement.getUpperBound() == -1)
      upper = "Unbounded";
    else if (typedElement.getUpperBound() == -2)
      upper = "Unspecified";
    else if (typedElement.getUpperBound() == 1)
      upper = "One";
    else if (typedElement.getUpperBound() != -1 && typedElement.getUpperBound() != 1
        && typedElement.getUpperBound() != -2)
      upper = "M";

    if (typedElement.getLowerBound() == typedElement.getUpperBound()) {
      overlayName += lower;
    } else {
      overlayName += lower + "To" + upper;
    }
    return overlayName;
  }

}
