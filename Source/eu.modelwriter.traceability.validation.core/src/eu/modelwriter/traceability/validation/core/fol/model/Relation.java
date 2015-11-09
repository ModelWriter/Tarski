package eu.modelwriter.traceability.validation.core.fol.model;

import java.util.ArrayList;

public class Relation {
  private final String name;
  private final ArrayList<Tuple> tuples;

  public Relation(String name) {
    this.name = name;
    tuples = new ArrayList<Tuple>();
  }

  public void addTuple(Tuple newTuple) {
    tuples.add(newTuple);
  }

  public boolean contains(Tuple tuple) {
    for (final Tuple t : tuples) {
      if (t.getText().equals(tuple.getText())) {
        return true;
      }
    }
    return false;
  }

  public int getArity() {
    if (tuples != null && tuples.size() != 0) {
      return tuples.get(0).getArity();
    }
    return 0;
  }

  public String getName() {
    return name;
  }

  public Tuple getTuple(int index) {
    return tuples.get(index);
  }

  public int getTupleCount() {
    return tuples.size();
  }

  public ArrayList<Tuple> getTuples() {
    return tuples;
  }

  @Override
  public String toString() {
    String ts = "";
    for (final Tuple tuple : tuples) {
      ts += tuple.toString() + " ";
    }
    return name + "={" + ts + "};";
  }
}
