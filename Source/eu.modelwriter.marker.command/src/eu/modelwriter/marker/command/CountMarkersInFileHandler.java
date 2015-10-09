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

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;

public class CountMarkersInFileHandler extends AbstractHandler {
  public static String COMMAND_ID = "eu.modelwriter.marker.command.countforfile";

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    ISelection sel = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow()
        .getSelectionService().getSelection();
    if (sel instanceof ITreeSelection) {
      ITreeSelection treeSel = (ITreeSelection) sel;
      if (treeSel.getFirstElement() instanceof IFile) {
        IFile file = (IFile) treeSel.getFirstElement();
        List<IMarker> markers = MarkerFactory.findMarkers(file);
        MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Marker Count", null,
            markers.size() + " marker(s)", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
      }
    }
    return null;
  }
}
