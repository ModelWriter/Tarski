package eu.modelwriter.visualization.editor.util;

import java.util.ArrayList;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.util.mxPoint;

import eu.modelwriter.visualization.editor.Graph;
import eu.modelwriter.visualization.editor.GraphComponent;

public class EdgeUtil {
  private static EdgeUtil nodeUtil;
  private static GraphUtil graphUtilInstance;
  private static Graph graph;
  private static GraphComponent graphComponent;

  public static EdgeUtil getInstance(final Graph graph, final GraphComponent graphComponent) {
    EdgeUtil.graph = graph;
    EdgeUtil.graphComponent = graphComponent;
    EdgeUtil.graphUtilInstance = GraphUtil.getInstance(EdgeUtil.graph, EdgeUtil.graphComponent);
    if (EdgeUtil.nodeUtil == null) {
      EdgeUtil.nodeUtil = new EdgeUtil();
    }
    return EdgeUtil.nodeUtil;
  }

  private EdgeUtil() {}

  public mxCell a(final mxCell cell) {
    return (mxCell) cell.getSource();
  }

  public mxCell b(final mxCell cell) {
    return (mxCell) cell.getTarget();
  }

  public mxPoint getControlPoint(final mxCell cell, final int controlPointOrder) {
    return controlPointOrder == -1 ? null : cell.getGeometry().getPoints().get(controlPointOrder);
  }

  public int getControlPointOrder(final mxCell edge, final int x, final int y) {
    for (int i = 0; i < edge.getGeometry().getPoints().size(); i++) {
      final mxPoint point = edge.getGeometry().getPoints().get(i);
      if (x + 3 >= point.getX() && x - 3 <= point.getX() && y + 3 >= point.getY()
          && y - 3 <= point.getY()) {
        return i;
      }
    }
    return -1;
  }

  public String getEdgeName(final mxCell edge) {
    return edge.getValue().toString();
  }

  public ArrayList<mxCell> getReverseEdges(final String edgeName) {
    final ArrayList<mxCell> reverseEdges = new ArrayList<>();
    for (final Object object : EdgeUtil.graphUtilInstance.getEdges()) {
      final mxCell edge = (mxCell) object;
      if (!this.getEdgeName(edge).equals(edgeName)) {
        reverseEdges.add(edge);
      }
    }
    return reverseEdges;
  }

  public ArrayList<mxCell> getSameEdges(final String edgeName) {
    final ArrayList<mxCell> sameEdges = new ArrayList<>();
    for (final Object object : EdgeUtil.graphUtilInstance.getEdges()) {
      final mxCell edge = (mxCell) object;
      if (this.getEdgeName(edge).equals(edgeName)) {
        sameEdges.add(edge);
      }
    }
    return sameEdges;
  }

  public int layer(final mxCell edge, final int controlPointOrder) {
    final mxICell source = edge.getSource();
    final mxICell target = edge.getTarget();
    final mxPoint point = edge.getGeometry().getPoints().get(controlPointOrder);
    final double sourceCenterY = source.getGeometry().getCenterY();
    if (sourceCenterY < point.getY()) { // source of edge is upper than the control point
      return NodeUtil.getInstance(EdgeUtil.graph, EdgeUtil.graphComponent).layer((mxCell) source)
          - controlPointOrder - 1;
    } else { // source of edge is lower than the control point
      return NodeUtil.getInstance(EdgeUtil.graph, EdgeUtil.graphComponent).layer((mxCell) target)
          - controlPointOrder - 1;
    }
  }
}
