package eu.modelwriter.marker.model.samples;

import java.util.ArrayList;

import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

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

    ArrayList<String> elements = new ArrayList<String>();
    elements.add("First marker");
    elements.add("2nd marker");
    elements.add("3rd marker");
    elements.add("My marker");
    elements.add("Whatever marker this is");

    treeViewer.setInput(elements);
  }

  @Override
  public void setFocus() {
    tree.setFocus();
  }
}
