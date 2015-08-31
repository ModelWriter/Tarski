package eu.modelwriter.marker.ui.internal.wizards.mappingwizard;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkElementUtilities;
import eu.modelwriter.marker.internal.Relation;
import eu.modelwriter.marker.ui.internal.preferences.RefColumn;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;

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
      tableViewer.setInput(filterRelations(rels));
      TableColumn[] columns = tableViewer.getTable().getColumns();
      for (int i = 0; i < columns.length; i++) {
        columns[i].pack();
      }
    }

  }

  private ArrayList<String> filterRelations(String rels) {
    ArrayList<String> filteredRelations = new ArrayList<String>();
    try {
      // DeSerialization of Relations
      ArrayList<Relation> relsList = Serialization.getInstance().fromString(rels);

      // Getting type of first selected marker
      String typeOfFirstSelectedMarker = MarkElementUtilities.getType(MappingWizard.selectedMarker);

      // Getting type of selected marker on Tree
      TreeSelection treeSelection = ((TreeSelection) MarkerMatchPage.markTreeViewer.getSelection());
      IMarker selectedMarkerOnTree = (IMarker) treeSelection.getFirstElement();
      String typeOfSelectedMarkerOnTree = MarkElementUtilities.getType(selectedMarkerOnTree);

      for (Relation relation : relsList) {

        if (typeOfFirstSelectedMarker.equals(relation.getFromType())
            && typeOfSelectedMarkerOnTree.equals(relation.getToType()))
          filteredRelations.add(relation.toString());
      }


    } catch (ClassNotFoundException | IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return filteredRelations;
  }

}
