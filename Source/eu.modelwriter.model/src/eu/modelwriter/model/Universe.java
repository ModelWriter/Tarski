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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Universe {
  private final HashMap<String, Atom> strayedAtoms;
  private final HashMap<String, Tuple> strayedTuples;
  private final HashMap<String, Relation> relations;
  private final HashMap<String, Tuple> tuples;
  private final HashMap<String, Atom> atoms;

  protected Universe() {
    this.strayedAtoms = new HashMap<String, Atom>();
    this.strayedTuples = new HashMap<String, Tuple>();
    this.relations = new HashMap<String, Relation>();
    this.tuples = new HashMap<String, Tuple>();
    this.atoms = new HashMap<String, Atom>();
  }

  protected void addAtom(final Atom atom) {
    this.atoms.put(atom.getID(), atom);
  }

  protected void addRelation(final Relation newRelation) {
    this.relations.put(newRelation.getName(), newRelation);
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
    if (this.atoms.containsKey(id)) {
      return true;
    }
    return false;
  }

  protected boolean containsRelation(final String relationName) {
    return this.relations.containsKey(relationName);
  }

  protected boolean containsStrayedAtom(final String id) {
    if (this.strayedAtoms.containsKey(id)) {
      return true;
    }
    return false;
  }

  protected boolean containsStrayedTuple(final String id) {
    if (this.strayedTuples.containsKey(id)) {
      return true;
    }
    return false;
  }

  protected boolean containsTuple(final String id) {
    if (this.tuples.containsKey(id)) {
      return true;
    }
    return false;
  }

  protected Atom getAtom(final String id) {
    if (this.containsAtom(id)) {
      return this.atoms.get(id);
    } else {
      return this.strayedAtoms.get(id);
    }
  }

  protected List<Atom> getAtoms() {
    return new ArrayList<Atom>(this.atoms.values());
  }

  protected Relation getRelation(final String relationName) {
    return this.relations.get(relationName);
  }

  protected List<Relation> getRelations() {
    return new ArrayList<Relation>(this.relations.values());
  }

  protected List<Atom> getStrayedAtoms() {
    return new ArrayList<Atom>(this.strayedAtoms.values());
  }

  protected List<Tuple> getStrayedTuples() {
    return new ArrayList<Tuple>(this.strayedTuples.values());
  }

  protected Tuple getTuple(final String id) {
    if (this.containsTuple(id)) {
      return this.tuples.get(id);
    } else {
      return this.strayedTuples.get(id);
    }
  }

  protected List<Tuple> getTuples() {
    return new ArrayList<Tuple>(this.tuples.values());
  }

  protected boolean removeAtom(final String id) {
    if (this.containsAtom(id)) {
      this.atoms.remove(id);
      for (final Relation relation : this.relations.values()) {
        for (final Tuple tuple : relation.getTuples()) {
          final Iterator<Atom> atomsIter = tuple.getAtoms().iterator();
          while (atomsIter.hasNext()) {
            final Atom atom = atomsIter.next();
            if (atom.getID().equals(id)) {
              atomsIter.remove();
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  protected boolean removeRelation(final String relationName) {
    if (this.containsRelation(relationName)) {
      this.relations.remove(relationName);
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
      for (final Relation relation : this.relations.values()) {
        final Iterator<Tuple> tuplesIter = relation.getTuples().iterator();
        while (tuplesIter.hasNext()) {
          final Tuple tuple = tuplesIter.next();
          if (tuple.getID().equals(id)) {
            tuplesIter.remove();
            return true;
          }
        }
      }
    }
    return false;
  }
}
