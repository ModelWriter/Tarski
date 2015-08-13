package eu.modelwriter.marker.typing.alloy;

import java.util.ArrayList;

public class AlloyModule {

  ArrayList<AlloySig> alloySigList;
  private String moduleName;

  public AlloyModule(ArrayList<AlloySig> alloySigList, String moduleName) {
    super();
    this.alloySigList = alloySigList;
    this.moduleName = moduleName;
  }

  public AlloyModule(String moduleName) {
    super();
    this.moduleName = moduleName;
    this.alloySigList = new ArrayList<AlloySig>();
  }

  public ArrayList<AlloySig> getSigList() {
    return alloySigList;
  }

  public void setSigList(ArrayList<AlloySig> alloySigList) {
    this.alloySigList = alloySigList;
  }

  public String getModuleName() {
    return moduleName;
  }

  public void setModuleName(String moduleName) {
    this.moduleName = moduleName;
  }

  public void addSig(AlloySig alloySig) {
    this.alloySigList.add(alloySig);
  }

}
