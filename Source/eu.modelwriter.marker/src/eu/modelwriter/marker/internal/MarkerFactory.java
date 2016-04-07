/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ferhat Erata - initial API and implementation H. Emre Kirmizi - initial API and
 * implementation Serhat Celik - initial API and implementation U. Anil Ozturk - initial API and
 * implementation
 *******************************************************************************/
package eu.modelwriter.marker.internal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.IElementComparer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.rmf.reqif10.AttributeValue;
import org.eclipse.rmf.reqif10.AttributeValueString;
import org.eclipse.rmf.reqif10.Identifiable;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.MarkerUtilities;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.xml.EventMemento;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;

public class MarkerFactory {

  public static final String TARGETVIEW_REF = "eu.modelwriter.marker.command.targetviewrefresh";
  public static final String SOURCEVIEW_REF = "eu.modelwriter.marker.command.sourceviewrefresh";
  public static final String MASTERVIEW_REF = "eu.modelwriter.marker.command.masterviewrefresh";

  public static final String ECORE_DECORATOR =
      "eu.modelwriter.model.decorators.decorator.ecore.red";
  public static final String FILE_DECORATOR = "eu.modelwriter.writer.markers.filedecorator";

  // Marker ID
  public static final String MARKER_MARKING = "eu.modelwriter.marker.marking";
  public static final String MARKER_MAPPING = "eu.modelwriter.marker.mapping";

  private static int nextId = -1;

  /**
   * Creates a Ecore Marker from tree selection
   *
   * @param selection
   * @param file
   * @param res
   * @param editor
   * @return
   */
  private static IMarker createEcoreMarker(final ITreeSelection selection, final IFile file,
      final IResource res, final IEditorPart editor) {

    IMarker marker = null;

    final ENamedElement element = (ENamedElement) selection.getFirstElement();
    final String selectedText = element.getName();

    final URI uri = EcoreUtil.getURI(element);
    System.out.println(uri);

    final String[] uriSplits = uri.toString().split("/");
    final List<String> uriSplitsList = Arrays.asList(uriSplits);
    int indexOfStream = uriSplitsList.indexOf("") + 1;

    final XMLInputFactory factory = XMLInputFactory.newInstance();
    try {
      final XMLStreamReader streamReader =
          factory.createXMLStreamReader(new FileReader(res.getLocation().toFile()));

      EventMemento memento = null;
      EventMemento current = null;
      @SuppressWarnings("unused")
      String elementName = null;
      while (streamReader.hasNext()) {

        if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT) {
          final String name = streamReader.getAttributeValue(null, "name");
          if (name != null && name.equals(uriSplitsList.get(indexOfStream))) {
            indexOfStream++;

            if (uriSplitsList.size() == indexOfStream) {
              elementName = streamReader.getName().toString();
              break;
            }
          }
        }
        memento = new EventMemento(streamReader);
        streamReader.next();
        current = new EventMemento(streamReader);
      }

      // JFace Text Document object is created to get character offsets from line numbers.

      final int[] offsetStartEnd =
          MarkerFactory.getStartEndOffsetFromXML(streamReader, file, memento, current);
      final int start = offsetStartEnd[0];
      final int end = offsetStartEnd[1];

      // Create Marker
      final HashMap<String, Object> map = new HashMap<String, Object>();
      MarkerUtilities.setLineNumber(map, current.getLineNumber());
      MarkerUtilities.setMessage(map, "Marker Type : non-type");
      MarkerUtilities.setCharStart(map, start);
      MarkerUtilities.setCharEnd(map, end);
      map.put(IMarker.TEXT, selectedText);
      map.put(IMarker.LOCATION, current.getLineNumber());
      map.put(IMarker.SOURCE_ID, MarkerFactory.generateId());
      map.put("uri", uri.toString());
      marker = file.createMarker(MarkerFactory.MARKER_MARKING);
      if (marker.exists()) {
        try {
          marker.setAttributes(map);
        } catch (final CoreException e) {
          // You need to handle the case where the marker no longer exists
          e.printStackTrace();
        }
      }

      AnnotationFactory.addAnnotation(marker, AnnotationFactory.ANNOTATION_MARKING);

    } catch (final XMLStreamException e) {
      e.printStackTrace();
    } catch (final FileNotFoundException e) {
      e.printStackTrace();
    } catch (final CoreException e1) {
      e1.printStackTrace();
    }
    return marker;
  }

  /**
   * Creates an Instance Marker from tree selection
   *
   * @param selection
   * @param file
   * @param res
   * @param editor
   * @return
   */
  private static IMarker createInstanceMarker(final ITreeSelection selection, final IFile file,
      final IResource res, final IEditorPart editor) {

    IMarker marker = null;

    final EObject element = (EObject) selection.getFirstElement();

    if (!(element instanceof EModelElement)) {
      final URI uri = EcoreUtil.getURI(element);

      final String[] uriSplits = uri.toString().split("/");
      final List<String> uriSplitsList = Arrays.asList(uriSplits);
      final int indexOfStream = uriSplitsList.indexOf("") + 1;
      final ArrayList<Object> pieces = new ArrayList<Object>();
      for (int i = indexOfStream; i < uriSplits.length; i++) {
        int dot = 0;
        dot = uriSplits[i].lastIndexOf(".");
        pieces.add(uriSplits[i].substring(1, dot));
        pieces.add(uriSplits[i].substring(dot + 1, uriSplits[i].length()));
      }

      try {
        final XMLInputFactory factory = XMLInputFactory.newInstance();

        final XMLStreamReader streamReader =
            factory.createXMLStreamReader(new FileReader(res.getLocation().toFile()));

        EventMemento memento = null;
        EventMemento current = null;
        int count = 0;
        int elementCount = 0;
        String name = null;
        String startElementName = null;
        int startElementCount = 0;

        while (streamReader.hasNext()) {

          if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT) {

            name = streamReader.getLocalName().toString();

            startElementName = (String) pieces.get(count);
            startElementCount = Integer.parseInt((String) pieces.get(count + 1));

            if (name.equals(startElementName)) {
              if (elementCount == startElementCount && pieces.size() - 2 == count) {
                break;
              }

              if (elementCount != startElementCount) {
                elementCount++;
              } else if (pieces.size() - 2 != count) {
                count += 2;
                elementCount = 0;
              }
            }
          }
          memento = new EventMemento(streamReader);
          streamReader.next();
          current = new EventMemento(streamReader);
        }

        // JFace Text Document object is created to get character offsets from line numbers.
        final int[] offsetStartEnd =
            MarkerFactory.getStartEndOffsetFromXML(streamReader, file, memento, current);
        final int start = offsetStartEnd[0];
        final int end = offsetStartEnd[1];

        final String text = MarkerFactory.instanceToString(element);

        final HashMap<String, Object> map = new HashMap<String, Object>();
        MarkerUtilities.setLineNumber(map, current.getLineNumber());
        MarkerUtilities.setMessage(map, "Marker Type : non-type");
        MarkerUtilities.setCharStart(map, start);
        MarkerUtilities.setCharEnd(map, end);
        map.put(IMarker.TEXT, text);
        map.put(IMarker.LOCATION, current.getLineNumber());
        map.put(IMarker.SOURCE_ID, MarkerFactory.generateId());
        map.put("uri", uri.toString());
        marker = file.createMarker(MarkerFactory.MARKER_MARKING);
        if (marker.exists()) {
          try {
            marker.setAttributes(map);
          } catch (final CoreException e) {
            // You need to handle the case where the marker no longer exists
            e.printStackTrace();
          }
        }

        AnnotationFactory.addAnnotation(marker, AnnotationFactory.ANNOTATION_MARKING);

      } catch (final XMLStreamException e) {
        e.printStackTrace();
      } catch (final FileNotFoundException e) {
        e.printStackTrace();
      } catch (final CoreException e1) {
        e1.printStackTrace();
      }
    }
    return marker;
  }

  /**
   * Creates a Marker from TextSelection
   */
  public static IMarker createMarker(final IResource resource, final ITextSelection selection) {
    try {
      IMarker createdMarker = null;

      if (selection != null && !selection.getText().isEmpty()) {

        if (MarkerFactory.findMarkerWithAbsolutePosition(resource, selection.getOffset(),
            selection.getOffset() + selection.getLength()) != null) {

          final MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
              "Mark Information", null, "In these area, there is already a marker",
              MessageDialog.WARNING, new String[] {"OK"}, 0);
          dialog.open();

          return null;
        }

        final int start = selection.getOffset();
        final int end = selection.getOffset() + selection.getLength();

        final HashMap<String, Object> map = new HashMap<String, Object>();

        MarkerUtilities.setLineNumber(map, selection.getStartLine());
        MarkerUtilities.setMessage(map, "Marker Type : non-type");
        MarkerUtilities.setCharStart(map, start);
        MarkerUtilities.setCharEnd(map, end);
        map.put(IMarker.TEXT, selection.getText());
        map.put(IMarker.LOCATION, selection.getStartLine());
        map.put(IMarker.SOURCE_ID, MarkerFactory.generateId());
        map.put(MarkUtilities.MARKER_TYPE, null);
        map.put(MarkUtilities.START_OFFSET, start);
        map.put(MarkUtilities.END_OFFSET, end);
        MarkerUtilities.createMarker(resource, map, MarkerFactory.MARKER_MARKING);

        createdMarker = MarkerFactory.findMarkerWithAbsolutePosition(resource, start, end);

      } else {
        final MessageDialog dialog =
            new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
                "Please perform a valid selection", MessageDialog.WARNING, new String[] {"OK"}, 0);
        dialog.open();
      }
      return createdMarker;
    } catch (final CoreException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Creates a Marker from TreeSelection
   */
  public static IMarker createMarker(final IResource res, final ITreeSelection selection) {
    if (selection == null) {
      final MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
          null, "Please perform a valid selection", MessageDialog.WARNING, new String[] {"OK"}, 0);
      dialog.open();
      return null;
    } else if (MarkerFactory.findMarkerByTreeSelection(selection, res) != null) {
      final MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
          null, "In these area, there is already a marker", MessageDialog.WARNING,
          new String[] {"OK"}, 0);
      dialog.open();
      return null;
    }

    // Fetch IResource
    final IWorkbench workbench = PlatformUI.getWorkbench();
    final IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
    final IWorkbenchPage page = window.getActivePage();
    final IEditorPart editor = page.getActiveEditor();
    final IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
    final IFile file = input.getFile();

    IMarker marker = null;
    if (selection != null && MarkerActivator.getEditor() instanceof EcoreEditor
        && selection.getFirstElement() instanceof ENamedElement
        && ((ENamedElement) selection.getFirstElement()).getName() != null
        && !((ENamedElement) selection.getFirstElement()).getName().isEmpty()) {

      marker = MarkerFactory.createEcoreMarker(selection, file, res, editor);

    } else if (selection != null && MarkerActivator.getEditor() instanceof EcoreEditor
        && selection.getFirstElement() != null
        && selection.getFirstElement() instanceof Identifiable) {

      marker = MarkerFactory.createReqIfMarker(selection, file, res, editor);


    } else if (selection != null && MarkerActivator.getEditor() instanceof EcoreEditor
        && selection.getFirstElement() != null) {

      marker = MarkerFactory.createInstanceMarker(selection, file, res, editor);

    } else {
      final MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
          null, "Please perform a valid selection", MessageDialog.WARNING, new String[] {"OK"}, 0);
      dialog.open();
    }
    return marker;
  }

  /**
   * Creates a ReqIf Marker from tree selection
   *
   * @param selection
   * @param file
   * @param res
   * @param editor
   * @return
   */
  private static IMarker createReqIfMarker(final ITreeSelection selection, final IFile file,
      final IResource res, final IEditorPart editor) {

    IMarker marker = null;

    final Identifiable element = (Identifiable) selection.getFirstElement();
    final URI uri = EcoreUtil.getURI(element);

    final String attributeValue = MarkerFactory.reqIfToString(element);

    final String identifier = element.getIdentifier();
    if (identifier != null && !identifier.isEmpty()) {
      final XMLInputFactory factory = XMLInputFactory.newInstance();
      try {
        final XMLStreamReader streamReader =
            factory.createXMLStreamReader(new FileReader(res.getLocation().toFile()));

        EventMemento memento = null;
        EventMemento current = null;
        while (streamReader.hasNext()) {
          if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT) {
            final String name = streamReader.getAttributeValue(null, "IDENTIFIER");
            if (name != null && name.equals(identifier)) {
              break;
            }
          }
          memento = new EventMemento(streamReader);
          streamReader.next();
          current = new EventMemento(streamReader);
        }
        streamReader.close();

        // JFace Text Document object is created to get character offsets from line numbers.
        final int[] offsetStartEnd =
            MarkerFactory.getStartEndOffsetFromXML(streamReader, file, memento, current);
        final int start = offsetStartEnd[0];
        final int end = offsetStartEnd[1];

        String text = null;
        if (element.isSetIdentifier()) {
          text = element.getIdentifier();
        }
        if (text == null) {
          text = element.toString();
        }

        final HashMap<String, Object> map = new HashMap<String, Object>();
        MarkerUtilities.setLineNumber(map, current.getLineNumber());
        MarkerUtilities.setMessage(map, "Marker Type : non-type");
        MarkerUtilities.setCharStart(map, start);
        MarkerUtilities.setCharEnd(map, end);
        map.put(IMarker.TEXT, attributeValue);
        map.put(IMarker.LOCATION, current.getLineNumber());
        map.put(IMarker.SOURCE_ID, MarkerFactory.generateId());
        map.put("uri", uri.toString());
        marker = file.createMarker(MarkerFactory.MARKER_MARKING);
        if (marker.exists()) {
          try {
            marker.setAttributes(map);
          } catch (final CoreException e) {
            // You need to handle the case where the marker no longer exists
            e.printStackTrace();
          }
        }

        AnnotationFactory.addAnnotation(marker, AnnotationFactory.ANNOTATION_MARKING);

      } catch (final XMLStreamException e) {
        e.printStackTrace();
      } catch (final FileNotFoundException e) {
        e.printStackTrace();
      } catch (final CoreException e1) {
        e1.printStackTrace();
      }
    }

    return marker;

  }

  /**
   * Find a marker for given offset on given resource
   *
   * @param resource
   * @param offset
   * @return
   */
  public static IMarker findMarkerByOffset(final IResource resource, final int offset) {
    final IMarker marker = null;
    final List<IMarker> mList = MarkerFactory.findMarkers(resource);
    int start;
    int end;
    for (final IMarker iMarker : mList) {
      start = MarkUtilities.getStart(iMarker);
      end = MarkUtilities.getEnd(iMarker);
      if (offset <= end && offset >= start) {
        return iMarker;
      }
    }
    return marker;
  }

  /**
   * Find a marker by its source id on resource
   *
   * @param resource
   * @param id
   * @return
   */
  public static IMarker findMarkerBySourceId(final IResource resource, final String id) {
    final IMarker marker = null;
    final List<IMarker> mList = MarkerFactory.findMarkers(resource);
    for (final IMarker iMarker : mList) {
      if (id.equals(MarkUtilities.getSourceId(iMarker))) {
        return iMarker;
      }
    }
    return marker;
  }

  /**
   * Finds a marker for given selection on the tree
   *
   * @param treeSelection
   * @param resource
   * @return
   */
  public static IMarker findMarkerByTreeSelection(final ITreeSelection treeSelection,
      final IResource resource) {
    final Object o = treeSelection.getFirstElement();
    if (o != null && o instanceof EObject) {
      final String uri = EcoreUtil.getURI((EObject) o).toString();

      final List<IMarker> markers = MarkerFactory.findMarkers(resource);

      for (final IMarker iMarker : markers) {
        if (uri.equals(MarkUtilities.getUri(iMarker))) {
          return iMarker;
        }
      }
    }
    return null;
  }

  /**
   * @param resource
   * @param xpath
   * @return
   */
  public static IMarker findMarkerByXpath(final IResource resource, final String xpath) {
    final IMarker marker = null;
    if (xpath == null || xpath.isEmpty()) {
      return null;
    }
    final List<IMarker> mList = MarkerFactory.findMarkers(resource);
    for (final IMarker iMarker : mList) {
      if (xpath.equals(MarkUtilities.getXpath(iMarker))) {
        return iMarker;
      }
    }
    return marker;
  }

  /**
   * Returns a list of markers that are linked to the resource or any sub resource of the resource
   *
   * @param resource
   * @return
   */
  public static List<IMarker> findMarkers(final IResource resource) {
    try {
      if (resource == null) {
        return new ArrayList<IMarker>();
      }
      return Arrays.asList(
          resource.findMarkers(MarkerFactory.MARKER_MARKING, true, IResource.DEPTH_INFINITE));
    } catch (final CoreException e) {
      return new ArrayList<IMarker>();
    }
  }

  /**
   * Returns a list of a resources markers
   *
   * @param resource
   * @return
   */
  public static ArrayList<IMarker> findMarkersAsArrayList(final IResource resource) {
    try {
      if (resource == null) {
        return new ArrayList<IMarker>();
      }
      final ArrayList<IMarker> myMarkerList = new ArrayList<IMarker>();
      IMarker[] list;
      list = resource.findMarkers(MarkerFactory.MARKER_MARKING, true, IResource.DEPTH_INFINITE);

      for (final IMarker iMarker : list) {
        myMarkerList.add(iMarker);
      }
      return myMarkerList;
    } catch (final CoreException e) {
      e.printStackTrace();
    }
    return new ArrayList<IMarker>();
  }

  /**
   * Find group of markers which means all of them are depended each other by same group
   *
   * @param resource
   * @param groupId
   * @return List of markers which have got same group
   */
  public static List<IMarker> findMarkersByGroupId(final IResource resource, final String groupId) {
    final List<IMarker> groupMarkers = new ArrayList<IMarker>();
    final List<IMarker> markerList = MarkerFactory.findMarkers(resource);
    for (final IMarker iMarker : markerList) {
      if (MarkUtilities.getGroupId(iMarker) != null
          && groupId.equals(MarkUtilities.getGroupId(iMarker))) {
        groupMarkers.add(iMarker);
      }
    }
    return groupMarkers;
  }

  /**
   * @param resource
   * @param uri
   * @return
   */
  public static IMarker findMarkersByUri(final IResource resource, final String uri) {

    final List<IMarker> markerList = MarkerFactory.findMarkers(resource);
    for (final IMarker iMarker : markerList) {
      if (uri.equals(MarkUtilities.getUri(iMarker))) {
        return iMarker;
      }
    }
    return null;
  }

  /**
   * @param resource
   * @param selection
   * @returns list of markers which are found by selection
   */
  public static ArrayList<IMarker> findMarkersInSelection(final IResource resource,
      final ITextSelection selection) {
    final ArrayList<IMarker> markerListInArea = new ArrayList<IMarker>();
    final ArrayList<IMarker> markerList = MarkerFactory.findMarkersAsArrayList(resource);

    if (markerList.isEmpty()) {
      return null;
    }
    final int textStart = selection.getOffset();
    final int textEnd = textStart + selection.getLength();

    for (final IMarker iMarker : markerList) {
      final int markerStart = MarkUtilities.getStart(iMarker);
      final int markerEnd = MarkUtilities.getEnd(iMarker);
      if (textStart >= markerStart && textStart <= markerEnd
          || textEnd >= markerStart && textEnd <= markerEnd
          || markerStart >= textStart && markerStart <= textEnd
          || markerEnd >= textStart && markerEnd <= textEnd) {

        markerListInArea.add(iMarker);
      }
    }
    return markerListInArea;
  }

  /**
   * @param resource
   * @param textStart
   * @param textEnd
   * @return
   */
  public static IMarker findMarkerWithAbsolutePosition(final IResource resource,
      final int textStart, final int textEnd) {
    final IMarker marker = null;
    final ArrayList<IMarker> markerList = MarkerFactory.findMarkersAsArrayList(resource);

    if (markerList.isEmpty()) {
      return null;
    }

    for (final IMarker iMarker : markerList) {
      final int markerStart = MarkUtilities.getStart(iMarker);
      final int markerEnd = MarkUtilities.getEnd(iMarker);
      if (textStart == markerStart && textEnd == markerEnd) {
        return iMarker;
      }
    }
    return marker;
  }

  /**
   * @param iResource
   * @return list of untyped markers for given resource
   */
  public static ArrayList<IMarker> findUntypedMarkers(final IResource iResource) {
    ArrayList<IMarker> listOfMarkers = new ArrayList<IMarker>();
    listOfMarkers = MarkerFactory.findMarkersAsArrayList(iResource);
    final Iterator<IMarker> iter = listOfMarkers.iterator();
    while (iter.hasNext()) {
      final IMarker iMarker = iter.next();
      if (MarkUtilities.getType(iMarker) != null) {
        iter.remove();
      }
    }
    return listOfMarkers;
  }

  public static String generateId() {
    final String base = "0000";
    // int nextId;
    final Path path = new Path(MarkerUpdater.getLocation());
    if (path.toFile().exists()) {

      final DocumentRoot documentRoot = MarkerUpdater.getDocumentRoot();
      nextId = documentRoot.getAlloy().getRepository().getNextId();

      documentRoot.getAlloy().getRepository().setNextId(++nextId);
      MarkerUpdater.writeDocumentRoot(documentRoot);

    } else {
      if (nextId == -1) {
        // ArrayList<IMarker> markers =
        // findMarkersAsArrayList(ResourcesPlugin.getWorkspace().getRoot());
        IMarker[] markers, mappedMarkers;
        int id = 0;
        try {
          markers = ResourcesPlugin.getWorkspace().getRoot()
              .findMarkers(MarkerFactory.MARKER_MARKING, true, IResource.DEPTH_INFINITE);
          mappedMarkers = ResourcesPlugin.getWorkspace().getRoot()
              .findMarkers(MarkerFactory.MARKER_MARKING, true, IResource.DEPTH_INFINITE);

          for (IMarker iMarker : markers) {
            int tempId = Integer.parseInt(MarkUtilities.getSourceId(iMarker));
            if (tempId > id)
              id = tempId;
          }

          for (IMarker iMarker : mappedMarkers) {
            int tempId = Integer.parseInt(MarkUtilities.getSourceId(iMarker));
            if (tempId > id)
              id = tempId;
          }

        } catch (CoreException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        nextId = id + 1;
      } else {
        nextId++;
      }

    }
    String id = base + nextId;
    id = id.substring(id.length() - 5);

    return id;
  }

  /**
   * @returns the document content
   */
  public static String getCurrentEditorContent() {
    return MarkerFactory.getDocument().get();
  }

  /**
   * @returns the document for current editor
   */
  public static IDocument getDocument() {
    MultiPageEditorPart mpepEditor;
    ITextEditor iteEditor;
    if (MarkerActivator.getEditor() instanceof MultiPageEditorPart) {
      mpepEditor = (MultiPageEditorPart) MarkerActivator.getEditor();
      final IEditorPart[] editors = mpepEditor.findEditors(mpepEditor.getEditorInput());
      iteEditor = (ITextEditor) editors[0];
    } else {
      iteEditor = (ITextEditor) MarkerActivator.getEditor();
    }
    final IDocumentProvider idp = iteEditor.getDocumentProvider();
    return idp.getDocument(iteEditor.getEditorInput());

  }

  /**
   * Note: it compares marker's resource file name and open editors' file name.
   *
   * @param marker
   * @return if marker's editor is open, return editor, else return null
   */
  public static IEditorPart getOpenEditorOfMarker(final IMarker marker) {
    final IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
    for (final IWorkbenchWindow iWorkbenchWindow : windows) {
      final IWorkbenchPage[] pages = iWorkbenchWindow.getPages();
      for (final IWorkbenchPage iWorkbenchPage : pages) {
        final IEditorReference[] editors = iWorkbenchPage.getEditorReferences();
        for (final IEditorReference iEditorReference : editors) {
          try {
            final IFileEditorInput input = (IFileEditorInput) iEditorReference.getEditorInput();
            final IFile file = input.getFile();
            if (file.getFullPath().equals(marker.getResource().getFullPath())) {
              return iEditorReference.getEditor(false);
            }
          } catch (final PartInitException e) {
            e.printStackTrace();
          }
        }
      }
    }
    return null;
  }

  /**
   * @param selections
   * @return
   */
  public static String getQualifiedName(final ITreeSelection selections) {
    final TreePath[] paths = selections.getPaths();

    // Consider only not empty and single selection
    if (selections.isEmpty() || selections.size() > 1) {
      return null;
    }

    final TreePath path = paths[0];
    IElementComparer comparer = null;
    if (selections instanceof TreeSelection) {
      comparer = ((TreeSelection) selections).getElementComparer();
    }
    System.out.println(path.hashCode(comparer));
    for (int i = 1; i < path.getSegmentCount(); i++) {
      if (path.getSegment(i) instanceof ResourceFactoryImpl) {
        final EcoreResourceFactoryImpl eResourceFactory =
            (EcoreResourceFactoryImpl) path.getSegment(i);
        System.out
            .println(eResourceFactory.getClass().getName() + ": " + eResourceFactory.toString());
      } else if (path.getSegment(i) instanceof ENamedElement) {
        final ENamedElement namedElement = (ENamedElement) path.getSegment(i);
        System.out.println(namedElement.getClass().getName() + ": " + namedElement.getName());
      } else {
        System.out.println("?");
      }
    }
    return null;
  }

  /**
   * @returns current selection
   */
  public static ISelection getSelection() {
    return MarkerActivator.getActiveWorkbenchWindow().getSelectionService().getSelection();
  }

  /**
   * Returns character offsets from line numbers from JFace Text Document object.
   */
  private static int[] getStartEndOffsetFromXML(final XMLStreamReader streamReader,
      final IFile file, final EventMemento memento, final EventMemento current) {
    final int[] offsetStartEnd = new int[2];
    try {
      String charsetName = streamReader.getCharacterEncodingScheme();
      if (charsetName == null) {
        charsetName = "UTF-8";
      }
      final Scanner scanner = new Scanner(file.getContents(), charsetName);
      final IDocument document = new Document(scanner.useDelimiter("\\A").next());
      scanner.close();

      int start = 0;
      System.out.println("Previous Line Number" + (memento.getLineNumber() - 1));
      int end = 0;
      System.out.println("Current Line Number" + current.getLineNumber());

      final IRegion startRegion = document.getLineInformation(memento.getLineNumber() - 1);
      start = startRegion.getOffset() + memento.getColumnNumber() - 2;
      final IRegion endRegion = document.getLineInformation(current.getLineNumber());
      end = endRegion.getOffset() - 1;

      offsetStartEnd[0] = start;
      offsetStartEnd[1] = end;

    } catch (final BadLocationException e1) {
      // e1.printStackTrace();
      System.out
          .println(e1.toString() + " --> in MarkerFactory's getStartEndOffsetFromXML function");
    } catch (final CoreException e) {
      e.printStackTrace();
    }
    return offsetStartEnd;
  }

  /**
   * Returns the text of element which given from Instance
   */
  public static String instanceToString(final EObject element) {
    final EClass clazz = element.eClass();
    String text = "";

    final EList<EStructuralFeature> structuralFeatures = clazz.getEStructuralFeatures();
    for (final EStructuralFeature eStructuralFeature : structuralFeatures) {
      if (!(eStructuralFeature instanceof EReference)) {
        text += eStructuralFeature.getName() + " = " + element.eGet(eStructuralFeature) + "  ";
      }
    }
    return text == null ? "" : text;
  }

  /**
   * This method refresh Project Explorer View when the actions (Mark/Mark All/Delete/Delete All)
   * have been completed.
   *
   */
  public static void refreshProjectExp() {
    try {
      ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
      final IViewPart viewPart = PlatformUI.getWorkbench().getWorkbenchWindows()[0].getActivePage()
          .findView("org.eclipse.ui.navigator.ProjectExplorer");
      ((ProjectExplorer) viewPart).getCommonViewer().refresh();
    } catch (final CoreException e) {
      e.printStackTrace();
    }

  }

  /**
   * Returns the text of element which given from Reqif
   */
  public static String reqIfToString(final Identifiable element) {
    AttributeValueString attribute = null;
    String attributeValue = null;
    if (element instanceof SpecHierarchy) {
      final SpecHierarchy specHierarchy = (SpecHierarchy) element;
      final Iterator<AttributeValue> iter = specHierarchy.getObject().getValues().iterator();
      while (iter.hasNext()) {
        final Object next = iter.next();
        if (next instanceof AttributeValueString) {
          attribute = (AttributeValueString) next;
          attributeValue = attribute.getTheValue();
          break;
        }
      }
    } else {
      final TreeIterator<EObject> iter = element.eAllContents();

      while (iter.hasNext()) {
        final EObject next = iter.next();
        if (next instanceof AttributeValueString) {
          attribute = (AttributeValueString) next;
          attributeValue = attribute.getTheValue();
          break;
        }
      }
    }
    return attributeValue;
  }

  /**
   * For the given marker this method updates its XML location
   *
   * @param marker
   * @param res
   */
  public static void updateMarkerfromXMLForInstance(final IMarker marker, final IResource res) {

    try {
      final String[] uriSplits = MarkUtilities.getUri(marker).split("/");
      final List<String> uriSplitsList = Arrays.asList(uriSplits);
      final int indexOfStream = uriSplitsList.indexOf("") + 1;
      final ArrayList<Object> pieces = new ArrayList<Object>();
      for (int i = indexOfStream; i < uriSplits.length; i++) {
        int dot = 0;
        dot = uriSplits[i].lastIndexOf(".");
        pieces.add(uriSplits[i].substring(1, dot));
        pieces.add(uriSplits[i].substring(dot + 1, uriSplits[i].length()));
      }

      final XMLInputFactory factory = XMLInputFactory.newInstance();

      final XMLStreamReader streamReader =
          factory.createXMLStreamReader(new FileReader(res.getLocation().toFile()));

      EventMemento memento = null;
      EventMemento current = null;
      int count = 0;
      int elementCount = 0;
      String name = null;
      String startElementName = null;
      int startElementCount = 0;

      while (streamReader.hasNext()) {

        if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT) {

          name = streamReader.getLocalName().toString();

          startElementName = (String) pieces.get(count);
          startElementCount = Integer.parseInt((String) pieces.get(count + 1));

          if (name.equals(startElementName)) {
            if (elementCount == startElementCount && pieces.size() - 2 == count) {
              break;
            }

            if (elementCount != startElementCount) {
              elementCount++;
            } else if (pieces.size() - 2 != count) {
              count += 2;
              elementCount = 0;
            }
          }

        }
        memento = new EventMemento(streamReader);
        streamReader.next();
        current = new EventMemento(streamReader);
      }

      final IFile file = (IFile) res;

      // JFace Text Document object is created to get character offsets from line numbers.
      final int[] offsetStartEnd =
          MarkerFactory.getStartEndOffsetFromXML(streamReader, file, memento, current);
      final int start = offsetStartEnd[0];
      final int end = offsetStartEnd[1];

      MarkUtilities.setStart(marker, start);
      MarkUtilities.setEnd(marker, end);
      MarkUtilities.setLinenumber(marker, current.getLineNumber());

    } catch (final XMLStreamException e) {
      e.printStackTrace();
    } catch (final FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * For the given marker this method updates its XML location
   *
   * @param marker
   * @param res
   */
  public static void updateMarkerfromXMLForModel(final IMarker marker, final IResource res) {
    try {
      final String[] uriSplits = MarkUtilities.getUri(marker).split("/");
      final List<String> uriSplitsList = Arrays.asList(uriSplits);
      int indexOfStream = uriSplitsList.indexOf("") + 1;

      final XMLInputFactory factory = XMLInputFactory.newInstance();

      final XMLStreamReader streamReader =
          factory.createXMLStreamReader(new FileReader(res.getLocation().toFile()));

      EventMemento memento = null;
      EventMemento current = null;
      while (streamReader.hasNext()) {

        if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT) {
          final String name = streamReader.getAttributeValue(null, "name");
          if (name != null && name.equals(uriSplitsList.get(indexOfStream))) {
            indexOfStream++;

            if (uriSplitsList.size() == indexOfStream) {
              break;
            }
          }
        }
        memento = new EventMemento(streamReader);
        streamReader.next();
        current = new EventMemento(streamReader);

      }

      final IFile file = (IFile) res;

      // JFace Text Document object is created to get character offsets from line numbers.
      final int[] offsetStartEnd =
          MarkerFactory.getStartEndOffsetFromXML(streamReader, file, memento, current);
      final int start = offsetStartEnd[0];
      final int end = offsetStartEnd[1];

      // Create Marker
      MarkUtilities.setStart(marker, start);
      MarkUtilities.setEnd(marker, end);
      MarkUtilities.setLinenumber(marker, current.getLineNumber());

    } catch (final XMLStreamException e) {
      e.printStackTrace();
    } catch (final FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * For the given marker this method updates its XML location
   *
   * @param marker
   * @param res
   */
  public static void updateMarkerfromXMLForReqIf(final IMarker marker, final IResource res) {

    final XMLInputFactory factory = XMLInputFactory.newInstance();
    try {
      final String uri = MarkUtilities.getUri(marker);
      final String identifier = uri.substring(uri.lastIndexOf("#") + 1, uri.length());
      final XMLStreamReader streamReader =
          factory.createXMLStreamReader(new FileReader(res.getLocation().toFile()));

      EventMemento memento = null;
      EventMemento current = null;
      while (streamReader.hasNext()) {
        if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT) {
          final String name = streamReader.getAttributeValue(null, "IDENTIFIER");
          if (name != null && name.equals(identifier)) {
            break;
          }
        }
        memento = new EventMemento(streamReader);
        streamReader.next();
        current = new EventMemento(streamReader);
      }
      streamReader.close();

      final IFile file = (IFile) res;

      // JFace Text Document object is created to get character offsets from line numbers.
      final int[] offsetStartEnd =
          MarkerFactory.getStartEndOffsetFromXML(streamReader, file, memento, current);
      final int start = offsetStartEnd[0];
      final int end = offsetStartEnd[1];

      MarkUtilities.setStart(marker, start);
      MarkUtilities.setEnd(marker, end);
      MarkUtilities.setLinenumber(marker, current.getLineNumber());

    } catch (final XMLStreamException e) {
      e.printStackTrace();
    } catch (final FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
