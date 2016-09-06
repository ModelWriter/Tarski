package eu.modelwriter.configuration.alloy.trace;

public class SigTrace extends Trace {
  private String sigName;
  private String className;

  public SigTrace(String alias, String sigName, String className) {
    this.setAlias(alias);
    this.setSigName(sigName);
    this.setClassName(className);
  }

  public String getSigName() {
    return sigName;
  }

  public void setSigName(String sigName) {
    this.sigName = sigName;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

}
