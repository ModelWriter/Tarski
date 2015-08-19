/**
 * 
 */
package eu.modelwriter.marker.internal;

import org.eclipse.core.resources.IMarker;

/**
 * @author Ferhat Erata
 *
 */
public class MarkElement implements java.io.Serializable {

  private static final long serialVersionUID = 1L;
  private String sourceId;
  private String path;

  public MarkElement(IMarker iMarker) {
    this.sourceId = MarkElementUtilities.getSourceId(iMarker);
    this.path = MarkElementUtilities.getPath(iMarker);
  }

  /**
   * 
   * @return markElement as {@link IMarker}
   */
  public IMarker getiMarker() {
    return MarkElementUtilities.getiMarker(sourceId, path);
  }
}

