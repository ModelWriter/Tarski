package eu.modelwriter.configuration.synthesis;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.configuration.alloy.trace.TraceException;

public class MWizardPage extends WizardPage {

  protected MWizardPage(String pageName) {
    super(pageName);
  }

  /**
   * This triggers when next button clicked
   * 
   * @return true if press handled
   * @throws TraceException
   */
  public boolean nextPressed() throws TraceException {
    return true;
  }

  @Override
  public void createControl(Composite parent) {
    setControl(parent);
  }

  public AlloyToEMF getAlloyToEMF() {
    try {
      return ((AlloyToEMFWizard) getWizard()).getAlloyToEmf();
    } catch (ClassCastException e) {
      this.setErrorMessage("Unsupported wizard! Make sure this page in AlloyToEMFWizard.");
      return null;
    }
  }

}
