package eu.modelwriter.marker.ui.internal.wizards.markerwizard;

import java.io.IOException;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkerTypeElement;
import eu.modelwriter.marker.ui.Activator;

public class MarkerPage extends WizardPage {

  public static TreeViewer markTreeViewer = null;
  private String savedTree;
  public static IDialogSettings settings = Activator.getDefault().getDialogSettings();

  public MarkerPage() {
    super("Marking with Tag");
  }

  @Override
  public void createControl(Composite parent) {
    Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayout(new GridLayout(1, false));

    // Text typeText = new Text(composite, SWT.BOLD);
    //
    // Button addType = new Button(composite, SWT.CHECK);
    // addType.setText("Add New Type");

    markTreeViewer = new TreeViewer(composite);
    markTreeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

    MarkerTreeViewContentProvider treeViewerContentProvider = new MarkerTreeViewContentProvider();

    markTreeViewer.setLabelProvider(new MarkerTreeViewLabelProvider());
    markTreeViewer.setContentProvider(treeViewerContentProvider);
    
    MarkerTypeElement root = new MarkerTypeElement("root");
    MarkerTypeElement child = new MarkerTypeElement("child");
    MarkerTypeElement torun = new MarkerTypeElement("torun");
    
    root.getChildren().add(child);
    child.getChildren().add(torun);
    
    try {
      settings.put("root", Serialization.getInstance().toString(root));
    } catch (IOException e1) {
      e1.printStackTrace();
    }
       
    savedTree = settings.get("root");
    try {
      Object[] array = new Object[1];
      array[0] = Serialization.getInstance().fromString(savedTree);
      markTreeViewer.setInput(array);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    setPageComplete(true);
    setControl(composite);
  }

}
