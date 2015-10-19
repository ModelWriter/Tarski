package eu.modelwriter.marker.ui.internal.wizards.creatingatomwizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.internal.MarkerTypeElement;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MappingWizard;

public class CreatingAtomWizard extends Wizard {

  private UntypedMarkerPage untypedMarkerPage;
  private MarkerTypesPage markerTypesPage;
  private ArrayList<IMarker> candidateToTypeChanging = new ArrayList<IMarker>();

  public CreatingAtomWizard() {}

  @Override
  public void addPages() {
    this.untypedMarkerPage = new UntypedMarkerPage();
    this.addPage(this.untypedMarkerPage);
    this.markerTypesPage = new MarkerTypesPage();
    this.addPage(this.markerTypesPage);
  }

  @Override
  public boolean canFinish() {
    if (this.markerTypesPage.isPageComplete()) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void createPageControls(Composite pageContainer) {
    this.untypedMarkerPage.setPageComplete(false);
    this.markerTypesPage.setPageComplete(false);
    super.createPageControls(pageContainer);
  }

  private void findCandidateToTypeChangingMarkers(IMarker iMarker) {
    this.candidateToTypeChanging.add(iMarker);

    ArrayList<IMarker> relationsSources = AlloyUtilities.getSourcesOfMarkerAtRelations(iMarker);

    for (IMarker marker : relationsSources) {
      this.candidateToTypeChanging.add(marker);
    }
  }

  @Override
  public IWizardPage getStartingPage() {
    return this.untypedMarkerPage;
  }

  @Override
  public String getWindowTitle() {
    return "Create Atom";
  }

  @Override
  public boolean performFinish() {
    IMarker iMarker =
        (IMarker) ((TreeSelection) this.untypedMarkerPage.getSelection()).getFirstElement();
    String markerType = ((MarkerTypeElement) ((TreeSelection) this.markerTypesPage.getSelection())
        .getFirstElement()).getType();

    this.findCandidateToTypeChangingMarkers(iMarker);
    iMarker = MappingWizard.convertAnnotationType(iMarker, true, true);

    IMarker mMarker = null;
    for (int i = 1; i < this.candidateToTypeChanging.size(); i++) {
      mMarker = this.candidateToTypeChanging.get(i);
      MappingWizard.convertAnnotationType(mMarker, true, MarkUtilities.compare(mMarker, iMarker));
    }

    AlloyUtilities.removeAllRelationsOfMarker(iMarker);
    AlloyUtilities.removeRelationOfMarker(iMarker);
    if (MarkUtilities.getGroupId(iMarker) != null) {
      List<IMarker> list = MarkerFactory.findMarkersByGroupId(iMarker.getResource(),
          MarkUtilities.getGroupId(iMarker));
      for (IMarker marker : list) {
        AlloyUtilities.removeTypeFromMarker(marker);
        MarkUtilities.setType(marker, markerType);
        if (MarkUtilities.getLeaderId(marker) != null) {
          AlloyUtilities.addTypeToMarker(marker);
        }
        AlloyUtilities.addMarkerToRepository(marker);
      }
    } else {
      AlloyUtilities.removeTypeFromMarker(iMarker);
      MarkUtilities.setType(iMarker, markerType);
      AlloyUtilities.addTypeToMarker(iMarker);
      AlloyUtilities.addMarkerToRepository(iMarker);
    }
    return true;
  }
}
