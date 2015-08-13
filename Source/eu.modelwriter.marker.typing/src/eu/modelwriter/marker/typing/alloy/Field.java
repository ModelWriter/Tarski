package eu.modelwriter.marker.typing.alloy;

public class Field {

  private String relation;
  private String displayRelation;
  private Sig relatedType;
  private String displayRelatedType;
  private String opName;

  public Field(String relation, Sig relatedType, String opName) {
    super();
    this.relation = relation;
    this.relatedType = relatedType;
    this.opName = opName;
    this.displayRelation = relation;
    this.displayRelatedType = relatedType.getDisplayName();
  }

  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }

  public Sig getRelatedType() {
    return relatedType;
  }

  public void setRelatedType(Sig relatedType) {
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
