package eu.modelwriter.marker.ui.internal.views.propertiesview;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkElementUtilities;

public class DetailPropertySource implements IPropertySource {
  private MarkElement marker;
  private static final Object ID = new Object();
  private static final Object LENGTH = new Object();
  private static final Object LINE_NUMBER = new Object();
  private static final Object OFFSET = new Object();
  private static final Object PATH = new Object();
  private static final Object TEXT = new Object();
  private static final Object TYPE = new Object();

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
        new PropertyDescriptor(TEXT, "Text"), new PropertyDescriptor(TYPE, "Type")};
  }

  @Override
  public Object getPropertyValue(Object id) {
    if (marker != null) {
      if (ID.equals(id)) {
        return MarkElementUtilities.getSourceId(marker.getiMarker());
      } else if (LENGTH.equals(id)) {
        return MarkElementUtilities.getLength(marker.getiMarker());
      } else if (LINE_NUMBER.equals(id)) {
        return MarkElementUtilities.getLinenumber(marker.getiMarker());
      } else if (OFFSET.equals(id)) {
        return MarkElementUtilities.getStart(marker.getiMarker());
      } else if (PATH.equals(id)) {
        return MarkElementUtilities.getPath(marker.getiMarker());
      } else if (TEXT.equals(id)) {
        return MarkElementUtilities.getMessage(marker.getiMarker());
      } else if (TYPE.equals(id)) {
        return MarkElementUtilities.getType(marker.getiMarker());
      }
    }
    return "";
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
