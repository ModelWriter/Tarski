package eu.modelwriter.marker.model.samples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.model.Activator;

public class MasterView extends ViewPart {

  private Tree tree;

  public MasterView() {}

  @Override
  public void createPartControl(Composite parent) {

    TreeViewer treeViewer = new TreeViewer(parent, SWT.BORDER);
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


  }

  @Override
  public void setFocus() {
    tree.setFocus();
  }
}
