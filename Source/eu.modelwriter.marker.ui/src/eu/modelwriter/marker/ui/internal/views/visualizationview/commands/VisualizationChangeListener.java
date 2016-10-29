package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import org.eclipse.core.resources.IMarker;

import edu.mit.csail.sdg.alloy4viz.AlloyAtom;

public interface VisualizationChangeListener {

  /**
   * When a relation has deleted
   * 
   * @param startMarker
   * @param endMarker
   * @param relation
   */
  void onRelationRemoved(IMarker startMarker, IMarker endMarker, String relation);

  /**
   * When an atom has deleted. Parameters will be empty if this atom has no trace with an ecore
   * element.
   * 
   * @param sigTypeName, deleted atoms sig type
   * @param relUri, relative uri @EObject that traced by this atom
   */
  void onAtomRemoved(String sigTypeName, String relUri);

  /**
   * When interpreting a relation that has a tuple of non-reasoned atom to reasoned atom.
   * 
   * @param fromMarker Non-reasoned atom's marker
   * @param toAtom The atom
   * @param relation relation name
   */
  void onReasonedRelationAccepted(AlloyAtom fromAtom, AlloyAtom toAtom, String relation);

  //
  // /**
  // * When interpreting a relation that has a tuple of reasoned atom to non-reasoned atom.
  // *
  // * @param fromAtom The atom
  // * @param toMarker Non-reasoned atom's marker
  // * @param relation relation name
  // */
  // void onReasonedRelationAccepted(AlloyAtom fromAtom, IMarker toMarker, String relation);
  //
  // /**
  // * When interpreting a relation that has a tuple of two non-reasoned atom
  // *
  // * @param fromMarker source atom's marker
  // * @param toMarker target atom's marker
  // * @param relation relation name
  // */
  // void onReasonedRelationAccepted(IMarker fromMarker, IMarker toMarker, String relation);

  /**
   * When interpreting an atom
   * 
   * @param alloyAtom
   */
  void onAtomAccepted(AlloyAtom alloyAtom);

}
