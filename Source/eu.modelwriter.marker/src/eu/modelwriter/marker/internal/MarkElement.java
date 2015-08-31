/**
 * 
 */
package eu.modelwriter.marker.internal;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;

/**
 * @author Ferhat Erata
 *
 */
public class MarkElement implements java.io.Serializable {

  private static final long serialVersionUID = 1L;
  private String sourceId;
  private String path;
  private Relation relation = null;

  public MarkElement(IMarker iMarker) {
    this.sourceId = MarkElementUtilities.getSourceId(iMarker);
    this.path = MarkElementUtilities.getPath(iMarker);
    this.relation = null;
  }

  /**
   * 
   * @return markElement as {@link IMarker}
   */
  public IMarker getiMarker() {
    return MarkElementUtilities.getiMarker(sourceId, path);
  }

  public Relation getRelation() {
    return relation;
  }

  public void setRelation(Relation relation) {
    this.relation = relation;
  }
}

