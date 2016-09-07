package eu.modelwriter.configuration.emf2alloy;

import org.eclipse.jface.wizard.IWizard;

import eu.modelwriter.configuration.converter.ConverterWizardPage;

public class EMFToAlloyWizardPage extends ConverterWizardPage {

  protected EMFToAlloy emfToAlloy = null;

  protected EMFToAlloyWizardPage(String pageName) {
    super(pageName);
  }

  @Override
  public void setWizard(IWizard newWizard) {
    super.setWizard(newWizard);
    emfToAlloy = (EMFToAlloy) getConverter();
  }

  public EMFToAlloy getEmfToAlloy() {
    return emfToAlloy;
  }
}
