package eu.modelwriter.marker.ui.internal.views.mappingview;

import eu.modelwriter.marker.internal.MarkElement;

public class ViewLineNumberColumn extends ViewColumn {

  @Override
  public String getText(Object element) {
    if (element instanceof MarkElement) {
      return ((MarkElement) element).getLinenumber();
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
