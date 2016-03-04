package com.mxgraph.examples.swing.viz;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.view.mxGraph;

public class VisualizationCellUtility {
  private static mxGraph graph;
  private static VisualizationCellUtility utility;

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

  public static VisualizationCellUtility getInstance(final mxGraph graph) {
    if (VisualizationCellUtility.utility == null) {
      VisualizationCellUtility.utility = new VisualizationCellUtility();
    }
    VisualizationCellUtility.graph = graph;
    return VisualizationCellUtility.utility;
  }

  private VisualizationCellUtility() {}

  public List<mxCell> getSources(final mxCell cell) {
    final LinkedList<mxCell> sources = new LinkedList<>();

    for (final Object object : VisualizationCellUtility.graph.getIncomingEdges(cell)) {
      final mxCell edge = (mxCell) object;

      final mxICell source = edge.getSource();
      if (!source.equals(this)) {
        sources.add((mxCell) source);
      }
    }

    return sources;
  }

  public List<mxCell> getTargets(final mxCell cell) {
    final LinkedList<mxCell> targets = new LinkedList<>();

    for (final Object object : VisualizationCellUtility.graph.getOutgoingEdges(cell)) {
      final mxCell edge = (mxCell) object;

      final mxICell target = edge.getTarget();
      if (!target.equals(this)) {
        targets.add((mxCell) target);
      }
    }

    return targets;
  }
}
