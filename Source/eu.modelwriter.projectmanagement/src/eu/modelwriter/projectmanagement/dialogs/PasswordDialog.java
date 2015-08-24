package eu.modelwriter.projectmanagement.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

public class PasswordDialog extends Dialog {
  private Text txtUser;
  private Text txtPassword;
  private String user = "";
  private String password = "";

  public PasswordDialog(Shell parentShell) {
    super(parentShell);
  }

  @Override
  protected Control createDialogArea(Composite parent) {
    Composite container = (Composite) super.createDialogArea(parent);
    GridLayout layout = new GridLayout(2, false);
    layout.marginRight = 5;
    layout.marginLeft = 10;
    container.setLayout(layout);

    Label lblUser = new Label(container, SWT.NONE);
    lblUser.setText("User:");

    txtUser = new Text(container, SWT.BORDER);
    txtUser.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    txtUser.setText(user);

    Label lblPassword = new Label(container, SWT.NONE);
    GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
    gd_lblNewLabel.horizontalIndent = 1;
    lblPassword.setLayoutData(gd_lblNewLabel);
    lblPassword.setText("Password:");

    txtPassword = new Text(container, SWT.BORDER | SWT.SINGLE | SWT.PASSWORD);
    txtPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    txtPassword.setText(password);
    return container;
  }

  // override method to use "Login" as label for the OK button
  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, IDialogConstants.OK_ID, "Login", true);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }

  @Override
  protected Point getInitialSize() {
    return new Point(400, 150);
  }

  @Override
  protected void okPressed() {
    // Copy data from SWT widgets into fields on button press.
    // Reading data from the widgets later will cause an SWT
    // widget disposed exception.
    user = txtUser.getText();
    password = txtPassword.getText();
    super.okPressed();
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

} 
