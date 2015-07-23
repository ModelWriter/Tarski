package eu.modelwriter.marker.ui.internal.views.mappingview;

import eu.modelwriter.marker.internal.MarkElement;

public class ViewTextColumn extends ViewColumn {

  @Override
  public String getText(Object element) {
    if (element instanceof MarkElement) {
      return ((MarkElement) element).getMessage();
    }
    return "";
  }

  @Override
  public String getTitle() {
    return "Text";
  }

  public int getWidth() {
    return 350;
  }

}
