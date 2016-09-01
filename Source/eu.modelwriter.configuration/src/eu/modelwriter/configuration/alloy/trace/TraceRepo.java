package eu.modelwriter.configuration.alloy.trace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraceRepo {

  private static TraceRepo instance = null;

  @SuppressWarnings("unused")
  private String alloyPath;

  private final List<SigTrace> sigTraces = new ArrayList<SigTrace>();
  private final List<RelationTrace> relationTraces = new ArrayList<RelationTrace>();
  private final List<LoadItem> loads = new ArrayList<LoadItem>();

  /**
   * 
   * @return TraceRepo instance
   */
  public static TraceRepo get() {
    if (instance == null)
      instance = new TraceRepo();
    return instance;
  }

  private TraceRepo() {}

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
    this.alloyPath = alloyPath;
    scanFile(alloyPath);
  }

  public List<LoadItem> getLoads() {
    return loads;
  }

  private void scanFile(String alloyPath) throws TraceException {
    final Pattern sigTracePattern = Pattern.compile(
        "(\\s*)(-)(-)(\\s*)(Trace|trace)(@)((?:[a-z0-9_]+))(\\.)((?:[a-z0-9_]+))(\\s*)",
        Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    final Pattern relationTracePattern = Pattern.compile(
        "(\\s*)(-)(-)(\\s*)(Trace|trace)(@)((?:[a-z0-9_]+))(\\.)((?:[a-z0-9_]+))(\\.)((?:[a-z0-9_]+))(\\s*)",
        Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

    final File file = new File(alloyPath);
    Scanner scanner = null;
    try {
      scanner = new Scanner(file);
    } catch (final FileNotFoundException e) {
      throw new TraceException("File not found. Path: " + alloyPath);
    }

    while (scanner.hasNextLine()) {
      String line = getNextLine(scanner);

      if (line.toLowerCase().startsWith("--loadalias")
          || line.toLowerCase().startsWith("-- loadalias")) {
        findLoads(scanner, line);
      }

      final Matcher sigTrace = sigTracePattern.matcher(line);
      final Matcher relationTrace = relationTracePattern.matcher(line);

      if (relationTrace.find()) {
        findRelationTrace(scanner, line, relationTrace);
      } else if (sigTrace.find()) {
        findSigTrace(scanner, line, sigTrace);
      }
    }

    scanner.close();
  }

  private void findSigTrace(Scanner scanner, String line, Matcher sigTraceMatcher) {
    String traceAlias = sigTraceMatcher.group(7);
    String traceType = sigTraceMatcher.group(9);
    do {
      line = getNextLine(scanner);
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
      line = getNextLine(scanner);
    } while (!line.contains(":"));

    if (line.contains(":")) {
      final String[] strings = line.split(" ");
      final String relation = strings[0].replaceAll(":", "").trim();
      final String targetSig =
          strings[strings.length - 1].replaceAll(",", "").replaceAll("}", "").trim();
      RelationTrace relationTrace =
          new RelationTrace(traceAlias, relation, traceReference, null, null);
      // source and target sigs are null for now
      // getSigTraceByClassName(traceClass), getSigTraceByName(targetSig));
      relationTraces.add(relationTrace);
    }
  }

  /**
   * Skips comment lines
   * 
   * @param scanner
   * @return comment free line
   */
  private String getNextLine(Scanner scanner) {
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine().trim();
      if (line.startsWith("//"))
        continue; // Its single comment line, skip

      if (line.startsWith("/*")) { // multi line comment
        String skipLine = line;
        while (scanner.hasNextLine() && !skipLine.contains("*/")) { // skip until close tag
          skipLine = scanner.nextLine();
        }
        // in case there is data after comment close tag
        line = skipLine.substring(skipLine.indexOf("*/") + 2);
        if (line.isEmpty())
          continue;
      }
      return line;
    }
    return "";
  }

  private void findLoads(Scanner scanner, String line) throws TraceException {
    String alias = "", modelFilePath = "", instanceFilePath = "";
    alias = line.substring(line.indexOf("@") + 1).trim();
    for (int i = 0; i < 2; i++) {
      String nextLine = getNextLine(scanner);
      if (nextLine.toLowerCase().contains("loadmodel@")) {
        modelFilePath = nextLine.substring(nextLine.indexOf("@") + 1);
      } else if (nextLine.toLowerCase().contains("loadinstance@")) {
        instanceFilePath = nextLine.substring(nextLine.indexOf("@") + 1);
      }
    }
    if (!alias.isEmpty() && !modelFilePath.isEmpty() && !instanceFilePath.isEmpty()) {
      try {
        loads.add(new LoadItem(alias, modelFilePath, instanceFilePath));
      } catch (IOException e) {
        throw new TraceException("Can't model with alias " + alias);
      }
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

  public RelationTrace getRelationTraceByRelationName(String rel) {
    return relationTraces.stream().filter(rt -> rt.getRelationName().equals(rel)).findFirst()
        .orElse(null);
  }

  public boolean isEmpty() {
    return sigTraces.isEmpty() || relationTraces.isEmpty();
  }

  public LoadItem getLoadByAlias(String alias) {
    return loads.stream().filter(load -> load.getAlias().equals(alias)).findFirst().orElse(null);
  }

}
