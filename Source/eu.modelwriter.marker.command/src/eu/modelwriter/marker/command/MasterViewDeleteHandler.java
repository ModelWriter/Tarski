package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class MasterViewDeleteHandler extends AbstractHandler {

  public static String COMMAND_ID = "eu.modelwriter.marker.command.masterviewdelete";

  private final String MASTERVIEW = "ModelWriter Master View";

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    // final IWorkbenchWindow window =
    // Activator.getDefault().getWorkbench().getActiveWorkbenchWindow();
    //
    // final ISelection selection = window.getSelectionService().getSelection();
    // final String title = window.getPartService().getActivePart().getTitle();
    //
    // if (selection != null && selection instanceof ITreeSelection &&
    // title.equals(this.MASTERVIEW)) {
    // @SuppressWarnings("rawtypes")
    // final Iterator iterator = ((TreeSelection) selection).iterator();
    // while (iterator.hasNext()) {
    // final TreeItem item = (TreeItem) iterator.next();
    // final IMarker marker = (IMarker) item.getData();
    //
    // if (MarkUtilities.getLeaderId(marker) != null) {
    // final List<IMarker> foundMarkers = MarkerFactory
    // .findMarkersByGroupId(marker.getResource(), MarkUtilities.getGroupId(marker));
    // foundMarkers.iterator();
    // this.switchSourceColors();
    // }
    // }
    // }

    return null;
  }
}
