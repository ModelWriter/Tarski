package eu.modelwriter.marker.ui.internal.views.mappingview;

import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkElementUtilities;

public class ViewLengthColumn extends ViewColumn {

  @Override
  public String getText(Object element) {
    if (element instanceof MarkElement) {
      return Integer.toString(MarkElementUtilities.getLength(((MarkElement) element).getiMarker()));
    }
    return "";
  }

  @Override
  public String getTitle() {
    return "Length";
  }

  public int getWidth() {
    return 50;
  }
}
