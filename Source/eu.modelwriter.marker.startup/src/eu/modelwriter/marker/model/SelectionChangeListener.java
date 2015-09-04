/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ferhat Erata - initial API and implementation
 *     H. Emre Kirmizi - initial API and implementation
 *     Serhat Celik - initial API and implementation
 *     U. Anil Ozturk - initial API and implementation
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

import eu.modelwriter.marker.internal.MarkElementUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.internal.MarkerUpdater;

public class SelectionChangeListener implements ISelectionChangedListener {

  private static SelectionChangeListener listener;

  public static IMarker preMarker = null;
  public static ITreeSelection preSelection = null;
  private IFile eFile;

  public void seteFile(IFile eFile) {
    this.eFile = eFile;
  }

  public SelectionChangeListener(IFile eFile) {
    this.eFile = eFile;
  }

  public static SelectionChangeListener getInstance(IFile eFile) {
    if (listener == null)
      listener = new SelectionChangeListener(eFile);
    else
      listener.seteFile(eFile);
    return listener;
  }

  @Override
  public void selectionChanged(SelectionChangedEvent event) {
    if (preMarker != null && preMarker.exists()) {
      try {
        if (event.getSelection().isEmpty()) {
          MarkerUpdater.updateTargetsToDelete(preMarker);
          MarkerUpdater.updateSourcesToDelete(preMarker);
          preMarker.delete();
        } else {
          if (preMarker.getAttribute("oldUri") == null)
            preMarker.setAttribute("oldUri", preMarker.getAttribute("uri"));

          MarkElementUtilities.setUri(preMarker,
              EcoreUtil.getURI((EObject) preSelection.getFirstElement()).toString());

          String text = null;

          if (preSelection.getFirstElement() instanceof Identifiable)
            text = MarkerFactory.reqIfToString((Identifiable) preSelection.getFirstElement());
          else if (preSelection.getFirstElement() instanceof ENamedElement)
            text = ((ENamedElement) preSelection.getFirstElement()).getName();
          else if (!(preSelection.getFirstElement() instanceof EModelElement))
            text = MarkerFactory.instanceToString((EObject) preSelection.getFirstElement());

          if (preMarker.getAttribute("oldText") == null)
            preMarker.setAttribute("oldText", MarkElementUtilities.getMessage(preMarker));

          MarkElementUtilities.setText(preMarker, text);
          MarkElementUtilities.setMessage(preMarker, text);
          // MarkerUpdater.updateTargets(preMarker);
          // MarkerUpdater.updateSources(preMarker);
          preMarker = null;
          preSelection = null;
        }
      } catch (CoreException e) {
        e.printStackTrace();
      }
    }
    if (preSelection == null || preSelection.getFirstElement() instanceof ENamedElement
        || preSelection.getFirstElement() instanceof Identifiable
        || !(preSelection.getFirstElement() instanceof EModelElement)) {
      preSelection = (ITreeSelection) event.getSelection();
      preMarker =
          MarkerFactory.findMarkerByTreeSelection((ITreeSelection) event.getSelection(), eFile);
    } else {
      preSelection = (ITreeSelection) event.getSelection();
    }
  }
}
