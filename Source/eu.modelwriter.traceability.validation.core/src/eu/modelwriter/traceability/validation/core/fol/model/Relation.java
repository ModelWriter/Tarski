package eu.modelwriter.traceability.validation.core.fol.model;

import java.util.ArrayList;

public class Relation {
  private String name;
  private ArrayList<Tuple> tuples;
  private int arity;

  public Relation(String name) {
    this.name = name;
    this.tuples = new ArrayList<Tuple>();
    this.arity = 0;
  }

  public void addTuple(Tuple newTuple) {
    this.tuples.add(newTuple);
    this.arity++;
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
    return this.arity;
  }

  public String getName() {
    return this.name;
  }

  public int getTupleCount() {
    return this.tuples.size();
  }

  public ArrayList<Tuple> getTuples() {
    return this.tuples;
  }
}
