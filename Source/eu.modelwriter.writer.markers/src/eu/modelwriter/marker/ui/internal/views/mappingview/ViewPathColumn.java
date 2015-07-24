package eu.modelwriter.marker.ui.internal.views.mappingview;

import eu.modelwriter.marker.internal.MarkElement;

public class ViewPathColumn extends ViewColumn {

  @Override
  public String getText(Object element) {
    if (element instanceof MarkElement) {
      return ((MarkElement) element).getPath();
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
