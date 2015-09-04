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
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkElementUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MarkHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    ISelection selection =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

    IFile file = (IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .getActiveEditor().getEditorInput().getAdapter(IFile.class);

    IEditorPart editor =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

    IMarker myMarker = null;

    if (selection instanceof ITextSelection) {

      myMarker = MarkerFactory.createMarker(file, (ITextSelection) selection);

      if (myMarker != null && myMarker.exists()) {
        AnnotationFactory.addAnnotation(myMarker, editor, AnnotationFactory.ANNOTATION_MARKING);
        MessageDialog dialog =
            new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
                "\"" + ((ITextSelection) selection).getText()
                    + "\" has been seleceted to be marked",
                MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
      }
    } else if (selection instanceof ITreeSelection) {
      if (editor instanceof EcoreEditor) {
        ITreeSelection treeSelection = (ITreeSelection) selection;
        myMarker = MarkerFactory.createMarker(file, treeSelection);

        if (myMarker != null && myMarker.exists()) {
          String message = null;
          if (treeSelection.getFirstElement() instanceof EModelElement)
            message = ((ENamedElement) treeSelection.getFirstElement()).getName();
          else
            message = MarkElementUtilities.getMessage(myMarker);
          MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
              null, "\"" + message + "\" has been seleceted to be marked",
              MessageDialog.INFORMATION, new String[] {"OK"}, 0);
          dialog.open();
        }
      }
    }
    MarkerFactory.refreshProjectExp();
    return null;
  }
}
