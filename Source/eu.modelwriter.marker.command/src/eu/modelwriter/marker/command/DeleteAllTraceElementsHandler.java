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
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

import eu.modelwriter.configuration.alloy.reasoning.AlloyNextSolution;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;

public class DeleteAllTraceElementsHandler extends AbstractHandler {
  public static String COMMAND_ID = "eu.modelwriter.marker.command.deleteAllTraceElements";
  IEditorPart editor;

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    if (AlloyUtilities.isExists()) {
      AlloyNextSolution.getInstance().finishNext();

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

      this.editor =
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

      this.refresh();
    } else {
      final MessageDialog infoDialog = new MessageDialog(MarkerActivator.getShell(),
          "System Information", null, "You dont have any registered alloy file to system.",
          MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      infoDialog.open();
    }
    return null;
  }

  private void refresh() {
    ITextEditor iteEditor = null;
    if (this.editor instanceof EcoreEditor) {
      final EcoreEditor ecEditor = (EcoreEditor) this.editor;
      ecEditor.getViewer().refresh();
    } else {
      if (this.editor instanceof ITextEditor) {
        iteEditor = (ITextEditor) this.editor;
      } else {
        final MultiPageEditorPart mpepEditor = (MultiPageEditorPart) this.editor;
        final IEditorPart[] editors = mpepEditor.findEditors(mpepEditor.getEditorInput());
        iteEditor = (ITextEditor) editors[0];
      }
      final IDocumentProvider idp = iteEditor.getDocumentProvider();
      try {
        idp.resetDocument(iteEditor.getEditorInput());
      } catch (final CoreException e) {
        e.printStackTrace();
      }
    }
    MarkerFactory.refreshProjectExp();
    if (Activator.getDefault().getWorkbench().getWorkbenchWindows()[0].getActivePage()
        .findView(Visualization.ID) != null) {
      Visualization.showViz();
    }
  }
}
