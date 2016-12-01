package eu.modelwriter.marker.command;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ide.ResourceUtil;

public class UpdateSpecificationFromEditorHandler extends UpdateSpecificationHandler {
  @Override
  protected String getFilePath() {
    IEditorPart editor;
    editor = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .getActiveEditor();
    String result = null;
    final IFile file = ResourceUtil.getFile(editor.getEditorInput());
    result = file.getLocation().makeAbsolute().toOSString();
    return result;
  }
}
