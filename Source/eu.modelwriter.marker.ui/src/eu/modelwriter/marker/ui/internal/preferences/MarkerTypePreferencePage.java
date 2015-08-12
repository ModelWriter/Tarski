package eu.modelwriter.marker.ui.internal.preferences;

import java.io.IOException;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerTreeViewContentProvider;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerTreeViewLabelProvider;

public class MarkerTypePreferencePage extends FieldEditorPreferencePage
    implements IWorkbenchPreferencePage {

  private TreeViewer myTreeViewer;
  private TableViewer myTableViewer;

  @Override
  public void init(IWorkbench workbench) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean performOk() {
    // TODO Auto-generated method stub
    return super.performOk();
  }

  @Override
  protected void createFieldEditors() {
    Composite composite2 = getFieldEditorParent(); // bu method her seferinde yeniden yarat�yor
                                                   // s�k�nt� burda bir defa �a��r�p
                                                   // treeview da da
                                                   // kullanmal�y�z.
//    addField(new StringButtonFieldEditor("button", "Add type", composite2) {
//
//      @Override
//      protected String changePressed() {
//        System.out.println("pushed");
//        return null;
//      }
//    });

    Composite compositeTree = new Composite(composite2, SWT.NONE);
    GridLayout layout = new GridLayout(1, false);
    GridData gd = new GridData(GridData.FILL_BOTH);
    gd.widthHint = 250;
    gd.heightHint = 200;
    compositeTree.setLayoutData(gd);
    compositeTree.setLayout(layout);

    myTreeViewer = new TreeViewer(compositeTree);
    myTreeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

    MarkerTreeViewContentProvider treeViewerContentProvider = new MarkerTreeViewContentProvider();

    myTreeViewer.setLabelProvider(new MarkerTreeViewLabelProvider());
    myTreeViewer.setContentProvider(treeViewerContentProvider);
    
    Composite compositeTable = new Composite(composite2, SWT.NONE);
    GridLayout layoutTable = new GridLayout(1, false);
    GridData gdTable = new GridData(GridData.FILL_BOTH);
//    gdTable.widthHint = 250;
//    gdTable.heightHint = 200;
    compositeTable.setLayoutData(gdTable);
    compositeTable.setLayout(layoutTable);
    
    myTableViewer = new TableViewer(composite2,  SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL);
    myTableViewer.getTable().setHeaderVisible(true);
    myTableViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
    myTableViewer.setContentProvider(ArrayContentProvider.getInstance());
    composite2.setLayout(layout);
    new RefColumn().addColumnTo(myTableViewer);

    try {
      String savedTree = MarkerPage.settings.get("universe");
      Object[] array = new Object[1];
      String rels = MarkerPage.settings.get("rels");

      array[0] = Serialization.getInstance().fromString(savedTree);
      myTreeViewer.setInput(array);
      myTableViewer.setInput(Serialization.getInstance().fromString(rels));
    } catch (IOException e1) {
      e1.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
