package com.mxgraph.examples.swing.viz;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

public class VisualizationGraph extends mxGraph {

  public final List<List<mxCell>> layerlist = new ArrayList<List<mxCell>>();
  private final List<Object> edgeList = new ArrayList<Object>();

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

  public List<Object> getEdgeList() {
    return this.edgeList;
  }

  @Override
  public Object insertEdge(final Object parent, final String id, final Object value,
      final Object source, final Object target, final String style) {
    final Object edge = super.insertEdge(parent, id, value, source, target, style);
    this.edgeList.add(edge);

    return edge;
  }

  public Object insertVertex(final Object parent, final String id, final Object value) {
    final mxCell insertVertex = (mxCell) super.insertVertex(parent, id, value, 0, 0, 0, 0);
    if (this.layerlist.size() == 0) {
      this.layerlist.add(new ArrayList<mxCell>());
    }
    this.layerlist.get(0).add(insertVertex);
    insertVertex.setAttribute("Position",
        Integer.toString(this.getChildVertices(this.getDefaultParent()).length - 1));
    return insertVertex;
  }
}
