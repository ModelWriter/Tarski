/*
 * Alloy Analyzer 4 -- Copyright (c) 2006-2009, Felix Chang
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.mit.csail.sdg.alloy4viz;

import java.util.ArrayList;

/**
 * Immutable; represents an Alloy atom in an instance.
 *
 * <p>
 * <b>Thread Safety:</b> Can be called only by the AWT event thread.
 */

public final class AlloyAtom implements Comparable<AlloyAtom> {

  public boolean changed = false;

  public ArrayList<String> impacted = new ArrayList<>();

  /** The original name of this atom from the original Kodkod or other analysis. */
  private final String originalName;

  /** The most specific AlloyType that this atom belongs to. */
  private final AlloyType type;

  /**
   * The index is a number that differentiates atoms of the same AlloyType; one special convention:
   * (this atom is the only atom with this type) iff (index==Integer.MAX_VALUE)
   */
  private final int index;

  /** Create a new AlloyAtom with the given type and index. */
  public AlloyAtom(final AlloyType type, final int index) {
    this.type = type;
    this.index = index;
    this.originalName = type.getName() + "." + index;
  }

  /** Create a new AlloyAtom with the given type, index, and label. */
  public AlloyAtom(final AlloyType type, final int index, final String originalName) {
    this.type = type;
    this.index = index;
    this.originalName = originalName;
  }

  /**
   * Compare first by type, then by index, then by the original names. <br>
   * We guarantee x.equals(y) iff x.compareTo(y)==0
   *
   * <p>
   * As a special cosmetic enhancement: if we're comparing integer atoms, we want to ignore the
   * difference between seqInt and Int.
   */
  @Override
  public int compareTo(final AlloyAtom otherAtom) {
    if (otherAtom == null) {
      return 1;
    }
    AlloyType at = this.type;
    if (at.equals(AlloyType.SEQINT)) {
      at = AlloyType.INT;
    }
    AlloyType bt = otherAtom.type;
    if (bt.equals(AlloyType.SEQINT)) {
      bt = AlloyType.INT;
    }
    // This renaming is necessary in order to make sure the comparison is transitive.
    // For example, assuming seq/Int comprises 0..3, then we want atom0 < atom5,
    // even though atom0's TYPENAME > atom5's TYPENAME.
    // On the other hand, if you have an atom X with type X, then we want to make sure X>5 just like
    // X>0
    // (even though lexically, the type name "X" < the type name "seq/Int"
    if (at.equals(AlloyType.INT) && bt.equals(AlloyType.INT)) {
      return this.index < otherAtom.index ? -1 : this.index > otherAtom.index ? 1 : 0;
    }
    final int result = at.compareTo(bt);
    if (result != 0) {
      return result;
    }
    // We don't want to use the "return (index-otherAtom.index);" trick,
    // especially since singleton sets will have index of Integer.MAX_VALUE.
    if (this.index != otherAtom.index) {
      return this.index < otherAtom.index ? -1 : 1;
    }
    return this.originalName.compareTo(otherAtom.originalName);
  }

  /** Two AlloyAtoms are equal if they have the same type, same index, and same original name. */
  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof AlloyAtom)) {
      return false;
    }
    if (other == this) {
      return true;
    }
    final AlloyAtom otherAtom = (AlloyAtom) other;
    return this.index == otherAtom.index && this.type.equals(otherAtom.type)
        && this.originalName.equals(otherAtom.originalName);
  }

  public String getOriginalName() {
    return this.originalName;
  }

  /** Return the type of the AlloyAtom. */
  public AlloyType getType() {
    return this.type;
  }

  /**
   * Return a label for this atom as recommended by a theme (theme can be null if there's no theme
   * to consult).
   */
  public String getVizName(final VizState theme, final boolean numberAtoms) {
    if (theme != null) {
      if (theme.useOriginalName() || this.type.getName().equals("String")) {
        return this.originalName;
      }
      if (this.index == Integer.MAX_VALUE && this.type.getName().equals("Int")
          && theme.label.get(this.type).length() == 0) {
        // Special handling for Meta Model. (Only meta model could have index==MAX_VALUE)
        return "Int";
      }
      if (this.index == Integer.MIN_VALUE && this.type.getName().equals("seq/Int")
          && theme.label.get(this.type).length() == 0) {
        // Special handling for Meta Model. (Only meta model could have index==MIN_VALUE)
        return "seq/Int";
      }
      if (this.index == Integer.MAX_VALUE || !numberAtoms) {
        return theme.label.get(this.type);
      } else {
        return theme.label.get(this.type) + this.index;
      }
    }
    if (this.type.getName().equals("Int")) {
      return "" + this.index; // Special override to display integers better
    }
    if (this.type.getName().equals("seq/Int")) {
      return "" + this.index; // Special override to display integers better
    }
    if (this.index == Integer.MAX_VALUE || !numberAtoms) {
      return this.type.getName();
    } else {
      return this.type.getName() + this.index;
    }
  }

  /** Returns a hash code based on the type and index. */
  @Override
  public int hashCode() {
    return 7 * this.type.hashCode() + 5 * this.index + 17 * this.originalName.hashCode();
  }

  /** Provides a human-readable label for debugging purpose. */
  @Override
  public String toString() {
    return this.getVizName(null, true);
  }
}
