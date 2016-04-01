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
import eu.modelwriter.model.Relation;
import eu.modelwriter.model.Relation.Multiplicity;
import eu.modelwriter.model.Tuple;
import eu.modelwriter.model.Universe;

public class ExampleGenerator {

  public static ModelManager createFileSystemExample() {
    final ModelManager manager = ModelManager.getInstance();
    final Universe universe = new Universe();
    manager.setUniverse(universe);

    /* Sigs definitions */
    final Relation Object = new Relation("Object");
    final Relation Directory = new Relation("Directory");
    final Relation Root = new Relation("Root");
    final Relation File = new Relation("File");
    final Relation Word = new Relation("Word");
    final Relation Alias = new Relation("Alias");
    final Relation Abc = new Relation();

    Root.setMultiplicity(Multiplicity.ONE);

    final Atom Root$0 = new Atom();

    final Atom Directory$0 = new Atom();
    final Atom Directory$1 = new Atom();

    final Atom Alias$0 = new Atom();
    final Atom Alias$1 = new Atom();
    final Atom Alias$2 = new Atom();

    final Atom Word$0 = new Atom();
    final Atom Word$1 = new Atom();
    final Atom Word$2 = new Atom();
    final Atom Word$3 = new Atom();

    final Atom Universe$0 = new Atom();
    final Atom Universe$1 = new Atom();
    final Atom Universe$2 = new Atom();

    Root.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Root$0));

    Directory.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Directory$0));
    Directory.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Directory$1));

    Word.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Word$0));
    Word.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Word$1));
    Word.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Word$2));
    Word.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Word$3));

    Alias.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Alias$0));
    Alias.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Alias$1));
    Alias.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Alias$2));

    Abc.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Universe$0));
    Abc.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Universe$1));
    Abc.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Universe$2));

    /* Sigs definitions end */

    /* Fields definitions */
    final Relation contents = new Relation("contents");
    final Relation refs = new Relation("refs");

    contents.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Root$0, Alias$0));
    contents.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Root$0, Directory$0));
    contents.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Root$0, Alias$1));
    contents.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Directory$0, Word$0));
    contents.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Directory$0, Directory$1));
    contents.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Directory$1, Word$1));
    contents.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Directory$1, Word$2));
    contents.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Directory$1, Word$3));
    contents.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Directory$1, Alias$2));

    refs.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Alias$2, Word$0));
    refs.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Alias$2, Word$1));
    refs.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Alias$2, Word$2));
    refs.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Alias$2, Word$3));

    contents.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Universe$0, Universe$1));
    refs.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Universe$2, Universe$1));

    contents.addTuple(ExampleGenerator.wrapTupleWithBound("lower", Word$0, Directory$0));

    /* Fields definitions end */

    universe.addRelation(Object);
    universe.addRelation(Directory);
    universe.addRelation(Root);
    universe.addRelation(File);
    universe.addRelation(Word);
    universe.addRelation(Alias);
    universe.addRelation(Abc);

    universe.addRelation(contents);
    universe.addRelation(refs);

    return manager;
  }

  public static ModelManager createInExample() {
    final ModelManager manager = ModelManager.getInstance();
    final Universe universe = new Universe();
    manager.setUniverse(universe);

    final Relation Ferhat = new Relation("Ferhat");
    final Relation Anil = new Relation("Anil");
    final Relation Serhat = new Relation("Serhat");

    final Atom Ferhat$0 = new Atom("Ferhat$0");
    final Atom Ferhat$1 = new Atom("Ferhat$1");
    final Atom Ferhat$2 = new Atom("Ferhat$2");

    final Atom Anil$0 = new Atom("Anil$0");

    final Atom Serhat$0 = new Atom("Serhat$0");
    final Atom Serhat$1 = new Atom("Serhat$1");
    final Atom Serhat$2 = new Atom("Serhat$2");
    final Atom Serhat$3 = new Atom("Serhat$3");
    final Atom Serhat$4 = new Atom("Serhat$4");
    final Atom Serhat$5 = new Atom("Serhat$5");
    final Atom Serhat$6 = new Atom("Serhat$6");


    Ferhat.addAtomWithTuple(Ferhat$0);
    Ferhat.addAtomWithTuple(Ferhat$1);
    Ferhat.addAtomWithTuple(Ferhat$2);

    Anil.addAtomWithTuple(Anil$0);

    Serhat.addAtomWithTuple(Serhat$0);
    Serhat.addAtomWithTuple(Serhat$1);
    Serhat.addAtomWithTuple(Serhat$2);
    Serhat.addAtomWithTuple(Serhat$3);
    Serhat.addAtomWithTuple(Serhat$4);
    Serhat.addAtomWithTuple(Serhat$5);
    Serhat.addAtomWithTuple(Serhat$6);


    final Relation emre = new Relation("emre");

    emre.addAtomWithTuple(Ferhat$0, Serhat$6);
    emre.addAtomWithTuple(Ferhat$1, Serhat$5);
    emre.addAtomWithTuple(Ferhat$2, Serhat$4);
    emre.addAtomWithTuple(Ferhat$0, Anil$0);

    universe.addRelation(Ferhat);
    universe.addRelation(Anil);
    universe.addRelation(Serhat);
    universe.addRelation(emre);

    return manager;
  }

  public static ModelManager createTestExample() {
    final ModelManager manager = ModelManager.getInstance();
    final Universe universe = new Universe();
    manager.setUniverse(universe);

    final Relation sig1 = new Relation("A");
    final Relation sig2 = new Relation("B");
    final Relation sig3 = new Relation("C");
    final Relation field1 = new Relation("X");

    final Tuple tuple1 = new Tuple("tuple1");
    final Tuple tuple2 = new Tuple("tuple2");
    final Tuple tuple3 = new Tuple("tuple3");
    final Tuple tuple4 = new Tuple("tuple4");
    final Tuple tuple5 = new Tuple("tuple5");

    final Atom atom1 = new Atom("atom1");
    final Atom atom2 = new Atom("atom2");
    final Atom atom3 = new Atom("atom3");

    tuple1.addAtom(atom1);
    sig1.addTuple(tuple1);

    tuple2.addAtom(atom2);
    sig2.addTuple(tuple2);

    tuple4.addAtom(atom3);
    sig2.addTuple(tuple4);

    tuple3.addAtom(atom1);
    tuple3.addAtom(atom2);

    tuple5.addAtom(atom1);
    tuple5.addAtom(atom3);

    field1.addTuple(tuple3);
    field1.addTuple(tuple5);

    universe.addRelation(sig1);
    universe.addRelation(sig2);
    universe.addRelation(sig3);
    universe.addRelation(field1);

    return manager;
  }

  public static void main(final String[] args) {}

  private static Tuple wrapTupleWithBound(final String bound, final Atom... atoms) {
    final Tuple tuple = new Tuple();
    for (final Atom atom : atoms) {
      tuple.addAtom(atom);
    }
    tuple.setBound(bound.toLowerCase());
    return tuple;
  }
}
