package eu.modelwriter.marker.ui.internal.wizards.creatingatomwizard;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class UntypedMarkerPage extends WizardPage {

  protected UntypedMarkerPage() {
    super("Markers Page");
    this.setTitle("Markers");
    this.setDescription("Untyped Markes For Create Atom");
  }

  @Override
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NONE);
    this.setControl(container);
    container.setLayout(new FillLayout(SWT.HORIZONTAL));

    TreeViewer treeViewer = new TreeViewer(container, SWT.BORDER);
    treeViewer.setUseHashlookup(true);
    treeViewer.setLabelProvider(new CreatingAtomWizardLabelProvider());
    treeViewer.setContentProvider(new CreatingAtomWizardContentProvider());
    treeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot().getProjects());
    treeViewer.setFilters(new ViewerFilter[] {new CreatingAtomWizardFilter()});
  }
}
