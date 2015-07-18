package eu.modelwriter.writer.markers.views.propertiesview.internal;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

import eu.modelwriter.writer.markers.internal.MarkElement;

public class DetailPropertySource implements IPropertySource {
  private MarkElement marker;
  private static final Object ID = new Object();
  private static final Object LENGTH = new Object();
  private static final Object LINE_NUMBER = new Object();
  private static final Object OFFSET = new Object();
  private static final Object PATH = new Object();
  private static final Object TEXT = new Object();

  public DetailPropertySource(MarkElement marker) {
    this.marker = marker;
  }

  @Override
  public Object getEditableValue() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IPropertyDescriptor[] getPropertyDescriptors() {
    return new IPropertyDescriptor[] {new PropertyDescriptor(ID, "ID"),
        new PropertyDescriptor(LENGTH, "Length"),
        new PropertyDescriptor(LINE_NUMBER, "Line Number"),
        new PropertyDescriptor(OFFSET, "Offset"), new PropertyDescriptor(PATH, "Path"),
        new PropertyDescriptor(TEXT, "Text")};
  }

  @Override
  public Object getPropertyValue(Object id) {
    if (ID.equals(id)) {
      return marker.getId();
    } else if (LENGTH.equals(id)) {
      return marker.getLength();
    } else if (LINE_NUMBER.equals(id)) {
      return marker.getLinenumber();
    } else if (OFFSET.equals(id)) {
      return marker.getOffset();
    } else if (PATH.equals(id)) {
      return marker.getPath();
    } else if (TEXT.equals(id)) {
      return marker.getMessage();
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
