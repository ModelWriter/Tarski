package eu.modelwriter.configuration.alloy.trace;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;

import org.eclipse.emf.ecore.EObject;

import eu.modelwriter.configuration.internal.Patterns;
import eu.modelwriter.configuration.internal.Utilities;

public class TraceRepo {

  /**
   * Path of loaded alloy
   */
  private String alloyPath;

  // Trace Lists
  private List<SigTrace> sigTraces;
  private List<RelationTrace> relationTraces;
  private List<LoadItem> loads;

  TraceRepo() {
    sigTraces = new ArrayList<>();
    relationTraces = new ArrayList<>();
    loads = new ArrayList<>();
  }

  public String getAlloyPath() {
    return alloyPath;
  }

  public List<SigTrace> getSigTraces() {
    return sigTraces;
  }

  public List<RelationTrace> getRelationTraces() {
    return relationTraces;
  }

  public List<LoadItem> getLoads() {
    return loads;
  }

  public void clear() {
    loads.clear();
    sigTraces.clear();
    relationTraces.clear();
  }

  /**
   * Loads traces from given path
   * 
   * @param alloyPath Path to load alloy file
   * @throws TraceException on any error
   */
  public void load(String alloyPath) throws TraceException {
    this.alloyPath = alloyPath;
    clear();
    scanFile(alloyPath);
  }

  public void reload() throws TraceException {
    if (!getAlloyPath().isEmpty())
      load(getAlloyPath());
    else
      throw new TraceException("Alloy file is not set!");
  }

  public boolean hasTraces() {
    return !getSigTraces().isEmpty() && !getRelationTraces().isEmpty();
  }

  public boolean hasInstance() {
    for (LoadItem loadItem : getLoads()) {
      if (loadItem.getInstanceRoot() != null)
        return true;
    }
    return false;
  }

  public boolean hasSigTrace(String sigTypeName) {
    try {
      return getSigTraceByType(sigTypeName).getLoad().getInstanceRoot() != null;
    } catch (TraceException e) {
      return false;
    }
  }

  private void scanFile(String alloyPath) throws TraceException {
    Scanner scanner = null;
    try {
      scanner = new Scanner(new File(alloyPath));
    } catch (final FileNotFoundException e) {
      throw new TraceException("File not found. Path: " + alloyPath);
    }

    while (scanner.hasNextLine()) {
      String line = Utilities.getNextLine(scanner).trim();

      if (line.toLowerCase().startsWith("--loadalias")
          || line.toLowerCase().startsWith("-- loadalias")) {
        findLoads(scanner, line);
      }

      final Matcher sigTrace = Patterns.SIG_TRACE_PATTERN.matcher(line);
      final Matcher relationTrace = Patterns.REL_TRACE_PATTERN.matcher(line);

      if (relationTrace.find()) {
        findRelationTrace(scanner, line, relationTrace);
      } else if (sigTrace.find()) {
        findSigTrace(scanner, line, sigTrace);
      }
    }
    scanner.close();
  }

  private void findSigTrace(Scanner scanner, String line, Matcher sigTraceMatcher)
      throws TraceException {
    String traceAlias = sigTraceMatcher.group(1);
    String className = sigTraceMatcher.group(2);
    Matcher matcher = null;
    do {
      line = Utilities.getNextLine(scanner).trim();
      matcher = Patterns.SIG_PATTERN.matcher(line);
    } while (!matcher.find());

    if (matcher.lookingAt()) {
      final String sigType = matcher.group(2);
      LoadItem loadItem = getLoadByAlias(traceAlias);
      if (loadItem == null)
        throw new TraceException("Load traces must be above than other traces!");

      sigTraces.add(
          new SigTrace(traceAlias, sigType, className, loadItem, loadItem.getEClass(className)));
    }
  }

  private void findRelationTrace(Scanner scanner, String line, Matcher relationTraceMatcher)
      throws TraceException {
    String traceAlias = relationTraceMatcher.group(1);
    String traceClass = relationTraceMatcher.group(2);
    String traceReference = relationTraceMatcher.group(3);

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
      relationTrace.setSource(getSigTraceByClassName(traceClass));
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
    if (!alias.isEmpty()) {
      loads.add(new LoadItem(alias, modelFilePath, instanceFilePath));
    } else {
      throw new TraceException("Can't load EMF models!");
    }
  }

  public SigTrace getSigTraceByType(String type) throws TraceException {
    return sigTraces.stream().filter(sigTrace -> sigTrace.getSigType().equals(type)).findFirst()
        .orElseThrow(() -> new TraceException("There is no trace for the sig: " + type));
  }

  public SigTrace getSigTraceByClassName(String name) throws TraceException {
    return sigTraces.stream().filter(sigTrace -> sigTrace.getClassName().equals(name)).findFirst()
        .orElseThrow(() -> new TraceException("There is no trace for the EClass: " + name));
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

  @SuppressWarnings("unused")
  private RelationTrace getRelationTraceBySigType(String sourceSigType, String relationName) {
    return relationTraces.stream().filter(t -> (t.getSource().getSigType().equals(sourceSigType)
        && t.getRelationName().equals(relationName))).findFirst().orElse(null);
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

}
