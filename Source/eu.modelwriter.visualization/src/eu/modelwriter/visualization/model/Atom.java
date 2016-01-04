package eu.modelwriter.visualization.model;

import java.io.Serializable;

public class Atom {
  private String text;
  private Serializable data;
  private String id;

  public Atom(String text) {
    this.text = text;
  }

  public String getText() {
    return this.text;
  }

  public Serializable getData() {
    return data;
  }

  public void setData(Serializable data) {
    this.data = data;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

}
