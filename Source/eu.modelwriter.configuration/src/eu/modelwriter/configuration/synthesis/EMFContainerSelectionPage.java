package eu.modelwriter.configuration.synthesis;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.configuration.alloy.trace.TraceException;

public class EMFContainerSelectionPage extends MWizardPage {

  private org.eclipse.swt.widgets.List classList;
  private List<String> emfClasses;
  private String emfAlias;
  private AlloyToEMF alloyToEMF;

  protected EMFContainerSelectionPage(String emfAlias) {
    super("Select EMF Container");
    this.emfAlias = emfAlias;
    this.setTitle("Select EMF Class");
    this.setDescription("Select a class to create a \"" + emfAlias + "\" EMF instace");
  }

  @Override
  public void createControl(Composite parent) {
    final Composite container = new Composite(parent, SWT.NULL);
    container.setLayout(new FillLayout(SWT.HORIZONTAL));

    classList =
        new org.eclipse.swt.widgets.List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);

    alloyToEMF = getAlloyToEMF();
    emfClasses = alloyToEMF.getEClasses(emfAlias);
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
    this.setControl(container);
  }


  @Override
  public boolean nextPressed() throws TraceException {
    alloyToEMF.setSelectedEClass(emfAlias, getSelectedClass());
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
