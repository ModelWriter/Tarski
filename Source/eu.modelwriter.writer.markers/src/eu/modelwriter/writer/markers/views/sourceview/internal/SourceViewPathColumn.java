package eu.modelwriter.writer.markers.views.sourceview.internal;

import eu.modelwriter.writer.markers.internal.MarkElement;

public class SourceViewPathColumn extends SourceViewColumn {

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
