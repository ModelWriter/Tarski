package eu.modelwriter.configuration.alloy2emf;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.configuration.alloy.trace.TraceException;

public class EMFContainerSelectionPage extends AlloyToEMFWizardPage {

  private org.eclipse.swt.widgets.List classList;
  private List<String> emfClasses;
  private String emfAlias;

  protected EMFContainerSelectionPage(String emfAlias, List<String> classes) {
    super("Select EMF Container");
    this.emfAlias = emfAlias;
    emfClasses = classes;
    setTitle("Select EMF Class");
    setDescription("Select a class to create a \"" + emfAlias + "\" EMF instace");
  }

  @Override
  public void createControl(Composite parent) {
    final Composite container = new Composite(parent, SWT.NULL);
    container.setLayout(new FillLayout(SWT.HORIZONTAL));

    classList =
        new org.eclipse.swt.widgets.List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);

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
    setControl(container);
  }


  @Override
  public boolean nextPressed() throws TraceException {
    ((AlloyToEMF) getConverter()).setSelectedEClass(emfAlias, getSelectedClass());
    return true;
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
}
