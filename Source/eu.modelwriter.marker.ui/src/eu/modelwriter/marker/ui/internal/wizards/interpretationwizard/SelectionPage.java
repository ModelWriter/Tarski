package eu.modelwriter.marker.ui.internal.wizards.interpretationwizard;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.marker.ui.internal.wizards.creatingatomwizard.CreatingAtomWizardContentProvider;
import eu.modelwriter.marker.ui.internal.wizards.creatingatomwizard.CreatingAtomWizardFilter;
import eu.modelwriter.marker.ui.internal.wizards.creatingatomwizard.CreatingAtomWizardLabelProvider;

public class SelectionPage extends WizardPage {

  private TreeViewer treeViewer;

  protected SelectionPage(final String pageName) {
    super(pageName);
    this.setTitle("Trace Elements");
  }

  @Override
  public void createControl(final Composite parent) {
    final Composite container = new Composite(parent, SWT.NONE);
    this.setControl(container);
    container.setLayout(new FillLayout(SWT.HORIZONTAL));

    this.treeViewer = new TreeViewer(container, SWT.BORDER);
    this.treeViewer.setUseHashlookup(true);
    this.treeViewer.setLabelProvider(new CreatingAtomWizardLabelProvider());
    this.treeViewer.setContentProvider(new CreatingAtomWizardContentProvider());
    this.treeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot().getProjects());
    this.treeViewer.setFilters(new ViewerFilter[] {new CreatingAtomWizardFilter()});

    this.treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

      @Override
      public void selectionChanged(final SelectionChangedEvent event) {
        if (((TreeSelection) event.getSelection()).getFirstElement() instanceof IMarker) {
          SelectionPage.this.setPageComplete(true);
        } else {
          SelectionPage.this.setPageComplete(false);
        }
      }
    });
  }

  public Object getSelection() {
    return ((ITreeSelection) this.treeViewer.getSelection()).getFirstElement();
  }
}
