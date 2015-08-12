package eu.modelwriter.marker.ui.internal.preferences;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkerTypeElement;
import eu.modelwriter.marker.typing.alloy.AlloyParser;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerTreeViewContentProvider;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerTreeViewLabelProvider;

public class MarkerTypePreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
  private Table table;
  Label lblNewLabel;



  @Override
  protected Control createContents(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);

    TreeViewer treeViewer = new TreeViewer(container, SWT.BORDER);
    Tree tree = treeViewer.getTree();
    tree.setBounds(10, 32, 167, 265);

    MarkerTreeViewContentProvider treeViewerContentProvider = new MarkerTreeViewContentProvider();

    treeViewer.setLabelProvider(new MarkerTreeViewLabelProvider());
    treeViewer.setContentProvider(treeViewerContentProvider);

    TableViewer tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
    table = tableViewer.getTable();
    table.setBounds(183, 32, 172, 265);

    tableViewer.setContentProvider(ArrayContentProvider.getInstance());
    new RefColumn().addColumnTo(tableViewer);

    Button btnParseAlloy = new Button(container, SWT.NONE);
    btnParseAlloy.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {

        FileDialog dialog = new FileDialog(
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
        dialog.setFilterExtensions(new String[] {"*.als"});
        String result = dialog.open();

        AlloyParser parser = new AlloyParser(result);
        ArrayList<MarkerTypeElement> roots = parser.getTypes();
        ArrayList<String> rels = parser.getRels();

        MarkerTypeElement systemRoot = new MarkerTypeElement("universe");
        for (MarkerTypeElement root : roots) {
          systemRoot.getChildren().add(root);
        }

        try {
          MarkerPage.settings.put("universe", Serialization.getInstance().toString(systemRoot));
          MarkerPage.settings.put("rels", Serialization.getInstance().toString(rels));
          lblNewLabel.setText(result);
        } catch (IOException e1) {
          e1.printStackTrace();
        }

      }
    });
    btnParseAlloy.setBounds(10, 303, 75, 25);
    btnParseAlloy.setText("Parse Alloy");

    Label lblMarkerTypes = new Label(container, SWT.NONE);
    lblMarkerTypes.setBounds(10, 10, 75, 15);
    lblMarkerTypes.setText("Marker Types");

    Label lblRelations = new Label(container, SWT.NONE);
    lblRelations.setBounds(183, 11, 55, 15);
    lblRelations.setText("Relations");

    lblNewLabel = new Label(container, SWT.NONE);
    lblNewLabel.setBounds(91, 308, 264, 15);


    try {
      String savedTree = MarkerPage.settings.get("universe");
      if (savedTree != null) {
        Object[] array = new Object[1];
        array[0] = Serialization.getInstance().fromString(savedTree);
        treeViewer.setInput(array);
      }

      String rels = MarkerPage.settings.get("rels");
      if (rels != null) {
        tableViewer.setInput(Serialization.getInstance().fromString(rels));
      }
    } catch (IOException e1) {
      e1.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }


    return container;
  }

  @Override
  public void init(IWorkbench workbench) {
    // TODO Auto-generated method stub

  }
}
