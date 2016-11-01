package eu.modelwriter.configuration.alloy.trace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import eu.modelwriter.configuration.alloy2emf.AlloyToEMF;
import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.configuration.internal.Utilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class TraceManager {

  private static TraceManager instance = null;

  @SuppressWarnings("unused")
  private String alloyPath;

  private final List<SigTrace> sigTraces = new ArrayList<SigTrace>();
  private final List<RelationTrace> relationTraces = new ArrayList<RelationTrace>();
  private final List<LoadItem> loads = new ArrayList<LoadItem>();

  /**
   * 
   * @return @TraceManager instance
   */
  public static TraceManager get() {
    if (instance == null)
      instance = new TraceManager();
    return instance;
  }

  private TraceManager() {}

  /**
   * Loads traces from given path
   * 
   * @param alloyPath Path to load alloy file
   * @throws TraceException on any error
   */
  public void loadSpec(String alloyPath) throws TraceException {
    sigTraces.clear();
    relationTraces.clear();
    loads.clear();
    this.alloyPath = alloyPath;
    scanFile(alloyPath, true);
  }

  public boolean hasTraces() {
    return !sigTraces.isEmpty() && !relationTraces.isEmpty();
  }

  public List<LoadItem> getLoads() {
    return loads;
  }

  private void scanFile(String alloyPath, boolean scanTraces) throws TraceException {
    final Pattern sigTracePattern = Pattern.compile(
        "(\\s*)(-)(-)(\\s*)(Trace|trace)(@)((?:[a-z0-9_]+))(\\.)((?:[a-z0-9_]+))(\\s*)",
        Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    final Pattern relationTracePattern = Pattern.compile(
        "(\\s*)(-)(-)(\\s*)(Trace|trace)(@)((?:[a-z0-9_]+))(\\.)((?:[a-z0-9_]+))(\\.)((?:[a-z0-9_]+))(\\s*)",
        Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

    Scanner scanner = null;
    try {
      final File file = new File(alloyPath);
      scanner = new Scanner(file);
    } catch (final FileNotFoundException e) {
      throw new TraceException("File not found. Path: " + alloyPath);
    }

    while (scanner.hasNextLine()) {
      String line = Utilities.getNextLine(scanner);

      if (line.toLowerCase().startsWith("--loadalias")
          || line.toLowerCase().startsWith("-- loadalias")) {
        findLoads(scanner, line);
      }

      if (scanTraces) {
        final Matcher sigTrace = sigTracePattern.matcher(line);
        final Matcher relationTrace = relationTracePattern.matcher(line);

        if (relationTrace.find()) {
          findRelationTrace(scanner, line, relationTrace);
        } else if (sigTrace.find()) {
          findSigTrace(scanner, line, sigTrace);
        }
      }
    }
    scanner.close();
  }

  private void findSigTrace(Scanner scanner, String line, Matcher sigTraceMatcher)
      throws TraceException {
    String traceAlias = sigTraceMatcher.group(7);
    String className = sigTraceMatcher.group(9);
    do {
      line = Utilities.getNextLine(scanner);
    } while (!line.contains("sig "));

    if (line.contains("sig ")) {
      final int start = line.indexOf("sig ") + 4;
      int stop = line.indexOf(" ", start);
      stop = stop == -1 ? line.indexOf("{", start) : stop;
      stop = stop == -1 ? line.indexOf("\n", start) : stop;
      final String sigType = line.substring(start, stop).trim();
      LoadItem loadItem = getLoadByAlias(traceAlias);
      if (loadItem == null)
        throw new TraceException("Load traces must be above than other traces!");
      SigTrace sigTrace = new SigTrace(traceAlias, sigType, className, loadItem,
          EcoreUtilities.findEClass(loadItem.getModelRoot(), className));
      sigTraces.add(sigTrace);
    }
  }

  private void findRelationTrace(Scanner scanner, String line, Matcher relationTraceMatcher) {
    String traceAlias = relationTraceMatcher.group(7);
    String traceClass = relationTraceMatcher.group(9);
    String traceReference = relationTraceMatcher.group(11);

    do {
      line = Utilities.getNextLine(scanner);
    } while (!line.contains(":"));

    if (line.contains(":")) {
      final String[] strings = line.split(" ");
      final String relation = strings[0].replaceAll(":", "").trim();
      @SuppressWarnings("unused")
      final String targetSig =
          strings[strings.length - 1].replaceAll(",", "").replaceAll("}", "").trim();
      RelationTrace relationTrace =
          new RelationTrace(traceAlias, traceClass, relation, traceReference);
      // source and target sigs are null for now
      // getSigTraceByClassName(traceClass), getSigTraceByName(targetSig));
      relationTraces.add(relationTrace);
    }
  }

  private void findLoads(Scanner scanner, String line) throws TraceException {
    String alias = "", modelFilePath = "", instanceFilePath = "";
    alias = line.substring(line.indexOf("@") + 1).trim();
    for (int i = 0; i < 2; i++) {
      String nextLine = Utilities.getNextLine(scanner);
      if (nextLine.toLowerCase().contains("loadmodel@")) {
        modelFilePath = nextLine.substring(nextLine.indexOf("@") + 1);
      } else if (nextLine.toLowerCase().contains("loadinstance@")) {
        instanceFilePath = nextLine.substring(nextLine.indexOf("@") + 1);
      }
    }
    if (!alias.isEmpty() /* && !modelFilePath.isEmpty() && !instanceFilePath.isEmpty() */) {
      loads.add(new LoadItem(alias, modelFilePath, instanceFilePath));
    } else {
      throw new TraceException("Can't load EMF models!");
    }
  }

  public SigTrace getSigTraceByType(String type) {
    return sigTraces.stream().filter(sigTrace -> sigTrace.getSigType().equals(type)).findFirst()
        .orElse(null);
  }

  public SigTrace getSigTraceByClassName(String name) {
    return sigTraces.stream().filter(sigTrace -> sigTrace.getClassName().equals(name)).findFirst()
        .orElse(null);
  }

  public RelationTrace getRelationTraceByReferenceName(String reference) {
    return relationTraces.stream().filter(rt -> rt.getReferenceName().equals(reference)).findFirst()
        .orElse(null);
  }

  public RelationTrace getRelationTrace(String className, String refName) {
    return relationTraces.stream()
        .filter(
            rt -> (rt.getClassName().equals(className) && rt.getReferenceName().equals(refName)))
        .findFirst().orElse(null);
  }

  public RelationTrace getRelationTrace2(String className, String relName) {
    return relationTraces.stream()
        .filter(rt -> (rt.getClassName().equals(className) && rt.getRelationName().equals(relName)))
        .findFirst().orElse(null);
  }

  public RelationTrace getRelationTraceByRelationName(String rel) {
    return relationTraces.stream().filter(rt -> rt.getRelationName().equals(rel)).findFirst()
        .orElse(null);
  }

  public LoadItem getLoadByAlias(String alias) {
    return loads.stream().filter(load -> load.getAlias().equals(alias)).findFirst().orElse(null);
  }

  public LoadItem getLoadByInstance(EObject instance) {
    return loads.stream().filter(load -> load.getInstanceRoot().equals(instance)).findFirst()
        .orElse(null);
  }

  public boolean deleteEObject(String sigType, String relativeObjectURI) throws IOException {
    EObject eObject = findEObject(sigType, relativeObjectURI);
    if (eObject != null) {
      Resource eResource = eObject.eResource();
      EcoreUtil.delete(eObject);
      eResource.save(null);
      return true;
    }
    return false;
  }

  private EObject findEObject(String sigTypeName, String relativeObjectURI) {
    if (relativeObjectURI != null && sigTypeName != null) {
      SigTrace trace = getSigTraceByType(sigTypeName);
      if (trace == null)
        return null;
      return EcoreUtil.getEObject(trace.getLoad().getInstanceRoot(), relativeObjectURI);
    }
    return null;
  }

  public EObject findEObject(IMarker marker) {
    if (marker == null)
      return null;
    // String uri = marker.getAttribute(MarkUtilities.URI, "");
    String relURI = marker.getAttribute(MarkUtilities.RELATIVE_URI, "");
    String sigTypeName = marker.getAttribute(MarkUtilities.MARKER_TYPE, "");
    return findEObject(sigTypeName, relURI);
  }

  private EObject findEObject(String uri) {
    String rootURI = uri.split("#")[0];
    String relURI = uri.split("#")[1];
    EObject root = findInstanceRootByURI(rootURI);

    return EcoreUtil.getEObject(root, relURI);
  }

  private EObject findInstanceRootByURI(String rootURI) {
    for (LoadItem loadItem : loads) {
      if (loadItem.getInstanceRoot().eResource().getURI().toString().equals(rootURI)) {
        return loadItem.getInstanceRoot();
      }
    }
    return null;
  }

  /**
   * Creates a @EObject for given atom, and marks it. Returns the marker.
   * 
   * @param sourceMarker
   * @param toAtom
   * @param relation
   * @return IMarker for @param toAtom
   */
  public IMarker createMarkerForAtom(IMarker sourceMarker, AlloyAtom toAtom){
    EObject source = sourceMarker == null ? null : findEObject(sourceMarker);
    SigTrace trace = getSigTraceByType(toAtom.getType().getName());
    if (trace == null)
      return null;

    EClass eClass = trace.getEClass();
    EObject eObject = EcoreUtil.create(eClass);
    EcoreUtilities.eSetAttributeByName(eObject, "name", toAtom.getOriginalName());
    AlloyToEMF.putIntoContainer(source == null ? trace.getLoad().getInstanceRoot() : source,
        eObject);
    EcoreUtilities.saveResource(trace.getLoad().getInstanceRoot());

    return MarkerFactory.createInstanceMarker(eObject, trace.getLoad().getInstanceFile(),
        trace.getSigType());
  }

  public void createReference(EObject source, EObject target, String relationName) {
    if (source == null || target == null)
      return;

    RelationTrace relationTrace = getRelationTrace2(source.eClass().getName(), relationName);
    if (relationTrace == null)
      return;
    // EObject _target = EcoreUtil.getEObject(EcoreUtil.getRootContainer(source),
    // EcoreUtil.getRelativeURIFragmentPath(target.eContainer(), target));
    EcoreUtilities.eSetReferenceByName(source, relationTrace.getReferenceName(), target);
  }

  public void createReference(IMarker fromMarker, IMarker toMarker, String relationName) {
    EObject source = findEObject(fromMarker);
    EObject target = findEObject(toMarker);
    createReference(source, target, relationName);
  }
}
