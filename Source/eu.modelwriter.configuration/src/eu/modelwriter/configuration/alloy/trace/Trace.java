package eu.modelwriter.configuration.alloy.trace;

public abstract class Trace {
  private String alias;

  public Trace(String alias) {
    setAlias(alias);
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }
}
