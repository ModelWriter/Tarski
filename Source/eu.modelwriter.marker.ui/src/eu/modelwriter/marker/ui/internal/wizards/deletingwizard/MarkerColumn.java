package eu.modelwriter.marker.ui.internal.wizards.deletingwizard;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;

import eu.modelwriter.marker.internal.MarkElement;

public class MarkerColumn extends Column {

  public MarkerColumn() {}

  @Override
  public String getText(Object element) {
    try {
      if (element instanceof IMarker) {
        return (String) ((IMarker) element).getAttribute(IMarker.MESSAGE);
      } else if (element instanceof MarkElement) {
        return ((MarkElement) element).getMessage();
      }
    } catch (CoreException e) {
      e.printStackTrace();
    }
    return "";
  }

  @Override
  public String getTitle() {
    return "Marker";
  }
}
