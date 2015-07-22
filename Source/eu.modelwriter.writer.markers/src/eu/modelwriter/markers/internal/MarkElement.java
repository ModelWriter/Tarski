/**
 * 
 */
package eu.modelwriter.markers.internal;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;

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

    } catch (CoreException e) {
      e.printStackTrace();
    }
  }

  private String id;

  private int offset;

  private int length;

  private String message;

  private String linenumber;

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

  // public boolean compareWith(IMarker compareWith) {
  // return this.id == Long.toString(compareWith.getId());
  // }

  public static IMarker getMarker(MarkElement markElement) {
    IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(markElement.getPath()));

    return MarkerFactory.findMarkerByOffset(file, markElement.getOffset());
  }

}
