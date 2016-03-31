package eu.modelwriter.visualization.editor.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.util.mxPoint;

import eu.modelwriter.visualization.editor.StaticEditorManager;
import eu.modelwriter.visualization.model.OurObject;
import eu.modelwriter.visualization.model.Pair;

public class NodeUtil {
  /**
   * It provides Singleton Pattern.
   */
  private static NodeUtil nodeUtil;

  public static final String TYPE = "type";

  /**
   * {@link GraphUtil} intance.
   */
  private static GraphUtil graphUtilInstance;

  public static NodeUtil getInstance() {
    NodeUtil.graphUtilInstance = GraphUtil.getInstance();
    if (NodeUtil.nodeUtil == null) {
      NodeUtil.nodeUtil = new NodeUtil();
    }
    return NodeUtil.nodeUtil;
  }

  private NodeUtil() {}

  /** (Re-)calculate this node's bounds. */
  public void calcBounds(final mxCell node) {
    final int hw = this.side(node);
    node.getGeometry().setWidth(hw * 2);
    ((OurObject) node.getValue()).setAttribute(GraphUtil.SIDE, String.valueOf(hw));

    final int hh = this.updown(node);
    node.getGeometry().setHeight(hh * 2);
    node.setAttribute(GraphUtil.UPDOWN, String.valueOf(hh));
  }

  /**
   * @param node
   * @return center X coordinate of given node.
   */
  public int centerX(final mxCell node) {
    return (int) node.getGeometry().getCenterX();
  }

  /**
   * @param node
   * @return center Y coordinate of given node.
   */
  public int centerY(final mxCell node) {
    return (int) node.getGeometry().getCenterY();
  }

  /**
   * @param node
   * @return layer number of given node.
   */
  public int layer(final mxCell node) {
    return ((OurObject) node.getValue()).getAttribute(GraphUtil.LAYER) == null ? -1
        : Integer.valueOf(((OurObject) node.getValue()).getAttribute(GraphUtil.LAYER));
  }

  /**
   * @param node
   * @return width of given node with self edge bounds if node has any
   *         {@linkplain NodeUtil#selfs(mxCell) self edge}.
   */
  public int reserved(final mxCell node) {
    final LinkedList<mxCell> selfs = this.selfs(node);
    int reserved = 0;
    for (int i = 0; i < selfs.size(); i++) {
      if (i == 0) {
        reserved = Integer.valueOf(node.getAttribute(GraphUtil.SIDE)) + GraphUtil.selfLoopA;
        continue;
      }
      reserved = reserved + (int) StaticEditorManager.graph.getView().getState(selfs.get(i - 1))
          .getLabelBounds().getWidth() + GraphUtil.selfLoopGL + GraphUtil.selfLoopGR;
    }
    if (reserved > 0) {
      reserved =
          reserved + (int) StaticEditorManager.graph.getView().getState(selfs.get(selfs.size() - 1))
              .getLabelBounds().getWidth() + GraphUtil.selfLoopGL + GraphUtil.selfLoopGR;
    }
    return reserved;
  }

  /**
   * @param node
   * @return List of edges of node which of their source and target is node.
   */
  public LinkedList<mxCell> selfs(final mxCell node) {
    final LinkedList<mxCell> selfs = new LinkedList<>();
    for (final Object object : StaticEditorManager.graph.getOutgoingEdges(node)) {
      final mxCell edge = (mxCell) object;
      final mxICell target = edge.getTarget();
      if (target != null && target.equals(node)) {
        selfs.add(edge);
      }
    }
    return selfs;
  }

  /**
   * Sets new X coordinate of given node. <br>
   * If left coordinate of node is negative, then shift right all elements in the same layer.
   *
   * @param node
   * @param newCenterX
   */
  public void setX(final mxCell node, final int newCenterX) {
    final int oldCenterX = this.centerX(node);
    StaticEditorManager.graph.moveCells(new Object[] {node}, newCenterX - oldCenterX, 0);
    final int leftOfNode = newCenterX - this.side(node);
    if (leftOfNode < 0) {
      StaticEditorManager.graph.moveCells(NodeUtil.graphUtilInstance.getNodes().toArray(),
          Math.abs(leftOfNode), 0);
      for (final Object edge : NodeUtil.graphUtilInstance.getEdges()) {
        for (final mxPoint point : ((mxCell) edge).getGeometry().getPoints()) {
          point.setX(point.getX() + Math.abs(leftOfNode));
        }
      }
    }
  }

  /**
   * Sets new Y coordinate of all elements in the same layer.<br>
   *
   * @param layer
   * @param newCenterY
   */
  public void setY(final int layer, final int newCenterY) {
    for (final Map<Integer, ArrayList<Pair>> value : mxHierarchicalLayout.hierarchyLayerControl) {
      final ArrayList<Pair> list = value.get(layer);
      if (list != null) {
        for (final Pair pair : list) {
          final mxPoint point =
              EdgeUtil.getInstance().getControlPoint(pair.getEdge(), pair.getOrder());
          final int sum = NodeUtil.graphUtilInstance.runLayerMinY()[layer]
              + NodeUtil.graphUtilInstance.layerPH()[layer] / 2;
          if (newCenterY < sum) {
            point.setY(sum);
          } else {
            point.setY(newCenterY);
          }
        }
      }
    }
    // final ArrayList<Pair> list = mxCoordinateAssignment.layerControlmap.get(layer);
    // if (list != null) {
    // for (final Pair pair : list) {
    // final mxPoint point =
    // EdgeUtil.getInstance().getControlPoint(pair.getEdge(), pair.getOrder());
    // final int sum = NodeUtil.graphUtilInstance.runLayerMinY()[layer]
    // + NodeUtil.graphUtilInstance.layerPH()[layer] / 2;
    // if (newCenterY < sum) {
    // point.setY(sum);
    // } else {
    // point.setY(newCenterY);
    // }
    // }
    // }

    for (final mxCell node : NodeUtil.graphUtilInstance.layer(layer)) {
      final int newY = newCenterY - NodeUtil.graphUtilInstance.layerPH()[layer] / 2;
      if (newY < NodeUtil.graphUtilInstance.runLayerMinY()[layer]) {
        node.getGeometry().setY(NodeUtil.graphUtilInstance.runLayerMinY()[layer]);
      } else {
        node.getGeometry().setY(newY);
      }
    }
  }

  /**
   * Helper method that shifts a node down.
   */
  private void shiftDown(final mxCell node, int layerOfNode, int newCenterY) {
    final int[] ph = NodeUtil.graphUtilInstance.layerPH();
    final int yJump = GraphUtil.yJump / 6;
    this.setY(layerOfNode, newCenterY);
    newCenterY = newCenterY + ph[layerOfNode] / 2;
    // y is now the bottom-most edge of this layer
    for (layerOfNode--; layerOfNode >= 0; layerOfNode--) {
      final List<mxCell> list = NodeUtil.graphUtilInstance.layer(layerOfNode);
      final mxCell first = list.get(0);
      final int centerY = this.centerY(first);
      if (centerY - ph[layerOfNode] / 2 - yJump < newCenterY) {
        this.setY(layerOfNode, newCenterY + ph[layerOfNode] / 2 + yJump);
      }
      newCenterY = centerY + ph[layerOfNode] / 2;
    }
  }

  /** Helper method that shifts a node left. */
  private void shiftLeft(final mxCell node, final List<mxCell> peers, int orderInLayer,
      int newCenterX) {
    final int xJump = GraphUtil.xJump / 3;
    this.setX(node, newCenterX);
    int side = this.side(node);
    newCenterX = newCenterX - side;
    // x is now the left-most edge of this node
    for (orderInLayer--; orderInLayer >= 0; orderInLayer--) {
      final mxCell other = peers.get(orderInLayer);
      side = this.side(other);
      int centerX = this.centerX(other);
      if (centerX + side + this.reserved(other) + xJump > newCenterX) {
        centerX = newCenterX - side - this.reserved(other) - xJump;
        this.setX(other, centerX);
      }
      newCenterX = centerX - side;
    }
  }

  /**
   * Helper method that shifts a node right.
   */
  private void shiftRight(final mxCell node, final List<mxCell> peers, int orderInLayer,
      int newCenterX) {
    final int xJump = GraphUtil.xJump / 3;
    this.setX(node, newCenterX);
    int side = this.side(node);
    newCenterX = newCenterX + side + this.reserved(node);
    // x is now the right most edge of this node
    for (orderInLayer++; orderInLayer < peers.size(); orderInLayer++) {
      final mxCell other = peers.get(orderInLayer);
      side = this.side(other);
      int centerX = this.centerX(other);
      if (centerX - side - xJump < newCenterX) {
        centerX = newCenterX + side + xJump;
        this.setX(other, centerX);
      }
      newCenterX = centerX + side + this.reserved(other);
    }
  }

  /**
   * Helper method that shifts a node up.
   */
  private void shiftUp(final mxCell node, int layerOfNode, int newCenterY) {
    final int[] ph = NodeUtil.graphUtilInstance.layerPH();
    final int yJump = GraphUtil.yJump / 6;

    final int old = this.centerY(node);
    this.setY(layerOfNode, newCenterY);
    final int neu = this.centerY(node);

    if (old == neu) {
      for (int layer = layerOfNode - 1; layer >= 0; layer--) {
        NodeUtil.graphUtilInstance.moveControlPointsBy(layer, Math.abs(newCenterY - old));
        StaticEditorManager.graph.moveCells(NodeUtil.graphUtilInstance.layer(layer).toArray(), 0,
            Math.abs(newCenterY - old));
      }
    } else {
      newCenterY = this.centerY(node) - ph[layerOfNode] / 2;
      // y is now the top-most edge of this layer
      for (layerOfNode++; layerOfNode < NodeUtil.graphUtilInstance.layers(); layerOfNode++) {
        final int centerY = NodeUtil.graphUtilInstance.yOfLayer(layerOfNode);
        if (centerY + ph[layerOfNode] / 2 + yJump > newCenterY) {
          this.setY(layerOfNode, newCenterY - ph[layerOfNode] / 2 - yJump);
        }
        newCenterY = centerY - ph[layerOfNode] / 2;
      }
    }
  }

  /**
   * calculates size from center of node to vertical edge of node with padding.
   *
   * @param node
   * @return (width + 1) / 2 + padding
   */
  public int side(final mxCell node) {
    final int width = (int) node.getGeometry().getWidth();
    final int hw = (width + 1) / 2 + GraphUtil.labelPadding;
    return hw;
  }

  /**
   * @param node
   * @return source vertices of given node. <br>
   *         It not includes if given node is source of itself.
   */
  public List<mxCell> sources(final mxCell node) {
    final LinkedList<mxCell> sources = new LinkedList<>();
    for (final Object object : StaticEditorManager.graph.getIncomingEdges(node)) {
      final mxCell edge = (mxCell) object;
      final mxICell source = edge.getSource();
      if (!source.equals(node)) {
        sources.add((mxCell) source);
      } else if (edge.getTarget().equals(node)) {
        sources.add((mxCell) source);
      }
    }
    return sources;
  }

  /** Helper method that swaps a node towards the left. */
  private void swapLeft(final mxCell node, final List<mxCell> peers, int orderInLayer,
      final int newCenterX) {
    final int side = this.side(node);
    final int left = newCenterX - side;
    while (true) {
      if (orderInLayer == 0) {
        this.setX(node, newCenterX);
        return;
      } // no clash possible
      final mxCell other = peers.get(orderInLayer - 1);
      final int otherSide = this.side(other);
      final int otherRight = this.centerX(other) + otherSide + this.reserved(other);
      if (otherRight < left) {
        this.setX(node, newCenterX);
        return;
      } // no clash
      NodeUtil.graphUtilInstance.swapNodes(this.layer(node), orderInLayer, orderInLayer - 1);
      orderInLayer--;
      this.shiftRight(other, peers, orderInLayer + 1,
          newCenterX + side + this.reserved(node) + otherSide);
    }
  }

  /** Helper method that swaps a node towards the right. */
  private void swapRight(final mxCell node, final List<mxCell> peers, int orderInLayer,
      final int newCenterX) {
    final int side = this.side(node);
    final int right = newCenterX + side + this.reserved(node);
    while (true) {
      if (orderInLayer == peers.size() - 1) {
        this.setX(node, newCenterX);
        return;
      } // no clash possible
      final mxCell other = peers.get(orderInLayer + 1);
      final int otherSide = this.side(other);
      final int otherLeft = this.centerX(other) - otherSide;
      if (otherLeft > right) {
        this.setX(node, newCenterX);
        return;
      } // no clash
      NodeUtil.graphUtilInstance.swapNodes(this.layer(node), orderInLayer, orderInLayer + 1);
      orderInLayer++;
      this.shiftLeft(other, peers, orderInLayer - 1,
          newCenterX - side - this.reserved(other) - otherSide);
    }
  }

  /**
   * @param node
   * @return target vertices of given node. <br>
   *         It not includes if given node is target of itself.
   */
  public List<mxCell> targets(final mxCell node) {
    final LinkedList<mxCell> targets = new LinkedList<>();
    for (final Object object : StaticEditorManager.graph.getOutgoingEdges(node)) {
      final mxCell edge = (mxCell) object;
      final mxICell target = edge.getTarget();
      if (!target.equals(node)) {
        targets.add((mxCell) target);
      } else if (edge.getSource().equals(node)) {
        targets.add((mxCell) target);
      }
    }
    return targets;
  }

  /**
   * Assuming the graph is already laid out, this shifts this node (and re-layouts nearby
   * nodes/edges as necessary)
   */
  public void tweak(final mxCell node, final int newCenterX, final int newCenterY) {
    final int oldCenterX = this.centerX(node);
    final int oldCenterY = this.centerY(node);
    if (oldCenterX == newCenterX && oldCenterY == newCenterY) {
      return; // If no change, then return right away
    }
    final int layerOfNode = this.layer(node);
    final List<mxCell> layerCells = NodeUtil.graphUtilInstance.layer(layerOfNode);
    final int n = layerCells.size();
    int orderInLayer;
    for (orderInLayer = 0; orderInLayer < n; orderInLayer++) {
      if (layerCells.get(orderInLayer).equals(node)) {
        break; // Figure out this node's position in its layer
      }
    }
    if (oldCenterX > newCenterX) {
      this.swapLeft(node, layerCells, orderInLayer, newCenterX);
    } else if (oldCenterX < newCenterX) {
      this.swapRight(node, layerCells, orderInLayer, newCenterX);
    }
    if (oldCenterY > newCenterY) {
      this.shiftUp(node, layerOfNode, newCenterY);
    } else if (oldCenterY < newCenterY) {
      this.shiftDown(node, layerOfNode, newCenterY);
    }
  }

  /**
   * @param edge which has selected control point
   * @param controlPointOrder order of selected control point in the points of edge
   * @param oldCenterY
   * @param newCenterY
   */
  public void tweakControlPoint(final mxCell edge, final int controlPointOrder,
      final int oldCenterY, final int newCenterY) {
    final int layerOfPoint = EdgeUtil.getInstance().layer(edge, controlPointOrder);
    if (layerOfPoint == -1) {
      return;
    }
    final mxCell nodeInLayer = NodeUtil.graphUtilInstance.layer(layerOfPoint).get(0);
    if (oldCenterY > newCenterY) {
      this.shiftUp(nodeInLayer, layerOfPoint, newCenterY);
    } else if (oldCenterY < newCenterY) {
      this.shiftDown(nodeInLayer, layerOfPoint, newCenterY);
    }
  }

  /**
   * calculates size from center of node to horizontal edge of node with padding.
   *
   * @return (height + 1) / 2 + padding
   */
  public int updown(final mxCell node) {
    final int height = (int) node.getGeometry().getHeight();
    final int hh = (height + 1) / 2 + GraphUtil.labelPadding;
    return hh;
  }

  /**
   * @param node
   * @return X coordinate of given node.
   */
  public int x(final mxCell node) {
    return this.centerX(node) - this.side(node);
  }

  /**
   * @param node
   * @return Y coordinate of given node.
   */
  public int y(final mxCell node) {
    return this.centerY(node) - this.updown(node);
  }
}
