package eu.modelwriter.visualization.editor.util;

import java.util.ArrayList;
import java.util.Collections;
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
  private static EdgeUtil edgeUtilInstance;
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

  private Object[] nodes;
  private Object[] edges;

  private mxHierarchicalLayout verticalLayout;
  private ArrayList<ArrayList<mxCell>> layerlist;

  private int[] layerPH;

  /**
   * Creates a layout instance for the given identifier.
   */
  mxIGraphLayout layout = null;

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
        if (entry2.getValue() instanceof mxCell) {
          final mxCell cell = entry2.getValue();
          cell.setAttribute(NodeUtil.LAYER, String.valueOf(i));
          cell.setAttribute(NodeUtil.ORDER, String.valueOf(j));
          layerCells.add(cell);
          j++;
        } else {
          layerCells.add(entry2.getValue());
        }
      }
      listOfLayers.add(layerCells);
      i--;
    }
    Collections.reverse(listOfLayers);
    return listOfLayers;
  }

  private mxIGraphLayout createLayout(final String ident, final boolean animate) {
    if (ident != null) {
      if (ident.equals("verticalHierarchical")) {
        this.layout = new mxHierarchicalLayout(GraphUtil.graph);
      } else if (ident.equals("horizontalHierarchical")) {
        this.layout = new mxHierarchicalLayout(GraphUtil.graph, JLabel.WEST);
      }
    }
    return this.layout;
  }

  public Object[] getEdges() {
    return this.edges;
  }

  public ArrayList<ArrayList<mxCell>> getLayerlist() {
    return this.layerlist;
  }

  public Object[] getNodes() {
    return this.nodes;
  }

  public ArrayList<mxCell> layer(final int layerOfCell) {
    return this.getLayerlist().get(layerOfCell);
  }

  public int[] layerPH() {
    this.layerPH = new int[this.layers()];

    // figure out the Y position of each layer, and also give each component an initial X position
    for (int layer = this.layers() - 1; layer >= 0; layer--) {
      int h = 0;
      for (final Object layerObject : this.layer(layer)) {
        if (layerObject instanceof mxCell) {
          final mxCell cell = (mxCell) layerObject;
          final int nHeight = (int) cell.getGeometry().getHeight();
          if (h < nHeight) {
            h = nHeight;
          }
        }
      }
      this.layerPH[layer] = h;
    }
    return this.layerPH;
  }

  public int layers() {
    return this.layerlist.size();
  }

  /** (Re-)perform the layout. */
  public void layout() {
    this.nodes =
        GraphUtil.graph.getChildVertices(GraphUtil.graphComponent.getGraph().getDefaultParent());
    this.edges = GraphUtil.graph.getAllEdges(new Object[] {GraphUtil.graph.getDefaultParent()});
    GraphUtil.nodeUtilInstance = NodeUtil.getInstance(GraphUtil.graph, GraphUtil.graphComponent);
    GraphUtil.edgeUtilInstance = EdgeUtil.getInstance(GraphUtil.graph, GraphUtil.graphComponent);

    // The rest of the code below assumes at least one node, so we return right away if
    // nodes.size()==0
    if (this.nodes.length == 0) {
      return;
    }

    // Calculate each node's width and height
    this.setVerticesSize();

    this.verticalLayout = this.runVerticalLayout();
    this.layerlist = this.assignLayers();

    this.layerPH();
  }

  private TreeMap<Double, TreeMap<Double, mxCell>> mapLayers() {
    final TreeMap<Double, TreeMap<Double, mxCell>> yVertices = new TreeMap<>();
    for (final Object nodeObject : this.nodes) {
      final mxCell node = (mxCell) nodeObject;
      final double yOfLayer = node.getGeometry().getCenterY();
      TreeMap<Double, mxCell> xVertices = yVertices.get(yOfLayer);
      if (xVertices == null) {
        xVertices = new TreeMap<Double, mxCell>();
        yVertices.put(yOfLayer, xVertices);
      }
      xVertices.put(node.getGeometry().getCenterX(), node);
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
    for (final Object object : this.nodes) {
      final mxCell vertex = (mxCell) object;
      GraphUtil.graphComponent.getGraph().updateCellSize(object);
      GraphUtil.nodeUtilInstance.calcBounds(vertex);
    }
  }

  /** Swap the given two nodes in the giver layer. */
  public void swapNodes(final int layer, final int node1, final int node2) {
    final List<mxCell> list = this.layer(layer);
    final mxCell n1 = list.get(node1), n2 = list.get(node2);
    list.set(node1, n2);
    list.set(node2, n1);
  }

  public int yOfLayer(final int layer) {
    return GraphUtil.nodeUtilInstance.y(this.layer(layer).get(0));
  }
}
