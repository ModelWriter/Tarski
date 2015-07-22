package eu.modelwriter.marker.ui.internal.views.targetview;

import eu.modelwriter.marker.internal.MarkElement;

public class TargetViewIDColumn extends TargetViewColumn {

  @Override
  public String getText(Object element) {
    if (element instanceof MarkElement) {
      return ((MarkElement) element).getId();
    }
    return "";
  }

  @Override
  public String getTitle() {
    return "ID";
  }

  public int getWidth() {
    return 210;

  }
}
