package eu.modelwriter.visualization.editor;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

import eu.modelwriter.model.ModelElement;

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
      final mxCell value = (mxCell) cell;
      final ModelElement element = (ModelElement) value.getValue();
      if (value.isVertex()) {
        return element.getID() + "\n(" + element.getSet() + ")";
      } else if (value.isEdge()) {
        return element.getID();
      }
    }
    return "";
  }

  public Object insertVertex(final Object parent, final String id, final Object value) {
    return super.insertVertex(parent, id, value, 0, 0, 0, 0);
  }
}
