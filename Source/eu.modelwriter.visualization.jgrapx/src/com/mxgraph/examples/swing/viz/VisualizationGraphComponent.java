package com.mxgraph.examples.swing.viz;

import java.awt.Color;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class VisualizationGraphComponent extends mxGraphComponent {
  private static final long serialVersionUID = -973809093898383471L;

  public VisualizationGraphComponent(final mxGraph graph) {
    super(graph);
    this.getConnectionHandler().setCreateTarget(false);
    this.setToolTips(true);

    // Sets the background to white
    this.getViewport().setOpaque(true);
    this.getViewport().setBackground(Color.WHITE);
  }
}
