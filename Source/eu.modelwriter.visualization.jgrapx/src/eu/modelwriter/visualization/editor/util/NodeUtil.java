package eu.modelwriter.visualization.editor.util;

import java.util.LinkedList;
import java.util.List;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.util.mxPoint;

import eu.modelwriter.visualization.editor.Graph;
import eu.modelwriter.visualization.editor.GraphComponent;

public class NodeUtil {
  private static NodeUtil nodeUtil;
  private static GraphUtil graphUtilInstance;
  private static Graph graph;
  private static GraphComponent graphComponent;

  public static NodeUtil getInstance(final Graph graph, final GraphComponent graphComponent) {
    NodeUtil.graph = graph;
    NodeUtil.graphComponent = graphComponent;
    NodeUtil.graphUtilInstance = GraphUtil.getInstance(NodeUtil.graph, NodeUtil.graphComponent);
    if (NodeUtil.nodeUtil == null) {
      NodeUtil.nodeUtil = new NodeUtil();
    }
    return NodeUtil.nodeUtil;
  }

  private NodeUtil() {}

  /** (Re-)calculate this node's bounds. */
  public void calcBounds(final mxCell cell) {
    final int hw = this.side(cell);
    cell.getGeometry().setWidth(hw * 2);
    cell.setAttribute(GraphUtil.SIDE, String.valueOf(hw));

    final int hh = this.updown(cell);
    cell.getGeometry().setHeight(hh * 2);
    cell.setAttribute(GraphUtil.UPDOWN, String.valueOf(hh));
  }

  private int centerX(final mxCell cell) {
    return (int) cell.getGeometry().getCenterX();
  }

  private int centerY(final mxCell cell) {
    return (int) cell.getGeometry().getCenterY();
  }

  public List<mxCell> ins(final mxCell cell) {
    final LinkedList<mxCell> sources = new LinkedList<>();
    for (final Object object : NodeUtil.graph.getIncomingEdges(cell)) {
      final mxCell edge = (mxCell) object;
      final mxICell source = edge.getSource();
      if (!source.equals(cell)) {
        sources.add((mxCell) source);
      } else if (edge.getTarget().equals(cell)) {
        sources.add((mxCell) source);
      }
    }
    return sources;
  }

  public int layer(final mxCell cell) {
    return cell.getAttribute(GraphUtil.LAYER) == null ? -1
        : Integer.valueOf(cell.getAttribute(GraphUtil.LAYER));
  }

  private int layer(final mxCell edge, final int controlPointNumber) {
    final mxICell source = edge.getSource();
    final mxICell target = edge.getTarget();
    final mxPoint point = edge.getGeometry().getPoints().get(controlPointNumber);
    final double sourceCenterY = source.getGeometry().getCenterY();
    if (sourceCenterY < point.getY()) { // source of edge is upper than the control point
      return this.layer((mxCell) source) - controlPointNumber - 1;
    } else { // source of edge is lower than the control point
      return this.layer((mxCell) target) - controlPointNumber - 1;
    }
  }

  public List<mxCell> outs(final mxCell cell) {
    final LinkedList<mxCell> targets = new LinkedList<>();
    for (final Object object : NodeUtil.graph.getOutgoingEdges(cell)) {
      final mxCell edge = (mxCell) object;
      final mxICell target = edge.getTarget();
      if (!target.equals(cell)) {
        targets.add((mxCell) target);
      } else if (edge.getSource().equals(cell)) {
        targets.add((mxCell) target);
      }
    }
    return targets;
  }

  public int reserved(final mxCell cell) {
    final LinkedList<mxCell> selfs = this.selfs(cell);
    int reserved = 0;
    for (int i = 0; i < selfs.size(); i++) {
      if (i == 0) {
        reserved = Integer.valueOf(cell.getAttribute(GraphUtil.SIDE)) + GraphUtil.selfLoopA;
        continue;
      }
      reserved = reserved
          + (int) NodeUtil.graph.getView().getState(selfs.get(i - 1)).getLabelBounds().getWidth()
          + GraphUtil.selfLoopGL + GraphUtil.selfLoopGR;
    }
    if (reserved > 0) {
      reserved = reserved + (int) NodeUtil.graph.getView().getState(selfs.get(selfs.size() - 1))
          .getLabelBounds().getWidth() + GraphUtil.selfLoopGL + GraphUtil.selfLoopGR;
    }
    return reserved;
  }

  public LinkedList<mxCell> selfs(final mxCell cell) {
    final LinkedList<mxCell> selfs = new LinkedList<>();
    for (final Object object : NodeUtil.graph.getOutgoingEdges(cell)) {
      final mxCell edge = (mxCell) object;
      final mxICell target = edge.getTarget();
      if (target != null && target.equals(cell)) {
        selfs.add(edge);
      }
    }
    return selfs;
  }

  public void setX(final mxCell cell, final int newCenterX) {
    final int oldCenterX = (int) cell.getGeometry().getCenterX();
    NodeUtil.graph.moveCells(new Object[] {cell}, newCenterX - oldCenterX, 0);
    final int lefOfCell = newCenterX - this.side(cell);
    if (lefOfCell < 0) {
      NodeUtil.graph.moveCells(NodeUtil.graphUtilInstance.getNodes().toArray(), Math.abs(lefOfCell),
          0);
      for (final Object edge : NodeUtil.graphUtilInstance.getEdges()) {
        for (final mxPoint point : ((mxCell) edge).getGeometry().getPoints()) {
          point.setX(point.getX() + Math.abs(lefOfCell));
        }
      }
    }
  }

  public void setY(final int layer, final int newCenterY) {
    final int oldCenterY = NodeUtil.graphUtilInstance.yOfLayer(layer);
    for (final Object object : NodeUtil.graphUtilInstance.getEdges()) {
      final mxCell edge = (mxCell) object;
      for (int i = 0; i < edge.getGeometry().getPoints().size(); i++) {
        if (oldCenterY < (int) edge.getGeometry().getPoints().get(i).getY()
            + NodeUtil.graphUtilInstance.layerPH()[layer]
            && oldCenterY > (int) edge.getGeometry().getPoints().get(i).getY()
                - NodeUtil.graphUtilInstance.layerPH()[layer]) {

          final int sum = NodeUtil.graphUtilInstance.runLayerMinY()[layer]
              + NodeUtil.graphUtilInstance.layerPH()[layer] / 2;
          if (newCenterY < sum) {
            edge.getGeometry().getPoints().get(i).setY(sum);
          } else {
            edge.getGeometry().getPoints().get(i).setY(newCenterY);
          }
        }
      }
    }

    for (final mxCell cell : NodeUtil.graphUtilInstance.layer(layer)) {
      final int newY = newCenterY - this.updown(cell);
      if (newY < NodeUtil.graphUtilInstance.runLayerMinY()[layer]) {
        cell.getGeometry().setY(NodeUtil.graphUtilInstance.runLayerMinY()[layer]);
      } else {
        cell.getGeometry().setY(newY);
      }
    }
  }

  /**
   * Helper method that shifts a node down.
   *
   * @param newCenterY2
   */
  private void shiftDown(final mxCell cell, int layerOfCell, int newCenterY) {
    final int[] ph = NodeUtil.graphUtilInstance.layerPH();
    final int yJump = GraphUtil.yJump / 6;
    this.setY(layerOfCell, newCenterY);
    newCenterY = newCenterY + ph[layerOfCell] / 2;
    // y is now the bottom-most edge of this layer
    for (layerOfCell--; layerOfCell >= 0; layerOfCell--) {
      final List<mxCell> list = NodeUtil.graphUtilInstance.layer(layerOfCell);
      final mxCell first = list.get(0);
      final int centerY = this.centerY(first);
      if (centerY - ph[layerOfCell] / 2 - yJump < newCenterY) {
        this.setY(layerOfCell, newCenterY + ph[layerOfCell] / 2 + yJump);
      }
      newCenterY = centerY + ph[layerOfCell] / 2;
    }
  }

  /** Helper method that shifts a node left. */
  private void shiftLeft(final mxCell cell, final List<mxCell> peers, int i, int newCenterX) {
    final int xJump = GraphUtil.xJump / 3;
    this.setX(cell, newCenterX);
    int side = this.side(cell);
    newCenterX = newCenterX - side;
    // x is now the left-most edge of this node
    for (i--; i >= 0; i--) {
      final mxCell node = peers.get(i);
      side = this.side(node);
      int centerX = this.centerX(node);
      if (centerX + side + this.reserved(node) + xJump > newCenterX) {
        centerX = newCenterX - side - this.reserved(node) - xJump;
        this.setX(node, newCenterX);
      }
      newCenterX = centerX - side;
    }
  }

  /**
   * Helper method that shifts a node right.
   */
  private void shiftRight(final mxCell cell, final List<mxCell> peers, int i, int newCenterX) {
    final int xJump = GraphUtil.xJump / 3;
    this.setX(cell, newCenterX);
    int side = this.side(cell);
    newCenterX = newCenterX + side + this.reserved(cell);
    // x is now the right most edge of this node
    for (i++; i < peers.size(); i++) {
      final mxCell node = peers.get(i);
      side = this.side(node);
      int centerX = this.centerX(node);
      if (centerX - side - xJump < newCenterX) {
        centerX = newCenterX + side + xJump;
        this.setX(node, newCenterX);
      }
      newCenterX = centerX + side + this.reserved(node);
    }
  }

  /**
   * Helper method that shifts a node up.
   *
   * @param newCenterY2
   *
   * @param oldY
   */
  private void shiftUp(final mxCell cell, int layerOfCell, int newCenterY) {
    final int[] ph = NodeUtil.graphUtilInstance.layerPH();
    final int yJump = GraphUtil.yJump / 6;

    final int old = this.y(cell);
    this.setY(layerOfCell, newCenterY);
    final int neu = this.y(cell);

    if (old == neu) {
      for (int layer = layerOfCell - 1; layer >= 0; layer--) {
        NodeUtil.graphUtilInstance.moveControlPointsBy(layer, Math.abs(newCenterY - old));
        NodeUtil.graph.moveCells(NodeUtil.graphUtilInstance.layer(layer).toArray(), 0,
            Math.abs(newCenterY - old));
      }
    } else {
      newCenterY = newCenterY - ph[layerOfCell] / 2;
      // y is now the top-most edge of this layer
      for (layerOfCell++; layerOfCell < NodeUtil.graphUtilInstance.layers(); layerOfCell++) {
        final List<mxCell> list = NodeUtil.graphUtilInstance.layer(layerOfCell);
        final mxCell first = list.get(0);
        final int centerY = this.centerY(first);
        if (centerY + ph[layerOfCell] / 2 + yJump > newCenterY) {
          this.setY(layerOfCell, newCenterY - ph[layerOfCell] / 2 - yJump);
        }
        newCenterY = centerY - ph[layerOfCell] / 2;
      }
    }
  }

  public int side(final mxCell cell) {
    final int width = (int) cell.getGeometry().getWidth();
    final int hw = (width + 1) / 2 + GraphUtil.labelPadding;
    return hw;
  }

  /** Helper method that swaps a node towards the left. */
  private void swapLeft(final mxCell cell, final List<mxCell> peers, int orderInLayer,
      final int newCenterX) {
    final int side = this.side(cell);
    final int left = newCenterX - side;
    while (true) {
      if (orderInLayer == 0) {
        this.setX(cell, newCenterX);
        return;
      } // no clash possible
      final mxCell other = peers.get(orderInLayer - 1);
      final int otherSide = this.side(other);
      final int otherRight = this.centerX(other) + otherSide + this.reserved(other);
      if (otherRight < left) {
        this.setX(cell, newCenterX);
        return;
      } // no clash
      NodeUtil.graphUtilInstance.swapNodes(this.layer(cell), orderInLayer, orderInLayer - 1);
      orderInLayer--;
      this.shiftRight(other, peers, orderInLayer + 1,
          newCenterX + side + this.reserved(cell) + otherSide);
    }
  }

  /** Helper method that swaps a node towards the right. */
  private void swapRight(final mxCell cell, final List<mxCell> peers, int orderInLayer,
      final int newCenterX) {
    final int side = this.side(cell);
    final int right = newCenterX + side + this.reserved(cell);
    while (true) {
      if (orderInLayer == peers.size() - 1) {
        this.setX(cell, newCenterX);
        return;
      } // no clash possible
      final mxCell other = peers.get(orderInLayer + 1);
      final int otherSide = this.side(other);
      final int otherLeft = this.centerX(other) - otherSide;
      if (otherLeft > right) {
        this.setX(cell, newCenterX);
        return;
      } // no clash
      NodeUtil.graphUtilInstance.swapNodes(this.layer(cell), orderInLayer, orderInLayer + 1);
      orderInLayer++;
      this.shiftLeft(other, peers, orderInLayer - 1,
          newCenterX - side - this.reserved(other) - otherSide);
    }
  }

  /**
   * Assuming the graph is already laid out, this shifts this node (and re-layouts nearby
   * nodes/edges as necessary)
   *
   * @param newCenterY2
   * @param newCenterX2
   */
  public void tweak(final mxCell cell, final int oldCenterX, final int oldCenterY,
      final int newCenterX, final int newCenterY) {
    if (oldCenterX == newCenterX && oldCenterY == newCenterY) {
      return; // If no change, then return right away
    }
    final int layerOfCell = this.layer(cell);
    final List<mxCell> layerCells = NodeUtil.graphUtilInstance.layer(layerOfCell);
    final int n = layerCells.size();
    int i;
    for (i = 0; i < n; i++) {
      if (layerCells.get(i).equals(cell)) {
        break; // Figure out this node's position in its layer
      }
    }
    if (oldCenterX > newCenterX) {
      this.swapLeft(cell, layerCells, i, newCenterX);
    } else if (oldCenterX < newCenterX) {
      this.swapRight(cell, layerCells, i, newCenterX);
    }
    if (oldCenterY > newCenterY) {
      this.shiftUp(cell, layerOfCell, newCenterY);
    } else if (oldCenterY < newCenterY) {
      this.shiftDown(cell, layerOfCell, newCenterY);
    }
  }

  public void tweakControlPoint(final mxCell cell, final int controlPointOrder,
      final int oldCenterY, final int newCenterY) {
    final int layerOfPoint = this.layer(cell, controlPointOrder);
    if (layerOfPoint == -1) {
      return;
    }
    final mxCell cellInLayer = NodeUtil.graphUtilInstance.layer(layerOfPoint).get(0);
    if (oldCenterY > newCenterY) {
      this.shiftUp(cellInLayer, layerOfPoint, newCenterY);
    } else if (oldCenterY < newCenterY) {
      this.shiftDown(cellInLayer, layerOfPoint, newCenterY);
    }
  }

  public int updown(final mxCell cell) {
    final int height = (int) cell.getGeometry().getHeight();
    final int hh = (height + 1) / 2 + GraphUtil.labelPadding;
    return hh;
  }

  public int x(final mxCell cell) {
    return (int) cell.getGeometry().getCenterX();
  }

  public int y(final mxCell cell) {
    return (int) cell.getGeometry().getCenterY();
  }
}
