package com.mxgraph.examples.swing.viz;

import org.w3c.dom.Element;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

public class VisualizationGraph extends mxGraph {
  public VisualizationGraph() {
    super();
    this.setAllowLoops(true);
    this.setKeepEdgesInBackground(true);
    this.setDefaultOverlap(0.0);
    this.setEdgeLabelsMovable(false);
    this.setLabelsClipped(false);
    this.setDisconnectOnMove(false);
    this.setMultigraph(true);
    this.setAllowDanglingEdges(false);
    this.setCellsResizable(false);
    this.setCellsEditable(false);
    this.setAutoSizeCells(true);
    this.setResetViewOnRootChange(false);
  }

  @Override
  public String convertValueToString(final Object cell) {
    if (cell instanceof mxCell) {
      final mxCell mxCell = (mxCell) cell;
      if (mxCell.getValue() instanceof Element) {
        final Element value = (Element) mxCell.getValue();
        return value.getAttribute("name");
      } else if (mxCell.getValue() instanceof String) {
        return (String) mxCell.getValue();
      }
    }
    return "";
  }

  public Object insertVertex(final Object parent, final String id, final Object value) {
    return super.insertVertex(parent, id, value, 0, 0, 0, 0);
  }
}
