package eu.modelwriter.marker.ui.internal.preferences;

import java.io.IOException;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringButtonFieldEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkerTypeElement;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerTreeViewContentProvider;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerTreeViewLabelProvider;

public class MarkerTypePreferencePage extends FieldEditorPreferencePage
    implements IWorkbenchPreferencePage {

  private TreeViewer myTreeViewer;
  ScrolledComposite fScrolledComposite;
  int fCompositeWidth, fCompositeHeight;
  FormToolkit toolkit;
  Form form;

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
    Composite composite2 = getFieldEditorParent(); // bu method her seferinde yeniden yaratýyor
                                                   // sýkýntý burda bir defa çaðýrýp treeview da da
                                                   // kullanmalýyýz.
    addField(new StringButtonFieldEditor("button", "Add type", composite2) {

      @Override
      protected String changePressed() {
        System.out.println("pushed");
        return null;
      }
    });

    Composite composite = new Composite(composite2, SWT.NONE);
    GridLayout layout = new GridLayout(1, false);
    // layout.marginHeight = 50;
    // layout.marginWidth = 50;
    composite.setLayout(layout);

    // Button addType = new Button(composite, SWT.CHECK);

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
}
