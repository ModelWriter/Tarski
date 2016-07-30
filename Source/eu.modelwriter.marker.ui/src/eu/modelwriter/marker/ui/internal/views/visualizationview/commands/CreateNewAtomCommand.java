package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import org.eclipse.jface.wizard.WizardDialog;

import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.wizards.creatingatomwizard.CreatingAtomWizard;

public class CreateNewAtomCommand implements Runnable {
  @Override
  public void run() {
    final CreatingAtomWizard wizard = new CreatingAtomWizard();
    final WizardDialog dialog = new WizardDialog(
        Activator.getDefault().getWorkbench().getWorkbenchWindows()[0].getShell(), wizard);
    dialog.open();
  }
}
