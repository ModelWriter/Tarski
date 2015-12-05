package eu.modelwriter.visualization;

import eu.modelwriter.visualization.Relation.Multiplicity;

public class Test {

  public static void main(final String[] args) {

    final Visualization visualization = new Visualization(createFileSystemExample());
    visualization.showModel();
    // visualization.showMetamodel();
  }

  public static Universe createTestExample() {

    final Universe universe = new Universe();

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

    field1.setParent(sig1);
    field1.addTuple(tuple3);
    field1.addTuple(tuple5);
    field1.getTypes().add(sig1);
    field1.getTypes().add(sig2);


    sig1.setParent(sig3);
    sig2.setParent(sig3);

    sig3.setAbstract(true);

    universe.addRelation(sig1);
    universe.addRelation(sig2);
    universe.addRelation(sig3);
    universe.addRelation(field1);

    return universe;
  }

  public static Universe createFileSystemExample() {
    Universe universe = new Universe();

    /* Sigs definitions */
    Relation Object = new Relation("Object");
    Relation Directory = new Relation("Directory");
    Relation Root = new Relation("Root");
    Relation File = new Relation("File");
    Relation Word = new Relation("Word");
    Relation Alias = new Relation("Alias");

    Directory.setParent(Object);
    Root.setParent(Directory);
    File.setParent(Object);
    Word.setParent(File);
    Alias.setParent(Object);

    Object.setAbstract(true);
    Root.setMultiplicity(Multiplicity.ONE);

    Atom Root$0 = new Atom("Root$0");

    Atom Directory$0 = new Atom("Directory$0");
    Atom Directory$1 = new Atom("Directory$1");

    Atom Alias$0 = new Atom("Alias$0");
    Atom Alias$1 = new Atom("Alias$1");
    Atom Alias$2 = new Atom("Alias$2");

    Atom Word$0 = new Atom("Word$0");
    Atom Word$1 = new Atom("Word$1");
    Atom Word$2 = new Atom("Word$2");
    Atom Word$3 = new Atom("Word$3");


    Root.addAtomWithTuple(Root$0);

    Directory.addAtomWithTuple(Directory$0);
    Directory.addAtomWithTuple(Directory$1);

    Word.addAtomWithTuple(Word$0);
    Word.addAtomWithTuple(Word$1);
    Word.addAtomWithTuple(Word$2);
    Word.addAtomWithTuple(Word$3);

    Alias.addAtomWithTuple(Alias$0);
    Alias.addAtomWithTuple(Alias$1);
    Alias.addAtomWithTuple(Alias$2);

    /* Sigs definitions end */

    /* Fields definitions */
    Relation contents = new Relation("contents");
    Relation refs = new Relation("refs");

    contents.setParent(Directory);
    refs.setParent(Alias);

    contents.getTypes().add(Directory);
    contents.getTypes().add(Object);
    refs.getTypes().add(Alias);
    refs.getTypes().add(Word);

    contents.addAtomWithTuple(Root$0, Alias$0);
    contents.addAtomWithTuple(Root$0, Directory$0);
    contents.addAtomWithTuple(Root$0, Alias$1);
    contents.addAtomWithTuple(Directory$0, Word$0);
    contents.addAtomWithTuple(Directory$0, Directory$1);
    contents.addAtomWithTuple(Directory$1, Word$1);
    contents.addAtomWithTuple(Directory$1, Word$2);
    contents.addAtomWithTuple(Directory$1, Word$3);
    contents.addAtomWithTuple(Directory$1, Alias$2);

    refs.addAtomWithTuple(Alias$2, Word$0);
    refs.addAtomWithTuple(Alias$2, Word$1);
    refs.addAtomWithTuple(Alias$2, Word$2);
    refs.addAtomWithTuple(Alias$2, Word$3);

    /* Fields definitions end */

    universe.addRelation(Object);
    universe.addRelation(Directory);
    universe.addRelation(Root);
    universe.addRelation(File);
    universe.addRelation(Word);
    universe.addRelation(Alias);

    universe.addRelation(contents);
    universe.addRelation(refs);

    return universe;
  }

}
