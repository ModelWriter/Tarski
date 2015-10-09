package eu.modelwriter.marker.model;

import java.util.Collection;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Widget;

public class MyDropAdapter extends EditingDomainViewerDropAdapter {

  public MyDropAdapter(EditingDomain domain, Viewer viewer) {
    super(domain, viewer);
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  @Override
  public void dragEnter(DropTargetEvent event) {
    super.dragEnter(event);
  }

  @Override
  public void dragLeave(DropTargetEvent event) {
    super.dragLeave(event);
  }

  @Override
  public void dragOperationChanged(DropTargetEvent event) {
    super.dragOperationChanged(event);
  }

  @Override
  public void dragOver(DropTargetEvent event) {
    super.dragOver(event);
  }

  @Override
  public void drop(DropTargetEvent event) {
    super.drop(event);

    if (TextTransfer.getInstance().isSupportedType(event.currentDataType)) {
      System.out.println("Mission okay.");
    }
  }

  @Override
  public void dropAccept(DropTargetEvent event) {
    super.dropAccept(event);
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  protected Collection<?> extractDragSource(Object object) {
    return super.extractDragSource(object);
  }

  @Override
  protected Object extractDropTarget(Widget item) {
    return super.extractDropTarget(item);
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
  }

  @Override
  protected int getAutoFeedback() {
    return super.getAutoFeedback();
  }

  @Override
  protected Collection<?> getDragSource(DropTargetEvent event) {
    return super.getDragSource(event);
  }

  @Override
  protected float getLocation(DropTargetEvent event) {
    return super.getLocation(event);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  protected void helper(DropTargetEvent event) {
    super.helper(event);
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
