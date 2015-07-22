package eu.modelwriter.marker.action;

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.IOpenable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

import eu.modelwriter.marker.Activator;
import eu.modelwriter.marker.internal.MarkerFactory;

public class CountMarkersForFilesAction implements IEditorActionDelegate {

  public CountMarkersForFilesAction() {
    super();
  }

  @Override
  public void setActiveEditor(IAction action, IEditorPart editor) {}

  /*
   * This is used to find all the markers for an IResource and any sub resources. Then output the
   * number of markers that are returned
   */
  @Override
  public void run(IAction action) {
    TreeSelection selection = MarkerFactory.getTreeSelection();
    if (selection.getFirstElement() instanceof IOpenable) {
      IResource resource =
          (IResource) ((IAdaptable) selection.getFirstElement()).getAdapter(IResource.class);
      List<IMarker> markers = MarkerFactory.findAllMarkers(resource);

      MessageDialog dialog = new MessageDialog(Activator.getShell(), "Marker Count", null,
          markers.size() + " marker(s)", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();
    }
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {}

}
