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


import java.util.ArrayList;
import java.util.List;

/**
 * A named graph vertex with optional data.
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class Vertex<T> {
    private List<Edge<T>> incomingEdges;

    private List<Edge<T>> outgoingEdges;

    private String name;

    private boolean mark;

    private int markState;

    private T data;

    /**
     * Calls this(null, null).
     */
    public Vertex() {
        this(null, null);
    }

    /**
     * Create a vertex with the given name and no data
     *
     * @param n
     */
    public Vertex(String n) {
        this(n, null);
    }

    /**
     * Create a Vertex with name n and given data
     *
     * @param n -
     *          name of vertex
     * @param data -
     *          data associated with vertex
     */
    public Vertex(String n, T data) {
        incomingEdges = new ArrayList<>();
        outgoingEdges = new ArrayList<>();
        name = n;
        mark = false;
        this.data = data;
    }

    /**
     * @return the possibly null name of the vertex
     */
    public String getName() {
        return name;
    }

    /**
     * @return the possibly null data of the vertex
     */
    public T getData() {
        return this.data;
    }

    /**
     * @param data
     *          The data to set.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Add an edge to the vertex. If edge.from is this vertex, its an outgoing
     * edge. If edge.to is this vertex, its an incoming edge. If neither from or
     * to is this vertex, the edge is not added.
     *
     * @param e -
     *          the edge to add
     * @return true if the edge was added, false otherwise
     */
    public boolean addEdge(Edge<T> e) {
        if (e.getFrom() == this)
            outgoingEdges.add(e);
        else if (e.getTo() == this)
            incomingEdges.add(e);
        else
            return false;
        return true;
    }

    /**
     * Add an outgoing edge ending at to.
     *
     * @param to -
     *          the destination vertex
     * @param cost
     *          the edge cost
     */
    public void addOutgoingEdge(Vertex<T> to, int cost) {
        Edge<T> out = new Edge<T>(this, to, cost);
        outgoingEdges.add(out);
    }

    /**
     * Add an incoming edge starting at from
     *
     * @param from -
     *          the starting vertex
     * @param cost
     *          the edge cost
     */
    public void addIncomingEdge(Vertex<T> from, int cost) {
        Edge<T> out = new Edge<T>(this, from, cost);
        incomingEdges.add(out);
    }

    /**
     * Check the vertex for either an incoming or outgoing edge mathcing e.
     *
     * @param e
     *          the edge to check
     * @return true it has an edge
     */
    public boolean hasEdge(Edge<T> e) {
        if (e.getFrom() == this)
            return incomingEdges.contains(e);
        else if (e.getTo() == this)
            return outgoingEdges.contains(e);
        else
            return false;
    }

    /**
     * Remove an edge from this vertex
     *
     * @param e -
     *          the edge to remove
     * @return true if the edge was removed, false if the edge was not connected
     *         to this vertex
     */
    public boolean remove(Edge<T> e) {
        if (e.getFrom() == this)
            incomingEdges.remove(e);
        else if (e.getTo() == this)
            outgoingEdges.remove(e);
        else
            return false;
        return true;
    }

    /**
     *
     * @return the count of incoming edges
     */
    public int getIncomingEdgeCount() {
        return incomingEdges.size();
    }

    /**
     * Get the ith incoming edge
     *
     * @param i
     *          the index into incoming edges
     * @return ith incoming edge
     */
    public Edge<T> getIncomingEdge(int i) {
        return incomingEdges.get(i);
    }

    /**
     * Get the incoming edges
     *
     * @return incoming edge list
     */
    public List getIncomingEdges() {
        return this.incomingEdges;
    }

    /**
     *
     * @return the count of incoming edges
     */
    public int getOutgoingEdgeCount() {
        return outgoingEdges.size();
    }

    /**
     * Get the ith outgoing edge
     *
     * @param i
     *          the index into outgoing edges
     * @return ith outgoing edge
     */
    public Edge<T> getOutgoingEdge(int i) {
        return outgoingEdges.get(i);
    }

    /**
     * Get the outgoing edges
     *
     * @return outgoing edge list
     */
    public List getOutgoingEdges() {
        return this.outgoingEdges;
    }

    /**
     * Search the outgoing edges looking for an edge whose's edge.to == dest.
     *
     * @param dest
     *          the destination
     * @return the outgoing edge going to dest if one exists, null otherwise.
     */
    public Edge<T> findEdge(Vertex<T> dest) {
        for (Edge<T> e : outgoingEdges) {
            if (e.getTo() == dest)
                return e;
        }
        return null;
    }

    /**
     * Search the outgoing edges for a match to e.
     *
     * @param e -
     *          the edge to check
     * @return e if its a member of the outgoing edges, null otherwise.
     */
    public Edge<T> findEdge(Edge<T> e) {
        if (outgoingEdges.contains(e))
            return e;
        else
            return null;
    }

    /**
     * What is the cost from this vertex to the dest vertex.
     *
     * @param dest -
     *          the destination vertex.
     * @return Return Integer.MAX_VALUE if we have no edge to dest, 0 if dest is
     *         this vertex, the cost of the outgoing edge otherwise.
     */
    public int cost(Vertex<T> dest) {
        if (dest == this)
            return 0;

        Edge<T> e = findEdge(dest);
        int cost = Integer.MAX_VALUE;
        if (e != null)
            cost = e.getCost();
        return cost;
    }

    /**
     * Is there an outgoing edge ending at dest.
     *
     * @param dest -
     *          the vertex to check
     * @return true if there is an outgoing edge ending at vertex, false
     *         otherwise.
     */
    public boolean hasEdge(Vertex<T> dest) {
        return (findEdge(dest) != null);
    }

    /**
     * Has this vertex been marked during a visit
     *
     * @return true is visit has been called
     */
    public boolean visited() {
        return mark;
    }

    /**
     * Set the vertex mark flag.
     *
     */
    public void mark() {
        mark = true;
    }

    /**
     * Set the mark state to state.
     *
     * @param state
     *          the state
     */
    public void setMarkState(int state) {
        markState = state;
    }

    /**
     * Get the mark state value.
     *
     * @return the mark state
     */
    public int getMarkState() {
        return markState;
    }

    /**
     * Visit the vertex and set the mark flag to true.
     *
     */
    public void visit() {
        mark();
    }

    /**
     * Clear the visited mark flag.
     *
     */
    public void clearMark() {
        mark = false;
    }

    /**
     * @return a string form of the vertex with in and out edges.
     */
    public String toString() {
        StringBuffer tmp = new StringBuffer("Vertex(");
        tmp.append(name);
        tmp.append(", data=");
        tmp.append(data);
        tmp.append("), in:[");
        for (int i = 0; i < incomingEdges.size(); i++) {
            Edge<T> e = incomingEdges.get(i);
            if (i > 0)
                tmp.append(',');
            tmp.append('{');
            tmp.append(e.getFrom().name);
            tmp.append(',');
            tmp.append(e.getCost());
            tmp.append('}');
        }
        tmp.append("], out:[");
        for (int i = 0; i < outgoingEdges.size(); i++) {
            Edge<T> e = outgoingEdges.get(i);
            if (i > 0)
                tmp.append(',');
            tmp.append('{');
            tmp.append(e.getTo().name);
            tmp.append(',');
            tmp.append(e.getCost());
            tmp.append('}');
        }
        tmp.append(']');
        return tmp.toString();
    }
}
