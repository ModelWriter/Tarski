package eu.modelwriter.visualization;

public class Test {

  public static void main(final String[] args) {

    final Universe universe = new Universe();

    final Relation sig1 = new Relation("sig1");
    final Relation sig2 = new Relation("sig2");
    final Relation sig3 = new Relation("sig3");
    final Relation field1 = new Relation("field1");

    final Tuple tuple1 = new Tuple("tuple1");
    final Tuple tuple2 = new Tuple("tuple2");
    final Tuple tuple3 = new Tuple("tuple3");

    final Atom atom1 = new Atom("atom1");
    final Atom atom2 = new Atom("atom2");

    tuple1.addAtom(atom1);
    sig1.addTuple(tuple1);

    tuple2.addAtom(atom2);
    sig2.addTuple(tuple2);

    tuple3.addAtom(atom1);
    tuple3.addAtom(atom2);

    field1.setParent(sig1);
    field1.addTuple(tuple3);
    field1.getTypes().add(sig1);
    field1.getTypes().add(sig2);

    sig1.setParent(sig3);
    sig2.setParent(sig3);

    sig3.setAbstract(true);

    universe.addRelation(sig1);
    universe.addRelation(sig2);
    universe.addRelation(sig3);
    universe.addRelation(field1);

    final Visualization visualization = new Visualization(universe);
    visualization.visualize();
  }
}
