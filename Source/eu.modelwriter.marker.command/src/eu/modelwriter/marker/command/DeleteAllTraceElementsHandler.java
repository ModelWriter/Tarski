package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

import eu.modelwriter.configuration.alloy.analysis.StaticAlloyAnalysisManager;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;

public class DeleteAllTraceElementsHandler extends AbstractHandler {
  public static String COMMAND_ID = "eu.modelwriter.marker.command.deleteAllTraceElements";

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final MessageDialog warningDialog = new MessageDialog(MarkerActivator.getShell(), "Warning!",
        null, "You are about to delete all markers! Do you want to continue?",
        MessageDialog.WARNING, new String[] {"Yes", "No"}, 0);
    if (warningDialog.open() != 0) {
      return null;
    }

    if (AlloyUtilities.isExists()) {
      StaticAlloyAnalysisManager.finishAnalysis();

      AlloyUtilities.clearRepository();
      AlloyUtilities.clearRelation();
      AlloyUtilities.clearSigs();
      AlloyUtilities.clearFields();

      try {
        ResourcesPlugin.getWorkspace().getRoot().deleteMarkers(MarkerFactory.MARKER_MARKING, true,
            IResource.DEPTH_INFINITE);
      } catch (final CoreException e) {
        e.printStackTrace();
      }

      refreshActiveEditor();
    } else {
      final MessageDialog infoDialog = new MessageDialog(MarkerActivator.getShell(),
          "System Information", null, "You dont have any registered alloy file to system.",
          MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      infoDialog.open();
    }
    return null;
  }

  private void refreshActiveEditor() {
    final IEditorPart editor = Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    if (editor == null) {
      return;
    }

    ITextEditor iteEditor = null;
    if (editor instanceof EcoreEditor) {
      final EcoreEditor ecEditor = (EcoreEditor) editor;
      ecEditor.getViewer().refresh();
    } else {
      if (editor instanceof ITextEditor) {
        iteEditor = (ITextEditor) editor;
      } else if (editor instanceof MultiPageEditorPart) {
        final MultiPageEditorPart mpepEditor = (MultiPageEditorPart) editor;
        final IEditorPart[] editors = mpepEditor.findEditors(mpepEditor.getEditorInput());
        iteEditor = (ITextEditor) editors[0];
      }
      if (iteEditor != null) {
        final IDocumentProvider idp = iteEditor.getDocumentProvider();
        try {
          idp.resetDocument(iteEditor.getEditorInput());
        } catch (final CoreException e) {
          e.printStackTrace();
        }
      }
    }
    MarkerFactory.refreshProjectExp();
    if (Activator.getDefault().getWorkbench().getWorkbenchWindows()[0].getActivePage()
        .findView(Visualization.ID) != null) {
      Visualization.showViz();
    }
  }
}
