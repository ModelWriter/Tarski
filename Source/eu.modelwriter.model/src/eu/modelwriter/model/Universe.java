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
  public final static String SET_UNIV = "UNIV";
  private final ArrayList<Atom> strayedAtoms;
  private final ArrayList<Tuple> strayedTuples;
  private final ArrayList<Relation> relations;

  protected Universe() {
    this.strayedAtoms = new ArrayList<Atom>();
    this.strayedTuples = new ArrayList<Tuple>();
    this.relations = new ArrayList<Relation>();
  }

  protected void addRelation(final Relation newRelation) {
    this.relations.add(newRelation);
  }

  protected void addStrayedAtom(final Atom strayedAtom) {
    this.strayedAtoms.add(strayedAtom);
  }

  protected void addStrayedTuple(final Tuple strayedTuple) {
    this.strayedTuples.add(strayedTuple);
  }

  public boolean contains(final Atom strayedAtom) {
    return this.strayedAtoms.contains(strayedAtom);
  }

  public boolean contains(final Relation relation) {
    return this.relations.contains(relation);
  }

  public boolean contains(final Tuple strayedTuple) {
    return this.strayedTuples.contains(strayedTuple);
  }

  public ArrayList<Atom> getAllAtoms() {
    final ArrayList<Atom> allAtoms = new ArrayList<Atom>();
    for (final Relation relation : this.relations) {
      for (final Tuple tuple : relation.getTuples()) {
        for (final Atom atom : tuple.getAtoms()) {
          if (!allAtoms.contains(atom)) {
            allAtoms.add(atom);
          }
        }
      }
    }
    allAtoms.addAll(this.strayedAtoms);
    return allAtoms;
  }

  public ArrayList<Tuple> getAllTuples() {
    final ArrayList<Tuple> allTuples = new ArrayList<Tuple>();
    for (final Relation relation : this.relations) {
      for (final Tuple tuple : relation.getTuples()) {
        if (!allTuples.contains(tuple)) {
          allTuples.add(tuple);
        }
      }
    }
    allTuples.addAll(this.strayedTuples);
    return allTuples;
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

  public ArrayList<Atom> getStrayedAtoms() {
    return this.strayedAtoms;
  }

  public ArrayList<Tuple> getStrayedTuples() {
    return this.strayedTuples;
  }
}
