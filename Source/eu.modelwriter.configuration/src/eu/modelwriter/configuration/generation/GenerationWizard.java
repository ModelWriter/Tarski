package eu.modelwriter.configuration.generation;

import org.eclipse.jface.wizard.Wizard;

public class GenerationWizard extends Wizard {

  private AbstractGeneration converter;

  public GenerationWizard(AbstractGeneration converter, String title) {
    super();
    this.converter = converter;
    setWindowTitle(title);
  }

  @Override
  public boolean performFinish() {
    return true;
  }

  public AbstractGeneration getConverter() {
    return converter;
  }

}
