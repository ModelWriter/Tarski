package eu.modelwriter.marker.typing.alloy;

import java.util.ArrayList;

public class Module {

  ArrayList<Module> moduleList;
  ArrayList<Sig> sigList;
  private String moduleName;

  public Module(ArrayList<Module> moduleList, ArrayList<Sig> sigList, String moduleName) {
    super();
    this.moduleList = moduleList;
    this.sigList = sigList;
    this.moduleName = moduleName;
  }

  public Module(ArrayList<Sig> sigList, String moduleName) {
    super();
    this.sigList = sigList;
    this.moduleName = moduleName;
    this.moduleList = new ArrayList<Module>();
  }

  public Module(String moduleName) {
    super();
    this.moduleName = moduleName;
    this.moduleList = new ArrayList<Module>();
    this.sigList = new ArrayList<Sig>();
  }

  public ArrayList<Module> getModuleList() {
    return moduleList;
  }

  public void setModuleList(ArrayList<Module> moduleList) {
    this.moduleList = moduleList;
  }

  public ArrayList<Sig> getSigList() {
    return sigList;
  }

  public void setSigList(ArrayList<Sig> sigList) {
    this.sigList = sigList;
  }

  public String getModuleName() {
    return moduleName;
  }

  public void setModuleName(String moduleName) {
    this.moduleName = moduleName;
  }

  public void addSig(Sig sig) {
    this.sigList.add(sig);
  }

  public void addModule(Module module) {
    this.moduleList.add(module);
  }


}
