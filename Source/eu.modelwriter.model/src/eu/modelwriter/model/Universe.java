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
import java.util.LinkedHashMap;
import java.util.List;

public class Universe {
  private final LinkedHashMap<String, Atom> strayedAtoms;
  private final LinkedHashMap<String, Tuple> strayedTuples;
  private final LinkedHashMap<String, Relation> relations;
  private final LinkedHashMap<String, Tuple> tuples;
  private final LinkedHashMap<String, Atom> atoms;

  protected Universe() {
    strayedAtoms = new LinkedHashMap<String, Atom>();
    strayedTuples = new LinkedHashMap<String, Tuple>();
    relations = new LinkedHashMap<String, Relation>();
    tuples = new LinkedHashMap<String, Tuple>();
    atoms = new LinkedHashMap<String, Atom>();
  }

  protected void addAtom(final Atom atom) {
    atoms.put(atom.getID(), atom);
  }

  protected void addRelation(final Relation newRelation) {
    relations.put(newRelation.getID(), newRelation);
  }

  protected void addStrayedAtom(final Atom strayedAtom) {
    strayedAtoms.put(strayedAtom.getID(), strayedAtom);
  }

  protected void addStrayedTuple(final Tuple strayedTuple) {
    strayedTuples.put(strayedTuple.getID(), strayedTuple);
  }

  protected void addTuple(final Tuple tuple) {
    tuples.put(tuple.getID(), tuple);
  }

  protected boolean containsAtom(final String atomID) {
    return atoms.containsKey(atomID);
  }

  protected boolean containsRelation(final String relationName) {
    return relations.containsKey(relationName);
  }

  protected boolean containsStrayedAtom(final String atomID) {
    return strayedAtoms.containsKey(atomID);
  }

  protected boolean containsStrayedTuple(final String tupleID) {
    return strayedTuples.containsKey(tupleID);
  }

  protected boolean containsTuple(final String tupleID) {
    return tuples.containsKey(tupleID);
  }

  protected Atom getAtom(final String atomID) {
    return atoms.get(atomID);
  }

  protected List<Atom> getAtoms() {
    return new ArrayList<Atom>(atoms.values());
  }

  protected Relation getRelation(final String relationID) {
    return relations.get(relationID);
  }

  protected List<Relation> getRelations() {
    return new ArrayList<Relation>(relations.values());
  }

  protected Atom getStrayedAtom(final String atomID) {
    return strayedAtoms.get(atomID);
  }

  protected List<Atom> getStrayedAtoms() {
    return new ArrayList<Atom>(strayedAtoms.values());
  }

  protected Tuple getStrayedTuple(final String tupleID) {
    return strayedTuples.get(tupleID);
  }

  protected List<Tuple> getStrayedTuples() {
    return new ArrayList<Tuple>(strayedTuples.values());
  }

  protected Tuple getTuple(final String id) {
    return tuples.get(id);
  }

  protected List<Tuple> getTuples() {
    return new ArrayList<Tuple>(tuples.values());
  }

  protected boolean removeAtom(final String atomID) {
    if (containsAtom(atomID)) {
      atoms.remove(atomID);
      return true;
    }
    return false;
  }

  protected boolean removeRelation(final String relationID) {
    if (containsRelation(relationID)) {
      relations.remove(relationID);
      return true;
    }
    return false;
  }

  protected boolean removeStrayedAtom(final String atomID) {
    if (containsStrayedAtom(atomID)) {
      strayedAtoms.remove(atomID);
      return true;
    }
    return false;
  }

  protected boolean removeStrayedTuple(final String tupleID) {
    if (containsStrayedTuple(tupleID)) {
      strayedTuples.remove(tupleID);
      return true;
    }
    return false;
  }

  protected boolean removeTuple(final String tupleID) {
    if (containsTuple(tupleID)) {
      tuples.remove(tupleID);
      return true;
    }
    return false;
  }
}
