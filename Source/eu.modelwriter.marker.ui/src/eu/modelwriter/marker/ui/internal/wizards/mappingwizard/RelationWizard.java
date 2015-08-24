package eu.modelwriter.marker.ui.internal.wizards.mappingwizard;

import org.eclipse.jface.wizard.Wizard;

public class RelationWizard extends Wizard {

  private RelationsWizardPage relationWizardPage;

  @Override
  public void addPages() {
    relationWizardPage = new RelationsWizardPage();
    super.addPages();
    this.addPage(relationWizardPage);
  }

  @Override
  public boolean performFinish() {
    // TODO Auto-generated method stub
    return false;
  }



}
