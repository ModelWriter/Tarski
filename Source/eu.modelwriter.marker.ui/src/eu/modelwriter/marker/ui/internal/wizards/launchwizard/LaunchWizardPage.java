package eu.modelwriter.marker.ui.internal.wizards.launchwizard;

import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class LaunchWizardPage extends WizardPage {

  private final List<String> commandList;

  private org.eclipse.swt.widgets.List list;

  public LaunchWizardPage(final List<String> commands) {
    super("Launch Wizard");
    this.commandList = commands;
  }

  @Override
  public void createControl(final Composite parent) {
    final Composite container = new Composite(parent, SWT.NULL);
    this.setControl(container);
    container.setLayout(new FillLayout(SWT.HORIZONTAL));

    this.list =
        new org.eclipse.swt.widgets.List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);

    for (final String command : this.commandList) {
      this.list.add(command);
    }
  }

  public String getSelection() {
    return this.list.getSelection()[0];
  }
}
