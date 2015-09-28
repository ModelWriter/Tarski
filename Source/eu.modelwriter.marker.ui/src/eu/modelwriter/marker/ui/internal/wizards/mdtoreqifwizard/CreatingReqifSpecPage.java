package eu.modelwriter.marker.ui.internal.wizards.mdtoreqifwizard;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class CreatingReqifSpecPage extends WizardPage {

  public static CheckboxTreeViewer markTreeViewer = null;

  public CreatingReqifSpecPage() {
    super("Creating Reqif");
  }

  @Override
  public void createControl(Composite parent) {
    Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayout(new GridLayout(1, false));

    markTreeViewer = new CheckboxTreeViewer(composite);
    markTreeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

    MarkdownToReqifContentProvider treeViewerContentProvider = new MarkdownToReqifContentProvider();

    markTreeViewer.setLabelProvider(new MarkdownToReqifLabelProvider());
    markTreeViewer.setContentProvider(treeViewerContentProvider);
    ViewerFilter[] filter = new ViewerFilter[] {new MarkdownToReqifFilter()};
    markTreeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot().getProjects());
    markTreeViewer.setFilters(filter);

    setPageComplete(true);
    setControl(composite);
  }
}
