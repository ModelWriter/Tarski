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

  public void setEnabled(boolean isEnabled) {
    if (isEnabled) {
      VisualizationActionListenerFactory.get().registerListener(this);
    } else {
      VisualizationActionListenerFactory.get().unregisterListener(this);
    }
  }

  @Override
  public void onRelationRemoved(IMarker startMarker, IMarker endMarker, String relation) {
    // TODO onRelationRemoved implementation
  }

  @Override
  public void onAtomRemoved(IMarker marker) {
    Activator.getDefault().getWorkbench().getDisplay().syncExec(new Runnable() {
      @Override
      public void run() {
        MessageDialog dialog = Activator.infoDialogYESNO("Caution",
            "This atom had a trace, do you want to delete corresponding ecore element?");
        if (dialog.open() == 0) {
          try {
            TraceManager.get().deleteEObjectByMarker(marker);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    });
  }

  @Override
  public void onReasonedRelationAccepted(IMarker fromMarker, IMarker toMarker, String relation) {
    // TODO onReasonedRelationAccepted implementation
  }


  @Override
  public void onAtomAccepted(AlloyAtom alloyAtom) {
    Activator.getDefault().getWorkbench().getDisplay().syncExec(new Runnable() {
      @Override
      public void run() {
        final String sigTypeName = alloyAtom.getType().getName();
        final String stringIndex = alloyAtom.toString().substring(sigTypeName.length());
        int index = 0;
        if (!stringIndex.isEmpty()) {
          index = Integer.parseInt(stringIndex);
        }
        IMarker newMarker =
            TraceManager.get().createTraceMarker(sigTypeName, alloyAtom.getOriginalName());
        if (newMarker != null) {
          AlloyUtilities.bindAtomToMarker(sigTypeName, index, newMarker);
          Visualization.showViz();
        }
      }
    });
  }

  @Override
  public void onAtomRemoved(AlloyAtom atom) {
    Activator.getDefault().getWorkbench().getDisplay().syncExec(new Runnable() {
      @Override
      public void run() {
        MessageDialog dialog = Activator.infoDialogYESNO("Caution",
            "This atom had a trace, do you want to delete corresponding ecore element?");
        if (dialog.open() == 0)
          TraceManager.get().deleteEObjectByName(atom.getOriginalName());
      }
    });
  }

  @Override
  public void onReasonedRelationAccepted(AlloyAtom fromAtom, AlloyAtom toAtom, String relation) {
    TraceManager.get().createRelation(fromAtom, toAtom, relation);
  }

}
