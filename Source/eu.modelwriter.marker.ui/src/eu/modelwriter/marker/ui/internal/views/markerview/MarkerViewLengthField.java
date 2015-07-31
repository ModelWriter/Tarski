package eu.modelwriter.marker.ui.internal.views.markerview;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.views.markers.MarkerField;
import org.eclipse.ui.views.markers.MarkerItem;

public class MarkerViewLengthField extends MarkerField {
  @Override
  public String getValue(MarkerItem item) {
    try {
      int ret = ((int) item.getMarker().getAttribute(IMarker.CHAR_END)
          - (int) item.getMarker().getAttribute(IMarker.CHAR_START));
      return Integer.toString(ret);
    } catch (CoreException e) {
      e.printStackTrace();
    }
    return "";
  }
}
