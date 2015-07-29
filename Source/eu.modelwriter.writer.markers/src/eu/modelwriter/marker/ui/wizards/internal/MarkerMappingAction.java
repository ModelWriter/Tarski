package eu.modelwriter.marker.ui.wizards.internal;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.Activator;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MarkerMappingAction implements IEditorActionDelegate {

  public MarkerMappingAction() {
    super();
  }

  @Override
  public void run(IAction action) {
    ISelection selection = MarkerFactory.getSelection();
    IFile file = (IFile) Activator.getEditor().getEditorInput().getAdapter(IFile.class);
    IEditorPart editor =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

    if (selection instanceof TextSelection) {
      TextSelection textSelection = (TextSelection) selection;
      IMarker marker = MarkerFactory.findMarkerByOffset(file, textSelection.getOffset());

      if (marker != null && marker.exists()) {
        MappingWizard mappingWizard = new MappingWizard(marker);

        WizardDialog dialog = new WizardDialog(Activator.getShell(), mappingWizard);

        if (dialog.open() == org.eclipse.jface.window.Window.OK) {
          System.out.println("Ok pressed");
        } else {
          System.out.println("Cancel pressed");
        }
      } else {
        MessageDialog dialog =
            new MessageDialog(Activator.getShell(), "There is no marker in this position", null,
                "Please select valid marker", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
      }
    } else if (selection instanceof TreeSelection) {
      ITreeSelection treeSelection = (ITreeSelection) selection;
      if (selection != null && editor instanceof EcoreEditor) {
        if (treeSelection.getFirstElement() instanceof ENamedElement
            && ((ENamedElement) treeSelection.getFirstElement()).getName() != null
            && !((ENamedElement) treeSelection.getFirstElement()).getName().isEmpty()) {
          try {
            URI uri = EcoreUtil.getURI((ENamedElement) treeSelection.getFirstElement());

            IMarker marker;

            marker = MarkerFactory.findMarkersByUri(file, uri.toString());

            if (marker != null && marker.exists()) {
              MappingWizard mappingWizard = new MappingWizard(marker);

              WizardDialog dialog = new WizardDialog(Activator.getShell(), mappingWizard);

              if (dialog.open() == org.eclipse.jface.window.Window.OK) {
                System.out.println("Ok pressed");
              } else {
                System.out.println("Cancel pressed");
              }
            } else {
              MessageDialog dialog = new MessageDialog(Activator.getShell(),
                  "There is no marker in this position", null, "Please select valid marker",
                  MessageDialog.INFORMATION, new String[] {"OK"}, 0);
              dialog.open();
            }
          } catch (CoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        } else if (!((EObject) treeSelection.getFirstElement() instanceof EModelElement)) {
          try {
            URI uri = EcoreUtil.getURI((EObject) treeSelection.getFirstElement());

            IMarker marker;
            marker = MarkerFactory.findMarkersByUri(file, uri.toString());

            if (marker != null && marker.exists()) {
              MappingWizard mappingWizard = new MappingWizard(marker);

              WizardDialog dialog = new WizardDialog(Activator.getShell(), mappingWizard);

              if (dialog.open() == org.eclipse.jface.window.Window.OK) {
                System.out.println("Ok pressed");
              } else {
                System.out.println("Cancel pressed");
              }
            } else {
              MessageDialog dialog = new MessageDialog(Activator.getShell(),
                  "There is no marker in this position", null, "Please select valid marker",
                  MessageDialog.INFORMATION, new String[] {"OK"}, 0);
              dialog.open();
            }
          } catch (CoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      }
    }
    // TextSelection selection = MarkerFactory.getTextSelection();
    // IFile file = (IFile) Activator.getEditor().getEditorInput().getAdapter(IFile.class);
    //
    // IMarker marker = MarkerFactory.findMarkerByOffset(file, selection.getOffset());
    //
    // if (marker != null && marker.exists()) {
    //
    // IEditorPart editorPart = Activator.getDefault().getWorkbench()
    // .getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    // if (editorPart instanceof AbstractTextEditor) {
    // IEditorSite editorSite = editorPart.getEditorSite();
    // if (editorSite != null) {
    // ISelectionProvider selectionProvider = editorSite.getSelectionProvider();
    // if (selectionProvider != null) {
    // MappingWizard mappingWizard = new MappingWizard(marker);
    //
    // WizardDialog dialog = new WizardDialog(Activator.getShell(), mappingWizard);
    //
    // if (dialog.open() == org.eclipse.jface.window.Window.OK) {
    // System.out.println("Ok pressed");
    // } else {
    // System.out.println("Cancel pressed");
    //
    // }
    // }
    // }
    // }
    // } else {
    // MessageDialog dialog =
    // new MessageDialog(Activator.getShell(), "There is no marker in this position", null,
    // "Please select valid marker", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
    // dialog.open();
    // }
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
