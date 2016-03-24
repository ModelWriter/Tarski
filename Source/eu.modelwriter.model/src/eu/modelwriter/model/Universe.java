/*******************************************************************************
 * Copyright (c) 2016 UNIT Information Technologies R&D Ltd All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ferhat Erata - initial API and implementation H. Emre Kirmizi - initial API and
 * implementation Serhat Celik - initial API and implementation U. Anil Ozturk - initial API and
 * implementation
 *******************************************************************************/
package eu.modelwriter.model;

import java.util.ArrayList;

public class Universe {
  private final ArrayList<Atom> atoms;
  private final ArrayList<Relation> relations;

  public Universe() {
    this.atoms = new ArrayList<Atom>();
    this.relations = new ArrayList<Relation>();
  }

  public void addAtom(final Atom newAtom) {
    this.atoms.add(newAtom);
  }

  public void addRelation(final Relation newRelation) {
    this.relations.add(newRelation);
  }

  public boolean contains(final Atom atom) {
    for (final Atom a : this.atoms) {
      if (a.getText().equals(atom.getText())) {
        return true;
      }
    }
    return false;
  }

  public boolean contains(final Relation relation) {
    for (final Relation r : this.relations) {
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

  public String getNextAtomText(final String current) {
    for (int i = 0; i < this.atoms.size(); i++) {
      if (this.atoms.get(i).getText().equals(current) && i + 1 < this.atoms.size()) {
        return this.atoms.get(i + 1).getText();
      }
    }
    return null;
  }

  public Relation getRelation(final String relationName) {
    for (final Relation relation : this.relations) {
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
