package eu.modelwriter.marker.action;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.Activator;
import eu.modelwriter.writer.markers.internal.MarkerFactory;

public class CountMarkersForFileAction implements IEditorActionDelegate {

  public CountMarkersForFileAction() {
    super();
  }

  @Override
  public void setActiveEditor(IAction action, IEditorPart editor) {}

  /*
   * I am using this method to find the markers that are directly related to the specified ifile.
   * Then output the number of markers that are returned
   * 
   * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
   */
  @Override
  public void run(IAction action) {
    IFile file = (IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .getActiveEditor().getEditorInput().getAdapter(IFile.class);
    List<IMarker> markers = MarkerFactory.findMarkers(file);
    MessageDialog dialog = new MessageDialog(Activator.getShell(), "Marker Count", null,
        markers.size() + " marker(s)", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
    dialog.open();

  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    // TODO Auto-generated method stub
  }

}
