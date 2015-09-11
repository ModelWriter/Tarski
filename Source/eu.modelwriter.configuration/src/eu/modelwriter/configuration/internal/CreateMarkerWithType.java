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
package eu.modelwriter.configuration.internal;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;

import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class CreateMarkerWithType {

  public static IMarker createMarker(IResource resource, ISelection selection, String type) {
    IMarker marker = null;
    if (selection instanceof ITextSelection) {
      marker = MarkerFactory.createMarker(resource, (ITextSelection) selection);
    } else if (selection instanceof ITreeSelection) {
      marker = MarkerFactory.createMarker(resource, (ITreeSelection) selection);
    }

    MarkUtilities.setType(marker, type);

    AlloyUtilities.addTypeToMarker(marker);

    return marker;
  }
}
