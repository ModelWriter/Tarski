package eu.modelwriter.visualization.editor.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
import com.mxgraph.util.mxPoint;

import eu.modelwriter.visualization.editor.StaticEditorManager;
import eu.modelwriter.visualization.model.OurObject;
import eu.modelwriter.visualization.model.Pair;

public class GraphUtil {
  /**
   * It provides Singleton Pattern.
   */
  private static GraphUtil graphUtil;

  /**
   * {@link NodeUtil} instance.
   */
  private static NodeUtil nodeUtilInstance;

  /**
   * {@link EdgeUtil} instance.
   */
  private static EdgeUtil edgeUtilInstance;

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

  public static double width;

  public static double height;

  /**
   * Attribute Constants for Vertex and Edge.
   */
  public static final String LAYER = "layer";
  public static final String ORDER = "order";
  public static final String SIDE = "side";
  public static final String UPDOWN = "updown";
  public static final String NAME = "name";

  /**
   * This determines the minimum amount of padding added above, left, right, and below the text
   * label.
   */
  public static final int labelPadding = 5;

  public static GraphUtil getInstance() {
    if (GraphUtil.graphUtil == null) {
      GraphUtil.graphUtil = new GraphUtil();
    }
    return GraphUtil.graphUtil;
  }

  protected double ourEmptyValue = 200.0;

  private ArrayList<ArrayList<mxCell>> layerlist;

  /**
   * Height of layers.
   */
  private int[] layerPH;

  /**
   * Minimum height of layers.
   */
  private int[] layerMinY;

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
          ((OurObject) cell.getValue()).setAttribute(GraphUtil.LAYER, String.valueOf(i));
          ((OurObject) cell.getValue()).setAttribute(GraphUtil.ORDER, String.valueOf(j));
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
        this.layout = new mxHierarchicalLayout(StaticEditorManager.graph);
      } else if (ident.equals("horizontalHierarchical")) {
        this.layout = new mxHierarchicalLayout(StaticEditorManager.graph, JLabel.WEST);
      }
    }
    return this.layout;
  }

  public HashSet<Object> getEdges() {
    final Object[] edges = StaticEditorManager.graph
        .getAllEdges(new Object[] {StaticEditorManager.graph.getDefaultParent()});
    return new HashSet<>(Arrays.asList(edges));
  }

  public ArrayList<ArrayList<mxCell>> getLayerlist() {
    return this.layerlist;
  }

  public HashSet<Object> getNodes() {
    final Object[] nodes = StaticEditorManager.graph
        .getChildVertices(StaticEditorManager.graphComponent.getGraph().getDefaultParent());
    return new HashSet<>(Arrays.asList(nodes));
  }

  /**
   *
   * @param layerOfNode
   * @return all nodes in the given layer number.
   */
  public ArrayList<mxCell> layer(final int layerOfNode) {
    return this.getLayerlist().get(layerOfNode);
  }

  public int[] layerPH() {
    this.layerPH = new int[this.layers()];

    // figure out the Y position of each layer, and also give each component
    // an initial X position
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
    GraphUtil.nodeUtilInstance = NodeUtil.getInstance();
    GraphUtil.edgeUtilInstance = EdgeUtil.getInstance();

    // The rest of the code below assumes at least one node, so we return
    // right away if
    // nodes.size()==0
    if (this.getNodes().size() == 0) {
      return;
    }

    // Calculate each node's width and height
    this.setVerticesSize();

    this.runVerticalLayout();
    this.layerlist = this.assignLayers();

    this.layerPH();
    StaticEditorManager.graphComponent.refresh();
  }

  private TreeMap<Double, TreeMap<Double, mxCell>> mapLayers() {
    final TreeMap<Double, TreeMap<Double, mxCell>> yVertices = new TreeMap<>();
    for (final Object nodeObject : this.getNodes()) {
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

  public void moveControlPointsBy(final int layer, final int dy) {
    final int y = this.yOfLayer(layer);
    final HashSet<Object> edges = this.getEdges();
    for (final Object object : edges) {
      final mxCell edge = (mxCell) object;
      final List<mxPoint> points = edge.getGeometry().getPoints();
      if (points != null) {
        for (final mxPoint mxPoint : points) {
          if (mxPoint.getY() == y) {
            mxPoint.setY(mxPoint.getY() + dy);
            break;
          }
        }
      }
    }
  }

  public void re_layout() {
    for (int i = this.layers() - 1; i >= 1; i--) {
      final int maxYThis =
          GraphUtil.nodeUtilInstance.centerY(this.layer(i).get(0)) + this.layerPH()[i] / 2;
      final int minYDown =
          GraphUtil.nodeUtilInstance.centerY(this.layer(i - 1).get(0)) - this.layerPH()[i - 1] / 2;
      if (maxYThis < this.runLayerMinY()[i]) {
        GraphUtil.nodeUtilInstance.setY(i, this.runLayerMinY()[i]);
      } else if (maxYThis + GraphUtil.yJump / 6 > minYDown) {
        GraphUtil.nodeUtilInstance.setY(i - 1, maxYThis + GraphUtil.yJump / 6);
      }

      for (final Map<Integer, ArrayList<Pair>> value : mxHierarchicalLayout.hierarchyLayerControl) {
        final ArrayList<Pair> list = value.get(i);
        if (list != null) {
          for (final Pair pair : list) {
            GraphUtil.edgeUtilInstance.getControlPoint(pair.getEdge(), pair.getOrder())
                .setY(GraphUtil.nodeUtilInstance.centerY(this.layer(i).get(0)));;
          }
        }
      }

      // final ArrayList<Pair> list = mxCoordinateAssignment.layerControlmap.get(i);
      // if (list != null) {
      // for (final Pair pair : list) {
      // GraphUtil.edgeUtilInstance.getControlPoint(pair.getEdge(), pair.getOrder())
      // .setY(GraphUtil.nodeUtilInstance.centerY(this.layer(i).get(0)));;
      // }
      // }
    }
  }

  public int[] runLayerMinY() {
    this.layerMinY = new int[this.layers()];
    int temp = 0;
    for (int layer = this.layers() - 1; layer >= 0; layer--) {
      this.layerMinY[layer] = temp;
      temp += this.layerPH[layer] + GraphUtil.yJump / 6;
    }
    return this.layerMinY;
  }

  private mxHierarchicalLayout runVerticalLayout() {
    final mxIGraphLayout layout = this.createLayout("verticalHierarchical", false);
    if (layout != null) {
      Object cell = StaticEditorManager.graph.getSelectionCell();
      if (cell == null || StaticEditorManager.graph.getModel().getChildCount(cell) == 0) {
        cell = StaticEditorManager.graph.getDefaultParent();
      }
      StaticEditorManager.graph.getModel().beginUpdate();
      try {
        layout.execute(cell);
        GraphUtil.width = ((mxHierarchicalLayout) layout).getMaxX() + this.ourEmptyValue;
        GraphUtil.height = ((mxHierarchicalLayout) layout).getMaxY() + this.ourEmptyValue;
      } finally {
        final mxMorphing morph = new mxMorphing(StaticEditorManager.graphComponent, 20, 1.25, 1);

        morph.addListener(mxEvent.DONE, new mxIEventListener() {
          @Override
          public void invoke(final Object sender, final mxEventObject evt) {
            StaticEditorManager.graph.getModel().endUpdate();
          }
        });
        morph.startAnimation();
      }
    }
    return (mxHierarchicalLayout) layout;
  }

  private void setVerticesSize() {
    for (final Object object : this.getNodes()) {
      final mxCell vertex = (mxCell) object;
      StaticEditorManager.graphComponent.getGraph().updateCellSize(object);
      GraphUtil.nodeUtilInstance.calcBounds(vertex);
    }
  }

  /** Swap the given two nodes in the given layer. */
  public void swapNodes(final int layer, final int node1, final int node2) {
    final List<mxCell> list = this.layer(layer);
    final mxCell n1 = list.get(node1), n2 = list.get(node2);
    list.set(node1, n2);
    list.set(node2, n1);
  }

  public int yOfLayer(final int layer) {
    return GraphUtil.nodeUtilInstance.centerY(this.layer(layer).get(0));
  }
}
