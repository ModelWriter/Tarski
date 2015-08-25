package eu.modelwriter.marker.ui.internal.preferences;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.TableColumn;

import eu.modelwriter.marker.MarkerActivator;

public abstract class RefColumnLabelProvider extends ColumnLabelProvider {

  @Override
  public Image getImage(Object element) {
    ImageRegistry imageRegistry = MarkerActivator.getDefault().getImageRegistry();
    return imageRegistry.get(MarkerActivator.Images.IMAGE_RELATION_ID);
  }

  public abstract String getText(Object element);

  public abstract String getTitle();

  public TableViewerColumn addColumnTo(TableViewer viewer) {
    TableViewerColumn tableViewerColumn = new TableViewerColumn(viewer, SWT.NONE);
    TableColumn column = tableViewerColumn.getColumn();
    column.setMoveable(true);
    column.setText(getTitle());
    column.setResizable(true);
    tableViewerColumn.setLabelProvider(this);
    return tableViewerColumn;
  }
}
