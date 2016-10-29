package eu.modelwriter.configuration.alloy.trace;

import org.eclipse.emf.ecore.EClass;

public class SigTrace extends Trace {
  private String sigType;
  private String className;
  private LoadItem load;
  private EClass eClass;

  public SigTrace(String alias, String sigName, String className) {
    super(alias);
    setSigType(sigName);
    setClassName(className);
  }

  public SigTrace(String alias, String sigType, String className, LoadItem load, EClass eClass) {
    super(alias);
    this.sigType = sigType;
    this.className = className;
    this.load = load;
    this.eClass = eClass;
  }

  public String getClassName() {
    return className;
  }

  public EClass getEClass() {
    return eClass;
  }

  public LoadItem getLoad() {
    return load;
  }

  public String getSigType() {
    return sigType;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public void seteClass(EClass eClass) {
    this.eClass = eClass;
  }

  public void setLoad(LoadItem load) {
    this.load = load;
  }

  public void setSigType(String sigType) {
    this.sigType = sigType;
  }

}
