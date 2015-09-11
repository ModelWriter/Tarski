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
package eu.modelwriter.marker.model.decorators;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;

import eu.modelwriter.marker.internal.MarkerFactory;

public class FileDecorator extends LabelProvider implements ILightweightLabelDecorator {

  public static final String ICON = "/icons/Black.gif";
  private static Color color = new Color(null, 255, 192, 0);

  @Override
  public void decorate(Object resource, IDecoration decoration) {
    int markers = MarkerFactory.findMarkers((IResource) resource).size();
    if (markers > 0) {
      decoration.addOverlay(ImageDescriptor.createFromFile(FileDecorator.class, ICON),
          IDecoration.TOP_RIGHT);
      decoration.setForegroundColor(color);
    } else {
      decoration.addOverlay(null);
      decoration.setForegroundColor(new Color(null, 0, 0, 0, 0));
    }
  }
}
