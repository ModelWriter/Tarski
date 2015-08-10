package eu.modelwriter.marker.ui.internal.preferences;

import java.io.IOException;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkerTypeElement;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerTreeViewContentProvider;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerTreeViewLabelProvider;

public class MarkerTypeFieldEditor extends FieldEditor {

  private TreeViewer myTreeViewer;
  
  public MarkerTypeFieldEditor() {
    // TODO Auto-generated constructor stub
  }
  
  @Override
  protected void createControl(Composite parent) {
    super.createControl(parent);
    Composite composite = new Composite(parent, SWT.NONE);
    GridLayout layout = new GridLayout(1, false);
//    layout.marginHeight = 50;
//    layout.marginWidth = 50;
    composite.setLayout(layout);
   
//    Button addType = new Button(composite, SWT.CHECK);

    myTreeViewer = new TreeViewer(composite);
    myTreeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

    MarkerTreeViewContentProvider treeViewerContentProvider = new MarkerTreeViewContentProvider();

    myTreeViewer.setLabelProvider(new MarkerTreeViewLabelProvider());
    myTreeViewer.setContentProvider(treeViewerContentProvider);
    
    MarkerTypeElement root = new MarkerTypeElement("root");
    MarkerTypeElement child = new MarkerTypeElement("child");
    MarkerTypeElement torun = new MarkerTypeElement("torun");
    
    root.getChildren().add(child);
    child.getChildren().add(torun);
    
    try {
      MarkerPage.settings.put("root", Serialization.getInstance().toString(root));
      String savedTree = MarkerPage.settings.get("root");
      Object[] array = new Object[1];
      array[0] = Serialization.getInstance().fromString(savedTree);
      myTreeViewer.setInput(array);
    } catch (IOException e1) {
      e1.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } 

  }
  
  @Override
  protected void adjustForNumColumns(int numColumns) {
    // TODO Auto-generated method stub
  }

  @Override
  protected void doFillIntoGrid(Composite parent, int numColumns) {
    // TODO Auto-generated method stub

  }

  @Override
  protected void doLoad() {
    // TODO Auto-generated method stub

  }

  @Override
  protected void doLoadDefault() {
    // TODO Auto-generated method stub

  }

  @Override
  protected void doStore() {
    // TODO Auto-generated method stub

  }

  @Override
  public int getNumberOfControls() {
    // TODO Auto-generated method stub
    return 3;
  }

}
