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
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;

import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.internal.Serialization;
import eu.modelwriter.marker.model.Activator;
import eu.modelwriter.marker.ui.views.SourceView;
import eu.modelwriter.marker.ui.views.TargetView;

public class MasterView extends ViewPart {
  
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
      treeViewer.setInput(allMarkers);
    } catch (CoreException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
<<<<<<< HEAD
    
    treeViewer.addDoubleClickListener(new IDoubleClickListener() {
      
      @Override
      public void doubleClick(DoubleClickEvent event) {
        IStructuredSelection selection = (IStructuredSelection) event.getSelection();
        IMarker selectedMarker = (IMarker)selection.getFirstElement();
        IFile file = Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
            .getEditorInput().getAdapter(IFile.class);
        try {
          IDE.openEditor(Activator.getActiveWorkbenchWindow().getActivePage(),
              MarkerFactory.findMarkerBySourceId(file, ((String)selectedMarker.getAttribute(IMarker.SOURCE_ID))));
        } catch (PartInitException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (CoreException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } 
      }
    });
    
    treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
      
      @Override
      public void selectionChanged(SelectionChangedEvent event) {
        if (!event.getSelection().isEmpty() && event.getSelection() instanceof IStructuredSelection){
          IStructuredSelection selection = (IStructuredSelection)event.getSelection();
          if (selection.getFirstElement() instanceof IMarker){
             try {
              IViewPart viewPart = Activator.getActiveWorkbenchWindow().getActivePage()
                .showView("eu.modelwriter.writer.markers.views.targetview");
              if (viewPart instanceof TargetView){
                IMarker selectedMark = (IMarker) selection.getFirstElement();
                ArrayList<MarkElement> targetMarkElementsOfSelectedMark = new ArrayList<MarkElement>();
                if (selectedMark.getAttribute(MarkElement.getTargetAttributeName()) != null){
                  targetMarkElementsOfSelectedMark = Serialization.getInstance()
                      .fromString((String) (selectedMark).getAttribute(MarkElement.getTargetAttributeName()));
                }
                TargetView.setColumns(targetMarkElementsOfSelectedMark);
              }
    
              viewPart = Activator.getActiveWorkbenchWindow().getActivePage()
              .showView("eu.modelwriter.writer.markers.views.sourceview");
              if (viewPart instanceof SourceView){
                IMarker selectedMark = (IMarker) selection.getFirstElement();
                ArrayList<MarkElement> sourceMarkElementsOfSelectedMark = new ArrayList<MarkElement>();
                if (selectedMark.getAttribute(MarkElement.getSourceAttributeName()) != null){
                  sourceMarkElementsOfSelectedMark = Serialization.getInstance()
                      .fromString((String) (selectedMark).getAttribute(MarkElement.getSourceAttributeName()));
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
        }
      }
    });
=======
>>>>>>> refs/heads/master
  }

  @Override
  public void setFocus() {
    tree.setFocus();
  }
  
  public static TreeViewer getTreeViewer(){
    return treeViewer;
  }
}
