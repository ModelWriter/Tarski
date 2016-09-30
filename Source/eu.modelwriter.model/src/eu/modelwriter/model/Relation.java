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

import eu.modelwriter.model.exception.InvalidArityException;

public class Relation {
  private LinkedHashMap<String, Tuple> tuples;
  private String id;
  private String name;
  private int arity;

  public Relation(final String relationID, final String name, final int arity) {
    setID(relationID);
    setName(name);
    setArity(arity);
    tuples = new LinkedHashMap<String, Tuple>(arity);
  }

  private void setName(final String name) {
    this.name = name;
  }

  private void setID(final String id) {
    this.id = id;
  }

  private void setArity(final int arity) {
    this.arity = arity;
  }

  protected void addTuple(final Tuple newTuple) throws InvalidArityException {
    if (newTuple.getArity() != getArity()) {
      throw new InvalidArityException();
    }
    tuples.put(newTuple.getID(), newTuple);
  }

  public boolean contains(final String tupleID) {
    return tuples.containsKey(tupleID);
  }

  @Override
  protected Relation clone() {
    final Relation cloneRelation = new Relation(getID(), getName(), getArity());
    cloneRelation.setTuples(tuples);
    return cloneRelation;
  }

  public String getID() {
    return id;
  }

  private void setTuples(final LinkedHashMap<String, Tuple> tuples) {
    this.tuples = tuples;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Relation)) {
      return false;
    }
    return getName().equals(((Relation) obj).getName());
  }

  public int getArity() {
    return arity;
  }

  public String getName() {
    return name;
  }

  public int getTupleCount() {
    return tuples.size();
  }

  public List<Tuple> getTuples() {
    return new ArrayList<Tuple>(tuples.values());
  }

  @Override
  public int hashCode() {
    return getName().hashCode();
  }

  protected void removeTuple(final String tupleID) {
    tuples.remove(tupleID);
  }

  @Override
  public String toString() {
    String ts = "\n";
    for (final Tuple tuple : getTuples()) {
      ts += tuple.toString() + "\n";
    }
    return getName() + "={" + ts + "};";
  }
}
