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
   * @return true to go next page
   * @throws TraceException
   */
  public boolean nextPressed() throws TraceException {
    return true;
  }

  /**
   * This triggers when back button clicked
   * 
   * @return true to go previous page
   */
  public boolean backPressed() {
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
      throw new UnsupportedOperationException(
          "Unsupported wizard! Make sure this page in AlloyToEMFWizard.");
    }
  }

}
