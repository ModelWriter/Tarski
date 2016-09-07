package eu.modelwriter.configuration.alloy2emf;

import org.eclipse.jface.wizard.IWizardPage;

import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.converter.AbstractConverter;
import eu.modelwriter.configuration.converter.ConverterWizard;

public class AlloyToEMFWizard extends ConverterWizard {

  private AlloyRunCommandsPage alloyRunCommandsPage;
  private FinishPage finishPage;

  public AlloyToEMFWizard(AbstractConverter converter, String title) {
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
    addPage(new AlloyExampleSelectionPage());
    for (String alias : getAlloyToEmf().getAliases()) {
      addPage(new EMFContainerSelectionPage(alias, getAlloyToEmf().getEClasses(alias)));
    }
    finishPage = new FinishPage();
    addPage(finishPage);
    finishPage.updateConverter();
  }

  @Override
  public boolean performFinish() {
    return getAlloyToEmf().performFinish(finishPage.appendToFileChecked());
  }

  @Override
  public boolean canFinish() {
    IWizardPage page = getContainer().getCurrentPage();
    boolean canFinish = false;
    boolean isLastPage = page.getName().equals("lastpage");
    if (isLastPage && getAlloyToEmf().getState() == AbstractConverter.NOT_STARTED) {
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
      if (isLastPage && getAlloyToEmf().getState() == AbstractConverter.FINISHED) {
        canFinish = getAlloyToEmf().isAllLocationsSelected();
      }
    }
    return canFinish;
  }

}
