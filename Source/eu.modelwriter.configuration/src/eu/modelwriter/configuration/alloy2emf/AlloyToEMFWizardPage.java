package eu.modelwriter.configuration.alloy2emf;

import org.eclipse.jface.wizard.IWizard;

import eu.modelwriter.configuration.converter.ConverterWizardPage;

public class AlloyToEMFWizardPage extends ConverterWizardPage {

  protected AlloyToEMF alloyToEMF = null;

  protected AlloyToEMFWizardPage(String pageName) {
    super(pageName);
  }

  @Override
  public void setWizard(IWizard newWizard) {
    super.setWizard(newWizard);
    alloyToEMF = (AlloyToEMF) getConverter();
  }

  public AlloyToEMF getAlloyToEMF() {
    return alloyToEMF;
  }

}
