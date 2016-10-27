package eu.modelwriter.configuration.alloy.trace;

public class SigTrace extends Trace {
  private String sigType;
  private String className;

  public SigTrace(String alias, String sigName, String className) {
    super(alias);
    setSigType(sigName);
    setClassName(className);
  }

  public String getSigType() {
    return sigType;
  }

  public void setSigType(String sigType) {
    this.sigType = sigType;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

}
