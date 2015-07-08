package eu.modelwriter.writer.markers.views;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import eu.modelwriter.writer.markers.actions.Serialization;
import eu.modelwriter.writer.markers.views.internal.MappingViewCharEndColumn;
import eu.modelwriter.writer.markers.views.internal.MappingViewCharStartColumn;
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
		new MappingViewCharStartColumn().addColumnTo(mappingViewer);
		new MappingViewCharEndColumn().addColumnTo(mappingViewer);
		new MappingViewLocationColumn().addColumnTo(mappingViewer);
		String[] sample = { "1", "2", "3", "4", "5" };
		mappingViewer.setInput(sample);// set input
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
}
