package eu.modelwriter.configuration.converter;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.configuration.alloy.trace.TraceException;

public class ConverterWizardPage extends WizardPage {

  private AbstractConverter converter = null;

  protected ConverterWizardPage(String pageName) {
    super(pageName);
  }

  /**
   * This triggers when next button clicked
   * 
   * @return true to go next page
   * @throws TraceException
   * @throws Exception
   */
  public boolean nextPressed() throws Exception {
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

  @Override
  public void setWizard(IWizard newWizard) {
    super.setWizard(newWizard);
    try {
      ConverterWizard wizard = (ConverterWizard) newWizard;
      converter = wizard.getConverter();
    } catch (ClassCastException e) {
      e.printStackTrace();
    }
  }

  public AbstractConverter getConverter() {
    return converter;
  }

}
