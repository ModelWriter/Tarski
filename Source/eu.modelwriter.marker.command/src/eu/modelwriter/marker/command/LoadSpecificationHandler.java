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
import org.eclipse.jface.dialogs.MessageDialog;

import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.alloy.trace.TraceManager;
import eu.modelwriter.marker.MarkerActivator;

public abstract class LoadSpecificationHandler extends AbstractHandler {
  public static String COMMAND_ID = "eu.modelwriter.marker.command.parsealloy";

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final MessageDialog warningdialog =
        new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
            "If new alloy file will be parsed , your all marker type will be lost !",
            MessageDialog.WARNING, new String[] {"OK", "Cancel"}, 0);
    if (warningdialog.open() != 0) {
      return null;
    }

    final String filePath = getFilePath();
    if (filePath == null) {
      return null;
    }
    AlloyParseUtil.parse(filePath);

    try {
      TraceManager.get().loadSpec(filePath);
    } catch (final TraceException e) {
      e.printStackTrace();
    }
    return null;
  }

  protected abstract String getFilePath();
}
