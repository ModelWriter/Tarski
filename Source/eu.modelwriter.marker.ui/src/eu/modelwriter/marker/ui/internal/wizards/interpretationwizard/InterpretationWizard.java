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
    setWindowTitle("Interpretation of Atom");
  }

  @Override
  public void addPages() {
    selectionPage = new SelectionPage("Selection Page");
    addPage(selectionPage);
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
    return selectedMarker;
  }

  @Override
  public boolean performFinish() {
    if (selectionPage.getSelection() instanceof IMarker) {
      selectedMarker = (IMarker) selectionPage.getSelection();
    }

    if (selectedMarker == null)
      return false;

    final ArrayList<IMarker> candidateToTypeChanging =
        findCandidateToTypeChangingMarkers(selectedMarker);
    selectedMarker = AnnotationFactory.convertAnnotationType(selectedMarker, true, true,
        AlloyUtilities.getTotalTargetCount(selectedMarker));

    IMarker mMarker = null;
    for (int i = 1; i < candidateToTypeChanging.size(); i++) {
      mMarker = candidateToTypeChanging.get(i);
      AnnotationFactory.convertAnnotationType(mMarker, true,
          MarkUtilities.compare(mMarker, selectedMarker),
          AlloyUtilities.getTotalTargetCount(mMarker));
    }
    AlloyUtilities.removeAllRelationsOfMarker(selectedMarker);
    AlloyUtilities.removeRelationOfMarker(selectedMarker);

    return true;
  }

  @Override
  public boolean canFinish() {
    return selectionPage.isPageComplete();
  }

}
