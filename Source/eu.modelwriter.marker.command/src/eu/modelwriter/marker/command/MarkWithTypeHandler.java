/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ferhat Erata - initial API and implementation
 *     H. Emre Kirmizi - initial API and implementation
 *     Serhat Celik - initial API and implementation
 *     U. Anil Ozturk - initial API and implementation
 *******************************************************************************/
package eu.modelwriter.marker.command;

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
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerWizard;

public class MarkWithTypeHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {

    if (!MarkerPage.isParsed()) {
      MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Type Information", null,
          "You dont have any marker type registered to system! \n"
              + "Please parse an alloy file first",
          MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();
      return null;
    }

    ISelection selection = MarkerFactory.getSelection();
    IFile file = (IFile) MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);
    if (selection instanceof ITextSelection) {
      ITextSelection textSelection = (ITextSelection) selection;
      if (textSelection.getLength() == 0) {
        MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
            null, "Please make a valid selection", MessageDialog.WARNING, new String[] {"OK"}, 0);
        dialog.open();
        return null;
      }
      if (selection instanceof ITextSelection
          && MarkerFactory.findMarkerWithAbsolutePosition(file, textSelection.getOffset(),
              textSelection.getOffset() + textSelection.getLength()) != null) {
        MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
            null, "In these area, there is already a marker", MessageDialog.WARNING,
            new String[] {"OK"}, 0);
        dialog.open();
        return null;
      }

      MarkerWizard markerWizard = new MarkerWizard(selection, file);

      WizardDialog dialog = new WizardDialog(MarkerActivator.getShell(), markerWizard);

      if (dialog.open() == org.eclipse.jface.window.Window.OK) {
        System.out.println("Ok pressed");
      } else {
        System.out.println("Cancel pressed");
      }
    } else if (selection instanceof TreeSelection) {
      ITreeSelection treeSelection = (ITreeSelection) selection;
      IEditorPart editor =
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
      if (selection != null && editor instanceof EcoreEditor) {
        if (treeSelection.getFirstElement() instanceof ENamedElement
            && ((ENamedElement) treeSelection.getFirstElement()).getName() != null
            && !((ENamedElement) treeSelection.getFirstElement()).getName().isEmpty()) {
          URI uri = EcoreUtil.getURI((ENamedElement) treeSelection.getFirstElement());

          IMarker selectedMarker;

          selectedMarker = MarkerFactory.findMarkersByUri(file, uri.toString());

          if (selectedMarker != null && selectedMarker.exists()) {
            MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Marker Info",
                null, "There is already a marker in this position", MessageDialog.INFORMATION,
                new String[] {"OK"}, 0);
            dialog.open();
          } else {
            MarkerWizard markerWizard = new MarkerWizard(selection, file);

            WizardDialog dialog = new WizardDialog(MarkerActivator.getShell(), markerWizard);

            if (dialog.open() == org.eclipse.jface.window.Window.OK) {
              System.out.println("Ok pressed");
            } else {
              System.out.println("Cancel pressed");
            }
          }
        } else if (!((EObject) treeSelection.getFirstElement() instanceof EModelElement)) {
          URI uri = EcoreUtil.getURI((EObject) treeSelection.getFirstElement());

          IMarker selectedMarker;
          selectedMarker = MarkerFactory.findMarkersByUri(file, uri.toString());

          if (selectedMarker != null && selectedMarker.exists()) {
            MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
                "There is no marker in this position", null, "Please select valid marker",
                MessageDialog.INFORMATION, new String[] {"OK"}, 0);
            dialog.open();
          } else {
            MarkerWizard markerWizard = new MarkerWizard(selection, file);

            WizardDialog dialog = new WizardDialog(MarkerActivator.getShell(), markerWizard);

            if (dialog.open() == org.eclipse.jface.window.Window.OK) {
              System.out.println("Ok pressed");
            } else {
              System.out.println("Cancel pressed");
            }
          }
        }
      }
    }

    return null;
  }
}
