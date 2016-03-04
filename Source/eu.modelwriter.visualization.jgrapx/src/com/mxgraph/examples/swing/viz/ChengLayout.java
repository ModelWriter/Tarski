package com.mxgraph.examples.swing.viz;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JLabel;

import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.util.mxMorphing;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.view.mxGraph;

public class ChengLayout {
  private static ChengLayout layout;
  private static mxGraphComponent graphComponent;
  private static Object[] cells = null;

  public static ChengLayout getInstance() {
    if (ChengLayout.layout == null) {
      ChengLayout.layout = new ChengLayout();
    }
    return ChengLayout.layout;
  }

  TreeMap<Double, ArrayList<mxCell>> xVertices = new TreeMap<Double, ArrayList<mxCell>>();
  TreeMap<Double, ArrayList<mxCell>> yVertices = new TreeMap<Double, ArrayList<mxCell>>();

  private ChengLayout() {}

  /**
   * Creates a layout instance for the given identifier.
   */
  private mxIGraphLayout createLayout(final String ident, final boolean animate) {
    mxIGraphLayout layout = null;

    if (ident != null) {
      final mxGraph graph = ChengLayout.graphComponent.getGraph();
      if (ident.equals("verticalHierarchical")) {
        layout = new mxHierarchicalLayout(graph);
      } else if (ident.equals("horizontalHierarchical")) {
        layout = new mxHierarchicalLayout(graph, JLabel.WEST);
      }
    }

    return layout;
  }

  private void init() {
    for (final Object object : ChengLayout.cells) {
      final mxCell cell = (mxCell) object;
      if (cell.isVertex()) {
        ArrayList<mxCell> xVertices = this.xVertices.get(cell.getGeometry().getCenterX());
        if (xVertices == null) {
          xVertices = new ArrayList<mxCell>();
          xVertices.add(cell);
          this.xVertices.put(cell.getGeometry().getCenterX(), xVertices);
        } else {
          xVertices.add(cell);
        }

        ArrayList<mxCell> yVertices = this.xVertices.get(cell.getGeometry().getCenterY());
        if (yVertices == null) {
          yVertices = new ArrayList<mxCell>();
          yVertices.add(cell);
          this.xVertices.put(cell.getGeometry().getCenterY(), yVertices);
        } else {
          yVertices.add(cell);
        }
      }
    }
  }

  private void runVerticalLayout() {
    final mxIGraphLayout layout = this.createLayout("verticalHierarchical", false);
    if (layout != null) {
      final mxGraph graph = ChengLayout.graphComponent.getGraph();
      Object cell = graph.getSelectionCell();

      if (cell == null || graph.getModel().getChildCount(cell) == 0) {
        cell = graph.getDefaultParent();
      }

      graph.getModel().beginUpdate();
      try {
        layout.execute(cell);
      } finally {
        final mxMorphing morph = new mxMorphing(ChengLayout.graphComponent, 20, 1.25, 1);

        morph.addListener(mxEvent.DONE, new mxIEventListener() {
          @Override
          public void invoke(final Object sender, final mxEventObject evt) {
            graph.getModel().endUpdate();
          }
        });
        morph.startAnimation();
      }
    }
  }

  public void setLayout(final VisualizationGraphComponent component) {
    ChengLayout.graphComponent = component;
    ChengLayout.cells = ChengLayout.graphComponent.getCells(new Rectangle(0, 0,
        ChengLayout.graphComponent.getWidth(), ChengLayout.graphComponent.getHeight()));

    this.setVerticesSize();
    this.runVerticalLayout();
    this.init();
  }

  private void setVerticesSize() {
    final Object[] childVertices = ChengLayout.graphComponent.getGraph()
        .getChildVertices(ChengLayout.graphComponent.getGraph().getDefaultParent());
    for (final Object object : childVertices) {
      ChengLayout.graphComponent.getGraph().updateCellSize(object);
    }
  }
}
