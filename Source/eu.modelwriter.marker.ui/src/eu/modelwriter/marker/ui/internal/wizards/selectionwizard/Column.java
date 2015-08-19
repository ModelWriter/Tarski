package eu.modelwriter.marker.ui.internal.wizards.selectionwizard;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;

public abstract class Column extends ColumnLabelProvider {

  public abstract String getText(Object element);

  public abstract String getTitle();

  public TableViewerColumn addColumnTo(TableViewer viewer) {
    TableViewerColumn tableViewerColumn = new TableViewerColumn(viewer, SWT.NONE);
    TableColumn column = tableViewerColumn.getColumn();
    column.setText(getTitle());
    tableViewerColumn.setLabelProvider(this);
    return tableViewerColumn;
  }
}
