package eu.modelwriter.marker.internal;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;
import org.eclipse.ui.texteditor.SimpleMarkerAnnotation;

public class AnnotationFactory {

  // Annotation IDs
  public static final String ANNOTATION_MARKING = "eu.modelwriter.marker.annotation.marking";
  public static final String ANNOTATION_MAPPING = "eu.modelwriter.marker.annotation.mapping";

  // TODO selection
  public static void addAnnotation(IMarker marker, IEditorPart editor, String annotationType) {
    // The DocumentProvider enables to get the document currently loaded in
    // the editor
    try {
      int start;
      start = MarkElementUtilities.getStart(marker);
      int length = MarkElementUtilities.getLength(marker);
      EcoreEditor ecEditor;
      MultiPageEditorPart mpepEditor;
      ITextEditor iteEditor = null;
      if (editor instanceof EcoreEditor) {
        IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
        IFile file = input.getFile();
        ResourceMarkerAnnotationModel rmam = new ResourceMarkerAnnotationModel(file);
        SimpleMarkerAnnotation ma = new SimpleMarkerAnnotation(annotationType, marker);
        rmam.addAnnotation(ma, new Position(start, length));

        ecEditor = (EcoreEditor) editor;
        ecEditor.getViewer().refresh();
      } else {
        if (editor instanceof ITextEditor) {
          iteEditor = (ITextEditor) editor;
        } else {
          mpepEditor = (MultiPageEditorPart) editor;
          IEditorPart[] editors = mpepEditor.findEditors(mpepEditor.getEditorInput());
          iteEditor = (ITextEditor) editors[0];
        }
        IDocumentProvider idp = iteEditor.getDocumentProvider();

        // This is the document we want to connect to. This is taken from the
        // current editor input.
        IDocument document = idp.getDocument(iteEditor.getEditorInput());

        // The IannotationModel enables to add/remove/change annoatation to a
        // Document loaded in an Editor
        IAnnotationModel iamf = idp.getAnnotationModel(iteEditor.getEditorInput());

        // Note: The annotation type id specify that you want to create one of
        // your annotations
        SimpleMarkerAnnotation ma = new SimpleMarkerAnnotation(annotationType, marker);

        // Finally add the new annotation to the model
        iamf.connect(document);
        iamf.addAnnotation(ma, new Position(start, length));
        iamf.disconnect(document);
        idp.resetDocument(iteEditor.getEditorInput());
      }
    } catch (CoreException e) {
      e.printStackTrace();
    }
  }


  public static void removeAnnotation(IMarker marker, IEditorPart editor) throws CoreException {
    // The DocumentProvider enables to get the document currently loaded in
    // the editor
    EcoreEditor ecEditor;
    MultiPageEditorPart mpepEditor;
    ITextEditor iteEditor = null;
    if (editor instanceof EcoreEditor) {
      IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
      IFile file = input.getFile();
      ResourceMarkerAnnotationModel rmam = new ResourceMarkerAnnotationModel(file);
      @SuppressWarnings("unchecked")
      Iterator<Annotation> iter = rmam.getAnnotationIterator();
      Annotation beRemoved = null;

      while (iter.hasNext()) {
        beRemoved = iter.next();
        if (rmam.getPosition(beRemoved).getOffset() == MarkElementUtilities.getStart(marker)
            && rmam.getPosition(beRemoved).getLength() == MarkElementUtilities.getLength(marker)) {
          rmam.removeAnnotation(beRemoved);
        }
      }
      ecEditor = (EcoreEditor) editor;
      ecEditor.getViewer().refresh();
    } else {
      if (editor instanceof ITextEditor) {
        iteEditor = (ITextEditor) editor;
      } else {
        mpepEditor = (MultiPageEditorPart) editor;
        IEditorPart[] editors = mpepEditor.findEditors(mpepEditor.getEditorInput());
        iteEditor = (ITextEditor) editors[0];
      }
      IDocumentProvider idp = iteEditor.getDocumentProvider();

      // This is the document we want to connect to. This is taken from the
      // current editor input.
      IDocument document = idp.getDocument(iteEditor.getEditorInput());

      // The IannotationModel enables to add/remove/change annoatation to a
      // Document loaded in an Editor
      IAnnotationModel iamf = idp.getAnnotationModel(iteEditor.getEditorInput());

      // Note: The annotation type id specify that you want to create one of
      // your annotations
      @SuppressWarnings("unchecked")
      Iterator<Annotation> iter = iamf.getAnnotationIterator();
      Annotation beRemoved = null;

      while (iter.hasNext()) {
        beRemoved = iter.next();
        if (iamf.getPosition(beRemoved).getOffset() == MarkElementUtilities.getStart(marker)
            && iamf.getPosition(beRemoved).getLength() == MarkElementUtilities.getLength(marker)) {
          iamf.connect(document);

          iamf.removeAnnotation(beRemoved);
          iamf.disconnect(document);
        }
      }
    }
    // Finally add the new annotation to the model
  }
}
