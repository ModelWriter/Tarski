package eu.modelwriter.marker.ui.internal.views.markerview;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.views.markers.MarkerField;
import org.eclipse.ui.views.markers.MarkerItem;

public class MarkerViewOffsetField extends MarkerField {
  @Override
  public String getValue(MarkerItem item) {
    try {
      return Integer.toString((int) item.getMarker().getAttribute(IMarker.LOCATION));
    } catch (CoreException e) {
      e.printStackTrace();
    }
    return "";
  }
}
