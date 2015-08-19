package eu.modelwriter.marker.ui.views.masterview;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkElementUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.Activator;

public class MasterViewTreeContentProvider implements ITreeContentProvider {

  @Override
  public void dispose() {}

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

  @Override
  public Object[] getElements(Object inputElement) {
    if (inputElement instanceof Object[]) {
      return (Object[]) inputElement;
    } else {
      return new Object[0];
    }
  }

  @Override
  public Object[] getChildren(Object parentElement) {
    IFile file = Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
        .getEditorInput().getAdapter(IFile.class);
    if (parentElement instanceof MarkElement) {
      MarkElement markedElement = (MarkElement) parentElement;
      IMarker marked = markedElement.getiMarker();
      List<IMarker> groupElements =
          MarkerFactory.findMarkersByGroupId(file, MarkElementUtilities.getGroupId(marked));
      groupElements.remove(marked);
      MarkElement markers[] = new MarkElement[groupElements.size()];
      int i = 0;
      for (IMarker iMarker : groupElements) {
        markers[i] = new MarkElement(iMarker);
        i++;
      }
      return markers;
    } else
      return null;
  }

  @Override
  public Object getParent(Object element) {
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {
    if (element instanceof MarkElement) {
      MarkElement markedElement = (MarkElement) element;
      IMarker marked = markedElement.getiMarker();
      if (marked != null && MarkElementUtilities.getLeaderId(marked) != null) {
        return true;
      }
    }
    return false;
  }
}
