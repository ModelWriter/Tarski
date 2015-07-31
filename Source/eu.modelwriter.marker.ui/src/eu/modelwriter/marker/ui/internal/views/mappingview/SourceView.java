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
    // getSite().setSelectionProvider(sourceViewer);

    sourceViewer.addDoubleClickListener(new IDoubleClickListener() {
      @Override
      public void doubleClick(DoubleClickEvent event) {
        IStructuredSelection selection = (IStructuredSelection) event.getSelection();

        try {
          IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),
              MarkElement.getMarker((MarkElement) selection.getFirstElement()));
          // IEditorPart org.eclipse.ui.ide.IDE.openEditor
          // If the marker contains an EDITOR_ID_ATTR attribute the
          // attribute value will be used to determine the editor type
          // to be opened. If not, the registered editor for the
          // marker resource file will be used.
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

  public static void refresh() {
    sourceViewer.refresh();
  }

  public static Object getViewerInput() {
    return sourceViewer.getInput();
  }
}
