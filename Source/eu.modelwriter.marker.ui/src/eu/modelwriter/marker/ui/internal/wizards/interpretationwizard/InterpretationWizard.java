package eu.modelwriter.marker.ui.internal.wizards.interpretationwizard;

import java.util.ArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.wizard.Wizard;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MappingWizard;

public class InterpretationWizard extends Wizard {

  private SelectionPage selectionPage;

  private IMarker selectedMarker;

  private final ArrayList<IMarker> candidateToTypeChanging = new ArrayList<>();

  public InterpretationWizard() {
    this.setWindowTitle("Interpretation of Atom");
  }

  @Override
  public void addPages() {
    this.selectionPage = new SelectionPage("Selection Page");
    this.addPage(this.selectionPage);
  }

  private void findCandidateToTypeChangingMarkers(final IMarker iMarker) {
    this.candidateToTypeChanging.add(iMarker);

    final ArrayList<IMarker> relationsSources =
        AlloyUtilities.getSourcesOfMarkerAtRelations(iMarker);

    for (final IMarker marker : relationsSources) {
      this.candidateToTypeChanging.add(marker);
    }
  }

  public IMarker getSelectedMarker() {
    return this.selectedMarker;
  }

  @Override
  public boolean performFinish() {
    if (this.selectionPage.getSelection() instanceof IMarker) {
      this.selectedMarker = (IMarker) this.selectionPage.getSelection();
    }

    this.findCandidateToTypeChangingMarkers(this.selectedMarker);
    this.selectedMarker = MappingWizard.convertAnnotationType(this.selectedMarker, true, true);

    IMarker mMarker = null;
    for (int i = 1; i < this.candidateToTypeChanging.size(); i++) {
      mMarker = this.candidateToTypeChanging.get(i);
      MappingWizard.convertAnnotationType(mMarker, true,
          MarkUtilities.compare(mMarker, this.selectedMarker));
    }
    AlloyUtilities.removeAllRelationsOfMarker(this.selectedMarker);
    AlloyUtilities.removeRelationOfMarker(this.selectedMarker);

    return true;
  }
}
