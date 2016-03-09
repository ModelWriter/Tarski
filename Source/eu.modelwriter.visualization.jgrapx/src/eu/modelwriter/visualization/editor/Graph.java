package eu.modelwriter.visualization.editor;

import org.w3c.dom.Element;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

public class Graph extends mxGraph {
  private static Graph graph;

  public static Graph getLastInstance() {
    if (Graph.graph == null) {
      Graph.graph = new Graph();
    }
    return Graph.graph;
  }

  public Graph() {
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
    this.setDropEnabled(false);
  }

  @Override
  public String convertValueToString(final Object cell) {
    if (cell instanceof mxCell) {
      final mxCell mxCell = (mxCell) cell;
      if (mxCell.getValue() instanceof Element) {
        final Element value = (Element) mxCell.getValue();
        return value.getAttribute("name")
        // + " : " + "\ncenterX:" + mxCell.getGeometry().getCenterX()
        // + "\ncenterY:" + mxCell.getGeometry().getCenterY() + "\nX:"
        // + mxCell.getGeometry().getX() + "\nY:" + mxCell.getGeometry().getY()
        ;
      } else if (mxCell.getValue() instanceof String) {
        return (String) mxCell.getValue();
      }
    }
    return "";
  }

  @Override
  public String getToolTipForCell(final Object cell) {
    return ((mxCell) cell).getGeometry().toString();
  }

  public Object insertVertex(final Object parent, final String id, final Object value) {
    final mxCell insertVertex = (mxCell) super.insertVertex(parent, id, value, 0, 0, 0, 0);
    insertVertex.setAttribute("Position",
        Integer.toString(this.getChildVertices(this.getDefaultParent()).length - 1));
    return insertVertex;
  }
}
