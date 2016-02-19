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
package eu.modelwriter.kodkod.core.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

  public boolean fullyEqual(final Relation rel1, final Relation rel2) {
    if (!rel1.getName().equals(rel2.getName())) {
      return false;
    }

    final List<Tuple> tuples1 = rel1.getTuples();
    final List<Tuple> tuples2 = rel2.getTuples();
    if (tuples1.size() != tuples2.size()) {
      return false;
    }
    for (int i = 0; i < tuples1.size(); i++) {
      if (!tuples1.get(i).equals(tuples2.get(i))) {
        return false;
      }
    }

    // final List<List<Relation>> types1 = rel1.getTypes();
    // final List<List<Relation>> types2 = rel2.getTypes();
    // if (types1.size() != types2.size()) {
    // return false;
    // }
    // for (int i = 0; i < types1.size(); i++) {
    // if (!types1.get(i).equals(types2.get(i))) {
    // return false;
    // }
    //
    // final List<Relation> list1 = types1.get(i);
    // final List<Relation> list2 = types2.get(i);
    // if (list1.size() != list2.size()) {
    // return false;
    // }
    // for (int j = 0; j < list1.size(); j++) {
    // if (!list1.get(i).equals(list2.get(i))) {
    // return false;
    // }
    // }
    // }
    return true;
  }

  public Atom getAtom(final String name) {
    for (final Atom atom : this.getAtoms()) {
      if (atom.getText().equals(name)) {
        return atom;
      }
    }
    return null;
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

  public void removeRelation(final Relation relation) {
    for (@SuppressWarnings("rawtypes")
    final Iterator iterator = this.relations.iterator(); iterator.hasNext();) {
      final Relation iterRel = (Relation) iterator.next();
      if (iterRel.equals(relation)) {
        iterator.remove();
      }
    }
  }
}
