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
package eu.modelwriter.marker.ui.internal.wizards.selectionwizard;

import org.eclipse.core.resources.IMarker;

import eu.modelwriter.marker.internal.MarkUtilities;

public class MarkerColumn extends Column {

  public MarkerColumn() {}

  @Override
  public String getText(Object element) {
    if (element instanceof IMarker) {
      return MarkUtilities.getText((IMarker) element);
    }
    return "";
  }

  @Override
  public String getTitle() {
    return "Marker";
  }
}
