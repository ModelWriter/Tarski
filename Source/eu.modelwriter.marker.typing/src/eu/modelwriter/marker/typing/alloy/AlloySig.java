package eu.modelwriter.marker.typing.alloy;

import java.util.ArrayList;

public class AlloySig {

  ArrayList<AlloyField> alloyFieldList;

  ArrayList<AlloySig> alloySigChildrenList;

  private AlloySig parentAlloySig;

  private String sigName;

  private String displayName;

  private boolean isAbstract;

  public AlloySig(ArrayList<AlloyField> alloyFieldList, String sigName, boolean isAbstract) {
    super();
    this.alloyFieldList = alloyFieldList;
    this.sigName = sigName;
    this.displayName = sigName;
    this.isAbstract = isAbstract;
    this.alloySigChildrenList = new ArrayList<AlloySig>();
  }

  public AlloySig(String sigName, boolean isAbstract) {
    super();
    this.sigName = sigName;
    this.alloyFieldList = new ArrayList<AlloyField>();
    this.displayName = sigName;
    this.isAbstract = isAbstract;
    this.alloySigChildrenList = new ArrayList<AlloySig>();
  }

  public ArrayList<AlloyField> getAlloyFieldList() {
    return alloyFieldList;
  }

  public void setAlloyFieldList(ArrayList<AlloyField> alloyFieldList) {
    this.alloyFieldList = alloyFieldList;
  }

  public String getSigName() {
    return sigName;
  }

  public void setSigName(String sigName) {
    this.sigName = sigName;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public boolean isAbstract() {
    return isAbstract;
  }

  public void setAbstract(boolean isAbstract) {
    this.isAbstract = isAbstract;
  }

  public ArrayList<AlloySig> getAlloySigChildrenList() {
    return alloySigChildrenList;
  }

  public void setAlloySigChildrenList(ArrayList<AlloySig> alloySigChildrenList) {
    this.alloySigChildrenList = alloySigChildrenList;
  }

  public AlloySig getParentAlloySig() {
    return parentAlloySig;
  }

  public void setParentAlloySig(AlloySig parentAlloySig) {
    this.parentAlloySig = parentAlloySig;
  }

  public void addChild(AlloySig child) {
    this.alloySigChildrenList.add(child);
  }

  public void addAllChildren(ArrayList<AlloySig> alloySigList) {
    this.alloySigChildrenList.addAll(alloySigList);
  }

  public void addField(AlloyField field) {
    this.alloyFieldList.add(field);
  }

}
