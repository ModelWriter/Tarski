package eu.modelwriter.marker.ui.internal.wizards.interpretationwizard;

import java.util.ArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.wizard.Wizard;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkUtilities;

public class InterpretationWizard extends Wizard {

  private SelectionPage selectionPage;

  private IMarker selectedMarker;

  public InterpretationWizard() {
    this.setWindowTitle("Interpretation of Atom");
  }

  @Override
  public void addPages() {
    this.selectionPage = new SelectionPage("Selection Page");
    this.addPage(this.selectionPage);
  }

  private ArrayList<IMarker> findCandidateToTypeChangingMarkers(final IMarker iMarker) {
    final ArrayList<IMarker> candidateToTypeChanging = new ArrayList<>();
    candidateToTypeChanging.add(iMarker);

    final ArrayList<IMarker> relationsSources =
        AlloyUtilities.getSourcesOfMarkerAtRelations(iMarker);

    for (final IMarker marker : relationsSources) {
      candidateToTypeChanging.add(marker);
    }
    return candidateToTypeChanging;
  }

  public IMarker getSelectedMarker() {
    return this.selectedMarker;
  }

  @Override
  public boolean performFinish() {
    if (this.selectionPage.getSelection() instanceof IMarker) {
      this.selectedMarker = (IMarker) this.selectionPage.getSelection();
    }

    final ArrayList<IMarker> candidateToTypeChanging =
        this.findCandidateToTypeChangingMarkers(this.selectedMarker);
    this.selectedMarker = AnnotationFactory.convertAnnotationType(this.selectedMarker, true, true,
        AlloyUtilities.getTotalTargetCount(this.selectedMarker));

    IMarker mMarker = null;
    for (int i = 1; i < candidateToTypeChanging.size(); i++) {
      mMarker = candidateToTypeChanging.get(i);
      AnnotationFactory.convertAnnotationType(mMarker, true,
          MarkUtilities.compare(mMarker, this.selectedMarker),
          AlloyUtilities.getTotalTargetCount(mMarker));
    }
    AlloyUtilities.removeAllRelationsOfMarker(this.selectedMarker);
    AlloyUtilities.removeRelationOfMarker(this.selectedMarker);

    return true;
  }
}
