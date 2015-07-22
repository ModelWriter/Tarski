package eu.modelwriter.marker.ui.internal.views.propertiesview;

import java.util.ArrayList;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

import eu.modelwriter.marker.internal.MarkElement;

public class RelatedElementPropertySource implements IPropertySource {
  private ArrayList<MarkElement> relatedElements = null;

  public RelatedElementPropertySource(ArrayList<MarkElement> relatedElements) {
    this.relatedElements = relatedElements;
  }

  @Override
  public Object getEditableValue() {
    return null;
  }

  @Override
  public IPropertyDescriptor[] getPropertyDescriptors() {
    if (relatedElements == null || relatedElements.isEmpty()) {
      return new IPropertyDescriptor[] {};
    } else {
      IPropertyDescriptor[] ipd = new IPropertyDescriptor[relatedElements.size()];
      for (int i = 0; i < ipd.length; i++) {
        ipd[i] = new PropertyDescriptor(i, "[" + i + "]");
      }
      return ipd;
    }
  }

  @Override
  public Object getPropertyValue(Object id) {
    return new DetailPropertySource(relatedElements.get(Integer.parseInt(id.toString())));
  }

  @Override
  public boolean isPropertySet(Object id) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void resetPropertyValue(Object id) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setPropertyValue(Object id, Object value) {
    // TODO Auto-generated method stub

  }
}
