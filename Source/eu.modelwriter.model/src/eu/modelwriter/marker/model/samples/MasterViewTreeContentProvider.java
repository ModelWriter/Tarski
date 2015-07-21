package eu.modelwriter.marker.model.samples;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

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
    return null;
  }

  @Override
  public Object getParent(Object element) {
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {
    return false;
  }

}
