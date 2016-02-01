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
package eu.modelwriter.marker.ui.internal.wizards.markallinwswizard;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class MarkAllInWsContentProvider implements ITreeContentProvider {

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
    if (parentElement instanceof IProject) {
      if (((IProject) parentElement).isOpen()) {
        try {
          return ((IProject) parentElement).members();
        } catch (CoreException e) {
          e.printStackTrace();
        }
      }
    } else if (parentElement instanceof IFolder) {
      try {
        return ((IFolder) parentElement).members();
      } catch (CoreException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @Override
  public Object getParent(Object element) {
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {
    if (element instanceof IProject) {
      try {
        if (((IProject) element).isOpen()) {
          if (((IProject) element).members().length != 0)
            return true;
          else
            return false;
        }
      } catch (CoreException e) {
        e.printStackTrace();
      }
    } else if (element instanceof IFolder) {
      try {
        if (((IFolder) element).members().length != 0)
          return true;
        else
          return false;
      } catch (CoreException e) {
        e.printStackTrace();
      }
    }
    return false;
  }
}
