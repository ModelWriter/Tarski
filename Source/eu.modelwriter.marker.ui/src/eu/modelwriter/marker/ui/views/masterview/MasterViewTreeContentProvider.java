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
package eu.modelwriter.marker.ui.views.masterview;

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkElementUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MasterViewTreeContentProvider implements ITreeContentProvider {

  @Override
  public void dispose() {}

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

  @Override
  public Object[] getElements(Object inputElement) {
    if (inputElement instanceof Object[]) {
      return (Object[]) inputElement;
    } else {
      return new Object[0];
    }
  }

  @Override
  public Object[] getChildren(Object parentElement) {
    if (parentElement instanceof MarkElement) {
      MarkElement markedElement = (MarkElement) parentElement;
      IMarker marked = markedElement.getiMarker();
      List<IMarker> groupElements = MarkerFactory.findMarkersByGroupId(marked.getResource(),
          MarkElementUtilities.getGroupId(marked));
      groupElements.remove(marked);
      MarkElement markers[] = new MarkElement[groupElements.size()];
      int i = 0;
      for (IMarker iMarker : groupElements) {
        markers[i] = new MarkElement(iMarker);
        i++;
      }
      return markers;
    } else
      return null;
  }

  @Override
  public Object getParent(Object element) {
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {
    if (element instanceof MarkElement) {
      MarkElement markedElement = (MarkElement) element;
      IMarker marked = markedElement.getiMarker();
      if (marked != null && MarkElementUtilities.getLeaderId(marked) != null) {
        return true;
      }
    }
    return false;
  }
}
