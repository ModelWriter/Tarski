package eu.modelwriter.configuration.alloy2emf;

import org.eclipse.jface.wizard.IWizardPage;

import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.generation.AbstractGeneration;
import eu.modelwriter.configuration.generation.GenerationWizard;

public class AlloyToEMFWizard extends GenerationWizard {

  private AlloyRunCommandsPage alloyRunCommandsPage;
  private FinishPage finishPage;

  public AlloyToEMFWizard(AbstractGeneration converter, String title) {
    super(converter, title);
  }

  public AlloyToEMF getAlloyToEmf() {
    return getConverter();
  }

  @Override
  public AlloyToEMF getConverter() {
    return (AlloyToEMF) super.getConverter();
  }

  @Override
  public void addPages() {
    super.addPages();
    alloyRunCommandsPage = new AlloyRunCommandsPage(getAlloyToEmf().getRunCommands());
    addPage(alloyRunCommandsPage);
    for (String alias : getAlloyToEmf().getAliases()) {
      addPage(new BoundSelectionPage(getAlloyToEmf().getEMFModel(alias),
          getAlloyToEmf().getCurrentSigs()));
    }
    addPage(new AlloySolutionSelectionPage());
    for (String alias : getAlloyToEmf().getAliases()) {
      addPage(new EMFContainerSelectionPage(alias, getAlloyToEmf().getEClasses(alias)));
    }
    finishPage = new FinishPage();
    addPage(finishPage);
    finishPage.updateConverter();
  }

  @Override
  public boolean performFinish() {
    return getAlloyToEmf().performFinish(finishPage.appendToFileChecked(), finishPage.startATC());
  }

  @Override
  public boolean canFinish() {
    IWizardPage page = getContainer().getCurrentPage();
    boolean canFinish = false;
    boolean isLastPage = page.getName().equals("lastpage");
    if (isLastPage && getAlloyToEmf().getState() == AbstractGeneration.NOT_STARTED) {
      FinishPage finishPage = (FinishPage) page;
      try {
        getAlloyToEmf().run();
        finishPage.success();
        canFinish = getAlloyToEmf().isAllLocationsSelected();
      } catch (TraceException e) {
        canFinish = false;
        finishPage.fail();
        getAlloyToEmf().onException(e);
      }
    } else {
      if (isLastPage && getAlloyToEmf().getState() == AbstractGeneration.FINISHED) {
        canFinish = getAlloyToEmf().isAllLocationsSelected();
      }
    }
    return canFinish;
  }

}
