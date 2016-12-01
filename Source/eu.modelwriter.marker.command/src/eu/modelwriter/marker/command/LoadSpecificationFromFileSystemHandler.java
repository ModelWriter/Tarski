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

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;

import eu.modelwriter.marker.MarkerActivator;

public class LoadSpecificationFromFileSystemHandler extends LoadSpecificationHandler {
  @Override
  public String getFilePath() {
    final String result;
    final FileDialog dialog = new FileDialog(MarkerActivator.getShell(), SWT.OPEN);
    dialog.setFilterExtensions(new String[] {"*.mw", "*.als"});
    result = dialog.open();
    if (result == null) {
      return null;
    }
    return result;
  }
}
