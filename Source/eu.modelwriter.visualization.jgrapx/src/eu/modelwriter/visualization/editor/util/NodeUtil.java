package eu.modelwriter.visualization.editor.util;

import java.util.LinkedList;
import java.util.List;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;

import eu.modelwriter.visualization.editor.Graph;
import eu.modelwriter.visualization.editor.GraphComponent;

public class NodeUtil {
  private static NodeUtil nodeUtil;
  private static GraphUtil graphUtilInstance;
  private static Graph graph;
  private static GraphComponent graphComponent;

  /**
   * This determines the minimum amount of padding added above, left, right, and below the text
   * label.
   */
  private static final int labelPadding = 5;

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
    cell.setAttribute("side", String.valueOf(hw));

    final int hh = this.updown(cell);
    cell.getGeometry().setHeight(hh * 2);
    cell.setAttribute("updown", String.valueOf(hh));
  }

  private int centerX(final mxCell cell) {
    return (int) cell.getGeometry().getCenterX();
  }

  private int centerY(final mxCell cell) {
    return (int) cell.getGeometry().getCenterY();
  }

  public List<mxCell> getSources(final mxCell cell) {
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

  public List<mxCell> getTargets(final mxCell cell) {
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

  public int layer(final mxCell cell) {
    return cell.getAttribute("layer") == null ? -1 : Integer.valueOf(cell.getAttribute("layer"));
  }

  public int reserved(final mxCell cell) {
    final LinkedList<mxCell> selfs = this.selfs(cell);
    int reserved = 0;
    for (int i = 0; i < selfs.size(); i++) {
      if (i == 0) {
        reserved = Integer.valueOf(cell.getAttribute("side")) + GraphUtil.selfLoopA;
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

  private LinkedList<mxCell> selfs(final mxCell cell) {
    final LinkedList<mxCell> selfs = new LinkedList<>();
    for (final Object object : NodeUtil.graph.getOutgoingEdges(cell)) {
      final mxCell edge = (mxCell) object;
      final mxICell target = edge.getTarget();
      if (target.equals(cell)) {
        selfs.add(edge);
      }
    }
    return selfs;
  }

  public void setY(final int layer, final int newY) {
    for (final mxCell cell : NodeUtil.graphUtilInstance.layer(layer)) {
      final int newCenterY = newY - this.updown(cell);
      cell.getGeometry().setY(newCenterY);
      // final Object[] array = new Object[1];
      // array[0] = cell;
      // final double centerY = cell.getGeometry().getCenterY();
      // final double newCenterY = newY - centerY;
      // NodeUtil.graph.moveCells(array, 0, newCenterY);
    }
  }

  /** Helper method that shifts a node down. */
  private void shiftDown(final mxCell cell, int newY) {
    final int[] ph = NodeUtil.graphUtilInstance.layerPH();
    final int yJump = GraphUtil.yJump / 6;
    int i = this.layer(cell);
    this.setY(i, newY);
    newY = newY + ph[i] / 2;
    // y is now the bottom-most edge of this layer
    for (i--; i >= 0; i--) {
      final List<mxCell> list = NodeUtil.graphUtilInstance.layer(i);
      final mxCell first = list.get(0);
      final int centerY = this.centerY(first);
      if (centerY - ph[i] / 2 - yJump < newY) {
        this.setY(i, newY + ph[i] / 2 + yJump);
      }
      newY = centerY + ph[i] / 2;
    }
    // this.graph.relayout_edges(false);
  }

  /** Helper method that shifts a node left. */
  private void shiftLeft(final mxCell cell, final List<mxCell> peers, int i, int newX) {
    final int xJump = GraphUtil.xJump / 3;
    int newCenterX = newX - this.side(cell);
    cell.getGeometry().setX(newCenterX);
    int side = this.side(cell);
    newX = newX - side;
    // x is now the left-most edge of this node
    for (i--; i >= 0; i--) {
      final mxCell node = peers.get(i);
      side = this.side(node);
      int centerX = this.centerX(node);
      if (centerX + side + this.reserved(node) + xJump > newX) {
        centerX = newX - side - this.reserved(node) - xJump;
        newCenterX = newX - this.side(node);
        node.getGeometry().setX(newCenterX);
      }
      newX = centerX - side;
    }
  }

  /**
   * Helper method that shifts a node right.
   */
  private void shiftRight(final mxCell cell, final List<mxCell> peers, int i, int newX) {
    final int xJump = GraphUtil.xJump / 3;
    int newCenterX = newX - this.side(cell);
    cell.getGeometry().setX(newCenterX);
    int side = this.side(cell);
    newX = newX + side + this.reserved(cell);
    // x is now the right most edge of this node
    for (i++; i < peers.size(); i++) {
      final mxCell node = peers.get(i);
      side = this.side(node);
      int centerX = this.centerX(node);
      if (centerX - side - xJump < newX) {
        centerX = newX + side + xJump;
        newCenterX = newX - this.side(node);
        node.getGeometry().setX(newCenterX);
      }
      newX = centerX + side + this.reserved(node);
    }
  }

  /** Helper method that shifts a node up. */
  private void shiftUp(final mxCell cell, int newY) {
    NodeUtil.graph.moveCells(NodeUtil.graphUtilInstance.layer(this.layer(cell)).toArray(), 0, -5);
    final int[] ph = NodeUtil.graphUtilInstance.layerPH();
    final int yJump = GraphUtil.yJump / 6;
    int i = this.layer(cell);
    this.setY(i, newY);
    newY = newY - ph[i] / 2;
    // y is now the top-most edge of this layer
    for (i++; i < NodeUtil.graphUtilInstance.getLayerlist().size(); i++) {
      final List<mxCell> list = NodeUtil.graphUtilInstance.layer(i);
      final mxCell first = list.get(0);
      final int centerY = this.centerY(first);
      if (centerY + ph[i] / 2 + yJump > newY) {
        this.setY(i, newY - ph[i] / 2 - yJump);
      }
      newY = centerY - ph[i] / 2;
    }
    // ChengLayout.graph.relayout_edges(false);
  }

  private int side(final mxCell cell) {
    final int width = (int) cell.getGeometry().getWidth();
    final int hw = (width + 1) / 2 + NodeUtil.labelPadding;
    return hw;
  }

  /** Helper method that swaps a node towards the left. */
  private void swapLeft(final mxCell cell, final List<mxCell> peers, int orderInLayer,
      final int newX) {
    final int newCenterX = newX - this.side(cell);
    final int side = this.side(cell);
    final int left = newX - side;
    while (true) {
      if (orderInLayer == 0) {
        cell.getGeometry().setX(newCenterX);
        return;
      } // no clash possible
      final mxCell other = peers.get(orderInLayer - 1);
      final int otherSide = this.side(other);
      final int otherRight = this.centerX(other) + otherSide + this.reserved(other);
      if (otherRight < left) {
        cell.getGeometry().setX(newCenterX);
        return;
      } // no clash
      NodeUtil.graphUtilInstance.swapNodes(this.layer(cell), orderInLayer, orderInLayer - 1);
      orderInLayer--;
      this.shiftRight(other, peers, orderInLayer + 1,
          newX + side + this.reserved(cell) + otherSide);
    }
  }

  /** Helper method that swaps a node towards the right. */
  private void swapRight(final mxCell cell, final List<mxCell> peers, int orderInLayer,
      final int newX) {
    final int newCenterX = newX - this.side(cell);
    final int side = this.side(cell);
    final int right = newX + side + this.reserved(cell);
    while (true) {
      if (orderInLayer == peers.size() - 1) {
        cell.getGeometry().setX(newCenterX);
        return;
      } // no clash possible
      final mxCell other = peers.get(orderInLayer + 1);
      final int otherSide = this.side(other);
      final int otherLeft = this.centerX(other) - otherSide;
      if (otherLeft > right) {
        cell.getGeometry().setX(newCenterX);
        return;
      } // no clash
      NodeUtil.graphUtilInstance.swapNodes(this.layer(cell), orderInLayer, orderInLayer + 1);
      orderInLayer++;
      this.shiftLeft(other, peers, orderInLayer - 1,
          newX - side - this.reserved(other) - otherSide);
    }
  }

  /**
   * Assuming the graph is already laid out, this shifts this node (and re-layouts nearby
   * nodes/edges as necessary)
   */
  public void tweak(final mxCell cell, final int oldX, final int oldY, final int newX,
      final int newY) {
    final int centerX = this.centerX(cell);
    final int centerY = this.centerY(cell);
    if (centerX == newX && centerY == newY) {
      return; // If no change, then return right away
    }
    final int layerOfCell = this.layer(cell);
    final List<mxCell> layer = NodeUtil.graphUtilInstance.layer(layerOfCell);
    final int n = layer.size();
    int i;
    for (i = 0; i < n; i++) {
      if (layer.get(i).equals(cell)) {
        break; // Figure out this node's position in its layer
      }
    }
    if (centerX > newX) {
      this.swapLeft(cell, layer, i, newX);
    } else if (centerX < newX) {
      this.swapRight(cell, layer, i, newX);
    }
    if (centerY > newY) {
      this.shiftUp(cell, newY);
    } else if (centerY < newY) {
      this.shiftDown(cell, newY);
    } else {
      // NodeUtil.graph.relayout_edges(layerOfCell);
    }
    // this.graph.recalcBound(false);}
    NodeUtil.graphComponent.refresh();
  }

  private int updown(final mxCell cell) {
    final int height = (int) cell.getGeometry().getHeight();
    final int hh = (height + 1) / 2 + NodeUtil.labelPadding;
    return hh;
  }
}
