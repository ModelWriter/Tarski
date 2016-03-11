package com.mxgraph.examples.swing.viz;

import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import javax.swing.JLabel;

import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.util.mxMorphing;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.util.mxPoint;
import com.mxgraph.util.mxRectangle;
import com.mxgraph.view.mxGraph;

public class ChengLayout {
  /** This corresponds to the Block structure described in the paper. */
  private static final class Block {
    /** These fields are described in the paper. */
    private final int first, last, weight;
    /** These fields are described in the paper. */
    private final double width, posn, wposn;

    /** This constructs a sentinel block. */
    public Block() {
      this.posn = Double.NEGATIVE_INFINITY;
      this.first = 0;
      this.last = 0;
      this.weight = 0;
      this.width = 0;
      this.wposn = 0;
    }

    /** This merges the two existing blocks into a new block. */
    public Block(final Block a, final Block b) {
      this.first = a.first;
      this.last = b.last;
      this.width = a.width + b.width;
      this.wposn = a.wposn + b.wposn - a.width * b.weight;
      this.weight = a.weight + b.weight;
      this.posn = this.wposn / this.weight;
    }

    /** This constructs a regular block. */
    public Block(final mxCell v, final int i) {
      this.first = i;
      this.last = i;
      this.width = v.getGeometry().getWidth() + v.getReserved(ChengLayout.graph) + 30;
      this.posn = ChengLayout.des(v) - this.width / 2;
      this.weight = 1;
      this.wposn = this.weight * this.posn;
    }
  }

  private static ChengLayout layout;
  private static mxGraphComponent graphComponent;
  private static Object[] cells = null;

  private static VisualizationGraph graph;

  /**
   * This computes the des() value as described in the paper.
   * <p>
   * The desired location of V = ("sum e:in(V) | wt(e) * phi(start of e)" +
   * "sum e:out(V) | wt(e) * phi(end of e)") / wt(v)
   */
  private static double des(final mxCell n) {
    double ans = 0;
    for (final Object e : ChengLayout.graph.getIncomingEdges(n)) {
      ans += ((mxCell) e).getTarget().getGeometry().getCenterX();
    }
    for (final Object e : ChengLayout.graph.getOutgoingEdges(n)) {
      ans += ((mxCell) e).getSource().getGeometry().getCenterX();
    }
    return ans;
  }

  public static ChengLayout getInstance() {
    if (ChengLayout.layout == null) {
      ChengLayout.layout = new ChengLayout();
    }
    return ChengLayout.layout;
  }

  /** The total width of the graph; this value is computed by layout(). */
  private double totalWidth = 0;

  /** The total height of the graph; this value is computed by layout(). */
  private double totalHeight = 0;

  /** The left edge. */
  private double left = 0;

  /** The top edge. */
  private double top = 0;

  /** The bottom edge. */
  private double bottom = 0;

  /** The height of each layer. */
  double[] layerPH = null;

  /** An unmodifiable empty list. */
  private final List<mxCell> emptyListOfNodes =
      Collections.unmodifiableList(new ArrayList<mxCell>(0));

  private Object[] childVertices;
  TreeMap<Double, ArrayList<mxCell>> xVertices = new TreeMap<Double, ArrayList<mxCell>>();

  TreeMap<Double, ArrayList<mxCell>> yVertices = new TreeMap<Double, ArrayList<mxCell>>();

  private ChengLayout() {}

  // Layout step #1: assign a total order on the nodes.
  private void assignOrders() {
    final int num = this.childVertices.length;
    final List<List<mxCell>> bins = new ArrayList<List<mxCell>>(2 * num + 1);
    for (int i = 0; i < 2 * num + 1; i++) {
      bins.add(new LinkedList<mxCell>());
    }
    final ArrayList<LinkedList<mxCell>> grIN = new ArrayList<LinkedList<mxCell>>(num);
    final ArrayList<LinkedList<mxCell>> grOUT = new ArrayList<LinkedList<mxCell>>(num);
    final int[] grBIN = new int[num];
    for (final Object node : this.childVertices) {
      final int ni = Integer.valueOf(((mxCell) node).getAttribute("Position"));
      final LinkedList<mxCell> in = new LinkedList<mxCell>(), out = new LinkedList<mxCell>();
      for (final Object e : ChengLayout.graph.getIncomingEdges(node)) {
        final mxCell a = (mxCell) ((mxCell) e).getSource();
        if (!in.contains(a)) {
          in.add(a);
        }
      }
      for (final Object e : ChengLayout.graph.getOutgoingEdges(node)) {
        final mxCell b = (mxCell) ((mxCell) e).getTarget();
        if (!out.contains(b)) {
          out.add(b);
        }
      }
      grIN.add(in);
      grOUT.add(out);
      grBIN[ni] = out.size() == 0 ? 0 : in.size() == 0 ? 2 * num : out.size() - in.size() + num;
      bins.get(grBIN[ni]).add((mxCell) node);
    }
    final LinkedList<mxCell> s1 = new LinkedList<mxCell>(), s2 = new LinkedList<mxCell>();
    while (true) {
      mxCell x = null;
      if (!bins.get(0).isEmpty()) {
        // If a sink exists, take a sink X and prepend X to S2
        x = bins.get(0).remove(bins.get(0).size() - 1);
        s1.add(x);
      } else {
        for (int j = 2 * num; j > 0; j--) {
          // Otherwise, let x be a source if one exists, or a node with the highest #out-#in. Then
          // append X to S1.
          final List<mxCell> bin = bins.get(j);
          final int sz = bin.size();
          if (sz > 0) {
            x = bin.remove(sz - 1);
            s2.addFirst(x);
            break;
          }
        }
      }
      if (x == null) {
        break; // This means we're done; else, delete X from its bin, and move each of X's
        // neighbor into their new bin
      }
      bins.get(grBIN[Integer.valueOf(x.getAttribute("Position"))]).remove(x);
      for (final mxCell n : grIN.get(Integer.valueOf(x.getAttribute("Position")))) {
        grOUT.get(Integer.valueOf(n.getAttribute("Position"))).remove(x);
      }
      for (final mxCell n : grOUT.get(Integer.valueOf(x.getAttribute("Position")))) {
        grIN.get(Integer.valueOf(n.getAttribute("Position"))).remove(x);
      }
      for (final mxCell n : VisualizationCellUtility.fastJoin(
          grIN.get(Integer.valueOf(x.getAttribute("Position"))),
          grOUT.get(Integer.valueOf(x.getAttribute("Position"))))) {
        final int ni = Integer.valueOf(n.getAttribute("Position")), out = grOUT.get(ni).size(),
            in = grIN.get(ni).size();
        final int b = out == 0 ? 0 : in == 0 ? 2 * num : out - in + num;
        if (grBIN[ni] != b) {
          bins.get(grBIN[ni]).remove(n);
          grBIN[ni] = b;
          bins.get(b).add(n);
        }
      }
    }
    this.sortNodes(VisualizationCellUtility.fastJoin(s1, s2));
  }

  // Layout step #2: reverses all backward edges.
  private void backEdges() {
    for (final Object e : ChengLayout.graph
        .getAllEdges(new Object[] {ChengLayout.graph.getDefaultParent()})) {
      final mxCell edge = (mxCell) e;

      final mxICell source = edge.getSource();
      final mxICell target = edge.getTarget();
      final int sourcePos = Integer.valueOf(((mxCell) source).getAttribute("Position"));
      final int targetPos = Integer.valueOf(((mxCell) target).getAttribute("Position"));
      if (sourcePos < targetPos) {
        final Object[] incomingEdges = ChengLayout.graph.getIncomingEdges(source);
        // edge.set(edge.bhead(), edge.ahead()).reverse();
      }
    }
  }

  /**
   * Creates a layout instance for the given identifier.
   */
  private mxIGraphLayout createLayout(final String ident, final boolean animate) {
    mxIGraphLayout layout = null;

    if (ident != null) {
      final mxGraph graph = ChengLayout.graphComponent.getGraph();
      if (ident.equals("verticalHierarchical")) {
        layout = new mxHierarchicalLayout(graph);
      } else if (ident.equals("horizontalHierarchical")) {
        layout = new mxHierarchicalLayout(graph, JLabel.WEST);
      }
    }

    return layout;
  }

  // // Layout step #4: add dummy nodes so that each edge only goes between adjacent layers.
  // private void dummyNodesIfNeeded() {
  // final Object[] allEdges =
  // ChengLayout.graph.getAllEdges(new Object[] {ChengLayout.graph.getDefaultParent()});
  // for (int i = 0; i < allEdges.length; i++) {
  // mxCell e = (mxCell) allEdges[i];
  // mxCell a = (mxCell) e.getSource();
  // final mxCell b = (mxCell) e.getTarget();
  // while (a.layer() - b.layer() > 1) {
  // final mxCell tmp = a;
  // a = (mxCell) ChengLayout.graph.insertVertex(ChengLayout.graph.getDefaultParent(), null,
  // null, 0, 0, 5, 5, "shape=ellipse;perimter=ellipsePerimeter");
  // a.setLayer(ChengLayout.graph, tmp.layer() - 1);
  // // now we have three nodes in the vertical order of "tmp", "a", then "b"
  // e.change(ChengLayout.graph, a); // let old edge go from "tmp" to "a"
  // e = (mxCell) ChengLayout.graph.insertEdge(ChengLayout.graph.getDefaultParent(), null, null,
  // a, b); // let new edge go from "a" to "b"
  // }
  // }
  // }

  // Layout step #3: assign the nodes into one or more layers, then return the number of layers.
  private int decideLayer() {
    // Here, for each node X, I compute its maximum length to a sink; if X is a sink, its length to
    // sink is 0.
    final int n = this.childVertices.length;
    final int[] len = new int[n];
    for (final Object x : this.childVertices) {
      // Since we ensured that arrows only ever go from a node with bigger pos() to a node with
      // smaller pos(),
      // we can compute the "len" array in O(n) time by visiting each node IN THE SORTED ORDER
      int max = 0;
      for (final Object e : ChengLayout.graph.getOutgoingEdges(x)) {
        final mxCell y = (mxCell) ((mxCell) e).getTarget();
        final int yLen = len[Integer.valueOf(y.getAttribute("Position"))] + 1;
        if (max < yLen) {
          max = yLen;
        }
      }
      len[Integer.valueOf(((mxCell) x).getAttribute("Position"))] = max;
    }
    // Now, we simply do the simplest thing: assign each node to the layer corresponding to its
    // mfinal ax-length-to-sink.
    for (final Object x : this.childVertices) {
      ((mxCell) x).setLayer(ChengLayout.graph,
          len[Integer.valueOf(((mxCell) x).getAttribute("Position"))]);
    }
    // Now, apply a simple trick: whenever every one of X's incoming edge is more than one layer
    // above, then move X up
    while (true) {
      boolean changed = false;
      for (final Object x : this.childVertices) {
        if (ChengLayout.graph.getIncomingEdges(x).length > 0) {
          int closestLayer = ChengLayout.graph.layerlist.size() + 1;
          for (final Object e : ChengLayout.graph.getIncomingEdges(x)) {
            final int y = ((mxCell) ((mxCell) e).getSource()).layer();
            if (closestLayer > y) {
              closestLayer = y;
            }
          }
          if (closestLayer - 1 > ((mxCell) x).layer()) {
            ((mxCell) x).setLayer(ChengLayout.graph, closestLayer - 1);
            changed = true;
          }
        }
      }
      if (!changed) {
        break;
      }
    }
    // All done!
    return ChengLayout.graph.layerlist.size();
  }

  // Layout step #4: add dummy nodes so that each edge only goes between adjacent layers.
  private void dummyNodesIfNeeded() {
    for (int i = 0; i < ChengLayout.graph.getEdgeList().size(); i++) {
      final mxCell e = (mxCell) ChengLayout.graph.getEdgeList().get(i);
      final mxCell a = (mxCell) e.getSource();
      final mxCell b = (mxCell) e.getTarget();

      final int dist = a.layer() - b.layer();
      if (dist > 1) {
        // ChengLayout.graph.setCellStyles(mxConstants.STYLE_MOVABLE, "1", new Object[] {e});
        ChengLayout.graph.setCellStyles(mxConstants.STYLE_BENDABLE, "1", new Object[] {e});
        ChengLayout.graph.setCellStyles(mxConstants.STYLE_EDGE,
            mxConstants.EDGESTYLE_ENTITY_RELATION, new Object[] {e});

        // final mxCellState edgeState = ChengLayout.graph.getView().getState(e);
        final List<mxPoint> edgeContPoints = new ArrayList<mxPoint>();

        final mxRectangle edgeBounds = ChengLayout.graph.getCellBounds(e);
        final mxPoint lastPoint = new mxPoint(edgeBounds.getX() + edgeBounds.getWidth(),
            edgeBounds.getY() + edgeBounds.getHeight());
        final double deltaX = lastPoint.getX() - edgeBounds.getX();
        final double deltaY = lastPoint.getY() - edgeBounds.getY();
        for (int j = 1; j < dist; j++) {
          edgeContPoints.add(new mxPoint(edgeBounds.getX() + deltaX / dist * j,
              edgeBounds.getY() + deltaY / dist * j));
        }
        e.getGeometry().setPoints(edgeContPoints);
        // edgeState.setAbsolutePoints(edgeContPoints);
        // ChengLayout.graph.getView().updateCellState(edgeState);
      }

      // while (a.layer() - b.layer() > 1) {
      // // edge offset + dist = edge length
      // // edge length / 2*dist - (a.layer() - b.layer())
      // e.getGeometry().getPoints();
      // // final mxCell tmp = a;
      // // a = (mxCell) ChengLayout.graph.insertVertex(ChengLayout.graph.getDefaultParent(), null,
      // // null, 0, 0, 5, 5, "shape=ellipse;perimter=ellipsePerimeter");
      // // a.setLayer(ChengLayout.graph, tmp.layer() - 1);
      // // // now we have three nodes in the vertical order of "tmp", "a", then "b"
      // // if (e.getSource().equals(e.getTarget())) {
      // // final Object[] edgesConnected2Source = ChengLayout.graph.getEdges(e.getSource());
      // // for (final Object edge : edgesConnected2Source) {
      // // if (((mxCell) edge).getSource().equals(((mxCell) edge).getTarget())) {
      // // ChengLayout.graph.removeCells(new Object[] {edge});
      // // }
      // // }
      // // }
      // // // else {
      // // // ChengLayout.graph.removeCells(new Object[] {e});
      // // // }
      // // e.setTarget(a);
      // // // // e.change(ChengLayout.graph, a); // let old edge go from "tmp" to "a"
      // // e = (mxCell) ChengLayout.graph.insertEdge(ChengLayout.graph.getDefaultParent(), null,
      // // null,
      // // a, b); // let new edge go from "a" to "b"
      // }
    }
  }

  /** Returns true if a direct line between a and b will not intersect any other node. */
  private boolean free(mxCell a, mxCell b) {
    if (a.layer() > b.layer()) {
      final mxCell tmp = a;
      a = b;
      b = tmp;
    }
    final Line2D.Double line = new Line2D.Double(a.getGeometry().getCenterX(),
        a.getGeometry().getCenterY(), b.getGeometry().getCenterX(), b.getGeometry().getCenterY());
    for (final Object n : this.childVertices) {
      if (n != a && n != b && a.layer() < ((mxCell) n).layer()
          && ((mxCell) n).layer() < b.layer()) {
        final Rectangle rectangle = ((mxCell) n).getGeometry().getRectangle();
        if (line.intersects(new Rectangle2D.Double(rectangle.getX(), rectangle.getY(),
            rectangle.getWidth() + 10, rectangle.getHeight() + 10))) {
          return false;
        }
      }
    }
    return true;
  }

  private void init() {
    for (final Object object : ChengLayout.cells) {
      final mxCell cell = (mxCell) object;
      if (cell.isVertex()) {
        ArrayList<mxCell> xVertices = this.xVertices.get(cell.getGeometry().getCenterX());
        if (xVertices == null) {
          xVertices = new ArrayList<mxCell>();
          xVertices.add(cell);
          this.xVertices.put(cell.getGeometry().getCenterX(), xVertices);
        } else {
          xVertices.add(cell);
        }

        ArrayList<mxCell> yVertices = this.xVertices.get(cell.getGeometry().getCenterY());
        if (yVertices == null) {
          yVertices = new ArrayList<mxCell>();
          yVertices.add(cell);
          this.xVertices.put(cell.getGeometry().getCenterY(), yVertices);
        } else {
          yVertices.add(cell);
        }
      }
    }
  }

  List<mxCell> layer(final int i) {
    if (i >= 0 && i < ChengLayout.graph.layerlist.size()) {
      return Collections.unmodifiableList(ChengLayout.graph.layerlist.get(i));
    }
    return this.emptyListOfNodes;
  }

  /** Re-establish top/left/width/height. */
  void recalcBound(final boolean fresh) {
    if (this.childVertices.length == 0) {
      this.top = 0;
      this.bottom = 10;
      this.totalHeight = 10;
      this.left = 0;
      this.totalWidth = 10;
      return;
    }
    if (fresh) {
      this.top = ((mxCell) this.childVertices[0]).getGeometry().getCenterY()
          - ((mxCell) this.childVertices[0]).getGeometry().getHeight() / 2 - 5;
      this.bottom = ((mxCell) this.childVertices[0]).getGeometry().getCenterY()
          + ((mxCell) this.childVertices[0]).getGeometry().getHeight() / 2 + 5;
    }
    // Find the leftmost and rightmost pixel
    double minX = ((mxCell) this.childVertices[0]).getGeometry().getCenterX()
        - ((mxCell) this.childVertices[0]).getGeometry().getWidth() / 2 - 5;
    double maxX = ((mxCell) this.childVertices[0]).getGeometry().getCenterX()
        + ((mxCell) this.childVertices[0]).getGeometry().getWidth() / 2
        + ((mxCell) this.childVertices[0]).getReserved(ChengLayout.graph) + 5;
    for (final Object n : this.childVertices) {
      final double min =
          ((mxCell) n).getGeometry().getCenterX() - ((mxCell) n).getGeometry().getWidth() / 2 - 5;
      if (minX > min) {
        minX = min;
      }
      final double max =
          ((mxCell) n).getGeometry().getCenterX() + ((mxCell) n).getGeometry().getWidth() / 2
              + ((mxCell) n).getReserved(ChengLayout.graph) + 5;
      if (maxX < max) {
        maxX = max;
      }
    }

    // final Object[] allEdges =
    // ChengLayout.graph.getAllEdges(new Object[] {ChengLayout.graph.getDefaultParent()});
    // for (final Object e : allEdges) {
    // if (e.getLabelW() > 0 && e.getLabelH() > 0) {
    // final int x1 = e.getLabelX(), x2 = x1 + e.getLabelW() - 1;
    // if (minX > x1) {
    // minX = x1;
    // }
    // if (maxX < x2) {
    // maxX = x2;
    // }
    // }
    // }
    this.left = minX - 20;
    this.totalWidth = maxX - minX + 20;
    // Find the topmost and bottommost pixel
    for (int layer = ChengLayout.graph.layerlist.size() - 1; layer >= 0; layer--) {
      for (final mxCell n : this.layer(layer)) {
        final double ytop = n.getGeometry().getCenterY() - n.getGeometry().getHeight() / 2 - 5;
        if (this.top > ytop) {
          this.top = ytop;
        }
        final double ybottom = n.getGeometry().getCenterY() + n.getGeometry().getHeight() / 2 + 5;
        if (this.bottom < ybottom) {
          this.bottom = ybottom;
        }
      }
    }
    this.totalHeight = this.bottom - this.top;
    // int widestLegend = 0, legendHeight = 30;
    // for (final Pair<String, Color> e : legends.values()) {
    // if (e.b == null) {
    // continue; // that means this legend is not visible
    // }
    // final int widthOfLegend = (int) getBounds(true, e.a).getWidth();
    // if (widestLegend < widthOfLegend) {
    // widestLegend = widthOfLegend;
    // }
    // legendHeight += ad;
    // }
    // if (widestLegend > 0) {
    // this.left -= widestLegend + 10;
    // this.totalWidth += widestLegend * 2 + 10;
    // if (this.totalHeight < legendHeight) {
    // this.bottom = this.bottom + legendHeight - this.totalHeight;
    // this.totalHeight = legendHeight;
    // }
    // }
  }

  // Assuming everything was laid out already, but at least one node just moved, this re-layouts ALL
  // edges.
  private void relayout_edges(final boolean straighten) {
    // Move pairs of virtual nodes to straighten the lines if possible
    if (straighten) {
      for (int i = 0; i < 5; i++) {
        for (final Object n : this.childVertices) {
          if (ChengLayout.graph.getIncomingEdges(n).length != 0
              && ChengLayout.graph.getOutgoingEdges(n).length != 0) {
            final mxCell e1 = (mxCell) ChengLayout.graph.getIncomingEdges(n)[0],
                e2 = (mxCell) ChengLayout.graph.getOutgoingEdges(n)[0];
            if (!this.free((mxCell) e1.getTarget(), (mxCell) e2.getSource())) {
              continue;
            }
            final double slope = (e2.getSource().getGeometry().getCenterX()
                - e1.getTarget().getGeometry().getCenterX())
                / (e2.getSource().getGeometry().getCenterY()
                    - e1.getTarget().getGeometry().getCenterY());
            final double xx = (((mxCell) n).getGeometry().getCenterY()
                - e1.getTarget().getGeometry().getCenterY()) * slope
                + e1.getTarget().getGeometry().getCenterX();
            ((mxCell) n).getGeometry().setX(2 * xx - ((mxCell) n).getGeometry().getWidth());
          }
        }
      }
    }
    // Move the virtual nodes between endpoints to straighten the lines if possible
    if (straighten) {
      final Object[] allEdges =
          ChengLayout.graph.getAllEdges(new Object[] {ChengLayout.graph.getDefaultParent()});
      for (final Object e : allEdges) {
        final mxCell a = (mxCell) ((mxCell) e).getSource();
        mxCell b;
        for (final mxCell ee = (mxCell) e;;) {
          b = (mxCell) ee.getTarget();
          break;
        }
        if (!this.free(a, b)) {
          continue;
        }
        final double slope = (b.getGeometry().getCenterX() - a.getGeometry().getCenterX())
            / (b.getGeometry().getCenterY() - a.getGeometry().getCenterY());
        for (final mxCell ee = (mxCell) e;;) {
          b = (mxCell) ee.getTarget();
          break;
        }
      }
    }
    // Now restore the invariant that nodes in each layer is ordered by x
    if (straighten) {
      for (int i = 0; i < ChengLayout.graph.layerlist.size(); i++) {
        this.sortLayer(i, new Comparator<mxCell>() {
          @Override
          public int compare(final mxCell o1, final mxCell o2) {
            if (o1.getGeometry().getCenterX() < o2.getGeometry().getCenterX()) {
              return -1;
            } else if (o1.getGeometry().getCenterX() > o2.getGeometry().getCenterX()) {
              return 1;
            }
            return 0;
          }
        });
        // Ensure that nodes are not bunched up together horizontally.
        final List<mxCell> layer = new ArrayList<mxCell>(this.layer(i));
        for (int j = layer.size() / 2; j >= 0 && j < layer.size() - 1; j++) {
          final mxCell a = layer.get(j), b = layer.get(j + 1);
          final double ax = a.getGeometry().getCenterX() + a.getGeometry().getWidth() / 2
              + a.getReserved(ChengLayout.graph);
          final double bx = b.getGeometry().getCenterX() - b.getGeometry().getWidth() / 2;
          if (bx <= ax || bx - ax < 5) {
            b.getGeometry()
                .setX(2 * ax + 10 + b.getGeometry().getWidth() - b.getGeometry().getWidth());
          }
        }
        for (int j = layer.size() / 2; j > 0 && j < layer.size(); j--) {
          final mxCell a = layer.get(j - 1), b = layer.get(j);
          final double ax = a.getGeometry().getCenterX() + a.getGeometry().getWidth() / 2
              + a.getReserved(ChengLayout.graph);
          final double bx = b.getGeometry().getCenterX() - b.getGeometry().getWidth() / 2;
          if (bx <= ax || bx - ax < 5) {
            a.getGeometry().setX(2 * bx - 10 - a.getGeometry().getWidth()
                - 2 * a.getReserved(ChengLayout.graph) - a.getGeometry().getWidth());
          }
        }
      }
    }
    // // Now layout the edges, initially as straight lines
    // final Object[] allEdges =
    // ChengLayout.graph.getAllEdges(new Object[] {ChengLayout.graph.getDefaultParent()});
    // for (final Object e : allEdges) {
    // e.resetPath();
    // }
    // // Now, scan layer-by-layer to find edges that intersect nodes improperly, and bend them
    // // accordingly
    // for (int layer = ChengLayout.graph.layerlist.size() - 1; layer > 0; layer--) {
    // final List<mxCell> top = this.layer(layer), bottom = this.layer(layer - 1);
    // checkUpperCollision(top);
    // checkLowerCollision(bottom);
    // checkUpperCollision(top);
    // }
    // // Now, for each edge, adjust its arrowhead and label.
    // final AvailableSpace sp = new AvailableSpace();
    // for (final mxCell n : nodes) {
    // if (n.shape() != null) {
    // sp.add(n.x() - n.getWidth() / 2, n.y() - n.getHeight() / 2, n.getWidth() + n.getReserved(),
    // n.getHeight());
    // }
    // }
    // for (final mxCell e : edges) {
    // e.layout_arrowHead();
    // e.repositionLabel(sp);
    // }
  }

  // Layout step #5: decide the order of the nodes within each layer.
  private void reorderPerLayer() {
    // This uses the original Barycenter heuristic
    final IdentityHashMap<mxCell, Object> map = new IdentityHashMap<mxCell, Object>();
    final double[] bc = new double[this.childVertices.length + 1];
    int i = 1;
    for (final mxCell n : this.layer(0)) {
      bc[Integer.valueOf(n.getAttribute("Position"))] = i;
      i++;
    }
    for (int layer = 0; layer < ChengLayout.graph.layerlist.size() - 1; layer++) {
      for (final mxCell n : this.layer(layer + 1)) {
        map.clear();
        int count = 0;
        double sum = 0;
        for (final Object e : ChengLayout.graph.getOutgoingEdges(n)) {
          final mxCell nn = (mxCell) ((mxCell) e).getTarget();
          if (map.put(nn, nn) == null) {
            count++;
            sum += bc[Integer.valueOf(nn.getAttribute("Position"))];
          }
        }
        bc[Integer.valueOf(n.getAttribute("Position"))] = count == 0 ? 0 : sum / count;
      }
      this.sortLayer(layer + 1, new Comparator<mxCell>() {
        @Override
        public int compare(final mxCell o1, final mxCell o2) {
          // If the two nodes have the same barycenter, we use their ordering that was established
          // during layout_assignOrder()
          if (o1 == o2) {
            return 0;
          }
          final int n = Double.compare(bc[Integer.valueOf(o1.getAttribute("Position"))],
              bc[Integer.valueOf(o2.getAttribute("Position"))]);
          if (n != 0) {
            return n;
          } else if (Integer.valueOf(o1.getAttribute("Position")) < Integer
              .valueOf(o2.getAttribute("Position"))) {
            return -1;
          } else {
            return 1;
          }
        }
      });
      int j = 1;
      for (final mxCell n : this.layer(layer + 1)) {
        bc[Integer.valueOf(n.getAttribute("Position"))] = j;
        j++;
      }
    }
  }

  private void runVerticalLayout() {
    final mxIGraphLayout layout = this.createLayout("verticalHierarchical", false);
    if (layout != null) {
      final mxGraph graph = ChengLayout.graphComponent.getGraph();
      Object cell = graph.getSelectionCell();

      if (cell == null || graph.getModel().getChildCount(cell) == 0) {
        cell = graph.getDefaultParent();
      }

      graph.getModel().beginUpdate();
      try {
        layout.execute(cell);
      } finally {
        final mxMorphing morph = new mxMorphing(ChengLayout.graphComponent, 20, 1.25, 1);

        morph.addListener(mxEvent.DONE, new mxIEventListener() {
          @Override
          public void invoke(final Object sender, final mxEventObject evt) {
            graph.getModel().endUpdate();
          }
        });
        morph.startAnimation();
      }
    }
  }

  public void setLayout(final VisualizationGraphComponent component,
      final VisualizationGraph graph) {
    ChengLayout.graphComponent = component;
    ChengLayout.graph = graph;
    // ChengLayout.cells = ChengLayout.graphComponent.getCells(new Rectangle(0, 0,
    // ChengLayout.graphComponent.getWidth(), ChengLayout.graphComponent.getHeight()));

    // Calculate each node's width and height
    this.setVerticesSize();

    this.runVerticalLayout();

    // this.assignOrders(); // #1 layout
    //
    // // this.backEdges(); // #2 layout
    //
    // final int layers = this.decideLayer(); // #3 layout
    //
    // this.dummyNodesIfNeeded(); // #4 layout
    //
    // this.reorderPerLayer(); // #5 layout
    //
    // // For each layer, this array stores the height of its tallest node
    // this.layerPH = new double[layers];
    //
    // // figure out the Y position of each layer, and also give each component an initial X
    // position
    // for (int layer = layers - 1; layer >= 0; layer--) {
    // double x = 5; // So that we're not touching the left-edge of the window
    // double h = 0;
    // for (final mxCell n : this.layer(layer)) {
    // final double nHeight = n.getGeometry().getHeight(), nWidth = n.getGeometry().getWidth();
    // // n.getGeometry().setX(x);
    // // n.getGeometry().setWidth(nWidth);
    // n.getGeometry().setX(2 * x + nWidth - n.getGeometry().getWidth());
    // if (h < nHeight) {
    // h = nHeight;
    // }
    // x = x + nWidth + n.getReserved(graph) + 20;
    // }
    // this.layerPH[layer] = h;
    // }
    //
    // // If there are more than one layer, then iteratively refine the X position of each component
    // 3
    // // times; 4 is a good number
    // if (layers > 1) {
    // // It's important to NOT DO THIS when layers<=1, because without edges the nodes will overlap
    // // each other into the center
    // for (int i = 0; i < 3; i++) {
    // for (int layer = 0; layer < layers; layer++) {
    // this.xAssignment(this.layer(layer));
    // }
    // }
    // }
    //
    // // Calculate each node's y; we start at y==5 so that we're not touching the top-edge of the
    // // window
    // double py = 5;
    // for (int layer = layers - 1; layer >= 0; layer--) {
    // final double ph = this.layerPH[layer];
    // for (final mxCell n : this.layer(layer)) {
    // n.getGeometry().setY(2 * py + ph - n.getGeometry().getHeight());
    // // n.getGeometry().setY(py);
    // // n.getGeometry().setHeight(ph);
    // }
    // py = py + ph + 60;
    // }
    //
    // this.relayout_edges(true);
    //
    // // Since we're doing layout for the first time, we need to explicitly set top and bottom,
    // since
    // // otherwise "recalcBound" will merely "extend top and bottom" as needed.
    // this.recalcBound(true);
    // graph.setMaximumGraphBounds(new mxRectangle(0, 0, this.totalWidth, this.totalHeight));
  }

  private void setVerticesSize() {
    this.childVertices = ChengLayout.graphComponent.getGraph()
        .getChildVertices(ChengLayout.graphComponent.getGraph().getDefaultParent());
    for (final Object object : this.childVertices) {
      ChengLayout.graphComponent.getGraph().updateCellSize(object);
    }
  }

  /** Sort the list of nodes in a given layer (0..#layer-1) using the given comparator. */
  void sortLayer(final int layer, final Comparator<mxCell> comparator) {
    Collections.sort(ChengLayout.graph.layerlist.get(layer), comparator);
  }

  // ============================================================================================================================//

  private void sortNodes(final Iterable<mxCell> newOrder) {
    // The nodes that are common to this.nodelist and newOrder are moved to the front of the list,
    // in the given order.
    // The nodes that are in this.nodelist but not in newOrder are moved to the back in an
    // unspecified order.
    // The nodes that are in newOrder but not in this.nodelist are ignored.
    int i = 0;
    final int n = this.childVertices.length;
    again: for (final mxCell x : newOrder) {
      for (int j = i; j < n; j++) {
        if (this.childVertices[j] == x) {
          if (i != j) {
            final mxCell tmp = (mxCell) this.childVertices[i];
            this.childVertices[i] = x;
            this.childVertices[j] = tmp;
          }
          i++;
          continue again;
        }
      }
    }
    for (int j = 0; j < this.childVertices.length; j++) {
      ((mxCell) this.childVertices[j]).setAttribute("Position", Integer.toString(j));
    }
  }

  // Layout step #6: decide the exact X position of each component.
  private void xAssignment(final List<mxCell> layer) {
    // This implementation uses the iterative approach described in the paper "Layout of Bayesian
    // Networks"
    // by Kim Marriott, Peter Moulder, Lucas Hope, and Charles Twardy
    final int n = this.childVertices.length;
    if (n == 0) {
      return;
    }
    final Block[] block = new Block[n + 1];
    block[0] = new Block(); // The sentinel block
    for (int i = 1; i <= n; i++) {
      Block b = new Block((mxCell) this.childVertices[i - 1], i);
      block[i] = b;
      while (block[b.first - 1].posn + block[b.first - 1].width > b.posn) {
        b = new Block(block[b.first - 1], b);
        block[b.last] = b;
        block[b.first] = b;
      }
    }
    int i = 1;
    while (true) {
      final Block b = block[i];
      // ((mxCell) this.childVertices[i - 1]).getGeometry().setX(b.posn);
      // ((mxCell) this.childVertices[i - 1]).getGeometry()
      // .setWidth(((mxCell) this.childVertices[b.first - 1]).getGeometry().getWidth()
      // + ((mxCell) this.childVertices[b.first - 1]).getReserved(ChengLayout.graph) + 30);
      final double tmp =
          b.posn + (((mxCell) this.childVertices[b.first - 1]).getGeometry().getWidth()
              + ((mxCell) this.childVertices[b.first - 1]).getReserved(ChengLayout.graph) + 30)
              / 2D;
      ((mxCell) this.childVertices[i - 1]).getGeometry()
          .setX(2 * tmp - ((mxCell) this.childVertices[i - 1]).getGeometry().getWidth());
      for (i = i + 1; i <= b.last; i++) {
        final mxCell v1 = (mxCell) this.childVertices[i - 1];
        final mxCell v2 = (mxCell) this.childVertices[i - 2];
        // final double xsep = (v1.getGeometry().getWidth() + v1.getReserved(ChengLayout.graph)
        // + v2.getGeometry().getWidth() + v2.getReserved(ChengLayout.graph)) / 2 + 30;
        // v1.setX((v2.getGeometry().getX() + v2.getGeometry().getWidth()) / 2 + xsep);
        final double xsep = (v1.getGeometry().getWidth() + v1.getReserved(ChengLayout.graph)
            + v2.getGeometry().getWidth() + v2.getReserved(ChengLayout.graph)) / 2 + 30;
        v1.getGeometry()
            .setX(2 * (v2.getGeometry().getCenterX() + xsep) - v1.getGeometry().getWidth());
      }
      i = b.last + 1;
      if (i > n) {
        break;
      }
    }
  }
}
