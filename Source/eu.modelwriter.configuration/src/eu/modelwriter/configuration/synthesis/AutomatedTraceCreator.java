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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.emf.ecore.util.EcoreEList;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.configuration.internal.ModelIO;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;

public class AutomatedTraceCreator {
  private final String alloyFilePath;
  private final String xmiFileFullPath;
  private final IFile xmiFile;
  private final HashMap<String, List<String>> traceRoot2traceType = new HashMap<>();
  // private final HashMap<String, List<String>> traceRoot2traceRelation = new HashMap<>();
  private final HashMap<String, String> traceType2Sig = new HashMap<>();
  private final HashMap<String, List<String>> traceRelation2field = new HashMap<>();

  final HashMap<EObject, IMarker> eObject2Marker = new HashMap<>();

  public AutomatedTraceCreator(final String alloyFilePath, final IFile xmiFile) {
    this.alloyFilePath = alloyFilePath;
    this.xmiFile = xmiFile;
    this.xmiFileFullPath = this.getFullPath(xmiFile);
  }

  public void automate() throws IOException {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final EObject rootObject = this.getRootObject(this.xmiFileFullPath);

    if (rootObject == null || documentRoot == null) {
      throw new IOException();
    }

    this.findTraceParts();

    final List<EObject> allEObjects = new ArrayList<>();
    allEObjects.add(rootObject);
    allEObjects.addAll(rootObject.eContents());

    final List<EObject> willBeCreatedMarkers = this.getWillBeCreatedMarkers(allEObjects);
    this.createMarkers(willBeCreatedMarkers);

    for (final EObject object : allEObjects) {
      this.createRelationsOfEObject(object);
    }
  }

  private void createMarkers(final List<EObject> willBeCreatedMarkers) {
    for (final EObject object : willBeCreatedMarkers) {
      final IMarker marker = MarkerFactory.createInstanceMarker(object, this.xmiFile,
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

      String traceRoot = null;
      String traceType = null;
      String traceRelation = null;

      if (matcherRelation.find()) {
        traceRoot = matcherRelation.group(7);
        traceType = matcherRelation.group(9);
        traceRelation = matcherRelation.group(11);
        // if (!this.traceRoot2traceRelation.containsKey(traceRoot)) {
        // this.traceRoot2traceRelation.put(traceRoot, new ArrayList<String>());
        // }
        // this.traceRoot2traceRelation.get(traceRoot).add(traceRelation);
      } else if (matcherType.find()) {
        traceRoot = matcherType.group(7);
        traceType = matcherType.group(9);
        if (!this.traceRoot2traceType.containsKey(traceRoot)) {
          this.traceRoot2traceType.put(traceRoot, new ArrayList<String>());
        }
        this.traceRoot2traceType.get(traceRoot).add(traceType);
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
  }

  public String getFullPath(final IFile file) {
    return file.getFullPath().toString();
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

  private List<EObject> getWillBeCreatedMarkers(final List<EObject> allEObjects) {
    final List<EObject> willBeCreatedMarkers = new ArrayList<>();
    for (final EObject object : allEObjects) {
      final String className = object.eClass().getName();
      for (final List<String> list : this.traceRoot2traceType.values()) {
        if (list.contains(className)) {
          willBeCreatedMarkers.add(object);
        }
      }
    }
    return willBeCreatedMarkers;
  }
}
