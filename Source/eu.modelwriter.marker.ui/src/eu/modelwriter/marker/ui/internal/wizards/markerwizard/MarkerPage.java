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
import org.eclipse.jface.viewers.IDoubleClickListener;
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
  public static IDialogSettings settings = Activator.getDefault().getDialogSettings();

  public static boolean isParsed() {
    return MarkerPage.settings.get("alloyFile") != null;
  }

  private String savedTree;
  private final IDoubleClickListener doubleClickListener;

  public MarkerPage(final IDoubleClickListener doubleClickListener) {
    super("Create a Trace Element with Type");
    this.doubleClickListener = doubleClickListener;
  }

  @Override
  public void createControl(final Composite parent) {
    final Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayout(new GridLayout(1, false));

    MarkerPage.markTreeViewer = new TreeViewer(composite);
    MarkerPage.markTreeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

    final MarkerTreeViewContentProvider treeViewerContentProvider =
        new MarkerTreeViewContentProvider();

    MarkerPage.markTreeViewer.setLabelProvider(new MarkerTreeViewLabelProvider());
    MarkerPage.markTreeViewer.setContentProvider(treeViewerContentProvider);
    MarkerPage.markTreeViewer.addDoubleClickListener(this.doubleClickListener);

    this.savedTree = MarkerPage.settings.get("universe");
    try {
      final Object[] array = new Object[1];
      if (this.savedTree != null) {
        // hic sig yoksa univ cikmasin
        array[0] = Serialization.getInstance().fromString(this.savedTree);
        MarkerPage.markTreeViewer.setInput(array);
      }
    } catch (final ClassNotFoundException e) {
      e.printStackTrace();
    } catch (final IOException e) {
      e.printStackTrace();
    }
    MarkerPage.markTreeViewer.expandAll();
    this.setPageComplete(true);
    this.setControl(composite);
  }
}
