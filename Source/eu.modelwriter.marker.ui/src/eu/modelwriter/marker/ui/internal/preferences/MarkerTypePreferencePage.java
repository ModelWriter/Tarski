package eu.modelwriter.marker.ui.internal.preferences;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.jface.dialogs.MessageDialog;
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

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkerTypeElement;
import eu.modelwriter.marker.typing.alloy.AlloyField;
import eu.modelwriter.marker.typing.alloy.AlloyModule;
import eu.modelwriter.marker.typing.alloy.AlloyParser;
import eu.modelwriter.marker.typing.alloy.AlloySig;
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

        MessageDialog warningdialog =
            new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
                "If new alloy file will be parsed , your all marker type will be lost !",
                MessageDialog.WARNING, new String[] {"OK", "Cancel"}, 0);
        if (warningdialog.open() == 1)
          return;

        FileDialog dialog = new FileDialog(
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.OPEN);
        dialog.setFilterExtensions(new String[] {"*.als"});
        String result = dialog.open();
        MarkerPage.settings.put("alloyFile", result);

        // AlloyParser parser = new AlloyParser(result);
        // ArrayList<MarkerTypeElement> roots = parser.getTypes();
        // ArrayList<String> rels = parser.getRels();

        String serializedModules =
            MarkerPage.settings.getSection("alloyModuleSection").get("alloyModuleList");

        try {
          ArrayList<AlloyModule> alloyModuleList =
              Serialization.getInstance().fromString(serializedModules);

          AlloySig systemRoot = new AlloySig("universe", true);
          for (AlloyModule alloyModule : alloyModuleList) {
            systemRoot.addAllChildren(alloyModule.getSigList());
          }

          Object[] array = new Object[1];
          array[0] = systemRoot;
          treeViewer.setInput(array);

        } catch (ClassNotFoundException e2) {
          // TODO Auto-generated catch block
          e2.printStackTrace();
        } catch (IOException e2) {
          // TODO Auto-generated catch block
          e2.printStackTrace();
        }


        // MarkerTypeElement systemRoot = new MarkerTypeElement("universe");
        // for (MarkerTypeElement root : roots) {
        // systemRoot.getChildren().add(root);
        // }

        // try {
        // MarkerPage.settings.put("universe", Serialization.getInstance().toString(systemRoot));
        // Object[] array = new Object[1];
        // array[0] = systemRoot;
        // treeViewer.setInput(array);
        // MarkerPage.settings.put("rels", Serialization.getInstance().toString(rels));
        // tableViewer.setInput(rels);
        // lblNewLabel.setText(result);
        // lblNewLabel.setToolTipText(result);
        // } catch (IOException e1) {
        // e1.printStackTrace();
        // }
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
    if (MarkerPage.settings.get("alloyFile") != null)
      lblNewLabel.setText(MarkerPage.settings.get("alloyFile"));
    lblNewLabel.setToolTipText(MarkerPage.settings.get("alloyFile"));

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
