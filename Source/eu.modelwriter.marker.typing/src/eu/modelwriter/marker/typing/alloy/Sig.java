package eu.modelwriter.marker.typing.alloy;

import java.util.ArrayList;

public class Sig {

  ArrayList<Field> fieldList;

  private String sigName;

  private String displayName;

  public Sig(ArrayList<Field> fieldList, String sigName) {
    super();
    this.fieldList = fieldList;
    this.sigName = sigName;
    this.displayName = sigName;
  }

  public Sig(String sigName) {
    super();
    this.sigName = sigName;
    this.fieldList = new ArrayList<Field>();
    this.displayName = sigName;
  }

  public ArrayList<Field> getFields() {
    return fieldList;
  }

  public void setFields(ArrayList<Field> fields) {
    this.fieldList = fields;
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

  public void addField(Field field) {
    this.addField(field);
  }

}
