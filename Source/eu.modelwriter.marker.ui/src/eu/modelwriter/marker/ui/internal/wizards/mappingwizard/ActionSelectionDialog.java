package eu.modelwriter.marker.ui.internal.wizards.mappingwizard;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class ActionSelectionDialog extends Dialog {

  /**
   * Create the dialog.
   *
   * @param parentShell
   */
  public ActionSelectionDialog(Shell parentShell) {
    super(parentShell);
    setShellStyle(SWT.DIALOG_TRIM);
  }

  @Override
  protected void buttonPressed(int buttonId) {
    setReturnCode(buttonId);
    close();
  }

  /**
   * Create contents of the button bar.
   *
   * @param parent
   */
  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, IDialogConstants.YES_ID, "Add Type", true);
    createButton(parent, IDialogConstants.NO_ID, "Remove Current Type", false);

  }

  /**
   * Create contents of the dialog.
   *
   * @param parent
   */
  @Override
  protected Control createDialogArea(Composite parent) {
    Composite container = (Composite) super.createDialogArea(parent);
    container.setToolTipText("");
    container.setLayout(null);

    Label lblNewLabel = new Label(container, SWT.NONE);
    lblNewLabel.setBounds(31, 10, 317, 13);
    lblNewLabel.setText("Which action do you want to do ?!");

    return container;
  }

  /**
   * Return the initial size of the dialog.
   */
  @Override
  protected Point getInitialSize() {
    return new Point(284, 123);
  }
}
