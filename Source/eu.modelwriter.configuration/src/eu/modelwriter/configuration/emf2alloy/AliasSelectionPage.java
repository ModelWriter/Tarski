package eu.modelwriter.configuration.emf2alloy;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class AliasSelectionPage extends EMFToAlloyWizardPage {

  private String alias;
  private Text text;

  public AliasSelectionPage(String alias) {
    super("SelectAliasPage");
    this.alias = alias;
    setTitle("Alias");
    setDescription("Select an alias for Ecore file");
  }


  @Override
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    container.setLayout(new GridLayout(2, false));
    Label label = new Label(container, SWT.NONE);
    label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
    label.setText("Select an alias for Ecore file ");
    text = new Text(container, SWT.BORDER);
    text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
    text.setText(alias);
    setControl(container);
  }

  public String getAlias() {
    alias = text.getText();
    return alias;
  }

  @Override
  public boolean nextPressed() throws Exception {
    emfToAlloy.setAlias(alias);
    return super.nextPressed();
  }

}
