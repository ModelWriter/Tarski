package eu.modelwriter.markers.views.internal;

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

import eu.modelwriter.markers.internal.MarkElement;
import eu.modelwriter.markers.views.targetview.internal.TargetViewIDColumn;
import eu.modelwriter.markers.views.targetview.internal.TargetViewLengthColumn;
import eu.modelwriter.markers.views.targetview.internal.TargetViewLineNumberColumn;
import eu.modelwriter.markers.views.targetview.internal.TargetViewOffsetColumn;
import eu.modelwriter.markers.views.targetview.internal.TargetViewPathColumn;
import eu.modelwriter.markers.views.targetview.internal.TargetViewTextColumn;

public class TargetView extends ViewPart {

  private static TableViewer targetViewer;

  @Override
  public void dispose() {
    super.dispose();
  }

  @Override
  public void createPartControl(Composite parent) {
    targetViewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL);
    targetViewer.getTable().setHeaderVisible(true);
    targetViewer.setContentProvider(ArrayContentProvider.getInstance());
    new TargetViewIDColumn().addColumnTo(targetViewer);
    new TargetViewTextColumn().addColumnTo(targetViewer);
    new TargetViewOffsetColumn().addColumnTo(targetViewer);
    new TargetViewLengthColumn().addColumnTo(targetViewer);
    new TargetViewLineNumberColumn().addColumnTo(targetViewer);
    new TargetViewPathColumn().addColumnTo(targetViewer);
    getSite().setSelectionProvider(targetViewer);

    targetViewer.addDoubleClickListener(new IDoubleClickListener() {
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
