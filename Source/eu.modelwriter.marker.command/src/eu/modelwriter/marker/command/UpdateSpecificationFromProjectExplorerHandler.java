package eu.modelwriter.marker.command;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.PlatformUI;

public class UpdateSpecificationFromProjectExplorerHandler extends UpdateSpecificationHandler {
  @Override
  public String getFilePath() {
    String result = null;
    final ISelection selection =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
    if (selection != null && selection instanceof TreeSelection) {
      final TreeSelection treeSelection = (TreeSelection) selection;
      final IFile file = (IFile) treeSelection.getFirstElement();
      result = file.getLocation().makeAbsolute().toOSString();
    }
    return result;
  }
}
