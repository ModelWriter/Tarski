package eu.modelwriter.marker.ui.internal.wizards.mdtoreqifwizard;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.rmf.reqif10.AttributeValue;
import org.eclipse.rmf.reqif10.AttributeValueString;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.Specification;

public class MarkdownToReqifLabelProvider extends LabelProvider {
  @Override
  public String getText(Object element) {
    if (element instanceof IResource) {
      return ((IResource) element).getName();
    } else if (element instanceof Specification) {
      Specification spec = (Specification) element;
      EList<AttributeValue> listOfAttrVal = spec.getValues();
      for (AttributeValue attributeValue : listOfAttrVal) {
        if (attributeValue instanceof AttributeValueString) {
          AttributeValueString attValStr = (AttributeValueString) attributeValue;
          return attValStr.getTheValue();
        }
      }
    } else if (element instanceof SpecHierarchy) {
      SpecHierarchy spec = (SpecHierarchy) element;
      EList<AttributeValue> listOfAttrVal = spec.getObject().getValues();
      for (AttributeValue attributeValue : listOfAttrVal) {
        if (attributeValue instanceof AttributeValueString) {
          AttributeValueString attValStr = (AttributeValueString) attributeValue;
          return attValStr.getTheValue();
        }
      }
    } else {
      return "Unknown type: " + element.getClass();
    }
    return null;
  }
}
