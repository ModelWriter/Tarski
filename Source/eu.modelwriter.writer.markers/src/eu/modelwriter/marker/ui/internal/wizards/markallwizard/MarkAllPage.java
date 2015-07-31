package eu.modelwriter.marker.ui.internal.wizards.markallwizard;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.marker.internal.MarkElement;

public class MarkAllPage extends WizardPage {

  private CheckboxTreeViewer treeViewer = null;

  public MarkAllPage() {
    super("Mark All Markers");
    setTitle("Mark All Markers");
  }

  @Override
  public void createControl(Composite parent) {

    Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayout(new GridLayout(1, false));

    treeViewer = new CheckboxTreeViewer(composite);
    treeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

    MarkAllTreeViewContentProvider markAllTreeViewContentProvider =
        new MarkAllTreeViewContentProvider();
    treeViewer.setLabelProvider(new MarkAllTreeViewLabelProvider());
    treeViewer.setContentProvider(markAllTreeViewContentProvider);

    treeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot().getProjects());

    setPageComplete(false);
    treeViewer.addCheckStateListener(new ICheckStateListener() {

      @Override
      public void checkStateChanged(CheckStateChangedEvent event) {
        try {
          if (event.getChecked()) {
            treeViewer.setSubtreeChecked(event.getElement(), true);
            if (event.getElement() instanceof IProject) {
              IProject iProject = (IProject) event.getElement();
              IResource[] projectMembers = iProject.members();
              for (IResource projectMember : projectMembers) {
                if (projectMember instanceof IFile) {
                  IFile iFile = (IFile) projectMember;
                  MarkAllWizard.checkedFiles.add(iFile);
                }
              }
              setPageComplete(true);
            } else if (event.getElement() instanceof IFolder) {
              IFolder iFolder = (IFolder) event.getElement();
              IResource[] folderMembers = iFolder.members();
              for (IResource folderMember : folderMembers) {
                if (folderMember instanceof IFile) {
                  IFile iFile = (IFile) folderMember;
                  MarkAllWizard.checkedFiles.add(iFile);
                }
              }
              setPageComplete(true);
            } else if (event.getElement() instanceof IFile) {
              IFile iFile = (IFile) event.getElement();
              MarkAllWizard.checkedFiles.add(iFile);
              setPageComplete(true);
            }
          } else {
            treeViewer.setSubtreeChecked(event.getElement(), false);
            if (event.getElement() instanceof IProject) {
              IProject iProject = (IProject) event.getElement();
              IResource[] projectMembers = iProject.members();
              for (IResource projectMember : projectMembers) {
                if (projectMember instanceof IFile) {
                  IFile iFile = (IFile) projectMember;
                  Iterator<IFile> iter = MarkAllWizard.checkedFiles.iterator();
                  while (iter.hasNext()) {
                    IFile iFile2 = (IFile) iter.next();
                    if (iFile.getFullPath().toString().equals(iFile2.getFullPath().toString())) {
                      iter.remove();
                    }
                  }
                }
              }
              setPageComplete(true);
            } else if (event.getElement() instanceof IFolder) {
              IFolder iFolder = (IFolder) event.getElement();
              IResource[] folderMembers = iFolder.members();
              for (IResource folderMember : folderMembers) {
                if (folderMember instanceof IFile) {
                  IFile iFile = (IFile) folderMember;
                  Iterator<IFile> iter = MarkAllWizard.checkedFiles.iterator();
                  while (iter.hasNext()) {
                    IFile iFile2 = (IFile) iter.next();
                    if (iFile.getFullPath().toString().equals(iFile2.getFullPath().toString())) {
                      iter.remove();
                    }
                  }
                }
              }
              setPageComplete(true);
            } else if (event.getElement() instanceof IFile) {
              IFile iFile = (IFile) event.getElement();
              Iterator<IFile> iter = MarkAllWizard.checkedFiles.iterator();
              while (iter.hasNext()) {
                IFile iFile2 = (IFile) iter.next();
                if (iFile.getFullPath().toString().equals(iFile2.getFullPath().toString())) {
                  iter.remove();
                }
              }
              setPageComplete(true);
            }
          }
        } catch (CoreException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    });
    setControl(composite);
  }

}
