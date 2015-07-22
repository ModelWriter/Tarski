package eu.modelwriter.marker.ui.wizards.internal;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

import eu.modelwriter.marker.Activator;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.xml.XMLDOMHelper;

public class MarkerMappingAction implements IEditorActionDelegate {

  public MarkerMappingAction() {
    super();
  }

  @Override
  public void run(IAction action) {
    ISelection selection = MarkerFactory.getSelection();
    IFile file = (IFile) Activator.getEditor().getEditorInput().getAdapter(IFile.class);
    
    if (selection instanceof TextSelection){
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
    }
    else if (selection instanceof TreeSelection){
      TreeSelection treeSelection = (TreeSelection) selection;
      String selectedText = ((ENamedElement) treeSelection.getFirstElement()).getName();

      String xpath = XMLDOMHelper.findNodeAndGetXPath(selectedText,
          file.getLocation().toFile().getAbsolutePath());
      IMarker marker = MarkerFactory.findMarkerByXpath(file, xpath);

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
    }
    
//    TextSelection selection = MarkerFactory.getTextSelection();
//    IFile file = (IFile) Activator.getEditor().getEditorInput().getAdapter(IFile.class);
//
//    IMarker marker = MarkerFactory.findMarkerByOffset(file, selection.getOffset());
//
//    if (marker != null && marker.exists()) {
//
//      IEditorPart editorPart = Activator.getDefault().getWorkbench()
//          .getActiveWorkbenchWindow().getActivePage().getActiveEditor();
//      if (editorPart instanceof AbstractTextEditor) {
//        IEditorSite editorSite = editorPart.getEditorSite();
//        if (editorSite != null) {
//          ISelectionProvider selectionProvider = editorSite.getSelectionProvider();
//          if (selectionProvider != null) {
//            MappingWizard mappingWizard = new MappingWizard(marker);
//
//            WizardDialog dialog = new WizardDialog(Activator.getShell(), mappingWizard);
//
//            if (dialog.open() == org.eclipse.jface.window.Window.OK) {
//              System.out.println("Ok pressed");
//            } else {
//              System.out.println("Cancel pressed");
//
//            }
//          }
//        }
//      }
//    } else {
//      MessageDialog dialog =
//          new MessageDialog(Activator.getShell(), "There is no marker in this position", null,
//              "Please select valid marker", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
//      dialog.open();
//    }
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
