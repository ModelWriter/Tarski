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
package eu.modelwriter.marker.ui.internal.wizards.mappingwizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE.SharedImages;

import eu.modelwriter.marker.internal.MarkUtilities;

public class WizardTreeViewLabelProvider extends LabelProvider {

  @Override
  public Image getImage(Object element) {
    if (element instanceof IProject) {
      if (((IProject) element).isOpen()) {
        return PlatformUI.getWorkbench().getSharedImages().getImage(SharedImages.IMG_OBJ_PROJECT);
      } else {
        return PlatformUI.getWorkbench().getSharedImages()
            .getImage(SharedImages.IMG_OBJ_PROJECT_CLOSED);
      }
    } else if (element instanceof IFolder) {
      return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
    } else if (element instanceof IFile) {
      return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
    } else if (element instanceof IMarker) {
      return PlatformUI.getWorkbench().getSharedImages().getImage(SharedImages.IMG_OPEN_MARKER);
    }

    return null;
  }

  @Override
  public String getText(Object element) {

    if (element instanceof IResource) {
      return ((IResource) element).getName();
    } else if (element instanceof IMarker) {
      String str;
      if (MarkUtilities.getType((IMarker) element) != null) {
        str = MarkUtilities.getText((IMarker) element) + "{"
            + MarkUtilities.getType((IMarker) element) + "}";
        return str;
      } else {
        return MarkUtilities.getText((IMarker) element);
      }
    } else {
      return "Unknown type: " + element.getClass();
    }
  }
}
