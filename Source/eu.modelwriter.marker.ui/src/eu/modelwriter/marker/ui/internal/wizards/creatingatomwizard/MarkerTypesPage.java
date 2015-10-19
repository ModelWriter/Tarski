package eu.modelwriter.marker.ui.internal.wizards.creatingatomwizard;

import java.io.IOException;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkerTypeElement;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerTreeViewContentProvider;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerTreeViewLabelProvider;

public class MarkerTypesPage extends WizardPage {

  private ISelection selection;

  protected MarkerTypesPage() {
    super("Marker Types Page");
    this.setTitle("Marker Types");
    this.setDescription("Marker types for this atom");
  }

  @Override
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NONE);
    this.setControl(container);
    container.setLayout(new FillLayout(SWT.HORIZONTAL));

    TreeViewer treeViewer = new TreeViewer(container, SWT.BORDER);
    treeViewer.setUseHashlookup(true);
    treeViewer.setLabelProvider(new MarkerTreeViewLabelProvider());
    treeViewer.setContentProvider(new MarkerTreeViewContentProvider());

    String savedTree = Activator.getDefault().getDialogSettings().get("universe");
    try {
      Object[] array = new Object[1];
      if (savedTree != null) {
        array[0] = Serialization.getInstance().fromString(savedTree);
        treeViewer.setInput(array);
      }
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

      @Override
      public void selectionChanged(SelectionChangedEvent event) {
        String markerType =
            ((MarkerTypeElement) ((TreeSelection) event.getSelection()).getFirstElement())
                .getType();
        if (markerType.equals("universe") || markerType.endsWith("{abs}")) {
          MarkerTypesPage.this.setPageComplete(false);
        } else {
          MarkerTypesPage.this.selection = event.getSelection();
          MarkerTypesPage.this.setPageComplete(true);
        }
      }
    });
  }

  public ISelection getSelection() {
    return this.selection;
  }
}
