package eu.modelwriter.configuration.synthesis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;

public class AutomatedTraceCreator {
  private final String alloyFilePath;
  private final String xmiFilePath;
  private final IFile xmiFile;
  private final HashMap<String, String> trace2sig = new HashMap<>();
  private final HashMap<String, String> trace2field = new HashMap<>();
  private final HashMap<String, List<String>> trace2mapping = new HashMap<>();
  final HashMap<EObject, IMarker> eObject2Marker = new HashMap<>();

  public AutomatedTraceCreator(final String alloyFilePath, final IFile xmiFile) {
    this.alloyFilePath = alloyFilePath;
    this.xmiFile = xmiFile;
    this.xmiFilePath = this.getFilePath(xmiFile);
  }

  public void automate() throws IOException {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final EObject rootObject = this.getRootObject(this.xmiFilePath);

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
          this.trace2sig.get(object.eClass().getName()));
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
      final String relationName = this.trace2field.get(feature.getName());
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
  }

  private void findTraceParts() {
    final File file = new File(this.alloyFilePath);
    Scanner scanner = null;
    try {
      scanner = new Scanner(file);
    } catch (final FileNotFoundException e) {
      e.printStackTrace();
    }

    String lastSig = "";
    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      if (line.contains("-- trace@") || line.contains("--trace@") || line.contains("-- Trace@")
          || line.contains("--Trace@")) {
        final String trace = line.substring(line.indexOf("race@") + 5, line.length()).trim();
        line = scanner.nextLine();
        if (line.contains("sig")) {
          final int start = line.indexOf("sig") + 4;
          final String sig = lastSig = line.substring(start, line.indexOf(" ", start)).trim();
          this.trace2sig.put(trace, sig);
        } else if (line.contains(":")) {
          final String[] strings = line.split(" ");
          final String relation = strings[0].replaceAll(":", "").trim();
          final String target =
              strings[strings.length - 1].replaceAll(",", "").replaceAll("}", "").trim();
          final String source = lastSig;
          final List<String> field = new ArrayList<>();
          field.add(source);
          field.add(relation);
          field.add(target);
          this.trace2mapping.put(trace, field);
          this.trace2field.put(trace, relation);
        }
      }
    }
  }

  public String getFilePath(final IFile file) {
    return file.getLocation().toString();
  }

  public EObject getRootObject(final String xmiFilePath) throws IOException {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    final List list;
    try {
      list = modelIO.read(URI.createFileURI(xmiFilePath));
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
      if (this.trace2sig.keySet().contains(className)) {
        willBeCreatedMarkers.add(object);
      }
    }
    return willBeCreatedMarkers;
  }
}
