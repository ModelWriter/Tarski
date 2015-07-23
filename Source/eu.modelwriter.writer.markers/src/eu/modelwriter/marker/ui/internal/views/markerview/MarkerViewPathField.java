package eu.modelwriter.marker.ui.internal.views.markerview;

import org.eclipse.ui.views.markers.MarkerField;
import org.eclipse.ui.views.markers.MarkerItem;

public class MarkerViewPathField extends MarkerField {
  @Override
  public String getValue(MarkerItem item) {
    return item.getMarker().getResource().getFullPath().toString();
  }
}
