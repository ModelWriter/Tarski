/*******************************************************************************
 * Copyright (c) 2016 UNIT Information Technologies R&D Ltd
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ferhat Erata - initial API and implementation
 *     H. Emre Kirmizi - initial API and implementation
 *     Serhat Celik - initial API and implementation
 *     U. Anil Ozturk - initial API and implementation
 *******************************************************************************/
package eu.modelwriter.visualization.model;

import java.util.ArrayList;
import java.util.List;

public class Relation {
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

  public enum Multiplicity {
    ONE, LONE, SOME
  }

  public Relation(String name) {
    this.name = name;
    tuples = new ArrayList<Tuple>();
    types = new ArrayList<List<Relation>>();
    id = -1;
  }

  public void addTuple(Tuple newTuple) {
    tuples.add(newTuple);
  }

  public boolean contains(Tuple tuple) {
    for (final Tuple t : tuples) {
      if (t.getText().equals(tuple.getText())) {
        return true;
      }
    }
    return false;
  }

  public int getArity() {
    if (tuples != null && tuples.size() != 0) {
      return tuples.get(0).getArity();
    }
    return 0;
  }

  public String getName() {
    return name;
  }

  public Tuple getTuple(int index) {
    return tuples.get(index);
  }

  public int getTupleCount() {
    return tuples.size();
  }

  public List<Tuple> getTuples() {
    return tuples;
  }

  public List<List<Relation>> getTypes() {
    return types;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Relation getParent() {
    return parent;
  }

  public void setParent(Relation parent) {
    this.parent = parent;
  }

  public Multiplicity getMultiplicity() {
    return multiplicity;
  }

  public void setMultiplicity(Multiplicity multiplicity) {
    this.multiplicity = multiplicity;
  }

  public boolean isAbstract() {
    return Abstract;
  }

  public void setAbstract(boolean Abstract) {
    this.Abstract = Abstract;
  }

  public boolean isPrivate() {
    return Private;
  }

  public void setPrivate(boolean Private) {
    this.Private = Private;
  }

  public boolean isMeta() {
    return Meta;
  }

  public void setMeta(boolean Meta) {
    this.Meta = Meta;
  }

  public boolean isEnum() {
    return Enum;
  }

  public void setEnum(boolean Enum) {
    this.Enum = Enum;
  }

  public void addAtomWithTuple(Atom... atoms) {
    Tuple tuple = new Tuple();
    for (Atom atom : atoms) {
      tuple.addAtom(atom);
    }
    this.addTuple(tuple);
  }


  public void addTypes(Relation... relations) {
    List<Relation> type = new ArrayList<>();

    for (Relation relation : relations) {
      type.add(relation);
    }

    types.add(type);
  }

  @Override
  public String toString() {
    String ts = "";
    for (final Tuple tuple : tuples) {
      ts += tuple.toString() + " ";
    }
    return name + "={" + ts + "};";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (obj == this)
      return true;

    return this.getName().equals(((Relation) obj).getName());
  }


}
