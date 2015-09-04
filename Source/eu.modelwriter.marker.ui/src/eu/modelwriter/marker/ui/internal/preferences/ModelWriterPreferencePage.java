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
package eu.modelwriter.marker.ui.internal.preferences;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import eu.modelwriter.marker.MarkerActivator;

public class ModelWriterPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

  /**
   * Create the preference page.
   */
  public ModelWriterPreferencePage() {}

  /**
   * Create contents of the preference page.
   * 
   * @param parent
   */
  @Override
  public Control createContents(Composite parent) {
    Image image = MarkerActivator.getDefault().getImageRegistry()
        .get(MarkerActivator.Images.IMAGE_MODELWRITER_ID);
    ProgressMonitorDialog pmd = new ProgressMonitorDialog(parent.getShell());
    ProgressMonitorDialog.setDefaultImage(image);
    pmd.open();
    IProgressMonitor pmdmoni = pmd.getProgressMonitor();
    try {
      pmdmoni.beginTask("Preparing", 5000);

      for (int i = 0; i < 50 && !pmdmoni.isCanceled(); i++) {
        if (i == 10) {
          pmdmoni.subTask("Doing something");
        } else if (i == 25) {
          pmdmoni.subTask("Doing something else");
        } else if (i == 40) {
          pmdmoni.subTask("Nearly there");
        }
        Thread.sleep(100);
        pmdmoni.worked(100);
      }
    } catch (InterruptedException e) {
    } finally {
      pmdmoni.done();
    }
    MessageDialog.openInformation(null, "Hello", "World");
    pmd.close();


    Composite container = new Composite(parent, SWT.NULL);
    container.setLayout(new FormLayout());


    return container;
  }

  /**
   * Initialize the preference page.
   */
  public void init(IWorkbench workbench) {
    // Initialize the preference page
  }
}
