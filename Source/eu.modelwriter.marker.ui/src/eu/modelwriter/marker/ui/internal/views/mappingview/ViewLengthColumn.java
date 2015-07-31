package eu.modelwriter.marker.ui.internal.views.mappingview;

import eu.modelwriter.marker.internal.MarkElement;

public class ViewLengthColumn extends ViewColumn {

  @Override
  public String getText(Object element) {
    if (element instanceof MarkElement) {
      return Integer.toString(((MarkElement) element).getLength());
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
