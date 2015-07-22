package eu.modelwriter.marker.wizards.internal;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.texteditor.AbstractTextEditor;

import eu.modelwriter.marker.Activator;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MarkerMappingAction implements IEditorActionDelegate {

  public MarkerMappingAction() {
    super();
  }

  @Override
  public void run(IAction action) {
    TextSelection selection = MarkerFactory.getTextSelection();
    IFile file = (IFile) Activator.getEditor().getEditorInput().getAdapter(IFile.class);

    IMarker marker = MarkerFactory.findMarkerByOffset(file, selection.getOffset());

    if (marker != null && marker.exists()) {

      IEditorPart editorPart = Activator.getDefault().getWorkbench()
          .getActiveWorkbenchWindow().getActivePage().getActiveEditor();
      if (editorPart instanceof AbstractTextEditor) {
        IEditorSite editorSite = editorPart.getEditorSite();
        if (editorSite != null) {
          ISelectionProvider selectionProvider = editorSite.getSelectionProvider();
          if (selectionProvider != null) {
            MappingWizard mappingWizard = new MappingWizard(marker);

            WizardDialog dialog = new WizardDialog(Activator.getShell(), mappingWizard);

            if (dialog.open() == org.eclipse.jface.window.Window.OK) {
              System.out.println("Ok pressed");
            } else {
              System.out.println("Cancel pressed");

            }
          }
        }
      }
    } else {
      MessageDialog dialog =
          new MessageDialog(Activator.getShell(), "There is no marker in this position", null,
              "Please select valid marker", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();
    }
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setActiveEditor(IAction action, IEditorPart targetEditor) {
    // TODO Auto-generated method stub

  }

}
