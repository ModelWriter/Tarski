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
import eu.modelwriter.model.ModelElement;
import eu.modelwriter.model.ModelManager;
import eu.modelwriter.model.RelationSet;
import eu.modelwriter.model.exception.InvalidArityException;

public class ExampleGenerator {

  public static ModelManager createFileSystemExample() {
    final ModelManager manager = ModelManager.getInstance();

    try {
      manager.addRelationSet("Object", 1);
      final RelationSet Directory = manager.addRelationSet("Directory", 1);
      final RelationSet Root = manager.addRelationSet("Root", 1);
      manager.addRelationSet("File", 1);
      final RelationSet Word = manager.addRelationSet("Word", 1);
      final RelationSet Alias = manager.addRelationSet("Alias", 1);

      final RelationSet List = manager.addRelationSet("List", 1);
      final RelationSet EmptyList = manager.addRelationSet("EmptyList", 1);

      manager.addAtom(Arrays.asList(new RelationSet[] {List, EmptyList}), null,
          ModelElement.BOUND.LOWER_BOUND);

      /** Atoms **/
      final Atom Root$0 = manager.addAtom(Arrays.asList(new RelationSet[] {Root}), null,
          ModelElement.BOUND.LOWER_BOUND);

      final Atom Directory$0 = manager.addAtom(Arrays.asList(new RelationSet[] {Directory}), null,
          ModelElement.BOUND.LOWER_BOUND);
      final Atom Directory$1 = manager.addAtom(Arrays.asList(new RelationSet[] {Directory}), null,
          ModelElement.BOUND.LOWER_BOUND);

      final Atom Alias$0 = manager.addAtom(Arrays.asList(new RelationSet[] {Alias}), null,
          ModelElement.BOUND.LOWER_BOUND);
      final Atom Alias$1 = manager.addAtom(Arrays.asList(new RelationSet[] {Alias}), null,
          ModelElement.BOUND.LOWER_BOUND);
      final Atom Alias$2 = manager.addAtom(Arrays.asList(new RelationSet[] {Alias}), null,
          ModelElement.BOUND.LOWER_BOUND);

      final Atom Word$0 = manager.addAtom(Arrays.asList(new RelationSet[] {Word}), null,
          ModelElement.BOUND.LOWER_BOUND);
      final Atom Word$1 = manager.addAtom(Arrays.asList(new RelationSet[] {Word}), null,
          ModelElement.BOUND.LOWER_BOUND);
      final Atom Word$2 = manager.addAtom(Arrays.asList(new RelationSet[] {Word}), null,
          ModelElement.BOUND.LOWER_BOUND);
      final Atom Word$3 = manager.addAtom(Arrays.asList(new RelationSet[] {Word}), null,
          ModelElement.BOUND.LOWER_BOUND);

      final Atom Universe$0 = manager.addAtom(null, null, ModelElement.BOUND.LOWER_BOUND);
      final Atom Universe$1 = manager.addAtom(null, null, ModelElement.BOUND.LOWER_BOUND);
      final Atom Universe$2 = manager.addAtom(null, null, ModelElement.BOUND.LOWER_BOUND);
      /** Atoms **/

      final RelationSet contents = manager.addRelationSet("contents", 2);
      final RelationSet refs = manager.addRelationSet("refs", 2);

      manager.addTuple(contents, null, ModelElement.BOUND.LOWER_BOUND, 2, Root$0, Alias$0);
      manager.addTuple(contents, null, ModelElement.BOUND.LOWER_BOUND, 2, Root$0, Directory$0);
      manager.addTuple(contents, null, ModelElement.BOUND.LOWER_BOUND, 2, Root$0, Alias$1);
      manager.addTuple(contents, null, ModelElement.BOUND.LOWER_BOUND, 2, Directory$0, Word$0);
      manager.addTuple(contents, null, ModelElement.BOUND.LOWER_BOUND, 2, Directory$0, Directory$1);
      manager.addTuple(contents, null, ModelElement.BOUND.LOWER_BOUND, 2, Directory$1, Word$1);
      manager.addTuple(contents, null, ModelElement.BOUND.LOWER_BOUND, 2, Directory$1, Word$2);
      manager.addTuple(contents, null, ModelElement.BOUND.LOWER_BOUND, 2, Directory$1, Word$3);
      manager.addTuple(contents, null, ModelElement.BOUND.LOWER_BOUND, 2, Directory$1, Alias$2);

      manager.addTuple(refs, null, ModelElement.BOUND.LOWER_BOUND, 2, Alias$2, Word$0);
      manager.addTuple(refs, null, ModelElement.BOUND.LOWER_BOUND, 2, Alias$2, Word$1);
      manager.addTuple(refs, null, ModelElement.BOUND.LOWER_BOUND, 2, Alias$2, Word$2);
      manager.addTuple(refs, null, ModelElement.BOUND.LOWER_BOUND, 2, Alias$2, Word$3);

      manager.addTuple(contents, null, ModelElement.BOUND.LOWER_BOUND, 2, Universe$0, Universe$1);
      manager.addTuple(refs, null, ModelElement.BOUND.LOWER_BOUND, 2, Universe$2, Universe$1);

      manager.addTuple(contents, null, ModelElement.BOUND.LOWER_BOUND, 2, Word$0, Directory$0);
      // refs.addTuple("",null,2,Tuple.BOUND.LOWER, Universe$1, Universe$0));
      manager.addTuple(contents, null, ModelElement.BOUND.LOWER_BOUND, 2, Universe$2, Universe$2);
    } catch (final InvalidArityException e) {
      e.printStackTrace();
    }
    return manager;
  }

  public static ModelManager createInExample() {
    final ModelManager manager = ModelManager.getInstance();

    try {
      final RelationSet Ferhat = manager.addRelationSet("Ferhat", 1);
      final RelationSet Anil = manager.addRelationSet("Anil", 1);
      final RelationSet Serhat = manager.addRelationSet("Serhat", 1);

      final Atom Ferhat$0 = manager.addAtom(Arrays.asList(new RelationSet[] {Ferhat}), null,
          ModelElement.BOUND.LOWER_BOUND);
      final Atom Ferhat$1 = manager.addAtom(Arrays.asList(new RelationSet[] {Ferhat}), null,
          ModelElement.BOUND.LOWER_BOUND);
      final Atom Ferhat$2 = manager.addAtom(Arrays.asList(new RelationSet[] {Ferhat}), null,
          ModelElement.BOUND.LOWER_BOUND);

      final Atom Anil$0 = manager.addAtom(Arrays.asList(new RelationSet[] {Anil}), null,
          ModelElement.BOUND.LOWER_BOUND);

      manager.addAtom(Arrays.asList(new RelationSet[] {Serhat}), null,
          ModelElement.BOUND.LOWER_BOUND);
      manager.addAtom(Arrays.asList(new RelationSet[] {Serhat}), null,
          ModelElement.BOUND.LOWER_BOUND);
      manager.addAtom(Arrays.asList(new RelationSet[] {Serhat}), null,
          ModelElement.BOUND.LOWER_BOUND);
      manager.addAtom(Arrays.asList(new RelationSet[] {Serhat}), null,
          ModelElement.BOUND.LOWER_BOUND);
      final Atom Serhat$4 = manager.addAtom(Arrays.asList(new RelationSet[] {Serhat}), null,
          ModelElement.BOUND.LOWER_BOUND);
      final Atom Serhat$5 = manager.addAtom(Arrays.asList(new RelationSet[] {Serhat}), null,
          ModelElement.BOUND.LOWER_BOUND);
      final Atom Serhat$6 = manager.addAtom(Arrays.asList(new RelationSet[] {Serhat}), null,
          ModelElement.BOUND.LOWER_BOUND);

      final RelationSet emre = manager.addRelationSet("emre", 2);

      manager.addTuple(emre, null, ModelElement.BOUND.LOWER_BOUND, 2, Ferhat$0, Serhat$6);
      manager.addTuple(emre, null, ModelElement.BOUND.LOWER_BOUND, 2, Ferhat$1, Serhat$5);
      manager.addTuple(emre, null, ModelElement.BOUND.LOWER_BOUND, 2, Ferhat$2, Serhat$4);
      manager.addTuple(emre, null, ModelElement.BOUND.LOWER_BOUND, 2, Ferhat$0, Anil$0);
    } catch (final InvalidArityException e) {
      e.printStackTrace();
    }
    return manager;
  }
}
