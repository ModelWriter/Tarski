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
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MappingWizard;

public class MappingCommand {
  private static void chooseForAction(final IMarker iMarker) {
    if (MarkUtilities.getType(iMarker) != null) {
      MappingCommand.goForRelPage(iMarker);
    } else {
      MappingCommand.goForMapPage(iMarker);
    }
  }

  private static void goForMapPage(final IMarker iMarker) {
    final MappingWizard relationWizard = new MappingWizard(iMarker, false);
    final WizardDialog dialog = new WizardDialog(new Shell(), relationWizard);
    dialog.open();
  }

  private static void goForRelPage(final IMarker iMarker) {
    final MappingWizard relationWizard = new MappingWizard(iMarker, true);
    final WizardDialog dialog = new WizardDialog(new Shell(), relationWizard);
    dialog.open();
  }

  public static void run(final IMarker marker) {
    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        if (AlloyUtilities.isExists()) {
          if (marker != null && marker.exists()) {
            MappingCommand.chooseForAction(marker);
            Visualization.showViz(Visualization.container);
          } else {
            final MessageDialog dialog = new MessageDialog(new Shell(),
                "There is no marker in this position", null, "Please select valid marker",
                MessageDialog.INFORMATION, new String[] {"OK"}, 0);
            dialog.open();
          }
        } else {
          final MessageDialog infoDialog = new MessageDialog(new Shell(), "System Information",
              null, "You dont have any registered alloy file to system.", MessageDialog.INFORMATION,
              new String[] {"OK"}, 0);
          infoDialog.open();
        }
      }
    });
    return;
  }
}
