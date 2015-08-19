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

public class SourceView extends ViewPart {

  public static final String ID = "eu.modelwriter.marker.ui.views.sourceview";
  private static TableViewer sourceViewer;

  @Override
  public void dispose() {
    super.dispose();
  }

  @Override
  public void createPartControl(Composite parent) {
    sourceViewer = new TableViewer(parent, SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL);
    sourceViewer.getTable().setHeaderVisible(true);
    sourceViewer.setContentProvider(ArrayContentProvider.getInstance());
    new ViewIDColumn().addColumnTo(sourceViewer);
    new ViewTextColumn().addColumnTo(sourceViewer);
    new ViewOffsetColumn().addColumnTo(sourceViewer);
    new ViewLengthColumn().addColumnTo(sourceViewer);
    new ViewLineNumberColumn().addColumnTo(sourceViewer);
    new ViewPathColumn().addColumnTo(sourceViewer);

    sourceViewer.addDoubleClickListener(new IDoubleClickListener() {
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
    sourceViewer.getControl().setFocus();
  }

  public static void setColumns(Object element) {
    sourceViewer.setInput(element);
  }

  public static void refresh() {
    sourceViewer.refresh();
  }

  public static Object getViewerInput() {
    return sourceViewer.getInput();
  }
}
