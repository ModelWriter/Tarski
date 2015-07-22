package eu.modelwriter.marker.views.propertiesview.internal;

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
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IPropertyDescriptor[] getPropertyDescriptors() {
    IPropertyDescriptor[] ipd = new IPropertyDescriptor[relatedElements.size()];
    for (int i = 0; i < ipd.length; i++) {
      ipd[i] = new PropertyDescriptor(i, "[" + i + "]");
    }
    return ipd;
  }

  @Override
  public Object getPropertyValue(Object id) {
    // ??? It only loops once ???
    for (int i = 0; i < relatedElements.size(); i++) {
      return new DetailPropertySource(relatedElements.get(i));
    }
    return null;
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
