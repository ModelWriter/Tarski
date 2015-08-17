package eu.modelwriter.marker.ui.internal.wizards.mappingwizard;

import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.wizards.selectionwizard.SelectionWizard;

public class MarkerMapping {

  private static MarkerMapping manager;

  private MarkerMapping() {}

  public static MarkerMapping getInstance() {
    if (manager == null)
      manager = new MarkerMapping();
    return manager;
  }

  public void run() {
    ISelection selection = MarkerFactory.getSelection();
    IFile file = (IFile) MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);
    IEditorPart editor =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();


    if (selection instanceof TextSelection) {
      TextSelection textSelection = (TextSelection) selection;

      IMarker marker = null;
      ArrayList<IMarker> markerList = MarkerFactory.findMarkersInSelection(file, textSelection);
      if (markerList != null) {
        if (markerList.size() == 1) {
          marker = markerList.get(0);
        } else if (markerList.size() > 1) {
          SelectionWizard selectionWizard = new SelectionWizard(markerList);
          WizardDialog selectionDialog =
              new WizardDialog(MarkerActivator.getShell(), selectionWizard);
          if (selectionDialog.open() == 1)
            return;
          marker = selectionWizard.getSelectedMarker();
        }
      }



      if (marker != null && marker.exists()) {
        MappingWizard mappingWizard = new MappingWizard(marker);

        WizardDialog dialog = new WizardDialog(MarkerActivator.getShell(), mappingWizard);

        if (dialog.open() == org.eclipse.jface.window.Window.OK) {
          System.out.println("Ok pressed");
        } else {
          System.out.println("Cancel pressed");
        }
      } else {
        MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
            "There is no marker in this position", null, "Please select valid marker",
            MessageDialog.INFORMATION, new String[] {"OK"}, 0);
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

              WizardDialog dialog = new WizardDialog(MarkerActivator.getShell(), mappingWizard);

              if (dialog.open() == org.eclipse.jface.window.Window.OK) {
                System.out.println("Ok pressed");
              } else {
                System.out.println("Cancel pressed");
              }
            } else {
              MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
                  "There is no marker in this position", null, "Please select valid marker",
                  MessageDialog.INFORMATION, new String[] {"OK"}, 0);
              dialog.open();
            }
          } catch (CoreException e) {
            e.printStackTrace();
          }
        } else if (!((EObject) treeSelection.getFirstElement() instanceof EModelElement)) {
          try {
            URI uri = EcoreUtil.getURI((EObject) treeSelection.getFirstElement());

            IMarker marker;
            marker = MarkerFactory.findMarkersByUri(file, uri.toString());

            if (marker != null && marker.exists()) {
              MappingWizard mappingWizard = new MappingWizard(marker);

              WizardDialog dialog = new WizardDialog(MarkerActivator.getShell(), mappingWizard);

              if (dialog.open() == org.eclipse.jface.window.Window.OK) {
                System.out.println("Ok pressed");
              } else {
                System.out.println("Cancel pressed");
              }
            } else {
              MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
                  "There is no marker in this position", null, "Please select valid marker",
                  MessageDialog.INFORMATION, new String[] {"OK"}, 0);
              dialog.open();
            }
          } catch (CoreException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
