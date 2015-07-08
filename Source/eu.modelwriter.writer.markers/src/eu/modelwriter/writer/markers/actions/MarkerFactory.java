package eu.modelwriter.writer.markers.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.SimpleMarkerAnnotation;

import eu.modelwriter.writer.markers.MarkerActivator;

public class MarkerFactory {

	// Marker ID
	public static final String MARKER = "eu.modelwriter.writer.markers.marker";

	// Annotation ID
	public static final String ANNOTATION = "eu.modelwriter.writer.markers.annotation";

	/*
	 * Creates a Marker
	 */
	public static IMarker createMarker(IResource res, ITextSelection selection)
			throws CoreException {
		IMarker marker = null;
		// note: you use the id that is defined in your plugin.xml
		marker = res.createMarker(MARKER);
		marker.setAttribute(IMarker.MESSAGE, selection.getText());
		// compute and set char start and char end
		int start = selection.getOffset();
		int end = selection.getOffset() + selection.getLength();
		marker.setAttribute(IMarker.LOCATION, selection.getStartLine());
		marker.setAttribute(IMarker.CHAR_START, start);
		marker.setAttribute(IMarker.CHAR_END, end);
		marker.setAttribute(IMarker.TEXT, selection.getText());
		marker.setAttribute(IMarker.SOURCE_ID, UUID.randomUUID().toString());
		return marker;
	}

	/*
	 * returns a list of a resources markers
	 */
	public static List<IMarker> findMarkers(IResource resource) {
		try {
			List<IMarker> myMarkerList = Arrays.asList(resource.findMarkers(
					MARKER, true, IResource.DEPTH_ZERO));
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

	public String getCurrentEditorContent() {
		final IEditorPart activeEditor = MarkerActivator.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();
		if (activeEditor == null)
			return null;
		final IDocument doc = (IDocument) activeEditor.getAdapter(IDocument.class);
		if (doc == null)
			return null;

		return doc.get();
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
			ITextEditor editor) {
		// The DocumentProvider enables to get the document currently loaded in
		// the editor
		IDocumentProvider idp = editor.getDocumentProvider();

		// This is the document we want to connect to. This is taken from the
		// current editor input.
		IDocument document = idp.getDocument(editor.getEditorInput());

		// The IannotationModel enables to add/remove/change annoatation to a
		// Document loaded in an Editor
		IAnnotationModel iamf = idp.getAnnotationModel(editor.getEditorInput());

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
