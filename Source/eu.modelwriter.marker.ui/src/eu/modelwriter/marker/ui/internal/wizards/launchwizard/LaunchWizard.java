package eu.modelwriter.marker.ui.internal.wizards.launchwizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.wizard.Wizard;

public class LaunchWizard extends Wizard {

  private LaunchWizardPage page;

  private final List<String> commands;

  private String selectedCommand;

  public LaunchWizard() {
    this.commands = new ArrayList<String>();
    this.setWindowTitle("Commands For Launch");
  }

  public LaunchWizard(final List<String> commands) {
    this.commands = commands;
    this.setWindowTitle("Commands For Launch");
  }

  @Override
  public void addPages() {
    super.addPages();
    this.page = new LaunchWizardPage(this.commands);
    this.addPage(this.page);
  }

  public String getSelection() {
    return this.selectedCommand;
  }

  @Override
  public boolean performFinish() {
    this.selectedCommand = this.page.getSelection();
    return true;
  }
}
