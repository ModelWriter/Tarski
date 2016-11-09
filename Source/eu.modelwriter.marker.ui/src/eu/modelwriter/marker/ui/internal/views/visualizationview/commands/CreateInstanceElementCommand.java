package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import eu.modelwriter.configuration.generation.GenerationWizardDialog;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.wizards.creatinginstanceelement.CreateInstanceElementWizard;

public class CreateInstanceElementCommand implements Runnable {
  @Override
  public void run() {
    final CreateInstanceElementWizard wizard = new CreateInstanceElementWizard();
    final GenerationWizardDialog dialog = new GenerationWizardDialog(Activator.getShell(), wizard);
    dialog.open();
  }
}
