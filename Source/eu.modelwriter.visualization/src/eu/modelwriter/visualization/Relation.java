package eu.modelwriter.visualization;

import java.util.ArrayList;
import java.util.List;

public class Relation {
  private final String name;
  private final List<Tuple> tuples;
  private final List<Relation> types;
  private int id;
  private Relation parent;
  private boolean Abstract = false;
  private boolean One = false;
  private boolean Lone = false;
  private boolean Some = false;
  private boolean Private = false;
  private boolean Meta = false;
  private boolean Enum = false;


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

  public boolean isAbstract() {
    return Abstract;
  }

  public void setAbstract(boolean Abstract) {
    this.Abstract = Abstract;
  }

  public boolean isOne() {
    return One;
  }

  public void setOne(boolean one) {
    One = one;
  }

  public boolean isLone() {
    return Lone;
  }

  public void setLone(boolean lone) {
    Lone = lone;
  }

  public boolean isSome() {
    return Some;
  }

  public void setSome(boolean some) {
    Some = some;
  }

  public boolean isPrivate() {
    return Private;
  }

  public void setPrivate(boolean private1) {
    Private = private1;
  }

  public boolean isMeta() {
    return Meta;
  }

  public void setMeta(boolean meta) {
    Meta = meta;
  }

  public boolean isEnum() {
    return Enum;
  }

  public void setEnum(boolean enum1) {
    Enum = enum1;
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
