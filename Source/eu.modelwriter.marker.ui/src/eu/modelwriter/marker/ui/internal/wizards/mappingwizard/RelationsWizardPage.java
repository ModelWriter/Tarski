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
package eu.modelwriter.marker.ui.internal.wizards.mappingwizard;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.ui.internal.preferences.RefColumn;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;

public class RelationsWizardPage extends WizardPage {
  private Table table;
  private IMarker selectedMarker;

  /**
   * Create the wizard.
   */
  public RelationsWizardPage(IMarker selectedMarker) {
    super("wizardPage");
    setTitle("Relations");
    setDescription("Relations for selected marker");
    this.selectedMarker = selectedMarker;
  }

  /**
   * Create contents of the wizard.
   *
   * @param parent
   */
  @Override
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
        ArrayList<String> suitableRelationTypes =
            AlloyUtilities.getRelationTypesForFirstSide(MarkUtilities.getType(selectedMarker));
        ArrayList<String> relsList = Serialization.getInstance().fromString(rels);
        ArrayList<String> filteredRelations = new ArrayList<String>();

        for (String rel : relsList) {
          for (String suitableRel : suitableRelationTypes) {
            if (rel.substring(0, rel.indexOf(" ")).equals(suitableRel)) {
              filteredRelations.add(rel);
            }
          }
        }
        tableViewer.setInput(filteredRelations);
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

  public Table getTable() {
    return table;
  }

  public void setTable(Table table) {
    this.table = table;
  }
}
