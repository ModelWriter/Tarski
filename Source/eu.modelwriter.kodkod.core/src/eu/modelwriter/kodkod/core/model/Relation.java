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
import java.util.Iterator;
import java.util.List;

public class Relation {
  public enum Multiplicity {
    ONE, LONE, SOME
  }

  private final String name;
  private final List<Tuple> tuples;
  private final List<List<Relation>> types;
  private int id;
  private Relation parent;
  private Multiplicity multiplicity;
  private boolean Abstract;
  private boolean Private;
  private boolean Meta;
  private boolean Enum;

  public Relation(final String name) {
    this.name = name;
    this.tuples = new ArrayList<Tuple>();
    this.types = new ArrayList<List<Relation>>();
    this.id = -1;
  }

  /**
   * @param isLowerBound if added tuple is one of lowerBound tuple then set this parameter true
   * @param atoms
   */
  public void addAtomWithTuple(final boolean isLowerBound, final Atom... atoms) {
    final Tuple tuple = new Tuple();
    tuple.setLowerBound(isLowerBound);
    for (final Atom atom : atoms) {
      tuple.addAtom(atom);
    }
    this.addTuple(tuple);
  }

  public void addTuple(final Tuple newTuple) {
    this.tuples.add(newTuple);
  }

  public void addTypes(final Relation... relations) {
    final List<Relation> type = new ArrayList<>();

    for (final Relation relation : relations) {
      type.add(relation);
    }

    this.types.add(type);
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

  public Relation getParent() {
    return this.parent;
  }

  public Tuple getTuple(final Atom... atoms) {
    boolean found = true;
    final Iterator<Tuple> iterator = this.getTuples().iterator();
    while (iterator.hasNext()) {
      final Tuple tuple = iterator.next();
      for (int i = 0; i < tuple.getArity(); i++) {
        if (!atoms[i].getText().equals(tuple.getAtom(i).getText())) {
          found = false;
        }
      }
      if (found) {
        return tuple;
      }
    }
    return null;
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

  public List<List<Relation>> getTypes() {
    return this.types;
  }

  public boolean isAbstract() {
    return this.Abstract;
  }

  public boolean isEnum() {
    return this.Enum;
  }

  public boolean isMeta() {
    return this.Meta;
  }

  public boolean isPrivate() {
    return this.Private;
  }

  public void removeTuple(final Atom... atoms) {
    boolean found = true;
    final Iterator<Tuple> iterator = this.getTuples().iterator();
    while (iterator.hasNext()) {
      final Tuple tuple = iterator.next();
      for (int i = 0; i < tuple.getArity(); i++) {
        if (!atoms[i].getText().equals(tuple.getAtom(i).getText())) {
          found = false;
        }
      }
      if (found) {
        iterator.remove();
      }
    }
  }

  public void setAbstract(final boolean Abstract) {
    this.Abstract = Abstract;
  }

  public void setEnum(final boolean Enum) {
    this.Enum = Enum;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public void setMeta(final boolean Meta) {
    this.Meta = Meta;
  }

  public void setMultiplicity(final Multiplicity multiplicity) {
    this.multiplicity = multiplicity;
  }


  public void setParent(final Relation parent) {
    this.parent = parent;
  }

  public void setPrivate(final boolean Private) {
    this.Private = Private;
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
