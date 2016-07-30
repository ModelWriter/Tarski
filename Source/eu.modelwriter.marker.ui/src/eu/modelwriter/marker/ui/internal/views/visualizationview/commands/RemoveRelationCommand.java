package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import java.util.Map;

import org.eclipse.core.resources.IMarker;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MappingWizard;

public class RemoveRelationCommand implements Runnable {
  private final String relation;
  private IMarker fromMarker;
  private final IMarker toMarker;

  public RemoveRelationCommand(final IMarker fromMarker, final IMarker toMarker,
      final String relation) {
    this.fromMarker = fromMarker;
    this.toMarker = toMarker;
    this.relation = relation;
  }

  @Override
  public void run() {
    AlloyUtilities.removeFieldOfMarkers(this.fromMarker, this.toMarker, this.relation);
    this.fromMarker = MappingWizard.convertAnnotationType(this.fromMarker, false, false);
    final Map<IMarker, String> relationsOfSelected =
        AlloyUtilities.getRelationsOfFirstSideMarker(this.fromMarker);
    if (relationsOfSelected.isEmpty()) {
      AlloyUtilities.unsetChanged(this.fromMarker);
    }
  }
}
