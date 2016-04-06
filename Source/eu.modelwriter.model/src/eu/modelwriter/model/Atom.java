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
import java.util.List;
import java.util.Random;

public class Atom extends ModelElement {
  private static int[] randomUniqueNumbers =
      new Random().ints(0, 1000).distinct().limit(1000).toArray();
  private static int atomCount = 0;

  public Atom(final List<String> list, final String id, final Serializable data) {
    super(list, id, data);
    this.setLabel();
  }

  protected void setLabel() {
    String label = "(" + this.setToString() + ")\n";
    label += "[" + Atom.randomUniqueNumbers[Atom.atomCount++] + "]";
    this.setLabel(label);
  }

  @Override
  public String toString() {
    return this.getLabel() + "\nid=" + this.getID();
  }
}
