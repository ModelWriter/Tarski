package eu.modelwriter.marker.ui.internal.wizards.markerwizard;

import org.eclipse.jface.wizard.Wizard;
import eu.modelwriter.marker.*;
import eu.modelwriter.marker.typing.*;

public class MarkerWizard extends Wizard {

  private MarkerPage page;
  
  public MarkerWizard() {
    super();
  }
  
  @Override
  public String getWindowTitle() {
    return "Marking with Tag";
  }
  
  @Override
  public void addPages() {
    page = new MarkerPage();
    super.addPages();
    this.addPage(page);
  }
  
  @Override
  public boolean performFinish() {
    return false;
  }

}
