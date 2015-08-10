package eu.modelwriter.marker.ui.internal.wizards.markerwizard;

import org.eclipse.jface.viewers.LabelProvider;

import eu.modelwriter.marker.internal.MarkerTypeElement;

public class MarkerTreeViewLabelProvider extends LabelProvider {
  @Override
  public String getText(Object element) {
    if (element instanceof MarkerTypeElement){
      MarkerTypeElement typeElement = (MarkerTypeElement) element;
      return typeElement.getType();
    }
    return null;
  }
}
