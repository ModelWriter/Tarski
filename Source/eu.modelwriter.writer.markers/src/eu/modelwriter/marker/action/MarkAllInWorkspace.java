/**
 * 
 */
package eu.modelwriter.marker.action;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.Activator;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.wizards.markallwizard.MarkAllWizard;

/**
 * @author emre.kirmizi
 *
 */
public class MarkAllInWorkspace implements IEditorActionDelegate {

  /**
   * 
   */
  public MarkAllInWorkspace() {
    super();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
   */
  @Override
  public void run(IAction action) {

    ISelection selection = MarkerFactory.getSelection();
    IFile file = (IFile) Activator.getEditor().getEditorInput().getAdapter(IFile.class);
    IEditorPart editor =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

    if (selection instanceof ITextSelection) {
      TextSelection textSelection = (TextSelection) selection;

      MarkAllWizard markAllWizard = new MarkAllWizard(textSelection);
      WizardDialog dialog = new WizardDialog(Activator.getShell(), markAllWizard);

      if (dialog.open() == org.eclipse.jface.window.Window.OK) {
        System.out.println("Ok pressed");
      } else {
        System.out.println("Cancel pressed");
      }


    } else if (selection instanceof ITreeSelection) {

    }
    // ISelection iselection =
    // PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
    // IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
    //
    // if (iselection instanceof ITreeSelection){
    //
    // }else if (iselection instanceof ITextSelection){
    // ITextSelection selection = (ITextSelection) iselection;
    //
    // for (IProject iProject : projects) {
    // try {
    // IResource[] resources = iProject.members();
    //
    // for (IResource iResource : resources) {
    // if (iResource instanceof IFolder){
    // IFolder folder = (IFolder) iResource;
    // IResource[] folderResources = folder.members();
    //
    // for (IResource iResource2 : folderResources) {
    // if ()
    // }
    // }
    // }
    // } catch (CoreException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }

    // }

  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
   * org.eclipse.jface.viewers.ISelection)
   */
  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    // TODO Auto-generated method stub

  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IEditorActionDelegate#setActiveEditor(org.eclipse.jface.action.IAction,
   * org.eclipse.ui.IEditorPart)
   */
  @Override
  public void setActiveEditor(IAction action, IEditorPart targetEditor) {
    // TODO Auto-generated method stub

  }

}
