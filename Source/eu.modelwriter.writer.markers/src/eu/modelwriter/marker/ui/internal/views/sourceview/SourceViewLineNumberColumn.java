package eu.modelwriter.marker.ui.internal.views.sourceview;

import eu.modelwriter.marker.internal.MarkElement;

public class SourceViewLineNumberColumn extends SourceViewColumn {

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
