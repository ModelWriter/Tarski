package eu.modelwriter.configuration.converter;

import org.eclipse.jface.wizard.Wizard;

public class ConverterWizard extends Wizard {

  private AbstractConverter converter;

  public ConverterWizard(AbstractConverter converter, String title) {
    super();
    this.converter = converter;
    setWindowTitle(title);
  }

  @Override
  public boolean performFinish() {
    return true;
  }

  public AbstractConverter getConverter() {
    return converter;
  }

}
