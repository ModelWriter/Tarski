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
import eu.modelwriter.marker.ui.Activator;

public class MarkerPage extends WizardPage {

  public static TreeViewer markTreeViewer = null;
  private String savedTree;
  public static IDialogSettings settings = Activator.getDefault().getDialogSettings();

  public MarkerPage() {
    super("Marking with Tag");
  }

  public static boolean isParsed() {
    return settings.get("alloyFile") != null;
  }

  @Override
  public void createControl(Composite parent) {
    Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayout(new GridLayout(1, false));

    markTreeViewer = new TreeViewer(composite);
    markTreeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

    MarkerTreeViewContentProvider treeViewerContentProvider = new MarkerTreeViewContentProvider();

    markTreeViewer.setLabelProvider(new MarkerTreeViewLabelProvider());
    markTreeViewer.setContentProvider(treeViewerContentProvider);

    savedTree = settings.get("universe");
    try {
      Object[] array = new Object[1];
      if (savedTree != null) {
        // hic sig yoksa univ cikmasin
        array[0] = Serialization.getInstance().fromString(savedTree);
        markTreeViewer.setInput(array);
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    setPageComplete(true);
    setControl(composite);
  }
}
