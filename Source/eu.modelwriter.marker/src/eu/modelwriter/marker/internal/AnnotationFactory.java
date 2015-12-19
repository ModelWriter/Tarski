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

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.swt.SWTException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;
import org.eclipse.ui.texteditor.SimpleMarkerAnnotation;

public class AnnotationFactory {

  public static final String ANNOTATION_MAPPING = "eu.modelwriter.marker.annotation.mapping";
  // Annotation IDs
  public static final String ANNOTATION_MARKING = "eu.modelwriter.marker.annotation.marking";

  // TODO selection
  public static void addAnnotation(final IMarker marker, final String annotationType) {
    // The DocumentProvider enables to get the document currently loaded in
    // the editor
    try {
      if (marker == null) {
        // final MessageDialog dialog = new MessageDialog(new Shell(),
        // "There is not exist marker to change annotation. (Marker is null)!", null,
        // "Please check .modelwriter/persistence.xml file", MessageDialog.INFORMATION,
        // new String[] {"OK"}, 0);
        // dialog.open();
        return;
      }

      final IEditorPart editor = MarkerFactory.getOpenEditorOfMarker(marker);

      if (editor == null) {
        // final MessageDialog dialog =
        // new MessageDialog(new Shell(), "There is no editor to refresh. (Editor is null)!", null,
        // "Please make sure about source marker's editor is open", MessageDialog.INFORMATION,
        // new String[] {"OK"}, 0);
        // dialog.open();
        return;
      }

      int start;
      start = MarkUtilities.getStart(marker);
      final int length = MarkUtilities.getLength(marker);
      EcoreEditor ecEditor;
      MultiPageEditorPart mpepEditor;
      ITextEditor iteEditor = null;
      if (editor instanceof EcoreEditor) {
        final IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
        final IFile file = input.getFile();
        final ResourceMarkerAnnotationModel rmam = new ResourceMarkerAnnotationModel(file);
        final SimpleMarkerAnnotation ma = new SimpleMarkerAnnotation(annotationType, marker);
        rmam.addAnnotation(ma, new Position(start, length));

        ecEditor = (EcoreEditor) editor;
        ecEditor.getViewer().refresh();
      } else {
        if (editor instanceof ITextEditor) {
          iteEditor = (ITextEditor) editor;
        } else {
          mpepEditor = (MultiPageEditorPart) editor;
          final IEditorPart[] editors = mpepEditor.findEditors(mpepEditor.getEditorInput());
          iteEditor = (ITextEditor) editors[0];
        }
        final IDocumentProvider idp = iteEditor.getDocumentProvider();
        // This is the document we want to connect to. This is taken from the
        // current editor input.
        final IDocument document = idp.getDocument(iteEditor.getEditorInput());

        // The IannotationModel enables to add/remove/change annoatation to a
        // Document loaded in an Editor
        final IAnnotationModel iamf = idp.getAnnotationModel(iteEditor.getEditorInput());

        // Note: The annotation type id specify that you want to create one of
        // your annotations
        final SimpleMarkerAnnotation ma = new SimpleMarkerAnnotation(annotationType, marker);

        // Finally add the new annotation to the model
        iamf.connect(document);
        iamf.addAnnotation(ma, new Position(start, length));
        iamf.disconnect(document);
        // idp.resetDocument(iteEditor.getEditorInput());
      }
    } catch (final Exception e) {
      e.printStackTrace();
    }
  }

  public static void removeAnnotation(final IMarker marker) {
    // The DocumentProvider enables to get the document currently loaded in
    // the editor
    if (marker == null) {
      // final MessageDialog dialog = new MessageDialog(new Shell(),
      // "There is not exist marker to change annotation. (Marker is null)!", null,
      // "Please check .modelwriter/persistence.xml file", MessageDialog.INFORMATION,
      // new String[] {"OK"}, 0);
      // dialog.open();
      return;
    }

    final IEditorPart editor = MarkerFactory.getOpenEditorOfMarker(marker);

    if (editor == null) {
      // final MessageDialog dialog =
      // new MessageDialog(new Shell(), "There is no editor to refresh. (Editor is null)!", null,
      // "Please make sure about source marker's editor is open", MessageDialog.INFORMATION,
      // new String[] {"OK"}, 0);
      // dialog.open();
      return;
    }

    EcoreEditor ecEditor;
    MultiPageEditorPart mpepEditor;
    ITextEditor iteEditor = null;

    if (editor instanceof EcoreEditor) {
      final IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
      final IFile file = input.getFile();
      final ResourceMarkerAnnotationModel rmam = new ResourceMarkerAnnotationModel(file);
      @SuppressWarnings("unchecked")
      final Iterator<Annotation> iter = rmam.getAnnotationIterator();
      Annotation beRemoved = null;

      while (iter.hasNext()) {
        beRemoved = iter.next();
        if (rmam.getPosition(beRemoved).getOffset() == MarkUtilities.getStart(marker)
            && rmam.getPosition(beRemoved).getLength() == MarkUtilities.getLength(marker)) {
          rmam.removeAnnotation(beRemoved);
        }
      }
      ecEditor = (EcoreEditor) editor;
      try {
        ecEditor.getViewer().refresh();
      } catch (final SWTException e) {
        e.printStackTrace();
      }
    } else {
      if (editor instanceof ITextEditor) {
        iteEditor = (ITextEditor) editor;
      } else {
        mpepEditor = (MultiPageEditorPart) editor;
        final IEditorPart[] editors = mpepEditor.findEditors(mpepEditor.getEditorInput());
        iteEditor = (ITextEditor) editors[0];
      }
      final IDocumentProvider idp = iteEditor.getDocumentProvider();

      // This is the document we want to connect to. This is taken from the
      // current editor input.
      final IDocument document = idp.getDocument(iteEditor.getEditorInput());

      // The IannotationModel enables to add/remove/change annoatation to a
      // Document loaded in an Editor
      final IAnnotationModel iamf = idp.getAnnotationModel(iteEditor.getEditorInput());

      // Note: The annotation type id specify that you want to create one of
      // your annotations
      @SuppressWarnings("unchecked")
      final Iterator<Annotation> iter = iamf.getAnnotationIterator();
      Annotation beRemoved = null;

      while (iter.hasNext()) {
        beRemoved = iter.next();
        if (iamf.getPosition(beRemoved).getOffset() == MarkUtilities.getStart(marker)
            && iamf.getPosition(beRemoved).getLength() == MarkUtilities.getLength(marker)) {
          iamf.connect(document);
          iamf.removeAnnotation(beRemoved);
          iamf.disconnect(document);
        }
      }
    }
    // Finally add the new annotation to the model
  }
}
