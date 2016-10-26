package eu.modelwriter.configuration.alloy.trace;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.modelwriter.configuration.alloy2emf.AlloyToEMF;
import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.configuration.synthesis.AutomatedTraceCreator;

public class TraceManager {

  private static TraceManager instance = null;

  @SuppressWarnings("unused")
  private String alloyPath;

  private final List<SigTrace> sigTraces = new ArrayList<SigTrace>();
  private final List<RelationTrace> relationTraces = new ArrayList<RelationTrace>();
  private final List<LoadItem> loads = new ArrayList<LoadItem>();
  private HashMap<EObject, IMarker> eObject2Marker = null;

  /**
   * 
   * @return TraceRepo instance
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
    updateSpec(alloyPath);
  }

  /**
   * Updates traces from given path
   * 
   * @param alloyPath Path to load alloy file
   * @throws TraceException
   */
  public void updateSpec(String alloyPath) throws TraceException {
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
      String line = LoadTraceUtils.getNextLine(scanner);

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

  private void findSigTrace(Scanner scanner, String line, Matcher sigTraceMatcher) {
    String traceAlias = sigTraceMatcher.group(7);
    String traceType = sigTraceMatcher.group(9);
    do {
      line = LoadTraceUtils.getNextLine(scanner);
    } while (!line.contains("sig "));

    if (line.contains("sig ")) {
      final int start = line.indexOf("sig ") + 4;
      int stop = line.indexOf(" ", start);
      stop = stop == -1 ? line.indexOf("{", start) : stop;
      stop = stop == -1 ? line.indexOf("\n", start) : stop;
      final String sig = line.substring(start, stop).trim();
      SigTrace sigTrace = new SigTrace(traceAlias, sig, traceType);
      sigTraces.add(sigTrace);
    }
  }

  @SuppressWarnings("unused")
  private void findRelationTrace(Scanner scanner, String line, Matcher relationTraceMatcher) {
    String traceAlias = relationTraceMatcher.group(7);
    String traceClass = relationTraceMatcher.group(9);
    String traceReference = relationTraceMatcher.group(11);

    do {
      line = LoadTraceUtils.getNextLine(scanner);
    } while (!line.contains(":"));

    if (line.contains(":")) {
      final String[] strings = line.split(" ");
      final String relation = strings[0].replaceAll(":", "").trim();
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
      String nextLine = LoadTraceUtils.getNextLine(scanner);
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

  public SigTrace getSigTraceByName(String name) {
    return sigTraces.stream().filter(sigTrace -> sigTrace.getSigName().equals(name)).findFirst()
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

  public void setMarkerTraces(HashMap<EObject, IMarker> eObject2Marker) {
    this.eObject2Marker = eObject2Marker;
  }

  public boolean hasMarkerTrace() {
    return eObject2Marker != null && !eObject2Marker.isEmpty();
  }

  public boolean deleteEObjectByMarker(IMarker marker) {
    for (Entry<EObject, IMarker> entry : eObject2Marker.entrySet()) {
      if (entry.getValue().equals(marker)) {
        EObject beDeleted = entry.getKey();
        EObject root = EcoreUtil.getRootContainer(beDeleted);
        if (root != null) {
          eObject2Marker.remove(beDeleted);
          EcoreUtil.delete(beDeleted);
          EcoreUtilities.saveResource(root);
          return true;
        }
      }
    }
    return false;
  }

  public IMarker createTraceMarker(String sigType, String sigName) {
    SigTrace sigTrace = getSigTraceByName(sigType);
    EObject instanceRoot = getLoadByAlias(sigTrace.getAlias()).getInstanceRoot();
    EObject modelRoot = getLoadByAlias(sigTrace.getAlias()).getModelRoot();
    EClass eClass = EcoreUtilities.findEClass(modelRoot, sigTrace.getClassName());
    EObject eObject = eClass.getEPackage().getEFactoryInstance().create(eClass);
    EcoreUtilities.eSetAttributeByName(eObject, "name", sigName);
    AlloyToEMF.putIntoContainer(instanceRoot, eObject);
    IFile instanceFile = getLoadByAlias(sigTrace.getAlias()).getInstanceFile();
    EcoreUtilities.saveResource(instanceRoot);
    IMarker marker = AutomatedTraceCreator.createMarker(eObject, instanceFile, sigType);
    if (marker != null)
      eObject2Marker.put(eObject, marker);
    return marker;
  }

  public boolean deleteEObjectByName(String originalName) {
    for (LoadItem loadItem : loads) {
      for (EObject eObject : loadItem.getInstanceRoot().eContents()) {
        if (eObject instanceof ENamedElement
            && ((ENamedElement) eObject).getName().equals(originalName)) {
          EObject root = EcoreUtil.getRootContainer(eObject);
          if (root != null) {
            EcoreUtil.delete(eObject);
            EcoreUtilities.saveResource(root);
            return true;
          }
        }
      }
    }
    return false;
  }
}
