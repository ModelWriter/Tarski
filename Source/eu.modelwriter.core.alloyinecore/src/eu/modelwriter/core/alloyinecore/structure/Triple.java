/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016, Ferhat Erata <ferhat@computer.org>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package eu.modelwriter.core.alloyinecore.structure;

import java.io.Serializable;

/**
 * <p>A triple consisting of three elements.</p>
 * <p/>
 * <p>This class is an abstract implementation defining the basic API. It refers to the elements as
 * 'left', 'middle' and 'right'.</p>
 * <p/>
 * <p>Subclass implementations may be mutable or immutable. However, there is no restriction on the
 * type of the stored objects that may be stored. If mutable objects are stored in the triple, then
 * the triple itself effectively becomes mutable.</p>
 *
 * @param <L>
 *         the left element type
 * @param <M>
 *         the middle element type
 * @param <R>
 *         the right element type
 *
 */
public abstract class Triple<L, M, R>
        implements Comparable<Triple<L, M, R>>, Serializable
{

    /**
     * Serialization version
     */
    private static final long serialVersionUID = 1L;


    /**
     * <p>Obtains an immutable triple of from three objects inferring the generic types.</p>
     * <p/>
     * <p>This factory allows the triple to be created using inference to obtain the generic
     * types.</p>
     *
     * @param <L>
     *         the left element type
     * @param <M>
     *         the middle element type
     * @param <R>
     *         the right element type
     * @param left
     *         the left element, may be null
     * @param middle
     *         the middle element, may be null
     * @param right
     *         the right element, may be null
     *
     * @return a triple formed from the three parameters, not null
     */
    public static <L, M, R> Triple<L, M, R> of(
            final L left,
            final M middle,
            final R right)
    {
        return new ImmutableTriple<>(left, middle, right);
    }

    //-----------------------------------------------------------------------


    /**
     * <p>Gets the left element from this triple.</p>
     *
     * @return the left element, may be null
     */
    public abstract L getLeft();

    /**
     * <p>Gets the middle element from this triple.</p>
     *
     * @return the middle element, may be null
     */
    public abstract M getMiddle();

    /**
     * <p>Gets the right element from this triple.</p>
     *
     * @return the right element, may be null
     */
    public abstract R getRight();

    //-----------------------------------------------------------------------


    /**
     * <p>Compares the triple based on the left element, followed by the middle element, finally the
     * right element. The types must be {@code Comparable}.</p>
     *
     * @param other
     *         the other triple, not null
     *
     * @return negative if this is less, zero if equal, positive if greater
     */
    @Override
    public int compareTo(final Triple<L, M, R> other)
    {
        @SuppressWarnings("unchecked") // assume this can be done; if not throw CCE as per Javadoc
        final Comparable<Object> comparableLeft = (Comparable<Object>) getLeft();
        int cmpLeft = comparableLeft.compareTo(other.getLeft());

        if (cmpLeft != 0) {
            return cmpLeft;
        }

        @SuppressWarnings("unchecked") // assume this can be done; if not throw CCE as per Javadoc
        final Comparable<Object> comparableMidle = (Comparable<Object>) getMiddle();
        int cmpMidle = comparableMidle.compareTo(other.getMiddle());

        if (cmpMidle != 0) {
            return cmpMidle;
        }

        @SuppressWarnings("unchecked") // assume this can be done; if not throw CCE as per Javadoc
        final Comparable<Object> comparableRight = (Comparable<Object>) getRight();
        int cmpRight = comparableRight.compareTo(other.getRight());

        return cmpRight;
    }


    /**
     * <p>Compares this triple to another based on the three elements.</p>
     *
     * @param obj
     *         the object to compare to, null returns false
     *
     * @return true if the elements of the triple are equal
     */
    @Override
    public boolean equals(final Object obj)
    {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Triple<?, ?, ?>) {
            final Triple<?, ?, ?> other = (Triple<?, ?, ?>) obj;


            return equals(getLeft(), other.getLeft()) &&
                    equals(getMiddle(), other.getMiddle()) &&
                    equals(getRight(), other.getRight());
        }
        return false;
    }


    private boolean equals(
            final Object object1,
            final Object object2)
    {
        return !(object1 == null || object2 == null) &&
                (object1 == object2 || object1.equals(object2));
    }


    /**
     * <p>Returns a suitable hash code.</p>
     *
     * @return the hash code
     */
    @Override
    public int hashCode()
    {
        return (getLeft() == null ? 0 : getLeft().hashCode()) ^
                (getMiddle() == null ? 0 : getMiddle().hashCode()) ^
                (getRight() == null ? 0 : getRight().hashCode());
    }


    /**
     * <p>Returns a String representation of this triple using the format {@code
     * ($left, $middle, $right)}.</p>
     *
     * @return a string describing this object, not null
     */
    @Override
    public String toString()
    {
        return new StringBuilder().append('(')
                .append(getLeft())
                .append(',')
                .append(getMiddle())
                .append(',')
                .append(getRight())
                .append(')')
                .toString();
    }


    /**
     * <p>Formats the receiver using the given format.</p>
     * <p/>
     * <p>This uses {@link java.util.Formattable} to perform the formatting. Three variables may be
     * used to embed the left and right elements. Use {@code %1$s} for the left element, {@code
     * %2$s} for the middle and {@code %3$s} for the right element. The default format used by
     * {@code toString()} is {@code (%1$s,%2$s,%3$s)}.</p>
     *
     * @param format
     *         the format string, optionally containing {@code %1$s}, {@code %2$s} and {@code %3$s},
     *         not null
     *
     * @return the formatted string, not null
     */
    public String toString(final String format)
    {
        return String.format(format, getLeft(), getMiddle(), getRight());
    }
}
