package eu.modelwriter.configuration.emf2alloy;

import org.eclipse.core.resources.IFile;
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
            emfToAlloy.getModelFilePath().lastIndexOf(Utilities.FILE_SEPERATOR));
        fd.setFilterPath(path);
        String selectedPath = fd.open();
        if (selectedPath != null) {
          String message = ("Select save location for \n\"" + selectedPath + "\"");
          label.setText(message.length() >= 70 ? (message.substring(0, 70) + "...") : message);
          label.setToolTipText(selectedPath);
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

    checkbox.setSelection(false);
    new Label(container, SWT.NO).setVisible(false);
    Button browseInstanceCheck = new Button(container, SWT.CHECK);
    browseInstanceCheck.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    browseInstanceCheck.setText("Load an existing instance file");
    final Button browseButton = new Button(container, SWT.PUSH);
    browseButton.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, true, false));
    browseButton.setText("Browse for Instance");
    browseButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        FileDialog fd = new FileDialog(button.getShell(), SWT.SAVE);
        fd.setText("Select");
        String path = emfToAlloy.getModelFilePath().substring(0,
            emfToAlloy.getModelFilePath().lastIndexOf(Utilities.FILE_SEPERATOR));
        fd.setFilterPath(path);
        String selectedPath = fd.open();
        if (selectedPath != null) {
          IFile iFile = Utilities.getIFileFromPath(selectedPath);
          getEmfToAlloy()
              .existingInstancePath(iFile == null ? selectedPath : iFile.getFullPath().toString());
          getContainer().updateButtons();
        }
      }
    });
    browseInstanceCheck.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        browseButton.setEnabled(browseInstanceCheck.getSelection());
        checkbox.setEnabled(!browseInstanceCheck.getSelection());
      }
    });
    browseInstanceCheck.setSelection(false);
    browseButton.setEnabled(false);
    checkbox.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        getEmfToAlloy().setEmfInstanceStarter(checkbox.getSelection());
        browseInstanceCheck.setEnabled(!checkbox.getSelection());
      }
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
    getEmfToAlloy().reset();
    return super.backPressed();
  }

}
