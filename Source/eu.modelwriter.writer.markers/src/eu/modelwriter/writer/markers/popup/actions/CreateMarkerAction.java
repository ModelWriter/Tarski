package eu.modelwriter.writer.markers.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.writer.markers.internal.MarkerFactory;

public class CreateMarkerAction implements IEditorActionDelegate {

  public CreateMarkerAction() {
    super();
  }

  @Override
  public void setActiveEditor(IAction action, IEditorPart editor) {}

  /*
   * This action creates a new marker for the given IFile
   */
  @Override
  public void run(IAction action) {
    try {

      ISelection selection =
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

      IFile file = (IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
          .getActiveEditor().getEditorInput().getAdapter(IFile.class);

      IEditorPart editor =
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

      IMarker mymarker = null;

      if (selection instanceof ITextSelection) {

        mymarker = MarkerFactory.createMarker(file, (ITextSelection) selection);
        MarkerFactory.addAnnotation(mymarker, (ITextSelection) selection, editor);

      } else if (selection instanceof ITreeSelection) {
        if (editor instanceof EcoreEditor) {

          mymarker = MarkerFactory.createMarker(file, (ITreeSelection) selection);
        }
      }


    } catch (CoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {}

}
