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
// import org.eclipse.jface.viewers.DoubleClickEvent;
// import org.eclipse.jface.viewers.IDoubleClickListener;
// import org.eclipse.jface.viewers.IStructuredSelection;
// import org.eclipse.jface.viewers.TreeViewer;
// import org.eclipse.jface.wizard.WizardPage;
// import org.eclipse.swt.SWT;
// import org.eclipse.swt.layout.GridData;
// import org.eclipse.swt.layout.GridLayout;
// import org.eclipse.swt.layout.RowData;
// import org.eclipse.swt.layout.RowLayout;
// import org.eclipse.swt.widgets.Composite;
// import org.eclipse.swt.widgets.Label;
// import org.eclipse.swt.widgets.Text;
//
// import eu.modelwriter.visualization.Utility;
//
// public class TypeHierarchyPage extends WizardPage {
// public TreeViewer treeViewer = null;
// public Text text;
//
// protected TypeHierarchyPage(String pageName) {
// super(pageName);
// this.setTitle("Create Atom");
// }
//
// @Override
// public void createControl(Composite parent) {
// Composite composite = new Composite(parent, SWT.NONE);
// composite.setLayout(new GridLayout(1, false));
//
// Composite composite_1 = new Composite(composite, SWT.NONE);
// composite_1.setLayout(new RowLayout(SWT.HORIZONTAL));
//
// Label lblNewLabel = new Label(composite_1, SWT.NONE);
// lblNewLabel.setText("Atom Name :");
//
// text = new Text(composite_1, SWT.BORDER);
// text.setLayoutData(new RowData(199, 11));
//
// treeViewer = new TreeViewer(composite);
// treeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
//
// MarkerTreeViewContentProvider treeViewerContentProvider = new MarkerTreeViewContentProvider();
//
// treeViewer.setContentProvider(treeViewerContentProvider);
// treeViewer.addDoubleClickListener(new IDoubleClickListener() {
//
// @Override
// public void doubleClick(DoubleClickEvent event) {
// IStructuredSelection selection = (IStructuredSelection) event.getSelection();
// Object firstElement = selection.getFirstElement();
// if (treeViewer.isExpandable(firstElement)) {
// boolean expanded = treeViewer.getExpandedState(firstElement);
// treeViewer.setExpandedState(firstElement, !expanded);
// }
//
// }
// });
//
// treeViewer.setInput(Utility.getTypeHierarchy().toArray());
//
// treeViewer.expandAll();
// setPageComplete(true);
// setControl(composite);
//
// }
// }
