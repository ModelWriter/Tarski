package eu.modelwriter.marker.ui.internal.wizards.creatinginstanceelement;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class AttributePage extends WizardPage {


  protected AttributePage() {
    super("Attributes");
    this.setTitle("Attributes");
    this.setDescription("");
  }

  @Override
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NONE);
    this.setControl(container);
    container.setLayout(new FillLayout(SWT.HORIZONTAL));

  }

}
