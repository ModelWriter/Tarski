package eu.modelwriter.marker.ui.internal.wizards.creatinginstanceelement;

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

public class ContainerSelectionPage extends GenerationWizardPage {

  private ISelection selection;
  private String sigType;
  private TreeViewer treeViewer;

  protected ContainerSelectionPage() {
    super("Containers");
    this.setTitle("Containers");
    this.setDescription("Select a container for new element");
  }

  @Override
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NONE);
    this.setControl(container);
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
          ContainerSelectionPage.this.selection = event.getSelection();
          ContainerSelectionPage.this.setPageComplete(true);
        } else {
          ContainerSelectionPage.this.setPageComplete(false);
        }
      }
    });
  }

  public ISelection getSelection() {
    return this.selection;
  }

  public IMarker getSelectedMarker() {
    return (IMarker) ((TreeSelection) getSelection()).getFirstElement();
  }

  public void setSigType(String containerSigType) {
    this.sigType = containerSigType;
    treeViewer.setFilters(new ViewerFilter[] {new SigTypeFilter(sigType)});
  }
}
