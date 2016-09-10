package eu.modelwriter.configuration.generation;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

public class GenerationWizardDialog extends WizardDialog {

  public GenerationWizardDialog(Shell parentShell, IWizard newWizard) {
    super(parentShell, newWizard);
  }

  @Override
  protected void backPressed() {
    IWizardPage currentActivePage = getCurrentPage();

    /* notify current page if it wants to do any validation on input */
    if (!((GenerationWizardPage) currentActivePage).backPressed())
      return;

    /* delegate backPressed processing to super */
    super.backPressed();
  }

  @Override
  protected void nextPressed() {
    IWizardPage currentActivePage = getCurrentPage();

    /* notify current page if it wants to do any validation on input */
    try {
      if (!((GenerationWizardPage) currentActivePage).nextPressed())
        return;
    } catch (Exception e) {
      GenerationWizard wizard = (GenerationWizard) getWizard();
      wizard.getConverter().onException(e);
    }

    /* delegate nextPressed processing to super */
    super.nextPressed();
  }
}
