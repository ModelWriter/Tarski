package eu.modelwriter.marker.internal;

import java.io.Serializable;
import java.util.ArrayList;

public class MarkerTypeElement implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private String type;
  private ArrayList<MarkerTypeElement> children = new ArrayList<MarkerTypeElement>();

  public MarkerTypeElement(String type) {
    this.type = type;
  }

  public MarkerTypeElement(String type, ArrayList<MarkerTypeElement> children) {
    super();
    this.type = type;
    this.children = children;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ArrayList<MarkerTypeElement> getChildren() {
    return children;
  }

  public void setChildren(ArrayList<MarkerTypeElement> children) {
    this.children = children;
  }
}
