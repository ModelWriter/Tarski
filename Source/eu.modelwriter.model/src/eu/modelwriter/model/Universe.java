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
  private final LinkedHashMap<String, RelationSet> relationSets;
  private final LinkedHashMap<String, Tuple> tuples;
  private final LinkedHashMap<String, Atom> atoms;

  protected Universe() {
    this.strayedAtoms = new LinkedHashMap<String, Atom>();
    this.strayedTuples = new LinkedHashMap<String, Tuple>();
    this.relationSets = new LinkedHashMap<String, RelationSet>();
    this.tuples = new LinkedHashMap<String, Tuple>();
    this.atoms = new LinkedHashMap<String, Atom>();
  }

  protected void addAtom(final Atom atom) {
    this.atoms.put(atom.getID(), atom);
  }

  protected void addRelationSet(final RelationSet newRelationSet) {
    this.relationSets.put(newRelationSet.getName(), newRelationSet);
  }

  protected void addStrayedAtom(final Atom strayedAtom) {
    this.strayedAtoms.put(strayedAtom.getID(), strayedAtom);
  }

  protected void addStrayedTuple(final Tuple strayedTuple) {
    this.strayedTuples.put(strayedTuple.getID(), strayedTuple);
  }

  protected void addTuple(final Tuple tuple) {
    this.tuples.put(tuple.getID(), tuple);
  }

  protected boolean containsAtom(final String id) {
    return this.atoms.containsKey(id);
  }

  protected boolean containsRelationSet(final String relationSetName) {
    return this.relationSets.containsKey(relationSetName);
  }

  protected boolean containsStrayedAtom(final String id) {
    return this.strayedAtoms.containsKey(id);
  }

  protected boolean containsStrayedTuple(final String id) {
    return this.strayedTuples.containsKey(id);
  }

  protected boolean containsTuple(final String id) {
    return this.tuples.containsKey(id);
  }

  protected Atom getAtom(final String id) {
    return this.atoms.get(id);
  }

  protected List<Atom> getAtoms() {
    return new ArrayList<Atom>(this.atoms.values());
  }

  protected RelationSet getRelationSet(final String relationSetName) {
    return this.relationSets.get(relationSetName);
  }

  protected List<RelationSet> getRelationSets() {
    return new ArrayList<RelationSet>(this.relationSets.values());
  }

  protected Atom getStrayedAtom(final String id) {
    return this.strayedAtoms.get(id);
  }

  protected List<Atom> getStrayedAtoms() {
    return new ArrayList<Atom>(this.strayedAtoms.values());
  }

  protected Tuple getStrayedTuple(final String id) {
    return this.strayedTuples.get(id);
  }

  protected List<Tuple> getStrayedTuples() {
    return new ArrayList<Tuple>(this.strayedTuples.values());
  }

  protected Tuple getTuple(final String id) {
    return this.tuples.get(id);
  }

  protected List<Tuple> getTuples() {
    return new ArrayList<Tuple>(this.tuples.values());
  }

  protected boolean removeAtom(final String id) {
    if (this.containsAtom(id)) {
      this.atoms.remove(id);
      return true;
    }
    return false;
  }

  protected boolean removeRelationSet(final String relationSetName) {
    if (this.containsRelationSet(relationSetName)) {
      this.relationSets.remove(relationSetName);
      return true;
    }
    return false;
  }

  protected boolean removeStrayedAtom(final String id) {
    if (this.containsStrayedAtom(id)) {
      this.strayedAtoms.remove(id);
      return true;
    }
    return false;
  }

  protected boolean removeStrayedTuple(final String id) {
    if (this.containsStrayedTuple(id)) {
      this.strayedTuples.remove(id);
      return true;
    }
    return false;
  }

  protected boolean removeTuple(final String id) {
    if (this.containsTuple(id)) {
      this.tuples.remove(id);
      return true;
    }
    return false;
  }
}
