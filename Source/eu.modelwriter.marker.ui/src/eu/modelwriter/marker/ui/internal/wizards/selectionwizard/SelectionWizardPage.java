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
package eu.modelwriter.marker.ui.internal.wizards.selectionwizard;

import java.util.ArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class SelectionWizardPage extends WizardPage {
  private Table table;
  private ArrayList<IMarker> candidateList;

  /**
   * Create the wizard.
   */
  SelectionWizardPage() {
    super("wizardPage");
  }

  /**
   * Create the wizard.
   * 
   * @param candidateList
   */
  public SelectionWizardPage(ArrayList<IMarker> candidateList) {
    super("wizardPage");
    this.candidateList = candidateList;
    setTitle("Markers");
    setDescription("All markers in selection");
  }

  /**
   * Create contents of the wizard.
   * 
   * @param parent
   */
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);

    setControl(container);
    container.setLayout(new GridLayout(1, false));

    TableViewer tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
    table = tableViewer.getTable();
    table.setLinesVisible(true);
    table.setHeaderVisible(true);
    table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

    tableViewer.setContentProvider(ArrayContentProvider.getInstance());
    tableViewer.setInput(candidateList);
    tableViewer.setLabelProvider(new MarkerColumn());
    // auto size columns
    TableColumn[] columns = tableViewer.getTable().getColumns();
    for (int i = 0; i < columns.length; i++) {
      columns[i].pack();
    }
  }

  public Table getTable() {
    return this.table;
  }
}
