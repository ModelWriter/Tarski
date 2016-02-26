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

public class Tuple {
  private String text;
  private final ArrayList<Atom> atoms;
  private int arity;
  private boolean isLowerBound;

  public Tuple() {
    this.atoms = new ArrayList<Atom>();
    this.arity = 0;
  }

  public Tuple(final String text) {
    this.text = text;
    this.atoms = new ArrayList<Atom>();
    this.arity = 0;
  }

  public void addAtom(final Atom newAtom) {
    this.atoms.add(newAtom);
    this.arity++;
  }

  public boolean contains(final Atom atom) {
    for (final Atom a : this.atoms) {
      if (a.getText().equals(atom.getText())) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }

    if (obj instanceof Tuple) {
      final ArrayList<Atom> otherAtoms = ((Tuple) obj).atoms;
      final ArrayList<Atom> atoms = this.atoms;
      if (otherAtoms.size() != atoms.size()) {
        return false;
      }
      for (int i = 0; i < atoms.size(); i++) {
        if (!atoms.get(i).getText().equals(otherAtoms.get(i).getText())) {
          return false;
        }
      }
    }
    return true;
  }

  public int getArity() {
    return this.arity;
  }

  public Atom getAtom(final int index) {
    return this.atoms.get(index);
  }

  public int getAtomCount() {
    return this.atoms.size();
  }

  public ArrayList<Atom> getAtoms() {
    return this.atoms;
  }

  public String getText() {
    return this.text;
  }

  public boolean isLowerBound() {
    return this.isLowerBound;
  }

  public void setLowerBound(final boolean isLowerBound) {
    this.isLowerBound = isLowerBound;
  }

  @Override
  public String toString() {
    String result = "[";
    for (int i = 0; i < this.atoms.size(); i++) {
      if (i == 0) {
        result += this.atoms.get(i).getText();
      } else {
        result += "," + this.atoms.get(i).getText();
      }
    }
    result += "]";

    return result;
  }
}
