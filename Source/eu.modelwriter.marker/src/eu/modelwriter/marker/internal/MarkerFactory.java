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
import java.util.UUID;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
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
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
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

  /**
   * Creates a Ecore Marker from tree selection
   *
   * @param selection
   * @param file
   * @param res
   * @param editor
   * @return
   */
  private static IMarker createEcoreMarker(ITreeSelection selection, IFile file, IResource res,
      IEditorPart editor) {

    IMarker marker = null;

    ENamedElement element = (ENamedElement) selection.getFirstElement();
    String selectedText = element.getName();

    URI uri = EcoreUtil.getURI(element);
    System.out.println(uri);

    String[] uriSplits = uri.toString().split("/");
    List<String> uriSplitsList = Arrays.asList(uriSplits);
    int indexOfStream = uriSplitsList.indexOf("") + 1;

    XMLInputFactory factory = XMLInputFactory.newInstance();
    try {
      XMLStreamReader streamReader =
          factory.createXMLStreamReader(new FileReader(res.getLocation().toFile()));

      EventMemento memento = null;
      EventMemento current = null;
      String elementName = null;
      while (streamReader.hasNext()) {

        if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT) {
          String name = streamReader.getAttributeValue(null, "name");
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

      int[] offsetStartEnd =
          MarkerFactory.getStartEndOffsetFromXML(streamReader, file, memento, current);
      int start = offsetStartEnd[0];
      int end = offsetStartEnd[1];

      // Create Marker
      HashMap<String, Object> map = new HashMap<String, Object>();
      MarkerUtilities.setLineNumber(map, current.getLineNumber());
      MarkerUtilities.setMessage(map, "Marker Type : non-type");
      MarkerUtilities.setCharStart(map, start);
      MarkerUtilities.setCharEnd(map, end);
      map.put(IMarker.TEXT, selectedText);
      map.put(IMarker.LOCATION, current.getLineNumber());
      map.put(IMarker.SOURCE_ID, generateId());
      map.put("uri", uri.toString());
      marker = file.createMarker(MarkerFactory.MARKER_MARKING);
      if (marker.exists()) {
        try {
          marker.setAttributes(map);
        } catch (CoreException e) {
          // You need to handle the case where the marker no longer exists
          e.printStackTrace();
        }
      }

      AnnotationFactory.addAnnotation(marker, editor, AnnotationFactory.ANNOTATION_MARKING);

    } catch (XMLStreamException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (CoreException e1) {
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
  private static IMarker createInstanceMarker(ITreeSelection selection, IFile file, IResource res,
      IEditorPart editor) {

    IMarker marker = null;

    EObject element = (EObject) selection.getFirstElement();

    if (!(element instanceof EModelElement)) {
      URI uri = EcoreUtil.getURI(element);

      String[] uriSplits = uri.toString().split("/");
      List<String> uriSplitsList = Arrays.asList(uriSplits);
      int indexOfStream = uriSplitsList.indexOf("") + 1;
      ArrayList<Object> pieces = new ArrayList<Object>();
      for (int i = indexOfStream; i < uriSplits.length; i++) {
        int dot = 0;
        dot = uriSplits[i].lastIndexOf(".");
        pieces.add(uriSplits[i].substring(1, dot));
        pieces.add(uriSplits[i].substring(dot + 1, uriSplits[i].length()));
      }

      try {
        XMLInputFactory factory = XMLInputFactory.newInstance();

        XMLStreamReader streamReader =
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
        int[] offsetStartEnd =
            MarkerFactory.getStartEndOffsetFromXML(streamReader, file, memento, current);
        int start = offsetStartEnd[0];
        int end = offsetStartEnd[1];

        String text = MarkerFactory.instanceToString(element);

        HashMap<String, Object> map = new HashMap<String, Object>();
        MarkerUtilities.setLineNumber(map, current.getLineNumber());
        MarkerUtilities.setMessage(map, "Marker Type : non-type");
        MarkerUtilities.setCharStart(map, start);
        MarkerUtilities.setCharEnd(map, end);
        map.put(IMarker.TEXT, text);
        map.put(IMarker.LOCATION, current.getLineNumber());
        map.put(IMarker.SOURCE_ID, generateId());
        map.put("uri", uri.toString());
        marker = file.createMarker(MarkerFactory.MARKER_MARKING);
        if (marker.exists()) {
          try {
            marker.setAttributes(map);
          } catch (CoreException e) {
            // You need to handle the case where the marker no longer exists
            e.printStackTrace();
          }
        }

        AnnotationFactory.addAnnotation(marker, editor, AnnotationFactory.ANNOTATION_MARKING);

      } catch (XMLStreamException e) {
        e.printStackTrace();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (CoreException e1) {
        e1.printStackTrace();
      }
    }
    return marker;
  }

  /**
   * Creates a Marker from TextSelection
   */
  public static IMarker createMarker(IResource resource, ITextSelection selection) {
    try {
      IMarker createdMarker = null;

      if (selection != null && !selection.getText().isEmpty()) {

        if (MarkerFactory.findMarkerWithAbsolutePosition(resource, selection.getOffset(),
            selection.getOffset() + selection.getLength()) != null) {

          MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
              null, "In these area, there is already a marker", MessageDialog.WARNING,
              new String[] {"OK"}, 0);
          dialog.open();

          return null;
        }

        int start = selection.getOffset();
        int end = selection.getOffset() + selection.getLength();

        HashMap<String, Object> map = new HashMap<String, Object>();

        MarkerUtilities.setLineNumber(map, selection.getStartLine());
        MarkerUtilities.setMessage(map, "Marker Type : non-type");
        MarkerUtilities.setCharStart(map, start);
        MarkerUtilities.setCharEnd(map, end);
        map.put(IMarker.TEXT, selection.getText());
        map.put(IMarker.LOCATION, selection.getStartLine());
        map.put(IMarker.SOURCE_ID, generateId());
        map.put(MarkUtilities.MARKER_TYPE, null);
        MarkerUtilities.createMarker(resource, map, MarkerFactory.MARKER_MARKING);

        createdMarker = MarkerFactory.findMarkerWithAbsolutePosition(resource, start, end);

      } else {
        MessageDialog dialog =
            new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
                "Please perform a valid selection", MessageDialog.WARNING, new String[] {"OK"}, 0);
        dialog.open();
      }
      return createdMarker;
    } catch (CoreException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Creates a Marker from TreeSelection
   */
  public static IMarker createMarker(IResource res, ITreeSelection selection) {
    if (selection == null) {
      MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
          "Please perform a valid selection", MessageDialog.WARNING, new String[] {"OK"}, 0);
      dialog.open();
      return null;
    } else if (MarkerFactory.findMarkerByTreeSelection(selection, res) != null) {
      MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
          "In these area, there is already a marker", MessageDialog.WARNING, new String[] {"OK"},
          0);
      dialog.open();
      return null;
    }

    // Fetch IResource
    IWorkbench workbench = PlatformUI.getWorkbench();
    IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
    IWorkbenchPage page = window.getActivePage();
    IEditorPart editor = page.getActiveEditor();
    IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
    IFile file = input.getFile();

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
      MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
          "Please perform a valid selection", MessageDialog.WARNING, new String[] {"OK"}, 0);
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
  private static IMarker createReqIfMarker(ITreeSelection selection, IFile file, IResource res,
      IEditorPart editor) {

    IMarker marker = null;

    Identifiable element = (Identifiable) selection.getFirstElement();
    URI uri = EcoreUtil.getURI(element);

    String attributeValue = MarkerFactory.reqIfToString(element);

    String identifier = element.getIdentifier();
    if (identifier != null && !identifier.isEmpty()) {
      XMLInputFactory factory = XMLInputFactory.newInstance();
      try {
        XMLStreamReader streamReader =
            factory.createXMLStreamReader(new FileReader(res.getLocation().toFile()));

        EventMemento memento = null;
        EventMemento current = null;
        while (streamReader.hasNext()) {
          if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT) {
            String name = streamReader.getAttributeValue(null, "IDENTIFIER");
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
        int[] offsetStartEnd =
            MarkerFactory.getStartEndOffsetFromXML(streamReader, file, memento, current);
        int start = offsetStartEnd[0];
        int end = offsetStartEnd[1];

        String text = null;
        if (element.isSetIdentifier()) {
          text = element.getIdentifier();
        }
        if (text == null) {
          text = element.toString();
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        MarkerUtilities.setLineNumber(map, current.getLineNumber());
        MarkerUtilities.setMessage(map, "Marker Type : non-type");
        MarkerUtilities.setCharStart(map, start);
        MarkerUtilities.setCharEnd(map, end);
        map.put(IMarker.TEXT, attributeValue);
        map.put(IMarker.LOCATION, current.getLineNumber());
        map.put(IMarker.SOURCE_ID, generateId());
        map.put("uri", uri.toString());
        marker = file.createMarker(MarkerFactory.MARKER_MARKING);
        if (marker.exists()) {
          try {
            marker.setAttributes(map);
          } catch (CoreException e) {
            // You need to handle the case where the marker no longer exists
            e.printStackTrace();
          }
        }

        AnnotationFactory.addAnnotation(marker, editor, AnnotationFactory.ANNOTATION_MARKING);

      } catch (XMLStreamException e) {
        e.printStackTrace();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (CoreException e1) {
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
  public static IMarker findMarkerByOffset(IResource resource, int offset) {
    IMarker marker = null;
    List<IMarker> mList = MarkerFactory.findMarkers(resource);
    int start;
    int end;
    for (IMarker iMarker : mList) {
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
  public static IMarker findMarkerBySourceId(IResource resource, String id) {
    IMarker marker = null;
    List<IMarker> mList = MarkerFactory.findMarkers(resource);
    for (IMarker iMarker : mList) {
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
  public static IMarker findMarkerByTreeSelection(ITreeSelection treeSelection,
      IResource resource) {
    Object o = treeSelection.getFirstElement();
    if (o != null && o instanceof EObject) {
      String uri = EcoreUtil.getURI((EObject) o).toString();

      List<IMarker> markers = MarkerFactory.findMarkers(resource);

      for (IMarker iMarker : markers) {
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
  public static IMarker findMarkerByXpath(IResource resource, String xpath) {
    IMarker marker = null;
    if (xpath == null || xpath.isEmpty()) {
      return null;
    }
    List<IMarker> mList = MarkerFactory.findMarkers(resource);
    for (IMarker iMarker : mList) {
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
  public static List<IMarker> findMarkers(IResource resource) {
    try {
      if (resource == null) {
        return new ArrayList<IMarker>();
      }
      return Arrays.asList(
          resource.findMarkers(MarkerFactory.MARKER_MARKING, true, IResource.DEPTH_INFINITE));
    } catch (CoreException e) {
      return new ArrayList<IMarker>();
    }
  }

  /**
   * Returns a list of a resources markers
   *
   * @param resource
   * @return
   */
  public static ArrayList<IMarker> findMarkersAsArrayList(IResource resource) {
    try {
      if (resource == null) {
        return new ArrayList<IMarker>();
      }
      ArrayList<IMarker> myMarkerList = new ArrayList<IMarker>();
      IMarker[] list;
      list = resource.findMarkers(MarkerFactory.MARKER_MARKING, true, IResource.DEPTH_INFINITE);

      for (IMarker iMarker : list) {
        myMarkerList.add(iMarker);
      }
      return myMarkerList;
    } catch (CoreException e) {
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
  public static List<IMarker> findMarkersByGroupId(IResource resource, String groupId) {
    List<IMarker> groupMarkers = new ArrayList<IMarker>();
    List<IMarker> markerList = MarkerFactory.findMarkers(resource);
    for (IMarker iMarker : markerList) {
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
  public static IMarker findMarkersByUri(IResource resource, String uri) {

    List<IMarker> markerList = MarkerFactory.findMarkers(resource);
    for (IMarker iMarker : markerList) {
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
  public static ArrayList<IMarker> findMarkersInSelection(IResource resource,
      ITextSelection selection) {
    ArrayList<IMarker> markerListInArea = new ArrayList<IMarker>();
    ArrayList<IMarker> markerList = MarkerFactory.findMarkersAsArrayList(resource);

    if (markerList.isEmpty()) {
      return null;
    }
    int textStart = selection.getOffset();
    int textEnd = textStart + selection.getLength();

    for (IMarker iMarker : markerList) {
      int markerStart = MarkUtilities.getStart(iMarker);
      int markerEnd = MarkUtilities.getEnd(iMarker);
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
  public static IMarker findMarkerWithAbsolutePosition(IResource resource, int textStart,
      int textEnd) {
    IMarker marker = null;
    ArrayList<IMarker> markerList = MarkerFactory.findMarkersAsArrayList(resource);

    if (markerList.isEmpty()) {
      return null;
    }

    for (IMarker iMarker : markerList) {
      int markerStart = MarkUtilities.getStart(iMarker);
      int markerEnd = MarkUtilities.getEnd(iMarker);
      if (textStart == markerStart && textEnd == markerEnd) {
        return iMarker;
      }
    }
    return marker;
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
      IEditorPart[] editors = mpepEditor.findEditors(mpepEditor.getEditorInput());
      iteEditor = (ITextEditor) editors[0];
    } else {
      iteEditor = (ITextEditor) MarkerActivator.getEditor();
    }
    IDocumentProvider idp = iteEditor.getDocumentProvider();
    return idp.getDocument(iteEditor.getEditorInput());

  }

  /**
   * @param selections
   * @return
   */
  public static String getQualifiedName(ITreeSelection selections) {
    TreePath[] paths = selections.getPaths();

    // Consider only not empty and single selection
    if (selections.isEmpty() || selections.size() > 1) {
      return null;
    }

    TreePath path = paths[0];
    IElementComparer comparer = null;
    if (selections instanceof TreeSelection) {
      comparer = ((TreeSelection) selections).getElementComparer();
    }
    System.out.println(path.hashCode(comparer));
    for (int i = 1; i < path.getSegmentCount(); i++) {
      if (path.getSegment(i) instanceof ResourceFactoryImpl) {
        EcoreResourceFactoryImpl eResourceFactory = (EcoreResourceFactoryImpl) path.getSegment(i);
        System.out
            .println(eResourceFactory.getClass().getName() + ": " + eResourceFactory.toString());
      } else if (path.getSegment(i) instanceof ENamedElement) {
        ENamedElement namedElement = (ENamedElement) path.getSegment(i);
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
  private static int[] getStartEndOffsetFromXML(XMLStreamReader streamReader, IFile file,
      EventMemento memento, EventMemento current) {
    int[] offsetStartEnd = new int[2];
    try {
      String charsetName = streamReader.getCharacterEncodingScheme();
      if (charsetName == null) {
        charsetName = "UTF-8";
      }
      Scanner scanner = new Scanner(file.getContents(), charsetName);
      IDocument document = new Document(scanner.useDelimiter("\\A").next());
      scanner.close();

      int start = 0;
      System.out.println("Previous Line Number" + (memento.getLineNumber() - 1));
      int end = 0;
      System.out.println("Current Line Number" + current.getLineNumber());

      IRegion startRegion = document.getLineInformation(memento.getLineNumber() - 1);
      start = startRegion.getOffset() + memento.getColumnNumber() - 2;
      IRegion endRegion = document.getLineInformation(current.getLineNumber());
      end = endRegion.getOffset() - 1;

      offsetStartEnd[0] = start;
      offsetStartEnd[1] = end;

    } catch (BadLocationException e1) {
      // e1.printStackTrace();
      System.out
          .println(e1.toString() + " --> in MarkerFactory's getStartEndOffsetFromXML function");
    } catch (CoreException e) {
      e.printStackTrace();
    }
    return offsetStartEnd;
  }

  /**
   * Returns the text of element which given from Instance
   */
  public static String instanceToString(EObject element) {
    EClass clazz = element.eClass();
    String text = "";

    EList<EStructuralFeature> structuralFeatures = clazz.getEStructuralFeatures();
    for (EStructuralFeature eStructuralFeature : structuralFeatures) {
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
      IViewPart viewPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
          .findView("org.eclipse.ui.navigator.ProjectExplorer");
      ((ProjectExplorer) viewPart).getCommonViewer().refresh();
    } catch (CoreException e) {
      e.printStackTrace();
    }

  }

  /**
   * Returns the text of element which given from Reqif
   */
  public static String reqIfToString(Identifiable element) {
    AttributeValueString attribute = null;
    String attributeValue = null;
    if (element instanceof SpecHierarchy) {
      SpecHierarchy specHierarchy = (SpecHierarchy) element;
      Iterator<AttributeValue> iter = specHierarchy.getObject().getValues().iterator();
      while (iter.hasNext()) {
        Object next = iter.next();
        if (next instanceof AttributeValueString) {
          attribute = (AttributeValueString) next;
          attributeValue = attribute.getTheValue();
          break;
        }
      }
    } else {
      TreeIterator<EObject> iter = element.eAllContents();

      while (iter.hasNext()) {
        EObject next = iter.next();
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
  public static void updateMarkerfromXMLForInstance(IMarker marker, IResource res) {

    try {
      String[] uriSplits = MarkUtilities.getUri(marker).split("/");
      List<String> uriSplitsList = Arrays.asList(uriSplits);
      int indexOfStream = uriSplitsList.indexOf("") + 1;
      ArrayList<Object> pieces = new ArrayList<Object>();
      for (int i = indexOfStream; i < uriSplits.length; i++) {
        int dot = 0;
        dot = uriSplits[i].lastIndexOf(".");
        pieces.add(uriSplits[i].substring(1, dot));
        pieces.add(uriSplits[i].substring(dot + 1, uriSplits[i].length()));
      }

      XMLInputFactory factory = XMLInputFactory.newInstance();

      XMLStreamReader streamReader =
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

      IFile file = (IFile) res;

      // JFace Text Document object is created to get character offsets from line numbers.
      int[] offsetStartEnd =
          MarkerFactory.getStartEndOffsetFromXML(streamReader, file, memento, current);
      int start = offsetStartEnd[0];
      int end = offsetStartEnd[1];

      MarkUtilities.setStart(marker, start);
      MarkUtilities.setEnd(marker, end);
      MarkUtilities.setLinenumber(marker, current.getLineNumber());

    } catch (XMLStreamException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * For the given marker this method updates its XML location
   *
   * @param marker
   * @param res
   */
  public static void updateMarkerfromXMLForModel(IMarker marker, IResource res) {
    try {
      String[] uriSplits = MarkUtilities.getUri(marker).split("/");
      List<String> uriSplitsList = Arrays.asList(uriSplits);
      int indexOfStream = uriSplitsList.indexOf("") + 1;

      XMLInputFactory factory = XMLInputFactory.newInstance();

      XMLStreamReader streamReader =
          factory.createXMLStreamReader(new FileReader(res.getLocation().toFile()));

      EventMemento memento = null;
      EventMemento current = null;
      while (streamReader.hasNext()) {

        if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT) {
          String name = streamReader.getAttributeValue(null, "name");
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

      IFile file = (IFile) res;

      // JFace Text Document object is created to get character offsets from line numbers.
      int[] offsetStartEnd =
          MarkerFactory.getStartEndOffsetFromXML(streamReader, file, memento, current);
      int start = offsetStartEnd[0];
      int end = offsetStartEnd[1];

      // Create Marker
      MarkUtilities.setStart(marker, start);
      MarkUtilities.setEnd(marker, end);
      MarkUtilities.setLinenumber(marker, current.getLineNumber());

    } catch (XMLStreamException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * For the given marker this method updates its XML location
   *
   * @param marker
   * @param res
   */
  public static void updateMarkerfromXMLForReqIf(IMarker marker, IResource res) {

    XMLInputFactory factory = XMLInputFactory.newInstance();
    try {
      String uri = MarkUtilities.getUri(marker);
      String identifier = uri.substring(uri.lastIndexOf("#") + 1, uri.length());
      XMLStreamReader streamReader =
          factory.createXMLStreamReader(new FileReader(res.getLocation().toFile()));

      EventMemento memento = null;
      EventMemento current = null;
      while (streamReader.hasNext()) {
        if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT) {
          String name = streamReader.getAttributeValue(null, "IDENTIFIER");
          if (name != null && name.equals(identifier)) {
            break;
          }
        }
        memento = new EventMemento(streamReader);
        streamReader.next();
        current = new EventMemento(streamReader);
      }
      streamReader.close();

      IFile file = (IFile) res;

      // JFace Text Document object is created to get character offsets from line numbers.
      int[] offsetStartEnd =
          MarkerFactory.getStartEndOffsetFromXML(streamReader, file, memento, current);
      int start = offsetStartEnd[0];
      int end = offsetStartEnd[1];

      MarkUtilities.setStart(marker, start);
      MarkUtilities.setEnd(marker, end);
      MarkUtilities.setLinenumber(marker, current.getLineNumber());

    } catch (XMLStreamException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static String generateId() {
    String base = "0000";
    DocumentRoot documentRoot = MarkerUpdater.getDocumentRoot();
    int nextId = documentRoot.getAlloy().getRepository().getNextId();

    String id = base + nextId;
    id = id.substring(id.length() - 5);

    documentRoot.getAlloy().getRepository().setNextId(++nextId);
    MarkerUpdater.writeDocumentRoot(documentRoot);

    return id;
  }
}
