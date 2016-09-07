package eu.modelwriter.configuration.emf2alloy;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class ContainerSelectionPage extends EMFToAlloyWizardPage {

  private org.eclipse.swt.widgets.List classList;
  private List<String> emfClasses;
  private String emfAlias;
  private Button checkbox;

  protected ContainerSelectionPage(String emfAlias, List<String> classes) {
    super("SelectEMFContainer");
    this.emfAlias = emfAlias;
    emfClasses = classes;
    setTitle("Select EMF Class");
    setDescription("Select the container class to continue");
  }

  @Override
  public void createControl(Composite parent) {
    final Composite container = new Composite(parent, SWT.NULL);
    container.setLayout(new GridLayout(1, true));
    container.setLayoutData(new GridData(SWT.FILL));

    classList =
        new org.eclipse.swt.widgets.List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
    classList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

    for (String clazz : emfClasses) {
      classList.add(clazz);
    }
    classList.setSelection(0);
    classList.addSelectionListener(new SelectionListener() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        setPageComplete(true);
      }

      @Override
      public void widgetDefaultSelected(SelectionEvent e) {

      }
    });
    checkbox = new Button(container, SWT.CHECK);
    checkbox.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, true, false));
    checkbox.setText("Don't include container class.");
    checkbox.setSelection(true);
    setControl(container);
  }

  public List<String> getEmfClasses() {
    return emfClasses;
  }

  public void setEmfClasses(List<String> emfClasses) {
    this.emfClasses = emfClasses;
    for (String clazz : emfClasses) {
      classList.add(clazz);
    }
  }

  public String getEmfAlias() {
    return emfAlias;
  }

  public void setEmfAlias(String emfAlias) {
    this.emfAlias = emfAlias;
  }

  public String getSelectedClass() {
    return emfClasses.get(classList.getSelectionIndex());
  }

  @Override
  public boolean nextPressed() throws Exception {
    getEmfToAlloy().setContainerClass(getSelectedClass(), checkbox.getSelection());
    return super.nextPressed();
  }

}
