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
package eu.modelwriter.marker.ui.internal.wizards.mappingwizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.ui.internal.preferences.RefColumn;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;

import java.io.IOException;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;

public class RelationsWizardPage extends WizardPage {
  private Table table;

  public Table getTable() {
    return table;
  }

  public void setTable(Table table) {
    this.table = table;
  }

  /**
   * Create the wizard.
   */
  public RelationsWizardPage() {
    super("wizardPage");
    setTitle("Relations");
    setDescription("Relations for selected marker");
  }

  /**
   * Create contents of the wizard.
   * 
   * @param parent
   */
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);

    setControl(container);
    container.setLayout(new FillLayout(SWT.HORIZONTAL));

    TableViewer tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
    table = tableViewer.getTable();

    tableViewer.setContentProvider(ArrayContentProvider.getInstance());
    new RefColumn().addColumnTo(tableViewer);

    String rels = MarkerPage.settings.get("rels");
    if (rels != null) {
      try {
        tableViewer.setInput(Serialization.getInstance().fromString(rels));
        TableColumn[] columns = tableViewer.getTable().getColumns();
        for (int i = 0; i < columns.length; i++) {
          columns[i].pack();
        }
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

}
