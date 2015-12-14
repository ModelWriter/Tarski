package eu.modelwriter.visualization.convertAlloyInstance.model;

import java.util.ArrayList;

public class Relation {
  public enum Multiplicity {
    ONE, LONE, SOME
  }

  private final String name;
  private final ArrayList<Tuple> tuples;
  private final ArrayList<ArrayList<Relation>> listOfTypes; // for union or difference.
  private int id;
  private Relation parent;
  private Multiplicity multiplicity;
  private boolean Abstract = false;
  private boolean Private = false;
  private boolean Meta = false;
  private boolean Enum = false;
  private boolean Builtin = false;
  private boolean Unary = false;

  public Relation(final String name) {
    this.name = name;
    this.tuples = new ArrayList<Tuple>();
    this.listOfTypes = new ArrayList<>();
    this.id = -1;
  }

  public void addAtomWithTuple(final Atom... atoms) {
    final Tuple tuple = new Tuple();
    for (final Atom atom : atoms) {
      tuple.addAtom(atom);
    }
    this.addTuple(tuple);
  }

  public void addTuple(final Tuple newTuple) {
    this.tuples.add(newTuple);
  }

  public void addTypes(final Relation... types) {
    final ArrayList<Relation> list = new ArrayList<Relation>();
    for (final Relation relation : types) {
      list.add(relation);
    }
    this.listOfTypes.add(list);
  }

  public boolean contains(final Tuple tuple) {
    for (final Tuple t : this.tuples) {
      if (t.getText().equals(tuple.getText())) {
        return true;
      }
    }
    return false;
  }

  public int getArity() {
    if (this.tuples != null && this.tuples.size() != 0) {
      return this.tuples.get(0).getArity();
    }
    return 0;
  }

  public int getId() {
    return this.id;
  }

  public ArrayList<ArrayList<Relation>> getListOfTypes() {
    return this.listOfTypes;
  }

  public Multiplicity getMultiplicity() {
    return this.multiplicity;
  }

  public String getName() {
    return this.name;
  }

  public Relation getParent() {
    return this.parent;
  }

  public Tuple getTuple(final int index) {
    return this.tuples.get(index);
  }

  public int getTupleCount() {
    return this.tuples.size();
  }

  public ArrayList<Tuple> getTuples() {
    return this.tuples;
  }

  public boolean hasSubset() {
    return this.listOfTypes.size() > 1;
  }

  public boolean isAbstract() {
    return this.Abstract;
  }

  public boolean isBuiltin() {
    return this.Builtin;
  }

  public boolean isEnum() {
    return this.Enum;
  }

  public boolean isLone() {
    return this.getMultiplicity() == null ? false
        : this.getMultiplicity().equals(Multiplicity.LONE);
  }

  public boolean isMeta() {
    return this.Meta;
  }

  public boolean isOne() {
    return this.getMultiplicity() == null ? false : this.getMultiplicity().equals(Multiplicity.ONE);
  }

  public boolean isPrivate() {
    return this.Private;
  }

  public boolean isSome() {
    return this.getMultiplicity() == null ? false
        : this.getMultiplicity().equals(Multiplicity.SOME);
  }

  public boolean isUnary() {
    return this.Unary;
  }

  public void setAbstract(final boolean Abstract) {
    this.Abstract = Abstract;
  }

  public void setBuiltin(final boolean builtin) {
    this.Builtin = builtin;
  }

  public void setEnum(final boolean Enum) {
    this.Enum = Enum;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public void setMeta(final boolean Meta) {
    this.Meta = Meta;
  }

  public void setMultiplicity(final Multiplicity multiplicity) {
    this.multiplicity = multiplicity;
  }

  public void setParent(final Relation parent) {
    this.parent = parent;
  }

  public void setPrivate(final boolean Private) {
    this.Private = Private;
  }

  public void setUnary(final boolean unary) {
    this.Unary = unary;
  }

  @Override
  public String toString() {
    String ts = "";
    for (final Tuple tuple : this.tuples) {
      ts += tuple.toString() + " ";
    }
    return this.name + "={" + ts + "};";
  }


}
