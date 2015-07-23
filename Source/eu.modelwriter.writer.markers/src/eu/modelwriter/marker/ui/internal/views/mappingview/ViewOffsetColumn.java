package eu.modelwriter.marker.ui.internal.views.mappingview;

import eu.modelwriter.marker.internal.MarkElement;

public class ViewOffsetColumn extends ViewColumn {

  @Override
  public String getText(Object element) {
    if (element instanceof MarkElement) {
      return Integer.toString(((MarkElement) element).getOffset());
    }
    return "";
  }

  @Override
  public String getTitle() {
    return "Offset";
  }

  public int getWidth() {
    return 50;
  }
}
