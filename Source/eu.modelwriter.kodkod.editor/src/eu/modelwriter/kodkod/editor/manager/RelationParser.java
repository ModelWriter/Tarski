package eu.modelwriter.kodkod.editor.manager;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class RelationParser {

  private class TupleSet {
    private final ArrayList<String> tuples;

    public TupleSet() {
      this.tuples = new ArrayList<String>();
    }

    public void addTuple(final String tuple) {
      this.tuples.add(tuple);
    }

    @Override
    public boolean equals(final Object obj) {
      if (obj == null) {
        return false;
      }
      if (obj == this) {
        return true;
      }

      for (final String tuple : ((TupleSet) obj).tuples) {
        if (!this.tuples.contains(tuple)) {
          return false;
        }
      }

      return true;
    }

    public void removeTuple(final String tuple) {
      this.tuples.remove(tuple);
    }

    @Override
    public String toString() {
      String result = "[";
      for (int i = 0; i < this.tuples.size(); i++) {
        if (i == 0) {
          result += this.tuples.get(i);
        } else {
          result += "," + this.tuples.get(i);
        }
      }
      result += "]";

      return result;
    }
  }

  private final String relationData;
  private String lowerBoundData;
  private String upperBoundData;
  private final TupleSet lowerTupleSet;
  private final TupleSet upperTupleSet;

  public RelationParser(final String relation) {
    this.relationData = relation;
    this.lowerTupleSet = new TupleSet();
    this.upperTupleSet = new TupleSet();

    try {
      this.init();
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  public void init() throws IOException {
    final StringReader reader = new StringReader(this.relationData);

    int open = 0;
    int offset = 1;
    int c = reader.read();
    while (c != -1) {
      if (c == '[' || c == '{') {
        open++;
      } else if (c == ']' || c == '}') {
        open--;
      }

      if (open == 1 && c == ',') {
        reader.close();
        break;
      }

      offset++;
      c = reader.read();
    }
    reader.close();

    if (offset > this.relationData.length()) {
      this.lowerBoundData =
          this.relationData.substring(this.relationData.indexOf("[") + 1, offset - 2);
      this.upperBoundData = this.relationData.substring(offset - 2, this.relationData.length() - 1);
    } else {
      this.lowerBoundData =
          this.relationData.substring(this.relationData.indexOf("[") + 1, offset - 1);
      this.upperBoundData = this.relationData.substring(offset, this.relationData.length() - 1);
    }

    this.parse2Tuples();
  }

  public void move2Lower(final String tuple) {
    this.lowerTupleSet.addTuple(tuple);
    if (this.lowerTupleSet.equals(this.upperTupleSet)) {
      this.upperTupleSet.tuples.clear();
    }
  }

  public void move2Upper(final String tuple) {
    if (this.upperTupleSet.tuples.isEmpty()) {
      this.upperTupleSet.tuples.addAll(this.lowerTupleSet.tuples);
      this.lowerTupleSet.removeTuple(tuple);
    } else {
      this.upperTupleSet.addTuple(tuple);
      this.lowerTupleSet.removeTuple(tuple);
    }
  }

  private void parse2Tuples() {
    if (!this.lowerBoundData.isEmpty()) {
      this.lowerBoundData = this.lowerBoundData.substring(this.lowerBoundData.indexOf("[") + 1,
          this.lowerBoundData.lastIndexOf("]"));

      final String ltuples[] = this.lowerBoundData.split(",");
      for (final String tuple : ltuples) {
        if (!tuple.isEmpty()) {
          this.lowerTupleSet.addTuple(tuple.trim());
        }
      }
    }

    if (!this.upperBoundData.isEmpty()) {
      this.upperBoundData = this.upperBoundData.substring(this.upperBoundData.indexOf("[") + 1,
          this.upperBoundData.lastIndexOf("]"));

      final String utuples[] = this.upperBoundData.split(",");
      for (final String tuple : utuples) {
        if (!tuple.isEmpty()) {
          this.upperTupleSet.addTuple(tuple.trim());
        }
      }
    }
  }

  public void removeTuples(final ArrayList<String> relatedTuples) {
    for (final String tuple : relatedTuples) {
      this.lowerTupleSet.removeTuple(tuple);
      this.upperTupleSet.removeTuple(tuple);
    }
  }

  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder(this.relationData);
    builder.delete(builder.indexOf("[") + 1, builder.lastIndexOf("]"));
    builder.insert(builder.indexOf("[") + 1,
        this.lowerTupleSet.toString() + "," + this.upperTupleSet.toString());

    return builder.toString();
  }
}
