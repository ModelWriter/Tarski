package eu.modelwriter.visualization.model;

import java.util.ArrayList;

public class Tuple {
  private String text;
  private ArrayList<Atom> atoms;
  private int arity;

  public Tuple() {
    this.atoms = new ArrayList<Atom>();
    this.arity = 0;
  }

  public Tuple(String text) {
    this.text = text;
    this.atoms = new ArrayList<Atom>();
    this.arity = 0;
  }

  public void addAtom(Atom newAtom) {
    this.atoms.add(newAtom);
    this.arity++;
  }

  public boolean contains(Atom atom) {
    for (Atom a : this.atoms) {
      if (a.getText().equals(atom.getText())) {
        return true;
      }
    }
    return false;
  }

  public int getArity() {
    return this.arity;
  }

  public Atom getAtom(int index) {
    return this.atoms.get(index);
  }

  public int getAtomCount() {
    return this.atoms.size();
  }

  public ArrayList<Atom> getAtoms() {
    return this.atoms;
  }

  public String getText() {
    return this.text;
  }

  @Override
  public String toString() {
    String as = "";
    for (Atom atom : this.atoms) {
      as += atom.getText() + " ";
    }
    return "(" + as + ")";
  }
}
