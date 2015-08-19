package eu.modelwriter.marker.ui.internal.views.mappingview;

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

import eu.modelwriter.marker.internal.MarkElement;

public class TargetView extends ViewPart {

  public static final String ID = "eu.modelwriter.marker.ui.views.targetview";
  private static TableViewer targetViewer;

  @Override
  public void dispose() {
    super.dispose();
  }

  @Override
  public void createPartControl(Composite parent) {
    targetViewer = new TableViewer(parent, SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL);
    targetViewer.getTable().setHeaderVisible(true);
    targetViewer.setContentProvider(ArrayContentProvider.getInstance());
    new ViewIDColumn().addColumnTo(targetViewer);
    new ViewTextColumn().addColumnTo(targetViewer);
    new ViewOffsetColumn().addColumnTo(targetViewer);
    new ViewLengthColumn().addColumnTo(targetViewer);
    new ViewLineNumberColumn().addColumnTo(targetViewer);
    new ViewPathColumn().addColumnTo(targetViewer);

    targetViewer.addDoubleClickListener(new IDoubleClickListener() {
      @Override
      public void doubleClick(DoubleClickEvent event) {
        IStructuredSelection selection = (IStructuredSelection) event.getSelection();

        try {
          IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),
              ((MarkElement) selection.getFirstElement()).getiMarker());
        } catch (PartInitException e) {
          e.printStackTrace();
        }
      }
    });
  }

  @Override
  public void setFocus() {
    targetViewer.getControl().setFocus();
  }

  public static void setColumns(Object element) {
    targetViewer.setInput(element);
  }

  public static void refresh() {
    targetViewer.refresh();
  }

  public static Object getViewerInput() {
    return targetViewer.getInput();
  }
}
