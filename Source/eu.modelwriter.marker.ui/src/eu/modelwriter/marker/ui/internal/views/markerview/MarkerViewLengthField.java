package eu.modelwriter.marker.ui.internal.views.markerview;

import org.eclipse.ui.views.markers.MarkerField;
import org.eclipse.ui.views.markers.MarkerItem;

import eu.modelwriter.marker.internal.MarkElementUtilities;

public class MarkerViewLengthField extends MarkerField {
  @Override
  public String getValue(MarkerItem item) {
    int ret = MarkElementUtilities.getLength(item.getMarker());
    return Integer.toString(ret);
  }
}
