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

package eu.modelwriter.core.alloyinecore.structure.graph;

/**
 * A directed, weighted edge in a graph
 *
 * @param <T>
 */
public class Edge<T> {
    private Vertex<T> from;

    private Vertex<T> to;

    private int cost;

    private boolean mark;

    /**
     * Create a zero cost edge between from and to
     *
     * @param from
     *          the starting vertex
     * @param to
     *          the ending vertex
     */
    public Edge(Vertex<T> from, Vertex<T> to) {
        this(from, to, 0);
    }

    /**
     * Create an edge between from and to with the given cost.
     *
     * @param from
     *          the starting vertex
     * @param to
     *          the ending vertex
     * @param cost
     *          the cost of the edge
     */
    public Edge(Vertex<T> from, Vertex<T> to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
        mark = false;
    }

    /**
     * Get the ending vertex
     *
     * @return ending vertex
     */
    public Vertex<T> getTo() {
        return to;
    }

    /**
     * Get the starting vertex
     *
     * @return starting vertex
     */
    public Vertex<T> getFrom() {
        return from;
    }

    /**
     * Get the cost of the edge
     *
     * @return cost of the edge
     */
    public int getCost() {
        return cost;
    }

    /**
     * Set the mark flag of the edge
     *
     */
    public void mark() {
        mark = true;
    }

    /**
     * Clear the edge mark flag
     *
     */
    public void clearMark() {
        mark = false;
    }

    /**
     * Get the edge mark flag
     *
     * @return edge mark flag
     */
    public boolean isMarked() {
        return mark;
    }

    /**
     * String rep of edge
     *
     * @return string rep with from/to vertex names and cost
     */
    public String toString() {
        StringBuffer tmp = new StringBuffer("Edge[from: ");
        tmp.append(from.getName());
        tmp.append(",to: ");
        tmp.append(to.getName());
        tmp.append(", cost: ");
        tmp.append(cost);
        tmp.append("]");
        return tmp.toString();
    }
}
