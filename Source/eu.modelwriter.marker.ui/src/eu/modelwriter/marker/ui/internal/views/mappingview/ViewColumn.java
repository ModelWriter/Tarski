/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ferhat Erata - initial API and implementation
 *     H. Emre Kirmizi - initial API and implementation
 *     Serhat Celik - initial API and implementation
 *     U. Anil Ozturk - initial API and implementation
 *******************************************************************************/
package eu.modelwriter.marker.ui.internal.views.mappingview;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;

public abstract class ViewColumn extends ColumnLabelProvider {

  public abstract String getText(Object element);

  public abstract String getTitle();

  public int getWidth() {
    return 100;
  }

  public TableViewerColumn addColumnTo(TableViewer viewer) {
    TableViewerColumn tableViewerColumn = new TableViewerColumn(viewer, SWT.NONE);
    TableColumn column = tableViewerColumn.getColumn();
    column.setMoveable(true);
    column.setResizable(true);
    column.setText(getTitle());
    column.setWidth(getWidth());
    tableViewerColumn.setLabelProvider(this);
    return tableViewerColumn;
  }
}
