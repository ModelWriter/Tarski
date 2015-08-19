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

public class MarkerUpdater implements IMarkerUpdater {
  /*
   * Returns the attributes for which this updater is responsible.If the result is null, the updater
   * assumes responsibility for any attributes.
   */
  String markerType = MarkerFactory.MARKER_MARKING;

  @Override
  public String[] getAttribute() {
    return null;
  }

  @Override
  public String getMarkerType() {
    // returns the marker type that we are interested in updating
    return markerType;
  }

  static String id = null;

  @Override
  public boolean updateMarker(IMarker marker, IDocument doc, Position position) {
    try {
      markerType = marker.getType();
      int start = position.getOffset();
      int end = position.getOffset() + position.getLength();

      MarkElementUtilities.setStart(marker, start);
      MarkElementUtilities.setEnd(marker, end);
      MarkElementUtilities.setLinenumber(marker, doc.getLineOfOffset(start));
      MarkElementUtilities.setMessage(marker, doc.get(start, position.getLength()));
      MarkElementUtilities.setText(marker, doc.get(start, position.getLength()));

      updateTargets(marker);
      updateSources(marker);

      // if (marker.getAttribute(MarkElement.getTargetAttributeName()) != null) {
      // ArrayList<MarkElement> targetElements = Serialization.getInstance() // güncellenen
      // // marker
      // // ın
      // // targetları
      // // alındı.
      // .fromString((String) (marker).getAttribute(MarkElement.getTargetAttributeName()));
      //
      // for (MarkElement targetElement : targetElements) {
      //
      // IMarker targetMarker = MarkElement.getMarker(targetElement);
      //
      // if (targetMarker.getAttribute(MarkElement.getSourceAttributeName()) != null) {
      //
      // ArrayList<MarkElement> sourceElementsofTarget =
      // Serialization.getInstance().fromString(
      // (String) (targetMarker).getAttribute(MarkElement.getSourceAttributeName()));
      //
      // for (MarkElement sourceElementofTarget : sourceElementsofTarget) {
      // if (sourceElementofTarget.getId().equals(marker.getAttribute(IMarker.SOURCE_ID))) {
      //
      // sourceElementofTarget.setMessage((String) marker.getAttribute(IMarker.MESSAGE));
      // sourceElementofTarget
      // .setLinenumber(Integer.toString((int) marker.getAttribute(IMarker.LOCATION)));
      // sourceElementofTarget.setOffset(start);
      // sourceElementofTarget.setLength(position.getLength());
      //
      // }
      //
      // }
      //
      // targetMarker.setAttribute(MarkElement.getSourceAttributeName(),
      // Serialization.getInstance().toString(sourceElementsofTarget));
      // }
      //
      // }
      // // TargetView.setColumns(null);
      //
      // }
      // /////////////////////////////////
      //
      // if (marker.getAttribute(MarkElement.getSourceAttributeName()) != null) {
      // ArrayList<MarkElement> sourceElements = Serialization.getInstance() // güncellenen
      // // marker
      // // ın
      // // sourceları
      // // alındı.
      // .fromString((String) (marker).getAttribute(MarkElement.getSourceAttributeName()));
      //
      // for (MarkElement sourceElement : sourceElements) {
      //
      // IMarker sourceMarker = MarkElement.getMarker(sourceElement);
      //
      // if (sourceMarker.getAttribute(MarkElement.getTargetAttributeName()) != null) {
      // ArrayList<MarkElement> targetElementsofSource =
      // Serialization.getInstance().fromString(
      // (String) (sourceMarker).getAttribute(MarkElement.getTargetAttributeName()));
      //
      // for (MarkElement targetElementofSource : targetElementsofSource) {
      // if (targetElementofSource.getId().equals(marker.getAttribute(IMarker.SOURCE_ID))) {
      //
      // targetElementofSource.setMessage((String) marker.getAttribute(IMarker.MESSAGE));
      // targetElementofSource
      // .setLinenumber(Integer.toString((int) marker.getAttribute(IMarker.LOCATION)));
      // targetElementofSource.setOffset(start);
      // targetElementofSource.setLength(position.getLength());
      //
      // }
      //
      // }
      //
      // sourceMarker.setAttribute(MarkElement.getTargetAttributeName(),
      // Serialization.getInstance().toString(targetElementsofSource));
      // }
      //
      // }
      //
      // // SourceView.setColumns(null);
      // }
      //
      // } catch (BadLocationException e) {
      // // TODO Auto-generated catch block
      // e.printStackTrace();
      // } catch (ClassNotFoundException e) {
      // // TODO Auto-generated catch block
      // e.printStackTrace();
      // } catch (IOException e) {
      // // TODO Auto-generated catch block
      // e.printStackTrace();
      // }

      return true;
    } catch (CoreException | BadLocationException e) {
      return false;
    }


  }

  public static void updateTargets(IMarker marker) {
    if (MarkElementUtilities.getTargetList(marker) != null) {
      ArrayList<MarkElement> targetElements = MarkElementUtilities.getTargetList(marker);

      for (MarkElement targetElement : targetElements) {

        IMarker targetMarker = targetElement.getiMarker();

        if (targetMarker != null && targetMarker.exists()
            && MarkElementUtilities.getSourceList(targetMarker) != null) {

          ArrayList<MarkElement> sourceElementsofTarget =
              MarkElementUtilities.getSourceList(targetMarker);

          for (MarkElement sourceElementofTarget : sourceElementsofTarget) {
            if (MarkElementUtilities.getSourceId(sourceElementofTarget.getiMarker())
                .equals(MarkElementUtilities.getSourceId(marker))) {

              MarkElementUtilities.setMessage(sourceElementofTarget.getiMarker(),
                  MarkElementUtilities.getMessage(marker));
              MarkElementUtilities.setLinenumber(sourceElementofTarget.getiMarker(),
                  MarkElementUtilities.getLinenumber(marker));
              MarkElementUtilities.setStart(sourceElementofTarget.getiMarker(),
                  MarkElementUtilities.getStart(marker));
              MarkElementUtilities.setEnd(sourceElementofTarget.getiMarker(),
                  MarkElementUtilities.getEnd(marker));
            }
          }
          MarkElementUtilities.setSourceList(targetMarker, sourceElementsofTarget);
        }
      }
      // TargetView.setColumns(null);
    }
  }

  public static void updateSources(IMarker marker) {
    if (MarkElementUtilities.getSourceList(marker) != null) {
      ArrayList<MarkElement> sourceElements = MarkElementUtilities.getSourceList(marker);

      for (MarkElement sourceElement : sourceElements) {

        IMarker sourceMarker = sourceElement.getiMarker();

        if (sourceMarker != null && sourceMarker.exists()
            && MarkElementUtilities.getTargetList(sourceMarker) != null) {
          ArrayList<MarkElement> targetElementsofSource =
              MarkElementUtilities.getTargetList(sourceMarker);

          for (MarkElement targetElementofSource : targetElementsofSource) {
            if (MarkElementUtilities.getSourceId(targetElementofSource.getiMarker())
                .equals(MarkElementUtilities.getSourceId(marker))) {
              MarkElementUtilities.setMessage(targetElementofSource.getiMarker(),
                  MarkElementUtilities.getMessage(marker));
              MarkElementUtilities.setLinenumber(targetElementofSource.getiMarker(),
                  MarkElementUtilities.getLinenumber(marker));
              MarkElementUtilities.setStart(targetElementofSource.getiMarker(),
                  MarkElementUtilities.getStart(marker));
              MarkElementUtilities.setEnd(targetElementofSource.getiMarker(),
                  MarkElementUtilities.getEnd(marker));
            }
          }
          MarkElementUtilities.setTargetList(sourceMarker, targetElementsofSource);
        }
      }
      // SourceView.setColumns(null);
    }

  }


  public static void updateTargetsToDelete(IMarker beDeleted) {
    if (MarkElementUtilities.getTargetList(beDeleted) != null) {
      ArrayList<MarkElement> targetElements = MarkElementUtilities.getTargetList(beDeleted);

      for (MarkElement targetElement : targetElements) {

        IMarker targetMarker = targetElement.getiMarker();
        List<IMarker> groupTargetMarkers = new ArrayList<IMarker>();

        if (MarkElementUtilities.getGroupId(targetMarker) != null) {
          groupTargetMarkers = MarkerFactory.findMarkersByGroupId(targetMarker.getResource(),
              MarkElementUtilities.getGroupId(targetMarker));
        }
        if (groupTargetMarkers.isEmpty())
          groupTargetMarkers.add(targetMarker);

        for (IMarker groupTargetMarker : groupTargetMarkers) {

          if (MarkElementUtilities.getSourceList(groupTargetMarker) != null) {

            ArrayList<MarkElement> sourceElementsofTarget =
                MarkElementUtilities.getSourceList(groupTargetMarker);

            for (int i = sourceElementsofTarget.size() - 1; i >= 0; i--) {
              if (MarkElementUtilities.getSourceId(sourceElementsofTarget.get(i).getiMarker())
                  .equals(MarkElementUtilities.getSourceId(beDeleted))) {
                sourceElementsofTarget.remove(i);
              }
            }

            MarkElementUtilities.setSourceList(groupTargetMarker, sourceElementsofTarget);
          }
        }
      }
      // TargetView.setColumns(null);
    }
  }

  public static void updateSourcesToDelete(IMarker beDeleted) {
    try {
      if (MarkElementUtilities.getSourceList(beDeleted) != null) {
        ArrayList<MarkElement> sourceElements = MarkElementUtilities.getSourceList(beDeleted);

        for (MarkElement sourceElement : sourceElements) {

          IMarker sourceMarker = sourceElement.getiMarker();
          List<IMarker> groupSourceMarkers = new ArrayList<IMarker>();

          if (MarkElementUtilities.getGroupId(sourceMarker) != null) {
            groupSourceMarkers = MarkerFactory.findMarkersByGroupId(sourceMarker.getResource(),
                MarkElementUtilities.getGroupId(sourceMarker));
          }
          if (groupSourceMarkers.isEmpty())
            groupSourceMarkers.add(sourceMarker);

          for (IMarker groupSourceMarker : groupSourceMarkers) {

            if (MarkElementUtilities.getTargetList(groupSourceMarker) != null) {
              ArrayList<MarkElement> targetElementsofSource =
                  MarkElementUtilities.getTargetList(groupSourceMarker);

              for (int i = targetElementsofSource.size() - 1; i >= 0; i--) {
                if (MarkElementUtilities.getSourceId(targetElementsofSource.get(i).getiMarker())
                    .equals(MarkElementUtilities.getSourceId(beDeleted)))
                  targetElementsofSource.remove(i);
              }

              MarkElementUtilities.setTargetList(groupSourceMarker, targetElementsofSource);

              if (groupSourceMarker.getType().equals(MarkerFactory.MARKER_MAPPING)
                  && targetElementsofSource.size() == 0) {
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
        // SourceView.setColumns(null);
      }
    } catch (CoreException e) {
      e.printStackTrace();
    }
  }



  public static void updateTargetsToAllDelete(IMarker marker) {
    if (MarkElementUtilities.getTargetList(marker) != null) {
      ArrayList<MarkElement> targetElements = MarkElementUtilities.getTargetList(marker);

      for (MarkElement targetElement : targetElements) {

        IMarker targetMarker = targetElement.getiMarker();

        List<IMarker> groupTargetMarkers = new ArrayList<IMarker>();

        if (MarkElementUtilities.getGroupId(targetMarker) != null) {
          groupTargetMarkers = MarkerFactory.findMarkersByGroupId(targetMarker.getResource(),
              MarkElementUtilities.getGroupId(targetMarker));
        }
        if (groupTargetMarkers.isEmpty())
          groupTargetMarkers.add(targetMarker);

        for (IMarker groupTargetMarker : groupTargetMarkers) {

          if (MarkElementUtilities.getSourceList(groupTargetMarker) != null) {

            ArrayList<MarkElement> sourceElementsofTarget =
                MarkElementUtilities.getSourceList(groupTargetMarker);

            for (int i = sourceElementsofTarget.size() - 1; i >= 0; i--) {
              if (MarkElementUtilities.getSourceId(sourceElementsofTarget.get(i).getiMarker())
                  .equals(MarkElementUtilities.getSourceId(marker)))
                sourceElementsofTarget.remove(i);
            }

            MarkElementUtilities.setSourceList(groupTargetMarker, sourceElementsofTarget);
          }
        }
      }
      // TargetView.setColumns(null);
    }
  }

  public static void updateSourcesToAllDelete(IMarker marker) {
    if (MarkElementUtilities.getSourceList(marker) != null) {
      ArrayList<MarkElement> sourceElements = MarkElementUtilities.getSourceList(marker);

      for (MarkElement sourceElement : sourceElements) {

        IMarker sourceMarker = sourceElement.getiMarker();
        List<IMarker> groupSourceMarkers = new ArrayList<IMarker>();

        if (MarkElementUtilities.getGroupId(sourceMarker) != null) {
          groupSourceMarkers = MarkerFactory.findMarkersByGroupId(sourceMarker.getResource(),
              MarkElementUtilities.getGroupId(sourceMarker));
        }
        if (groupSourceMarkers.isEmpty())
          groupSourceMarkers.add(sourceMarker);

        for (IMarker groupSourceMarker : groupSourceMarkers) {

          if (MarkElementUtilities.getTargetList(groupSourceMarker) != null) {
            ArrayList<MarkElement> targetElementsofSource =
                MarkElementUtilities.getTargetList(groupSourceMarker);

            for (int i = targetElementsofSource.size() - 1; i >= 0; i--) {
              if (MarkElementUtilities.getSourceId(targetElementsofSource.get(i).getiMarker())
                  .equals(MarkElementUtilities.getSourceId(marker)))
                targetElementsofSource.remove(i);
            }

            MarkElementUtilities.setTargetList(groupSourceMarker, targetElementsofSource);
          }
        }
      }
      // SourceView.setColumns(null);
    }
  }



}
