package eu.modelwriter.visualization.editor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.w3c.dom.Element;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

public class Graph extends mxGraph {
  private static Graph graph;
  private static LinkedHashMap<String, ArrayList<Object>> edgeMap =
      new LinkedHashMap<String, ArrayList<Object>>();;

  public static LinkedHashMap<String, ArrayList<Object>> getEdgeMap() { // so so
    return Graph.edgeMap;
  }

  public static Graph getLastInstance() {
    if (Graph.graph == null) {
      Graph.graph = new Graph();
    }
    return Graph.graph;
  }

  public static ArrayList<Object> getReverse(final String edgeName) {
    final ArrayList<Object> reverses = new ArrayList<Object>();
    for (final Entry<String, ArrayList<Object>> entry : Graph.edgeMap.entrySet()) {
      if (!entry.getKey().equals(edgeName)) {
        final ArrayList<Object> values = entry.getValue();
        for (final Object object : values) {
          reverses.add(object);
        }
      }
    }

    return reverses;
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
    this.setAllowNegativeCoordinates(false);
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

  @Override
  public String getToolTipForCell(final Object cell) {
    return ((mxCell) cell).getGeometry().toString();
  }

  @Override
  public Object insertEdge(final Object parent, final String id, final Object value,
      final Object source, final Object target, final String style) {
    final Object insertEdge = super.insertEdge(parent, id, value, source, target, style);
    if (Graph.edgeMap.containsKey(value)) {
      Graph.edgeMap.get(value).add(insertEdge);
    } else {
      final ArrayList<Object> list = new ArrayList<Object>();
      list.add(insertEdge);
      Graph.edgeMap.put((String) value, list);
    }
    return insertEdge;
  }

  public Object insertVertex(final Object parent, final String id, final Object value) {
    final mxCell insertVertex = (mxCell) super.insertVertex(parent, id, value, 0, 0, 0, 0);
    insertVertex.setAttribute("Position",
        Integer.toString(this.getChildVertices(this.getDefaultParent()).length - 1));
    return insertVertex;
  }
}
