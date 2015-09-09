/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ferhat Erata - initial API and implementation H. Emre Kirmizi - initial API and
 * implementation Serhat Celik - initial API and implementation U. Anil Ozturk - initial API and
 * implementation
 *******************************************************************************/
package eu.modelwriter.marker.command;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkElementUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.internal.MarkerUpdater;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerWizard;
import eu.modelwriter.marker.ui.internal.wizards.selectionwizard.SelectionWizard;

public class AddRemoveTypeHandler extends AbstractHandler {
  IFile file;
  ISelection selection;

  private void addRemoveType() {
    this.file = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .getActiveEditor().getEditorInput().getAdapter(IFile.class);
    this.selection =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

    if (!MarkerPage.isParsed()) {
      MessageDialog parseCtrlDialog =
          new MessageDialog(MarkerActivator.getShell(), "Type Information", null,
              "You dont have any marker type registered to system! \n"
                  + "Please parse an alloy file first",
              MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      parseCtrlDialog.open();
      return;
    }

    MessageDialog actionSelectionDialog = new MessageDialog(MarkerActivator.getShell(),
        "Select Action", null, "Which action do you want to do ?!", MessageDialog.INFORMATION,
        new String[] {"Add Type", "Remove Current Type"}, 0);
    actionSelectionDialog.open();

    IMarker selectedMarker = this.getMarker();

    if ((selectedMarker != null) && selectedMarker.exists()) {
      if (actionSelectionDialog.getReturnCode() == 0) {
        this.addType(selectedMarker);
      } else {
        this.removeType(selectedMarker);
      }
    } else {
      MessageDialog dialog =
          new MessageDialog(MarkerActivator.getShell(), "There is no marker in this position", null,
              "Please select valid marker", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();
      return;
    }

    MarkerUpdater.updateTargets(selectedMarker);
    MarkerUpdater.updateSources(selectedMarker);
  }

  private void addType(IMarker selectedMarker) {
    MarkerWizard markerWizard = new MarkerWizard(selectedMarker);

    WizardDialog dialog = new WizardDialog(MarkerActivator.getShell(), markerWizard);

    if (dialog.open() == org.eclipse.jface.window.Window.OK) {
      System.out.println("Ok pressed");
    } else {
      System.out.println("Cancel pressed");
    }
  }

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    this.addRemoveType();
    return null;

  }

  private IMarker getMarker() {
    IMarker selectedMarker = null;
    if (this.selection instanceof ITextSelection) {
      ITextSelection textSelection = (ITextSelection) this.selection;

      ArrayList<IMarker> markerList =
          MarkerFactory.findMarkersInSelection(this.file, textSelection);
      if (markerList != null) {
        if (markerList.size() == 1) {
          selectedMarker = markerList.get(0);
        } else if (markerList.size() > 1) {
          SelectionWizard selectionWizard = new SelectionWizard(markerList);
          WizardDialog selectionDialog =
              new WizardDialog(MarkerActivator.getShell(), selectionWizard);
          if (selectionDialog.open() == 1) {
            return null;
          }
          selectedMarker = selectionWizard.getSelectedMarker();
        }
      }
    } else if (this.selection instanceof ITreeSelection) {
      IEditorPart editor =
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
      ITreeSelection treeSelection = (ITreeSelection) this.selection;
      if ((this.selection != null) && (editor instanceof EcoreEditor)) {
        if ((treeSelection.getFirstElement() instanceof ENamedElement)
            && (((ENamedElement) treeSelection.getFirstElement()).getName() != null)
            && !((ENamedElement) treeSelection.getFirstElement()).getName().isEmpty()) {

          URI uri = EcoreUtil.getURI((ENamedElement) treeSelection.getFirstElement());

          selectedMarker = MarkerFactory.findMarkersByUri(this.file, uri.toString());
        } else if (!((EObject) treeSelection.getFirstElement() instanceof EModelElement)) {
          URI uri = EcoreUtil.getURI((EObject) treeSelection.getFirstElement());
          selectedMarker = MarkerFactory.findMarkersByUri(this.file, uri.toString());
        }
      }
    }
    return selectedMarker;
  }

  private void removeType(IMarker selectedMarker) {
    if (MarkElementUtilities.getGroupId(selectedMarker) != null) {
      List<IMarker> group = MarkerFactory.findMarkersByGroupId(selectedMarker.getResource(),
          MarkElementUtilities.getGroupId(selectedMarker));
      for (IMarker iMarker : group) {
        AlloyUtilities.removeTypeFromMarker(iMarker);
        MarkElementUtilities.setType(iMarker, null);
      }
    } else {
      AlloyUtilities.removeTypeFromMarker(selectedMarker);
      MarkElementUtilities.setType(selectedMarker, null);
    }
    MessageDialog removeSuccessDialog = new MessageDialog(MarkerActivator.getShell(),
        "Removing Type Action", null, "Selected marker's type has been removed.",
        MessageDialog.INFORMATION, new String[] {"OK"}, 0);
    removeSuccessDialog.open();
  }
}
