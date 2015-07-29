package eu.modelwriter.marker.internal;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.ui.texteditor.IMarkerUpdater;

import eu.modelwriter.marker.Serialization;

public class MarkerUpdater implements IMarkerUpdater {
  /*
   * Returns the attributes for which this updater is responsible.If the result is null, the updater
   * assumes responsibility for any attributes.
   */
  @Override
  public String[] getAttribute() {
    return null;
  }

  @Override
  public String getMarkerType() {
    // returns the marker type that we are interested in updating
    return MarkerFactory.MARKER_MARKING;
  }

  static String id = null;

  @Override
  public boolean updateMarker(IMarker marker, IDocument doc, Position position) {
    try {
      int start = position.getOffset();
      int end = position.getOffset() + position.getLength();
      marker.setAttribute(IMarker.CHAR_START, start);
      marker.setAttribute(IMarker.CHAR_END, end);

      marker.setAttribute(IMarker.TEXT, doc.get(start, position.getLength()));
      marker.setAttribute(IMarker.MESSAGE, doc.get(start, position.getLength()));
      marker.setAttribute(IMarker.LOCATION, doc.getLineOfOffset(start));

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
    try {
      if (marker.getAttribute(MarkElement.getTargetAttributeName()) != null) {
        ArrayList<MarkElement> targetElements = Serialization.getInstance() // güncellenen
                                                                            // marker
                                                                            // ın
                                                                            // targetları
                                                                            // alındı.
            .fromString((String) (marker).getAttribute(MarkElement.getTargetAttributeName()));

        for (MarkElement targetElement : targetElements) {

          IMarker targetMarker = MarkElement.getMarker(targetElement);

          if (targetMarker != null && targetMarker.exists()
              && targetMarker.getAttribute(MarkElement.getSourceAttributeName()) != null) {

            ArrayList<MarkElement> sourceElementsofTarget = Serialization.getInstance().fromString(
                (String) (targetMarker).getAttribute(MarkElement.getSourceAttributeName()));

            for (MarkElement sourceElementofTarget : sourceElementsofTarget) {
              if (sourceElementofTarget.getId().equals(marker.getAttribute(IMarker.SOURCE_ID))) {

                sourceElementofTarget.setMessage((String) marker.getAttribute(IMarker.MESSAGE));
                sourceElementofTarget
                    .setLinenumber(Integer.toString((int) marker.getAttribute(IMarker.LOCATION)));
                sourceElementofTarget.setOffset((int) marker.getAttribute(IMarker.CHAR_START));
                sourceElementofTarget.setLength(((int) marker.getAttribute(IMarker.CHAR_END))
                    - ((int) marker.getAttribute(IMarker.CHAR_START)));

              }

            }

            targetMarker.setAttribute(MarkElement.getSourceAttributeName(),
                Serialization.getInstance().toString(sourceElementsofTarget));
          }

        }
        // TargetView.setColumns(null);

      }
    } catch (ClassNotFoundException | CoreException | IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void updateSources(IMarker marker) {
    try {
      if (marker.getAttribute(MarkElement.getSourceAttributeName()) != null) {
        ArrayList<MarkElement> sourceElements = Serialization.getInstance() // güncellenen
            // marker
            // ın
            // sourceları
            // alındı.
            .fromString((String) (marker).getAttribute(MarkElement.getSourceAttributeName()));

        for (MarkElement sourceElement : sourceElements) {

          IMarker sourceMarker = MarkElement.getMarker(sourceElement);

          if (sourceMarker != null && sourceMarker.exists()
              && sourceMarker.getAttribute(MarkElement.getTargetAttributeName()) != null) {
            ArrayList<MarkElement> targetElementsofSource = Serialization.getInstance().fromString(
                (String) (sourceMarker).getAttribute(MarkElement.getTargetAttributeName()));

            for (MarkElement targetElementofSource : targetElementsofSource) {
              if (targetElementofSource.getId().equals(marker.getAttribute(IMarker.SOURCE_ID))) {

                targetElementofSource.setMessage((String) marker.getAttribute(IMarker.MESSAGE));
                targetElementofSource
                    .setLinenumber(Integer.toString((int) marker.getAttribute(IMarker.LOCATION)));
                targetElementofSource.setOffset((int) marker.getAttribute(IMarker.CHAR_START));
                targetElementofSource.setLength(((int) marker.getAttribute(IMarker.CHAR_END))
                    - ((int) marker.getAttribute(IMarker.CHAR_START)));

              }

            }

            sourceMarker.setAttribute(MarkElement.getTargetAttributeName(),
                Serialization.getInstance().toString(targetElementsofSource));
          }

        }

        // SourceView.setColumns(null);
      }
    } catch (ClassNotFoundException | CoreException | IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
