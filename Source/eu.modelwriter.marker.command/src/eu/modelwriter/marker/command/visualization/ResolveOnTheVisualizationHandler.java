package eu.modelwriter.marker.command.visualization;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import edu.mit.csail.sdg.alloy4viz.AlloyTuple;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.ui.internal.views.Visualization;

public class ResolveOnTheVisualizationHandler extends AbstractHandler {
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    if (Visualization.container == null) {
      return null;
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
    return null;
  }

}
