package eu.modelwriter.visualization;

import java.util.ArrayList;
import java.util.List;

public class Relation {
  private final String name;
  private final List<Tuple> tuples;
  private final List<Relation> types;
  private int id;
  private Relation parent;
  private Status statue;

  public enum Status {
    ABSTRACT, ONE, LONE, SOME, PRIVATE, META, ENUM
  }

  public Relation(String name) {
    this.name = name;
    tuples = new ArrayList<Tuple>();
    types = new ArrayList<Relation>();
    id = -1;
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

  public List<Tuple> getTuples() {
    return tuples;
  }

  public List<Relation> getTypes() {
    return types;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Relation getParent() {
    return parent;
  }

  public void setParent(Relation parent) {
    this.parent = parent;
  }

  public Status getStatue() {
    return statue;
  }

  public void setStatue(Status statue) {
    this.statue = statue;
  }

  @Override
  public String toString() {
    String ts = "";
    for (final Tuple tuple : tuples) {
      ts += tuple.toString() + " ";
    }
    return name + "={" + ts + "};";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (obj == this)
      return true;

    return this.getName().equals(((Relation) obj).getName());
  }


}
