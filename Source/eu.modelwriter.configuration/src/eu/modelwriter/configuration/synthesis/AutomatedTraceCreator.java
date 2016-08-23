package eu.modelwriter.configuration.synthesis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.emf.ecore.util.EcoreEList;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.configuration.internal.EditorUtilities;
import eu.modelwriter.configuration.internal.ModelIO;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;

public class AutomatedTraceCreator {
  private final String alloyFilePath;
  private final HashMap<String, IFile> alias2XMIFile = new HashMap<>();
  private final HashMap<String, EObject> alias2TraceRoot = new HashMap<>();

  private final HashMap<String, List<String>> traceRoot2traceType = new HashMap<>();
  private final HashMap<String, String> traceType2Sig = new HashMap<>();
  private final HashMap<String, List<String>> traceRelation2field = new HashMap<>();

  final HashMap<EObject, IMarker> eObject2Marker = new HashMap<>();

  public AutomatedTraceCreator(final String alloyFilePath) {
    this.alloyFilePath = alloyFilePath;
  }

  public void automate() throws IOException {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    if (documentRoot == null) {
      throw new IOException();
    }

    this.findLoadedModels();
    this.findTraceParts();

    final List<EObject> allEObjects = new ArrayList<>();
    for (EObject rootObject : alias2TraceRoot.values()) {
      allEObjects.add(rootObject);
      allEObjects.addAll(rootObject.eContents());
    }

    final HashMap<EObject, String> willBeCreatedMarkers = this.getWillBeCreatedMarkers();
    this.createMarkers(willBeCreatedMarkers);

    for (final EObject object : willBeCreatedMarkers.keySet()) {
      this.createRelationsOfEObject(object);
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

  private void findTraceParts() {
    final File file = new File(this.alloyFilePath);
    Scanner scanner = null;
    try {
      scanner = new Scanner(file);
    } catch (final FileNotFoundException e) {
      e.printStackTrace();
    }

    final Pattern typePattern =
        Pattern.compile("(\\s*)(-)(-)(\\s*)(Trace|trace)(@)((?:[a-z]+))(\\.)((?:[a-z]+))(\\s*)",
            Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    final Pattern relationPattern = Pattern.compile(
        "(\\s*)(-)(-)(\\s*)(Trace|trace)(@)((?:[a-z]+))(\\.)((?:[a-z]+))(\\.)((?:[a-z]+))(\\s*)",
        Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      final Matcher matcherType = typePattern.matcher(line);
      final Matcher matcherRelation = relationPattern.matcher(line);

      String traceAlias = null;
      String traceType = null;
      String traceRelation = null;

      if (matcherRelation.find()) {
        traceAlias = matcherRelation.group(7);
        traceType = matcherRelation.group(9);
        traceRelation = matcherRelation.group(11);
      } else if (matcherType.find()) {
        traceAlias = matcherType.group(7);
        traceType = matcherType.group(9);
        if (!this.traceRoot2traceType.containsKey(traceAlias)) {
          this.traceRoot2traceType.put(traceAlias, new ArrayList<String>());
        }
        this.traceRoot2traceType.get(traceAlias).add(traceType);
      } else {
        continue;
      }

      line = scanner.nextLine();
      if (line.contains("sig")) {
        final int start = line.indexOf("sig") + 4;
        final String sig = line.substring(start, line.indexOf(" ", start)).trim();
        this.traceType2Sig.put(traceType, sig);
      } else if (line.contains(":")) {
        final String[] strings = line.split(" ");
        final String relation = strings[0].replaceAll(":", "").trim();
        final String targetSig =
            strings[strings.length - 1].replaceAll(",", "").replaceAll("}", "").trim();
        final List<String> field = new ArrayList<>();
        final String sourceSig = this.traceType2Sig.get(traceType);
        field.add(sourceSig);
        field.add(relation);
        field.add(targetSig);
        this.traceRelation2field.put(traceRelation, field);
      }
    }
    scanner.close();
  }

  private HashMap<EObject, String> getWillBeCreatedMarkers() {
    final HashMap<EObject, String> willBeCreatedMarkers = new HashMap<>();
    for (final String alias : alias2TraceRoot.keySet()) {
      final List<EObject> contents = new ArrayList<>();
      contents.add(alias2TraceRoot.get(alias));
      contents.addAll(alias2TraceRoot.get(alias).eContents());
      for (EObject eObject : contents) {
        final String className = eObject.eClass().getName();
        for (final List<String> list : this.traceRoot2traceType.values()) {
          if (list.contains(className)) {
            willBeCreatedMarkers.put(eObject, alias);
          }
        }
      }
    }
    return willBeCreatedMarkers;
  }

  private void createMarkers(final HashMap<EObject, String> willBeCreatedMarkers) {
    for (Entry<EObject, String> e : willBeCreatedMarkers.entrySet()) {
      String alias = e.getValue();
      EObject object = e.getKey();
      final IMarker marker = MarkerFactory.createInstanceMarker(object, alias2XMIFile.get(alias),
          this.traceType2Sig.get(object.eClass().getName()));
      if (marker == null) {
        return;
      }
      this.eObject2Marker.put(object, marker);
      AlloyUtilities.addTypeToMarker(marker);
      AlloyUtilities.addMarkerToRepository(marker);
    }
  }

  private void createRelationsOfEObject(final EObject object) {
    final IMarker source = this.eObject2Marker.get(object);
    if (source == null) {
      return;
    }
    final EList<EStructuralFeature> features = object.eClass().getEStructuralFeatures();
    for (final EStructuralFeature feature : features) {
      final List<String> field = this.traceRelation2field.get(feature.getName());
      String relationName = null;
      if (field != null) {
        relationName = field.get(1);
      }
      if (relationName != null && feature instanceof EReferenceImpl && !feature.isVolatile()) {
        @SuppressWarnings("unchecked")
        final EcoreEList<DynamicEObjectImpl> refs =
            (EcoreEList<DynamicEObjectImpl>) object.eGet(feature);
        for (final DynamicEObjectImpl ref : refs) {
          final IMarker target = this.eObject2Marker.get(ref);
          if (target == null) {
            continue;
          }
          AlloyUtilities.addRelation2Markers(source, target, relationName);
        }
      }
    }
    AnnotationFactory.convertAnnotationType(source, false, false,
        AlloyUtilities.getTotalTargetCount(source));
  }

  public String getFullPath(final IFile file) {
    return file.getFullPath().toString();
  }

}
