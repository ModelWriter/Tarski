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
package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.dialogs.MessageDialog;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MarkerMapping;

public class MappingCommand {
  static IMarker marker;

  public static void run(final IMarker marker) {
    MappingCommand.marker = marker;
    if (AlloyUtilities.isExists()) {
      MarkerMapping.getInstance().run();
      if (Activator.getDefault().getWorkbench().getWorkbenchWindows()[0].getActivePage()
          .findView(Visualization.ID) != null) {
        Visualization.showViz(Visualization.container);
      }
    } else {
      final MessageDialog infoDialog = new MessageDialog(Activator.getShell(), "System Information",
          null, "You dont have any registered alloy file to system.", MessageDialog.INFORMATION,
          new String[] {"OK"}, 0);
      infoDialog.open();
    }
    return;
  }
}
