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
 * A spanning tree visitor callback interface
 *
 * @see Graph#dfsSpanningTree(Vertex, DFSVisitor)
 *
 * @param <T>
 */
public interface DFSVisitor<T> {
    /**
     * Called by the graph traversal methods when a vertex is first visited.
     *
     * @param g -
     *          the graph
     * @param v -
     *          the vertex being visited.
     */
    public void visit(Graph<T> g, Vertex<T> v);

    /**
     * Used dfsSpanningTree to notify the visitor of each outgoing edge to an
     * unvisited vertex.
     *
     * @param g -
     *          the graph
     * @param v -
     *          the vertex being visited
     * @param e -
     *          the outgoing edge from v
     */
    public void visit(Graph<T> g, Vertex<T> v, Edge<T> e);
}

