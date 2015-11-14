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
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.IWizardPage;
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
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerWizard;

public class RelationsWizardPage extends WizardPage {
  public static String selectedRelation;
  private TableViewer tableViewer;
  private Table table;
  private IMarker selectedMarker;
  boolean isIndirect;

  /**
   * Create the wizard.
   */
  public RelationsWizardPage(IMarker selectedMarker) {
    super("Relations Page");
    this.setTitle("Relations");
    this.setDescription("Suitable relations for selected marker");
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

    this.setControl(container);
    container.setLayout(new FillLayout(SWT.HORIZONTAL));

    this.tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
    this.table = this.tableViewer.getTable();

    this.tableViewer.setContentProvider(ArrayContentProvider.getInstance());
    new RefColumn().addColumnTo(this.tableViewer);

    tableViewer.addDoubleClickListener(new IDoubleClickListener() {

      @Override
      public void doubleClick(DoubleClickEvent event) {
        if (getNextPage() != null)
          getContainer().showPage(getNextPage());

      }
    });

    String rels = MarkerPage.settings.get("rels");
    if (rels != null) {
      try {
        ArrayList<String> suitableRelationTypes =
            AlloyUtilities.getRelationTypesForFirstSide(MarkUtilities.getType(this.selectedMarker));
        ArrayList<String> relsList = Serialization.getInstance().fromString(rels);
        ArrayList<String> filteredRelations = new ArrayList<String>();

        for (String rel : relsList) {
          for (String suitableRel : suitableRelationTypes) {
            if (rel.substring(0, rel.indexOf(" ")).equals(suitableRel)) {
              filteredRelations.add(rel);
            }
          }
        }
        this.tableViewer.setInput(filteredRelations);
        TableColumn[] columns = this.tableViewer.getTable().getColumns();
        for (int i = 0; i < columns.length; i++) {
          columns[i].pack();
        }

      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    this.tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {

      @Override
      public void selectionChanged(SelectionChangedEvent event) {
        StructuredSelection sel = (StructuredSelection) event.getSelection();
        RelationsWizardPage.selectedRelation = sel.getFirstElement().toString();
        RelationsWizardPage.this.setPageComplete(true);
      }
    });
  }

  @Override
  public IWizardPage getNextPage() {
    return ((MappingWizard) this.getWizard()).getMarkerMatchPage();
  }

  public Table getTable() {
    return this.table;
  }

  public void setTable(Table table) {
    this.table = table;
  }
}
