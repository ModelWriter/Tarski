package eu.modelwriter.writer.markers.views;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;

import eu.modelwriter.writer.markers.actions.MarkElement;
import eu.modelwriter.writer.markers.views.internal.MappingViewIDColumn;
import eu.modelwriter.writer.markers.views.internal.MappingViewLengthColumn;
import eu.modelwriter.writer.markers.views.internal.MappingViewLineNumberColumn;
import eu.modelwriter.writer.markers.views.internal.MappingViewOffsetColumn;
import eu.modelwriter.writer.markers.views.internal.MappingViewPathColumn;
import eu.modelwriter.writer.markers.views.internal.MappingViewIDColumn;
import eu.modelwriter.writer.markers.views.internal.MappingViewTextColumn;

public class MappingView extends ViewPart {

	private static TableViewer mappingViewer;

	@Override
	public void dispose() {
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
		new MappingViewLineNumberColumn().addColumnTo(mappingViewer);
		new MappingViewPathColumn().addColumnTo(mappingViewer);
		getSite().setSelectionProvider(mappingViewer);

		mappingViewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();

				try {
					IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),
							MarkElement.getMarker((MarkElement) selection.getFirstElement()));
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
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
