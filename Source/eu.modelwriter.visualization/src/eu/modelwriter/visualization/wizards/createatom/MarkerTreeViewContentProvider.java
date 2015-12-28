/// *******************************************************************************
// * Copyright (c) 2015 UNIT Information Technologies R&D Ltd All rights reserved. This program and
// * the accompanying materials are made available under the terms of the Eclipse Public License
/// v1.0
// * which accompanies this distribution, and is available at
// * http://www.eclipse.org/legal/epl-v10.html
// *
// * Contributors: Ferhat Erata - initial API and implementation H. Emre Kirmizi - initial API and
// * implementation Serhat Celik - initial API and implementation U. Anil Ozturk - initial API and
// * implementation
// *******************************************************************************/
// package eu.modelwriter.visualization.wizards.createatom;
//
// import org.eclipse.jface.viewers.ITreeContentProvider;
// import org.eclipse.jface.viewers.Viewer;
//
// public class MarkerTreeViewContentProvider implements ITreeContentProvider {
//
// @Override
// public void dispose() {}
//
// @Override
// public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
//
// @Override
// public Object[] getElements(Object inputElement) {
// if (inputElement instanceof Object[]) {
// return (Object[]) inputElement;
// } else {
// return new Object[0];
// }
// }
//
// @Override
// public Object[] getChildren(Object parentElement) {
// if (parentElement instanceof TypeElement) {
// TypeElement type = (TypeElement) parentElement;
// return type.getChildren().toArray();
// }
// return null;
// }
//
// @Override
// public Object getParent(Object element) {
// return null;
// }
//
// @Override
// public boolean hasChildren(Object element) {
// if (element instanceof TypeElement) {
// TypeElement type = (TypeElement) element;
// return !type.getChildren().isEmpty();
// }
// return false;
// }
// }
