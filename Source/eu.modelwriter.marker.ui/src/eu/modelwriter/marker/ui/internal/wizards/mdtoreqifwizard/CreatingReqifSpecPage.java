package eu.modelwriter.marker.ui.internal.wizards.mdtoreqifwizard;

import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class CreatingReqifSpecPage extends WizardPage {

  public static CheckboxTreeViewer markTreeViewer = null;
  private ArrayList<IProject> inputArray;

  public CreatingReqifSpecPage() {
    super("Creating Reqif");
    inputArray = new ArrayList<IProject>();
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
    try {
      for (IProject iProject : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
        if (iProject.isAccessible()) {
          IResource[] resources = iProject.members();
          int length = resources.length;
          for (int i = 0; i < length; i++) {
            if (resources[i].getType() == IResource.FILE && resources[i].getFileExtension() != null
                && resources[i].getFileExtension().equals("reqif")) {
              inputArray.add(iProject);
              break;
            }
          }
        }
      }
      markTreeViewer.setInput(inputArray.toArray());
    } catch (CoreException e) {
      e.printStackTrace();
    }

    setPageComplete(true);
    setControl(composite);
  }
}
