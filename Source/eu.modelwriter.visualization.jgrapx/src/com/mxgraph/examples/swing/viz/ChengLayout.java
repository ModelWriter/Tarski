package com.mxgraph.examples.swing.viz;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.TreeMap;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;

public class ChengLayout {
  private static ChengLayout layout;
  private static mxGraphComponent graphComponent;

  static Object[] cells = null;

  public static ChengLayout getInstance(final mxGraphComponent component) {
    if (ChengLayout.layout == null) {
      ChengLayout.layout = new ChengLayout(component);
    }
    return ChengLayout.layout;
  }

  TreeMap<Double, ArrayList<mxCell>> xVertices = new TreeMap<Double, ArrayList<mxCell>>();
  TreeMap<Double, ArrayList<mxCell>> yVertices = new TreeMap<Double, ArrayList<mxCell>>();

  private ChengLayout() {}

  private ChengLayout(final mxGraphComponent component) {
    ChengLayout.graphComponent = component;
    ChengLayout.cells = ChengLayout.graphComponent.getCells(new Rectangle(0, 0,
        ChengLayout.graphComponent.getWidth(), ChengLayout.graphComponent.getHeight()));
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

  public void refactorLayout() {
    this.init();
  }
}
