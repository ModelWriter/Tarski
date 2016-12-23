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
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * A directed graph data structure.
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class Graph<T> {
    /** Color used to mark unvisited nodes */
    public static final int VISIT_COLOR_WHITE = 1;

    /** Color used to mark nodes as they are first visited in DFS order */
    public static final int VISIT_COLOR_GREY = 2;

    /** Color used to mark nodes after descendants are completely visited */
    public static final int VISIT_COLOR_BLACK = 3;

    /** Vector<Vertex> of graph verticies */
    private List<Vertex<T>> verticies;

    /** Vector<Edge> of edges in the graph */
    private List<Edge<T>> edges;

    /** The vertex identified as the root of the graph */
    private Vertex<T> rootVertex;

    /**
     * Construct a new graph without any vertices or edges
     */
    public Graph() {
        verticies = new ArrayList<>();
        edges = new ArrayList<>();
    }

    /**
     * Are there any verticies in the graph
     *
     * @return true if there are no verticies in the graph
     */
    public boolean isEmpty() {
        return verticies.size() == 0;
    }

    /**
     * Add a vertex to the graph
     *
     * @param v
     *          the Vertex to add
     * @return true if the vertex was added, false if it was already in the graph.
     */
    public boolean addVertex(Vertex<T> v) {
        boolean added = false;
        if (!verticies.contains(v)) {
            added = verticies.add(v);
        }
        return added;
    }

    /**
     * Get the vertex count.
     *
     * @return the number of verticies in the graph.
     */
    public int size() {
        return verticies.size();
    }

    /**
     * Get the root vertex
     *
     * @return the root vertex if one is set, null if no vertex has been set as
     *         the root.
     */
    public Vertex<T> getRootVertex() {
        return rootVertex;
    }

    /**
     * Set a root vertex. If root does no exist in the graph it is added.
     *
     * @param root -
     *          the vertex to set as the root and optionally add if it does not
     *          exist in the graph.
     */
    public void setRootVertex(Vertex<T> root) {
        this.rootVertex = root;
        if (!verticies.contains(root))
            this.addVertex(root);
    }

    /**
     * Get the given Vertex.
     *
     * @param n
     *          the index [0, size()-1] of the Vertex to access
     * @return the nth Vertex
     */
    public Vertex<T> getVertex(int n) {
        return verticies.get(n);
    }

    /**
     * Get the graph verticies
     *
     * @return the graph verticies
     */
    public List<Vertex<T>> getVerticies() {
        return this.verticies;
    }

    /**
     * Insert a directed, weighted Edge<T> into the graph.
     *
     * @param from -
     *          the Edge<T> starting vertex
     * @param to -
     *          the Edge<T> ending vertex
     * @param cost -
     *          the Edge<T> weight/cost
     * @return true if the Edge<T> was added, false if from already has this Edge<T>
     * @throws IllegalArgumentException
     *           if from/to are not verticies in the graph
     */
    public boolean addEdge(Vertex<T> from, Vertex<T> to, int cost) throws IllegalArgumentException {
        if (!verticies.contains(from))
            throw new IllegalArgumentException("from is not in graph");
        if (!verticies.contains(to))
            throw new IllegalArgumentException("to is not in graph");

        Edge<T> e = new Edge<>(from, to, cost);
        if (from.findEdge(to) != null)
            return false;
        else {
            from.addEdge(e);
            to.addEdge(e);
            edges.add(e);
            return true;
        }
    }

    /**
     * Insert a bidirectional Edge<T> in the graph
     *
     * @param from -
     *          the Edge<T> starting vertex
     * @param to -
     *          the Edge<T> ending vertex
     * @param cost -
     *          the Edge<T> weight/cost
     * @return true if edges between both nodes were added, false otherwise
     * @throws IllegalArgumentException
     *           if from/to are not verticies in the graph
     */
    public boolean insertBiEdge(Vertex<T> from, Vertex<T> to, int cost)
            throws IllegalArgumentException {
        return addEdge(from, to, cost) && addEdge(to, from, cost);
    }

    /**
     * Get the graph edges
     *
     * @return the graph edges
     */
    public List<Edge<T>> getEdges() {
        return this.edges;
    }

    /**
     * Remove a vertex from the graph
     *
     * @param v
     *          the Vertex to remove
     * @return true if the Vertex was removed
     */
    public boolean removeVertex(Vertex<T> v) {
        if (!verticies.contains(v))
            return false;

        verticies.remove(v);
        if (v == rootVertex)
            rootVertex = null;

        // Remove the edges associated with v
        for (int n = 0; n < v.getOutgoingEdgeCount(); n++) {
            Edge<T> e = v.getOutgoingEdge(n);
            v.remove(e);
            Vertex<T> to = e.getTo();
            to.remove(e);
            edges.remove(e);
        }
        for (int n = 0; n < v.getIncomingEdgeCount(); n++) {
            Edge<T> e = v.getIncomingEdge(n);
            v.remove(e);
            Vertex<T> predecessor = e.getFrom();
            predecessor.remove(e);
        }
        return true;
    }

    /**
     * Remove an Edge<T> from the graph
     *
     * @param from -
     *          the Edge<T> starting vertex
     * @param to -
     *          the Edge<T> ending vertex
     * @return true if the Edge<T> exists, false otherwise
     */
    public boolean removeEdge(Vertex<T> from, Vertex<T> to) {
        Edge<T> e = from.findEdge(to);
        if (e == null)
            return false;
        else {
            from.remove(e);
            to.remove(e);
            edges.remove(e);
            return true;
        }
    }

    /**
     * Clear the mark state of all vertices in the graph by calling clearMark()
     * on all vertices.
     *
     * @see Vertex#clearMark()
     */
    public void clearMark() {
        for (Vertex<T> w : verticies)
            w.clearMark();
    }

    /**
     * Clear the mark state of all edges in the graph by calling clearMark() on
     * all edges.
     */
    public void clearEdges() {
        for (Edge<T> e : edges)
            e.clearMark();
    }

    /**
     * Perform a depth first search using recursion.
     *
     * @param v -
     *          the Vertex to start the search from
     * @param visitor -
     *          the visitor to inform prior to
     * @see Visitor#visit(Graph, Vertex)
     */
    public void depthFirstSearch(Vertex<T> v, final Visitor<T> visitor) {
        VisitorEX<T, RuntimeException> wrapper = new VisitorEX<T, RuntimeException>() {
            public void visit(Graph<T> g, Vertex<T> v) throws RuntimeException {
                if (visitor != null)
                    visitor.visit(g, v);
            }
        };
        this.depthFirstSearch(v, wrapper);
    }

    /**
     * Perform a depth first search using recursion. The search may be cut short
     * if the visitor throws an exception.
     *
     * @param <E>
     *
     * @param v -
     *          the Vertex to start the search from
     * @param visitor -
     *          the visitor to inform prior to
     * @see Visitor#visit(Graph, Vertex)
     * @throws E
     *           if visitor.visit throws an exception
     */
    public <E extends Exception> void depthFirstSearch(Vertex<T> v, VisitorEX<T, E> visitor) throws E {
        if (visitor != null)
            visitor.visit(this, v);
        v.visit();
        for (int i = 0; i < v.getOutgoingEdgeCount(); i++) {
            Edge<T> e = v.getOutgoingEdge(i);
            if (!e.getTo().visited()) {
                depthFirstSearch(e.getTo(), visitor);
            }
        }
    }

    /**
     * Perform a breadth first search of this graph, starting at v.
     *
     * @param v -
     *          the search starting point
     * @param visitor -
     *          the vistor whose vist method is called prior to visiting a vertex.
     */
    public void breadthFirstSearch(Vertex<T> v, final Visitor<T> visitor) {
        VisitorEX<T, RuntimeException> wrapper = new VisitorEX<T, RuntimeException>() {
            public void visit(Graph<T> g, Vertex<T> v) throws RuntimeException {
                if (visitor != null)
                    visitor.visit(g, v);
            }
        };
        this.breadthFirstSearch(v, wrapper);
    }

    /**
     * Perform a breadth first search of this graph, starting at v. The vist may
     * be cut short if visitor throws an exception during a visit callback.
     *
     * @param <E>
     *
     * @param v -
     *          the search starting point
     * @param visitor -
     *          the visitor whose visit method is called prior to visiting a vertex.
     * @throws E
     *           if visitor.visit throws an exception
     */
    public <E extends Exception> void breadthFirstSearch(Vertex<T> v, VisitorEX<T, E> visitor)
            throws E {
        LinkedList<Vertex<T>> q = new LinkedList<Vertex<T>>();

        q.add(v);
        if (visitor != null)
            visitor.visit(this, v);
        v.visit();
        while (!q.isEmpty()) {
            v = q.removeFirst();
            for (int i = 0; i < v.getOutgoingEdgeCount(); i++) {
                Edge<T> e = v.getOutgoingEdge(i);
                Vertex<T> to = e.getTo();
                if (!to.visited()) {
                    q.add(to);
                    if (visitor != null)
                        visitor.visit(this, to);
                    to.visit();
                }
            }
        }
    }

    /**
     * Find the spanning tree using a DFS starting from v.
     *
     * @param v -
     *          the vertex to start the search from
     * @param visitor -
     *          visitor invoked after each vertex is visited and an edge is added
     *          to the tree.
     */
    public void dfsSpanningTree(Vertex<T> v, DFSVisitor<T> visitor) {
        v.visit();
        if (visitor != null)
            visitor.visit(this, v);

        for (int i = 0; i < v.getOutgoingEdgeCount(); i++) {
            Edge<T> e = v.getOutgoingEdge(i);
            if (!e.getTo().visited()) {
                if (visitor != null)
                    visitor.visit(this, v, e);
                e.mark();
                dfsSpanningTree(e.getTo(), visitor);
            }
        }
    }

    /**
     * Search the verticies for one with name.
     *
     * @param name -
     *          the vertex name
     * @return the first vertex with a matching name, null if no matches are found
     */
    public Vertex<T> findVertexByName(String name) {
        Vertex<T> match = null;
        for (Vertex<T> v : verticies) {
            if (name.equals(v.getName())) {
                match = v;
                break;
            }
        }
        return match;
    }

    /**
     * Search the verticies for one with data.
     *
     * @param data -
     *          the vertex data to match
     * @param compare -
     *          the comparator to perform the match
     * @return the first vertex with a matching data, null if no matches are found
     */
    public Vertex<T> findVertexByData(T data, Comparator<T> compare) {
        Vertex<T> match = null;
        for (Vertex<T> v : verticies) {
            if (compare.compare(data, v.getData()) == 0) {
                match = v;
                break;
            }
        }
        return match;
    }

    /**
     * Search the graph for cycles. In order to detect cycles, we use a modified
     * depth first search called a colored DFS. All nodes are initially marked
     * white. When a node is encountered, it is marked grey, and when its
     * descendants are completely visited, it is marked black. If a grey node is
     * ever encountered, then there is a cycle.
     *
     * @return the edges that form cycles in the graph. The array will be empty if
     *         there are no cycles.
     */
    public Edge<T>[] findCycles() {
        ArrayList<Edge<T>> cycleEdges = new ArrayList<>();
        // Mark all verticies as white
        for (int n = 0; n < verticies.size(); n++) {
            Vertex<T> v = getVertex(n);
            v.setMarkState(VISIT_COLOR_WHITE);
        }
        for (int n = 0; n < verticies.size(); n++) {
            Vertex<T> v = getVertex(n);
            visit(v, cycleEdges);
        }

        Edge<T>[] cycles = new Edge[cycleEdges.size()];
        cycleEdges.toArray(cycles);
        return cycles;
    }

    private void visit(Vertex<T> v, ArrayList<Edge<T>> cycleEdges) {
        v.setMarkState(VISIT_COLOR_GREY);
        int count = v.getOutgoingEdgeCount();
        for (int n = 0; n < count; n++) {
            Edge<T> e = v.getOutgoingEdge(n);
            Vertex<T> u = e.getTo();
            if (u.getMarkState() == VISIT_COLOR_GREY) {
                // A cycle Edge<T>
                cycleEdges.add(e);
            } else if (u.getMarkState() == VISIT_COLOR_WHITE) {
                visit(u, cycleEdges);
            }
        }
        v.setMarkState(VISIT_COLOR_BLACK);
    }

    public String toString() {
        StringBuffer tmp = new StringBuffer("Graph[");
        for (Vertex<T> v : verticies)
            tmp.append(v);
        tmp.append(']');
        return tmp.toString();
    }

}
