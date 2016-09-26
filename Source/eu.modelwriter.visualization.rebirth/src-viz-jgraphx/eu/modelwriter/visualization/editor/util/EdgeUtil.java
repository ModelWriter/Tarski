package eu.modelwriter.visualization.editor.util;

import java.util.ArrayList;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.util.mxPoint;

import eu.modelwriter.model.ModelElement;

public class EdgeUtil {
  /**
   * It provides Singleton Pattern.
   */
  private static EdgeUtil edgeUtil;

  /**
   * {@link GraphUtil} instance.
   */
  private static GraphUtil graphUtilInstance;

  public static EdgeUtil getInstance() {
    EdgeUtil.graphUtilInstance = GraphUtil.getInstance();
    if (EdgeUtil.edgeUtil == null) {
      EdgeUtil.edgeUtil = new EdgeUtil();
    }
    return EdgeUtil.edgeUtil;
  }

  private EdgeUtil() {}

  /**
   * @param edge
   * @return source node of given edge.
   */
  public mxCell a(final mxCell edge) {
    return (mxCell) edge.getSource();
  }

  /**
   * @param edge
   * @return target node of given edge.
   */
  public mxCell b(final mxCell edge) {
    return (mxCell) edge.getTarget();
  }

  /**
   * Finds the control point of the given edge.
   *
   * @param edge
   * @param controlPointOrder order of control point in this edge. (Topdown.)
   * @return
   */
  public mxPoint getControlPoint(final mxCell edge, final int controlPointOrder) {
    return controlPointOrder == -1 ? null : edge.getGeometry().getPoints().get(controlPointOrder);
  }

  /**
   * Finds control point order of edge on this Y coordinate.
   *
   * @param edge
   * @param y coordinate.
   * @return control point order.
   */
  public int getControlPointOrder(final mxCell edge, final int y) {
    if (edge.getGeometry().getPoints() == null) {
      return -1;
    }
    for (int i = 0; i < edge.getGeometry().getPoints().size(); i++) {
      final mxPoint point = edge.getGeometry().getPoints().get(i);
      if (y == point.getY()) {
        return i;
      }
    }
    return -1;
  }

  /**
   * @param edge
   * @return name of given edge.
   */
  public String getEdgeName(final mxCell edge) {
    return ((ModelElement) edge.getValue()).getLabel();
  }

  /**
   * @param edgeName
   * @return all edges which have not the given edge name.
   */
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

  /**
   * @param edgeName
   * @return all edges which have the given edge name.
   */
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

  /**
   * @param edge
   * @param controlPointOrder
   * @return layer number of control point which in the given edge and has given control point
   *         order.
   */
  public int layer(final mxCell edge, final int controlPointOrder) {
    final mxICell source = edge.getSource();
    final mxICell target = edge.getTarget();
    final double sourceCenterY = source.getGeometry().getCenterY();
    final double targetCenterY = target.getGeometry().getCenterY();
    if (sourceCenterY < targetCenterY) { // source of edge is upper than the target
      return NodeUtil.getInstance().layer((mxCell) source) - controlPointOrder - 1;
    } else { // source of edge is lower than the target
      return NodeUtil.getInstance().layer((mxCell) target) - controlPointOrder - 1;
    }
  }
}
