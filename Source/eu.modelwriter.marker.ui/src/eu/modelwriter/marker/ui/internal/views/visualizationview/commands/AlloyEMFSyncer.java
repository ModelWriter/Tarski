package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import java.io.IOException;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.dialogs.MessageDialog;

import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import eu.modelwriter.configuration.alloy.trace.TraceManager;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;

public class AlloyEMFSyncer implements VisualizationListener {

  private static AlloyEMFSyncer mInstance = null;

  public static AlloyEMFSyncer get() {
    if (mInstance == null)
      mInstance = new AlloyEMFSyncer();
    return mInstance;
  }

  @Override
  public void onRelationRemoved(IMarker startMarker, IMarker endMarker, String relation) {
    // TODO onRelationRemoved implementation
  }

  @Override
  public void onAtomRemoved(String sigTypeName, String relUri) {
    Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
      @Override
      public void run() {
        if (!sigTypeName.isEmpty() && !relUri.isEmpty()) {
          MessageDialog dialog = Activator.infoDialogYESNO("Caution",
              "This atom had a trace, do you want to delete corresponding ecore element?");
          if (dialog.open() == 0) {
            try {
              TraceManager.get().deleteEObject(sigTypeName, relUri);
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }
      }
    });
  }

  @Override
  public void onReasonedRelationAccepted(AlloyAtom fromAtom, AlloyAtom toAtom, String relation) {
    Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
      @Override
      public void run() {

        IMarker toMarker = Visualization.getMarker(fromAtom),
            fromMarker = Visualization.getMarker(toAtom);

        if (fromMarker != null && toMarker != null) {
          fromMarker = Visualization.getMarker(fromAtom);
          toMarker = Visualization.getMarker(toAtom);
          TraceManager.get().createReference(fromMarker, toMarker, relation);
        } else {
          if (fromMarker == null)
            fromMarker = interpretAtom(fromAtom, null);

          if (toMarker == null)
            toMarker = interpretAtom(toAtom, fromAtom);

          // Cancel it
          if (fromMarker == null || toMarker == null)
            return;
        }

        AlloyUtilities.resetReasoned(fromMarker, toMarker, relation);
        Visualization.showViz();
      }
    });
  }


  @Override
  public void onAtomAccepted(AlloyAtom alloyAtom) {
    Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
      @Override
      public void run() {
        interpretAtom(alloyAtom, null);
        Visualization.showViz();
      }
    });
  }

  public IMarker interpretAtom(AlloyAtom alloyAtom, AlloyAtom sourceAtom) {
    Object[] atomInfo = getAtomInfo(alloyAtom);
    final String sigTypeName = (String) atomInfo[0];
    int index = (int) atomInfo[1];

    IMarker marker = TraceManager.get().createMarkerForAtom(
        sourceAtom == null ? null : Visualization.getMarker(sourceAtom), alloyAtom);

    if (marker != null) {
      AlloyUtilities.addMarkerToRepository(marker);
      AlloyUtilities.bindAtomToMarker(sigTypeName, index, marker);
    }
    return marker;
  }

  /**
   * Returns given atoms info as @Object array
   * 
   * @param alloyAtom
   * @return Object array size of 2. First index: Atom type as @String, second index: Atom index
   *         as @Integer
   */
  private Object[] getAtomInfo(AlloyAtom alloyAtom) {
    final String sigTypeName = alloyAtom.getType().getName();
    final String stringIndex = alloyAtom.toString().substring(sigTypeName.length());
    int index = !stringIndex.isEmpty() ? Integer.parseInt(stringIndex) : 0;
    return new Object[] {sigTypeName, index};
  }

}
