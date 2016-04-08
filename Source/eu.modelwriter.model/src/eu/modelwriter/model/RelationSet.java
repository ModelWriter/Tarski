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

import eu.modelwriter.model.exception.InvalidArityException;

public class RelationSet {
  private final LinkedHashMap<String, Tuple> tuples;
  private final String name;
  private final int arity;

  public RelationSet(final String name, final int arity) {
    this.name = name;
    this.arity = arity;
    this.tuples = new LinkedHashMap<String, Tuple>(arity);
  }

  protected void addTuple(final Tuple newTuple) throws InvalidArityException {
    if (newTuple.getArity() != this.arity) {
      throw new InvalidArityException();
    }
    this.tuples.put(newTuple.getID(), newTuple);
  }

  public boolean contains(final String tupleID) {
    return this.tuples.containsKey(tupleID);
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof RelationSet)) {
      return false;
    }
    return this.getName().equals(((RelationSet) obj).getName());
  }

  public int getArity() {
    return this.arity;
  }

  public String getName() {
    return this.name;
  }

  public int getTupleCount() {
    return this.tuples.size();
  }

  public ArrayList<Tuple> getTuples() {
    return new ArrayList<Tuple>(this.tuples.values());
  }

  @Override
  public int hashCode() {
    return this.getName().hashCode();
  }

  protected void removeTuple(final String id) {
    this.tuples.remove(id);
  }

  @Override
  public String toString() {
    String ts = "\n";
    for (final Tuple tuple : this.getTuples()) {
      ts += tuple.toString() + "\n";
    }
    return this.name + "={" + ts + "};";
  }
}
