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

import java.util.UUID;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MarkAllHandler extends AbstractHandler {
  public static String COMMAND_ID = "eu.modelwriter.marker.command.markall";

  IEditorPart editor;
  IFile file;
  ISelection selection;

  private void addToAlloyXML(IMarker beAdded) {
    AlloyUtilities.addMarkerToRepository(beAdded);
  }

  private void createMarkers() {
    this.editor =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    this.file = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .getActiveEditor().getEditorInput().getAdapter(IFile.class);
    this.selection =
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

    ITextSelection textSelection = (ITextSelection) this.selection;

    if (MarkerFactory.findMarkerWithAbsolutePosition(this.file, textSelection.getOffset(),
        textSelection.getOffset() + textSelection.getLength()) != null) {

      MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
          "In these area, there is already a marker", MessageDialog.WARNING, new String[] {"OK"},
          0);
      dialog.open();
    } else {
      String content = MarkerFactory.getCurrentEditorContent();
      int index = 0;
      int offset = 0;
      int length = textSelection.getLength();
      String id = UUID.randomUUID().toString();
      String leader_id = UUID.randomUUID().toString();

      if (length != 0) {
        while ((offset =
            content.toLowerCase().indexOf(textSelection.getText().toLowerCase(), index)) != -1) {
          TextSelection nextSelection =
              new TextSelection(MarkerFactory.getDocument(), offset, length);
          if (MarkerFactory.findMarkerWithAbsolutePosition(this.file, offset,
              offset + length) == null) {
            IMarker mymarker = MarkerFactory.createMarker(this.file, nextSelection);
            MarkUtilities.setGroupId(mymarker, id);
            if (textSelection.getOffset() == offset) {
              MarkUtilities.setLeaderId(mymarker, leader_id);
            }
            AnnotationFactory.addAnnotation(mymarker, AnnotationFactory.ANNOTATION_MARKING);
            if (AlloyUtilities.isExists())
              this.addToAlloyXML(mymarker);
          }
          index = offset + length;
        }
        // MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
        // "Mark Information will be provided by this wizard.", null,
        // "\"" + textSelection.getText() + "\" has been selected to be marked",
        // MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        // dialog.open();
      } else {
        MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
            "Mark Information will be provided by this wizard.", null,
            "Please select a valid information", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
      }
    }
  }

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    if (AlloyUtilities.isExists()) {
      this.createMarkers();
      this.refresh();
    } else {
      MessageDialog infoDialog = new MessageDialog(MarkerActivator.getShell(), "System Information",
          null, "You dont have any registered alloy file to system.", MessageDialog.INFORMATION,
          new String[] {"OK"}, 0);
      infoDialog.open();
    }
    return null;
  }

  private void refresh() {
    MarkerFactory.refreshProjectExp();
  }
}
