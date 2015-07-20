package eu.modelwriter.writer.markers.internal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;
import org.eclipse.ui.texteditor.SimpleMarkerAnnotation;

import eu.modelwriter.writer.EventMemento;
import eu.modelwriter.writer.XMLDOMHelper;
import eu.modelwriter.writer.markers.MarkerActivator;

public class MarkerFactory {

  // Marker ID
  public static final String MARKER = "eu.modelwriter.writer.markers.marker";

  // Annotation ID
  public static final String ANNOTATION = "eu.modelwriter.writer.markers.annotation";

  public static final String GROUP_ID = "GROUP_ID";

  public static IMarker createMarker(IResource resource, ITextSelection selection)
      throws CoreException {

    IMarker marker = null;

    if (selection != null && !selection.getText().isEmpty()) {

      int start = selection.getOffset();
      int end = selection.getOffset() + selection.getLength();

      HashMap<String, Object> map = new HashMap<String, Object>();

      MarkerUtilities.setLineNumber(map, selection.getStartLine());
      MarkerUtilities.setMessage(map, selection.getText());
      MarkerUtilities.setCharStart(map, start);
      MarkerUtilities.setCharEnd(map, end);
      map.put(IMarker.TEXT, selection.getText());
      map.put(IMarker.LOCATION, selection.getStartLine());
      map.put(IMarker.SOURCE_ID, UUID.randomUUID().toString());
      MarkerUtilities.createMarker(resource, map, MARKER);

      MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
          "\"" + selection.getText() + "\" has been seleceted to be marked",
          MessageDialog.INFORMATION, new String[] {"OK"}, 0);
      dialog.open();

    } else {
      MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
          "Please perform a valid selection", MessageDialog.WARNING, new String[] {"OK"}, 0);
      dialog.open();
    }
    return marker;
  }

  /*
   * Creates a Marker
   */
  public static IMarker createMarker(IResource res, ITreeSelection selection) throws CoreException {

    IMarker marker = null;
    if (selection != null && MarkerActivator.getEditor() instanceof EcoreEditor
        && selection.getFirstElement() instanceof ENamedElement
        && ((ENamedElement) selection.getFirstElement()).getName() != null
        && !((ENamedElement) selection.getFirstElement()).getName().isEmpty()) {

      String selectedText = ((ENamedElement) selection.getFirstElement()).getName();

      String uri = getTreeUri(selection);
      System.out.println(uri);
      String xpath = XMLDOMHelper.findNodeAndGetXPath(selectedText,
          res.getLocation().toFile().getAbsolutePath());
      System.out.println(xpath);

      XMLInputFactory factory = XMLInputFactory.newInstance();
      try {
        XMLStreamReader streamReader =
            factory.createXMLStreamReader(new FileReader(res.getLocation().toFile()));

        EventMemento memento = null;
        EventMemento current = null;
        String elementName = null;
        while (streamReader.hasNext()) {
          // XMLStreamHelper.printEvent(streamReader, true);
          if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT) {
            String name = streamReader.getAttributeValue(null, "name");
            if (name != null && name.equals(selectedText)) {
              elementName = streamReader.getName().toString();
              break;
            }
          }
          memento = new EventMemento(streamReader);
          streamReader.next();
          current = new EventMemento(streamReader);
        }
        streamReader.close();
        IWorkbench workbench = PlatformUI.getWorkbench();
        IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
        IWorkbenchPage page = window.getActivePage();
        IEditorPart editor = page.getActiveEditor();
        IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
        IFile file = input.getFile();

        // None olarak declare edilmiş ise default UTF-8 ata.
        // JFace Text Document object is created to get character offsets from line numbers.
        Scanner scanner =
            new Scanner(file.getContents(), streamReader.getCharacterEncodingScheme());
        Document document = new Document(scanner.useDelimiter("\\A").next());
        scanner.close();

        int start = 0;
        System.out.println(memento.getLineNumber() - 1);
        int end = 0;
        System.out.println(current.getLineNumber());
        try {
          IRegion startRegion = document.getLineInformation(memento.getLineNumber() - 1);
          start = startRegion.getOffset() + memento.getColumnNumber() - 2;
          IRegion endRegion = document.getLineInformation(current.getLineNumber());
          end = endRegion.getOffset() - 1;
        } catch (BadLocationException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        // System.out.println(start);
        // System.out.println(end);
        int length = end - start;



        HashMap<String, Object> map = new HashMap<String, Object>();

        MarkerUtilities.setLineNumber(map, current.getLineNumber());
        MarkerUtilities.setMessage(map, selectedText);
        MarkerUtilities.setCharStart(map, start);
        MarkerUtilities.setCharEnd(map, end);
        map.put(IMarker.TEXT, elementName);
        map.put(IMarker.LOCATION, current.getLineNumber());
        map.put(IMarker.SOURCE_ID, UUID.randomUUID().toString());
        map.put("uri", uri);
        map.put("xpath", xpath);
        marker = file.createMarker(MARKER);
        if (marker.exists()) {
          try {
            marker.setAttributes(map);
          } catch (CoreException e) {
            // You need to handle the case where the marker no longer exists
            e.printStackTrace();
          }
        }
        ResourceMarkerAnnotationModel rmam = new ResourceMarkerAnnotationModel(file);
        SimpleMarkerAnnotation ma = new SimpleMarkerAnnotation(ANNOTATION, marker);
        rmam.addAnnotation(ma, new Position(start, length));

      } catch (XMLStreamException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      if (marker != null) {
        MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information",
            null, "\"" + selectedText + "\" has been seleceted to be marked",
            MessageDialog.INFORMATION, new String[] {"OK"}, 0);
        dialog.open();
      }
    } else {
      MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(), "Mark Information", null,
          "Please perform a valid selection", MessageDialog.WARNING, new String[] {"OK"}, 0);
      dialog.open();
    }
    return marker;

  }

  public static String getTreeUri(ITreeSelection treeSelection) {

    ENamedElement element = (ENamedElement) treeSelection.getFirstElement();
    String segment = treeSelection.getPaths()[0].getFirstSegment().toString();
    segment =
        segment.substring(segment.indexOf("'") + 1, segment.indexOf("'", segment.indexOf("'") + 1));
    String name = element.getName();

    String uri = segment + "#//" + name;
    return uri;
  }


  /*
   * returns a list of a resources markers
   */
  public static List<IMarker> findMarkers(IResource resource) {
    try {
      List<IMarker> myMarkerList =
          Arrays.asList(resource.findMarkers(MARKER, true, IResource.DEPTH_ZERO));
      return myMarkerList;
    } catch (CoreException e) {
      return new ArrayList<IMarker>();
    }
  }

  public static IMarker findMarkerByOffset(IResource resource, int offset) {
    IMarker marker = null;
    try {
      List<IMarker> mList = findAllMarkers(resource);
      int start;
      int end;
      for (IMarker iMarker : mList) {
        start = (int) iMarker.getAttribute(IMarker.CHAR_START);
        end = (int) iMarker.getAttribute(IMarker.CHAR_END);
        if (offset <= end && offset >= start) {
          return iMarker;
        }
      }
    } catch (CoreException e) {
      e.printStackTrace();
    }
    return marker;
  }

  public static IMarker findMarkerBySourceId(IResource resource, String id) {
    IMarker marker = null;
    try {
      List<IMarker> mList = findAllMarkers(resource);
      for (IMarker iMarker : mList) {
        if (id.equals(iMarker.getAttribute(IMarker.SOURCE_ID))) {
          return iMarker;
        }
      }
    } catch (CoreException e) {
      e.printStackTrace();
    }
    return marker;
  }

  public static IMarker findMarkerByXpath(IResource resource, String xpath) {
    IMarker marker = null;
    try {
      List<IMarker> mList = findAllMarkers(resource);
      for (IMarker iMarker : mList) {
        if (xpath.equals(iMarker.getAttribute("xpath"))) {
          return iMarker;
        }
      }
    } catch (CoreException e) {
      e.printStackTrace();
    }
    return marker;
  }

  public static IDocument getDocument() {
    MultiPageEditorPart mpepEditor;
    ITextEditor iteEditor;
    if (MarkerActivator.getEditor() instanceof MultiPageEditorPart) {
      mpepEditor = (MultiPageEditorPart) MarkerActivator.getEditor();
      IEditorPart[] editors = mpepEditor.findEditors(mpepEditor.getEditorInput());
      iteEditor = (ITextEditor) editors[0];
    } else
      iteEditor = (ITextEditor) MarkerActivator.getEditor();
    IDocumentProvider idp = iteEditor.getDocumentProvider();
    return idp.getDocument(iteEditor.getEditorInput());

    // ITextEditor editor = (ITextEditor) MarkerActivator.getEditor();
    // IDocumentProvider idp = editor.getDocumentProvider();
    // return idp.getDocument(editor.getEditorInput());
  }

  public static String getCurrentEditorContent() {
    return getDocument().get();
  }

  /*
   * Returns a list of markers that are linked to the resource or any sub resource of the resource
   */
  public static List<IMarker> findAllMarkers(IResource resource) {
    try {
      return Arrays.asList(resource.findMarkers(MARKER, true, IResource.DEPTH_INFINITE));
    } catch (CoreException e) {
      return new ArrayList<IMarker>();
    }
  }

  /*
   * Returns the selection of the package explorer
   */
  public static TreeSelection getTreeSelection() {

    ISelection selection =
        MarkerActivator.getActiveWorkbenchWindow().getSelectionService().getSelection();
    if (selection instanceof TreeSelection) {
      return (TreeSelection) selection;
    }
    return null;
  }

  /*
   * Returns the selection of the package explorer
   */
  public static TextSelection getTextSelection() {

    ISelection selection =
        MarkerActivator.getActiveWorkbenchWindow().getSelectionService().getSelection();
    if (selection instanceof TextSelection) {
      return (TextSelection) selection;
    }
    return null;
  }

  public static void addAnnotation(IMarker marker, ITextSelection selection, IEditorPart editor) {
    // The DocumentProvider enables to get the document currently loaded in
    // the editor
    MultiPageEditorPart mpepEditor;
    ITextEditor iteEditor;
    if (editor instanceof MultiPageEditorPart) {
      mpepEditor = (MultiPageEditorPart) editor;
      IEditorPart[] editors = mpepEditor.findEditors(mpepEditor.getEditorInput());
      iteEditor = (ITextEditor) editors[0];
    } else
      iteEditor = (ITextEditor) editor;

    IDocumentProvider idp = iteEditor.getDocumentProvider();

    // This is the document we want to connect to. This is taken from the
    // current editor input.
    IDocument document = idp.getDocument(iteEditor.getEditorInput());

    // The IannotationModel enables to add/remove/change annoatation to a
    // Document loaded in an Editor
    IAnnotationModel iamf = idp.getAnnotationModel(iteEditor.getEditorInput());

    // Note: The annotation type id specify that you want to create one of
    // your annotations
    SimpleMarkerAnnotation ma = new SimpleMarkerAnnotation(ANNOTATION, marker);

    // Finally add the new annotation to the model
    iamf.connect(document);
    iamf.addAnnotation(ma, new Position(selection.getOffset(), selection.getLength()));
    iamf.disconnect(document);
  }


}


