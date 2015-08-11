/**
 * 
 */
package eu.modelwriter.marker.internal;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;

import eu.modelwriter.marker.Serialization;

/**
 * @author Ferhat Erata
 *
 */
public class MarkElement implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  private static transient String targetAttributeName = "TARGET_MARKED_ELEMENT";
  private static transient String sourceAttributeName = "SOURCE_MARKED_ELEMENT";

  public MarkElement(IMarker iMarker) {
    try {
      id = (String) iMarker.getAttribute(IMarker.SOURCE_ID);
      offset = (int) iMarker.getAttribute(IMarker.CHAR_START);
      length = (int) iMarker.getAttribute(IMarker.CHAR_END) - offset;
      message = (String) iMarker.getAttribute(IMarker.MESSAGE);
      linenumber = Integer.toString((int) iMarker.getAttribute(IMarker.LOCATION));
      path = iMarker.getResource().getFullPath().toString();
      type = iMarker.getAttribute("MARKER_TYPE") != null
          ? (String) iMarker.getAttribute("MARKER_TYPE") : "";

    } catch (CoreException e) {
      e.printStackTrace();
    }
  }

  private String id;

  private int offset;

  private int length;

  private String message;

  private String linenumber;

  private String type;

  public String getType() {
    return type;
  }

  public String getPath() {
    return path;
  }

  private String path;

  public String getId() {
    return id;
  }

  public int getOffset() {
    return offset;
  }

  public int getLength() {
    return length;
  }

  public String getMessage() {
    return message;
  }

  public void getType(String type) {
    this.type = type;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setLinenumber(String linenumber) {
    this.linenumber = linenumber;
  }

  public String getLinenumber() {
    return linenumber;
  }

  public static String getTargetAttributeName() {
    return targetAttributeName;
  }

  public static String getSourceAttributeName() {
    return sourceAttributeName;
  }

  /**
   * @param marker
   * @return If marker has not any source returns new ArrayList, else returns list of sourceF
   *         elements
   */
  public static ArrayList<MarkElement> getSourceList(IMarker marker) {
    ArrayList<MarkElement> sourceList = new ArrayList<MarkElement>();
    try {
      if (marker.getAttribute(MarkElement.getSourceAttributeName()) != null) {
        sourceList = Serialization.getInstance()
            .fromString((String) marker.getAttribute(MarkElement.getSourceAttributeName()));
      }
    } catch (ClassNotFoundException | IOException | CoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return sourceList;
  }

  /**
   * @param marker
   * @return If marker has not any target returns new ArrayList, else returns list of target
   *         elements
   */
  public static ArrayList<MarkElement> getTargetList(IMarker marker) {
    ArrayList<MarkElement> targetList = new ArrayList<MarkElement>();
    try {
      if (marker.getAttribute(MarkElement.getTargetAttributeName()) != null) {
        targetList = Serialization.getInstance()
            .fromString((String) marker.getAttribute(MarkElement.getTargetAttributeName()));
      }
    } catch (ClassNotFoundException | IOException | CoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return targetList;
  }

  /**
   * Sets the MarkElement.getSourceAttributeName() named attribute of marker with given parameter
   * sourceList
   * 
   * @param marker
   * @param sourceList
   */
  public static void setSourceList(IMarker marker, ArrayList<MarkElement> sourceList) {
    try {
      marker.setAttribute(MarkElement.getSourceAttributeName(),
          Serialization.getInstance().toString(sourceList));
    } catch (CoreException | IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Sets the MarkElement.getTargetAttributeName() named attribute of marker with given parameter
   * targetList
   * 
   * @param marker
   * @param sourceList
   */
  public static void setTargetList(IMarker marker, ArrayList<MarkElement> targetList) {
    try {
      marker.setAttribute(MarkElement.getTargetAttributeName(),
          Serialization.getInstance().toString(targetList));
    } catch (CoreException | IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * 
   * @param markElement
   * @return markElement as {@link IMarker}
   */
  public static IMarker getiMarker(MarkElement markElement) {
    IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(markElement.getPath()));

    return MarkerFactory.findMarkerBySourceId(file, markElement.getId());
  }
}

