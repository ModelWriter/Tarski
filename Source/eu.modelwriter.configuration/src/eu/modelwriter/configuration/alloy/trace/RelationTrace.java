package eu.modelwriter.configuration.alloy.trace;

public class RelationTrace extends Trace {
  private String relationName;
  private String referenceName;
  private String className;
  private SigTrace source = null;
  private SigTrace target = null;

  public RelationTrace(String alias, String className, String relationName, String referenceName) {
    super(alias);
    this.className = className;
    this.relationName = relationName;
    this.referenceName = referenceName;
  }

  public RelationTrace(String alias, String relationName, String referenceName, SigTrace source,
      SigTrace target) {
    super(alias);
    setRelationName(relationName);
    setReferenceName(referenceName);
    setSource(source);
    setTarget(target);
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

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

}
