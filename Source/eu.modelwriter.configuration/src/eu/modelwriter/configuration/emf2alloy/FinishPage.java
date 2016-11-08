package eu.modelwriter.configuration.emf2alloy;

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

public class FinishPage extends EMFToAlloyWizardPage {

  private boolean backButtonEnabled = true;
  private Composite container;
  private Button checkbox;

  protected FinishPage() {
    super("lastpage");
    setTitle("Finish");
    setDescription("Save the file");
  }

  @Override
  public void createControl(Composite parent) {
    container = new Composite(parent, SWT.NULL);
    container.setLayout(new GridLayout(2, false));
    Label label = new Label(container, SWT.NONE);
    label.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    label.setText("Select save location \n");
    Button button = new Button(container, SWT.PUSH);
    button.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, true, false));
    button.setText("Browse");
    button.addSelectionListener(new SelectionListener() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        FileDialog fd = new FileDialog(button.getShell(), SWT.SAVE);
        fd.setText("Save");
        fd.setFileName(getEmfToAlloy().getFileName() + ".mw");
        String path = emfToAlloy.getModelFilePath().substring(0,
            emfToAlloy.getModelFilePath().lastIndexOf("/"));
        fd.setFilterPath(path);
        String selectedPath = fd.open();
        if (selectedPath != null) {
          label.setText("Select save location for \n\"" + selectedPath + "\"");
          label.getParent().layout();
          getEmfToAlloy().save(selectedPath);
          getContainer().updateButtons();
        }
      }

      @Override
      public void widgetDefaultSelected(SelectionEvent e) {}
    });
    checkbox = new Button(container, SWT.CHECK);
    checkbox.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    checkbox.setText("Start EMF Instance generation");
    checkbox.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        getEmfToAlloy().setEmfInstanceStarter(checkbox.getSelection());
      }
    });
    checkbox.setSelection(false);
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
    getEmfToAlloy().reset();
    return super.backPressed();
  }

}
