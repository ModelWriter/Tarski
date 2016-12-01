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

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ide.ResourceUtil;

public class LoadSpecificationFromEditorHandler extends LoadSpecificationHandler {
  @Override
  public String getFilePath() {
    IEditorPart editor;
    editor = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .getActiveEditor();
    String result = null;
    final IFile file = ResourceUtil.getFile(editor.getEditorInput());
    result = file.getLocation().makeAbsolute().toOSString();
    return result;
  }
}
