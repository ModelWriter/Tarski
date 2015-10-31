package eu.modelwriter.traceability.validation.core.fol.model;

import java.util.ArrayList;

public class Relation {
  private String name;
  private ArrayList<Tuple> tuples;

  public Relation(String name) {
    this.name = name;
    this.tuples = new ArrayList<Tuple>();
  }

  public void addTuple(Tuple newTuple) {
    this.tuples.add(newTuple);
  }

  public boolean contains(Tuple tuple) {
    for (Tuple t : this.tuples) {
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

  public String getName() {
    return this.name;
  }

  public Tuple getTuple(int index) {
    return this.tuples.get(index);
  }

  public int getTupleCount() {
    return this.tuples.size();
  }

  public ArrayList<Tuple> getTuples() {
    return this.tuples;
  }

  @Override
  public String toString() {
    String ts = "";
    for (Tuple tuple : this.tuples) {
      ts += tuple.toString() + " ";
    }
    return this.name + "={" + ts + "};";
  }
}
