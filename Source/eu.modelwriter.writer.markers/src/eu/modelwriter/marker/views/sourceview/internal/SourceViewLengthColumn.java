package eu.modelwriter.marker.views.sourceview.internal;

import eu.modelwriter.marker.internal.MarkElement;

public class SourceViewLengthColumn extends SourceViewColumn {

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
