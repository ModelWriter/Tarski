package eu.modelwriter.configuration.synthesis;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

import eu.modelwriter.configuration.alloy.trace.TraceException;

public class MWizardDialog extends WizardDialog {

  public MWizardDialog(Shell parentShell, IWizard newWizard) {
    super(parentShell, newWizard);
  }

  @Override
  protected void backPressed() {
    IWizardPage currentActivePage = getCurrentPage();

    /* notify current page if it wants to do any validation on input */
    if (!((MWizardPage) currentActivePage).backPressed())
      return;

    /* delegate backPressed processing to super */
    super.backPressed();
  }

  @Override
  protected void nextPressed() {
    IWizardPage currentActivePage = getCurrentPage();

    /* notify current page if it wants to do any validation on input */
    try {
      if (!((MWizardPage) currentActivePage).nextPressed())
        return;
    } catch (TraceException e) {
      AlloyToEMFWizard wizard = (AlloyToEMFWizard) getWizard();
      wizard.getAlloyToEmf().onException(e);
    }

    /* delegate nextPressed processing to super */
    super.nextPressed();
  }
}
