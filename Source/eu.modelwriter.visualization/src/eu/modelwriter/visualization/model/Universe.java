/*******************************************************************************
 * Copyright (c) 2016 UNIT Information Technologies R&D Ltd
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ferhat Erata - initial API and implementation
 *     H. Emre Kirmizi - initial API and implementation
 *     Serhat Celik - initial API and implementation
 *     U. Anil Ozturk - initial API and implementation
 *******************************************************************************/
package eu.modelwriter.visualization.model;

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

  public String getFirstAtomText() {
    return this.atoms.get(0).getText();
  }

  public String getNextAtomText(String current) {
    for (int i = 0; i < this.atoms.size(); i++) {
      if (this.atoms.get(i).getText().equals(current) && i + 1 < this.atoms.size()) {
        return this.atoms.get(i + 1).getText();
      }
    }
    return null;
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
