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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.IMarkerUpdater;
import org.eclipse.ui.texteditor.MarkerUtilities;

import eu.modelwriter.marker.MarkerActivator;

/**
 * Returns the attributes for which this updater is responsible.If the result is null, the updater
 * assumes responsibility for any attributes.
 *
 * @author anil.ozturk
 *
 */
public class MarkerUpdater implements IMarkerUpdater {

  public static void updateSources(IMarker marker) {
    if (MarkUtilities.getSourceList(marker).size() != 0) {
      ArrayList<MarkElement> sourceElements = MarkUtilities.getSourceList(marker);

      for (MarkElement sourceElement : sourceElements) {

        IMarker sourceMarker = sourceElement.getiMarker();

        if ((sourceMarker != null) && sourceMarker.exists()
            && (MarkUtilities.getTargetList(sourceMarker).size() != 0)) {
          ArrayList<MarkElement> targetElementsofSource = MarkUtilities.getTargetList(sourceMarker);

          for (MarkElement targetElementofSource : targetElementsofSource) {
            if ((targetElementofSource.getiMarker() != null)
                && MarkUtilities.compare(targetElementofSource.getiMarker(), marker)) {
              MarkUtilities.setMessage(targetElementofSource.getiMarker(),
                  MarkUtilities.getMessage(marker));
              MarkUtilities.setLinenumber(targetElementofSource.getiMarker(),
                  MarkUtilities.getLinenumber(marker));
              MarkUtilities.setStart(targetElementofSource.getiMarker(),
                  MarkUtilities.getStart(marker));
              MarkUtilities.setEnd(targetElementofSource.getiMarker(),
                  MarkUtilities.getEnd(marker));
            }
          }
          MarkUtilities.setTargetList(sourceMarker, targetElementsofSource);
        }
      }
    }
  }

  public static void updateSourcesToAllDelete(IMarker marker) {
    if (MarkUtilities.getSourceList(marker).size() != 0) {
      ArrayList<MarkElement> sourceElements = MarkUtilities.getSourceList(marker);

      for (MarkElement sourceElement : sourceElements) {

        IMarker sourceMarker = sourceElement.getiMarker();
        List<IMarker> groupSourceMarkers = new ArrayList<IMarker>();

        if (MarkUtilities.getGroupId(sourceMarker) != null) {
          groupSourceMarkers = MarkerFactory.findMarkersByGroupId(sourceMarker.getResource(),
              MarkUtilities.getGroupId(sourceMarker));
        }
        if (groupSourceMarkers.isEmpty()) {
          groupSourceMarkers.add(sourceMarker);
        }

        for (IMarker groupSourceMarker : groupSourceMarkers) {

          if (MarkUtilities.getTargetList(groupSourceMarker).size() != 0) {
            ArrayList<MarkElement> targetElementsofSource =
                MarkUtilities.getTargetList(groupSourceMarker);

            for (int i = targetElementsofSource.size() - 1; i >= 0; i--) {
              if (MarkUtilities.compare(targetElementsofSource.get(i).getiMarker(), marker)) {
                targetElementsofSource.remove(i);
              }
            }
            MarkUtilities.setTargetList(groupSourceMarker, targetElementsofSource);
          }
        }
      }
    }
  }

  public static void updateSourcesToDelete(IMarker beDeleted) {
    try {
      if (MarkUtilities.getSourceList(beDeleted).size() != 0) {
        ArrayList<MarkElement> sourceElements = MarkUtilities.getSourceList(beDeleted);

        for (MarkElement sourceElement : sourceElements) {

          IMarker sourceMarker = sourceElement.getiMarker();
          List<IMarker> groupSourceMarkers = new ArrayList<IMarker>();

          if (MarkUtilities.getGroupId(sourceMarker) != null) {
            groupSourceMarkers = MarkerFactory.findMarkersByGroupId(sourceMarker.getResource(),
                MarkUtilities.getGroupId(sourceMarker));
          }
          if (groupSourceMarkers.isEmpty()) {
            groupSourceMarkers.add(sourceMarker);
          }

          for (IMarker groupSourceMarker : groupSourceMarkers) {

            if (MarkUtilities.getTargetList(groupSourceMarker).size() != 0) {
              ArrayList<MarkElement> targetElementsofSource =
                  MarkUtilities.getTargetList(groupSourceMarker);

              for (int i = targetElementsofSource.size() - 1; i >= 0; i--) {
                if (MarkUtilities.compare(targetElementsofSource.get(i).getiMarker(), beDeleted)) {
                  targetElementsofSource.remove(i);
                }
              }
              MarkUtilities.setTargetList(groupSourceMarker, targetElementsofSource);

              if (groupSourceMarker.getType().equals(MarkerFactory.MARKER_MAPPING)
                  && (targetElementsofSource.size() == 0)) {
                IEditorPart part =
                    IDE.openEditor(MarkerActivator.getActiveWorkbenchWindow().getActivePage(),
                        groupSourceMarker, false);
                Map<String, Object> attributes = groupSourceMarker.getAttributes();
                IResource res = groupSourceMarker.getResource();
                AnnotationFactory.removeAnnotation(groupSourceMarker, part);
                groupSourceMarker.delete();
                MarkerUtilities.createMarker(res, attributes, MarkerFactory.MARKER_MARKING);
                IMarker newMarker = MarkerFactory.findMarkerBySourceId(res,
                    (String) attributes.get(IMarker.SOURCE_ID));
                AnnotationFactory.addAnnotation(newMarker, part,
                    AnnotationFactory.ANNOTATION_MARKING);
              }
            }
          }
        }
      }
    } catch (CoreException e) {
      e.printStackTrace();
    }
  }

  public static void updateTargets(IMarker marker) {
    if (MarkUtilities.getTargetList(marker).size() != 0) {
      ArrayList<MarkElement> targetElements = MarkUtilities.getTargetList(marker);

      for (MarkElement targetElement : targetElements) {

        IMarker targetMarker = targetElement.getiMarker();

        if ((targetMarker != null) && targetMarker.exists()
            && (MarkUtilities.getSourceList(targetMarker).size() != 0)) {

          ArrayList<MarkElement> sourceElementsofTarget = MarkUtilities.getSourceList(targetMarker);

          for (MarkElement sourceElementofTarget : sourceElementsofTarget) {
            if ((sourceElementofTarget.getiMarker() != null)
                && MarkUtilities.compare(sourceElementofTarget.getiMarker(), marker)) {

              MarkUtilities.setMessage(sourceElementofTarget.getiMarker(),
                  MarkUtilities.getMessage(marker));
              MarkUtilities.setLinenumber(sourceElementofTarget.getiMarker(),
                  MarkUtilities.getLinenumber(marker));
              MarkUtilities.setStart(sourceElementofTarget.getiMarker(),
                  MarkUtilities.getStart(marker));
              MarkUtilities.setEnd(sourceElementofTarget.getiMarker(),
                  MarkUtilities.getEnd(marker));
            }
          }
          MarkUtilities.setSourceList(targetMarker, sourceElementsofTarget);
        }
      }
    }
  }

  public static void updateTargetsToAllDelete(IMarker marker) {
    if (MarkUtilities.getTargetList(marker).size() != 0) {
      ArrayList<MarkElement> targetElements = MarkUtilities.getTargetList(marker);

      for (MarkElement targetElement : targetElements) {

        IMarker targetMarker = targetElement.getiMarker();

        List<IMarker> groupTargetMarkers = new ArrayList<IMarker>();

        if (MarkUtilities.getGroupId(targetMarker) != null) {
          groupTargetMarkers = MarkerFactory.findMarkersByGroupId(targetMarker.getResource(),
              MarkUtilities.getGroupId(targetMarker));
        }
        if (groupTargetMarkers.isEmpty()) {
          groupTargetMarkers.add(targetMarker);
        }

        for (IMarker groupTargetMarker : groupTargetMarkers) {

          if (MarkUtilities.getSourceList(groupTargetMarker).size() != 0) {

            ArrayList<MarkElement> sourceElementsofTarget =
                MarkUtilities.getSourceList(groupTargetMarker);

            for (int i = sourceElementsofTarget.size() - 1; i >= 0; i--) {
              if (MarkUtilities.compare(sourceElementsofTarget.get(i).getiMarker(), marker)) {
                sourceElementsofTarget.remove(i);
              }
            }
            MarkUtilities.setSourceList(groupTargetMarker, sourceElementsofTarget);
          }
        }
      }
    }
  }

  public static void updateTargetsToDelete(IMarker beDeleted) {
    if (MarkUtilities.getTargetList(beDeleted).size() != 0) {
      ArrayList<MarkElement> targetElements = MarkUtilities.getTargetList(beDeleted);

      for (MarkElement targetElement : targetElements) {

        IMarker targetMarker = targetElement.getiMarker();
        List<IMarker> groupTargetMarkers = new ArrayList<IMarker>();

        if (MarkUtilities.getGroupId(targetMarker) != null) {
          groupTargetMarkers = MarkerFactory.findMarkersByGroupId(targetMarker.getResource(),
              MarkUtilities.getGroupId(targetMarker));
        }
        if (groupTargetMarkers.isEmpty()) {
          groupTargetMarkers.add(targetMarker);
        }

        for (IMarker groupTargetMarker : groupTargetMarkers) {

          if (MarkUtilities.getSourceList(groupTargetMarker).size() != 0) {

            ArrayList<MarkElement> sourceElementsofTarget =
                MarkUtilities.getSourceList(groupTargetMarker);

            for (int i = sourceElementsofTarget.size() - 1; i >= 0; i--) {
              if (MarkUtilities.compare(sourceElementsofTarget.get(i).getiMarker(), beDeleted)) {
                sourceElementsofTarget.remove(i);
              }
            }
            MarkUtilities.setSourceList(groupTargetMarker, sourceElementsofTarget);
          }
        }
      }
    }
  }

  String markerType = MarkerFactory.MARKER_MARKING;

  @Override
  public String[] getAttribute() {
    return null;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.eclipse.ui.texteditor.IMarkerUpdater#getMarkerType()
   *
   */
  @Override
  public String getMarkerType() {
    return markerType;
  }

  @Override
  public boolean updateMarker(IMarker marker, IDocument doc, Position position) {
    try {
      markerType = marker.getType();
      int start = position.getOffset();
      int end = position.getOffset() + position.getLength();

      MarkUtilities.setStart(marker, start);
      MarkUtilities.setEnd(marker, end);
      MarkUtilities.setLinenumber(marker, doc.getLineOfOffset(start));
      MarkUtilities.setMessage(marker, doc.get(start, position.getLength()));
      MarkUtilities.setText(marker, doc.get(start, position.getLength()));

      updateTargets(marker);
      updateSources(marker);

      return true;
    } catch (CoreException | BadLocationException e) {
      return false;
    }
  }
}
