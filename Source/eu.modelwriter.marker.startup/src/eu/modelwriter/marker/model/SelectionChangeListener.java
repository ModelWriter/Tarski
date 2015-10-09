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
package eu.modelwriter.marker.model;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.rmf.reqif10.Identifiable;

import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class SelectionChangeListener implements ISelectionChangedListener {

  private static SelectionChangeListener listener;

  public static IMarker preMarker = null;
  public static ITreeSelection preSelection = null;

  public static SelectionChangeListener getInstance(IFile eFile) {
    if (SelectionChangeListener.listener == null) {
      SelectionChangeListener.listener = new SelectionChangeListener(eFile);
    } else {
      SelectionChangeListener.listener.seteFile(eFile);
    }
    return SelectionChangeListener.listener;
  }

  private IFile eFile;

  public SelectionChangeListener(IFile eFile) {
    this.eFile = eFile;
  }

  @Override
  public void selectionChanged(SelectionChangedEvent event) {
    if ((SelectionChangeListener.preMarker != null) && SelectionChangeListener.preMarker.exists()) {
      try {
        if (event.getSelection().isEmpty()) {
          // Deleting marker for element removed.
          SelectionChangeListener.preMarker.delete();
        } else {
          if (SelectionChangeListener.preMarker.getAttribute("oldUri") == null) {
            // Saving Uri of marker which before change
            SelectionChangeListener.preMarker.setAttribute("oldUri",
                SelectionChangeListener.preMarker.getAttribute("uri"));
          }

          // Updating Uri of Marker
          MarkUtilities.setUri(SelectionChangeListener.preMarker, EcoreUtil
              .getURI((EObject) SelectionChangeListener.preSelection.getFirstElement()).toString());

          String text = null;

          // According to selected element, setting the text.
          if (SelectionChangeListener.preSelection.getFirstElement() instanceof Identifiable) {
            text = MarkerFactory.reqIfToString(
                (Identifiable) SelectionChangeListener.preSelection.getFirstElement());
          } else
            if (SelectionChangeListener.preSelection.getFirstElement() instanceof ENamedElement) {
            text =
                ((ENamedElement) SelectionChangeListener.preSelection.getFirstElement()).getName();
          } else if (!(SelectionChangeListener.preSelection
              .getFirstElement() instanceof EModelElement)) {
            text = MarkerFactory
                .instanceToString((EObject) SelectionChangeListener.preSelection.getFirstElement());
          }

          // Saving text of marker which before change
          if (SelectionChangeListener.preMarker.getAttribute("oldText") == null) {
            SelectionChangeListener.preMarker.setAttribute("oldText",
                MarkUtilities.getText(SelectionChangeListener.preMarker));
          }

          // Updating marker text.
          MarkUtilities.setText(SelectionChangeListener.preMarker, text);

          SelectionChangeListener.preMarker = null;
          SelectionChangeListener.preSelection = null;
        }
      } catch (CoreException e) {
        e.printStackTrace();
      }
    }
    if ((SelectionChangeListener.preSelection == null)
        || (SelectionChangeListener.preSelection.getFirstElement() instanceof ENamedElement)
        || (SelectionChangeListener.preSelection.getFirstElement() instanceof Identifiable)
        || !(SelectionChangeListener.preSelection.getFirstElement() instanceof EModelElement)) {
      SelectionChangeListener.preSelection = (ITreeSelection) event.getSelection();
      SelectionChangeListener.preMarker = MarkerFactory
          .findMarkerByTreeSelection((ITreeSelection) event.getSelection(), this.eFile);
    } else {
      SelectionChangeListener.preSelection = (ITreeSelection) event.getSelection();
    }
  }

  public void seteFile(IFile eFile) {
    this.eFile = eFile;
  }
}
