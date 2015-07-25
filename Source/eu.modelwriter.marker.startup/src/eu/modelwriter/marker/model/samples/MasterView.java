package eu.modelwriter.marker.model.samples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;

import eu.modelwriter.marker.Activator;
import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.views.SourceView;
import eu.modelwriter.marker.ui.views.TargetView;

public class MasterView extends ViewPart {

  public static final String ID = "eu.modelwriter.marker.ui.views.markerview";
  private static TreeViewer treeViewer;
  private Tree tree;

  public MasterView() {}

  @Override
  public void createPartControl(Composite parent) {

    treeViewer = new TreeViewer(parent, SWT.BORDER);
    tree = treeViewer.getTree();
    treeViewer.setContentProvider(new MasterViewTreeContentProvider());

    MasterViewTreeLabelProvider baseLabelprovider = new MasterViewTreeLabelProvider();
    ILabelDecorator decorator = PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator();
    treeViewer.setLabelProvider(new DecoratingLabelProvider(baseLabelprovider, decorator));
    getSite().setSelectionProvider(treeViewer);

    IFile file = Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
        .getEditorInput().getAdapter(IFile.class);
    ArrayList<IMarker> allMarkers;
    try {
      allMarkers = MarkerFactory.findMarkersAsArrayList(file);
      Iterator<IMarker> iter = allMarkers.iterator();
      while (iter.hasNext()) {
        Object marker = iter.next();
        try {
          if (((IMarker) marker).getAttribute(MarkerFactory.LEADER_ID) == null
              && ((IMarker) marker).getAttribute(MarkerFactory.GROUP_ID) != null) {
            iter.remove();
          }
        } catch (CoreException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      MarkElement markers[] = new MarkElement[allMarkers.size()];
      int i = 0;
      for (IMarker iMarker : allMarkers) {
        markers[i] = new MarkElement(iMarker);
        i++;
      }
      treeViewer.setInput(markers);
    } catch (CoreException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

    treeViewer.addDoubleClickListener(new IDoubleClickListener() {

      @Override
      public void doubleClick(DoubleClickEvent event) {
        IStructuredSelection selection = (IStructuredSelection) event.getSelection();
        MarkElement selected = (MarkElement) selection.getFirstElement();
        IMarker selectedMarker = MarkElement.getMarker(selected);
        IFile file = Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
            .getEditorInput().getAdapter(IFile.class);
        try {
          IDE.openEditor(Activator.getActiveWorkbenchWindow().getActivePage(),
              MarkerFactory.findMarkerBySourceId(file,
                  ((String) selectedMarker.getAttribute(IMarker.SOURCE_ID))));
          IViewPart viewPart =
              Activator.getActiveWorkbenchWindow().getActivePage().showView(TargetView.ID);
          if (viewPart instanceof TargetView) {
            ArrayList<MarkElement> targetMarkElementsOfSelectedMark = new ArrayList<MarkElement>();
            if (selectedMarker.getAttribute(MarkElement.getTargetAttributeName()) != null) {
              targetMarkElementsOfSelectedMark = Serialization.getInstance().fromString(
                  (String) (selectedMarker).getAttribute(MarkElement.getTargetAttributeName()));
            }
            TargetView.setColumns(targetMarkElementsOfSelectedMark);
          }
          viewPart = Activator.getActiveWorkbenchWindow().getActivePage().showView(SourceView.ID);
          if (viewPart instanceof SourceView) {
            ArrayList<MarkElement> sourceMarkElementsOfSelectedMark = new ArrayList<MarkElement>();
            if (selectedMarker.getAttribute(MarkElement.getSourceAttributeName()) != null) {
              sourceMarkElementsOfSelectedMark = Serialization.getInstance().fromString(
                  (String) (selectedMarker).getAttribute(MarkElement.getSourceAttributeName()));
            }
            SourceView.setColumns(sourceMarkElementsOfSelectedMark);
          }
        } catch (PartInitException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (CoreException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (ClassNotFoundException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    });
  }

  @Override
  public void setFocus() {
    tree.setFocus();
  }

  public static TreeViewer getTreeViewer() {
    return treeViewer;
  }
}
