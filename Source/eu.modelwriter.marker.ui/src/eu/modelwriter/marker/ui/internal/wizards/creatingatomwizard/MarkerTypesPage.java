package eu.modelwriter.marker.ui.internal.wizards.creatingatomwizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class MarkerTypesPage extends WizardPage {

  protected MarkerTypesPage() {
    super("Marker Types Page");
    this.setTitle("Marker Types");
    this.setDescription("Marker types for this atom");
  }

  @Override
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NONE);
    this.setControl(container);
    container.setLayout(new FillLayout(SWT.HORIZONTAL));
  }
}
