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
package eu.modelwriter.marker.ui.internal.wizards.markerwizard;

import java.io.IOException;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.ui.Activator;

public class MarkerPage extends WizardPage {

  public static TreeViewer markTreeViewer = null;
  private String savedTree;
  public static IDialogSettings settings = Activator.getDefault().getDialogSettings();

  public MarkerPage() {
    super("Marking with Tag");
  }

  public static boolean isParsed() {
    return settings.get("alloyFile") != null;
  }

  @Override
  public void createControl(Composite parent) {
    Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayout(new GridLayout(1, false));

    markTreeViewer = new TreeViewer(composite);
    markTreeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

    MarkerTreeViewContentProvider treeViewerContentProvider = new MarkerTreeViewContentProvider();

    markTreeViewer.setLabelProvider(new MarkerTreeViewLabelProvider());
    markTreeViewer.setContentProvider(treeViewerContentProvider);

    markTreeViewer.addDoubleClickListener(new IDoubleClickListener() {

      @Override
      public void doubleClick(DoubleClickEvent event) {
        IStructuredSelection selection = (IStructuredSelection) event.getSelection();
        Object firstElement = selection.getFirstElement();
        if (markTreeViewer.isExpandable(firstElement)) {
          boolean expanded = markTreeViewer.getExpandedState(firstElement);
          markTreeViewer.setExpandedState(firstElement, !expanded);
        }

      }
    });

    savedTree = settings.get("universe");
    try {
      Object[] array = new Object[1];
      if (savedTree != null) {
        // hic sig yoksa univ cikmasin
        array[0] = Serialization.getInstance().fromString(savedTree);
        markTreeViewer.setInput(array);
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    markTreeViewer.expandAll();
    setPageComplete(true);
    setControl(composite);
  }
}
