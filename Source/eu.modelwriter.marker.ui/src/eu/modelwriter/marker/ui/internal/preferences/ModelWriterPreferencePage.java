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
package eu.modelwriter.marker.ui.internal.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

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
    Composite container = new Composite(parent, SWT.NULL);
    container.setLayout(new FormLayout());

    return container;
  }

  /**
   * Initialize the preference page.
   */
  @Override
  public void init(IWorkbench workbench) {}
}
