package eu.modelwriter.marker.ui.internal.views.mappingview;

import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkElementUtilities;

public class ViewLineNumberColumn extends ViewColumn {

  @Override
  public String getText(Object element) {
    if (element instanceof MarkElement) {
      return Integer
          .toString(MarkElementUtilities.getLinenumber(((MarkElement) element).getiMarker()));
    }
    return "";
  }

  @Override
  public String getTitle() {
    return "Line Number";
  }

  public int getWidth() {
    return 75;
  }
}
