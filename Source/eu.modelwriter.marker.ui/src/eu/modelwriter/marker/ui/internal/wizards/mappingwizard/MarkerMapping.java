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
package eu.modelwriter.marker.ui.internal.wizards.mappingwizard;

import java.util.ArrayList;

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
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.wizards.selectionwizard.SelectionWizard;

public class MarkerMapping {

  private static MarkerMapping manager;

  public static MarkerMapping getInstance() {
    if (manager == null) {
      manager = new MarkerMapping();
    }
    return manager;
  }

  IEditorPart editor;
  IFile file;
  ISelection selection;

  private MarkerMapping() {}

  private void chooseForAction(IMarker iMarker) {
    if (MarkUtilities.getType(iMarker) != null) {
      goForRelWiz(iMarker);
    } else {
      goForMapWiz(iMarker);
    }
  }

  private IMarker getMarker() {
    IMarker iMarker = null;
    if (this.selection instanceof ITextSelection) {
      TextSelection textSelection = (TextSelection) this.selection;

      ArrayList<IMarker> markerList =
          MarkerFactory.findMarkersInSelection(this.file, textSelection);
      if (markerList != null) {
        if (markerList.size() == 1) {
          iMarker = markerList.get(0);
        } else if (markerList.size() > 1) {
          SelectionWizard selectionWizard = new SelectionWizard(markerList);
          WizardDialog selectionDialog =
              new WizardDialog(MarkerActivator.getShell(), selectionWizard);
          if (selectionDialog.open() == 1) {
            return null;
          }
          iMarker = selectionWizard.getSelectedMarker();
        }
      }
    } else if (this.selection instanceof ITreeSelection) {
      ITreeSelection treeSelection = (ITreeSelection) this.selection;
      if ((this.selection != null) && (this.editor instanceof EcoreEditor)) {
        if ((treeSelection.getFirstElement() instanceof ENamedElement)
            && (((ENamedElement) treeSelection.getFirstElement()).getName() != null)
            && !((ENamedElement) treeSelection.getFirstElement()).getName().isEmpty()) {

          URI uri = EcoreUtil.getURI((ENamedElement) treeSelection.getFirstElement());

          iMarker = MarkerFactory.findMarkersByUri(this.file, uri.toString());
        } else if (!((EObject) treeSelection.getFirstElement() instanceof EModelElement)) {
          URI uri = EcoreUtil.getURI((EObject) treeSelection.getFirstElement());
          iMarker = MarkerFactory.findMarkersByUri(this.file, uri.toString());
        }
      }
    }
    return iMarker;
  }

  private void goForMapWiz(IMarker iMarker) {
    MappingWizard mappingWizard = new MappingWizard(iMarker, false);

    WizardDialog dialog = new WizardDialog(MarkerActivator.getShell(), mappingWizard);
    dialog.open();
  }

  private void goForRelWiz(IMarker iMarker) {
    RelationWizard relationWizard = new RelationWizard(iMarker);

    WizardDialog dialog = new WizardDialog(MarkerActivator.getShell(), relationWizard);
    dialog.open();
  }

  public void run() {
    selection = MarkerFactory.getSelection();
    file = MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);
    editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

    IMarker marker = getMarker();

    if ((marker != null) && marker.exists()) {
      chooseForAction(marker);
    } else {
      MessageDialog dialog =
          new MessageDialog(MarkerActivator.getShell(), "There is no marker in this position", null,
              "Please select valid marker", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();
    }
  }
}
