package eu.modelwriter.marker.command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ide.ResourceUtil;

import eu.modelwriter.configuration.alloy.analysis.StaticAlloyAnalysisManager;
import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.alloy.trace.TraceManager;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.MarkerActivator;

public abstract class UpdateSpecificationHandler extends AbstractHandler {

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final String filePath = getFilePath();
    if (filePath == null) {
      return null;
    }

    final IEditorPart editor = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow()
        .getActivePage().getActiveEditor();;

        if (editor == null) {
          return null;
        }

        if (editor.isDirty()) {
          final IFile file = ResourceUtil.getFile(editor.getEditorInput());
          final MessageDialog warningdialog =
              new MessageDialog(MarkerActivator.getShell(), "Save Specification", null,
                  file.getName()
                  + " has been modified. You must save file for update the specification. Do you want to save now?",
                  MessageDialog.WARNING, new String[] {"Yes", "No"}, 0);
          if (warningdialog.open() != 0) {
            return null;
          }

          StaticAlloyAnalysisManager.finishAnalysis();
          editor.doSave(new NullProgressMonitor());
        }

        final String content = getContent(filePath);
        if (content == null) {
          return null;
        }

        AlloyUtilities.updateSpec(filePath, content);

        try {
          TraceManager.get().loadSpec(filePath);
        } catch (final TraceException e) {
          e.printStackTrace();
        }

        final MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Status Information",
            null, "Specification has been updated.", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();

        return null;
  }

  private String getContent(final String filePath) {
    try {
      final byte[] encoded = Files.readAllBytes(Paths.get(filePath));
      return new String(encoded, "UTF-8");
    } catch (final IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  protected abstract String getFilePath();
}
