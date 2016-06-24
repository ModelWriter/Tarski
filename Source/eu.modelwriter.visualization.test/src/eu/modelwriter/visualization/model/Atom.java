package eu.modelwriter.visualization.model;

public class Atom {

  private final String text;

  private Relation locatedIn;

  public Atom(final String text) {
    this.text = text;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }

    return this.getText().equals(((Atom) obj).getText());
  }

  public Relation getLocatedIn() {
    return this.locatedIn;
  }

  public String getText() {
    return this.text;
  }

  public void setLocatedIn(final Relation locatedIn) {
    this.locatedIn = locatedIn;
  }

}
