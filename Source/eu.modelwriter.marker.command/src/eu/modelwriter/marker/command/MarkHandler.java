package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MarkHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    try {

      ISelection selection =
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

      IFile file = (IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
          .getActiveEditor().getEditorInput().getAdapter(IFile.class);

      IEditorPart editor =
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

      IMarker myMarker = null;

      if (selection instanceof ITextSelection) {

        myMarker = MarkerFactory.createMarker(file, (ITextSelection) selection);

        if (myMarker != null && myMarker.exists()) {
          MarkerFactory.addAnnotation(myMarker, editor, MarkerFactory.ANNOTATION_MARKING);
          MessageDialog dialog =
              new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
                  "\"" + ((ITextSelection) selection).getText()
                      + "\" has been seleceted to be marked",
                  MessageDialog.INFORMATION, new String[] {"OK"}, 0);
          dialog.open();
        }
      } else if (selection instanceof ITreeSelection) {
        if (editor instanceof EcoreEditor) {
          ITreeSelection treeSelection = (ITreeSelection) selection;
          myMarker = MarkerFactory.createMarker(file, treeSelection);

          if (myMarker != null && myMarker.exists()) {
            String message = null;
            if (treeSelection.getFirstElement() instanceof EModelElement)
              message = ((ENamedElement) treeSelection.getFirstElement()).getName();
            else
              message = (String) myMarker.getAttribute(IMarker.TEXT);
            MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
                null, "\"" + message + "\" has been seleceted to be marked",
                MessageDialog.INFORMATION, new String[] {"OK"}, 0);
            dialog.open();
          }
        }
      }

    } catch (CoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }
}
