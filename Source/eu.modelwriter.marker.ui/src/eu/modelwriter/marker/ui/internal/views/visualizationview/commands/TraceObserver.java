package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;

import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.alloy.trace.TraceManager;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;
import eu.modelwriter.traceability.core.persistence.TupleType;

public class TraceObserver implements VisualizationChangeListener {

  private static TraceObserver mInstance = null;

  public static TraceObserver get() {
    if (TraceObserver.mInstance == null) {
      TraceObserver.mInstance = new TraceObserver();
    }
    return TraceObserver.mInstance;
  }

  @Override
  public void onRelationRemoved(final IMarker startMarker, final IMarker endMarker,
      final String relation) {
    // TODO onRelationRemoved implementation
  }

  @Override
  public void onAtomRemoved(final String sigTypeName, final String relUri) {
    if (!checkTraces()) {
      return;
    }

    Activator.getDefault().getWorkbench().getDisplay().syncExec(new Runnable() {
      @Override
      public void run() {
        if (!sigTypeName.isEmpty() && !relUri.isEmpty()) {
          final MessageDialog dialog = Activator.infoDialogYESNO("Caution",
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
        for (final String atomName : AlloyUtilities.getAllReasonedAtoms()) {
          try {
            interpretAtom(atomName, true);
          } catch (final Exception e) {
            e.printStackTrace();
          }
        }
        for (final Entry<TupleType, String> entry : AlloyUtilities.getAllReasonedTuples()
            .entrySet()) {
          final TupleType tuple = entry.getKey();
          if (!tuple.getAtom().get(0).isReasoned() && !tuple.getAtom().get(1).isReasoned()) {
            final IMarker fromMarker =
                AlloyUtilities.findMarkerByID(tuple.getAtom().get(0).getLabel());
            final IMarker toMarker =
                AlloyUtilities.findMarkerByID(tuple.getAtom().get(1).getLabel());
            try {
              createRelation(fromMarker, toMarker, entry.getValue());
            } catch (final TraceException e) {
              e.printStackTrace();
            }
          }
        }
        Visualization.showViz();
      }
    });
  }

  @Override
  public void onReasonedRelationAccepted(final AlloyAtom fromAtom, final AlloyAtom toAtom,
      final String relation) {
    Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
      @Override
      public void run() {
        try {
          TraceManager.get().reload();

          IMarker fromMarker = Visualization.getMarker(fromAtom);
          IMarker toMarker = Visualization.getMarker(toAtom);

          if (fromMarker != null && toMarker != null) {
            createRelation(fromMarker, toMarker, relation);
            Visualization.showViz();
          } else {
            if (fromMarker == null) {
              fromMarker = interpretAtom(fromAtom.getOriginalName(), false);
            }
            if (toMarker == null) {
              toMarker = interpretAtom(toAtom.getOriginalName(), false);
            }
            // Cancel it
            if (fromMarker == null || toMarker == null) {
              return;
            }
            createRelation(fromMarker, toMarker, relation);
          }
        } catch (final TraceException e) {
          Activator.errorDialogOK("Error", e.getMessage());
        } finally {
          Visualization.showViz();
        }
      }
    });
  }

  protected boolean checkTraces() {
    if (!TraceManager.get().hasTraces()) {
      try {
        TraceManager.get().loadSpec(MarkerPage.settings.get("alloyFile"));
      } catch (final TraceException e) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void onAtomAccepted(final AlloyAtom alloyAtom) {
    if (!checkTraces()) {
      return;
    }

    Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
      @Override
      public void run() {
        try {
          interpretAtom(alloyAtom.getOriginalName(), true);
        } catch (final TraceException e) {
          Activator.errorDialogOK("Error", e.getMessage());
        } finally {
          Visualization.showViz();
        }
      }
    });
  }

  public IMarker interpretAtom(final String atomName, final boolean createRelations)
      throws TraceException {
    String sigTypeName = atomName;
    int index = 0;
    if (atomName.contains("$")) {
      sigTypeName = atomName.substring(0, atomName.indexOf("$"));
      index = Integer.parseInt(atomName.substring(sigTypeName.length() + 1));
    }

    String containmentRelation = null;
    IMarker sourceMarker = null;
    IMarker marker = null;

    marker = AlloyUtilities.findMarkerByID(AlloyUtilities.getAtomId(sigTypeName, index));
    if (marker != null)
      return marker;

    final Map<Object, String> firstSides =
        AlloyUtilities.getReasonedRelationsOfSSAtom(sigTypeName, index);

    if (firstSides.isEmpty()) {
      sourceMarker = null;
    } else {
      final Object parent = findContainer(sigTypeName, firstSides);
      containmentRelation = firstSides.get(parent);
      if (parent instanceof String) {
        // Need to interpret the parent
        firstSides.remove(parent);
        sourceMarker = interpretAtom((String) parent, true);
      } else if (parent instanceof IMarker) {
        firstSides.remove(parent);
        sourceMarker = (IMarker) parent;
      } else {
        sourceMarker = null;
      }
    }
    EObject eObject = TraceManager.get().createEObject(sigTypeName, atomName, sourceMarker);
    marker = TraceManager.get().createMarkerForEObject(eObject);
    if (marker != null) {
      AlloyUtilities.addMarkerToRepository(marker);
      AlloyUtilities.bindAtomToMarker(sigTypeName, index, marker);
      if (containmentRelation != null && sourceMarker != null) {
        AlloyUtilities.resetReasoned(sourceMarker, marker, containmentRelation);
        AnnotationFactory.convertAnnotationType(sourceMarker, false, false,
            AlloyUtilities.getTotalTargetCount(sourceMarker));
      }

      final Map<Object, String> secondSides =
          AlloyUtilities.getReasonedRelationsOfFSAtom(sigTypeName, index);
      if (createRelations && (!secondSides.isEmpty() || !firstSides.isEmpty())) {
        MessageDialog dialog = Activator.infoDialogYESNO("Warning",
            "Do you want to accept relations of " + atomName + " ?");
        if (dialog.open() == 0) {
          createRelations(marker, secondSides);
          createRelations(firstSides, marker);
          AnnotationFactory.convertAnnotationType(marker, false, false,
              AlloyUtilities.getTotalTargetCount(marker));
        }
      }
    } else {
      // No marker no EObject
      EObject container = eObject.eContainer();
      EcoreUtil.delete(eObject);
      EcoreUtilities.saveResource(container);
    }
    return marker;
  }

  private void createRelations(final Map<Object, String> firstSides, final IMarker marker)
      throws TraceException {
    for (final Entry<Object, String> entry : firstSides.entrySet()) {
      if (entry.getKey() instanceof IMarker) {
        createRelation((IMarker) entry.getKey(), marker, entry.getValue());
      } else {
        // Atom has no marker, need to create one
        interpretAtom((String) entry.getKey(), true);
      }
    }
  }

  private void createRelations(IMarker marker, final Map<Object, String> secondSides)
      throws TraceException {
    for (final Entry<Object, String> entry : secondSides.entrySet()) {
      if (entry.getKey() instanceof IMarker) {
        createRelation(marker, (IMarker) entry.getKey(), entry.getValue());
      } else {
        // Atom has no marker, need to create one
        interpretAtom((String) entry.getKey(), true);
      }
    }
  }

  private void createRelation(IMarker fromMarker, final IMarker toMarker, final String relationName)
      throws TraceException {
    TraceManager.get().createReference(fromMarker, toMarker, relationName);
    AlloyUtilities.resetReasoned(fromMarker, toMarker, relationName);
  }

  private Object findContainer(final String sigTypeName, final Map<Object, String> firstSides)
      throws TraceException {
    Set<String> containers = TraceManager.get().getContainerSigTypes(sigTypeName);
    for (Object object : firstSides.keySet()) {
      if (object instanceof IMarker) {
        IMarker iMarker = (IMarker) object;
        String markerType = iMarker.getAttribute(MarkUtilities.MARKER_TYPE, "");
        if (containers.contains(markerType))
          return iMarker;
      } else if (object instanceof String) {
        String atomName = (String) object;
        String type =
            atomName.contains("$") ? atomName.substring(0, atomName.indexOf("$")) : atomName;
        if (containers.contains(type))
          return type;
      }
    }
    return null;
  }
}
