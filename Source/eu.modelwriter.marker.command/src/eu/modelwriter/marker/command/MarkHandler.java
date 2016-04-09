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
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MappingUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MarkHandler extends AbstractHandler {
  public static String COMMAND_ID = "eu.modelwriter.marker.command.mark";

  IEditorPart editor;
  IFile file;
  ISelection selection;

  private void addToAlloyXML(final IMarker beAdded) {
    AlloyUtilities.addMarkerToRepository(beAdded);
  }

  private void createMarker() {
    this.editor =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    this.file = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .getActiveEditor().getEditorInput().getAdapter(IFile.class);
    this.selection =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

    final IMarker beAdded = this.getMarker();
    @SuppressWarnings("unused")
    String text = "";
    if (this.selection instanceof ITextSelection) {
      if (beAdded != null && beAdded.exists()) {
        text = ((ITextSelection) this.selection).getText();
        AnnotationFactory.addAnnotation(beAdded, AnnotationFactory.ANNOTATION_MARKING);
        MappingUtilities.addTextLocation(beAdded, null);
      }
    } else if (this.selection instanceof ITreeSelection) {
      if (this.editor instanceof EcoreEditor) {
        final ITreeSelection treeSelection = (ITreeSelection) this.selection;
        if (beAdded != null && beAdded.exists()) {
          if (treeSelection.getFirstElement() instanceof EModelElement) {
            text = ((ENamedElement) treeSelection.getFirstElement()).getName();
          } else {
            text = MarkUtilities.getText(beAdded);
          }
          MappingUtilities.addEObjectLocation(beAdded, (EObject) treeSelection.getFirstElement(),
              null);
        }
      }
    }
    if (AlloyUtilities.isExists())
      this.addToAlloyXML(beAdded);



    // MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
    // null,
    // "\"" + text + "\" has been selected to be marked", MessageDialog.INFORMATION,
    // new String[] {"OK"}, 0);
    // dialog.open();
  }

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    // if (AlloyUtilities.isExists()) {
    this.createMarker();
    this.refresh();
    // } else {
    // final MessageDialog infoDialog = new MessageDialog(MarkerActivator.getShell(),
    // "System Information", null, "You dont have any registered alloy file to system.",
    // MessageDialog.INFORMATION, new String[] {"OK"}, 0);
    // infoDialog.open();
    // }
    return null;
  }

  private IMarker getMarker() {
    IMarker beAdded = null;
    if (this.selection instanceof ITextSelection) {
      beAdded = MarkerFactory.createMarker(this.file, (ITextSelection) this.selection);
    } else if (this.selection instanceof ITreeSelection) {
      if (this.editor instanceof EcoreEditor) {
        final ITreeSelection treeSelection = (ITreeSelection) this.selection;
        beAdded = MarkerFactory.createMarker(this.file, treeSelection);
      }
    }

    return beAdded;
  }

  private void refresh() {
    MarkerFactory.refreshProjectExp();
  }
}
