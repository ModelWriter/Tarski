package eu.modelwriter.writer.markers.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.SimpleMarkerAnnotation;

import eu.modelwriter.writer.markers.MarkerActivator;

public class MarkerFactory {

	// Marker ID
	public static final String MARKER = "eu.modelwriter.writer.markers.marker";

	// Annotation ID
	public static final String ANNOTATION = "eu.modelwriter.writer.markers.annotation";

	public static final String GROUP_ID = "GROUP_ID";

	public static IMarker createMarker(IResource res, ITextSelection selection)
			throws CoreException {

		IMarker marker = null;

		if (selection != null && !selection.getText().isEmpty()) {
			marker = res.createMarker(MARKER);

			marker.setAttribute(IMarker.MESSAGE, selection.getText());
			// compute and set char start and char end
			int start = selection.getOffset();
			int end = selection.getOffset() + selection.getLength();
			marker.setAttribute(IMarker.LOCATION, selection.getStartLine());
			marker.setAttribute(IMarker.CHAR_START, start);
			marker.setAttribute(IMarker.CHAR_END, end);
			marker.setAttribute(IMarker.TEXT, selection.getText());
			marker.setAttribute(IMarker.SOURCE_ID,
					UUID.randomUUID().toString());

			MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
					"Mark Information", null,
					"\"" + selection.getText()
							+ "\" has been seleceted to be marked",
					MessageDialog.INFORMATION, new String[] { "OK" }, 0);
			dialog.open();

		} else {
			MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
					"Mark Information", null,
					"Please perform a valid selection", MessageDialog.WARNING,
					new String[] { "OK" }, 0);
			dialog.open();
		}
		return marker;
	}

	/*
	 * Creates a Marker
	 */
	public static IMarker createMarker(IResource res, ITreeSelection selection)
			throws CoreException {

		IMarker marker = null;
		if (selection != null
				&& MarkerActivator.getEditor() instanceof EcoreEditor
				&& selection.getFirstElement() instanceof ENamedElement) {

			String selectedText = ((ENamedElement) selection.getFirstElement())
					.getName();

			String uri = getTreeUri(selection);

			marker = res.createMarker(MARKER);
			// marker.setAttribute("uri",
			// "platform:/resource/EcoreDeneme/model/ecoreDeneme.ecore#//asdasd");
			// marker.setAttribute("uri","platform:/resource/EcoreDeneme/model/Library1.xmi#//@writers.0");
			marker.setAttribute("uri", uri);
			marker.setAttribute(IMarker.MESSAGE, selectedText);
			marker.setAttribute(IMarker.SOURCE_ID,
					UUID.randomUUID().toString());
			// marker.setAttribute("severity", 2);
			// marker.setAttribute("relatedURIs",
			// "http://www.eclipse.org/emf/2002/Ecore%23//ENamedElement/name");

			MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
					"Mark Information", null,
					"\"" + selectedText + "\" has been seleceted to be marked",
					MessageDialog.INFORMATION, new String[] { "OK" }, 0);
			dialog.open();
		} else if (selection == null) {
			MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
					"Mark Information", null,
					"Please perform a valid selection", MessageDialog.WARNING,
					new String[] { "OK" }, 0);
			dialog.open();
		}
		return marker;

	}

	public static String getTreeUri(ITreeSelection treeSelection) {

		ENamedElement element = (ENamedElement) treeSelection.getFirstElement();
		String segment = treeSelection.getPaths()[0].getFirstSegment()
				.toString();
		segment = segment.substring(segment.indexOf("'") + 1,
				segment.indexOf("'", segment.indexOf("'") + 1));
		String name = element.getName();

		String uri = segment + "#//" + name;
		return uri;
	}

	public static String getTreeUri(Object TreeItem) {

		return null;
	}

	/*
	 * returns a list of a resources markers
	 */
	public static List<IMarker> findMarkers(IResource resource) {
		try {
			List<IMarker> myMarkerList = Arrays.asList(
					resource.findMarkers(MARKER, true, IResource.DEPTH_ZERO));
			// for (IMarker iMarker : myMarkerList) {
			// int startChar = iMarker.getAttribute(IMarker.CHAR_START, 0);
			// int endChar = iMarker.getAttribute(IMarker.CHAR_END, 0);
			// MessageDialog.openInformation(null, "Wizards Starts", startChar +
			// " - " + endChar);
			// }
			return myMarkerList;
		} catch (CoreException e) {
			return new ArrayList<IMarker>();
		}
	}

	public static IMarker findMarker(IResource resource, int offset) {
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

	public static IMarker findMarker(IResource resource, String id) {
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

	public static IMarker findMarkerByLocationUri(IResource resource,
			String uri) {
		IMarker marker = null;
		try {
			List<IMarker> mList = findAllMarkers(resource);
			for (IMarker iMarker : mList) {
				if (iMarker.getAttribute("uri") != null
						&& uri.equals(iMarker.getAttribute("uri"))) {
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
			IEditorPart[] editors = mpepEditor
					.findEditors(mpepEditor.getEditorInput());
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
	 * Returns a list of markers that are linked to the resource or any sub
	 * resource of the resource
	 */
	public static List<IMarker> findAllMarkers(IResource resource) {
		try {
			return Arrays.asList(resource.findMarkers(MARKER, true,
					IResource.DEPTH_INFINITE));
		} catch (CoreException e) {
			return new ArrayList<IMarker>();
		}
	}

	/*
	 * Returns the selection of the package explorer
	 */
	public static TreeSelection getTreeSelection() {

		ISelection selection = MarkerActivator.getActiveWorkbenchWindow()
				.getSelectionService().getSelection();
		if (selection instanceof TreeSelection) {
			return (TreeSelection) selection;
		}
		return null;
	}

	/*
	 * Returns the selection of the package explorer
	 */
	public static TextSelection getTextSelection() {

		ISelection selection = MarkerActivator.getActiveWorkbenchWindow()
				.getSelectionService().getSelection();
		if (selection instanceof TextSelection) {
			return (TextSelection) selection;
		}
		return null;
	}

	public static void addAnnotation(IMarker marker, ITextSelection selection,
			IEditorPart editor) {
		// The DocumentProvider enables to get the document currently loaded in
		// the editor
		MultiPageEditorPart mpepEditor;
		ITextEditor iteEditor;
		if (editor instanceof MultiPageEditorPart) {
			mpepEditor = (MultiPageEditorPart) editor;
			IEditorPart[] editors = mpepEditor
					.findEditors(mpepEditor.getEditorInput());
			iteEditor = (ITextEditor) editors[0];
		} else
			iteEditor = (ITextEditor) editor;

		IDocumentProvider idp = iteEditor.getDocumentProvider();

		// This is the document we want to connect to. This is taken from the
		// current editor input.
		IDocument document = idp.getDocument(iteEditor.getEditorInput());

		// The IannotationModel enables to add/remove/change annoatation to a
		// Document loaded in an Editor
		IAnnotationModel iamf = idp
				.getAnnotationModel(iteEditor.getEditorInput());

		// Note: The annotation type id specify that you want to create one of
		// your annotations
		SimpleMarkerAnnotation ma = new SimpleMarkerAnnotation(ANNOTATION,
				marker);

		// Finally add the new annotation to the model
		iamf.connect(document);
		iamf.addAnnotation(ma,
				new Position(selection.getOffset(), selection.getLength()));
		iamf.disconnect(document);
	}
}
