package eu.modelwriter.marker.ui.internal.wizards.creatingatomwizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.internal.MarkerTypeElement;

public class CreatingAtomWizard extends Wizard {

  private UntypedMarkerPage untypedMarkerPage;
  private MarkerTypesPage markerTypesPage;
  private final ArrayList<IMarker> candidateToTypeChanging = new ArrayList<IMarker>();

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
  public void createPageControls(final Composite pageContainer) {
    this.untypedMarkerPage.setPageComplete(false);
    this.markerTypesPage.setPageComplete(false);
    super.createPageControls(pageContainer);
  }

  private void findCandidateToTypeChangingMarkers(final IMarker iMarker) {
    this.candidateToTypeChanging.add(iMarker);

    final ArrayList<IMarker> relationsSources = AlloyUtilities.getSourcesOfMarkerAtRelations(iMarker);

    for (final IMarker marker : relationsSources) {
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
    final String markerType = ((MarkerTypeElement) ((TreeSelection) this.markerTypesPage.getSelection())
        .getFirstElement()).getType();

    this.findCandidateToTypeChangingMarkers(iMarker);
    iMarker = AnnotationFactory.convertAnnotationType(iMarker, true, true,
        AlloyUtilities.getTotalTargetCount(iMarker));

    IMarker mMarker = null;
    for (int i = 1; i < this.candidateToTypeChanging.size(); i++) {
      mMarker = this.candidateToTypeChanging.get(i);
      AnnotationFactory.convertAnnotationType(mMarker, true,
          MarkUtilities.compare(mMarker, iMarker), AlloyUtilities.getTotalTargetCount(mMarker));
    }

    AlloyUtilities.removeAllRelationsOfMarker(iMarker);
    AlloyUtilities.removeRelationOfMarker(iMarker);
    if (MarkUtilities.getGroupId(iMarker) != null) {
      final List<IMarker> list = MarkerFactory.findMarkersByGroupId(iMarker.getResource(),
          MarkUtilities.getGroupId(iMarker));
      for (final IMarker marker : list) {
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
