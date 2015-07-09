package eu.modelwriter.writer.markers.views;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import eu.modelwriter.writer.markers.views.internal.MappingViewLengthColumn;
import eu.modelwriter.writer.markers.views.internal.MappingViewOffsetColumn;
import eu.modelwriter.writer.markers.views.internal.MappingViewIDColumn;
import eu.modelwriter.writer.markers.views.internal.MappingViewLocationColumn;
import eu.modelwriter.writer.markers.views.internal.MappingViewSelectionListener;
import eu.modelwriter.writer.markers.views.internal.MappingViewTextColumn;

public class MappingView extends ViewPart {

	private static TableViewer mappingViewer;
	private MappingViewSelectionListener selectionListener;

	public void dispose() {
		if (selectionListener != null) {
			getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(selectionListener);
			selectionListener = null;
		}
		super.dispose();
	}

	@Override
	public void createPartControl(Composite parent) {
		mappingViewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		mappingViewer.getTable().setHeaderVisible(true);
		mappingViewer.setContentProvider(ArrayContentProvider.getInstance());
		new MappingViewIDColumn().addColumnTo(mappingViewer);
		new MappingViewTextColumn().addColumnTo(mappingViewer);
		new MappingViewOffsetColumn().addColumnTo(mappingViewer);
		new MappingViewLengthColumn().addColumnTo(mappingViewer);
		new MappingViewLocationColumn().addColumnTo(mappingViewer);
		getSite().setSelectionProvider(mappingViewer);

		selectionListener = new MappingViewSelectionListener(mappingViewer, getSite().getPart());
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(selectionListener);
	}

	@Override
	public void setFocus() {
		mappingViewer.getControl().setFocus();
	}

	public static void setColumns(Object element) {
		mappingViewer.setInput(element);
	}

	public static Object getViewerInput() {
		return mappingViewer.getInput();
	}
}
