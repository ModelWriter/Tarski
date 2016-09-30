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
import java.util.LinkedHashMap;
import java.util.List;

public class Atom extends ModelElement {
  private final LinkedHashMap<String, Tuple> tuplesIn;
  private List<Relation> relationsIn;

  public Atom(final List<Relation> relationsIn, final String label, final String atomID,
      final Serializable data,
      final BOUND bound) {
    super(atomID, label, data, bound);
    tuplesIn = new LinkedHashMap<String, Tuple>();
    setRelationsIn(relationsIn);
  }

  void addTupleIn(final Tuple tupleIn) {
    tuplesIn.put(tupleIn.getID(), tupleIn);
  }

  List<Tuple> getTuplesIn() {
    return new ArrayList<Tuple>(tuplesIn.values());
  }

  @Override
  public String toString() {
    return getLabel();
  }

  public List<String> getRelationsInNames() {
    final List<String> relationNames = new ArrayList<String>();
    for (final Relation relation : getRelationsIn()) {
      relationNames.add(relation.getName());
    }
    return relationNames;
  }

  void setRelationsIn(final List<Relation> relationsIn) {
    this.relationsIn = relationsIn;
  }

  public List<Relation> getRelationsIn() {
    return relationsIn;
  }

  public String relationsToString() {
    return String.join(", ", getRelationsInNames());
  }
}
