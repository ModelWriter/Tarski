package eu.modelwriter.marker.ui.internal.wizards.deletingwizard;

import java.util.ArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.TableItem;

public class SelectionWizard extends Wizard {
  ArrayList<IMarker> candidateList;
  private IMarker selectedMarker;

  private SelectionWizardPage deletingWizardPage;

  public SelectionWizard() {
    this.candidateList = new ArrayList<IMarker>();
    setWindowTitle("Select Marker");
  }

  public SelectionWizard(ArrayList<IMarker> candidateList) {
    setWindowTitle("Select Marker");
    this.candidateList = candidateList;
  }

  @Override
  public void addPages() {
    deletingWizardPage = new SelectionWizardPage(candidateList);
    super.addPages();
    this.addPage(deletingWizardPage);
  }

  @Override
  public boolean performFinish() {

    TableItem selectedItem = deletingWizardPage.getTable().getSelection()[0];
    this.selectedMarker = (IMarker) selectedItem;
    return false;
  }

  public IMarker getSelectedMarker() {
    return this.selectedMarker;
  }
}
