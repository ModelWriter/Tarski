package eu.modelwriter.marker.command;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;

public class CountMarkersInFileHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    IFile file = (IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .getActiveEditor().getEditorInput().getAdapter(IFile.class);
    List<IMarker> markers = MarkerFactory.findMarkers(file);
    MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Marker Count", null,
        markers.size() + " marker(s)", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
    dialog.open();
    return null;
  }
}
