package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.dialogs.MessageDialog;

import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.alloy.trace.TraceManager;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;

public class TraceObserver implements VisualizationChangeListener {

  private static TraceObserver mInstance = null;

  public static TraceObserver get() {
    if (mInstance == null)
      mInstance = new TraceObserver();
    return mInstance;
  }

  @Override
  public void onRelationRemoved(IMarker startMarker, IMarker endMarker, String relation) {
    // TODO onRelationRemoved implementation
  }

  @Override
  public void onAtomRemoved(String sigTypeName, String relUri) {
    if (!checkTraces()) {
      return;
    }

    Activator.getDefault().getWorkbench().getDisplay().syncExec(new Runnable() {
      @Override
      public void run() {
        if (!sigTypeName.isEmpty() && !relUri.isEmpty()) {
          MessageDialog dialog = Activator.infoDialogYESNO("Caution",
              "This atom had a trace, do you want to delete corresponding ecore element?");
          if (dialog.open() == 0) {
            try {
              TraceManager.get().deleteEObject(sigTypeName, relUri);
            } catch (IOException | TraceException e) {
              e.printStackTrace();
            }
          }
        }
      }
    });
  }

  @Override
  public void onAllReasonedAccepted() {
    if (!checkTraces()) {
      return;
    }

    Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
      @Override
      public void run() {
        for (String atomName : AlloyUtilities.getAllReasonedAtoms()) {
          try {
            interpretAtom(atomName, true);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
        Visualization.showViz();
      }
    });
  }

  @Override
  public void onReasonedRelationAccepted(AlloyAtom fromAtom, AlloyAtom toAtom, String relation) {
    if (!checkTraces()) {
      return;
    }

    Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
      @Override
      public void run() {
        try {

          IMarker fromMarker = Visualization.getMarker(fromAtom);
          IMarker toMarker = Visualization.getMarker(toAtom);

          if (fromMarker != null && toMarker != null) {
            createRelation(fromMarker, toMarker, relation);
            Visualization.showViz();
          } else {
            if (fromMarker == null)
              fromMarker = interpretAtom(fromAtom.getOriginalName(), false);
            if (toMarker == null)
              toMarker = interpretAtom(toAtom.getOriginalName(), false);
            // Cancel it
            if (fromMarker == null || toMarker == null)
              return;
            createRelation(fromMarker, toMarker, relation);
            Visualization.showViz();
          }
        } catch (TraceException e) {
          Activator.errorDialogOK("Error", e.getMessage());
        }
      }
    });
  }

  protected boolean checkTraces() {
    if (!TraceManager.get().hasTraces()) {
      try {
        TraceManager.get().loadSpec(MarkerPage.settings.get("alloyFile"));
      } catch (TraceException e) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void onAtomAccepted(AlloyAtom alloyAtom) {
    if (!checkTraces()) {
      return;
    }

    Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
      @Override
      public void run() {
        try {
          interpretAtom(alloyAtom.getOriginalName(), true);
          Visualization.showViz();
        } catch (TraceException e) {
          Activator.errorDialogOK("Error", e.getMessage());
        }
      }
    });
  }

  public IMarker interpretAtom(String atomName, boolean createRelations) throws TraceException {
    String sigTypeName = atomName;
    int index = 0;
    if (atomName.contains("$")) {
      sigTypeName = atomName.substring(0, atomName.indexOf("$"));
      index = Integer.parseInt(atomName.substring(sigTypeName.length() + 1));
    }

    IMarker sourceMarker = null;
    IMarker marker = null;
    String containmentRelation = null;
    Map<Object, String> firstSides =
        AlloyUtilities.getReasonedRelationsOfSSAtom(sigTypeName, index);

    if (firstSides.isEmpty())
      sourceMarker = null;
    else {
      Object parent = findContainer(sigTypeName, firstSides);
      containmentRelation = firstSides.get(parent);
      if (parent instanceof String) {
        // Need to interpret the parent
        firstSides.remove(parent);
        interpretAtom((String) parent, true);
      } else if (parent instanceof IMarker) {
        sourceMarker = (IMarker) parent;
        firstSides.remove(parent);
      } else {
        sourceMarker = null;
      }
    }
    marker = TraceManager.get().createMarkerForAtom(sigTypeName, atomName, sourceMarker);
    if (marker != null) {
      AlloyUtilities.addMarkerToRepository(marker);
      AlloyUtilities.bindAtomToMarker(sigTypeName, index, marker);

      Map<Object, String> secondSides =
          AlloyUtilities.getReasonedRelationsOfFSAtom(sigTypeName, index);
      if (createRelations && (!secondSides.isEmpty() || !firstSides.isEmpty())) {
        // TODO: Ask if user wants to create relations
        createRelations(firstSides, marker);
        createRelations(marker, secondSides);
      } else if (containmentRelation != null && sourceMarker != null) {
        // FIXME
        AlloyUtilities.resetReasoned(sourceMarker, marker, containmentRelation);
        // sourceMarker = AnnotationFactory.convertAnnotationType(sourceMarker, false, false,
        // AlloyUtilities.getTotalTargetCount(sourceMarker));
      }
    }
    return marker;
  }

  private void createRelations(Map<Object, String> firstSides, IMarker marker)
      throws TraceException {
    for (Entry<Object, String> entry : firstSides.entrySet()) {
      if (entry.getKey() instanceof IMarker) {
        createRelation((IMarker) entry.getKey(), marker, entry.getValue());
      } else {
        // Atom has no marker, need to create one
        interpretAtom((String) entry.getKey(), true);
      }
    }
  }

  private void createRelations(IMarker marker, Map<Object, String> secondSides)
      throws TraceException {
    for (Entry<Object, String> entry : secondSides.entrySet()) {
      if (entry.getKey() instanceof IMarker) {
        marker = createRelation(marker, (IMarker) entry.getKey(), entry.getValue());
      } else {
        // Atom has no marker, need to create one
        interpretAtom((String) entry.getKey(), true);
      }
    }
  }

  private IMarker createRelation(IMarker fromMarker, IMarker toMarker, String relationName)
      throws TraceException {
    fromMarker = TraceManager.get().createReference(fromMarker, toMarker, relationName);
    AlloyUtilities.resetReasoned(fromMarker, toMarker, relationName);
    return fromMarker;
  }

  private Object findContainer(String sigTypeName, Map<Object, String> firstSides)
      throws TraceException {
    String containerSigType = TraceManager.get().getContainerSigType(sigTypeName);
    for (Object object : firstSides.keySet()) {
      if (object instanceof IMarker) {
        IMarker iMarker = (IMarker) object;
        String markerType = iMarker.getAttribute(MarkUtilities.MARKER_TYPE, "");
        if (markerType.equals(containerSigType))
          return iMarker;
      } else if (object instanceof String && ((String) object).contains(containerSigType)) {
        return object;
      }
    }
    return null;
  }
}
