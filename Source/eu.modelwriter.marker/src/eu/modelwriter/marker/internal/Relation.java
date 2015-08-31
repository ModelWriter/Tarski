package eu.modelwriter.marker.internal;

import java.util.ArrayList;

public class Relation implements java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private String rel;
  private String fromType;
  private String ofType;
  private String toType;

  public Relation(String rel, String fromType, String ofType, String toType) {
    super();
    this.rel = rel;
    this.fromType = fromType;
    this.ofType = ofType;
    this.toType = toType;
  }

  public String getRel() {
    return rel;
  }

  public void setRel(String rel) {
    this.rel = rel;
  }

  public String getFromType() {
    return fromType;
  }

  public void setFromType(String fromType) {
    this.fromType = fromType;
  }

  public String getOfType() {
    return ofType;
  }

  public void setOfType(String ofType) {
    this.ofType = ofType;
  }

  public String getToType() {
    return toType;
  }

  public void setToType(String toType) {
    this.toType = toType;
  }

  @Override
  public String toString() {
    return rel + " : " + fromType + " -> " + ofType + " " + toType;
  }

  public static ArrayList<String> relationStringList(ArrayList<Relation> rels) {
    ArrayList<String> relationList = new ArrayList<String>();

    for (Relation rel : rels) {
      relationList.add(rel.toString());
    }

    return relationList;
  }

  public static Relation stringToRelation(String relation) {
    String rel = relation.substring(0, relation.indexOf(":") - 1);
    String fromType = relation.substring(relation.indexOf(":") + 2, relation.indexOf("->") - 1);
    String ofType = relation.substring(relation.indexOf("->") + 3, relation.lastIndexOf("of ") + 2);
    String toType = relation.substring(relation.lastIndexOf("of ") + 3);

    return new Relation(rel, fromType, ofType, toType);

  }

}
