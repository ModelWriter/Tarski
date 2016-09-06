package eu.modelwriter.configuration.synthesis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import eu.modelwriter.configuration.alloy.trace.LoadItem;
import eu.modelwriter.configuration.alloy.trace.SigTrace;
import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.alloy.trace.TraceRepo;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkerFactory;

public class AutomatedTraceCreator {

  private final HashMap<EObject, IMarker> eObject2Marker = new HashMap<>();

  public AutomatedTraceCreator() {}

  public void automate() throws TraceException {
    final List<EObject> allEObjects = new ArrayList<>();
    for (LoadItem load : TraceRepo.get().getLoads()) {
      if (load.getInstanceRoot() == null) {
        throw new TraceException("There is no loaded instance for alias: " + load.getAlias());
      }
      findAllEObjects(allEObjects, load.getInstanceRoot());
      allEObjects.remove(load.getInstanceRoot());
    }
    createMarkers(allEObjects);
    createRelations();
  }

  private void findAllEObjects(List<EObject> allEObjects, EObject root) {
    allEObjects.add(root);
    for (EObject object : root.eContents()) {
      findAllEObjects(allEObjects, object);
    }
  }

  private void createMarkers(List<EObject> allEObjects) throws TraceException {
    for (EObject eObject : allEObjects) {
      final String className = eObject.eClass().getName();
      final SigTrace sigTrace = TraceRepo.get().getSigTraceByClassName(className);
      if (sigTrace != null) {
        LoadItem load = TraceRepo.get().getLoadByAlias(sigTrace.getAlias());
        IMarker marker = createMarker(eObject, load.getInstanceFile(), sigTrace.getSigName());
        if (marker != null) {
          eObject2Marker.put(eObject, marker);
        }
      } else {
        throw new TraceException("There is no sig trace for EClass " + className);
      }
    }
  }

  private IMarker createMarker(EObject eObject, IFile iFile, String sigName) {
    final IMarker marker = MarkerFactory.createInstanceMarker(eObject, iFile, sigName);
    if (marker == null) {
      return null;
    }
    AlloyUtilities.addTypeToMarker(marker);
    AlloyUtilities.addMarkerToRepository(marker);
    return marker;
  }

  @SuppressWarnings({"unchecked"})
  private void createRelations() {
    for (EObject sourceObject : eObject2Marker.keySet()) {
      final IMarker sourceMarker = eObject2Marker.get(sourceObject);
      for (EReference eReference2 : sourceObject.eClass().getEAllReferences()) {
        if (eReference2.isMany()) {
          List<EObject> refs = (List<EObject>) sourceObject.eGet(eReference2);
          for (EObject ref : refs) {
            IMarker targetMarker = eObject2Marker.get(ref);
            if (sourceMarker != null && targetMarker != null && !eReference2.isVolatile())
              AlloyUtilities.addRelation2Markers(sourceMarker, targetMarker, TraceRepo.get()
                  .getRelationTraceByReferenceName(eReference2.getName()).getRelationName());
          }
        } else {
          EObject ref = (EObject) sourceObject.eGet(eReference2);
          IMarker targetMarker = eObject2Marker.get(ref);
          if (sourceMarker != null && targetMarker != null && !eReference2.isVolatile())
            AlloyUtilities.addRelation2Markers(sourceMarker, targetMarker, TraceRepo.get()
                .getRelationTraceByReferenceName(eReference2.getName()).getRelationName());
        }
      }
      if (sourceMarker != null) {
        IMarker newSourceMarker = AnnotationFactory.convertAnnotationType(sourceMarker, false,
            false, AlloyUtilities.getTotalTargetCount(sourceMarker));
        eObject2Marker.put(sourceObject, newSourceMarker);
      }

    }
  }

}
