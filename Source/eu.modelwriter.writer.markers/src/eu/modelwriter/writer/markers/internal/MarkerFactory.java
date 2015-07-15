package eu.modelwriter.writer.markers.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.EditorPart;
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

	/*
	 * Creates a Marker
	 */
	static TreeSelection select;

	public static IMarker createMarker(IResource res, ISelection selection) throws CoreException {
		IMarker marker = null;

		ITextSelection textSelection = null;
		ITreeSelection treeSelection = null;

		String uri = null;

		if (selection instanceof ITextSelection)
			textSelection = (ITextSelection) selection;
		else if (selection instanceof ITreeSelection) {
			treeSelection = (ITreeSelection) selection;
			uri = getTreeUri(treeSelection);
		}

		Object[] segments = new Object[treeSelection.getPaths()[0].getSegmentCount()];
		for (int i = 0; i < treeSelection.getPaths()[0].getSegmentCount(); i++) {
			segments[i] = treeSelection.getPaths()[0].getSegment(i);
		}

		TreePath path = new TreePath(segments);

		EcoreEditor obje = (EcoreEditor) MarkerActivator.getEditor().getAdapter(EditorPart.class);

		TreeViewer viewer = (TreeViewer) obje.getViewer();

		if (select != null)
			obje.getViewer().setSelection(select);

		DecoratingLabelProvider decorator = new DecoratingLabelProvider((ILabelProvider) viewer.getLabelProvider(),
				new FileDecorator());
		viewer.setLabelProvider(decorator);

		select = new TreeSelection(path);
		MessageDialog dialog = new MessageDialog(MarkerActivator.getShell(),
				"Mark Information will be provided by this wizard.", null, "\"" + "\"has been seleceted to be marked",
				MessageDialog.INFORMATION, new String[] { "OK" }, 0);
		dialog.open();

		// obje.setSelection(select);
		// note: you use the id that is defined in your plugin.xml
		marker = res.createMarker(MARKER);

		if (textSelection != null) {
			marker.setAttribute(IMarker.MESSAGE, textSelection.getText());
			// compute and set char start and char end
			int start = textSelection.getOffset();
			int end = textSelection.getOffset() + textSelection.getLength();
			marker.setAttribute(IMarker.LOCATION, textSelection.getStartLine());
			marker.setAttribute(IMarker.CHAR_START, start);
			marker.setAttribute(IMarker.CHAR_END, end);
			marker.setAttribute(IMarker.TEXT, textSelection.getText());
			marker.setAttribute(IMarker.SOURCE_ID, UUID.randomUUID().toString());
		} else if (treeSelection != null) {
			// marker.setAttribute("uri",
			// "platform:/resource/EcoreDeneme/model/ecoreDeneme.ecore#//asdasd");
			// marker.setAttribute("uri","platform:/resource/EcoreDeneme/model/Library1.xmi#//@writers.0");
			marker.setAttribute("uri", uri);
			marker.setAttribute(IMarker.MESSAGE, "treee");
			marker.setAttribute("severity", 2);
			// marker.setAttribute("relatedURIs",
			// "http://www.eclipse.org/emf/2002/Ecore%23//ENamedElement/name");

		}
		return marker;
	}

	public static String getTreeUri(ITreeSelection treeSelection) {

		EClassImpl obje = (EClassImpl) treeSelection.getFirstElement();
		String segment = treeSelection.getPaths()[0].getFirstSegment().toString();
		segment = segment.substring(segment.indexOf("'") + 1, segment.indexOf("'", segment.indexOf("'") + 1));
		String name = obje.getName();

		String uri = segment + "#//" + name;
		return uri;
	}

	/*
	 * returns a list of a resources markers
	 */
	public static List<IMarker> findMarkers(IResource resource) {
		try {
			List<IMarker> myMarkerList = Arrays.asList(resource.findMarkers(MARKER, true, IResource.DEPTH_ZERO));
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
	 * Returns a list of markers that are linked to the resource or any sub
	 * resource of the resource
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

		ISelection selection = MarkerActivator.getActiveWorkbenchWindow().getSelectionService().getSelection();
		if (selection instanceof TreeSelection) {
			return (TreeSelection) selection;
		}
		return null;
	}

	/*
	 * Returns the selection of the package explorer
	 */
	public static TextSelection getTextSelection() {

		ISelection selection = MarkerActivator.getActiveWorkbenchWindow().getSelectionService().getSelection();
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
