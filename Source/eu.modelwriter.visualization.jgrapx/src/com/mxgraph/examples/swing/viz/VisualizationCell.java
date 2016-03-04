package com.mxgraph.examples.swing.viz;

import java.util.LinkedList;
import java.util.List;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;

public class VisualizationCell extends mxCell {
  private static final long serialVersionUID = -7484669379467280702L;

  public List<mxCell> getSources() {
    final LinkedList<mxCell> sources = new LinkedList<>();

    for (final Object object : this.edges) {
      final mxCell edge = (mxCell) object;

      final mxICell source = edge.getSource();
      if (!source.equals(this)) {
        sources.add((mxCell) source);
      }
    }

    return sources;
  }

  public List<mxCell> getTargets() {
    final LinkedList<mxCell> targets = new LinkedList<>();

    for (final Object object : this.edges) {
      final mxCell edge = (mxCell) object;

      final mxICell target = edge.getTarget();
      if (!target.equals(this)) {
        targets.add((mxCell) target);
      }
    }

    return targets;
  }
}
