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

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MasterViewTreeContentProvider implements ITreeContentProvider {

  @Override
  public void dispose() {}

  @Override
  public Object[] getChildren(Object parentElement) {
    if (parentElement instanceof IMarker) {
      IMarker iMarker = (IMarker) parentElement;
      List<IMarker> groupElements = MarkerFactory.findMarkersByGroupId(iMarker.getResource(),
          MarkUtilities.getGroupId(iMarker));
      groupElements.remove(iMarker);

      return groupElements.toArray();
    } else {
      return null;
    }
  }

  @Override
  public Object[] getElements(Object inputElement) {
    if (inputElement instanceof Object[]) {
      return (Object[]) inputElement;
    } else {
      return new Object[0];
    }
  }

  @Override
  public Object getParent(Object element) {
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {
    if (element instanceof IMarker) {
      IMarker iMarker = (IMarker) element;
      if ((MarkUtilities.getLeaderId(iMarker) != null)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
}
