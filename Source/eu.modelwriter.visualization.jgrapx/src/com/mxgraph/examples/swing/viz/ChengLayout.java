package com.mxgraph.examples.swing.viz;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import javax.swing.JLabel;

import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.util.mxMorphing;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.view.mxGraph;

public class ChengLayout {
  private static ChengLayout layout;
  private static mxGraphComponent graphComponent;
  private static Object[] cells = null;
  private static mxGraph graph;

  public static ChengLayout getInstance() {
    if (ChengLayout.layout == null) {
      ChengLayout.layout = new ChengLayout();
    }
    return ChengLayout.layout;
  }

  private Object[] childVertices;

  TreeMap<Double, ArrayList<mxCell>> xVertices = new TreeMap<Double, ArrayList<mxCell>>();
  TreeMap<Double, ArrayList<mxCell>> yVertices = new TreeMap<Double, ArrayList<mxCell>>();

  private ChengLayout() {}

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

  private void assignOrders() {
    // Layout step #1: assign a total order on the nodes.
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

  public void setLayout(final VisualizationGraphComponent component) {
    ChengLayout.graphComponent = component;
    ChengLayout.graph = ChengLayout.graphComponent.getGraph();
    ChengLayout.cells = ChengLayout.graphComponent.getCells(new Rectangle(0, 0,
        ChengLayout.graphComponent.getWidth(), ChengLayout.graphComponent.getHeight()));

    // Calculate each node's width and height
    this.setVerticesSize();

    this.runVerticalLayout();

    this.assignOrders();

    this.init();
  }

  private void setVerticesSize() {
    this.childVertices = ChengLayout.graphComponent.getGraph()
        .getChildVertices(ChengLayout.graphComponent.getGraph().getDefaultParent());
    for (final Object object : this.childVertices) {
      ChengLayout.graphComponent.getGraph().updateCellSize(object);
    }
  }

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
}
