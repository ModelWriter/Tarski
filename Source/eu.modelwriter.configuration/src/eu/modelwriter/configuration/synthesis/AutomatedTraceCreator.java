package eu.modelwriter.configuration.synthesis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EContentsEList;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.configuration.internal.EditorUtilities;
import eu.modelwriter.configuration.internal.ModelIO;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;

abstract class Trace {
  String modelPath;
  String instancePath;
  String alias;
  String tracePath;
}


class SigTrace extends Trace {
  String sigName;
  String className;
}


class RelationTrace extends Trace {
  String relationName;
  String referenceName;
  SigTrace source, target;
}


public class AutomatedTraceCreator {
  private final String alloyFilePath;
  private final HashMap<String, IFile> alias2XMIFile = new HashMap<>();
  private final HashMap<String, EObject> alias2TraceRoot = new HashMap<>();

  private final List<SigTrace> sigTraces = new ArrayList<SigTrace>();
  private final List<RelationTrace> relationTraces = new ArrayList<RelationTrace>();

  private final HashMap<EObject, IMarker> eObject2Marker = new HashMap<>();

  public AutomatedTraceCreator(final String alloyFilePath) {
    this.alloyFilePath = alloyFilePath;
  }

  public void automate() throws IOException {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    if (documentRoot == null) {
      throw new IOException();
    }

    this.findLoadedModels();

    final File file = new File(this.alloyFilePath);
    Scanner scanner = null;
    try {
      scanner = new Scanner(file);
      this.findSigTraces(scanner);
      scanner.close();
      scanner = new Scanner(file);
      this.findRelationTraces(scanner);
      scanner.close();
    } catch (final FileNotFoundException e) {
      e.printStackTrace();
    }

    final List<EObject> allEObjects = new ArrayList<>();
    for (EObject rootObject : alias2TraceRoot.values()) {
      findAllEObjects(allEObjects, rootObject);
    }

    this.createMarkers(allEObjects);
    this.createRelations(allEObjects);

  }

  private void findAllEObjects(List<EObject> allEObjects, EObject root) {
    allEObjects.add(root);
    for (EObject object : root.eContents()) {
      findAllEObjects(allEObjects, object);
    }
  }

  private void createMarkers(List<EObject> allEObjects) {
    for (EObject eObject : allEObjects) {
      final String className = eObject.eClass().getName();
      final SigTrace sigTrace = findSigTraceByClassName(className);
      if (sigTrace != null) {
        IMarker marker = createMarker(eObject, sigTrace.alias, sigTrace.sigName);
        if (marker != null) {
          eObject2Marker.put(eObject, marker);
        }
      }
    }
  }

  private IMarker createMarker(EObject eObject, String alias, String sigName) {
    final IMarker marker =
        MarkerFactory.createInstanceMarker(eObject, alias2XMIFile.get(alias), sigName);
    if (marker == null) {
      return null;
    }
    AlloyUtilities.addTypeToMarker(marker);
    AlloyUtilities.addMarkerToRepository(marker);
    return marker;
  }

  private RelationTrace findRelationNameByReferenceName(String reference) {
    return relationTraces.stream().filter(rt -> rt.referenceName.equals(reference)).findFirst()
        .orElse(null);
  }

  @SuppressWarnings("rawtypes")
  private void createRelations(List<EObject> allEObjects) {
    for (EObject eObject : eObject2Marker.keySet()) {
      final IMarker source = eObject2Marker.get(eObject);
      for (EContentsEList.FeatureIterator featureIterator =
          (EContentsEList.FeatureIterator) eObject.eCrossReferences().iterator(); featureIterator
              .hasNext();) {
        EObject crossObject = (EObject) featureIterator.next();
        EReference eReference = (EReference) featureIterator.feature();
        final IMarker target = eObject2Marker.get(crossObject);
        final RelationTrace relationTrace = findRelationNameByReferenceName(eReference.getName());
        if (target != null && source != null && relationTrace != null) {
          AlloyUtilities.addRelation2Markers(source, target, relationTrace.relationName);
        }
      }
      // AnnotationFactory.convertAnnotationType(source, false, false,
      // AlloyUtilities.getTotalTargetCount(source));
    }
  }

  public EObject getRootObject(final String xmiFileFullPath) throws IOException {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    final List list;
    try {
      list = modelIO.read(URI.createPlatformResourceURI(xmiFileFullPath, true));
    } catch (final IOException e) {
      throw new IOException();
    }
    if (list.isEmpty()) {
      return null;
    }
    final EObject rootObject = (EObject) list.get(0);
    return rootObject;
  }

  private void findLoadedModels() throws IOException {
    List<String> lines = EditorUtilities.getPartitionsByRules(new File(this.alloyFilePath),
        "-- loadInstance", "--loadInstance");
    try {
      for (String line : lines) {
        final String path = line.substring(line.indexOf("@") + 1, line.indexOf(" as")).trim();
        final String alias = line.substring(line.indexOf(" as") + 3).trim();
        EObject root = getRootObject(path);
        if (root != null) {
          this.alias2XMIFile.put(alias, EditorUtilities.getIFileFromPath(path));
          this.alias2TraceRoot.put(alias, this.getRootObject(path));
        }
      }
    } catch (IndexOutOfBoundsException e) {
      throw new IOException();
    }
    if (this.alias2TraceRoot.size() == 0 || this.alias2XMIFile.size() == 0)
      throw new IOException();
  }

  private void findSigTraces(Scanner scanner) {
    final Pattern typePattern = Pattern.compile(
        "(\\s*)(-)(-)(\\s*)(Trace|trace)(@)((?:[a-z0-9_]+))(\\.)((?:[a-z0-9_]+))(\\s*)",
        Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    final Pattern relationPattern = Pattern.compile(
        "(\\s*)(-)(-)(\\s*)(Trace|trace)(@)((?:[a-z0-9_]+))(\\.)((?:[a-z0-9_]+))(\\.)((?:[a-z0-9_]+))(\\s*)",
        Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      final Matcher matcherType = typePattern.matcher(line);
      final Matcher matcherRelation = relationPattern.matcher(line);
      String traceAlias = null;
      String traceType = null;

      if (line.trim().startsWith("//") || line.trim().startsWith("/*"))
        continue;

      if (matcherRelation.find()) {
        continue;
      } else if (matcherType.find()) {
        traceAlias = matcherType.group(7);
        traceType = matcherType.group(9);
      } else {
        continue;
      }

      do {
        line = scanner.nextLine();
      } while (scanner.hasNextLine()
          && ((line.trim().startsWith("//") || line.trim().startsWith("/*"))
              || !line.contains("sig")));

      if (line.contains("sig")) {
        final int start = line.indexOf("sig") + 4;
        int stop = line.indexOf(" ", start);
        stop = stop == -1 ? line.indexOf("{", start) : stop;
        stop = stop == -1 ? line.indexOf("\n", start) : stop;
        final String sig = line.substring(start, stop).trim();
        SigTrace sigTrace = new SigTrace();
        sigTrace.sigName = sig;
        sigTrace.className = traceType;
        sigTrace.alias = traceAlias;
        sigTraces.add(sigTrace);
      }
    }
  }

  private void findRelationTraces(Scanner scanner) {
    final Pattern relationPattern = Pattern.compile(
        "(\\s*)(-)(-)(\\s*)(Trace|trace)(@)((?:[a-z0-9_]+))(\\.)((?:[a-z0-9_]+))(\\.)((?:[a-z0-9_]+))(\\s*)",
        Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      final Matcher matcherRelation = relationPattern.matcher(line);

      String traceAlias = null;
      String traceClass = null;
      String traceReference = null;

      if (line.trim().startsWith("//") || line.trim().startsWith("/*"))
        continue;

      if (matcherRelation.find()) {
        traceAlias = matcherRelation.group(7);
        traceClass = matcherRelation.group(9);
        traceReference = matcherRelation.group(11);
      } else {
        continue;
      }

      do {
        line = scanner.nextLine();
      } while (scanner.hasNextLine()
          && ((line.trim().startsWith("//") || line.trim().startsWith("/*"))
              || !line.contains(":")));

      if (line.contains(":")) {
        final String[] strings = line.split(" ");
        final String relation = strings[0].replaceAll(":", "").trim();
        final String targetSig =
            strings[strings.length - 1].replaceAll(",", "").replaceAll("}", "").trim();
        RelationTrace relationTrace = new RelationTrace();
        relationTrace.alias = traceAlias;
        relationTrace.source = findSigTraceByClassName(traceClass);
        relationTrace.target = findSigTraceByName(targetSig);
        relationTrace.relationName = relation;
        relationTrace.referenceName = traceReference;
        relationTraces.add(relationTrace);
      }
    }

  }

  private SigTrace findSigTraceByName(String name) {
    return sigTraces.stream().filter(sigTrace -> sigTrace.sigName.equals(name)).findFirst()
        .orElse(null);
  }

  private SigTrace findSigTraceByClassName(String name) {
    return sigTraces.stream().filter(sigTrace -> sigTrace.className.equals(name)).findFirst()
        .orElse(null);
  }

}
