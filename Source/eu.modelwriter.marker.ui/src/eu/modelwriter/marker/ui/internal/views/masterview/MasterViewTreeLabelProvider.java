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
package eu.modelwriter.marker.ui.internal.views.masterview;

import java.net.URL;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

import eu.modelwriter.marker.internal.MarkUtilities;

public class MasterViewTreeLabelProvider extends LabelProvider {

  public static ImageDescriptor getImageDescriptor(final String bundleID, final String path) {
    assert(bundleID != null) : "No bundle defined";
    assert(path != null) : "No path defined";

    // if the bundle is not ready then there is no image
    final Bundle bundle = Platform.getBundle(bundleID);
    final int bundleState = bundle.getState();
    if ((bundleState != Bundle.ACTIVE) && (bundleState != Bundle.STARTING)
        && (bundleState != Bundle.RESOLVED)) {
      return null;
    }

    // look for the image (this will check both the plugin and fragment
    // folders
    final URL imagePath = FileLocator.find(bundle, new Path(path), null);

    if (imagePath != null) {
      return ImageDescriptor.createFromURL(imagePath);
    }

    return null;
  }

  private ImageDescriptor mDescriptor = MasterViewTreeLabelProvider
      .getImageDescriptor("org.eclipse.ui", "/icons/full/eview16/tasks_tsk.gif");

  @Override
  public Image getImage(Object element) {
    return this.mDescriptor.createImage();
  }

  @Override
  public String getText(Object element) {
    if (element instanceof IMarker) {
      IMarker iMarker = (IMarker) element;
      if (MarkUtilities.getType(iMarker) == null)
        return MarkUtilities.getText(iMarker);
      return MarkUtilities.getText(iMarker) + " [T: " + MarkUtilities.getType(iMarker) + "]";
    } else {
      return "Unknown type: " + element.getClass();
    }
  }
}
