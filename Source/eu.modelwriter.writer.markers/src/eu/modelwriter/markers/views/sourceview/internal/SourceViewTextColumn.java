package eu.modelwriter.markers.views.sourceview.internal;

import eu.modelwriter.markers.internal.MarkElement;

public class SourceViewTextColumn extends SourceViewColumn {

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
