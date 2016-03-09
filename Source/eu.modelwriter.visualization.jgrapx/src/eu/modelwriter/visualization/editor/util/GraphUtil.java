package eu.modelwriter.visualization.editor.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.JLabel;

import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxCell;
import com.mxgraph.swing.util.mxMorphing;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;

import eu.modelwriter.visualization.editor.Graph;
import eu.modelwriter.visualization.editor.GraphComponent;

public class GraphUtil {
  private static GraphUtil graphUtil;
  private static NodeUtil nodeUtilInstance;
  private static Graph graph;
  private static GraphComponent graphComponent;

  /** Minimum horizontal distance between adjacent nodes. */
  public static final int xJump = 60;
  /** Minimum vertical distance between adjacent layers. */
  public static final int yJump = 240;
  /** The horizontal distance between the first self-loop and the node itself. */
  public static final int selfLoopA = 40;
  /** The horizontal padding to put on the left side of a self-loop's edge label. */
  public static final int selfLoopGL = 2;
  /** The horizontal padding to put on the right side of a self-loop's edge label. */
  public static final int selfLoopGR = 20;

  public static GraphUtil getInstance(final Graph graph, final GraphComponent graphComponent) {
    GraphUtil.graph = graph;
    GraphUtil.graphComponent = graphComponent;
    if (GraphUtil.graphUtil == null) {
      GraphUtil.graphUtil = new GraphUtil();
    }
    return GraphUtil.graphUtil;
  }

  private Object[] vertices;
  private Object[] edges;
  private mxHierarchicalLayout verticalLayout;
  private ArrayList<ArrayList<mxCell>> layerlist;
  // ================================ adjustable options
  // ========================================================================//
  private int[] layerPH;

  private GraphUtil() {}

  private ArrayList<ArrayList<mxCell>> assignLayers() {
    final TreeMap<Double, TreeMap<Double, mxCell>> layers = this.mapLayers();
    final ArrayList<ArrayList<mxCell>> listOfLayers = new ArrayList<>();

    int i = layers.entrySet().size() - 1;

    for (final Entry<Double, TreeMap<Double, mxCell>> entry : layers.entrySet()) {
      final TreeMap<Double, mxCell> layer = entry.getValue();
      final ArrayList<mxCell> layerCells = new ArrayList<>();
      int j = 0;
      for (final Entry<Double, mxCell> entry2 : layer.entrySet()) {
        final mxCell cell = entry2.getValue();
        cell.setAttribute("layer", String.valueOf(i));
        cell.setAttribute("order", String.valueOf(j));
        layerCells.add(cell);
        j++;
      }
      listOfLayers.add(layerCells);
      i--;
    }
    Collections.reverse(listOfLayers);
    return listOfLayers;
  }

  private void assignOrders() {
    // Layout step #1: assign a total order on the nodes.
    final int num = this.vertices.length;
    final List<List<mxCell>> bins = new ArrayList<List<mxCell>>(2 * num + 1);
    for (int i = 0; i < 2 * num + 1; i++) {
      bins.add(new LinkedList<mxCell>());
    }
    final ArrayList<LinkedList<mxCell>> grIN = new ArrayList<LinkedList<mxCell>>(num);
    final ArrayList<LinkedList<mxCell>> grOUT = new ArrayList<LinkedList<mxCell>>(num);
    final int[] grBIN = new int[num];
    for (final Object node : this.vertices) {
      final int ni = Integer.valueOf(((mxCell) node).getAttribute("Position"));
      final LinkedList<mxCell> in = new LinkedList<mxCell>(), out = new LinkedList<mxCell>();
      for (final Object e : GraphUtil.graph.getIncomingEdges(node)) {
        final mxCell a = (mxCell) ((mxCell) e).getSource();
        if (!in.contains(a)) {
          in.add(a);
        }
      }
      for (final Object e : GraphUtil.graph.getOutgoingEdges(node)) {
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
      for (final mxCell n : OurUtil.fastJoin(grIN.get(Integer.valueOf(x.getAttribute("Position"))),
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
    this.sortNodes(OurUtil.fastJoin(s1, s2));
  }

  /**
   * Creates a layout instance for the given identifier.
   */
  private mxIGraphLayout createLayout(final String ident, final boolean animate) {
    mxIGraphLayout layout = null;

    if (ident != null) {
      if (ident.equals("verticalHierarchical")) {
        layout = new mxHierarchicalLayout(GraphUtil.graph);
      } else if (ident.equals("horizontalHierarchical")) {
        layout = new mxHierarchicalLayout(GraphUtil.graph, JLabel.WEST);
      }
    }

    return layout;
  }

  private void dummyNodesIfNeeded() {
    // for (int i = 0; i < this.edges.length; i++) {
    // final mxCell e = (mxCell) this.edges[i];
    // mxCell a = (mxCell) e.getSource();
    // final mxCell b = (mxCell) e.getTarget();
    //
    // GraphUtil.graph.setCellStyles(mxConstants.STYLE_MOVABLE, "0", new Object[] {e});
    // GraphUtil.graph.setCellStyles(mxConstants.STYLE_BENDABLE, "0", new Object[] {e});
    // if (e.getGeometry().getPoints() != null) {
    // e.getGeometry().getPoints().clear();
    // }
    // int layerA = GraphUtil.nodeUtilInstance.layer(a);
    // final int layerB = GraphUtil.nodeUtilInstance.layer(b);
    // if (layerA == -1 || layerB == -1) {
    // continue;
    // }
    // int dist = layerA - layerB;
    // while (dist > 1) {
    // final mxCell tmp = a;
    // a = (mxCell) GraphUtil.graph.insertVertex(GraphUtil.graph.getDefaultParent(), null, null);
    // a.getGeometry().setWidth(1);
    // a.getGeometry().setHeight(1);
    //
    // e.setSource(a);
    // e.setTarget(b);
    //
    // final mxCell newE = (mxCell) GraphUtil.graph
    // .insertEdge(GraphUtil.graph.getDefaultParent(), null, e.getValue(), tmp, a);
    //
    // newE.setSource(tmp);
    // newE.setTarget(a);
    //
    // layerA--;
    // dist = layerA - layerB;
    // }
    // }
  }

  public ArrayList<ArrayList<mxCell>> getLayerlist() {
    return this.layerlist;
  }

  public List<mxCell> layer(final int layerOfCell) {
    return this.getLayerlist().get(layerOfCell);
  }

  public int[] layerPH() {
    this.layerPH = new int[this.layerlist.size()];

    // figure out the Y position of each layer, and also give each component an initial X position
    for (int layer = this.layerlist.size() - 1; layer >= 0; layer--) {
      // int x = 5;
      int h = 0;
      for (final mxCell cell : this.layer(layer)) {
        final int nHeight = (int) cell.getGeometry().getHeight();
        // final int nWidth = (int) cell.getGeometry().getWidth();
        // cell.getGeometry().setX(x + nWidth / 2);
        if (h < nHeight) {
          h = nHeight;
        }
        // x = x + nWidth
        // + nodeUtilInstance.reserved(cell) + 20;
      }
      this.layerPH[layer] = h;
    }
    return this.layerPH;
  }

  /** (Re-)perform the layout. */
  public void layout() {
    this.vertices =
        GraphUtil.graph.getChildVertices(GraphUtil.graphComponent.getGraph().getDefaultParent());
    this.edges = GraphUtil.graph.getAllEdges(new Object[] {GraphUtil.graph.getDefaultParent()});
    GraphUtil.nodeUtilInstance = NodeUtil.getInstance(GraphUtil.graph, GraphUtil.graphComponent);

    // The rest of the code below assumes at least one node, so we return right away if
    // nodes.size()==0
    if (this.vertices.length == 0) {
      return;
    }

    // Calculate each node's width and height
    this.setVerticesSize();
    for (final Object object : this.vertices) {
      final mxCell vertex = (mxCell) object;
      GraphUtil.nodeUtilInstance.calcBounds(vertex);
    }

    this.verticalLayout = this.runVerticalLayout();
    this.layerlist = this.assignLayers();
    this.dummyNodesIfNeeded();

    // Layout the nodes
    // this.assignOrders();

    this.layerPH();

  }

  private TreeMap<Double, TreeMap<Double, mxCell>> mapLayers() {
    final TreeMap<Double, TreeMap<Double, mxCell>> yVertices = new TreeMap<>();
    for (final Object object : this.vertices) {
      final mxCell cell = (mxCell) object;
      if (cell.isVertex()) {
        TreeMap<Double, mxCell> xVertices = yVertices.get(cell.getGeometry().getCenterY());
        if (xVertices == null) {
          xVertices = new TreeMap<Double, mxCell>();
          xVertices.put(cell.getGeometry().getCenterX(), cell);
          yVertices.put(cell.getGeometry().getCenterY(), xVertices);
        } else {
          xVertices.put(cell.getGeometry().getCenterX(), cell);
        }
      }
    }
    return yVertices;
  }

  private mxHierarchicalLayout runVerticalLayout() {
    final mxIGraphLayout layout = this.createLayout("verticalHierarchical", false);
    if (layout != null) {
      Object cell = GraphUtil.graph.getSelectionCell();

      if (cell == null || GraphUtil.graph.getModel().getChildCount(cell) == 0) {
        cell = GraphUtil.graph.getDefaultParent();
      }

      GraphUtil.graph.getModel().beginUpdate();
      try {
        layout.execute(cell);
      } finally {
        final mxMorphing morph = new mxMorphing(GraphUtil.graphComponent, 20, 1.25, 1);

        morph.addListener(mxEvent.DONE, new mxIEventListener() {
          @Override
          public void invoke(final Object sender, final mxEventObject evt) {
            GraphUtil.graph.getModel().endUpdate();
          }
        });
        morph.startAnimation();
      }
    }
    return (mxHierarchicalLayout) layout;
  }

  private void setVerticesSize() {
    for (final Object object : this.vertices) {
      GraphUtil.graphComponent.getGraph().updateCellSize(object);
    }
  }

  private void sortNodes(final Iterable<mxCell> newOrder) {
    // The nodes that are common to this.nodelist and newOrder are moved to the front of the list,
    // in the given order.
    // The nodes that are in this.nodelist but not in newOrder are moved to the back in an
    // unspecified order.
    // The nodes that are in newOrder but not in this.nodelist are ignored.
    int i = 0;
    final int n = this.vertices.length;
    again: for (final mxCell x : newOrder) {
      for (int j = i; j < n; j++) {
        if (this.vertices[j] == x) {
          if (i != j) {
            final mxCell tmp = (mxCell) this.vertices[i];
            this.vertices[i] = x;
            this.vertices[j] = tmp;
          }
          i++;
          continue again;
        }
      }
    }
    for (int j = 0; j < this.vertices.length; j++) {
      ((mxCell) this.vertices[j]).setAttribute("Position", Integer.toString(j));
    }
  }

  /** Swap the given two nodes in the giver layer. */
  public void swapNodes(final int layer, final int node1, final int node2) {
    final List<mxCell> list = this.layer(layer);
    final mxCell n1 = list.get(node1), n2 = list.get(node2);
    list.set(node1, n2);
    list.set(node2, n1);
  }
}
