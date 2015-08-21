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
