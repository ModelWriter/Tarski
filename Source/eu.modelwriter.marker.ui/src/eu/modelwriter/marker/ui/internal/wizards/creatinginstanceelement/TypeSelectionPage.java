package eu.modelwriter.marker.ui.internal.wizards.creatinginstanceelement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.configuration.alloy.trace.LoadItem;
import eu.modelwriter.configuration.alloy.trace.TraceManager;
import eu.modelwriter.configuration.generation.GenerationWizardPage;
import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkerTypeElement;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerTreeViewContentProvider;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerTreeViewLabelProvider;

public class TypeSelectionPage extends GenerationWizardPage {

  private List<EClass> allEClasses = new ArrayList<EClass>();
  private Set<String> containerSigTypes;
  private ISelection selection;
  private boolean canFlip = false;

  protected TypeSelectionPage() {
    super("Types Page");
    setTitle("Types");
    setDescription("Select type for this element");
  }

  @Override
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NONE);
    setControl(container);
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

    for (LoadItem loadItem : TraceManager.get().getLoads()) {
      allEClasses.addAll(loadItem.getAllEClasses().values());
    }

    treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

      @Override
      public void selectionChanged(SelectionChangedEvent event) {
        String markerType =
            ((MarkerTypeElement) ((TreeSelection) event.getSelection()).getFirstElement())
                .getType();
        if (markerType.equals("universe") || markerType.endsWith("{abs}")) {
          TypeSelectionPage.this.setPageComplete(false);
          canFlip = false;
        } else {
          selection = event.getSelection();
          containerSigTypes = TraceManager.get().findContainers(allEClasses, getSelectedType());
          canFlip = !containerSigTypes.isEmpty();
          TypeSelectionPage.this.setPageComplete(true);
          getContainer().updateButtons();
        }
      }
    });

  }


  @Override
  public boolean canFlipToNextPage() {
    return canFlip;
  }

  public ISelection getSelection() {
    return selection;
  }

  public String getSelectedType() {
    return ((MarkerTypeElement) ((TreeSelection) getSelection()).getFirstElement()).getType();
  }

  @Override
  public boolean nextPressed() throws Exception {
    if (!containerSigTypes.isEmpty()) {
      ContainerSelectionPage nextPage = (ContainerSelectionPage) getNextPage();
      nextPage.setSigType(containerSigTypes);
    }

    return super.nextPressed();
  }
}
