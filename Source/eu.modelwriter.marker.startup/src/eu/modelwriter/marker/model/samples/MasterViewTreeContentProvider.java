package eu.modelwriter.marker.model.samples;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import eu.modelwriter.marker.Activator;
import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MasterViewTreeContentProvider implements ITreeContentProvider {

  @Override
  public void dispose() {
    // nothing to do
  }

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
      IMarker marked = MarkElement.getMarker(markedElement);
      try {
        List<IMarker> groupElements = MarkerFactory.findMarkersByGroupId(file,
            ((String) marked.getAttribute(MarkerFactory.GROUP_ID)));
        groupElements.remove(marked);
        MarkElement markers[] = new MarkElement[groupElements.size()];
        int i = 0;
        for (IMarker iMarker : groupElements) {
          markers[i] = new MarkElement(iMarker);
          i++;
        }
        return markers;
      } catch (CoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else
      return null;
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
      IMarker marked = MarkElement.getMarker(markedElement);
      try {
        if (marked.getAttribute(MarkerFactory.LEADER_ID) != null) {
          return true;
        }
      } catch (CoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else
      return false;
    return false;
  }

}
