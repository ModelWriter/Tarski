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
package eu.modelwriter.model.example;

import java.util.Arrays;

import eu.modelwriter.model.Atom;
import eu.modelwriter.model.ModelManager;
import eu.modelwriter.model.Tuple;
import eu.modelwriter.model.exception.InvalidArityException;

public class ExampleGenerator {

  public static ModelManager createFileSystemExample() {
    final ModelManager manager = ModelManager.getInstance();

    manager.addRelation("Object", 1);
    manager.addRelation("Directory", 1);
    manager.addRelation("Root", 1);
    manager.addRelation("File", 1);
    manager.addRelation("Word", 1);
    manager.addRelation("Alias", 1);

    manager.addRelation("List", 1);
    manager.addRelation("EmptyList", 1);

    manager.addAtom(Arrays.asList(new String[] {"List", "EmptyList"}), null, Tuple.BOUND.LOWER);

    /** Atoms **/
    final Atom Root$0 =
        manager.addAtom(Arrays.asList(new String[] {"Root"}), null, Tuple.BOUND.LOWER);

    final Atom Directory$0 =
        manager.addAtom(Arrays.asList(new String[] {"Directory"}), null, Tuple.BOUND.LOWER);
    final Atom Directory$1 =
        manager.addAtom(Arrays.asList(new String[] {"Directory"}), null, Tuple.BOUND.LOWER);

    final Atom Alias$0 =
        manager.addAtom(Arrays.asList(new String[] {"Alias"}), null, Tuple.BOUND.LOWER);
    final Atom Alias$1 =
        manager.addAtom(Arrays.asList(new String[] {"Alias"}), null, Tuple.BOUND.LOWER);
    final Atom Alias$2 =
        manager.addAtom(Arrays.asList(new String[] {"Alias"}), null, Tuple.BOUND.LOWER);

    final Atom Word$0 =
        manager.addAtom(Arrays.asList(new String[] {"Word"}), null, Tuple.BOUND.LOWER);
    final Atom Word$1 =
        manager.addAtom(Arrays.asList(new String[] {"Word"}), null, Tuple.BOUND.LOWER);
    final Atom Word$2 =
        manager.addAtom(Arrays.asList(new String[] {"Word"}), null, Tuple.BOUND.LOWER);
    final Atom Word$3 =
        manager.addAtom(Arrays.asList(new String[] {"Word"}), null, Tuple.BOUND.LOWER);

    final Atom Universe$0 = manager.addAtom(null, null, Tuple.BOUND.LOWER);
    final Atom Universe$1 = manager.addAtom(null, null, Tuple.BOUND.LOWER);
    final Atom Universe$2 = manager.addAtom(null, null, Tuple.BOUND.LOWER);
    /** Atoms **/

    manager.addRelation("contents", 2);
    manager.addRelation("refs", 2);

    try {
      manager.addTuple("contents", null, Tuple.BOUND.LOWER, 2, Root$0, Alias$0);
      manager.addTuple("contents", null, Tuple.BOUND.LOWER, 2, Root$0, Directory$0);
      manager.addTuple("contents", null, Tuple.BOUND.LOWER, 2, Root$0, Alias$1);
      manager.addTuple("contents", null, Tuple.BOUND.LOWER, 2, Directory$0, Word$0);
      manager.addTuple("contents", null, Tuple.BOUND.LOWER, 2, Directory$0, Directory$1);
      manager.addTuple("contents", null, Tuple.BOUND.LOWER, 2, Directory$1, Word$1);
      manager.addTuple("contents", null, Tuple.BOUND.LOWER, 2, Directory$1, Word$2);
      manager.addTuple("contents", null, Tuple.BOUND.LOWER, 2, Directory$1, Word$3);
      manager.addTuple("contents", null, Tuple.BOUND.LOWER, 2, Directory$1, Alias$2);

      manager.addTuple("refs", null, Tuple.BOUND.LOWER, 2, Alias$2, Word$0);
      manager.addTuple("refs", null, Tuple.BOUND.LOWER, 2, Alias$2, Word$1);
      manager.addTuple("refs", null, Tuple.BOUND.LOWER, 2, Alias$2, Word$2);
      manager.addTuple("refs", null, Tuple.BOUND.LOWER, 2, Alias$2, Word$3);

      manager.addTuple("contents", null, Tuple.BOUND.LOWER, 2, Universe$0, Universe$1);
      manager.addTuple("refs", null, Tuple.BOUND.LOWER, 2, Universe$2, Universe$1);

      // refs.addTuple("",null,2,Tuple.BOUND.LOWER, Word$0, Directory$0));
      // refs.addTuple("",null,2,Tuple.BOUND.LOWER, Universe$1, Universe$0));
      manager.addTuple(null, null, Tuple.BOUND.LOWER, 2, Universe$0, Universe$0);
    } catch (final InvalidArityException e) {
      e.printStackTrace();
    }

    return manager;
  }

  public static ModelManager createInExample() {
    final ModelManager manager = ModelManager.getInstance();

    manager.addRelation("Ferhat", 1);
    manager.addRelation("Anil", 1);
    manager.addRelation("Serhat", 1);

    final Atom Ferhat$0 =
        manager.addAtom(Arrays.asList(new String[] {"Ferhat"}), null, Tuple.BOUND.LOWER);
    final Atom Ferhat$1 =
        manager.addAtom(Arrays.asList(new String[] {"Ferhat"}), null, Tuple.BOUND.LOWER);
    final Atom Ferhat$2 =
        manager.addAtom(Arrays.asList(new String[] {"Ferhat"}), null, Tuple.BOUND.LOWER);

    final Atom Anil$0 =
        manager.addAtom(Arrays.asList(new String[] {"Anil"}), null, Tuple.BOUND.LOWER);

    manager.addAtom(Arrays.asList(new String[] {"Serhat"}), null, Tuple.BOUND.LOWER);
    manager.addAtom(Arrays.asList(new String[] {"Serhat"}), null, Tuple.BOUND.LOWER);
    manager.addAtom(Arrays.asList(new String[] {"Serhat"}), null, Tuple.BOUND.LOWER);
    manager.addAtom(Arrays.asList(new String[] {"Serhat"}), null, Tuple.BOUND.LOWER);
    final Atom Serhat$4 =
        manager.addAtom(Arrays.asList(new String[] {"Serhat"}), null, Tuple.BOUND.LOWER);
    final Atom Serhat$5 =
        manager.addAtom(Arrays.asList(new String[] {"Serhat"}), null, Tuple.BOUND.LOWER);
    final Atom Serhat$6 =
        manager.addAtom(Arrays.asList(new String[] {"Serhat"}), null, Tuple.BOUND.LOWER);

    manager.addRelation("emre", 2);

    try {
      manager.addTuple("emre", null, Tuple.BOUND.LOWER, 2, Ferhat$0, Serhat$6);
      manager.addTuple("emre", null, Tuple.BOUND.LOWER, 2, Ferhat$1, Serhat$5);
      manager.addTuple("emre", null, Tuple.BOUND.LOWER, 2, Ferhat$2, Serhat$4);
      manager.addTuple("emre", null, Tuple.BOUND.LOWER, 2, Ferhat$0, Anil$0);
    } catch (final InvalidArityException e) {
      e.printStackTrace();
    }

    return manager;
  }
}
