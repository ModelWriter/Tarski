package eu.modelwriter.visualization.editor.util;

import com.mxgraph.model.mxCell;
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

  public mxPoint getControlPoint(final mxCell cell, final int controlPointNumber) {
    return controlPointNumber == -1 ? null : cell.getGeometry().getPoints().get(controlPointNumber);
  }
}
