package eu.modelwriter.marker.command;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.IOpenable;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;

public class CountMarkersInResourceHandler extends AbstractHandler {

  public CountMarkersInResourceHandler() {
    super();
  }

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    ISelection selection = MarkerFactory.getSelection();
    if (selection instanceof ITreeSelection) {
      ITreeSelection treeSelection = (ITreeSelection) selection;
      if (treeSelection.getFirstElement() instanceof IOpenable
          || treeSelection.getFirstElement() instanceof IFile) {
        IResource resource =
            (IResource) ((IAdaptable) treeSelection.getFirstElement()).getAdapter(IResource.class);
        List<IMarker> markers = MarkerFactory.findMarkers(resource);
        MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Marker Count", null,
            markers.size() + " marker(s)", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
      }
    }
    return null;
  }
}
