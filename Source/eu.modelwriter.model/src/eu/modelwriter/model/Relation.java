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
import java.util.List;

public class Relation {
  public enum Multiplicity {
    ONE, LONE, SOME
  }

  private final String name;
  private final List<Tuple> tuples;
  private int id;
  private Multiplicity multiplicity;

  public Relation(final String name) {
    this.name = name;
    this.tuples = new ArrayList<Tuple>();
    this.id = -1;
  }

  public void addAtomWithTuple(final Atom... atoms) {
    final Tuple tuple = new Tuple();
    for (final Atom atom : atoms) {
      tuple.addAtom(atom);
    }
    this.addTuple(tuple);
  }

  public void addTuple(final Tuple newTuple) {
    this.tuples.add(newTuple);
  }

  public boolean contains(final Tuple tuple) {
    for (final Tuple t : this.tuples) {
      if (t.getText().equals(tuple.getText())) {
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

    return this.getName().equals(((Relation) obj).getName());
  }

  public int getArity() {
    if (this.tuples != null && this.tuples.size() != 0) {
      return this.tuples.get(0).getArity();
    }
    return 0;
  }

  public int getId() {
    return this.id;
  }

  public Multiplicity getMultiplicity() {
    return this.multiplicity;
  }

  public String getName() {
    return this.name;
  }

  public Tuple getTuple(final int index) {
    return this.tuples.get(index);
  }

  public int getTupleCount() {
    return this.tuples.size();
  }

  public List<Tuple> getTuples() {
    return this.tuples;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public void setMultiplicity(final Multiplicity multiplicity) {
    this.multiplicity = multiplicity;
  }

  @Override
  public String toString() {
    String ts = "";
    for (final Tuple tuple : this.tuples) {
      ts += tuple.toString() + " ";
    }
    return this.name + "={" + ts + "};";
  }
}
