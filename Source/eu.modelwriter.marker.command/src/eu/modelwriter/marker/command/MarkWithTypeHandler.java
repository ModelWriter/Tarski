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

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerWizard;

public class MarkWithTypeHandler extends AbstractHandler {
  public static String COMMAND_ID = "eu.modelwriter.marker.command.markwithtype";

  IFile file;
  ISelection selection;

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    if (AlloyUtilities.isExists()) {
      return this.markWithType();
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
    if (this.selection instanceof ITextSelection) {
      final ITextSelection textSelection = (ITextSelection) this.selection;
      selectedMarker = MarkerFactory.findMarkerWithAbsolutePosition(this.file,
          textSelection.getOffset(), textSelection.getOffset() + textSelection.getLength());
    } else if (this.selection instanceof TreeSelection) {
      final ITreeSelection treeSelection = (ITreeSelection) this.selection;
      final IEditorPart editor =
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
      if (this.selection != null && editor instanceof EcoreEditor) {
        if (treeSelection.getFirstElement() instanceof ENamedElement
            && ((ENamedElement) treeSelection.getFirstElement()).getName() != null
            && !((ENamedElement) treeSelection.getFirstElement()).getName().isEmpty()) {
          final URI uri = EcoreUtil.getURI((ENamedElement) treeSelection.getFirstElement());
          selectedMarker = MarkerFactory.findMarkersByUri(this.file, uri.toString());
        } else if (!((EObject) treeSelection.getFirstElement() instanceof EModelElement)) {
          final URI uri = EcoreUtil.getURI((EObject) treeSelection.getFirstElement());
          selectedMarker = MarkerFactory.findMarkersByUri(this.file, uri.toString());
        }
      }
    }
    return selectedMarker;
  }

  private Object markWithType() {
    this.file = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .getActiveEditor().getEditorInput().getAdapter(IFile.class);
    this.selection =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

    if (!MarkerPage.isParsed()) {
      final MessageDialog dialog =
          new MessageDialog(MarkerActivator.getShell(), "Type Information", null,
              "You dont have any marker type registered to system! \n"
                  + "Please parse an alloy file first",
              MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();
      return null;
    }

    final IMarker selectedMarker = this.getMarker();
    if (selectedMarker != null) {
      final MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
          null, "In these area, there is already a marker", MessageDialog.WARNING,
          new String[] {"OK"}, 0);
      dialog.open();
      return null;
    } else if (this.selection instanceof ITextSelection
        && ((ITextSelection) this.selection).getLength() == 0) {
      final MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
          null, "Please make a valid selection", MessageDialog.WARNING, new String[] {"OK"}, 0);
      dialog.open();
      return null;
    }

    final MarkerWizard markerWizard = new MarkerWizard(this.selection, this.file);

    final WizardDialog dialog = new WizardDialog(MarkerActivator.getShell(), markerWizard);
    dialog.open();

    Visualization.showViz(Visualization.container);
    return null;
  }
}
