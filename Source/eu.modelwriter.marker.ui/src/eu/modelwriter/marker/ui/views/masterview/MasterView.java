package eu.modelwriter.marker.ui.views.masterview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;

import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkElementUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.internal.MarkerUpdater;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.views.mappingview.SourceView;
import eu.modelwriter.marker.ui.internal.views.mappingview.TargetView;

public class MasterView extends ViewPart {

  public static final String ID = "eu.modelwriter.marker.ui.views.markerview";
  private static TreeViewer treeViewer;
  private Tree tree;
  private ArrayList<IMarker> candidateToDelete;

  public MasterView() {
    candidateToDelete = new ArrayList<IMarker>();
  }

  @Override
  public void createPartControl(Composite parent) {

    treeViewer = new TreeViewer(parent, SWT.BORDER | SWT.MULTI);
    tree = treeViewer.getTree();
    treeViewer.setContentProvider(new MasterViewTreeContentProvider());

    MasterViewTreeLabelProvider baseLabelprovider = new MasterViewTreeLabelProvider();
    ILabelDecorator decorator = PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator();
    treeViewer.setLabelProvider(new DecoratingLabelProvider(baseLabelprovider, decorator));
    // if (PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
    // .findView("org.eclipse.ui.views.PropertySheet") != null) {
    // getSite().setSelectionProvider(treeViewer);
    // }
    getSite().setSelectionProvider(treeViewer);

    PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

      @Override
      public void run() {
        ResourcesPlugin.getWorkspace().addResourceChangeListener(new IResourceChangeListener() {
          @Override
          public void resourceChanged(IResourceChangeEvent event) {
            if (event.findMarkerDeltas(MarkerFactory.MARKER_MARKING, true).length != 0) {
              if (!tree.isDisposed()) {
                refreshTree();
              }
            }
          }
        }, IResourceChangeEvent.POST_CHANGE);
      }
    });

    treeViewer.addDoubleClickListener(new IDoubleClickListener() {

      @Override
      public void doubleClick(DoubleClickEvent event) {
        IStructuredSelection selection = (IStructuredSelection) event.getSelection();
        MarkElement selected = (MarkElement) selection.getFirstElement();
        IMarker selectedMarker = selected.getiMarker();
        try {
          IDE.openEditor(Activator.getActiveWorkbenchWindow().getActivePage(),
              MarkerFactory.findMarkerBySourceId(selectedMarker.getResource(),
                  (MarkElementUtilities.getSourceId(selectedMarker))));
          IViewPart viewPart =
              Activator.getActiveWorkbenchWindow().getActivePage().showView(TargetView.ID);
          if (viewPart instanceof TargetView) {
            ArrayList<MarkElement> targetMarkElementsOfSelectedMark = new ArrayList<MarkElement>();
            if (MarkElementUtilities.getTargetList(selectedMarker) != null) {
              targetMarkElementsOfSelectedMark = MarkElementUtilities.getTargetList(selectedMarker);
            }
            TargetView.setColumns(targetMarkElementsOfSelectedMark);
          }
          viewPart = Activator.getActiveWorkbenchWindow().getActivePage().showView(SourceView.ID);
          if (viewPart instanceof SourceView) {
            ArrayList<MarkElement> sourceMarkElementsOfSelectedMark = new ArrayList<MarkElement>();
            if (MarkElementUtilities.getSourceList(selectedMarker) != null) {
              sourceMarkElementsOfSelectedMark = MarkElementUtilities.getSourceList(selectedMarker);
            }
            SourceView.setColumns(sourceMarkElementsOfSelectedMark);
          }
        } catch (PartInitException e) {
          e.printStackTrace();
        }
      }
    });

    tree.addKeyListener(new KeyListener() {

      @Override
      public void keyReleased(KeyEvent e) {}

      @Override
      public void keyPressed(KeyEvent e) {
        if (e.keyCode == SWT.DEL) {
          IStructuredSelection selection = treeViewer.getStructuredSelection();
          if (selection.isEmpty()) {
            return;
          } else {
            IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().getActiveEditor();
            TreeItem[] items = treeViewer.getTree().getSelection();
            candidateToDelete = new ArrayList<IMarker>();
            for (TreeItem treeItem : items) {
              MarkElement selectedMarker = (MarkElement) treeItem.getData();
              IMarker iMarker = selectedMarker.getiMarker();
              try {
                if (MarkElementUtilities.getLeaderId(iMarker) != null) {
                  IFile file = (IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                      .getActivePage().getActiveEditor().getEditorInput().getAdapter(IFile.class);

                  List<IMarker> listOfGroup = MarkerFactory.findMarkersByGroupId(file,
                      MarkElementUtilities.getGroupId(iMarker));
                  for (IMarker iMarker2 : listOfGroup) {
                    candidateToDelete.add(iMarker2);
                    AnnotationFactory.removeAnnotation(iMarker2, editor);
                  }
                } else {
                  candidateToDelete.add(iMarker);
                  AnnotationFactory.removeAnnotation(iMarker, editor);
                }
              } catch (CoreException e1) {
                e1.printStackTrace();
              }
            }
          }
          try {
            IMarker[] list = new IMarker[candidateToDelete.size()];
            int i = 0;
            for (IMarker iMarker : candidateToDelete) {
              MarkerUpdater.updateTargetsToDelete(iMarker);
              MarkerUpdater.updateSourcesToDelete(iMarker);
              list[i] = iMarker;
              i++;
            }
            ResourcesPlugin.getWorkspace().deleteMarkers(list);
          } catch (CoreException e1) {
            e1.printStackTrace();
          }
        }
      }
    });
  }

  @Override
  public void setFocus() {
    tree.setFocus();
  }

  public static void refreshTree() {
    if (Activator.getActiveWorkbenchWindow() == null)
      return;

    // if (getSite().getSelectionProvider() == null) {
    // getSite().setSelectionProvider(treeViewer);
    // }

    if (Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor() == null) {
      treeViewer.setInput(new MarkElement[0]);
      return;
    }
    if (treeViewer == null)
      return;

    IFile file = Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
        .getEditorInput().getAdapter(IFile.class);
    ArrayList<IMarker> allMarkers;
    allMarkers = MarkerFactory.findMarkersAsArrayList(file);
    Iterator<IMarker> iter = allMarkers.iterator();
    while (iter.hasNext()) {
      Object marker = iter.next();
      if (MarkElementUtilities.getLeaderId((IMarker) marker) == null
          && MarkElementUtilities.getGroupId((IMarker) marker) != null) {
        iter.remove();
      }
    }
    ArrayList<MarkElement> markers = new ArrayList<MarkElement>();
    for (IMarker iMarker : allMarkers) {
      if (MarkElementUtilities.getSourceId(iMarker) != null) {
        markers.add(new MarkElement(iMarker));
      }
    }
    if (!treeViewer.getTree().isDisposed()) {
      treeViewer.setInput(markers.toArray());
    }
  }

  public static TreeViewer getTreeViewer() {
    return treeViewer;
  }
}
