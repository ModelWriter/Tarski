package eu.modelwriter.marker.ui.internal.views.mappingview;

import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkElementUtilities;

public class ViewIDColumn extends ViewColumn {

  @Override
  public String getText(Object element) {
    if (element instanceof MarkElement) {
      return MarkElementUtilities.getSourceId(((MarkElement) element).getiMarker());
    }
    return "";
  }

  @Override
  public String getTitle() {
    return "ID";
  }

  public int getWidth() {
    return 215;
  }
}
