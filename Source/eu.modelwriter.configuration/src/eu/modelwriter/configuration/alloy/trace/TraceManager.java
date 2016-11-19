package eu.modelwriter.configuration.alloy.trace;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class TraceManager {

  private TraceRepo repo;

  TraceManager(TraceRepo repo) {
    this.repo = repo;
  }

  public boolean deleteEObject(String sigType, String relativeObjectURI)
      throws IOException, TraceException {
    EObject eObject = findEObject(sigType, relativeObjectURI);
    if (eObject != null) {
      Resource eResource = eObject.eResource();
      EcoreUtil.delete(eObject);
      eResource.save(null);
      return true;
    }
    return false;
  }

  private EObject findEObject(String sigTypeName, String relativeObjectURI) throws TraceException {
    if (relativeObjectURI != null && sigTypeName != null) {
      SigTrace trace = repo.getSigTraceByType(sigTypeName);
      return EcoreUtil.getEObject(trace.getLoad().getInstanceRoot(), relativeObjectURI);
    }
    return null;
  }

  public EObject findEObject(IMarker marker) throws TraceException {
    if (marker == null)
      return null;
    String relURI = marker.getAttribute(MarkUtilities.RELATIVE_URI, "");
    String sigTypeName = marker.getAttribute(MarkUtilities.MARKER_TYPE, "");
    return findEObject(sigTypeName, relURI);
  }

  @SuppressWarnings("unused")
  private EObject findEObject(String uri) {
    String rootURI = uri.split("#")[0];
    String relURI = uri.split("#")[1];
    EObject root = findInstanceRootByURI(rootURI);

    return EcoreUtil.getEObject(root, relURI);
  }

  private EObject findInstanceRootByURI(String rootURI) {
    for (LoadItem loadItem : repo.getLoads()) {
      if (loadItem.getInstanceRoot().eResource().getURI().toString().equals(rootURI)) {
        return loadItem.getInstanceRoot();
      }
    }
    return null;
  }

  public EObject createEObject(String sigTypeName, String atomName, IMarker source)
      throws TraceException {
    SigTrace trace = repo.getSigTraceByType(sigTypeName);
    EClass eClass = trace.getEClass();
    EObject eObject = EcoreUtil.create(eClass);
    EcoreUtilities.eSetAttributeByName(eObject, "name", atomName);
    EcoreUtilities.putIntoContainer(
        source == null ? trace.getLoad().getInstanceRoot() : findEObject(source), eObject);
    EcoreUtilities.saveResource(trace.getLoad().getInstanceRoot());
    return eObject;
  }

  public IMarker createMarkerForEObject(EObject eObject) throws TraceException {
    SigTrace trace = repo.getSigTraceByClassName(eObject.eClass().getName());
    return MarkerFactory.createInstanceMarker(eObject, trace.getLoad().getInstanceFile(),
        trace.getSigType());
  }

  public Set<String> getContainerSigTypes(String sigTypeName) {
    try {
      SigTrace trace = repo.getSigTraceByType(sigTypeName);
      return findContainers(trace.getLoad().getAllEClasses().values(), sigTypeName);
    } catch (TraceException e) {
      return new HashSet<String>();
    }
  }

  public String getContainmentRelation(IMarker fromMarker, IMarker toMarker) throws TraceException {
    EObject source = findEObject(fromMarker);
    EObject target = findEObject(toMarker);
    EReference eReference = EcoreUtilities.getContainmentEReference(source, target);
    if (eReference != null)
      return repo
          .getRelationTrace(((EClass) eReference.eContainer()).getName(), eReference.getName())
          .getRelationName();
    return null;
  }

  public void createReference(IMarker fromMarker, IMarker toMarker, String relationName)
      throws TraceException {
    EObject source = findEObject(fromMarker);
    EObject target = findEObject(toMarker);
    EReference ref = null;
    for (EReference eReference : source.eClass().getEAllReferences()) {
      RelationTrace relationTrace =
          repo.getRelationTrace(((EClass) eReference.eContainer()).getName(), eReference.getName());
      if (relationTrace != null && relationTrace.getRelationName().equals(relationName)) {
        ref = eReference;
        break;
      }
    }
    if (ref != null) {
      EcoreUtilities.eSetReferenceByName(source, ref.getName(), target);
      EcoreUtilities.saveResource(source);
    }
  }

  public Set<String> findContainers(Collection<EClass> collection, String selectedType) {
    Set<String> result = new HashSet<String>();
    SigTrace typeTrace;
    try {
      typeTrace = repo.getSigTraceByType(selectedType);
    } catch (TraceException e1) {
      return result;
    }
    EList<EClass> superTypes = typeTrace.getEClass().getEAllSuperTypes();
    for (EClass eClass : collection) {
      for (EReference eReference : eClass.getEAllReferences()) {
        if (eReference.isContainment()) {
          try {
            if (superTypes.stream()
                .anyMatch(s -> s.getName().equals(eReference.getEReferenceType().getName()))) {
              result.add(repo.getSigTraceByClassName(eClass.getName()).getSigType());
            }
          } catch (TraceException e) {
            // no need to handle
          }
        }
      }
    }
    return result;
  }
}
