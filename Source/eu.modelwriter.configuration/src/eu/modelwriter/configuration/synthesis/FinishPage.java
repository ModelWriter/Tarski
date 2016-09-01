package eu.modelwriter.configuration.synthesis;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;

public class FinishPage extends MWizardPage {

  private AlloyToEMF alloyToEMF;
  private boolean backButtonEnabled = true;
  private Composite container;
  private Button checkbox;

  protected FinishPage() {
    super("lastpage");
    setTitle("Finish");
    setDescription("Creating EMF instances...");
  }

  @Override
  public void createControl(Composite parent) {
    container = new Composite(parent, SWT.NULL);
    container.setLayout(new GridLayout(2, false));
    alloyToEMF = getAlloyToEMF();
    for (String alias : alloyToEMF.getAliases()) {
      Label label = new Label(container, SWT.NONE);
      label.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, true));
      label.setText("Select save location for " + alias);
      Button button = new Button(container, SWT.PUSH);
      button.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, true, true));
      button.setText("Browse");
      button.addSelectionListener(new SelectionListener() {

        @Override
        public void widgetSelected(SelectionEvent e) {
          FileDialog fd = new FileDialog(button.getShell(), SWT.SAVE);
          fd.setText("Save");
          fd.setFileName(alias + ".xmi");
          fd.setFilterPath(Platform.getLocation().toOSString());
          String selectedPath = fd.open();
          if (selectedPath != null) {
            label.setText(label.getText() + " \"" + selectedPath + "\"");
            alloyToEMF.setSaveLocation(alias, selectedPath);
            getContainer().updateButtons();
          }
        }

        @Override
        public void widgetDefaultSelected(SelectionEvent e) {}
      });
    }
    checkbox = new Button(container, SWT.CHECK);
    checkbox.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
    checkbox.setText("Append generated file(s) to alloy file?");
    checkbox.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {}
    });

    setControl(container);
  }

  public void setBackButtonEnabled(boolean enabled) {
    backButtonEnabled = enabled;
    getContainer().updateButtons();
  }

  @Override
  public IWizardPage getPreviousPage() {
    if (!backButtonEnabled) {
      return null;
    }
    return super.getPreviousPage();
  }

  public void success() {
    setMessage("Operation succeed without any error.");
    setBackButtonEnabled(false);
  }

  public void fail() {
    setErrorMessage("Something went wrong!");
  }

  public boolean appendToFileChecked() {
    return checkbox.getSelection();
  }
}
