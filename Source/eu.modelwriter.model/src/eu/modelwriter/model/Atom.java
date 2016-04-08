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
import java.util.Random;

public class Atom extends ModelElement {
  private static int[] randomUniqueNumbers =
      new Random().ints(0, 1000).distinct().limit(1000).toArray();
  private static int atomCount = 0;
  private final LinkedHashMap<String, Tuple> tuplesIn;

  public Atom(final List<RelationSet> relationSets, final String id, final Serializable data,
      final BOUND bound) {
    super(relationSets, id, data, bound);
    this.tuplesIn = new LinkedHashMap<String, Tuple>();
    this.setLabel();
  }

  protected void addTuplesIn(final Tuple tuple) {
    this.tuplesIn.put(tuple.getID(), tuple);
  }

  protected List<Tuple> getTuplesIn() {
    return new ArrayList<Tuple>(this.tuplesIn.values());
  }

  protected void setLabel() {
    String label;
    if (this.getRelationSets().size() == 0) {
      label = "(Univ)\n";
    } else {
      label = "(" + this.relationSetsToString() + ")\n";
    }
    label += "[" + Atom.randomUniqueNumbers[Atom.atomCount++] + "]";
    this.setLabel(label);
  }

  @Override
  protected void setRelationSets(final List<RelationSet> relationSets) {
    super.setRelationSets(relationSets);
    this.setLabel();
  }

  @Override
  public String toString() {
    this.setLabel();
    return this.getLabel();
  }
}
