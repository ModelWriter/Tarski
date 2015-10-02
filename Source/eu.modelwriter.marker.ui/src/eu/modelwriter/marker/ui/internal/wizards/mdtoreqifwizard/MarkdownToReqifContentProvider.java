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
package eu.modelwriter.marker.ui.internal.wizards.mdtoreqifwizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.Specification;
import org.eclipse.rmf.reqif10.impl.ReqIFImpl;

public class MarkdownToReqifContentProvider implements ITreeContentProvider {

  @Override
  public void dispose() {}

  @Override
  public Object[] getChildren(Object parentElement) {

    if (parentElement instanceof IProject) {
      try {
        return ((IProject) parentElement).members();
      } catch (CoreException e) {
        e.printStackTrace();
      }

    } else if (parentElement instanceof IFolder) {
      try {
        return ((IFolder) parentElement).members();
      } catch (CoreException e) {
        e.printStackTrace();
      }
    } else if (parentElement instanceof IFile) {
      IFile file = (IFile) parentElement;
      ResourceSet load = new ResourceSetImpl();
      Resource res = load.getResource(URI.createURI(file.getLocationURI().toString()), true);
      EList<EObject> list = res.getContents();
      for (EObject eObject : list) {
        if (eObject instanceof ReqIFImpl) {
          ReqIFImpl content = (ReqIFImpl) eObject;
          return content.getCoreContent().getSpecifications().toArray();
        }
      }
    } else if (parentElement instanceof Specification) {
      Specification spec = (Specification) parentElement;
      return spec.getChildren().toArray();
    } else if (parentElement instanceof SpecHierarchy) {
      SpecHierarchy specHier = (SpecHierarchy) parentElement;
      return specHier.getChildren().toArray();
    }
    return null;
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

    if (element instanceof IProject) {
      try {
        if (((IProject) element).members().length != 0) {
          return true;
        } else {
          return false;
        }
      } catch (CoreException e) {
        e.printStackTrace();
      }
    } else if (element instanceof IFolder) {
      try {
        if (((IFolder) element).members().length != 0) {
          return true;
        } else {
          return false;
        }
      } catch (CoreException e) {
        e.printStackTrace();
      }
    } else if (element instanceof IFile) {
      IFile file = (IFile) element;
      ResourceSet load = new ResourceSetImpl();
      Resource res = load.getResource(URI.createURI(file.getLocationURI().toString()), true);
      EList<EObject> list = res.getContents();
      for (EObject eObject : list) {
        if (eObject instanceof ReqIFImpl) {
          ReqIFImpl content = (ReqIFImpl) eObject;
          return !content.getCoreContent().getSpecifications().isEmpty();
        }
      }
    } else if (element instanceof Specification) {
      Specification spec = (Specification) element;
      return !spec.getChildren().isEmpty();
    } else if (element instanceof SpecHierarchy) {
      SpecHierarchy specHier = (SpecHierarchy) element;
      return !specHier.getChildren().isEmpty();
    }
    return false;
  }

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
}
