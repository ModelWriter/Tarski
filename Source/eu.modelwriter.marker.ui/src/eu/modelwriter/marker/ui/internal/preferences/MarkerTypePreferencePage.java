package eu.modelwriter.marker.ui.internal.preferences;

import java.io.IOException;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringButtonFieldEditor;
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
    addField(new StringButtonFieldEditor("button", "Add type", composite2) {

      @Override
      protected String changePressed() {
        System.out.println("pushed");
        return null;
      }
    });

    Composite composite = new Composite(composite2, SWT.NONE);
    GridLayout layout = new GridLayout(2, false);
    GridData gd = new GridData(GridData.FILL_VERTICAL);
    gd.horizontalSpan = 1;
    gd.widthHint = 400;
    gd.heightHint = 350;
    composite.setLayoutData(gd);
    composite.setLayout(layout);

    myTreeViewer = new TreeViewer(composite);
    myTreeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

    MarkerTreeViewContentProvider treeViewerContentProvider = new MarkerTreeViewContentProvider();

    myTreeViewer.setLabelProvider(new MarkerTreeViewLabelProvider());
    myTreeViewer.setContentProvider(treeViewerContentProvider);
    
    myTableViewer = new TableViewer(composite);
    myTableViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
    myTableViewer.setContentProvider(ArrayContentProvider.getInstance());
    
    new RefColumn().addColumnTo(myTableViewer);
    
    String[] deneme = {"test1","test2"};
    
    myTableViewer.setInput(deneme);
    
    try {
      String savedTree = MarkerPage.settings.get("universe");
      Object[] array = new Object[1];
      array[0] = Serialization.getInstance().fromString(savedTree);
      myTreeViewer.setInput(array);
    } catch (IOException e1) {
      e1.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
