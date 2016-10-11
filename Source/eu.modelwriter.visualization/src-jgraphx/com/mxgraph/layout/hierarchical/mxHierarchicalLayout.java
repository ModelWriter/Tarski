/*
 * Copyright (c) 2005-2012, JGraph Ltd
 */
package com.mxgraph.layout.hierarchical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingConstants;

import com.mxgraph.layout.mxGraphLayout;
import com.mxgraph.layout.hierarchical.model.mxGraphHierarchyModel;
import com.mxgraph.layout.hierarchical.stage.mxCoordinateAssignment;
import com.mxgraph.layout.hierarchical.stage.mxHierarchicalLayoutStage;
import com.mxgraph.layout.hierarchical.stage.mxMedianHybridCrossingReduction;
import com.mxgraph.layout.hierarchical.stage.mxMinimumCycleRemover;
import com.mxgraph.model.mxGraphModel;
import com.mxgraph.model.mxIGraphModel;
import com.mxgraph.util.Pair;
import com.mxgraph.view.mxCellState;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxGraphView;

/**
 * The top level compound layout of the hierarchical layout. The individual elements of the layout
 * are called in sequence.
 */
public class mxHierarchicalLayout extends mxGraphLayout/*
 * , JGraphLayout.Stoppable
 */
{
  /**
   * The layout progress bar
   */
  // protected JGraphLayoutProgress progress = new JGraphLayoutProgress();
  /** The logger for this class */
  private static Logger logger =
      Logger.getLogger("com.jgraph.layout.hierarchical.JGraphHierarchicalLayout");

  public static List<Map<Integer, ArrayList<Pair>>> hierarchyLayerControl = new ArrayList<>();

  /** The root nodes of the layout */
  protected List<Object> roots = null;

  protected double maxX;

  protected double maxY;

  /**
   * Specifies if the parent should be resized after the layout so that it contains all the child
   * cells. Default is false. @See parentBorder.
   */
  protected boolean resizeParent = true;

  /**
   * Specifies if the parnent should be moved if resizeParent is enabled. Default is false. @See
   * resizeParent.
   */
  protected boolean moveParent = false;

  /**
   * The border to be added around the children if the parent is to be resized using resizeParent.
   * Default is 0. @See resizeParent.
   */
  protected int parentBorder = 0;

  /**
   * The spacing buffer added between cells on the same layer
   */
  protected double intraCellSpacing = 30.0;

  /**
   * The spacing buffer added between cell on adjacent layers
   */
  protected double interRankCellSpacing = 50.0;

  /**
   * The spacing buffer between unconnected hierarchies
   */
  protected double interHierarchySpacing = 60.0;

  /**
   * The distance between each parallel edge on each ranks for long edges
   */
  protected double parallelEdgeSpacing = 10.0;

  /**
   * The position of the root node(s) relative to the laid out graph in. Default is
   * <code>SwingConstants.NORTH</code>, i.e. top-down.
   */
  protected int orientation = SwingConstants.NORTH;

  /**
   * Specifies if the STYLE_NOEDGESTYLE flag should be set on edges that are modified by the result.
   * Default is true.
   */
  protected boolean disableEdgeStyle = true;

  /**
   * Whether or not to perform local optimisations and iterate multiple times through the algorithm
   */
  protected boolean fineTuning = true;

  /**
   * Whether or not to promote edges that terminate on vertices with different but common ancestry
   * to appear connected to the highest siblings in the ancestry chains
   */
  protected boolean promoteEdges = true;

  /**
   * Whether or not to navigate edges whose terminal vertices have different parents but are in the
   * same ancestry chain
   */
  protected boolean traverseAncestors = true;

  /**
   * The internal model formed of the layout
   */
  protected mxGraphHierarchyModel model = null;

  protected double ourConstantValue = 100.0;

  /**
   * Constructs a hierarchical layout
   *
   * @param graph the graph to lay out
   *
   */
  public mxHierarchicalLayout(final mxGraph graph) {
    this(graph, SwingConstants.NORTH);
  }

  /**
   * Constructs a hierarchical layout
   *
   * @param graph the graph to lay out
   * @param orientation <code>SwingConstants.NORTH, SwingConstants.EAST, SwingConstants.SOUTH</code>
   *        or <code> SwingConstants.WEST</code>
   *
   */
  public mxHierarchicalLayout(final mxGraph graph, final int orientation) {
    super(graph);
    this.orientation = orientation;
  }

  /**
   * Executes the crossing stage using mxMedianHybridCrossingReduction.
   */
  public void crossingStage(final Object parent) {
    final mxHierarchicalLayoutStage crossingStage = new mxMedianHybridCrossingReduction(this);
    crossingStage.execute(parent);
  }

  /**
   * Executes the cycle stage. This implementation uses the mxMinimumCycleRemover.
   */
  public void cycleStage(final Object parent) {
    final mxHierarchicalLayoutStage cycleStage = new mxMinimumCycleRemover(this);
    cycleStage.execute(parent);
  }

  /**
   * Executes the layout for the children of the specified parent.
   *
   * @param parent Parent cell that contains the children to be laid out.
   */
  @Override
  public void execute(final Object parent) {
    this.execute(parent, null);
  }

  /**
   * Executes the layout for the children of the specified parent.
   *
   * @param parent Parent cell that contains the children to be laid out.
   * @param roots the starting roots of the layout
   */
  public void execute(final Object parent, final List<Object> roots) {
    super.execute(parent);
    final mxIGraphModel model = graph.getModel();

    // If the roots are set and the parent is set, only
    // use the roots that are some dependent of the that
    // parent.
    // If just the root are set, use them as-is
    // If just the parent is set use it's immediate
    // children as the initial set

    if (roots == null && parent == null) {
      // TODO indicate the problem
      return;
    }

    if (roots != null && parent != null) {
      for (final Object root : roots) {
        if (!model.isAncestor(parent, root)) {
          roots.remove(root);
        }
      }
    }

    this.roots = roots;

    model.beginUpdate();
    try {
      run(parent);

      if (isResizeParent() && !graph.isCellCollapsed(parent)) {
        graph.updateGroupBounds(new Object[] {parent}, getParentBorder(),
            isMoveParent());
      }
    } finally {
      model.endUpdate();
    }
  }

  /**
   * Creates a set of descendant cells
   *
   * @param cell The cell whose descendants are to be calculated
   * @return the descendants of the cell (not the cell)
   */
  public Set<Object> filterDescendants(final Object cell) {
    final mxIGraphModel model = graph.getModel();
    final Set<Object> result = new LinkedHashSet<Object>();

    if (model.isVertex(cell) && cell != parent && graph.isCellVisible(cell)) {
      result.add(cell);
    }

    if (traverseAncestors || cell == parent && graph.isCellVisible(cell)) {
      final int childCount = model.getChildCount(cell);

      for (int i = 0; i < childCount; i++) {
        final Object child = model.getChildAt(cell, i);
        result.addAll(filterDescendants(child));
      }
    }

    return result;
  }

  /**
   * Returns all visible children in the given parent which do not have incoming edges. If the
   * result is empty then the children with the maximum difference between incoming and outgoing
   * edges are returned. This takes into account edges that are being promoted to the given root due
   * to invisible children or collapsed cells.
   *
   * @param parent Cell whose children should be checked.
   * @return List of tree roots in parent.
   */
  public List<Object> findRoots(final Object parent, final Set<Object> vertices) {
    final List<Object> roots = new ArrayList<Object>();

    Object best = null;
    int maxDiff = -100000;
    final mxIGraphModel model = graph.getModel();

    for (final Object vertex : vertices) {
      if (model.isVertex(vertex) && graph.isCellVisible(vertex)) {
        final Object[] conns = getEdges(vertex);
        int fanOut = 0;
        int fanIn = 0;

        for (int k = 0; k < conns.length; k++) {
          final Object src = graph.getView().getVisibleTerminal(conns[k], true);

          if (src == vertex) {
            fanOut++;
          } else {
            fanIn++;
          }
        }

        if (fanIn == 0 && fanOut > 0) {
          roots.add(vertex);
        }

        final int diff = fanOut - fanIn;

        if (diff > maxDiff) {
          maxDiff = diff;
          best = vertex;
        }
      }
    }

    if (roots.isEmpty() && best != null) {
      roots.add(best);
    }

    return roots;
  }

  /**
   *
   * @param cell
   * @return
   */
  public Object[] getEdges(final Object cell) {
    final mxIGraphModel model = graph.getModel();
    final boolean isCollapsed = graph.isCellCollapsed(cell);
    final List<Object> edges = new ArrayList<Object>();
    final int childCount = model.getChildCount(cell);

    for (int i = 0; i < childCount; i++) {
      final Object child = model.getChildAt(cell, i);

      if (isCollapsed || !graph.isCellVisible(child)) {
        edges.addAll(Arrays.asList(mxGraphModel.getEdges(model, child, true, true, false)));
      }
    }

    edges.addAll(Arrays.asList(mxGraphModel.getEdges(model, cell, true, true, false)));
    final List<Object> result = new ArrayList<Object>(edges.size());
    final Iterator<Object> it = edges.iterator();

    while (it.hasNext()) {
      final Object edge = it.next();
      final mxCellState state = graph.getView().getState(edge);
      final Object source = state != null ? state.getVisibleTerminal(true)
          : graph.getView().getVisibleTerminal(edge, true);
      final Object target = state != null ? state.getVisibleTerminal(false)
          : graph.getView().getVisibleTerminal(edge, false);

      if (source != target && (target == cell
          && (parent == null
          || graph.isValidAncestor(source, parent, traverseAncestors))
          || source == cell && (parent == null
          || graph.isValidAncestor(target, parent, traverseAncestors)))) {
        result.add(edge);
      }
    }

    return result.toArray();
  }

  /**
   * @return Returns the interHierarchySpacing.
   */
  public double getInterHierarchySpacing() {
    return interHierarchySpacing;
  }

  /**
   * @return Returns the interRankCellSpacing.
   */
  public double getInterRankCellSpacing() {
    return interRankCellSpacing;
  }

  /**
   * @return Returns the intraCellSpacing.
   */
  public double getIntraCellSpacing() {
    return intraCellSpacing;
  }

  public double getMaxX() {
    return maxX + ourConstantValue;
  }

  public double getMaxY() {
    return maxY + ourConstantValue;
  }

  /**
   * Returns the model for this layout algorithm.
   */
  public mxGraphHierarchyModel getModel() {
    return model;
  }

  /**
   * @return Returns the orientation.
   */
  public int getOrientation() {
    return orientation;
  }

  public double getParallelEdgeSpacing() {
    return parallelEdgeSpacing;
  }

  /**
   * Returns parentBorder.
   */
  public int getParentBorder() {
    return parentBorder;
  }

  /**
   *
   */
  public boolean isDisableEdgeStyle() {
    return disableEdgeStyle;
  }

  /**
   * @return Returns the fineTuning.
   */
  public boolean isFineTuning() {
    return fineTuning;
  }

  /**
   * Returns the moveParent flag.
   */
  public boolean isMoveParent() {
    return moveParent;
  }

  /**
   * Returns the resizeParent flag.
   */
  public boolean isResizeParent() {
    return resizeParent;
  }

  /**
   * Implements first stage of a Sugiyama layout.
   */
  public void layeringStage() {
    model.initialRank();
    model.fixRanks();
  }

  /**
   * Executes the placement stage using mxCoordinateAssignment.
   */
  public double placementStage(final double initialX, final Object parent) {
    final mxCoordinateAssignment placementStage =
        new mxCoordinateAssignment(this, intraCellSpacing, interRankCellSpacing,
            orientation, initialX, parallelEdgeSpacing);
    placementStage.setFineTuning(fineTuning);
    placementStage.execute(parent);

    if (maxX < placementStage.getWidestRankValue()) {
      maxX = placementStage.getWidestRankValue();
    }
    if (maxY < placementStage.getMaxY()) {
      maxY = placementStage.getMaxY();
    }

    return placementStage.getLimitX() + interHierarchySpacing;
  }

  /**
   * The API method used to exercise the layout upon the graph description and produce a separate
   * description of the vertex position and edge routing changes made.
   */
  public void run(final Object parent) {
    mxHierarchicalLayout.hierarchyLayerControl = new ArrayList<>();
    // Separate out unconnected hierarchies
    final List<Set<Object>> hierarchyVertices = new ArrayList<Set<Object>>();
    final Set<Object> allVertexSet = new LinkedHashSet<Object>();

    if (roots == null && parent != null) {
      final Set<Object> filledVertexSet = filterDescendants(parent);

      roots = new ArrayList<Object>();

      while (!filledVertexSet.isEmpty()) {
        final List<Object> candidateRoots = findRoots(parent, filledVertexSet);

        for (final Object root : candidateRoots) {
          final Set<Object> vertexSet = new LinkedHashSet<Object>();
          hierarchyVertices.add(vertexSet);

          traverse(root, true, null, allVertexSet, vertexSet, hierarchyVertices,
              filledVertexSet);
        }

        roots.addAll(candidateRoots);
      }
    } else {
      // Find vertex set as directed traversal from roots

      for (int i = 0; i < roots.size(); i++) {
        final Set<Object> vertexSet = new LinkedHashSet<Object>();
        hierarchyVertices.add(vertexSet);

        traverse(roots.get(i), true, null, allVertexSet, vertexSet, hierarchyVertices,
            null);
      }
    }

    // Iterate through the result removing parents who have children in this layout


    // Perform a layout for each separate hierarchy
    // Track initial coordinate x-positioning
    double initialX = ourConstantValue;
    final Iterator<Set<Object>> iter = hierarchyVertices.iterator();

    while (iter.hasNext()) {
      final Set<Object> vertexSet = iter.next();

      model = new mxGraphHierarchyModel(this, vertexSet.toArray(), roots, parent);

      cycleStage(parent);
      layeringStage();
      crossingStage(parent);
      initialX = placementStage(initialX, parent);

      mxHierarchicalLayout.hierarchyLayerControl.add(mxCoordinateAssignment.layerControlmap);
    }
  }

  /**
   *
   * @param disableEdgeStyle
   */
  public void setDisableEdgeStyle(final boolean disableEdgeStyle) {
    this.disableEdgeStyle = disableEdgeStyle;
  }

  /**
   * @param fineTuning The fineTuning to set.
   */
  public void setFineTuning(final boolean fineTuning) {
    this.fineTuning = fineTuning;
  }

  /**
   * @param interHierarchySpacing The interHierarchySpacing to set.
   */
  public void setInterHierarchySpacing(final double interHierarchySpacing) {
    this.interHierarchySpacing = interHierarchySpacing;
  }

  /**
   * @param interRankCellSpacing The interRankCellSpacing to set.
   */
  public void setInterRankCellSpacing(final double interRankCellSpacing) {
    this.interRankCellSpacing = interRankCellSpacing;
  }

  /**
   * @param intraCellSpacing The intraCellSpacing to set.
   */
  public void setIntraCellSpacing(final double intraCellSpacing) {
    this.intraCellSpacing = intraCellSpacing;
  }

  /**
   * Sets the logging level of this class
   *
   * @param level the logging level to set
   */
  public void setLoggerLevel(final Level level) {
    try {
      mxHierarchicalLayout.logger.setLevel(level);
    } catch (final SecurityException e) {
      // Probably running in an applet
    }
  }

  /**
   * Sets the moveParent flag.
   */
  public void setMoveParent(final boolean value) {
    moveParent = value;
  }

  /**
   * @param orientation The orientation to set.
   */
  public void setOrientation(final int orientation) {
    this.orientation = orientation;
  }

  public void setParallelEdgeSpacing(final double parallelEdgeSpacing) {
    this.parallelEdgeSpacing = parallelEdgeSpacing;
  }

  /**
   * Sets parentBorder.
   */
  public void setParentBorder(final int value) {
    parentBorder = value;
  }

  /**
   * Sets the resizeParent flag.
   */
  public void setResizeParent(final boolean value) {
    resizeParent = value;
  }

  /**
   * Returns <code>Hierarchical</code>, the name of this algorithm.
   */
  @Override
  public String toString() {
    return "Hierarchical";
  }

  /**
   * Traverses the (directed) graph invoking the given function for each visited vertex and edge.
   * The function is invoked with the current vertex and the incoming edge as a parameter. This
   * implementation makes sure each vertex is only visited once. The function may return false if
   * the traversal should stop at the given vertex.
   *
   * @param vertex <mxCell> that represents the vertex where the traversal starts.
   * @param directed Optional boolean indicating if edges should only be traversed from source to
   *        target. Default is true.
   * @param edge Optional <mxCell> that represents the incoming edge. This is null for the first
   *        step of the traversal.
   * @param allVertices Array of cell paths for the visited cells.
   */
  protected void traverse(final Object vertex, final boolean directed, final Object edge,
      final Set<Object> allVertices, final Set<Object> currentComp,
      final List<Set<Object>> hierarchyVertices, final Set<Object> filledVertexSet) {
    final mxGraphView view = graph.getView();
    final mxIGraphModel model = graph.getModel();

    if (vertex != null && allVertices != null) {
      // Has this vertex been seen before in any traversal
      // And if the filled vertex set is populated, only
      // process vertices in that it contains
      if (!allVertices.contains(vertex)
          && (filledVertexSet == null ? true : filledVertexSet.contains(vertex))) {
        currentComp.add(vertex);
        allVertices.add(vertex);

        if (filledVertexSet != null) {
          filledVertexSet.remove(vertex);
        }

        final int edgeCount = model.getEdgeCount(vertex);

        if (edgeCount > 0) {
          for (int i = 0; i < edgeCount; i++) {
            final Object e = model.getEdgeAt(vertex, i);
            final boolean isSource = view.getVisibleTerminal(e, true) == vertex;

            if (!directed || isSource) {
              final Object next = view.getVisibleTerminal(e, !isSource);
              traverse(next, directed, e, allVertices, currentComp, hierarchyVertices,
                  filledVertexSet);
            }
          }
        }
      } else {
        if (!currentComp.contains(vertex)) {
          // We've seen this vertex before, but not in the current component
          // This component and the one it's in need to be merged
          Set<Object> matchComp = null;

          for (final Set<Object> comp : hierarchyVertices) {
            if (comp.contains(vertex)) {
              currentComp.addAll(comp);
              matchComp = comp;
              break;
            }
          }

          if (matchComp != null) {
            hierarchyVertices.remove(matchComp);
          }
        }
      }
    }
  }

}
