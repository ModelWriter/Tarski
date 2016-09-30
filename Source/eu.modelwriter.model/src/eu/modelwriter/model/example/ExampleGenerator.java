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

import eu.modelwriter.model.ModelElement;
import eu.modelwriter.model.ModelManager;
import eu.modelwriter.model.exception.InvalidArityException;
import eu.modelwriter.model.exception.NoSuchModelElementException;

public class ExampleGenerator {

  public static ModelManager createFileSystemExample() {
    final ModelManager manager = ModelManager.instance;

    try {
      manager.addRelation("Object", 1);
      final String Directory = manager.addRelation("Directory", 1);
      final String Root = manager.addRelation("Root", 1);
      manager.addRelation("File", 1);
      final String Word = manager.addRelation("Word", 1);
      final String Alias = manager.addRelation("Alias", 1);

      final String List = manager.addRelation("List", 1);
      final String EmptyList = manager.addRelation("EmptyList", 1);

      manager.addAtom(Arrays.asList(new String[] {List, EmptyList}), "List, EmptyList", null,
          ModelElement.BOUND.LOWER_BOUND);

      /** Atoms **/
      final String Root$0 = manager.addAtom(Arrays.asList(new String[] {Root}), "Root$0", null,
          ModelElement.BOUND.LOWER_BOUND);

      final String Directory$0 =
          manager.addAtom(Arrays.asList(new String[] {Directory}), "Directory$0", null,
              ModelElement.BOUND.LOWER_BOUND);
      final String Directory$1 =
          manager.addAtom(Arrays.asList(new String[] {Directory}), "Directory$1", null,
              ModelElement.BOUND.LOWER_BOUND);

      final String Alias$0 = manager.addAtom(Arrays.asList(new String[] {Alias}), "Alias$0", null,
          ModelElement.BOUND.LOWER_BOUND);
      final String Alias$1 = manager.addAtom(Arrays.asList(new String[] {Alias}), "Alias$1", null,
          ModelElement.BOUND.LOWER_BOUND);
      final String Alias$2 = manager.addAtom(Arrays.asList(new String[] {Alias}), "Alias$2", null,
          ModelElement.BOUND.LOWER_BOUND);

      final String Word$0 = manager.addAtom(Arrays.asList(new String[] {Word}), "Word$0", null,
          ModelElement.BOUND.LOWER_BOUND);
      final String Word$1 = manager.addAtom(Arrays.asList(new String[] {Word}), "Word$1", null,
          ModelElement.BOUND.LOWER_BOUND);
      final String Word$2 = manager.addAtom(Arrays.asList(new String[] {Word}), "Word$2", null,
          ModelElement.BOUND.LOWER_BOUND);
      final String Word$3 = manager.addAtom(Arrays.asList(new String[] {Word}), "Word$3", null,
          ModelElement.BOUND.LOWER_BOUND);

      final String Universe$0 =
          manager.addAtom(null, "Universe$0", null, ModelElement.BOUND.LOWER_BOUND);
      final String Universe$1 =
          manager.addAtom(null, "Universe$1", null, ModelElement.BOUND.LOWER_BOUND);
      final String Universe$2 =
          manager.addAtom(null, "Universe$2", null, ModelElement.BOUND.LOWER_BOUND);
      /** Atoms **/

      final String contents = manager.addRelation("contents", 2);
      final String refs = manager.addRelation("refs", 2);

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
      manager.addTuple(contents, null, ModelElement.BOUND.LOWER_BOUND, 2, Universe$2, Universe$2);
    } catch (final InvalidArityException | NoSuchModelElementException e) {
      e.printStackTrace();
    }
    return manager;
  }

  public static ModelManager createInExample() {
    final ModelManager manager = ModelManager.instance;

    try {
      final String Ferhat = manager.addRelation("Ferhat", 1);
      final String Anil = manager.addRelation("Anil", 1);
      final String Serhat = manager.addRelation("Serhat", 1);

      final String Ferhat$0 =
          manager.addAtom(Arrays.asList(new String[] {Ferhat}), "Ferhat$0", null,
              ModelElement.BOUND.LOWER_BOUND);
      final String Ferhat$1 =
          manager.addAtom(Arrays.asList(new String[] {Ferhat}), "Ferhat$1", null,
              ModelElement.BOUND.LOWER_BOUND);
      final String Ferhat$2 =
          manager.addAtom(Arrays.asList(new String[] {Ferhat}), "Ferhat$2", null,
              ModelElement.BOUND.LOWER_BOUND);

      final String Anil$0 = manager.addAtom(Arrays.asList(new String[] {Anil}), "Anil$0", null,
          ModelElement.BOUND.LOWER_BOUND);

      manager.addAtom(Arrays.asList(new String[] {Serhat}), "Serhat$1", null,
          ModelElement.BOUND.LOWER_BOUND);
      manager.addAtom(Arrays.asList(new String[] {Serhat}), "Serhat$2", null,
          ModelElement.BOUND.LOWER_BOUND);
      manager.addAtom(Arrays.asList(new String[] {Serhat}), "Serhat$3", null,
          ModelElement.BOUND.LOWER_BOUND);
      final String Serhat$4 =
          manager.addAtom(Arrays.asList(new String[] {Serhat}), "Serhat$4", null,
              ModelElement.BOUND.LOWER_BOUND);
      final String Serhat$5 =
          manager.addAtom(Arrays.asList(new String[] {Serhat}), "Serhat$5", null,
              ModelElement.BOUND.LOWER_BOUND);
      final String Serhat$6 = manager.addAtom(Arrays.asList(new String[] {Serhat}), "Serhat$6",
          null,
          ModelElement.BOUND.LOWER_BOUND);

      final String emre = manager.addRelation("emre", 2);

      manager.addTuple(emre, null, ModelElement.BOUND.LOWER_BOUND, 2, Ferhat$0, Serhat$6);
      manager.addTuple(emre, null, ModelElement.BOUND.LOWER_BOUND, 2, Ferhat$1, Serhat$5);
      manager.addTuple(emre, null, ModelElement.BOUND.LOWER_BOUND, 2, Ferhat$2, Serhat$4);
      manager.addTuple(emre, null, ModelElement.BOUND.LOWER_BOUND, 2, Ferhat$0, Anil$0);
    } catch (final InvalidArityException | NoSuchModelElementException e) {
      e.printStackTrace();
    }
    return manager;
  }
}
