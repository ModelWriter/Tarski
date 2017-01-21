package eu.modelwriter.core.alloyinecore.ui.outline;

import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

import eu.modelwriter.core.alloyinecore.structure.Element;
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
    // Add suffix
    decoration.addSuffix(((Element) element).getSuffix());
    // Add visibility overlay
    if (element instanceof IVisibility) {
      Visibility visibility = ((IVisibility) element).getVisibility();
      String overlayName = visibility.name().toString();
      decorate(decoration, overlayName, IDecoration.BOTTOM_RIGHT);
    }
  }

  private void decorate(IDecoration decoration, String overlayName, int position) {
    ImageDescriptor overlayDesc =
        Activator.getDefault().getImageRegistry().getDescriptor(overlayName);
    if (overlayDesc != null)
      decoration.addOverlay(overlayDesc, IDecoration.BOTTOM_RIGHT);
  }

  @SuppressWarnings("unused")
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
