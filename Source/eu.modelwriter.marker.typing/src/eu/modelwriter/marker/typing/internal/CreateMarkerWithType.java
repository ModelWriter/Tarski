package eu.modelwriter.marker.typing.internal;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;

import eu.modelwriter.marker.internal.MarkElementUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class CreateMarkerWithType {

  public static IMarker createMarker(IResource resource, ISelection selection, String type) {
    IMarker marker = null;
    if (selection instanceof ITextSelection)
      marker = MarkerFactory.createMarker(resource, (ITextSelection) selection);
    else if (selection instanceof ITreeSelection)
      marker = MarkerFactory.createMarker(resource, (ITreeSelection) selection);

    MarkElementUtilities.setType(marker, type);
    return marker;
  }
}
