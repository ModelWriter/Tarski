package eu.modelwriter.traceability.validation.core.fol.model;

import java.util.ArrayList;

public class Tuple {
  private String text;
  private ArrayList<Atom> atoms;

  public Tuple(String text) {
    this.text = text;
    this.atoms = new ArrayList<Atom>();
  }

  public void addAtom(Atom newAtom) {
    this.atoms.add(newAtom);
  }

  public boolean contains(Atom atom) {
    for (Atom a : this.atoms) {
      if (a.getText().equals(atom.getText())) {
        return true;
      }
    }
    return false;
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
}
