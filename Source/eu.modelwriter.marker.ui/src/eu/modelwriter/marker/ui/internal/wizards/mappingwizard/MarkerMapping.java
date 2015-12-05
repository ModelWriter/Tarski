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
  private static IMarker marker;
  private static MarkerMapping manager;

  public static MarkerMapping getInstance() {
    if (MarkerMapping.manager == null) {
      MarkerMapping.manager = new MarkerMapping();
    }
    return MarkerMapping.manager;
  }

  IEditorPart editor;
  IFile file;
  ISelection selection;

  private MarkerMapping() {}

  private void chooseForAction(final IMarker iMarker) {
    if (MarkUtilities.getType(iMarker) != null) {
      this.goForRelPage(iMarker);
    } else {
      this.goForMapPage(iMarker);
    }
  }

  private IMarker getMarker() {
    IMarker iMarker = null;
    if (this.selection instanceof ITextSelection) {
      final TextSelection textSelection = (TextSelection) this.selection;

      final ArrayList<IMarker> markerList =
          MarkerFactory.findMarkersInSelection(this.file, textSelection);
      if (markerList != null) {
        if (markerList.size() == 1) {
          iMarker = markerList.get(0);
        } else if (markerList.size() > 1) {
          final SelectionWizard selectionWizard = new SelectionWizard(markerList);
          final WizardDialog selectionDialog =
              new WizardDialog(MarkerActivator.getShell(), selectionWizard);
          if (selectionDialog.open() == 1) {
            return null;
          }
          iMarker = selectionWizard.getSelectedMarker();
        }
      }
    } else if (this.selection instanceof ITreeSelection) {
      final ITreeSelection treeSelection = (ITreeSelection) this.selection;
      if (this.selection != null
          && ((ITreeSelection) this.selection).getFirstElement() instanceof IMarker) {
        iMarker = (IMarker) ((ITreeSelection) this.selection).getFirstElement();
      } else if (this.selection != null && this.editor instanceof EcoreEditor) {
        if (treeSelection.getFirstElement() instanceof ENamedElement
            && ((ENamedElement) treeSelection.getFirstElement()).getName() != null
            && !((ENamedElement) treeSelection.getFirstElement()).getName().isEmpty()) {

          final URI uri = EcoreUtil.getURI((ENamedElement) treeSelection.getFirstElement());

          iMarker = MarkerFactory.findMarkersByUri(this.file, uri.toString());
        } else if (!((EObject) treeSelection.getFirstElement() instanceof EModelElement)) {
          final URI uri = EcoreUtil.getURI((EObject) treeSelection.getFirstElement());
          iMarker = MarkerFactory.findMarkersByUri(this.file, uri.toString());
        }
      }
    }
    return iMarker;
  }

  private void goForMapPage(final IMarker iMarker) {
    final MappingWizard relationWizard = new MappingWizard(iMarker, false);

    final WizardDialog dialog = new WizardDialog(MarkerActivator.getShell(), relationWizard);
    dialog.open();
  }

  private void goForRelPage(final IMarker iMarker) {
    final MappingWizard relationWizard = new MappingWizard(iMarker, true);

    final WizardDialog dialog = new WizardDialog(MarkerActivator.getShell(), relationWizard);
    dialog.open();
  }

  private void run() {
    if (MarkerMapping.marker != null && MarkerMapping.marker.exists()) {
      this.chooseForAction(MarkerMapping.marker);
    } else {
      final MessageDialog dialog =
          new MessageDialog(MarkerActivator.getShell(), "There is no marker in this position", null,
              "Please select valid marker", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();
    }
  }

  /**
   * it takes marker and then it runs mapping
   *
   * @param marker
   */
  public void runWithMarker(final IMarker marker) {
    MarkerMapping.marker = marker;
    this.run();
  }

  /**
   * it gets active editor and selection, and find marker then it runs mapping
   */
  public void runWithSelection() {
    this.selection = MarkerFactory.getSelection();
    this.file = MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);
    this.editor =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

    MarkerMapping.marker = this.getMarker();
    this.run();
  }
}
