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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import eu.modelwriter.model.exception.InvalidArityException;

public class Tuple extends ModelElement {
  /**
   * LinkedList is needed because atoms must be sorted.
   */
  private final static String ARITY = "ARITY";
  private final LinkedList<Atom> atoms;
  private Relation relationIn;

  public Tuple(final Relation relationIn, final String tupleID, final Serializable data,
      final BOUND bound, final int arity, final Atom... atoms) throws InvalidArityException {
    super(tupleID, relationIn.getName(), data, bound);
    setRelationIn(relationIn);
    setArity(arity);
    this.atoms = new LinkedList<Atom>();
    addAtoms(atoms);
  }

  private void addAtoms(final Atom... atoms) throws InvalidArityException {
    if (atoms == null) {
      return;
    }
    if (atoms.length != getArity()) {
      throw new InvalidArityException();
    }
    for (final Atom atom : atoms) {
      this.atoms.add(atom);
    }
  }

  public boolean contains(final String atomID) {
    for (final Atom atom : atoms) {
      if (atom.getID().equals(atomID)) {
        return true;
      }
    }
    return false;
  }

  public Atom getAtom(final int index) {
    return atoms.get(index);
  }

  public List<Atom> getAtoms() {
    return Collections.unmodifiableList(atoms);
  }

  public String[] getTypes() {
    final String[] types = new String[getArity()];
    for (int i = 0; i < getArity(); i++) {
      types[i] = atoms.get(i).relationsToString();
    }
    return types;
  }

  private void setRelationIn(final Relation relationIn) {
    this.relationIn = relationIn;
  }

  public Relation getRelationIn() {
    return relationIn.clone();
  }

  @Override
  public String toString() {
    return getID() + ":(" + String.join(", ", getAtomLabels()) + ")";
  }

  private List<String> getAtomLabels() {
    final List<String> atomLabels = new ArrayList<String>();
    for (final Atom atom : atoms) {
      atomLabels.add(atom.getLabel());
    }
    return atomLabels;
  }

  private void setArity(final int arity) {
    setAttribute(Tuple.ARITY, arity);
  }

  public int getArity() {
    return (int) getAttribute(Tuple.ARITY);
  }

  public List<String> getAtomsIDs() {
    return getAtoms().stream().map(a -> a.getID()).collect(Collectors.toList());
  }
}
