package eu.modelwriter.configuration.alloy2emf;

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

import eu.modelwriter.configuration.internal.Utilities;

public class FinishPage extends AlloyToEMFWizardPage {

  private boolean backButtonEnabled = true;
  private Composite container;
  private Button checkbox;

  protected FinishPage() {
    super("lastpage");
    setTitle("Finish");
  }

  @Override
  public void createControl(Composite parent) {
    container = new Composite(parent, SWT.NULL);
    container.setLayout(new GridLayout(2, false));
    for (String alias : alloyToEMF.getAliases()) {
      Label label = new Label(container, SWT.NONE);
      label.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
      label.setText("Select save location for " + alias + " \n");
      Button button = new Button(container, SWT.PUSH);
      button.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, true, false));
      button.setText("Browse");
      button.addSelectionListener(new SelectionListener() {

        @Override
        public void widgetSelected(SelectionEvent e) {
          FileDialog fd = new FileDialog(button.getShell(), SWT.SAVE);
          fd.setText("Save");
          fd.setFileName(alias + ".xmi");
          String path = alloyToEMF.getAlloyFilePath().substring(0,
              alloyToEMF.getAlloyFilePath().lastIndexOf(Utilities.LINE_SEPERATOR));
          fd.setFilterPath(path);
          String selectedPath = fd.open();
          if (selectedPath != null) {
            label.setText("Select save location for " + alias + " \n\"" + selectedPath + "\"");
            label.getParent().layout();
            alloyToEMF.setSaveLocation(alias, selectedPath);
            getContainer().updateButtons();
          }
        }

        @Override
        public void widgetDefaultSelected(SelectionEvent e) {}
      });
    }
    checkbox = new Button(container, SWT.CHECK);
    checkbox.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    checkbox.setText("Append generated file(s) to alloy file?");
    // checkbox.setEnabled(false); // Disabled for now
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

  @Override
  public boolean backPressed() {
    alloyToEMF.resetRun();
    return true;
  }

  public void success() {
    setMessage("Operation succeed without any error.");
  }

  public void fail() {
    setErrorMessage("Something went wrong!");
  }

  public boolean appendToFileChecked() {
    return checkbox.getSelection();
  }

  public void updateConverter() {
    alloyToEMF = (AlloyToEMF) getConverter();
  }
}
