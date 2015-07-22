package eu.modelwriter.marker.ui.internal.views.targetview;

import eu.modelwriter.marker.internal.MarkElement;

public class TargetViewLineNumberColumn extends TargetViewColumn {

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
