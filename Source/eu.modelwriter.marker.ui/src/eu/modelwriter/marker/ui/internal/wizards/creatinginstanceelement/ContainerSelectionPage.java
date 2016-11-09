package eu.modelwriter.marker.ui.internal.wizards.creatinginstanceelement;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.configuration.generation.GenerationWizardPage;
import eu.modelwriter.configuration.internal.AlloyUtilities;

public class ContainerSelectionPage extends GenerationWizardPage {

  private ISelection selection;
  private TreeViewer treeViewer;

  protected ContainerSelectionPage() {
    super("Containers");
    setTitle("Containers");
    setDescription("Select a container for new element");
  }

  @Override
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NONE);
    setControl(container);
    container.setLayout(new FillLayout(SWT.HORIZONTAL));

    treeViewer = new TreeViewer(container, SWT.BORDER);
    treeViewer.setUseHashlookup(true);
    treeViewer.setLabelProvider(new SigTypeLabelProvider());
    treeViewer.setContentProvider(new SigTypeContentProvider());
    treeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot().getProjects());

    treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

      @Override
      public void selectionChanged(SelectionChangedEvent event) {
        if (((TreeSelection) event.getSelection()).getFirstElement() instanceof IMarker) {
          selection = event.getSelection();
          ContainerSelectionPage.this.setPageComplete(true);
        } else {
          ContainerSelectionPage.this.setPageComplete(false);
        }
      }
    });
  }

  public ISelection getSelection() {
    return selection;
  }

  public IMarker getSelectedMarker() {
    return (IMarker) ((TreeSelection) getSelection()).getFirstElement();
  }

  public void setSigType(Set<String> containerSigTypes) {
    for (Iterator<String> iterator = containerSigTypes.iterator(); iterator.hasNext();) {
      String sigType = (String) iterator.next();
      containerSigTypes
          .addAll(AlloyUtilities.getAllChildNames(AlloyUtilities.getSigTypeIdByName(sigType)));
    }
    treeViewer.setFilters(new ViewerFilter[] {new SigTypeFilter(containerSigTypes)});
  }
}
