package eu.modelwriter.marker.ui.internal.wizards.selectionwizard;

import org.eclipse.core.resources.IMarker;

import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkElementUtilities;

public class MarkerColumn extends Column {

  public MarkerColumn() {}

  @Override
  public String getText(Object element) {
    if (element instanceof IMarker) {
      return MarkElementUtilities.getMessage((IMarker) element);
    } else if (element instanceof MarkElement) {
      return MarkElementUtilities.getMessage(((MarkElement) element).getiMarker());
    }
    return "";
  }

  @Override
  public String getTitle() {
    return "Marker";
  }
}
