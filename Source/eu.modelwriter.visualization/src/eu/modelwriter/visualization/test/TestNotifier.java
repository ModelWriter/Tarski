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
package eu.modelwriter.visualization.test;

import java.io.Serializable;
import java.util.List;

import eu.modelwriter.visualization.Notifier;

public class TestNotifier implements Notifier {

  @Override
  public void addTupleNotify(final String relationName, final List<String> tuple,
      final String bound) {
    System.out.println("Added Relation " + relationName);

    for (final String string : tuple) {
      System.out.println("Atom : " + string);
    }

    System.out.println("Bound : " + bound);
  }

  @Override
  public void addTupleNotify(final String relationName, final String inRelationName,
      final List<String> tuple, final String bound) {
    System.out.println("Added Relation " + relationName + " in " + inRelationName);

    for (final String string : tuple) {
      System.out.println("Atom : " + string);
    }

    System.out.println("Bound : " + bound);
  }

  @Override
  public void moveToLower(final String relationName, final List<String> tuple) {
    System.out.println("Relation " + relationName);

    for (final String string : tuple) {
      System.out.println("Atom : " + string);
    }

    System.out.println("Moved to Lower.");
  }

  @Override
  public void moveToLower(final String relationName, final String inRelationName,
      final List<String> tuple) {
    System.out.println("Relation " + relationName + " in " + inRelationName);

    for (final String string : tuple) {
      System.out.println("Atom : " + string);
    }

    System.out.println("Moved to Lower.");
  }

  @Override
  public void moveToUpper(final String relationName, final List<String> tuple) {
    System.out.println("Relation " + relationName);

    for (final String string : tuple) {
      System.out.println("Atom : " + string);
    }

    System.out.println("Moved to Upper.");
  }

  @Override
  public void moveToUpper(final String relationName, final String inRelationName,
      final List<String> tuple) {
    System.out.println("Relation " + relationName + " in " + inRelationName);

    for (final String string : tuple) {
      System.out.println("Atom : " + string);
    }

    System.out.println("Moved to Upper.");
  }

  @Override
  public void notify(final Serializable data) {
    final TestObject testObject = (TestObject) data;

    System.out.println(testObject.name);
  }

  @Override
  public void removeTupleNotify(final String relationName, final List<String> tuple,
      final String bound) {
    System.out.println("Removed Relation " + relationName);

    for (final String string : tuple) {
      System.out.println("Atom : " + string);
    }

    System.out.println("Bound : " + bound);
  }

  @Override
  public void removeTupleNotify(final String relationName, final String inRelationName,
      final List<String> tuple, final String bound) {
    System.out.println("Removed Relation " + relationName + " in " + inRelationName);

    for (final String string : tuple) {
      System.out.println("Atom : " + string);
    }

    System.out.println("Bound : " + bound);
  }
}
