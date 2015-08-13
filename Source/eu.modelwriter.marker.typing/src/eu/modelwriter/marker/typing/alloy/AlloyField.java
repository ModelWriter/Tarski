package eu.modelwriter.marker.typing.alloy;

public class AlloyField {

  private String relation;
  private String displayRelation;
  private String relatedType;
  private String displayRelatedType;
  private String opName;

  public AlloyField(String relation, String relatedType, String opName) {
    super();
    this.relation = relation;
    this.relatedType = relatedType;
    this.opName = opName;
    this.displayRelation = relation;
    this.displayRelatedType = relatedType;
  }

  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }

  public String getRelatedType() {
    return relatedType;
  }

  public void setRelatedType(String relatedType) {
    this.relatedType = relatedType;
  }

  public String getDisplayRelation() {
    return displayRelation;
  }

  public void setDisplayRelation(String displayRelation) {
    this.displayRelation = displayRelation;
  }

  public String getDisplayRelatedType() {
    return displayRelatedType;
  }

  public void setDisplayRelatedType(String displayRelatedType) {
    this.displayRelatedType = displayRelatedType;
  }

  public String getOpName() {
    return opName;
  }

  public void setOpName(String opName) {
    this.opName = opName;
  }

}
