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

import eu.modelwriter.model.exception.InvalidArityException;

public class Tuple extends ModelElement {
  public static enum BOUND {
    LOWER("LOWER"), UPPER("UPPER"), EXACT("EXACT");
    String bound;

    private BOUND(final String bound) {
      this.bound = bound;
    }

    @Override
    public String toString() {
      return this.bound;
    }
  }

  private final ArrayList<Atom> atoms;
  private final int arity;
  private BOUND bound;

  public Tuple(final String set, final String label, final String id, final Serializable data,
      final BOUND bound, final int arity, final Atom... atoms) throws InvalidArityException {
    super(set, label, id, data);
    this.arity = arity;
    this.bound = bound;
    this.atoms = new ArrayList<Atom>(arity);
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

  public boolean contains(final Atom atom) {
    return this.atoms.contains(atom);
  }

  public boolean contains(final String atomID) {
    for (final Atom a : this.atoms) {
      if (a.getSet().equals(atomID)) {
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

  public ArrayList<Atom> getAtoms() {
    return this.atoms;
  }

  public BOUND getBound() {
    return this.bound;
  }

  public String[] getTypes() {
    final String[] types = new String[this.arity];
    for (int i = 0; i < this.arity; i++) {
      types[i] = this.atoms.get(i).getSet();
    }
    return types;
  }

  protected void setBound(final BOUND bound) {
    this.bound = bound;
  }

  @Override
  public String toString() {
    String as = "\n";
    for (final Atom atom : this.atoms) {
      as += atom.toString() + "\n";
    }
    return "(" + as + ")";
  }
}
