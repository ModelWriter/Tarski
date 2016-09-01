package eu.modelwriter.configuration.alloy.trace;

public class RelationTrace extends Trace {
  private String relationName;
  private String referenceName;
  private SigTrace source;
  private SigTrace target;

  public RelationTrace(String alias, String relationName, String referenceName, SigTrace source,
      SigTrace target) {
    this.setAlias(alias);
    this.setRelationName(relationName);
    this.setReferenceName(referenceName);
    this.setSource(source);
    this.setTarget(target);
  }

  public String getRelationName() {
    return relationName;
  }

  public void setRelationName(String relationName) {
    this.relationName = relationName;
  }

  public String getReferenceName() {
    return referenceName;
  }

  public void setReferenceName(String referenceName) {
    this.referenceName = referenceName;
  }

  public SigTrace getSource() {
    return source;
  }

  public void setSource(SigTrace source) {
    this.source = source;
  }

  public SigTrace getTarget() {
    return target;
  }

  public void setTarget(SigTrace target) {
    this.target = target;
  }

}
