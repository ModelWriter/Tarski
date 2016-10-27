package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import org.eclipse.core.resources.IMarker;

import edu.mit.csail.sdg.alloy4viz.AlloyAtom;

public interface VisualizationListener {

  void onRelationRemoved(IMarker startMarker, IMarker endMarker, String relation);

  void onAtomRemoved(IMarker marker);

  void onAtomRemoved(AlloyAtom atom);

  void onReasonedRelationAccepted(IMarker fromMarker, IMarker toMarker, String relation);

  void onReasonedRelationAccepted(AlloyAtom fromAtom, AlloyAtom toAtom, String relation);

  void onAtomAccepted(AlloyAtom alloyAtom);

}
