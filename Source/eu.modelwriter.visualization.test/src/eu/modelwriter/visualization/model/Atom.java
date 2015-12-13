package eu.modelwriter.visualization.model;

public class Atom {
  private String text;
  private Relation locatedIn;

  public Atom(String text) {
    this.text = text;
  }

  public String getText() {
    return this.text;
  }

  public Relation getLocatedIn() {
    return locatedIn;
  }

  public void setLocatedIn(Relation locatedIn) {
    this.locatedIn = locatedIn;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (obj == this)
      return true;

    return this.getText().equals(((Atom) obj).getText());
  }

}
