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
import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerWizard;
import eu.modelwriter.marker.ui.internal.wizards.selectionwizard.SelectionWizard;

@SuppressWarnings("restriction")
public class MarkWithTypeHandler extends AbstractHandler {
  public static String COMMAND_ID = "eu.modelwriter.marker.command.markwithtype";

  IEditorPart editor;
  IFile file;
  ISelection selection;

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    if (AlloyUtilities.isExists()) {
      return markWithType();
    } else {
      final MessageDialog infoDialog = new MessageDialog(MarkerActivator.getShell(),
          "System Information", null, "You dont have any registered alloy file to system.",
          MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      infoDialog.open();
    }
    return null;
  }

  private IMarker getMarker() {
    IMarker selectedMarker = null;
    if (selection != null) {
      if (selection instanceof ITextSelection) {
        final TextSelection textSelection = (TextSelection) selection;

        final ArrayList<IMarker> markerList =
            MarkerFactory.findMarkersInSelection(file, textSelection);
        if (markerList != null) {
          if (markerList.size() == 1) {
            selectedMarker = markerList.get(0);
          } else if (markerList.size() > 1) {
            final SelectionWizard selectionWizard = new SelectionWizard(markerList);
            final WizardDialog selectionDialog =
                new WizardDialog(MarkerActivator.getShell(), selectionWizard);
            if (selectionDialog.open() == 1) {
              return null;
            }
            selectedMarker = selectionWizard.getSelectedMarker();
          }
        }
      } else if (selection instanceof ITreeSelection) {
        final ITreeSelection treeSelection = (ITreeSelection) selection;
        if (((ITreeSelection) selection).getFirstElement() instanceof IMarker) {
          selectedMarker = (IMarker) ((ITreeSelection) selection).getFirstElement();
        } else if (editor instanceof EcoreEditor) {
          if (treeSelection.getFirstElement() instanceof ENamedElement
              && ((ENamedElement) treeSelection.getFirstElement()).getName() != null
              && !((ENamedElement) treeSelection.getFirstElement()).getName().isEmpty()) {

            final URI uri = EcoreUtil.getURI((ENamedElement) treeSelection.getFirstElement());

            selectedMarker = MarkerFactory.findMarkersByUri(file, uri.toString());
          } else if (!((EObject) treeSelection.getFirstElement() instanceof EModelElement)) {
            final URI uri = EcoreUtil.getURI((EObject) treeSelection.getFirstElement());
            selectedMarker = MarkerFactory.findMarkersByUri(file, uri.toString());
          }
        } else if (editor instanceof CompilationUnitEditor) {
          selectedMarker = MarkerFactory.findMarkerByOutlineTreeSelection(treeSelection, file);
        }
      }
    }
    return selectedMarker;
  }

  private Object markWithType() {
    file = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
        .getEditorInput().getAdapter(IFile.class);
    selection =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
    editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

    if (!MarkerPage.isParsed()) {
      final MessageDialog dialog =
          new MessageDialog(MarkerActivator.getShell(), "Type Information", null,
              "You dont have any marker type registered to system! \n"
                  + "Please parse an alloy file first",
                  MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();
      return null;
    }

    final IMarker selectedMarker = getMarker();
    if (selectedMarker != null) {
      final MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
          null, "In these area, there is already a marker", MessageDialog.WARNING,
          new String[] {"OK"}, 0);
      dialog.open();
      return null;
    } else if (selection instanceof ITextSelection
        && ((ITextSelection) selection).getLength() == 0) {
      final MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
          null, "Please make a valid selection", MessageDialog.WARNING, new String[] {"OK"}, 0);
      dialog.open();
      return null;
    }

    final MarkerWizard markerWizard = new MarkerWizard(selection, file);
    final WizardDialog dialog = new WizardDialog(MarkerActivator.getShell(), markerWizard);
    dialog.open();

    Visualization.showViz();
    return null;
  }
}
