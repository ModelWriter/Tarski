package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import edu.mit.csail.sdg.alloy4viz.AlloyTuple;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;

public class ResolveCommand {
  public static void run() {
    if (Visualization.container == null) {
      return;
    }
    if (Visualization.rightClickedAnnotation instanceof AlloyTuple) {
      final AlloyTuple tuple = (AlloyTuple) Visualization.rightClickedAnnotation;
      final AlloyAtom fromAtom = tuple.getStart();
      final AlloyAtom toAtom = tuple.getEnd();
      AlloyUtilities.unsetImpactAndChanged(Visualization.getMarker(fromAtom),
          Visualization.getMarker(toAtom));
    } else {
      final AlloyAtom atom = (AlloyAtom) Visualization.rightClickedAnnotation;
      AlloyUtilities.unsetChangedAndAllImpacted(Visualization.getMarker(atom));
    }
    return;
  }
}
