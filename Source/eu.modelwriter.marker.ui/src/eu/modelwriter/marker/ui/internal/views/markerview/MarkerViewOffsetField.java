package eu.modelwriter.marker.ui.internal.views.markerview;

import org.eclipse.ui.views.markers.MarkerField;
import org.eclipse.ui.views.markers.MarkerItem;

import eu.modelwriter.marker.internal.MarkElementUtilities;

public class MarkerViewOffsetField extends MarkerField {
  @Override
  public String getValue(MarkerItem item) {
    return Integer.toString(MarkElementUtilities.getLinenumber(item.getMarker()));
  }
}
