package eu.modelwriter.marker.ui.internal.views.mappingview;

import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkElementUtilities;

public class ViewPathColumn extends ViewColumn {

  @Override
  public String getText(Object element) {
    if (element instanceof MarkElement) {
      return MarkElementUtilities.getPath(((MarkElement) element).getiMarker());
    }
    return "";
  }

  @Override
  public String getTitle() {
    return "Path";
  }

  public int getWidth() {
    return 350;
  }
}
