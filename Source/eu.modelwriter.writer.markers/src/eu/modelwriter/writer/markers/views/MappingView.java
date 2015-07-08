package eu.modelwriter.writer.markers.views;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import eu.modelwriter.writer.markers.views.internal.MappingViewIDColumn;
import eu.modelwriter.writer.markers.views.internal.MappingViewSelectionListener;

public class MappingView extends ViewPart {

	private TableViewer mappingViewer;
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
		mappingViewer.setInput("");// set input
		getSite().setSelectionProvider(mappingViewer);

		selectionListener = new MappingViewSelectionListener(mappingViewer, getSite().getPart());
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(selectionListener);
	}

	@Override
	public void setFocus() {
		mappingViewer.getControl().setFocus();
	}

}
