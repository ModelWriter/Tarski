/*******************************************************************************
 * Copyright (c) 2016 UNIT Information Technologies R&D Ltd
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
// package eu.modelwriter.visualization.wizards.createatom;
//
// import org.eclipse.jface.viewers.TreeSelection;
// import org.eclipse.jface.wizard.Wizard;
//
// import eu.modelwriter.visualization.Utility;
//
// public class CreateAtomWizard extends Wizard {
//
// TypeHierarchyPage typeHierarchyPage;
//
// @Override
// public void addPages() {
// typeHierarchyPage = new TypeHierarchyPage("Type Hierarchy");
// this.addPage(typeHierarchyPage);
// }
//
// @Override
// public boolean performFinish() {
// TreeSelection selection = (TreeSelection) typeHierarchyPage.treeViewer.getSelection();
// if (selection == null || selection.getFirstElement() == null)
// return false;
// String type = ((TypeElement) selection.getFirstElement()).getType();
// String name = typeHierarchyPage.text.getText();
// if (name == null || name.isEmpty())
// return false;
//
// Utility.addAtomToSigType(type, name);
//
// return true;
// }
//
// }
