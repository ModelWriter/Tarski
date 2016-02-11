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
package eu.modelwriter.visualization.model;

import java.util.ArrayList;

public class Tuple {
  private String text;
  private ArrayList<Atom> atoms;
  private int arity;
  private String bound;


  public Tuple() {
    this.atoms = new ArrayList<Atom>();
    this.arity = 0;
  }

  public Tuple(String text) {
    this.text = text;
    this.atoms = new ArrayList<Atom>();
    this.arity = 0;
  }

  public void addAtom(Atom newAtom) {
    this.atoms.add(newAtom);
    this.arity++;
  }

  public boolean contains(Atom atom) {
    for (Atom a : this.atoms) {
      if (a.getText().equals(atom.getText())) {
        return true;
      }
    }
    return false;
  }

  public int getArity() {
    return this.arity;
  }

  public Atom getAtom(int index) {
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

  public String getBound() {
    return bound;
  }

  public void setBound(String bound) {
    this.bound = bound;
  }

  @Override
  public String toString() {
    String as = "";
    for (Atom atom : this.atoms) {
      as += atom.getText() + " ";
    }
    return "(" + as + ")";
  }
}
