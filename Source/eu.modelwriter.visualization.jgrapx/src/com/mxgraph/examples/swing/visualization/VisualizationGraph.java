package com.mxgraph.examples.swing.visualization;

import org.w3c.dom.Element;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

public class VisualizationGraph extends mxGraph {
  public VisualizationGraph() {
    super();
    this.setMultigraph(true);
    this.setAllowDanglingEdges(false);
    this.setCellsResizable(false);
    this.setCellsEditable(false);
    this.setResetViewOnRootChange(false);
  }

  @Override
  public String convertValueToString(final Object cell) {
    if (cell instanceof mxCell) {
      final mxCell mxCell = (mxCell) cell;
      if (mxCell.getValue() instanceof Element) {
        final Element value = (Element) mxCell.getValue();
        return value.getAttribute("label");
      } else if (mxCell.getValue() instanceof String) {
        return (String) mxCell.getValue();
      }
    }
    return "";
  }
}
