package eu.modelwriter.configuration.synthesis;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

import eu.modelwriter.configuration.alloy.trace.TraceException;

public class AlloyToEMFWizard extends Wizard {

  private AlloyToEMF alloyToEmf;
  private AlloyRunCommandsPage alloyRunCommandsPage;
  private FinishPage finishPage;

  public AlloyToEMFWizard(AlloyToEMF alloyToEmf) {
    super();
    this.alloyToEmf = alloyToEmf;
    setWindowTitle("Alloy to EMF");
  }

  public AlloyToEMF getAlloyToEmf() {
    return alloyToEmf;
  }

  @Override
  public void addPages() {
    super.addPages();
    alloyRunCommandsPage = new AlloyRunCommandsPage(alloyToEmf.getRunCommands());
    addPage(alloyRunCommandsPage);
    addPage(new AlloyExampleSelectionPage());
    for (String alias : alloyToEmf.getAliases()) {
      addPage(new EMFContainerSelectionPage(alias));
    }
    finishPage = new FinishPage();
    addPage(finishPage);
  }

  @Override
  public boolean performFinish() {
    return alloyToEmf.performFinish(finishPage.appendToFileChecked());
  }

  @Override
  public boolean canFinish() {
    IWizardPage page = getContainer().getCurrentPage();
    boolean canFinish = false;
    boolean isLastPage = page.getName().equals("lastpage");
    if (isLastPage && alloyToEmf.state == alloyToEmf.NOT_STARTED) {
      FinishPage finishPage = (FinishPage) page;
      try {
        alloyToEmf.run();
        finishPage.success();
        canFinish = alloyToEmf.isAllLocationsSelected();
      } catch (TraceException e) {
        canFinish = false;
        finishPage.fail();
        alloyToEmf.onException(e);
      }
    } else if (isLastPage && alloyToEmf.state == alloyToEmf.FINISHED) {
      canFinish = alloyToEmf.isAllLocationsSelected();
    }
    return canFinish;
  }

}
