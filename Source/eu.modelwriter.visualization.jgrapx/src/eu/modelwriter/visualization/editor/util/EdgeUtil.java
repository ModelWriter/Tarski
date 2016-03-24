package eu.modelwriter.visualization.editor.util;

import java.util.ArrayList;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.util.mxPoint;

public class EdgeUtil {
  private static EdgeUtil nodeUtil;
  private static GraphUtil graphUtilInstance;

  public static EdgeUtil getInstance() {
    EdgeUtil.graphUtilInstance = GraphUtil.getInstance();
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

  @SuppressWarnings("unused")
  public mxPoint getControlPointOnLayer(final mxCell edge, final int layer) {
    final int yOfLayer = EdgeUtil.graphUtilInstance.yOfLayer(layer);
    final int controlPointOrder = this.getControlPointOrder(edge, yOfLayer);
    final mxPoint controlPoint = this.getControlPoint(edge, controlPointOrder);
    return controlPoint;
  }

  public int getControlPointOrder(final mxCell edge, final int y) {
    for (int i = 0; i < edge.getGeometry().getPoints().size(); i++) {
      final mxPoint point = edge.getGeometry().getPoints().get(i);
      if (y + 3 >= point.getY() && y - 3 <= point.getY()) {
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
      return NodeUtil.getInstance().layer((mxCell) source) - controlPointOrder - 1;
    } else { // source of edge is lower than the control point
      return NodeUtil.getInstance().layer((mxCell) target) - controlPointOrder - 1;
    }
  }
}
