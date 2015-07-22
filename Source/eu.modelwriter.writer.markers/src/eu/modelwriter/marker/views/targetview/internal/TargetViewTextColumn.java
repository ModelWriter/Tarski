package eu.modelwriter.marker.views.targetview.internal;

import eu.modelwriter.marker.internal.MarkElement;

public class TargetViewTextColumn extends TargetViewColumn {

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
