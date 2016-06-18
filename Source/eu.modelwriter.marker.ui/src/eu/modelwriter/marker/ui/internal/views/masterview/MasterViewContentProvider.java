package eu.modelwriter.marker.ui.internal.views.masterview;

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MasterViewContentProvider implements ITreeContentProvider {

  @Override
  public void dispose() {}

  @Override
  public Object[] getChildren(final Object parentElement) {
    if (parentElement instanceof IMarker) {
      final IMarker iMarker = (IMarker) parentElement;
      final List<IMarker> groupElements = MarkerFactory.findMarkersByGroupId(iMarker.getResource(),
          MarkUtilities.getGroupId(iMarker));
      groupElements.remove(iMarker);

      return groupElements.toArray();
    } else {
      return null;
    }
  }

  @Override
  public Object[] getElements(final Object inputElement) {
    if (inputElement instanceof Object[]) {
      return (Object[]) inputElement;
    } else {
      return new Object[0];
    }
  }

  @Override
  public Object getParent(final Object element) {
    return null;
  }

  @Override
  public boolean hasChildren(final Object element) {
    if (element instanceof IMarker) {
      final IMarker iMarker = (IMarker) element;
      if (MarkUtilities.getLeaderId(iMarker) != null) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {}
}
