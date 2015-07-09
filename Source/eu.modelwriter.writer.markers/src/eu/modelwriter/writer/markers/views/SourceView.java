package eu.modelwriter.writer.markers.views;

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
import eu.modelwriter.writer.markers.views.sourceview.internal.SourceViewIDColumn;
import eu.modelwriter.writer.markers.views.sourceview.internal.SourceViewLengthColumn;
import eu.modelwriter.writer.markers.views.sourceview.internal.SourceViewLineNumberColumn;
import eu.modelwriter.writer.markers.views.sourceview.internal.SourceViewOffsetColumn;
import eu.modelwriter.writer.markers.views.sourceview.internal.SourceViewPathColumn;
import eu.modelwriter.writer.markers.views.sourceview.internal.SourceViewTextColumn;
import eu.modelwriter.writer.markers.views.sourceview.internal.SourceViewImageColumn;

public class SourceView extends ViewPart {

	private static TableViewer sourceViewer;

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void createPartControl(Composite parent) {
		sourceViewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		sourceViewer.getTable().setHeaderVisible(true);
		sourceViewer.setContentProvider(ArrayContentProvider.getInstance());
		new SourceViewImageColumn().addColumnTo(sourceViewer);
		new SourceViewIDColumn().addColumnTo(sourceViewer);
		new SourceViewTextColumn().addColumnTo(sourceViewer);
		new SourceViewOffsetColumn().addColumnTo(sourceViewer);
		new SourceViewLengthColumn().addColumnTo(sourceViewer);
		new SourceViewLineNumberColumn().addColumnTo(sourceViewer);
		new SourceViewPathColumn().addColumnTo(sourceViewer);
		getSite().setSelectionProvider(sourceViewer);

		sourceViewer.addDoubleClickListener(new IDoubleClickListener() {
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
		sourceViewer.getControl().setFocus();
	}

	public static void setColumns(Object element) {
		sourceViewer.setInput(element);
	}

	public static Object getViewerInput() {
		return sourceViewer.getInput();
	}
}
