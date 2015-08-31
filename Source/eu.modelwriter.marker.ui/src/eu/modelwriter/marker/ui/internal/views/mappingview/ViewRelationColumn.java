package eu.modelwriter.marker.ui.internal.views.mappingview;

import eu.modelwriter.marker.internal.MarkElement;

public class ViewRelationColumn extends ViewColumn {

  @Override
  public String getText(Object element) {
    if (element instanceof MarkElement) {
      return ((MarkElement) element).getRelation().toString();
    }
    return "";
  }

  @Override
  public String getTitle() {
    return "Relation";
  }

  public int getWidth() {
    return 250;
  }

}
