package eu.modelwriter.traceability.validation.core.fol.model;

import java.util.ArrayList;

public class Universe {
  private ArrayList<Atom> atoms;
  private ArrayList<Relation> relations;

  public Universe() {
    this.atoms = new ArrayList<Atom>();
    this.relations = new ArrayList<Relation>();
  }

  public void addAtom(Atom newAtom) {
    this.atoms.add(newAtom);
  }

  public void addRelation(Relation newRelation) {
    this.relations.add(newRelation);
  }

  public boolean contains(Atom atom) {
    for (Atom a : this.atoms) {
      if (a.getText().equals(atom.getText())) {
        return true;
      }
    }
    return false;
  }

  public boolean contains(Relation relation) {
    for (Relation r : this.relations) {
      if (r.getName().equals(relation.getName())) {
        return true;
      }
    }
    return false;
  }

  public ArrayList<Atom> getAtoms() {
    return this.atoms;
  }

  public Relation getRelation(String relationName) {
    for (Relation relation : this.relations) {
      if (relation.getName().equals(relationName)) {
        return relation;
      }
    }
    return null;
  }

  public ArrayList<Relation> getRelations() {
    return this.relations;
  }
}
