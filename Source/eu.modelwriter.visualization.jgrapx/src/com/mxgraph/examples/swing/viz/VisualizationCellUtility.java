package com.mxgraph.examples.swing.viz;

import java.util.LinkedList;
import java.util.List;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;

public class VisualizationCellUtility {
  private static VisualizationGraph graph;
  private static VisualizationCellUtility utility;

  public static VisualizationCellUtility getInstance(final VisualizationGraph graph) {
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
