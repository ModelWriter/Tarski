package eu.modelwriter.marker.ui.internal.wizards.markerwizard;

import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

public class MarkerPage extends WizardPage {

  public static CheckboxTreeViewer markTreeViewer = null;
  
  public MarkerPage() {
    super("Marking with Tag");
  }

  @Override
  public void createControl(Composite parent) {
    
  }

}
