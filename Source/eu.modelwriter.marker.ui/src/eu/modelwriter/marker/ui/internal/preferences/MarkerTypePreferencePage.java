package eu.modelwriter.marker.ui.internal.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

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

    Composite comp = getFieldEditorParent();

    Tree tree = new Tree(comp, SWT.NONE);
    tree.setLayout(new FillLayout());
    tree.setHeaderVisible(true);

    TreeItem item1 = new TreeItem(tree, SWT.NONE);
    item1.setText("Name1");

    TreeItem item11 = new TreeItem(item1, SWT.NONE);
    item11.setText("Name11");
    StringFieldEditor s11 = new StringFieldEditor("name11", "label11:", comp);
    item11.setData("object");

    TreeItem item12 = new TreeItem(item1, SWT.NONE);
    item12.setText("Name12");
    StringFieldEditor s12 = new StringFieldEditor("name12", "label12:", comp);
    item12.setData("object2");


    item1.setExpanded(true);
    item11.setExpanded(true);
    item12.setExpanded(true);


    TreeItem item2 = new TreeItem(tree, SWT.NONE);
    item2.setText("Name2");

    // Create the ScrolledComposite to scroll horizontally and vertically
    fScrolledComposite = new ScrolledComposite(getFieldEditorParent(), SWT.H_SCROLL | SWT.V_SCROLL);
    // Displays the scrollbars when the window gets smaller
    fScrolledComposite.setAlwaysShowScrollBars(false);
    // Sets the minimum size for the composite to work for scrolling
    fScrolledComposite.setMinSize(fCompositeWidth, fCompositeHeight);
    fScrolledComposite.setExpandHorizontal(true);
    fScrolledComposite.setExpandVertical(true);

    Composite composite = new Composite(fScrolledComposite, SWT.NONE);
    composite.setLayout(new GridLayout());
    fScrolledComposite.setContent(composite);
    // Sets up the toolkit.
    Display display = composite.getDisplay();
    toolkit = new FormToolkit(display);

    // Creates a form instance.
    form = toolkit.createForm(composite);
    form.getBody().setLayout(new GridLayout());
    form.setBackground(display.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
    form.setText("Model: ");// Sets title of the Preference page

    // Add the three main nodes to the preference page
    addNode1();
  }

  private void addNode1() {
    ExpandableComposite expandableComposite =
        createExpandableComposite("Signal Generator Device Host/Port:", true);
    Composite childComposite = createChildComposite(expandableComposite);

    // Builds fields here (StringFieldEditor, IntegerFieldEditor, etc.)

  }

  /**
   * Creates an ExpandableComposite that will be added to the preference page
   * 
   * @param label
   * @param expanded
   * @return
   */
  private ExpandableComposite createExpandableComposite(String label, boolean expanded) {
    ExpandableComposite expandableComposite = null;
    if (expanded) {
      expandableComposite =
          toolkit.createExpandableComposite(form.getBody(), ExpandableComposite.TWISTIE
              | ExpandableComposite.CLIENT_INDENT | ExpandableComposite.EXPANDED);
    } else {
      expandableComposite = toolkit.createExpandableComposite(form.getBody(),
          ExpandableComposite.TWISTIE | ExpandableComposite.CLIENT_INDENT);
    }

    expandableComposite.setText(label);
    expandableComposite.setBackground(form.getBackground());
    expandableComposite.addExpansionListener(new ExpansionAdapter() {
      @Override
      public void expansionStateChanged(ExpansionEvent e) {
        form.pack();
      }
    });

    GridData gd = new GridData();
    expandableComposite.setLayoutData(gd);

    return expandableComposite;
  }

  /**
   * Creates a child composite for an ExpandableComposite
   * 
   * @param expandableComposite
   * @return
   */
  private Composite createChildComposite(ExpandableComposite expandableComposite) {
    Composite childComposite = new Composite(expandableComposite, SWT.None);

    GridData gd = new GridData(GridData.FILL_BOTH);
    gd.horizontalSpan = 2;
    // gd.horizontalAlignment = GridData.END;
    childComposite.setLayoutData(gd);

    expandableComposite.setClient(childComposite);

    return childComposite;
  }

  // @Override
  // protected void createFieldEditors() {
  //
  //
  // addField(new StringButtonFieldEditor("type", "Add new marker type ",
  // getFieldEditorParent()) {
  //
  // @Override
  // protected String changePressed() {
  // System.out.println("basýldý.");
  // return oldValue;
  // }
  // });
  // }
}
