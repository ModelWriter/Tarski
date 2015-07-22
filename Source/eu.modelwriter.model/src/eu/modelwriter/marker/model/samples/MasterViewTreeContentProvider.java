package eu.modelwriter.marker.model.samples;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.model.Activator;

public class MasterViewTreeContentProvider implements ITreeContentProvider {

  @Override
  public void dispose() {
    // nothing to do
  }

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

  @Override
  public Object[] getElements(Object inputElement) {
    if (inputElement instanceof List<?>)
      return ((List<?>) inputElement).toArray();
    return new Object[0];
  }

  @Override
  public Object[] getChildren(Object parentElement) {
    IFile file =Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
    if (parentElement instanceof IMarker ){
      IMarker markedElement = (IMarker) parentElement;
      try {
        List<IMarker> groupElements = MarkerFactory.findMarkersByGroupId(file, ((String)markedElement.getAttribute(MarkerFactory.GROUP_ID)));
        groupElements.remove(markedElement);
        return groupElements.toArray();
      } catch (CoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    else
      return null;
    return null;
  }

  @Override
  public Object getParent(Object element) {
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {
    if (element instanceof IMarker){
      IMarker markedElement = (IMarker) element;
      try {
        if (markedElement.getAttribute(MarkerFactory.LEADER_ID) != null){
          return true;
        }
      } catch (CoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    else
      return false;
    return false;
  }

}
