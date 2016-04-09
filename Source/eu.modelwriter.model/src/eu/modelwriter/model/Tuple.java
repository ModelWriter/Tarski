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
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import eu.modelwriter.model.exception.InvalidArityException;

public class Tuple extends ModelElement {
  /**
   * LinkedList is needed because atoms must be sorted.
   */
  private final LinkedList<Atom> atoms;
  private final int arity;

  public Tuple(final RelationSet relationSet, final String id, final Serializable data,
      final BOUND bound, final int arity, final Atom... atoms) throws InvalidArityException {
    super(Arrays.asList(new RelationSet[] {relationSet}), id, data, bound);
    this.setLabel(relationSet.getName());
    this.arity = arity;
    this.atoms = new LinkedList<Atom>();
    this.addAtoms(atoms);
  }

  private void addAtoms(final Atom... atoms) throws InvalidArityException {
    if (atoms == null) {
      return;
    }
    if (atoms.length != this.arity) {
      throw new InvalidArityException();
    }
    for (final Atom atom : atoms) {
      this.atoms.add(atom);
    }
  }

  public boolean contains(final String atomID) {
    for (final Atom atom : this.atoms) {
      if (atom.getID().equals(atomID)) {
        return true;
      }
    }
    return false;
  }

  public int getArity() {
    return this.arity;
  }

  public Atom getAtom(final int index) {
    return this.atoms.get(index);
  }

  public List<String> getAtomLabels() {
    final List<String> atomLabels = new ArrayList<String>();
    for (final Atom atom : this.atoms) {
      atomLabels.add(atom.getLabel());
    }
    return atomLabels;
  }

  protected List<Atom> getAtoms() {
    return this.atoms;
  }

  public List<Atom> getAtomsCopy() {
    return new ArrayList<Atom>(this.atoms);
  }

  public String[] getTypes() {
    final String[] types = new String[this.arity];
    for (int i = 0; i < this.arity; i++) {
      types[i] = this.atoms.get(i).relationSetsToString();
    }
    return types;
  }

  @Override
  public String toString() {
    return this.getID() + ":(" + String.join(", ", this.getAtomLabels()) + ")";
  }
}
