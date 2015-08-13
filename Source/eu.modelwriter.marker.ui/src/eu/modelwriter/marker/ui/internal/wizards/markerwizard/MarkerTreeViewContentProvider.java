package eu.modelwriter.marker.ui.internal.wizards.markerwizard;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import eu.modelwriter.marker.internal.MarkerTypeElement;
import eu.modelwriter.marker.typing.alloy.AlloySig;

public class MarkerTreeViewContentProvider implements ITreeContentProvider {

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    // TODO Auto-generated method stub

  }

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
    if (parentElement instanceof AlloySig) {
      AlloySig type = (AlloySig) parentElement;
      return type.getAlloySigChildrenList().toArray();
    }
    return null;
  }

  @Override
  public Object getParent(Object element) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {
    if (element instanceof AlloySig) {
      AlloySig type = (AlloySig) element;
      return !type.getAlloySigChildrenList().isEmpty();
    }
    return false;
  }

}
