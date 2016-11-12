package eu.modelwriter.marker.ui.internal.wizards.creatinginstanceelement;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.alloy.trace.TraceManager;
import eu.modelwriter.configuration.generation.GenerationWizard;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;

public class CreateInstanceElementWizard extends GenerationWizard {

  public CreateInstanceElementWizard() {
    super(null, "Create Instance Element");
  }

  private TypeSelectionPage typeSelectionPage;
  private ContainerSelectionPage containerSelectionPage;

  @Override
  public void addPages() {
    typeSelectionPage = new TypeSelectionPage();
    addPage(typeSelectionPage);
    containerSelectionPage = new ContainerSelectionPage();
    addPage(containerSelectionPage);
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
    typeSelectionPage.setPageComplete(false);
    containerSelectionPage.setPageComplete(false);
    super.createPageControls(pageContainer);
  }

  @Override
  public IWizardPage getStartingPage() {
    return typeSelectionPage;
  }

  @Override
  public String getWindowTitle() {
    return "Create Instance Element";
  }

  @Override
  public boolean performFinish() {
    final String sigTypeName = typeSelectionPage.getSelectedType();
    IMarker containerMarker = null;
    if (containerSelectionPage.isPageComplete())
      containerMarker = containerSelectionPage.getSelectedMarker();

    try {
      EObject eObject = TraceManager.get().createEObject(sigTypeName, "", containerMarker);
      IMarker marker = TraceManager.get().createMarkerForEObject(eObject);
      if (marker == null) {
        return false;
      }
      AlloyUtilities.addTypeToMarker(marker);
      AlloyUtilities.addMarkerToRepository(marker);
      String atomName = AlloyUtilities.getAtomNameById(MarkUtilities.getSourceId(marker));
      EcoreUtilities.eSetAttributeByName(eObject, "name", atomName);
      EcoreUtilities.saveResource(eObject);
      MarkUtilities.setText(marker, MarkerFactory.instanceToString(eObject));
      int index = Integer.parseInt(atomName.toString().substring(sigTypeName.length() + 1));
      AlloyUtilities.bindAtomToMarker(sigTypeName, index, marker);
      if (containerMarker != null) {
        String relation = TraceManager.get().getContainmentRelation(containerMarker, marker);
        AlloyUtilities.addRelation2Markers(containerMarker, marker, relation);
        AnnotationFactory.convertAnnotationType(containerMarker, false, false,
            AlloyUtilities.getTotalTargetCount(containerMarker));
      }
    } catch (TraceException e) {
      e.printStackTrace();
      return false;
    } finally {
      Visualization.showViz();
    }
    return true;
  }

}
