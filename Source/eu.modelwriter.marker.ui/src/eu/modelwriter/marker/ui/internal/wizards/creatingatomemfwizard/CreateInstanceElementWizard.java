package eu.modelwriter.marker.ui.internal.wizards.creatingatomemfwizard;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.alloy.trace.TraceManager;
import eu.modelwriter.configuration.generation.GenerationWizard;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.traceability.core.persistence.AtomType;

public class CreateInstanceElementWizard extends GenerationWizard {

  public CreateInstanceElementWizard() {
    super(null, "Create Instance Element");
  }

  private TypeSelectionPage typeSelectionPage;
  private ContainerSelectionPage containerSelectionPage;

  @Override
  public void addPages() {
    this.typeSelectionPage = new TypeSelectionPage();
    this.addPage(this.typeSelectionPage);
    containerSelectionPage = new ContainerSelectionPage();
    this.addPage(containerSelectionPage);
  }

  @Override
  public boolean canFinish() {
    IWizardPage page = getContainer().getCurrentPage();
    if (page instanceof TypeSelectionPage) {
      TypeSelectionPage typePage = ((TypeSelectionPage) page);
      if (typePage.isPageComplete())
        return !typePage.canFlipToNextPage();
      else
        return false;
    } else if (page instanceof ContainerSelectionPage)
      return page.isPageComplete();
    return false;
  }

  @Override
  public void createPageControls(final Composite pageContainer) {
    this.typeSelectionPage.setPageComplete(false);
    this.containerSelectionPage.setPageComplete(false);
    super.createPageControls(pageContainer);
  }

  @Override
  public IWizardPage getStartingPage() {
    return this.typeSelectionPage;
  }

  @Override
  public String getWindowTitle() {
    return "Create Instance Element";
  }

  @Override
  public boolean performFinish() {
    final String sigTypeName = this.typeSelectionPage.getSelectedType();
    IMarker containerMarker = null;
    if (containerSelectionPage.isPageComplete())
      containerMarker = containerSelectionPage.getSelectedMarker();

    try {
      AtomType atomType = AlloyUtilities.addNewAtom2Sig(sigTypeName);
      String atomName = AlloyUtilities.getAtomNameById(atomType.getLabel());
      IMarker marker =
          TraceManager.get().createMarkerForAtom(sigTypeName, atomName, containerMarker);
      if (marker == null) {
        return false;
      }
      int index = Integer.parseInt(atomName.toString().substring(sigTypeName.length() + 1));
      AlloyUtilities.bindAtomToMarker(sigTypeName, index, marker);
      AlloyUtilities.addMarkerToRepository(marker);
      Visualization.showViz();
      MarkUtilities.focusMarker(marker);
    } catch (TraceException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

}
