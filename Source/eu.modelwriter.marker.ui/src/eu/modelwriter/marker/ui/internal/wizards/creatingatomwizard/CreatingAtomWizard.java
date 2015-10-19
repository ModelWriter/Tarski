package eu.modelwriter.marker.ui.internal.wizards.creatingatomwizard;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

public class CreatingAtomWizard extends Wizard {

  private UntypedMarkerPage untypedMarkerPage;
  private MarkerTypesPage markerTypesPage;

  public CreatingAtomWizard() {}

  @Override
  public void addPages() {
    this.untypedMarkerPage = new UntypedMarkerPage();
    this.addPage(this.untypedMarkerPage);
    this.markerTypesPage = new MarkerTypesPage();
    this.addPage(this.markerTypesPage);
  }

  @Override
  public boolean canFinish() {
    if (this.markerTypesPage.isPageComplete()) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public IWizardPage getStartingPage() {
    return this.untypedMarkerPage;
  }

  @Override
  public String getWindowTitle() {
    return "Create Atom";
  }

  @Override
  public boolean performFinish() {
    return false;
  }
}
