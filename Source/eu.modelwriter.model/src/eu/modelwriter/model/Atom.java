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

  public Atom(final List<Relation> relations, final String label, final String id,
      final Serializable data,
      final BOUND bound) {
    super(relations, id, data, bound);
    tuplesIn = new LinkedHashMap<String, Tuple>();
    if (label != null) {
      setLabel(label);
    } else {
      setRandomLabel();
    }
  }

  protected void addTuplesIn(final Tuple tuple) {
    tuplesIn.put(tuple.getID(), tuple);
  }

  protected List<Tuple> getTuplesIn() {
    return new ArrayList<Tuple>(tuplesIn.values());
  }

  protected void setRandomLabel() {
    String label;
    if (getRelationSets().size() == 0) {
      label = "(Univ)\n";
    } else {
      label = "(" + relationSetsToString() + ")\n";
    }
    label += "[" + Atom.randomUniqueNumbers[Atom.atomCount++] + "]";
    setLabel(label);
  }

  @Override
  protected void setRelationSets(final List<Relation> relations) {
    super.setRelationSets(relations);
    setRandomLabel();
  }

  @Override
  public String toString() {
    setRandomLabel();
    return getLabel();
  }
}
