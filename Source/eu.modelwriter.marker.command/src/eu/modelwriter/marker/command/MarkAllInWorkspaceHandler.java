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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.wizards.markallinwswizard.MarkAllInWsWizard;

public class MarkAllInWorkspaceHandler extends AbstractHandler {
  public static String COMMAND_ID = "eu.modelwriter.marker.command.markallinworkspace";

  IFile file;
  ISelection selection;

  private void createMarkersWs() {
    ITextSelection textSelection = (ITextSelection) this.selection;
    if (MarkerFactory.findMarkerWithAbsolutePosition(this.file, textSelection.getOffset(),
        textSelection.getOffset() + textSelection.getLength()) != null) {
      MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
          "In these area, there is already a marker", MessageDialog.WARNING, new String[] {"OK"},
          0);
      dialog.open();
      return;
    } else {
      MarkAllInWsWizard markAllWsWizard = new MarkAllInWsWizard(textSelection, this.file);
      WizardDialog selectionDialog = new WizardDialog(MarkerActivator.getShell(), markAllWsWizard);
      selectionDialog.open();
    }
  }

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    if (AlloyUtilities.isExists()) {
      this.file = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
          .getActiveEditor().getEditorInput().getAdapter(IFile.class);
      this.selection =
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

      this.createMarkersWs();
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
