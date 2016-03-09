package eu.modelwriter.visualization.editor.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OurUtil {
  /**
   * Return an iterable whose iterator is a read-only iterator that first iterate over Collection1,
   * and then Collection2.
   */
  public static <E> Iterable<E> fastJoin(final Iterable<E> collection1,
      final Iterable<E> collection2) {
    return new Iterable<E>() {
      @Override
      public Iterator<E> iterator() {
        return new Iterator<E>() {
          private Iterator<E> a = collection1.iterator(), b = collection2.iterator();

          @Override
          public boolean hasNext() {
            if (this.a != null) {
              if (this.a.hasNext()) {
                return true;
              }
              this.a = null;
            }
            if (this.b != null) {
              if (this.b.hasNext()) {
                return true;
              }
              this.b = null;
            }
            return false;
          }

          @Override
          public E next() {
            if (this.a != null) {
              if (this.a.hasNext()) {
                return this.a.next();
              }
              this.a = null;
            }
            if (this.b != null) {
              if (this.b.hasNext()) {
                return this.b.next();
              }
              this.b = null;
            }
            throw new NoSuchElementException();
          }

          @Override
          public void remove() {
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }
}
