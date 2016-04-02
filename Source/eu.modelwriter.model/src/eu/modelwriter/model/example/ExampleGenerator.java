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

import eu.modelwriter.model.Atom;
import eu.modelwriter.model.ModelManager;
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

    /** Atoms **/
    final Atom Root$0 = manager.addAtom("Root", null);

    final Atom Directory$0 = manager.addAtom("Directory", null);
    final Atom Directory$1 = manager.addAtom("Directory", null);

    final Atom Alias$0 = manager.addAtom("Alias", null);
    final Atom Alias$1 = manager.addAtom("Alias", null);
    final Atom Alias$2 = manager.addAtom("Alias", null);

    final Atom Word$0 = manager.addAtom("Word", null);
    final Atom Word$1 = manager.addAtom("Word", null);
    final Atom Word$2 = manager.addAtom("Word", null);
    final Atom Word$3 = manager.addAtom("Word", null);

    final Atom Universe$0 = manager.addAtom(null, null);
    final Atom Universe$1 = manager.addAtom(null, null);
    final Atom Universe$2 = manager.addAtom(null, null);
    /** Atoms **/

    manager.addRelation("contents", 2);
    manager.addRelation("refs", 2);

    try {
      manager.addTuple("contents", null, 2, "lower", Root$0, Alias$0);
      manager.addTuple("contents", null, 2, "lower", Root$0, Directory$0);
      manager.addTuple("contents", null, 2, "lower", Root$0, Alias$1);
      manager.addTuple("contents", null, 2, "lower", Directory$0, Word$0);
      manager.addTuple("contents", null, 2, "lower", Directory$0, Directory$1);
      manager.addTuple("contents", null, 2, "lower", Directory$1, Word$1);
      manager.addTuple("contents", null, 2, "lower", Directory$1, Word$2);
      manager.addTuple("contents", null, 2, "lower", Directory$1, Word$3);
      manager.addTuple("contents", null, 2, "lower", Directory$1, Alias$2);

      manager.addTuple("refs", null, 2, "lower", Alias$2, Word$0);
      manager.addTuple("refs", null, 2, "lower", Alias$2, Word$1);
      manager.addTuple("refs", null, 2, "lower", Alias$2, Word$2);
      manager.addTuple("refs", null, 2, "lower", Alias$2, Word$3);

      manager.addTuple("contents", null, 2, "lower", Universe$0, Universe$1);
      manager.addTuple("refs", null, 2, "lower", Universe$2, Universe$1);

      // refs.addTuple("",null,2,"lower", Word$0, Directory$0));
      // refs.addTuple("",null,2,"lower", Universe$1, Universe$0));
      manager.addTuple(null, null, 2, "lower", Universe$0, Universe$0);
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

    final Atom Ferhat$0 = manager.addAtom("Ferhat", null);
    final Atom Ferhat$1 = manager.addAtom("Ferhat", null);
    final Atom Ferhat$2 = manager.addAtom("Ferhat", null);

    final Atom Anil$0 = manager.addAtom("Anil", null);

    manager.addAtom("Serhat", null);
    manager.addAtom("Serhat", null);
    manager.addAtom("Serhat", null);
    manager.addAtom("Serhat", null);
    final Atom Serhat$4 = manager.addAtom("Serhat", null);
    final Atom Serhat$5 = manager.addAtom("Serhat", null);
    final Atom Serhat$6 = manager.addAtom("Serhat", null);

    manager.addRelation("emre", 2);

    try {
      manager.addTuple("emre", null, 2, null, Ferhat$0, Serhat$6);
      manager.addTuple("emre", null, 2, null, Ferhat$1, Serhat$5);
      manager.addTuple("emre", null, 2, null, Ferhat$2, Serhat$4);
      manager.addTuple("emre", null, 2, null, Ferhat$0, Anil$0);
    } catch (final InvalidArityException e) {
      e.printStackTrace();
    }

    return manager;
  }
}
