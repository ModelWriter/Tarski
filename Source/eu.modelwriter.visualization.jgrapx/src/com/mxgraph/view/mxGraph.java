/**
 * Copyright (c) 2007, Gaudenz Alder
 */
package com.mxgraph.view;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Element;

import com.mxgraph.canvas.mxGraphics2DCanvas;
import com.mxgraph.canvas.mxICanvas;
import com.mxgraph.canvas.mxImageCanvas;
import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.model.mxGraphModel;
import com.mxgraph.model.mxGraphModel.Filter;
import com.mxgraph.model.mxGraphModel.mxChildChange;
import com.mxgraph.model.mxGraphModel.mxCollapseChange;
import com.mxgraph.model.mxGraphModel.mxGeometryChange;
import com.mxgraph.model.mxGraphModel.mxRootChange;
import com.mxgraph.model.mxGraphModel.mxStyleChange;
import com.mxgraph.model.mxGraphModel.mxTerminalChange;
import com.mxgraph.model.mxGraphModel.mxValueChange;
import com.mxgraph.model.mxGraphModel.mxVisibleChange;
import com.mxgraph.model.mxICell;
import com.mxgraph.model.mxIGraphModel;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource;
import com.mxgraph.util.mxImageBundle;
import com.mxgraph.util.mxPoint;
import com.mxgraph.util.mxRectangle;
import com.mxgraph.util.mxResources;
import com.mxgraph.util.mxStyleUtils;
import com.mxgraph.util.mxUndoableEdit;
import com.mxgraph.util.mxUndoableEdit.mxUndoableChange;
import com.mxgraph.util.mxUtils;

/**
 * Implements a graph object that allows to create diagrams from a graph model and stylesheet.
 *
 * <h3>Images</h3> To create an image from a graph, use the following code for a given XML document
 * (doc) and File (file):
 *
 * <code>
 * Image img = mxCellRenderer.createBufferedImage(
 * 		graph, null, 1, Color.WHITE, false, null);
 * ImageIO.write(img, "png", file);
 * </code>
 *
 * If the XML is given as a string rather than a document, the document can be obtained using
 * mxUtils.parse.
 *
 * This class fires the following events:
 *
 * mxEvent.ROOT fires if the root in the model has changed. This event has no properties.
 *
 * mxEvent.ALIGN_CELLS fires between begin- and endUpdate in alignCells. The <code>cells</code> and
 * <code>align</code> properties contain the respective arguments that were passed to alignCells.
 *
 * mxEvent.FLIP_EDGE fires between begin- and endUpdate in flipEdge. The <code>edge</code> property
 * contains the edge passed to flipEdge.
 *
 * mxEvent.ORDER_CELLS fires between begin- and endUpdate in orderCells. The <code>cells</code> and
 * <code>back</code> properties contain the respective arguments that were passed to orderCells.
 *
 * mxEvent.CELLS_ORDERED fires between begin- and endUpdate in cellsOrdered. The <code>cells</code>
 * and <code>back</code> arguments contain the respective arguments that were passed to
 * cellsOrdered.
 *
 * mxEvent.GROUP_CELLS fires between begin- and endUpdate in groupCells. The <code>group</code>,
 * <code>cells</code> and <code>border</code> arguments contain the respective arguments that were
 * passed to groupCells.
 *
 * mxEvent.UNGROUP_CELLS fires between begin- and endUpdate in ungroupCells. The <code>cells</code>
 * property contains the array of cells that was passed to ungroupCells.
 *
 * mxEvent.REMOVE_CELLS_FROM_PARENT fires between begin- and endUpdate in removeCellsFromParent. The
 * <code>cells</code> property contains the array of cells that was passed to removeCellsFromParent.
 *
 * mxEvent.ADD_CELLS fires between begin- and endUpdate in addCells. The <code>cells</code>,
 * <code>parent</code>, <code>index</code>, <code>source</code> and <code>target</code> properties
 * contain the respective arguments that were passed to addCells.
 *
 * mxEvent.CELLS_ADDED fires between begin- and endUpdate in cellsAdded. The <code>cells</code>,
 * <code>parent</code>, <code>index</code>, <code>source</code>, <code>target</code> and
 * <code>absolute</code> properties contain the respective arguments that were passed to cellsAdded.
 *
 * mxEvent.REMOVE_CELLS fires between begin- and endUpdate in removeCells. The <code>cells</code>
 * and <code>includeEdges</code> arguments contain the respective arguments that were passed to
 * removeCells.
 *
 * mxEvent.CELLS_REMOVED fires between begin- and endUpdate in cellsRemoved. The <code>cells</code>
 * argument contains the array of cells that was removed.
 *
 * mxEvent.SPLIT_EDGE fires between begin- and endUpdate in splitEdge. The <code>edge</code>
 * property contains the edge to be splitted, the <code>cells</code>, <code>newEdge</code>,
 * <code>dx</code> and <code>dy</code> properties contain the respective arguments that were passed
 * to splitEdge.
 *
 * mxEvent.TOGGLE_CELLS fires between begin- and endUpdate in toggleCells. The <code>show</code>,
 * <code>cells</code> and <code>includeEdges</code> properties contain the respective arguments that
 * were passed to toggleCells.
 *
 * mxEvent.FOLD_CELLS fires between begin- and endUpdate in foldCells. The <code>collapse</code>,
 * <code>cells</code> and <code>recurse</code> properties contain the respective arguments that were
 * passed to foldCells.
 *
 * mxEvent.CELLS_FOLDED fires between begin- and endUpdate in cellsFolded. The <code>collapse</code>
 * , <code>cells</code> and <code>recurse</code> properties contain the respective arguments that
 * were passed to cellsFolded.
 *
 * mxEvent.UPDATE_CELL_SIZE fires between begin- and endUpdate in updateCellSize. The
 * <code>cell</code> and <code>ignoreChildren</code> properties contain the respective arguments
 * that were passed to updateCellSize.
 *
 * mxEvent.RESIZE_CELLS fires between begin- and endUpdate in resizeCells. The <code>cells</code>
 * and <code>bounds</code> properties contain the respective arguments that were passed to
 * resizeCells.
 *
 * mxEvent.CELLS_RESIZED fires between begin- and endUpdate in cellsResized. The <code>cells</code>
 * and <code>bounds</code> properties contain the respective arguments that were passed to
 * cellsResized.
 *
 * mxEvent.MOVE_CELLS fires between begin- and endUpdate in moveCells. The <code>cells</code>,
 * <code>dx</code>, <code>dy</code>, <code>clone</code>, <code>target</code> and
 * <code>location</code> properties contain the respective arguments that were passed to moveCells.
 *
 * mxEvent.CELLS_MOVED fires between begin- and endUpdate in cellsMoved. The <code>cells</code>,
 * <code>dx</code>, <code>dy</code> and <code>disconnect</code> properties contain the respective
 * arguments that were passed to cellsMoved.
 *
 * mxEvent.CONNECT_CELL fires between begin- and endUpdate in connectCell. The <code>edge</code>,
 * <code>terminal</code> and <code>source</code> properties contain the respective arguments that
 * were passed to connectCell.
 *
 * mxEvent.CELL_CONNECTED fires between begin- and endUpdate in cellConnected. The <code>edge</code>
 * , <code>terminal</code> and <code>source</code> properties contain the respective arguments that
 * were passed to cellConnected.
 *
 * mxEvent.REPAINT fires if a repaint was requested by calling repaint. The <code>region</code>
 * property contains the optional mxRectangle that was passed to repaint to define the dirty region.
 */
public class mxGraph extends mxEventSource {

  /**
   *
   */
  public interface mxICellVisitor {

    /**
     *
     * @param vertex
     * @param edge
     */
    boolean visit(Object vertex, Object edge);

  }

  /**
   * Adds required resources.
   */
  static {
    try {
      mxResources.add("com.mxgraph.resources.graph");
    } catch (final Exception e) {
      // ignore
    }
  }

  /**
   * Holds the version number of this release. Current version is 3.4.1.3.
   */
  public static final String VERSION = "3.4.1.3";

  /**
   * Holds the list of bundles.
   */
  protected static List<mxImageBundle> imageBundles = new LinkedList<mxImageBundle>();

  /**
   * Prints the version number on the console.
   */
  public static void main(final String[] args) {
    System.out.println("mxGraph version \"" + mxGraph.VERSION + "\"");
  }

  /**
   * Property change event handling.
   */
  protected PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

  /**
   * Holds the model that contains the cells to be displayed.
   */
  protected mxIGraphModel model;

  /**
   * Holds the view that caches the cell states.
   */
  protected mxGraphView view;

  /**
   * Holds the stylesheet that defines the appearance of the cells.
   */
  protected mxStylesheet stylesheet;

  /**
   * Holds the <mxGraphSelection> that models the current selection.
   */
  protected mxGraphSelectionModel selectionModel;

  /**
   * Specifies the grid size. Default is 10.
   */
  protected int gridSize = 10;

  /**
   * Specifies if the grid is enabled. Default is true.
   */
  protected boolean gridEnabled = true;

  /**
   * Specifies if ports are enabled. This is used in <cellConnected> to update the respective style.
   * Default is true.
   */
  protected boolean portsEnabled = true;

  /**
   * Value returned by getOverlap if isAllowOverlapParent returns true for the given cell.
   * getOverlap is used in keepInside if isKeepInsideParentOnMove returns true. The value specifies
   * the portion of the child which is allowed to overlap the parent.
   */
  protected double defaultOverlap = 0.5;

  /**
   * Specifies the default parent to be used to insert new cells. This is used in getDefaultParent.
   * Default is null.
   */
  protected Object defaultParent;

  /**
   * Specifies the alternate edge style to be used if the main control point on an edge is being
   * doubleclicked. Default is null.
   */
  protected String alternateEdgeStyle;

  /**
   * Specifies the return value for isEnabled. Default is true.
   */
  protected boolean enabled = true;

  /**
   * Specifies the return value for isCell(s)Locked. Default is false.
   */
  protected boolean cellsLocked = false;

  /**
   * Specifies the return value for isCell(s)Editable. Default is true.
   */
  protected boolean cellsEditable = true;

  /**
   * Specifies the return value for isCell(s)Sizable. Default is true.
   */
  protected boolean cellsResizable = true;

  /**
   * Specifies the return value for isCell(s)Movable. Default is true.
   */
  protected boolean cellsMovable = true;

  /**
   * Specifies the return value for isCell(s)Bendable. Default is true.
   */
  protected boolean cellsBendable = true;

  /**
   * Specifies the return value for isCell(s)Selectable. Default is true.
   */
  protected boolean cellsSelectable = true;

  /**
   * Specifies the return value for isCell(s)Deletable. Default is true.
   */
  protected boolean cellsDeletable = true;

  /**
   * Specifies the return value for isCell(s)Cloneable. Default is true.
   */
  protected boolean cellsCloneable = true;

  /**
   * Specifies the return value for isCellDisconntableFromTerminal. Default is true.
   */
  protected boolean cellsDisconnectable = true;

  /**
   * Specifies the return value for isLabel(s)Clipped. Default is false.
   */
  protected boolean labelsClipped = false;

  /**
   * Specifies the return value for edges in isLabelMovable. Default is true.
   */
  protected boolean edgeLabelsMovable = true;

  /**
   * Specifies the return value for vertices in isLabelMovable. Default is false.
   */
  protected boolean vertexLabelsMovable = false;

  /**
   * Specifies the return value for isDropEnabled. Default is true.
   */
  protected boolean dropEnabled = true;

  /**
   * Specifies if dropping onto edges should be enabled. Default is true.
   */
  protected boolean splitEnabled = true;

  /**
   * Specifies if the graph should automatically update the cell size after an edit. This is used in
   * isAutoSizeCell. Default is false.
   */
  protected boolean autoSizeCells = false;

  /**
   * <mxRectangle> that specifies the area in which all cells in the diagram should be placed. Uses
   * in getMaximumGraphBounds. Use a width or height of 0 if you only want to give a upper, left
   * corner.
   */
  protected mxRectangle maximumGraphBounds = null;

  /**
   * mxRectangle that specifies the minimum size of the graph canvas inside the scrollpane.
   */
  protected mxRectangle minimumGraphSize = null;

  /**
   * Border to be added to the bottom and right side when the container is being resized after the
   * graph has been changed. Default is 0.
   */
  protected int border = 0;

  /**
   * Specifies if edges should appear in the foreground regardless of their order in the model. This
   * has precendence over keepEdgeInBackground Default is false.
   */
  protected boolean keepEdgesInForeground = false;

  /**
   * Specifies if edges should appear in the background regardless of their order in the model.
   * Default is false.
   */
  protected boolean keepEdgesInBackground = false;

  /**
   * Specifies if the cell size should be changed to the preferred size when a cell is first
   * collapsed. Default is true.
   */
  protected boolean collapseToPreferredSize = true;

  /**
   * Specifies if negative coordinates for vertices are allowed. Default is true.
   */
  protected boolean allowNegativeCoordinates = true;

  /**
   * Specifies the return value for isConstrainChildren. Default is true.
   */
  protected boolean constrainChildren = true;

  /**
   * Specifies if a parent should contain the child bounds after a resize of the child. Default is
   * true.
   */
  protected boolean extendParents = true;

  /**
   * Specifies if parents should be extended according to the <extendParents> switch if cells are
   * added. Default is true.
   */
  protected boolean extendParentsOnAdd = true;

  /**
   * Specifies if the scale and translate should be reset if the root changes in the model. Default
   * is true.
   */
  protected boolean resetViewOnRootChange = true;

  /**
   * Specifies if loops (aka self-references) are allowed. Default is false.
   */
  protected boolean resetEdgesOnResize = false;

  /**
   * Specifies if edge control points should be reset after the move of a connected cell. Default is
   * false.
   */
  protected boolean resetEdgesOnMove = false;

  /**
   * Specifies if edge control points should be reset after the the edge has been reconnected.
   * Default is true.
   */
  protected boolean resetEdgesOnConnect = true;

  /**
   * Specifies if loops (aka self-references) are allowed. Default is false.
   */
  protected boolean allowLoops = false;

  /**
   * Specifies the multiplicities to be used for validation of the graph.
   */
  protected mxMultiplicity[] multiplicities;

  /**
   * Specifies the default style for loops.
   */
  protected mxEdgeStyle.mxEdgeStyleFunction defaultLoopStyle = mxEdgeStyle.Loop;

  /**
   * Specifies if multiple edges in the same direction between the same pair of vertices are
   * allowed. Default is true.
   */
  protected boolean multigraph = true;

  /**
   * Specifies if edges are connectable. Default is false. This overrides the connectable field in
   * edges.
   */
  protected boolean connectableEdges = false;

  /**
   * Specifies if edges with disconnected terminals are allowed in the graph. Default is false.
   */
  protected boolean allowDanglingEdges = true;

  /**
   * Specifies if edges that are cloned should be validated and only inserted if they are valid.
   * Default is true.
   */
  protected boolean cloneInvalidEdges = false;

  /**
   * Specifies if edges should be disconnected from their terminals when they are moved. Default is
   * true.
   */
  protected boolean disconnectOnMove = true;

  /**
   * Specifies if labels should be visible. This is used in getLabel. Default is true.
   */
  protected boolean labelsVisible = true;

  /**
   * Specifies the return value for isHtmlLabel. Default is false.
   */
  protected boolean htmlLabels = false;

  /**
   * Specifies if nesting of swimlanes is allowed. Default is true.
   */
  protected boolean swimlaneNesting = true;

  /**
   * Specifies the maximum number of changes that should be processed to find the dirty region. If
   * the number of changes is larger, then the complete grah is repainted. A value of zero will
   * always compute the dirty region for any number of changes. Default is 1000.
   */
  protected int changesRepaintThreshold = 1000;

  /**
   * Specifies if the origin should be automatically updated.
   */
  protected boolean autoOrigin = false;

  /**
   * Holds the current automatic origin.
   */
  protected mxPoint origin = new mxPoint();

  /**
   * Fires repaint events for full repaints.
   */
  protected mxIEventListener fullRepaintHandler = new mxIEventListener() {
    @Override
    public void invoke(final Object sender, final mxEventObject evt) {
      mxGraph.this.repaint();
    }
  };

  /**
   * Fires repaint events for full repaints.
   */
  protected mxIEventListener updateOriginHandler = new mxIEventListener() {
    @Override
    public void invoke(final Object sender, final mxEventObject evt) {
      if (mxGraph.this.isAutoOrigin()) {
        mxGraph.this.updateOrigin();
      }
    }
  };

  /**
   * Fires repaint events for model changes.
   */
  protected mxIEventListener graphModelChangeHandler = new mxIEventListener() {
    @Override
    public void invoke(final Object sender, final mxEventObject evt) {
      final mxRectangle dirty = mxGraph.this.graphModelChanged((mxIGraphModel) sender,
          ((mxUndoableEdit) evt.getProperty("edit")).getChanges());
      mxGraph.this.repaint(dirty);
    }
  };

  /**
   * Constructs a new graph with an empty {@link com.mxgraph.model.mxGraphModel}.
   */
  public mxGraph() {
    this(null, null);
  }

  /**
   * Constructs a new graph for the specified model. If no model is specified, then a new, empty
   * {@link com.mxgraph.model.mxGraphModel} is used.
   *
   * @param model Model that contains the graph data
   */
  public mxGraph(final mxIGraphModel model) {
    this(model, null);
  }

  /**
   * Constructs a new graph for the specified model. If no model is specified, then a new, empty
   * {@link com.mxgraph.model.mxGraphModel} is used.
   *
   * @param model Model that contains the graph data
   */
  public mxGraph(final mxIGraphModel model, final mxStylesheet stylesheet) {
    this.selectionModel = this.createSelectionModel();
    this.setModel(model != null ? model : new mxGraphModel());
    this.setStylesheet(stylesheet != null ? stylesheet : this.createStylesheet());
    this.setView(this.createGraphView());
  }

  /**
   * Constructs a new graph for the specified model. If no model is specified, then a new, empty
   * {@link com.mxgraph.model.mxGraphModel} is used.
   *
   * @param stylesheet The stylesheet to use for the graph.
   */
  public mxGraph(final mxStylesheet stylesheet) {
    this(null, stylesheet);
  }

  /**
   * Returns an array with the given cells and all edges that are connected to a cell or one of its
   * descendants.
   */
  public Object[] addAllEdges(final Object[] cells) {
    final List<Object> allCells = new ArrayList<Object>(cells.length);
    allCells.addAll(Arrays.asList(cells));
    allCells.addAll(Arrays.asList(this.getAllEdges(cells)));

    return allCells.toArray();
  }

  /**
   * Adds the cell to the default parent. This is a shortcut method.
   *
   * @param cell Cell to be inserted.
   * @return Returns the cell that was added.
   */
  public Object addCell(final Object cell) {
    return this.addCell(cell, null);
  }

  /**
   * Adds the cell to the parent. This is a shortcut method.
   *
   * @param cell Cell tobe inserted.
   * @param parent Object that represents the new parent. If no parent is given then the default
   *        parent is used.
   * @return Returns the cell that was added.
   */
  public Object addCell(final Object cell, final Object parent) {
    return this.addCell(cell, parent, null, null, null);
  }

  /**
   * Adds the cell to the parent and connects it to the given source and target terminals. This is a
   * shortcut method.
   *
   * @param cell Cell to be inserted into the given parent.
   * @param parent Object that represents the new parent. If no parent is given then the default
   *        parent is used.
   * @param index Optional index to insert the cells at. Default is to append.
   * @param source Optional cell that represents the source terminal.
   * @param target Optional cell that represents the target terminal.
   * @return Returns the cell that was added.
   */
  public Object addCell(final Object cell, final Object parent, final Integer index,
      final Object source, final Object target) {
    return this.addCells(new Object[] {cell}, parent, index, source, target)[0];
  }

  /**
   * Adds the cells to the default parent. This is a shortcut method.
   *
   * @param cells Array of cells to be inserted.
   * @return Returns the cells that were added.
   */
  public Object[] addCells(final Object[] cells) {
    return this.addCells(cells, null);
  }

  /**
   * Adds the cells to the parent. This is a shortcut method.
   *
   * @param cells Array of cells to be inserted.
   * @param parent Optional cell that represents the new parent. If no parent is specified then the
   *        default parent is used.
   * @return Returns the cells that were added.
   */
  public Object[] addCells(final Object[] cells, final Object parent) {
    return this.addCells(cells, parent, null);
  }

  /**
   * Adds the cells to the parent at the given index. This is a shortcut method.
   *
   * @param cells Array of cells to be inserted.
   * @param parent Optional cell that represents the new parent. If no parent is specified then the
   *        default parent is used.
   * @param index Optional index to insert the cells at. Default is to append.
   * @return Returns the cells that were added.
   */
  public Object[] addCells(final Object[] cells, final Object parent, final Integer index) {
    return this.addCells(cells, parent, index, null, null);
  }

  /**
   * Adds the cells to the parent at the given index, connecting each cell to the optional source
   * and target terminal. The change is carried out using cellsAdded. This method fires
   * mxEvent.ADD_CELLS while the transaction is in progress.
   *
   * @param cells Array of cells to be added.
   * @param parent Optional cell that represents the new parent. If no parent is specified then the
   *        default parent is used.
   * @param index Optional index to insert the cells at. Default is to append.
   * @param source Optional source terminal for all inserted cells.
   * @param target Optional target terminal for all inserted cells.
   * @return Returns the cells that were added.
   */
  public Object[] addCells(final Object[] cells, Object parent, Integer index, final Object source,
      final Object target) {
    if (parent == null) {
      parent = this.getDefaultParent();
    }

    if (index == null) {
      index = this.model.getChildCount(parent);
    }

    this.model.beginUpdate();
    try {
      this.cellsAdded(cells, parent, index, source, target, false, true);
      this.fireEvent(new mxEventObject(mxEvent.ADD_CELLS, "cells", cells, "parent", parent, "index",
          index, "source", source, "target", target));
    } finally {
      this.model.endUpdate();
    }

    return cells;
  }

  /**
   * Adds the edge to the parent and connects it to the given source and target terminals. This is a
   * shortcut method.
   *
   * @param edge Edge to be inserted into the given parent.
   * @param parent Object that represents the new parent. If no parent is given then the default
   *        parent is used.
   * @param source Optional cell that represents the source terminal.
   * @param target Optional cell that represents the target terminal.
   * @param index Optional index to insert the cells at. Default is to append.
   * @return Returns the edge that was added.
   */
  public Object addEdge(final Object edge, final Object parent, final Object source,
      final Object target, final Integer index) {
    return this.addCell(edge, parent, index, source, target);
  }

  /**
   * Adds the specified bundle.
   */
  public void addImageBundle(final mxImageBundle bundle) {
    mxGraph.imageBundles.add(bundle);
  }

  /**
   * @param listener
   * @see java.beans.PropertyChangeSupport#addPropertyChangeListener(java.beans.PropertyChangeListener)
   */
  public void addPropertyChangeListener(final PropertyChangeListener listener) {
    this.changeSupport.addPropertyChangeListener(listener);
  }

  /**
   * @param propertyName
   * @param listener
   * @see java.beans.PropertyChangeSupport#addPropertyChangeListener(java.lang.String,
   *      java.beans.PropertyChangeListener)
   */
  public void addPropertyChangeListener(final String propertyName,
      final PropertyChangeListener listener) {
    this.changeSupport.addPropertyChangeListener(propertyName, listener);
  }

  /**
   *
   */
  public void addSelectionCell(final Object cell) {
    this.selectionModel.addCell(cell);
  }

  /**
   *
   */
  public void addSelectionCells(final Object[] cells) {
    this.selectionModel.addCells(cells);
  }

  /**
   * Aligns the selection cells vertically or horizontally according to the given alignment.
   *
   * @param align Specifies the alignment. Possible values are all constants in mxConstants with an
   *        ALIGN prefix.
   */
  public Object[] alignCells(final String align) {
    return this.alignCells(align, null);
  }

  //
  // Cell styles
  //

  /**
   * Aligns the given cells vertically or horizontally according to the given alignment.
   *
   * @param align Specifies the alignment. Possible values are all constants in mxConstants with an
   *        ALIGN prefix.
   * @param cells Array of cells to be aligned.
   */
  public Object[] alignCells(final String align, final Object[] cells) {
    return this.alignCells(align, cells, null);
  }

  /**
   * Aligns the given cells vertically or horizontally according to the given alignment using the
   * optional parameter as the coordinate.
   *
   * @param align Specifies the alignment. Possible values are all constants in mxConstants with an
   *        ALIGN prefix.
   * @param cells Array of cells to be aligned.
   * @param param Optional coordinate for the alignment.
   */
  public Object[] alignCells(final String align, Object[] cells, Object param) {
    if (cells == null) {
      cells = this.getSelectionCells();
    }

    if (cells != null && cells.length > 1) {
      // Finds the required coordinate for the alignment
      if (param == null) {
        for (int i = 0; i < cells.length; i++) {
          final mxGeometry geo = this.getCellGeometry(cells[i]);

          if (geo != null && !this.model.isEdge(cells[i])) {
            if (param == null) {
              if (align == null || align.equals(mxConstants.ALIGN_LEFT)) {
                param = geo.getX();
              } else if (align.equals(mxConstants.ALIGN_CENTER)) {
                param = geo.getX() + geo.getWidth() / 2;
                break;
              } else if (align.equals(mxConstants.ALIGN_RIGHT)) {
                param = geo.getX() + geo.getWidth();
              } else if (align.equals(mxConstants.ALIGN_TOP)) {
                param = geo.getY();
              } else if (align.equals(mxConstants.ALIGN_MIDDLE)) {
                param = geo.getY() + geo.getHeight() / 2;
                break;
              } else if (align.equals(mxConstants.ALIGN_BOTTOM)) {
                param = geo.getY() + geo.getHeight();
              }
            } else {
              final double tmp = Double.parseDouble(String.valueOf(param));

              if (align == null || align.equals(mxConstants.ALIGN_LEFT)) {
                param = Math.min(tmp, geo.getX());
              } else if (align.equals(mxConstants.ALIGN_RIGHT)) {
                param = Math.max(tmp, geo.getX() + geo.getWidth());
              } else if (align.equals(mxConstants.ALIGN_TOP)) {
                param = Math.min(tmp, geo.getY());
              } else if (align.equals(mxConstants.ALIGN_BOTTOM)) {
                param = Math.max(tmp, geo.getY() + geo.getHeight());
              }
            }
          }
        }
      }

      // Aligns the cells to the coordinate
      this.model.beginUpdate();
      try {
        final double tmp = Double.parseDouble(String.valueOf(param));

        for (int i = 0; i < cells.length; i++) {
          mxGeometry geo = this.getCellGeometry(cells[i]);

          if (geo != null && !this.model.isEdge(cells[i])) {
            geo = (mxGeometry) geo.clone();

            if (align == null || align.equals(mxConstants.ALIGN_LEFT)) {
              geo.setX(tmp);
            } else if (align.equals(mxConstants.ALIGN_CENTER)) {
              geo.setX(tmp - geo.getWidth() / 2);
            } else if (align.equals(mxConstants.ALIGN_RIGHT)) {
              geo.setX(tmp - geo.getWidth());
            } else if (align.equals(mxConstants.ALIGN_TOP)) {
              geo.setY(tmp);
            } else if (align.equals(mxConstants.ALIGN_MIDDLE)) {
              geo.setY(tmp - geo.getHeight() / 2);
            } else if (align.equals(mxConstants.ALIGN_BOTTOM)) {
              geo.setY(tmp - geo.getHeight());
            }

            this.model.setGeometry(cells[i], geo);

            if (this.isResetEdgesOnMove()) {
              this.resetEdges(new Object[] {cells[i]});
            }
          }
        }

        this.fireEvent(new mxEventObject(mxEvent.ALIGN_CELLS, "cells", cells, "align", align));
      } finally {
        this.model.endUpdate();
      }
    }

    return cells;
  }

  /**
   * Sets the new terminal for the given edge and resets the edge points if isResetEdgesOnConnect
   * returns true. This method fires <mxEvent.CELL_CONNECTED> while the transaction is in progress.
   *
   * @param edge Edge whose terminal should be updated.
   * @param terminal New terminal to be used.
   * @param source Specifies if the new terminal is the source or target.
   * @param constraint Constraint to be used for this connection.
   */
  public void cellConnected(final Object edge, Object terminal, final boolean source,
      final mxConnectionConstraint constraint) {
    if (edge != null) {
      this.model.beginUpdate();
      try {
        final Object previous = this.model.getTerminal(edge, source);

        // Updates the constraint
        this.setConnectionConstraint(edge, terminal, source, constraint);

        // Checks if the new terminal is a port, uses the ID of the port in the
        // style and the parent of the port as the actual terminal of the edge.
        if (this.isPortsEnabled()) {
          // Checks if the new terminal is a port
          String id = null;

          if (this.isPort(terminal) && terminal instanceof mxICell) {
            id = ((mxICell) terminal).getId();
            terminal = this.getTerminalForPort(terminal, source);
          }

          // Sets or resets all previous information for connecting to a child port
          final String key = source ? mxConstants.STYLE_SOURCE_PORT : mxConstants.STYLE_TARGET_PORT;
          this.setCellStyles(key, id, new Object[] {edge});
        }

        this.model.setTerminal(edge, terminal, source);

        if (this.isResetEdgesOnConnect()) {
          this.resetEdge(edge);
        }

        this.fireEvent(new mxEventObject(mxEvent.CELL_CONNECTED, "edge", edge, "terminal", terminal,
            "source", source, "previous", previous));
      } finally {
        this.model.endUpdate();
      }
    }
  }

  /**
   * Called when a cell has been painted as the specified object, typically a DOM node that
   * represents the given cell graphically in a document.
   */
  protected void cellDrawn(final mxICanvas canvas, final mxCellState state, final Object element,
      final Object labelElement) {
    if (element instanceof Element) {
      final String link = this.getLinkForCell(state.getCell());

      if (link != null) {
        final String title = this.getToolTipForCell(state.getCell());
        Element elem = (Element) element;

        if (elem.getNodeName().startsWith("v:")) {
          elem.setAttribute("href", link.toString());

          if (title != null) {
            elem.setAttribute("title", title);
          }
        } else if (elem.getOwnerDocument().getElementsByTagName("svg").getLength() > 0) {
          final Element xlink = elem.getOwnerDocument().createElement("a");
          xlink.setAttribute("xlink:href", link.toString());

          elem.getParentNode().replaceChild(xlink, elem);
          xlink.appendChild(elem);

          if (title != null) {
            xlink.setAttribute("xlink:title", title);
          }

          elem = xlink;
        } else {
          final Element a = elem.getOwnerDocument().createElement("a");
          a.setAttribute("href", link.toString());
          a.setAttribute("style", "text-decoration:none;");

          elem.getParentNode().replaceChild(a, elem);
          a.appendChild(elem);

          if (title != null) {
            a.setAttribute("title", title);
          }

          elem = a;
        }

        final String target = this.getTargetForCell(state.getCell());

        if (target != null) {
          elem.setAttribute("target", target);
        }
      }
    }
  }

  /**
   * Sets the new label for a cell. If autoSize is true then <cellSizeUpdated> will be called.
   *
   * @param cell Cell whose label should be changed.
   * @param value New label to be assigned.
   * @param autoSize Specifies if cellSizeUpdated should be called.
   */
  public void cellLabelChanged(final Object cell, final Object value, final boolean autoSize) {
    this.model.beginUpdate();
    try {
      this.getModel().setValue(cell, value);

      if (autoSize) {
        this.cellSizeUpdated(cell, false);
      }
    } finally {
      this.model.endUpdate();
    }
  }

  /**
   * Adds the specified cells to the given parent. This method fires mxEvent.CELLS_ADDED while the
   * transaction is in progress.
   */
  public void cellsAdded(final Object[] cells, final Object parent, final Integer index,
      final Object source, final Object target, final boolean absolute) {
    this.cellsAdded(cells, parent, index, source, target, absolute, true);
  }

  /**
   * Adds the specified cells to the given parent. This method fires mxEvent.CELLS_ADDED while the
   * transaction is in progress.
   */
  public void cellsAdded(final Object[] cells, final Object parent, Integer index,
      final Object source, final Object target, final boolean absolute, final boolean constrain) {
    if (cells != null && parent != null && index != null) {
      this.model.beginUpdate();
      try {
        final mxCellState parentState = absolute ? this.view.getState(parent) : null;
        final mxPoint o1 = parentState != null ? parentState.getOrigin() : null;
        final mxPoint zero = new mxPoint(0, 0);

        for (int i = 0; i < cells.length; i++) {
          if (cells[i] == null) {
            index--;
          } else {
            final Object previous = this.model.getParent(cells[i]);

            // Keeps the cell at its absolute location
            if (o1 != null && cells[i] != parent && parent != previous) {
              final mxCellState oldState = this.view.getState(previous);
              final mxPoint o2 = oldState != null ? oldState.getOrigin() : zero;
              mxGeometry geo = this.model.getGeometry(cells[i]);

              if (geo != null) {
                final double dx = o2.getX() - o1.getX();
                final double dy = o2.getY() - o1.getY();

                geo = (mxGeometry) geo.clone();
                geo.translate(dx, dy);

                if (!geo.isRelative() && this.model.isVertex(cells[i])
                    && !this.isAllowNegativeCoordinates()) {
                  geo.setX(Math.max(0, geo.getX()));
                  geo.setY(Math.max(0, geo.getY()));
                }

                this.model.setGeometry(cells[i], geo);
              }
            }

            // Decrements all following indices
            // if cell is already in parent
            if (parent == previous) {
              index--;
            }

            this.model.add(parent, cells[i], index + i);

            // Extends the parent
            if (this.isExtendParentsOnAdd() && this.isExtendParent(cells[i])) {
              this.extendParent(cells[i]);
            }

            // Constrains the child
            if (constrain) {
              this.constrainChild(cells[i]);
            }

            // Sets the source terminal
            if (source != null) {
              this.cellConnected(cells[i], source, true, null);
            }

            // Sets the target terminal
            if (target != null) {
              this.cellConnected(cells[i], target, false, null);
            }
          }
        }

        this.fireEvent(new mxEventObject(mxEvent.CELLS_ADDED, "cells", cells, "parent", parent,
            "index", index, "source", source, "target", target, "absolute", absolute));

      } finally {
        this.model.endUpdate();
      }
    }
  }

  /**
   * Invokes cellsFoldable with checkFoldable set to false.
   */
  public void cellsFolded(final Object[] cells, final boolean collapse, final boolean recurse) {
    this.cellsFolded(cells, collapse, recurse, false);
  }

  /**
   * Sets the collapsed state of the specified cells. This method fires mxEvent.CELLS_FOLDED while
   * the transaction is in progress. Returns the cells whose collapsed state was changed.
   *
   * @param cells Array of cells whose collapsed state should be set.
   * @param collapse Boolean indicating the collapsed state to be assigned.
   * @param recurse Boolean indicating if the collapsed state of all descendants should be set.
   * @param checkFoldable Boolean indicating of isCellFoldable should be checked. Default is false.
   */
  public void cellsFolded(final Object[] cells, final boolean collapse, final boolean recurse,
      final boolean checkFoldable) {
    if (cells != null && cells.length > 0) {
      this.model.beginUpdate();
      try {
        for (int i = 0; i < cells.length; i++) {
          if ((!checkFoldable || this.isCellFoldable(cells[i], collapse))
              && collapse != this.isCellCollapsed(cells[i])) {
            this.model.setCollapsed(cells[i], collapse);
            this.swapBounds(cells[i], collapse);

            if (this.isExtendParent(cells[i])) {
              this.extendParent(cells[i]);
            }

            if (recurse) {
              final Object[] children = mxGraphModel.getChildren(this.model, cells[i]);
              this.cellsFolded(children, collapse, recurse);
            }
          }
        }

        this.fireEvent(new mxEventObject(mxEvent.CELLS_FOLDED, "cells", cells, "collapse", collapse,
            "recurse", recurse));
      } finally {
        this.model.endUpdate();
      }
    }
  }

  /**
   * Updates the size of the given cell in the model using getPreferredSizeForCell to get the new
   * size.
   *
   * @param cell Cell for which the size should be changed.
   */
  public void cellSizeUpdated(final Object cell, final boolean ignoreChildren) {
    if (cell != null) {
      this.model.beginUpdate();
      try {
        final mxRectangle size = this.getPreferredSizeForCell(cell);
        mxGeometry geo = this.model.getGeometry(cell);

        if (size != null && geo != null) {
          final boolean collapsed = this.isCellCollapsed(cell);
          geo = (mxGeometry) geo.clone();

          if (this.isSwimlane(cell)) {
            final mxCellState state = this.view.getState(cell);
            final Map<String, Object> style =
                state != null ? state.getStyle() : this.getCellStyle(cell);
            String cellStyle = this.model.getStyle(cell);

            if (cellStyle == null) {
              cellStyle = "";
            }

            if (mxUtils.isTrue(style, mxConstants.STYLE_HORIZONTAL, true)) {
              cellStyle = mxStyleUtils.setStyle(cellStyle, mxConstants.STYLE_STARTSIZE,
                  String.valueOf(size.getHeight() + 8));

              if (collapsed) {
                geo.setHeight(size.getHeight() + 8);
              }

              geo.setWidth(size.getWidth());
            } else {
              cellStyle = mxStyleUtils.setStyle(cellStyle, mxConstants.STYLE_STARTSIZE,
                  String.valueOf(size.getWidth() + 8));

              if (collapsed) {
                geo.setWidth(size.getWidth() + 8);
              }

              geo.setHeight(size.getHeight());
            }

            this.model.setStyle(cell, cellStyle);
          } else {
            geo.setWidth(size.getWidth());
            geo.setHeight(size.getHeight());
          }

          if (!ignoreChildren && !collapsed) {
            final mxRectangle bounds =
                this.view.getBounds(mxGraphModel.getChildren(this.model, cell));

            if (bounds != null) {
              final mxPoint tr = this.view.getTranslate();
              final double scale = this.view.getScale();

              final double width =
                  (bounds.getX() + bounds.getWidth()) / scale - geo.getX() - tr.getX();
              final double height =
                  (bounds.getY() + bounds.getHeight()) / scale - geo.getY() - tr.getY();

              geo.setWidth(Math.max(geo.getWidth(), width));
              geo.setHeight(Math.max(geo.getHeight(), height));
            }
          }

          this.cellsResized(new Object[] {cell}, new mxRectangle[] {geo});
        }
      } finally {
        this.model.endUpdate();
      }
    }
  }

  /**
   * Moves the specified cells by the given vector, disconnecting the cells using disconnectGraph if
   * disconnect is true. This method fires mxEvent.CELLS_MOVED while the transaction is in progress.
   */
  public void cellsMoved(final Object[] cells, final double dx, final double dy,
      final boolean disconnect, final boolean constrain) {
    if (cells != null && (dx != 0 || dy != 0)) {
      this.model.beginUpdate();
      try {
        if (disconnect) {
          this.disconnectGraph(cells);
        }

        for (int i = 0; i < cells.length; i++) {
          this.translateCell(cells[i], dx, dy);

          if (constrain) {
            this.constrainChild(cells[i]);
          }
        }

        if (this.isResetEdgesOnMove()) {
          this.resetEdges(cells);
        }

        this.fireEvent(new mxEventObject(mxEvent.CELLS_MOVED, "cells", cells, "dx", dx, "dy", dy,
            "disconnect", disconnect));
      } finally {
        this.model.endUpdate();
      }
    }
  }

  /**
   * Moves the given cells to the front or back. This method fires mxEvent.CELLS_ORDERED while the
   * transaction is in progress.
   *
   * @param cells Array of cells whose order should be changed.
   * @param back Specifies if the cells should be moved to back.
   */
  public void cellsOrdered(final Object[] cells, final boolean back) {
    if (cells != null) {
      this.model.beginUpdate();
      try {
        for (int i = 0; i < cells.length; i++) {
          final Object parent = this.model.getParent(cells[i]);

          if (back) {
            this.model.add(parent, cells[i], i);
          } else {
            this.model.add(parent, cells[i], this.model.getChildCount(parent) - 1);
          }
        }

        this.fireEvent(new mxEventObject(mxEvent.CELLS_ORDERED, "cells", cells, "back", back));
      } finally {
        this.model.endUpdate();
      }
    }
  }

  /**
   * Removes the given cells from the model. This method fires mxEvent.CELLS_REMOVED while the
   * transaction is in progress.
   *
   * @param cells Array of cells to remove.
   */
  public void cellsRemoved(final Object[] cells) {
    if (cells != null && cells.length > 0) {
      final double scale = this.view.getScale();
      final mxPoint tr = this.view.getTranslate();

      this.model.beginUpdate();
      try {
        for (int i = 0; i < cells.length; i++) {
          // Disconnects edges which are not in cells
          final Collection<Object> cellSet = new HashSet<Object>();
          cellSet.addAll(Arrays.asList(cells));
          final Object[] edges = this.getConnections(cells[i]);

          for (int j = 0; j < edges.length; j++) {
            if (!cellSet.contains(edges[j])) {
              mxGeometry geo = this.model.getGeometry(edges[j]);

              if (geo != null) {
                final mxCellState state = this.view.getState(edges[j]);

                if (state != null) {
                  // Checks which side of the edge is being disconnected
                  Object tmp = state.getVisibleTerminal(true);
                  boolean source = false;

                  while (tmp != null) {
                    if (cells[i] == tmp) {
                      source = true;
                      break;
                    }

                    tmp = this.model.getParent(tmp);
                  }

                  geo = (mxGeometry) geo.clone();
                  final int n = source ? 0 : state.getAbsolutePointCount() - 1;
                  final mxPoint pt = state.getAbsolutePoint(n);

                  geo.setTerminalPoint(
                      new mxPoint(pt.getX() / scale - tr.getX(), pt.getY() / scale - tr.getY()),
                      source);
                  this.model.setTerminal(edges[j], null, source);
                  this.model.setGeometry(edges[j], geo);
                }
              }
            }
          }

          this.model.remove(cells[i]);
        }

        this.fireEvent(new mxEventObject(mxEvent.CELLS_REMOVED, "cells", cells));
      } finally {
        this.model.endUpdate();
      }
    }
  }

  /**
   * Sets the bounds of the given cells and fires a <mxEvent.CELLS_RESIZED> event. If extendParents
   * is true, then the parent is extended if a child size is changed so that it overlaps with the
   * parent.
   *
   * @param cells Array of <mxCells> whose bounds should be changed.
   * @param bounds Array of <mxRectangles> that represents the new bounds.
   */
  public void cellsResized(final Object[] cells, final mxRectangle[] bounds) {
    if (cells != null && bounds != null && cells.length == bounds.length) {
      this.model.beginUpdate();
      try {
        for (int i = 0; i < cells.length; i++) {
          final mxRectangle tmp = bounds[i];
          mxGeometry geo = this.model.getGeometry(cells[i]);

          if (geo != null && (geo.getX() != tmp.getX() || geo.getY() != tmp.getY()
              || geo.getWidth() != tmp.getWidth() || geo.getHeight() != tmp.getHeight())) {
            geo = (mxGeometry) geo.clone();

            if (geo.isRelative()) {
              final mxPoint offset = geo.getOffset();

              if (offset != null) {
                offset.setX(offset.getX() + tmp.getX());
                offset.setY(offset.getY() + tmp.getY());
              }
            } else {
              geo.setX(tmp.getX());
              geo.setY(tmp.getY());
            }

            geo.setWidth(tmp.getWidth());
            geo.setHeight(tmp.getHeight());

            if (!geo.isRelative() && this.model.isVertex(cells[i])
                && !this.isAllowNegativeCoordinates()) {
              geo.setX(Math.max(0, geo.getX()));
              geo.setY(Math.max(0, geo.getY()));
            }

            this.model.setGeometry(cells[i], geo);

            if (this.isExtendParent(cells[i])) {
              this.extendParent(cells[i]);
            }
          }
        }

        if (this.isResetEdgesOnResize()) {
          this.resetEdges(cells);
        }

        // RENAME BOUNDSARRAY TO BOUNDS
        this.fireEvent(new mxEventObject(mxEvent.CELLS_RESIZED, "cells", cells, "bounds", bounds));
      } finally {
        this.model.endUpdate();
      }
    }
  }

  /**
   * Sets the visible state of the specified cells.
   *
   * @param cells Array of cells whose visible state should be changed.
   * @param show Boolean that specifies the visible state to be assigned.
   */
  public void cellsToggled(final Object[] cells, final boolean show) {
    if (cells != null && cells.length > 0) {
      this.model.beginUpdate();
      try {
        for (int i = 0; i < cells.length; i++) {
          this.model.setVisible(cells[i], show);
        }
      } finally {
        this.model.endUpdate();
      }
    }
  }

  /**
   *
   */
  public void clearSelection() {
    this.selectionModel.clear();
  }

  /**
   * Clones all cells in the given array. To clone all children in a cell and add them to another
   * graph:
   *
   * <code>
   * graph2.addCells(graph.cloneCells(new Object[] { parent }));
   * </code>
   *
   * To clone all children in a graph layer if graph g1 and put them into the default parent
   * (typically default layer) of another graph g2, the following code is used:
   *
   * <code>
   * g2.addCells(g1.cloneCells(g1.cloneCells(g1.getChildCells(g1.getDefaultParent()));
   * </code>
   */
  public Object[] cloneCells(final Object[] cells) {

    return this.cloneCells(cells, true);
  }

  /**
   * Returns the clones for the given cells. If the terminal of an edge is not in the given array,
   * then the respective end is assigned a terminal point and the terminal is removed. If a cloned
   * edge is invalid and allowInvalidEdges is false, then a null pointer will be at this position in
   * the returned array. Use getCloneableCells on the input array to only clone the cells where
   * isCellCloneable returns true.
   *
   * @param cells Array of mxCells to be cloned.
   * @return Returns the clones of the given cells.
   */
  public Object[] cloneCells(final Object[] cells, final boolean allowInvalidEdges) {
    Object[] clones = null;

    if (cells != null) {
      final Collection<Object> tmp = new LinkedHashSet<Object>(cells.length);
      tmp.addAll(Arrays.asList(cells));

      if (!tmp.isEmpty()) {
        final double scale = this.view.getScale();
        final mxPoint trans = this.view.getTranslate();
        clones = this.model.cloneCells(cells, true);

        for (int i = 0; i < cells.length; i++) {
          if (!allowInvalidEdges && this.model.isEdge(clones[i])
              && this.getEdgeValidationError(clones[i], this.model.getTerminal(clones[i], true),
                  this.model.getTerminal(clones[i], false)) != null) {
            clones[i] = null;
          } else {
            final mxGeometry g = this.model.getGeometry(clones[i]);

            if (g != null) {
              final mxCellState state = this.view.getState(cells[i]);
              final mxCellState pstate = this.view.getState(this.model.getParent(cells[i]));

              if (state != null && pstate != null) {
                final double dx = pstate.getOrigin().getX();
                final double dy = pstate.getOrigin().getY();

                if (this.model.isEdge(clones[i])) {
                  // Checks if the source is cloned or sets the terminal point
                  Object src = this.model.getTerminal(cells[i], true);

                  while (src != null && !tmp.contains(src)) {
                    src = this.model.getParent(src);
                  }

                  if (src == null) {
                    final mxPoint pt = state.getAbsolutePoint(0);
                    g.setTerminalPoint(new mxPoint(pt.getX() / scale - trans.getX(),
                        pt.getY() / scale - trans.getY()), true);
                  }

                  // Checks if the target is cloned or sets the terminal point
                  Object trg = this.model.getTerminal(cells[i], false);

                  while (trg != null && !tmp.contains(trg)) {
                    trg = this.model.getParent(trg);
                  }

                  if (trg == null) {
                    final mxPoint pt = state.getAbsolutePoint(state.getAbsolutePointCount() - 1);
                    g.setTerminalPoint(new mxPoint(pt.getX() / scale - trans.getX(),
                        pt.getY() / scale - trans.getY()), false);
                  }

                  // Translates the control points
                  final List<mxPoint> points = g.getPoints();

                  if (points != null) {
                    final Iterator<mxPoint> it = points.iterator();

                    while (it.hasNext()) {
                      final mxPoint pt = it.next();
                      pt.setX(pt.getX() + dx);
                      pt.setY(pt.getY() + dy);
                    }
                  }
                } else {
                  g.setX(g.getX() + dx);
                  g.setY(g.getY() + dy);
                }
              }
            }
          }
        }
      } else {
        clones = new Object[] {};
      }
    }

    return clones;
  }

  //
  // Cell alignment and orientation
  //

  /**
   * Connects the specified end of the given edge to the given terminal using cellConnected and
   * fires mxEvent.CONNECT_CELL while the transaction is in progress.
   */
  public Object connectCell(final Object edge, final Object terminal, final boolean source) {
    return this.connectCell(edge, terminal, source, null);
  }

  /**
   * Connects the specified end of the given edge to the given terminal using cellConnected and
   * fires mxEvent.CONNECT_CELL while the transaction is in progress.
   *
   * @param edge Edge whose terminal should be updated.
   * @param terminal New terminal to be used.
   * @param source Specifies if the new terminal is the source or target.
   * @param constraint Optional constraint to be used for this connection.
   * @return Returns the update edge.
   */
  public Object connectCell(final Object edge, final Object terminal, final boolean source,
      final mxConnectionConstraint constraint) {
    this.model.beginUpdate();
    try {
      final Object previous = this.model.getTerminal(edge, source);
      this.cellConnected(edge, terminal, source, constraint);
      this.fireEvent(new mxEventObject(mxEvent.CONNECT_CELL, "edge", edge, "terminal", terminal,
          "source", source, "previous", previous));
    } finally {
      this.model.endUpdate();
    }

    return edge;
  }

  /**
   * Keeps the given cell inside the bounds returned by getCellContainmentArea for its parent,
   * according to the rules defined by getOverlap and isConstrainChild. This modifies the cell's
   * geometry in-place and does not clone it.
   *
   * @param cell Cell which should be constrained.
   */
  public void constrainChild(final Object cell) {
    if (cell != null) {
      final mxGeometry geo = this.model.getGeometry(cell);
      final mxRectangle area = this.isConstrainChild(cell) ? this.getCellContainmentArea(cell)
          : this.getMaximumGraphBounds();

      if (geo != null && area != null) {
        // Keeps child within the content area of the parent
        if (!geo.isRelative() && (geo.getX() < area.getX() || geo.getY() < area.getY()
            || area.getWidth() < geo.getX() + geo.getWidth()
            || area.getHeight() < geo.getY() + geo.getHeight())) {
          final double overlap = this.getOverlap(cell);

          if (area.getWidth() > 0) {
            geo.setX(Math.min(geo.getX(),
                area.getX() + area.getWidth() - (1 - overlap) * geo.getWidth()));
          }

          if (area.getHeight() > 0) {
            geo.setY(Math.min(geo.getY(),
                area.getY() + area.getHeight() - (1 - overlap) * geo.getHeight()));
          }

          geo.setX(Math.max(geo.getX(), area.getX() - geo.getWidth() * overlap));
          geo.setY(Math.max(geo.getY(), area.getY() - geo.getHeight() * overlap));
        }
      }
    }
  }

  /**
   * Returns the textual representation for the given cell.
   *
   * @param cell Cell to be converted to a string.
   * @return Returns the textual representation of the cell.
   */
  public String convertValueToString(final Object cell) {
    final Object result = this.model.getValue(cell);

    return result != null ? result.toString() : "";
  }

  //
  // Order
  //

  /**
   * Hook method that creates the new edge for insertEdge. This implementation does not set the
   * source and target of the edge, these are set when the edge is added to the model.
   *
   * @param parent Cell that specifies the parent of the new edge.
   * @param id Optional string that defines the Id of the new edge.
   * @param value Object to be used as the user object.
   * @param source Cell that defines the source of the edge.
   * @param target Cell that defines the target of the edge.
   * @param style Optional string that defines the cell style.
   * @return Returns the new edge to be inserted.
   */
  public Object createEdge(final Object parent, final String id, final Object value,
      final Object source, final Object target, final String style) {
    final mxCell edge = new mxCell(value, new mxGeometry(), style);

    edge.setId(id);
    edge.setEdge(true);
    edge.getGeometry().setRelative(true);

    return edge;
  }

  /**
   * Constructs a new view to be used in this graph.
   */
  protected mxGraphView createGraphView() {
    return new mxGraphView(this);
  }

  /**
   * Hook for creating the group cell to hold the given array of <mxCells> if no group cell was
   * given to the <group> function. The children are just for informational purpose, they will be
   * added to the returned group later. Note that the returned group should have a geometry. The
   * coordinates of which are later overridden.
   *
   * @param cells
   * @return Returns a new group cell.
   */
  public Object createGroupCell(final Object[] cells) {
    final mxCell group = new mxCell("", new mxGeometry(), null);
    group.setVertex(true);
    group.setConnectable(false);

    return group;
  }

  //
  // Grouping
  //

  /**
   * Constructs a new selection model to be used in this graph.
   */
  protected mxGraphSelectionModel createSelectionModel() {
    return new mxGraphSelectionModel(this);
  }

  /**
   * Constructs a new stylesheet to be used in this graph.
   */
  protected mxStylesheet createStylesheet() {
    return new mxStylesheet();
  }

  /**
   * Hook method that creates the new vertex for insertVertex.
   *
   * @param parent Cell that specifies the parent of the new vertex.
   * @param id Optional string that defines the Id of the new vertex.
   * @param value Object to be used as the user object.
   * @param x Integer that defines the x coordinate of the vertex.
   * @param y Integer that defines the y coordinate of the vertex.
   * @param width Integer that defines the width of the vertex.
   * @param height Integer that defines the height of the vertex.
   * @param style Optional string that defines the cell style.
   * @return Returns the new vertex to be inserted.
   */
  public Object createVertex(final Object parent, final String id, final Object value,
      final double x, final double y, final double width, final double height, final String style) {
    return this.createVertex(parent, id, value, x, y, width, height, style, false);
  }

  /**
   * Hook method that creates the new vertex for insertVertex.
   *
   * @param parent Cell that specifies the parent of the new vertex.
   * @param id Optional string that defines the Id of the new vertex.
   * @param value Object to be used as the user object.
   * @param x Integer that defines the x coordinate of the vertex.
   * @param y Integer that defines the y coordinate of the vertex.
   * @param width Integer that defines the width of the vertex.
   * @param height Integer that defines the height of the vertex.
   * @param style Optional string that defines the cell style.
   * @param relative Specifies if the geometry should be relative.
   * @return Returns the new vertex to be inserted.
   */
  public Object createVertex(final Object parent, final String id, final Object value,
      final double x, final double y, final double width, final double height, final String style,
      final boolean relative) {
    final mxGeometry geometry = new mxGeometry(x, y, width, height);
    geometry.setRelative(relative);

    final mxCell vertex = new mxCell(value, geometry, style);
    vertex.setId(id);
    vertex.setVertex(true);
    vertex.setConnectable(true);

    return vertex;
  }

  /**
   * Disconnects the given edges from the terminals which are not in the given array.
   *
   * @param cells Array of <mxCells> to be disconnected.
   */
  public void disconnectGraph(final Object[] cells) {
    if (cells != null) {
      this.model.beginUpdate();
      try {
        final double scale = this.view.getScale();
        final mxPoint tr = this.view.getTranslate();

        // Prepares a hashtable for faster cell lookups
        final Set<Object> hash = new HashSet<Object>();

        for (int i = 0; i < cells.length; i++) {
          hash.add(cells[i]);
        }

        for (int i = 0; i < cells.length; i++) {
          if (this.model.isEdge(cells[i])) {
            mxGeometry geo = this.model.getGeometry(cells[i]);

            if (geo != null) {
              final mxCellState state = this.view.getState(cells[i]);
              final mxCellState pstate = this.view.getState(this.model.getParent(cells[i]));

              if (state != null && pstate != null) {
                geo = (mxGeometry) geo.clone();

                final double dx = -pstate.getOrigin().getX();
                final double dy = -pstate.getOrigin().getY();

                Object src = this.model.getTerminal(cells[i], true);

                if (src != null && this.isCellDisconnectable(cells[i], src, true)) {
                  while (src != null && !hash.contains(src)) {
                    src = this.model.getParent(src);
                  }

                  if (src == null) {
                    final mxPoint pt = state.getAbsolutePoint(0);
                    geo.setTerminalPoint(new mxPoint(pt.getX() / scale - tr.getX() + dx,
                        pt.getY() / scale - tr.getY() + dy), true);
                    this.model.setTerminal(cells[i], null, true);
                  }
                }

                Object trg = this.model.getTerminal(cells[i], false);

                if (trg != null && this.isCellDisconnectable(cells[i], trg, false)) {
                  while (trg != null && !hash.contains(trg)) {
                    trg = this.model.getParent(trg);
                  }

                  if (trg == null) {
                    final int n = state.getAbsolutePointCount() - 1;
                    final mxPoint pt = state.getAbsolutePoint(n);
                    geo.setTerminalPoint(new mxPoint(pt.getX() / scale - tr.getX() + dx,
                        pt.getY() / scale - tr.getY() + dy), false);
                    this.model.setTerminal(cells[i], null, false);
                  }
                }
              }

              this.model.setGeometry(cells[i], geo);
            }
          }
        }
      } finally {
        this.model.endUpdate();
      }
    }
  }

  /**
   * Draws the given cell and its descendants onto the specified canvas.
   *
   * @param canvas Canvas onto which the cell should be drawn.
   * @param cell Cell that should be drawn onto the canvas.
   */
  public void drawCell(final mxICanvas canvas, final Object cell) {
    this.drawState(canvas, this.getView().getState(cell), true);

    // Draws the children on top of their parent
    final int childCount = this.model.getChildCount(cell);

    for (int i = 0; i < childCount; i++) {
      final Object child = this.model.getChildAt(cell, i);
      this.drawCell(canvas, child);
    }
  }

  /**
   * Draws the graph onto the given canvas.
   *
   * @param canvas Canvas onto which the graph should be drawn.
   */
  public void drawGraph(final mxICanvas canvas) {
    this.drawCell(canvas, this.getModel().getRoot());
  }

  /**
   * Draws the cell state with the given label onto the canvas. No children or descendants are
   * painted here. This method invokes cellDrawn after the cell, but not its descendants have been
   * painted.
   *
   * @param canvas Canvas onto which the cell should be drawn.
   * @param state State of the cell to be drawn.
   * @param drawLabel Indicates if the label should be drawn.
   */
  public void drawState(final mxICanvas canvas, final mxCellState state, final boolean drawLabel) {
    final Object cell = state != null ? state.getCell() : null;

    if (cell != null && cell != this.view.getCurrentRoot() && cell != this.model.getRoot()
        && (this.model.isVertex(cell) || this.model.isEdge(cell))) {
      final Object obj = canvas.drawCell(state);
      Object lab = null;

      // Holds the current clipping region in case the label will
      // be clipped
      Shape clip = null;
      final Rectangle newClip = state.getRectangle();

      // Indirection for image canvas that contains a graphics canvas
      mxICanvas clippedCanvas = this.isLabelClipped(state.getCell()) ? canvas : null;

      if (clippedCanvas instanceof mxImageCanvas) {
        clippedCanvas = ((mxImageCanvas) clippedCanvas).getGraphicsCanvas();
        // TODO: Shift newClip to match the image offset
        // Point pt = ((mxImageCanvas) canvas).getTranslate();
        // newClip.translate(-pt.x, -pt.y);
      }

      if (clippedCanvas instanceof mxGraphics2DCanvas) {
        final Graphics g = ((mxGraphics2DCanvas) clippedCanvas).getGraphics();
        clip = g.getClip();

        // Ensure that our new clip resides within our old clip
        if (clip instanceof Rectangle) {
          g.setClip(newClip.intersection((Rectangle) clip));
        }
        // Otherwise, default to original implementation
        else {
          g.setClip(newClip);
        }
      }

      if (drawLabel) {
        final String label = state.getLabel();

        if (label != null && state.getLabelBounds() != null) {
          lab = canvas.drawLabel(label, state, this.isHtmlLabel(cell));
        }
      }

      // Restores the previous clipping region
      if (clippedCanvas instanceof mxGraphics2DCanvas) {
        ((mxGraphics2DCanvas) clippedCanvas).getGraphics().setClip(clip);
      }

      // Invokes the cellDrawn callback with the object which was created
      // by the canvas to represent the cell graphically
      if (obj != null) {
        this.cellDrawn(canvas, state, obj, lab);
      }
    }
  }

  /**
   *
   */
  public void enterGroup() {
    this.enterGroup(null);
  }

  /**
   * Uses the given cell as the root of the displayed cell hierarchy. If no cell is specified then
   * the selection cell is used. The cell is only used if <isValidRoot> returns true.
   *
   * @param cell
   */
  public void enterGroup(Object cell) {
    if (cell == null) {
      cell = this.getSelectionCell();
    }

    if (cell != null && this.isValidRoot(cell)) {
      this.view.setCurrentRoot(cell);
      this.clearSelection();
    }
  }

  /**
   * Changes the current root to the next valid root in the displayed cell hierarchy.
   */
  public void exitGroup() {
    final Object root = this.model.getRoot();
    final Object current = this.getCurrentRoot();

    if (current != null) {
      Object next = this.model.getParent(current);

      // Finds the next valid root in the hierarchy
      while (next != root && !this.isValidRoot(next) && this.model.getParent(next) != root) {
        next = this.model.getParent(next);
      }

      // Clears the current root if the new root is
      // the model's root or one of the layers.
      if (next == root || this.model.getParent(next) == root) {
        this.view.setCurrentRoot(null);
      } else {
        this.view.setCurrentRoot(next);
      }

      final mxCellState state = this.view.getState(current);

      // Selects the previous root in the graph
      if (state != null) {
        this.setSelectionCell(current);
      }
    }
  }

  /**
   * Resizes the parents recursively so that they contain the complete area of the resized child
   * cell.
   *
   * @param cell <mxCell> that has been resized.
   */
  public void extendParent(final Object cell) {
    if (cell != null) {
      final Object parent = this.model.getParent(cell);
      mxGeometry p = this.model.getGeometry(parent);

      if (parent != null && p != null && !this.isCellCollapsed(parent)) {
        final mxGeometry geo = this.model.getGeometry(cell);

        if (geo != null && (p.getWidth() < geo.getX() + geo.getWidth()
            || p.getHeight() < geo.getY() + geo.getHeight())) {
          p = (mxGeometry) p.clone();

          p.setWidth(Math.max(p.getWidth(), geo.getX() + geo.getWidth()));
          p.setHeight(Math.max(p.getHeight(), geo.getY() + geo.getHeight()));

          this.cellsResized(new Object[] {parent}, new mxRectangle[] {p});
        }
      }
    }
  }

  /**
   * Returns all visible children in the given parent which do not have incoming edges. If the
   * result is empty then the with the greatest difference between incoming and outgoing edges is
   * returned. This takes into account edges that are being promoted to the given root due to
   * invisible children or collapsed cells.
   *
   * @param parent Cell whose children should be checked.
   * @return List of tree roots in parent.
   */
  public List<Object> findTreeRoots(final Object parent) {
    return this.findTreeRoots(parent, false);
  }

  /**
   * Returns all visible children in the given parent which do not have incoming edges. If the
   * result is empty then the children with the maximum difference between incoming and outgoing
   * edges are returned. This takes into account edges that are being promoted to the given root due
   * to invisible children or collapsed cells.
   *
   * @param parent Cell whose children should be checked.
   * @param isolate Specifies if edges should be ignored if the opposite end is not a child of the
   *        given parent cell.
   * @return List of tree roots in parent.
   */
  public List<Object> findTreeRoots(final Object parent, final boolean isolate) {
    return this.findTreeRoots(parent, isolate, false);
  }

  /**
   * Returns all visible children in the given parent which do not have incoming edges. If the
   * result is empty then the children with the maximum difference between incoming and outgoing
   * edges are returned. This takes into account edges that are being promoted to the given root due
   * to invisible children or collapsed cells.
   *
   * @param parent Cell whose children should be checked.
   * @param isolate Specifies if edges should be ignored if the opposite end is not a child of the
   *        given parent cell.
   * @param invert Specifies if outgoing or incoming edges should be counted for a tree root. If
   *        false then outgoing edges will be counted.
   * @return List of tree roots in parent.
   */
  public List<Object> findTreeRoots(final Object parent, final boolean isolate,
      final boolean invert) {
    final List<Object> roots = new ArrayList<Object>();

    if (parent != null) {
      final int childCount = this.model.getChildCount(parent);
      Object best = null;
      int maxDiff = 0;

      for (int i = 0; i < childCount; i++) {
        final Object cell = this.model.getChildAt(parent, i);

        if (this.model.isVertex(cell) && this.isCellVisible(cell)) {
          final Object[] conns = this.getConnections(cell, isolate ? parent : null);
          int fanOut = 0;
          int fanIn = 0;

          for (int j = 0; j < conns.length; j++) {
            final Object src = this.view.getVisibleTerminal(conns[j], true);

            if (src == cell) {
              fanOut++;
            } else {
              fanIn++;
            }
          }

          if (invert && fanOut == 0 && fanIn > 0 || !invert && fanIn == 0 && fanOut > 0) {
            roots.add(cell);
          }

          final int diff = invert ? fanIn - fanOut : fanOut - fanIn;

          if (diff > maxDiff) {
            maxDiff = diff;
            best = cell;
          }
        }
      }

      if (roots.isEmpty() && best != null) {
        roots.add(best);
      }
    }

    return roots;
  }

  //
  // Cell cloning, insertion and removal
  //

  /**
   * Called when the main control point of the edge is double-clicked. This implementation switches
   * between null (default) and alternateEdgeStyle and resets the edges control points. Finally, a
   * flip event is fired before endUpdate is called on the model.
   *
   * @param edge Cell that represents the edge to be flipped.
   * @return Returns the edge that has been flipped.
   */
  public Object flipEdge(final Object edge) {
    if (edge != null && this.alternateEdgeStyle != null) {
      this.model.beginUpdate();
      try {
        final String style = this.model.getStyle(edge);

        if (style == null || style.length() == 0) {
          this.model.setStyle(edge, this.alternateEdgeStyle);
        } else {
          this.model.setStyle(edge, null);
        }

        // Removes all existing control points
        this.resetEdge(edge);
        this.fireEvent(new mxEventObject(mxEvent.FLIP_EDGE, "edge", edge));
      } finally {
        this.model.endUpdate();
      }
    }

    return edge;
  }

  /**
   * Sets the collapsed state of the selection cells without recursion. This is a shortcut method.
   *
   * @param collapse Boolean that specifies the collapsed state to be assigned.
   * @return Returns the cells whose collapsed state was changed.
   */
  public Object[] foldCells(final boolean collapse) {
    return this.foldCells(collapse, false);
  }

  /**
   * Sets the collapsed state of the selection cells. This is a shortcut method.
   *
   * @param collapse Boolean that specifies the collapsed state to be assigned.
   * @param recurse Boolean that specifies if the collapsed state should be assigned to all
   *        descendants.
   * @return Returns the cells whose collapsed state was changed.
   */
  public Object[] foldCells(final boolean collapse, final boolean recurse) {
    return this.foldCells(collapse, recurse, null);
  }

  /**
   * Invokes foldCells with checkFoldable set to false.
   */
  public Object[] foldCells(final boolean collapse, final boolean recurse, final Object[] cells) {
    return this.foldCells(collapse, recurse, cells, false);
  }

  /**
   * Sets the collapsed state of the specified cells and all descendants if recurse is true. The
   * change is carried out using cellsFolded. This method fires mxEvent.FOLD_CELLS while the
   * transaction is in progress. Returns the cells whose collapsed state was changed.
   *
   * @param collapse Boolean indicating the collapsed state to be assigned.
   * @param recurse Boolean indicating if the collapsed state of all descendants should be set.
   * @param cells Array of cells whose collapsed state should be set. If null is specified then the
   *        foldable selection cells are used.
   * @param checkFoldable Boolean indicating of isCellFoldable should be checked. Default is false.
   */
  public Object[] foldCells(final boolean collapse, final boolean recurse, Object[] cells,
      final boolean checkFoldable) {
    if (cells == null) {
      cells = this.getFoldableCells(this.getSelectionCells(), collapse);
    }

    this.model.beginUpdate();
    try {
      this.cellsFolded(cells, collapse, recurse, checkFoldable);
      this.fireEvent(new mxEventObject(mxEvent.FOLD_CELLS, "cells", cells, "collapse", collapse,
          "recurse", recurse));
    } finally {
      this.model.endUpdate();
    }

    return cells;
  }

  /**
   * Returns an array of all constraints for the given terminal.
   *
   * @param terminal Cell state that represents the terminal.
   * @param source Specifies if the terminal is the source or target.
   */
  public mxConnectionConstraint[] getAllConnectionConstraints(final mxCellState terminal,
      final boolean source) {
    return null;
  }

  /**
   * Returns all edges connected to the given cells or their descendants.
   */
  public Object[] getAllEdges(final Object[] cells) {
    final List<Object> edges = new ArrayList<Object>();

    if (cells != null) {
      for (int i = 0; i < cells.length; i++) {
        final int edgeCount = this.model.getEdgeCount(cells[i]);

        for (int j = 0; j < edgeCount; j++) {
          edges.add(this.model.getEdgeAt(cells[i], j));
        }

        // Recurses
        final Object[] children = mxGraphModel.getChildren(this.model, cells[i]);
        edges.addAll(Arrays.asList(this.getAllEdges(children)));
      }
    }

    return edges.toArray();
  }

  /**
   * Returns alternateEdgeStyle.
   */
  public String getAlternateEdgeStyle() {
    return this.alternateEdgeStyle;
  }

  /**
   * Returns the value of <border>.
   *
   * @return Returns the border.
   */
  public int getBorder() {
    return this.border;
  }

  /**
   * Returns the bounds of the given cell.
   */
  public mxRectangle getBoundingBox(final Object cell) {
    return this.getBoundingBox(cell, false);
  }

  /**
   * Returns the bounding box of the given cell including all connected edges if includeEdge is
   * true.
   */
  public mxRectangle getBoundingBox(final Object cell, final boolean includeEdges) {
    return this.getBoundingBox(cell, includeEdges, false);
  }

  /**
   * Returns the bounding box of the given cell including all connected edges if includeEdge is
   * true.
   */
  public mxRectangle getBoundingBox(final Object cell, final boolean includeEdges,
      final boolean includeDescendants) {
    return this.getCellBounds(cell, includeEdges, includeDescendants, true);
  }

  /**
   * Returns the bounding box for the geometries of the vertices in the given array of cells.
   */
  public mxRectangle getBoundingBoxFromGeometry(final Object[] cells) {
    mxRectangle result = null;

    if (cells != null) {
      for (int i = 0; i < cells.length; i++) {
        if (this.getModel().isVertex(cells[i])) {
          final mxGeometry geo = this.getCellGeometry(cells[i]);

          if (result == null) {
            result = new mxRectangle(geo);
          } else {
            result.add(geo);
          }
        }
      }
    }

    return result;
  }

  /**
   * Returns the bounds for the given cells.
   */
  public mxRectangle getBoundsForCells(final Object[] cells, final boolean includeEdges,
      final boolean includeDescendants, final boolean boundingBox) {
    mxRectangle result = null;

    if (cells != null && cells.length > 0) {
      for (int i = 0; i < cells.length; i++) {
        final mxRectangle tmp =
            this.getCellBounds(cells[i], includeEdges, includeDescendants, boundingBox);

        if (tmp != null) {
          if (result == null) {
            result = new mxRectangle(tmp);
          } else {
            result.add(tmp);
          }
        }
      }
    }

    return result;
  }

  /**
   * Returns the bounds to be used for the given group and children. This implementation computes
   * the bounding box of the geometries of all vertices in the given children array. Edges are
   * ignored. If the group cell is a swimlane the title region is added to the bounds.
   */
  public mxRectangle getBoundsForGroup(final Object group, final Object[] children,
      final double border) {
    final mxRectangle result = this.getBoundingBoxFromGeometry(children);

    if (result != null) {
      if (this.isSwimlane(group)) {
        final mxRectangle size = this.getStartSize(group);

        result.setX(result.getX() - size.getWidth());
        result.setY(result.getY() - size.getHeight());
        result.setWidth(result.getWidth() + size.getWidth());
        result.setHeight(result.getHeight() + size.getHeight());
      }

      // Adds the border
      result.setX(result.getX() - border);
      result.setY(result.getY() - border);
      result.setWidth(result.getWidth() + 2 * border);
      result.setHeight(result.getHeight() + 2 * border);
    }

    return result;
  }

  /**
   * Returns the bounds of the given cell.
   */
  public mxRectangle getCellBounds(final Object cell) {
    return this.getCellBounds(cell, false);
  }

  /**
   * Returns the bounds of the given cell including all connected edges if includeEdge is true.
   */
  public mxRectangle getCellBounds(final Object cell, final boolean includeEdges) {
    return this.getCellBounds(cell, includeEdges, false);
  }

  /**
   * Returns the bounds of the given cell including all connected edges if includeEdge is true.
   */
  public mxRectangle getCellBounds(final Object cell, final boolean includeEdges,
      final boolean includeDescendants) {
    return this.getCellBounds(cell, includeEdges, includeDescendants, false);
  }

  /**
   * Returns the bounds of the given cell including all connected edges if includeEdge is true.
   */
  public mxRectangle getCellBounds(final Object cell, final boolean includeEdges,
      final boolean includeDescendants, final boolean boundingBox) {
    Object[] cells;

    // Recursively includes connected edges
    if (includeEdges) {
      final Set<Object> allCells = new HashSet<Object>();
      allCells.add(cell);

      Set<Object> edges = new HashSet<Object>(Arrays.asList(this.getEdges(cell)));

      while (!edges.isEmpty() && !allCells.containsAll(edges)) {
        allCells.addAll(edges);

        final Set<Object> tmp = new HashSet<Object>();
        final Iterator<Object> it = edges.iterator();

        while (it.hasNext()) {
          final Object edge = it.next();
          tmp.addAll(Arrays.asList(this.getEdges(edge)));
        }

        edges = tmp;
      }

      cells = allCells.toArray();
    } else {
      cells = new Object[] {cell};
    }

    mxRectangle result = this.view.getBounds(cells, boundingBox);

    // Recursively includes the bounds of the children
    if (includeDescendants) {
      for (int i = 0; i < cells.length; i++) {
        final int childCount = this.model.getChildCount(cells[i]);

        for (int j = 0; j < childCount; j++) {
          final mxRectangle tmp = this.getCellBounds(this.model.getChildAt(cells[i], j),
              includeEdges, true, boundingBox);

          if (result != null) {
            result.add(tmp);
          } else {
            result = tmp;
          }
        }
      }
    }

    return result;
  }

  /**
   * Returns the mxRectangle inside which a cell is to be kept.
   */
  public mxRectangle getCellContainmentArea(final Object cell) {
    if (cell != null && !this.model.isEdge(cell)) {
      final Object parent = this.model.getParent(cell);

      if (parent == this.getDefaultParent() || parent == this.getCurrentRoot()) {
        return this.getMaximumGraphBounds();
      } else if (parent != null && parent != this.getDefaultParent()) {
        final mxGeometry g = this.model.getGeometry(parent);

        if (g != null) {
          double x = 0;
          double y = 0;
          double w = g.getWidth();
          double h = g.getHeight();

          if (this.isSwimlane(parent)) {
            final mxRectangle size = this.getStartSize(parent);

            x = size.getWidth();
            w -= size.getWidth();
            y = size.getHeight();
            h -= size.getHeight();
          }

          return new mxRectangle(x, y, w, h);
        }
      }
    }

    return null;
  }

  /**
   * Returns the geometry for the given cell.
   *
   * @param cell Cell whose geometry should be returned.
   * @return Returns the geometry of the cell.
   */
  public mxGeometry getCellGeometry(final Object cell) {
    return this.model.getGeometry(cell);
  }

  /**
   * Returns the children of the given parent that are contained in the halfpane from the given
   * point (x0, y0) rightwards and downwards depending on rightHalfpane and bottomHalfpane.
   *
   * @param x0 X-coordinate of the origin.
   * @param y0 Y-coordinate of the origin.
   * @param parent <mxCell> whose children should be checked.
   * @param rightHalfpane Boolean indicating if the cells in the right halfpane from the origin
   *        should be returned.
   * @param bottomHalfpane Boolean indicating if the cells in the bottom halfpane from the origin
   *        should be returned.
   * @return Returns the cells beyond the given halfpane.
   */
  public Object[] getCellsBeyond(final double x0, final double y0, Object parent,
      final boolean rightHalfpane, final boolean bottomHalfpane) {
    if (parent == null) {
      parent = this.getDefaultParent();
    }

    final int childCount = this.model.getChildCount(parent);
    final List<Object> result = new ArrayList<Object>(childCount);

    if (rightHalfpane || bottomHalfpane) {

      if (parent != null) {
        for (int i = 0; i < childCount; i++) {
          final Object child = this.model.getChildAt(parent, i);
          final mxCellState state = this.view.getState(child);

          if (this.isCellVisible(child) && state != null) {
            if ((!rightHalfpane || state.getX() >= x0) && (!bottomHalfpane || state.getY() >= y0)) {
              result.add(child);
            }
          }
        }
      }
    }

    return result.toArray();
  }

  /**
   * Returns the cells with the same parent as the first cell in the given array.
   */
  public Object[] getCellsForGroup(final Object[] cells) {
    final List<Object> result = new ArrayList<Object>(cells.length);

    if (cells.length > 0) {
      final Object parent = this.model.getParent(cells[0]);
      result.add(cells[0]);

      // Filters selection cells with the same parent
      for (int i = 1; i < cells.length; i++) {
        if (this.model.getParent(cells[i]) == parent) {
          result.add(cells[i]);
        }
      }
    }

    return result.toArray();
  }

  /**
   * Returns an array of key, value pairs representing the cell style for the given cell. If no
   * string is defined in the model that specifies the style, then the default style for the cell is
   * returned or <EMPTY_ARRAY>, if not style can be found.
   *
   * @param cell Cell whose style should be returned.
   * @return Returns the style of the cell.
   */
  public Map<String, Object> getCellStyle(final Object cell) {
    Map<String, Object> style = this.model.isEdge(cell) ? this.stylesheet.getDefaultEdgeStyle()
        : this.stylesheet.getDefaultVertexStyle();

    final String name = this.model.getStyle(cell);

    if (name != null) {
      style = this.postProcessCellStyle(this.stylesheet.getCellStyle(name, style));
    }

    if (style == null) {
      style = mxStylesheet.EMPTY_STYLE;
    }

    return style;
  }

  /**
   * Checks all multiplicities that cannot be enforced while the graph is being modified, namely,
   * all multiplicities that require a minimum of 1 edge.
   *
   * @param cell Cell for which the multiplicities should be checked.
   */
  public String getCellValidationError(final Object cell) {
    final int outCount = mxGraphModel.getDirectedEdgeCount(this.model, cell, true);
    final int inCount = mxGraphModel.getDirectedEdgeCount(this.model, cell, false);
    final StringBuffer error = new StringBuffer();
    final Object value = this.model.getValue(cell);

    if (this.multiplicities != null) {
      for (int i = 0; i < this.multiplicities.length; i++) {
        final mxMultiplicity rule = this.multiplicities[i];
        final int max = rule.getMaxValue();

        if (rule.source && mxUtils.isNode(value, rule.type, rule.attr, rule.value)
            && (max == 0 && outCount > 0 || rule.min == 1 && outCount == 0
                || max == 1 && outCount > 1)) {
          error.append(rule.countError + '\n');
        } else if (!rule.source && mxUtils.isNode(value, rule.type, rule.attr, rule.value)
            && (max == 0 && inCount > 0 || rule.min == 1 && inCount == 0
                || max == 1 && inCount > 1)) {
          error.append(rule.countError + '\n');
        }
      }
    }

    return error.length() > 0 ? error.toString() : null;
  }

  /**
   * @return Returns changesRepaintThreshold.
   */
  public int getChangesRepaintThreshold() {
    return this.changesRepaintThreshold;
  }

  /**
   * Returns the visible children of the given parent.
   *
   * @param parent Cell whose children should be returned.
   */
  public Object[] getChildCells(final Object parent) {
    return this.getChildCells(parent, false, false);
  }

  //
  // Cell visibility
  //

  /**
   * Returns the visible child vertices or edges in the given parent. If vertices and edges is
   * false, then all children are returned.
   *
   * @param parent Cell whose children should be returned.
   * @param vertices Specifies if child vertices should be returned.
   * @param edges Specifies if child edges should be returned.
   * @return Returns the child vertices and edges.
   */
  public Object[] getChildCells(final Object parent, final boolean vertices, final boolean edges) {
    final Object[] cells = mxGraphModel.getChildCells(this.model, parent, vertices, edges);
    final List<Object> result = new ArrayList<Object>(cells.length);

    // Filters out the non-visible child cells
    for (int i = 0; i < cells.length; i++) {
      if (this.isCellVisible(cells[i])) {
        result.add(cells[i]);
      }
    }

    return result.toArray();
  }

  /**
   * Returns the visible child edges of the given parent.
   *
   * @param parent Cell whose children should be returned.
   */
  public Object[] getChildEdges(final Object parent) {
    return this.getChildCells(parent, false, true);
  }

  /**
   * Returns the offset to be used for the cells inside the given cell. The root and layer cells may
   * be identified using mxGraphModel.isRoot and mxGraphModel.isLayer. This implementation returns
   * null.
   *
   * @param cell Cell whose offset should be returned.
   * @return Returns the child offset for the given cell.
   */
  public mxPoint getChildOffsetForCell(final Object cell) {
    return null;
  }

  /**
   * Returns the visible child vertices of the given parent.
   *
   * @param parent Cell whose children should be returned.
   */
  public Object[] getChildVertices(final Object parent) {
    return this.getChildCells(parent, true, false);
  }

  //
  // Folding
  //

  /**
   * Returns the cells which are movable in the given array of cells.
   */
  public Object[] getCloneableCells(final Object[] cells) {
    return mxGraphModel.filterCells(cells, new Filter() {
      @Override
      public boolean filter(final Object cell) {
        return mxGraph.this.isCellCloneable(cell);
      }
    });
  }

  /**
   * Returns an connection constraint that describes the given connection point. This result can
   * then be passed to getConnectionPoint.
   *
   * @param edge Cell state that represents the edge.
   * @param terminal Cell state that represents the terminal.
   * @param source Boolean indicating if the terminal is the source or target.
   */
  public mxConnectionConstraint getConnectionConstraint(final mxCellState edge,
      final mxCellState terminal, final boolean source) {
    mxPoint point = null;
    final Object x =
        edge.getStyle().get(source ? mxConstants.STYLE_EXIT_X : mxConstants.STYLE_ENTRY_X);

    if (x != null) {
      final Object y =
          edge.getStyle().get(source ? mxConstants.STYLE_EXIT_Y : mxConstants.STYLE_ENTRY_Y);

      if (y != null) {
        point = new mxPoint(Double.parseDouble(x.toString()), Double.parseDouble(y.toString()));
      }
    }

    boolean perimeter = false;

    if (point != null) {
      perimeter = mxUtils.isTrue(edge.style,
          source ? mxConstants.STYLE_EXIT_PERIMETER : mxConstants.STYLE_ENTRY_PERIMETER, true);
    }

    return new mxConnectionConstraint(point, perimeter);
  }

  /**
   * Sets the connection constraint that describes the given connection point. If no constraint is
   * given then nothing is changed. To remove an existing constraint from the given edge, use an
   * empty constraint instead.
   *
   * @param vertex Cell state that represents the vertex.
   * @param constraint Connection constraint that represents the connection point constraint as
   *        returned by getConnectionConstraint.
   */
  public mxPoint getConnectionPoint(final mxCellState vertex,
      final mxConnectionConstraint constraint) {
    mxPoint point = null;

    if (vertex != null && constraint.point != null) {
      point = new mxPoint(vertex.getX() + constraint.getPoint().getX() * vertex.getWidth(),
          vertex.getY() + constraint.getPoint().getY() * vertex.getHeight());
    }

    if (point != null && constraint.perimeter) {
      point = this.view.getPerimeterPoint(vertex, point, false);
    }

    return point;
  }

  /**
   * Returns all visible edges connected to the given cell without loops.
   *
   * @param cell Cell whose connections should be returned.
   * @return Returns the connected edges for the given cell.
   */
  public Object[] getConnections(final Object cell) {
    return this.getConnections(cell, null);
  }

  /**
   * Returns all visible edges connected to the given cell without loops. If the optional parent
   * argument is specified, then only child edges of the given parent are returned.
   *
   * @param cell Cell whose connections should be returned.
   * @param parent Optional parent of the opposite end for a connection to be returned.
   * @return Returns the connected edges for the given cell.
   */
  public Object[] getConnections(final Object cell, final Object parent) {
    return this.getConnections(cell, parent, false);
  }

  /**
   * Returns all visible edges connected to the given cell without loops. If the optional parent
   * argument is specified, then only child edges of the given parent are returned.
   *
   * @param cell Cell whose connections should be returned.
   * @param parent Optional parent of the opposite end for a connection to be returned.
   * @return Returns the connected edges for the given cell.
   */
  public Object[] getConnections(final Object cell, final Object parent, final boolean recurse) {
    return this.getEdges(cell, parent, true, true, false, recurse);
  }

  /**
   * Returns the current root of the displayed cell hierarchy. This is a shortcut to
   * <mxGraphView.currentRoot> in <view>.
   *
   * @return Returns the current root in the view.
   */
  public Object getCurrentRoot() {
    return this.view.getCurrentRoot();
  }

  /**
   * Returns the default edge style used for loops.
   *
   * @return Returns the default loop style.
   */
  public mxEdgeStyle.mxEdgeStyleFunction getDefaultLoopStyle() {
    return this.defaultLoopStyle;
  }

  /**
   * Gets defaultOverlap.
   */
  public double getDefaultOverlap() {
    return this.defaultOverlap;
  }

  /**
   * Returns the first child of the root in the model, that is, the first or default layer of the
   * diagram.
   *
   * @return Returns the default parent for new cells.
   */
  public Object getDefaultParent() {
    Object parent = this.defaultParent;

    if (parent == null) {
      parent = this.view.getCurrentRoot();

      if (parent == null) {
        final Object root = this.model.getRoot();
        parent = this.model.getChildAt(root, 0);
      }
    }

    return parent;
  }

  //
  // Cell sizing
  //

  /**
   * Returns the cells which are movable in the given array of cells.
   */
  public Object[] getDeletableCells(final Object[] cells) {
    return mxGraphModel.filterCells(cells, new Filter() {
      @Override
      public boolean filter(final Object cell) {
        return mxGraph.this.isCellDeletable(cell);
      }
    });
  }

  /**
   * Returns the given cell if it is a drop target for the given cells or the nearest ancestor that
   * may be used as a drop target for the given cells. If the given array contains a swimlane and
   * swimlaneNesting is false then this always returns null. If no cell is given, then the
   * bottommost swimlane at the location of the given event is returned.
   *
   * This function should only be used if isDropEnabled returns true.
   */
  public Object getDropTarget(final Object[] cells, final Point pt, Object cell) {
    if (!this.isSwimlaneNesting()) {
      for (int i = 0; i < cells.length; i++) {
        if (this.isSwimlane(cells[i])) {
          return null;
        }
      }
    }

    // FIXME the else below does nothing if swimlane is null
    final Object swimlane = null; // getSwimlaneAt(pt.x, pt.y);

    if (cell == null) {
      cell = swimlane;
    }
    /*
     * else if (swimlane != null) { // Checks if the cell is an ancestor of the swimlane // under
     * the mouse and uses the swimlane in that case Object tmp = model.getParent(swimlane);
     *
     * while (tmp != null && isSwimlane(tmp) && tmp != cell) { tmp = model.getParent(tmp); }
     *
     * if (tmp == cell) { cell = swimlane; } }
     */

    while (cell != null && !this.isValidDropTarget(cell, cells)
        && this.model.getParent(cell) != this.model.getRoot()) {
      cell = this.model.getParent(cell);
    }

    return this.model.getParent(cell) != this.model.getRoot() && !mxUtils.contains(cells, cell)
        ? cell : null;
  }

  /**
   * Returns all visible edges connected to the given cell including loops.
   *
   * @param cell Cell whose edges should be returned.
   * @return Returns the edges of the given cell.
   */
  public Object[] getEdges(final Object cell) {
    return this.getEdges(cell, null);
  }

  /**
   * Returns all visible edges connected to the given cell including loops.
   *
   * @param cell Cell whose edges should be returned.
   * @param parent Optional parent of the opposite end for an edge to be returned.
   * @return Returns the edges of the given cell.
   */
  public Object[] getEdges(final Object cell, final Object parent) {
    return this.getEdges(cell, parent, true, true, true);
  }

  /**
   * Returns the incoming and/or outgoing edges for the given cell. If the optional parent argument
   * is specified, then only edges are returned where the opposite is in the given parent cell.
   *
   * @param cell Cell whose edges should be returned.
   * @param parent Optional parent. If specified the opposite end of any edge must be a direct child
   *        of that parent in order for the edge to be returned.
   * @param incoming Specifies if incoming edges should be included in the result.
   * @param outgoing Specifies if outgoing edges should be included in the result.
   * @param includeLoops Specifies if loops should be included in the result.
   * @return Returns the edges connected to the given cell.
   */
  public Object[] getEdges(final Object cell, final Object parent, final boolean incoming,
      final boolean outgoing, final boolean includeLoops) {
    return this.getEdges(cell, parent, incoming, outgoing, includeLoops, false);
  }

  /**
   * Returns the incoming and/or outgoing edges for the given cell. If the optional parent argument
   * is specified, then only edges are returned where the opposite is in the given parent cell.
   *
   * @param cell Cell whose edges should be returned.
   * @param parent Optional parent. If specified the opposite end of any edge must be a child of
   *        that parent in order for the edge to be returned. The recurse parameter specifies
   *        whether or not it must be the direct child or the parent just be an ancestral parent.
   * @param incoming Specifies if incoming edges should be included in the result.
   * @param outgoing Specifies if outgoing edges should be included in the result.
   * @param includeLoops Specifies if loops should be included in the result.
   * @param recurse Specifies if the parent specified only need be an ancestral parent,
   *        <code>true</code>, or the direct parent, <code>false</code>
   * @return Returns the edges connected to the given cell.
   */
  public Object[] getEdges(final Object cell, final Object parent, final boolean incoming,
      final boolean outgoing, final boolean includeLoops, final boolean recurse) {
    final boolean isCollapsed = this.isCellCollapsed(cell);
    final List<Object> edges = new ArrayList<Object>();
    final int childCount = this.model.getChildCount(cell);

    for (int i = 0; i < childCount; i++) {
      final Object child = this.model.getChildAt(cell, i);

      if (isCollapsed || !this.isCellVisible(child)) {
        edges.addAll(Arrays
            .asList(mxGraphModel.getEdges(this.model, child, incoming, outgoing, includeLoops)));
      }
    }

    edges.addAll(
        Arrays.asList(mxGraphModel.getEdges(this.model, cell, incoming, outgoing, includeLoops)));
    final List<Object> result = new ArrayList<Object>(edges.size());
    final Iterator<Object> it = edges.iterator();

    while (it.hasNext()) {
      final Object edge = it.next();
      final mxCellState state = this.view.getState(edge);
      final Object source =
          state != null ? state.getVisibleTerminal(true) : this.view.getVisibleTerminal(edge, true);
      final Object target = state != null ? state.getVisibleTerminal(false)
          : this.view.getVisibleTerminal(edge, false);

      if (includeLoops && source == target || source != target && (incoming && target == cell
          && (parent == null || this.isValidAncestor(source, parent, recurse))
          || outgoing && source == cell
              && (parent == null || this.isValidAncestor(target, parent, recurse)))) {
        result.add(edge);
      }
    }

    return result.toArray();
  }

  /**
   * Returns the edges between the given source and target. This takes into account collapsed and
   * invisible cells and returns the connected edges as displayed on the screen.
   *
   * @param source
   * @param target
   * @return Returns all edges between the given terminals.
   */
  public Object[] getEdgesBetween(final Object source, final Object target) {
    return this.getEdgesBetween(source, target, false);
  }

  /**
   * Returns the edges between the given source and target. This takes into account collapsed and
   * invisible cells and returns the connected edges as displayed on the screen.
   *
   * @param source
   * @param target
   * @param directed
   * @return Returns all edges between the given terminals.
   */
  public Object[] getEdgesBetween(final Object source, final Object target,
      final boolean directed) {
    final Object[] edges = this.getEdges(source);
    final List<Object> result = new ArrayList<Object>(edges.length);

    // Checks if the edge is connected to the correct
    // cell and adds any match to the result
    for (int i = 0; i < edges.length; i++) {
      final mxCellState state = this.view.getState(edges[i]);
      final Object src = state != null ? state.getVisibleTerminal(true)
          : this.view.getVisibleTerminal(edges[i], true);
      final Object trg = state != null ? state.getVisibleTerminal(false)
          : this.view.getVisibleTerminal(edges[i], false);

      if (src == source && trg == target || !directed && src == target && trg == source) {
        result.add(edges[i]);
      }
    }

    return result.toArray();
  }

  //
  // Cell moving
  //

  /**
   * Returns the validation error message to be displayed when inserting or changing an edges'
   * connectivity. A return value of null means the edge is valid, a return value of '' means it's
   * not valid, but do not display an error message. Any other (non-empty) string returned from this
   * method is displayed as an error message when trying to connect an edge to a source and target.
   * This implementation uses the multiplicities, as well as multigraph and allowDanglingEdges to
   * generate validation errors.
   *
   * @param edge Cell that represents the edge to validate.
   * @param source Cell that represents the source terminal.
   * @param target Cell that represents the target terminal.
   */
  public String getEdgeValidationError(final Object edge, final Object source,
      final Object target) {
    if (edge != null && !this.isAllowDanglingEdges() && (source == null || target == null)) {
      return "";
    }

    if (edge != null && this.model.getTerminal(edge, true) == null
        && this.model.getTerminal(edge, false) == null) {
      return null;
    }

    // Checks if we're dealing with a loop
    if (!this.isAllowLoops() && source == target && source != null) {
      return "";
    }

    // Checks if the connection is generally allowed
    if (!this.isValidConnection(source, target)) {
      return "";
    }

    if (source != null && target != null) {
      final StringBuffer error = new StringBuffer();

      // Checks if the cells are already connected
      // and adds an error message if required
      if (!this.multigraph) {
        final Object[] tmp = mxGraphModel.getEdgesBetween(this.model, source, target, true);

        // Checks if the source and target are not connected by another edge
        if (tmp.length > 1 || tmp.length == 1 && tmp[0] != edge) {
          error.append(mxResources.get("alreadyConnected", "Already Connected") + "\n");
        }
      }

      // Gets the number of outgoing edges from the source
      // and the number of incoming edges from the target
      // without counting the edge being currently changed.
      final int sourceOut = mxGraphModel.getDirectedEdgeCount(this.model, source, true, edge);
      final int targetIn = mxGraphModel.getDirectedEdgeCount(this.model, target, false, edge);

      // Checks the change against each multiplicity rule
      if (this.multiplicities != null) {
        for (int i = 0; i < this.multiplicities.length; i++) {
          final String err =
              this.multiplicities[i].check(this, edge, source, target, sourceOut, targetIn);

          if (err != null) {
            error.append(err);
          }
        }
      }

      // Validates the source and target terminals independently
      final String err = this.validateEdge(edge, source, target);

      if (err != null) {
        error.append(err);
      }

      return error.length() > 0 ? error.toString() : null;
    }

    return this.allowDanglingEdges ? null : "";
  }

  /**
   * Returns the cells which are movable in the given array of cells.
   */
  public Object[] getFoldableCells(final Object[] cells, final boolean collapse) {
    return mxGraphModel.filterCells(cells, new Filter() {
      @Override
      public boolean filter(final Object cell) {
        return mxGraph.this.isCellFoldable(cell, collapse);
      }
    });
  }

  /**
   * Returns the bounds of the visible graph.
   */
  public mxRectangle getGraphBounds() {
    return this.view.getGraphBounds();
  }

  /**
   * Returns the grid size.
   *
   * @return Returns the grid size
   */
  public int getGridSize() {
    return this.gridSize;
  }

  /**
   * Returns the image URL for the given cell state. This implementation returns the value stored
   * under <mxConstants.STYLE_IMAGE> in the cell style.
   *
   * @param state
   * @return Returns the image associated with the given cell state.
   */
  public String getImage(final mxCellState state) {
    return state != null && state.getStyle() != null
        ? mxUtils.getString(state.getStyle(), mxConstants.STYLE_IMAGE) : null;
  }

  /**
   * Returns the image bundles
   */
  public List<mxImageBundle> getImageBundles() {
    return mxGraph.imageBundles;
  }

  /**
   * Returns the image bundles
   */
  public void getImageBundles(final List<mxImageBundle> value) {
    mxGraph.imageBundles = value;
  }

  /**
   * Searches all bundles for the specified key and returns the value for the first match or null if
   * the key is not found.
   */
  public String getImageFromBundles(final String key) {
    if (key != null) {
      final Iterator<mxImageBundle> it = mxGraph.imageBundles.iterator();

      while (it.hasNext()) {
        final String value = it.next().getImage(key);

        if (value != null) {
          return value;
        }
      }
    }

    return null;
  }

  /**
   * Returns all incoming visible edges connected to the given cell without loops.
   *
   * @param cell Cell whose incoming edges should be returned.
   * @return Returns the incoming edges of the given cell.
   */
  public Object[] getIncomingEdges(final Object cell) {
    return this.getIncomingEdges(cell, null);
  }

  /**
   * Returns the visible incoming edges for the given cell. If the optional parent argument is
   * specified, then only child edges of the given parent are returned.
   *
   * @param cell Cell whose incoming edges should be returned.
   * @param parent Optional parent of the opposite end for an edge to be returned.
   * @return Returns the incoming edges of the given cell.
   */
  public Object[] getIncomingEdges(final Object cell, final Object parent) {
    return this.getEdges(cell, parent, true, false, false);
  }

  /**
   * Returns a string or DOM node that represents the label for the given cell. This implementation
   * uses <convertValueToString> if <labelsVisible> is true. Otherwise it returns an empty string.
   *
   * @param cell <mxCell> whose label should be returned.
   * @return Returns the label for the given cell.
   */
  public String getLabel(final Object cell) {
    String result = "";

    if (cell != null) {
      final mxCellState state = this.view.getState(cell);
      final Map<String, Object> style = state != null ? state.getStyle() : this.getCellStyle(cell);

      if (this.labelsVisible && !mxUtils.isTrue(style, mxConstants.STYLE_NOLABEL, false)) {
        result = this.convertValueToString(cell);
      }
    }

    return result;
  }

  //
  // Cell connecting and connection constraints
  //

  /**
   * Returns the hyperlink to be used for the given cell.
   */
  protected String getLinkForCell(final Object cell) {
    return null;
  }

  /**
   * @return the maximumGraphBounds
   */
  public mxRectangle getMaximumGraphBounds() {
    return this.maximumGraphBounds;
  }

  /**
   * Returns the minimum size of the diagram.
   *
   * @return Returns the minimum container size.
   */
  public mxRectangle getMinimumGraphSize() {
    return this.minimumGraphSize;
  }

  /**
   * Returns the graph model that contains the graph data.
   *
   * @return Returns the model that contains the graph data
   */
  public mxIGraphModel getModel() {
    return this.model;
  }

  /**
   * Returns the cells which are movable in the given array of cells.
   */
  public Object[] getMovableCells(final Object[] cells) {
    return mxGraphModel.filterCells(cells, new Filter() {
      @Override
      public boolean filter(final Object cell) {
        return mxGraph.this.isCellMovable(cell);
      }
    });
  }

  /**
   *
   */
  public mxMultiplicity[] getMultiplicities() {
    return this.multiplicities;
  }

  /**
   * Returns all distinct visible opposite cells of the terminal on the given edges.
   *
   * @param edges
   * @param terminal
   * @return Returns the terminals at the opposite ends of the given edges.
   */
  public Object[] getOpposites(final Object[] edges, final Object terminal) {
    return this.getOpposites(edges, terminal, true, true);
  }

  /**
   * Returns all distincts visible opposite cells for the specified terminal on the given edges.
   *
   * @param edges Edges whose opposite terminals should be returned.
   * @param terminal Terminal that specifies the end whose opposite should be returned.
   * @param sources Specifies if source terminals should be included in the result.
   * @param targets Specifies if target terminals should be included in the result.
   * @return Returns the cells at the opposite ends of the given edges.
   */
  public Object[] getOpposites(final Object[] edges, final Object terminal, final boolean sources,
      final boolean targets) {
    final Collection<Object> terminals = new LinkedHashSet<Object>();

    if (edges != null) {
      for (int i = 0; i < edges.length; i++) {
        final mxCellState state = this.view.getState(edges[i]);
        final Object source = state != null ? state.getVisibleTerminal(true)
            : this.view.getVisibleTerminal(edges[i], true);
        final Object target = state != null ? state.getVisibleTerminal(false)
            : this.view.getVisibleTerminal(edges[i], false);

        // Checks if the terminal is the source of
        // the edge and if the target should be
        // stored in the result
        if (targets && source == terminal && target != null && target != terminal) {
          terminals.add(target);
        }

        // Checks if the terminal is the taget of
        // the edge and if the source should be
        // stored in the result
        else if (sources && target == terminal && source != null && source != terminal) {
          terminals.add(source);
        }
      }
    }

    return terminals.toArray();
  }

  //
  // Drilldown
  //

  /**
   * Returns origin.
   */
  public mxPoint getOrigin() {
    return this.origin;
  }

  /**
   * Returns all outgoing visible edges connected to the given cell without loops.
   *
   * @param cell Cell whose outgoing edges should be returned.
   * @return Returns the outgoing edges of the given cell.
   */
  public Object[] getOutgoingEdges(final Object cell) {
    return this.getOutgoingEdges(cell, null);
  }

  /**
   * Returns the visible outgoing edges for the given cell. If the optional parent argument is
   * specified, then only child edges of the given parent are returned.
   *
   * @param cell Cell whose outgoing edges should be returned.
   * @param parent Optional parent of the opposite end for an edge to be returned.
   * @return Returns the outgoing edges of the given cell.
   */
  public Object[] getOutgoingEdges(final Object cell, final Object parent) {
    return this.getEdges(cell, parent, false, true, false);
  }

  /**
   * Returns a decimal number representing the amount of the width and height of the given cell that
   * is allowed to overlap its parent. A value of 0 means all children must stay inside the parent,
   * 1 means the child is allowed to be placed outside of the parent such that it touches one of the
   * parents sides. If <isAllowOverlapParent> returns false for the given cell, then this method
   * returns 0.
   *
   * @param cell
   * @return Returns the overlapping value for the given cell inside its parent.
   */
  public double getOverlap(final Object cell) {
    return this.isAllowOverlapParent(cell) ? this.getDefaultOverlap() : 0;
  }

  /**
   * Returns the bounding box of the given cells and their descendants.
   */
  public mxRectangle getPaintBounds(final Object[] cells) {
    return this.getBoundsForCells(cells, false, true, true);
  }

  /**
   * Returns the preferred width and height of the given <mxCell> as an <mxRectangle>.
   *
   * @param cell <mxCell> for which the preferred size should be returned.
   */
  public mxRectangle getPreferredSizeForCell(final Object cell) {
    mxRectangle result = null;

    if (cell != null) {
      final mxCellState state = this.view.getState(cell);
      final Map<String, Object> style = state != null ? state.style : this.getCellStyle(cell);

      if (style != null && !this.model.isEdge(cell)) {
        double dx = 0;
        double dy = 0;

        // Adds dimension of image if shape is a label
        if (this.getImage(state) != null
            || mxUtils.getString(style, mxConstants.STYLE_IMAGE) != null) {
          if (mxUtils.getString(style, mxConstants.STYLE_SHAPE, "")
              .equals(mxConstants.SHAPE_LABEL)) {
            if (mxUtils.getString(style, mxConstants.STYLE_VERTICAL_ALIGN, "")
                .equals(mxConstants.ALIGN_MIDDLE)) {
              dx += mxUtils.getDouble(style, mxConstants.STYLE_IMAGE_WIDTH,
                  mxConstants.DEFAULT_IMAGESIZE);
            }

            if (mxUtils.getString(style, mxConstants.STYLE_ALIGN, "")
                .equals(mxConstants.ALIGN_CENTER)) {
              dy += mxUtils.getDouble(style, mxConstants.STYLE_IMAGE_HEIGHT,
                  mxConstants.DEFAULT_IMAGESIZE);
            }
          }
        }

        // Adds spacings
        final double spacing = mxUtils.getDouble(style, mxConstants.STYLE_SPACING);
        dx += 2 * spacing;
        dx += mxUtils.getDouble(style, mxConstants.STYLE_SPACING_LEFT);
        dx += mxUtils.getDouble(style, mxConstants.STYLE_SPACING_RIGHT);

        dy += 2 * spacing;
        dy += mxUtils.getDouble(style, mxConstants.STYLE_SPACING_TOP);
        dy += mxUtils.getDouble(style, mxConstants.STYLE_SPACING_BOTTOM);

        // LATER: Add space for collapse/expand icon if applicable

        // Adds space for label
        final String value = this.getLabel(cell);

        if (value != null && value.length() > 0) {
          final mxRectangle size = mxUtils.getLabelSize(value, style, this.isHtmlLabel(cell), 1);
          double width = size.getWidth() + dx + 5;
          double height = size.getHeight() + dy + 5;

          if (!mxUtils.isTrue(style, mxConstants.STYLE_HORIZONTAL, true)) {
            final double tmp = height;

            height = width;
            width = tmp;
          }

          if (this.gridEnabled) {
            width = this.snap(width + this.gridSize / 2);
            height = this.snap(height + this.gridSize / 2);
          }

          result = new mxRectangle(0, 0, width, height);
        } else {
          final double gs2 = 4 * this.gridSize;
          result = new mxRectangle(0, 0, gs2, gs2);
        }
      }
    }

    return result;
  }

  /**
   * Returns the cells that have been removed from the model.
   */
  public Object[] getRemovedCellsForChanges(final List<mxUndoableChange> changes) {
    final List<Object> result = new ArrayList<Object>();
    final Iterator<mxUndoableChange> it = changes.iterator();

    while (it.hasNext()) {
      final Object change = it.next();

      if (change instanceof mxRootChange) {
        break;
      } else if (change instanceof mxChildChange) {
        final mxChildChange cc = (mxChildChange) change;

        if (cc.getParent() == null) {
          result.addAll(mxGraphModel.getDescendants(this.model, cc.getChild()));
        }
      } else if (change instanceof mxVisibleChange) {
        final Object cell = ((mxVisibleChange) change).getCell();
        result.addAll(mxGraphModel.getDescendants(this.model, cell));
      }
    }

    return result.toArray();
  }

  /**
   *
   * @return Returns the selection cell.
   */
  public Object getSelectionCell() {
    return this.selectionModel.getCell();
  }

  /**
   *
   * @return Returns the selection cells.
   */
  public Object[] getSelectionCells() {
    return this.selectionModel.getCells();
  }

  /**
   * Returns the cells to be selected for the given list of changes.
   */
  public Object[] getSelectionCellsForChanges(final List<mxUndoableChange> changes) {
    final List<Object> cells = new ArrayList<Object>();
    final Iterator<mxUndoableChange> it = changes.iterator();

    while (it.hasNext()) {
      final Object change = it.next();

      if (change instanceof mxChildChange) {
        cells.add(((mxChildChange) change).getChild());
      } else if (change instanceof mxTerminalChange) {
        cells.add(((mxTerminalChange) change).getCell());
      } else if (change instanceof mxValueChange) {
        cells.add(((mxValueChange) change).getCell());
      } else if (change instanceof mxStyleChange) {
        cells.add(((mxStyleChange) change).getCell());
      } else if (change instanceof mxGeometryChange) {
        cells.add(((mxGeometryChange) change).getCell());
      } else if (change instanceof mxCollapseChange) {
        cells.add(((mxCollapseChange) change).getCell());
      } else if (change instanceof mxVisibleChange) {
        final mxVisibleChange vc = (mxVisibleChange) change;

        if (vc.isVisible()) {
          cells.add(((mxVisibleChange) change).getCell());
        }
      }
    }

    return mxGraphModel.getTopmostCells(this.model, cells.toArray());
  }

  //
  // Graph display
  //

  /**
   *
   */
  public int getSelectionCount() {
    return this.selectionModel.size();
  }

  /**
   *
   */
  public mxGraphSelectionModel getSelectionModel() {
    return this.selectionModel;
  }

  /**
   * Returns the start size of the given swimlane, that is, the width or height of the part that
   * contains the title, depending on the horizontal style. The return value is an
   * <mxRectangle> with either width or height set as appropriate.
   *
   * @param swimlane <mxCell> whose start size should be returned.
   * @return Returns the startsize for the given swimlane.
   */
  public mxRectangle getStartSize(final Object swimlane) {
    final mxRectangle result = new mxRectangle();
    final mxCellState state = this.view.getState(swimlane);
    final Map<String, Object> style =
        state != null ? state.getStyle() : this.getCellStyle(swimlane);

    if (style != null) {
      final double size =
          mxUtils.getDouble(style, mxConstants.STYLE_STARTSIZE, mxConstants.DEFAULT_STARTSIZE);

      if (mxUtils.isTrue(style, mxConstants.STYLE_HORIZONTAL, true)) {
        result.setHeight(size);
      } else {
        result.setWidth(size);
      }
    }

    return result;
  }

  /**
   * Returns the stylesheet that provides the style.
   *
   * @return Returns the stylesheet that provides the style.
   */
  public mxStylesheet getStylesheet() {
    return this.stylesheet;
  }

  /**
   * Returns the hyperlink to be used for the given cell.
   */
  protected String getTargetForCell(final Object cell) {
    return null;
  }

  /**
   * Returns the terminal to be used for a given port. This implementation always returns the parent
   * cell.
   *
   * @param cell Cell that represents the port.
   * @param source If the cell is the source or target port.
   * @return Returns the terminal to be used for the given port.
   */
  public Object getTerminalForPort(final Object cell, final boolean source) {
    return this.getModel().getParent(cell);
  }

  /**
   * Returns the tooltip to be used for the given cell.
   */
  public String getToolTipForCell(final Object cell) {
    return this.convertValueToString(cell);
  }

  /**
   * Returns the translation to be used if the given cell is the root cell as an <mxPoint>. This
   * implementation returns null.
   *
   * @param cell Cell that represents the root of the view.
   * @return Returns the translation of the graph for the given root cell.
   */
  public mxPoint getTranslateForRoot(final Object cell) {
    return null;
  }

  /**
   * Returns the view that contains the cell states.
   *
   * @return Returns the view that contains the cell states
   */
  public mxGraphView getView() {
    return this.view;
  }

  /**
   * Called when the graph model changes. Invokes processChange on each item of the given array to
   * update the view accordingly.
   */
  public mxRectangle graphModelChanged(final mxIGraphModel sender,
      final List<mxUndoableChange> changes) {
    final int thresh = this.getChangesRepaintThreshold();
    boolean ignoreDirty = thresh > 0 && changes.size() > thresh;

    // Ignores dirty rectangle if there was a root change
    if (!ignoreDirty) {
      final Iterator<mxUndoableChange> it = changes.iterator();

      while (it.hasNext()) {
        if (it.next() instanceof mxRootChange) {
          ignoreDirty = true;
          break;
        }
      }
    }

    mxRectangle dirty = this.processChanges(changes, true, ignoreDirty);
    this.view.validate();

    if (this.isAutoOrigin()) {
      this.updateOrigin();
    }

    if (!ignoreDirty) {
      final mxRectangle tmp = this.processChanges(changes, false, ignoreDirty);

      if (tmp != null) {
        if (dirty == null) {
          dirty = tmp;
        } else {
          dirty.add(tmp);
        }
      }
    }

    this.removeSelectionCells(this.getRemovedCellsForChanges(changes));

    return dirty;
  }

  /**
   * Groups the selection cells. This is a shortcut method.
   *
   * @return Returns the new group.
   */
  public Object groupCells() {
    return this.groupCells(null);
  }

  /**
   * Groups the selection cells and adds them to the given group. This is a shortcut method.
   *
   * @return Returns the new group.
   */
  public Object groupCells(final Object group) {
    return this.groupCells(group, 0);
  }

  /**
   * Groups the selection cells and adds them to the given group. This is a shortcut method.
   *
   * @return Returns the new group.
   */
  public Object groupCells(final Object group, final double border) {
    return this.groupCells(group, border, null);
  }

  /**
   * Adds the cells into the given group. The change is carried out using cellsAdded, cellsMoved and
   * cellsResized. This method fires mxEvent.GROUP_CELLS while the transaction is in progress.
   * Returns the new group. A group is only created if there is at least one entry in the given
   * array of cells.
   *
   * @param group Cell that represents the target group. If null is specified then a new group is
   *        created using createGroupCell.
   * @param border Integer that specifies the border between the child area and the group bounds.
   * @param cells Optional array of cells to be grouped. If null is specified then the selection
   *        cells are used.
   */
  public Object groupCells(Object group, final double border, Object[] cells) {
    if (cells == null) {
      cells = mxUtils.sortCells(this.getSelectionCells(), true);
    }

    cells = this.getCellsForGroup(cells);

    if (group == null) {
      group = this.createGroupCell(cells);
    }

    final mxRectangle bounds = this.getBoundsForGroup(group, cells, border);

    if (cells.length > 0 && bounds != null) {
      // Uses parent of group or previous parent of first child
      Object parent = this.model.getParent(group);

      if (parent == null) {
        parent = this.model.getParent(cells[0]);
      }

      this.model.beginUpdate();
      try {
        // Checks if the group has a geometry and
        // creates one if one does not exist
        if (this.getCellGeometry(group) == null) {
          this.model.setGeometry(group, new mxGeometry());
        }

        // Adds the children into the group and moves
        int index = this.model.getChildCount(group);
        this.cellsAdded(cells, group, index, null, null, false);
        this.cellsMoved(cells, -bounds.getX(), -bounds.getY(), false, true);

        // Adds the group into the parent and resizes
        index = this.model.getChildCount(parent);
        this.cellsAdded(new Object[] {group}, parent, index, null, null, false, false);
        this.cellsResized(new Object[] {group}, new mxRectangle[] {bounds});

        this.fireEvent(new mxEventObject(mxEvent.GROUP_CELLS, "group", group, "cells", cells,
            "border", border));
      } finally {
        this.model.endUpdate();
      }
    }

    return group;
  }

  /**
   * Uses the root of the model as the root of the displayed cell hierarchy and selects the previous
   * root.
   */
  public void home() {
    final Object current = this.getCurrentRoot();

    if (current != null) {
      this.view.setCurrentRoot(null);
      final mxCellState state = this.view.getState(current);

      if (state != null) {
        this.setSelectionCell(current);
      }
    }
  }

  /**
   * Creates and adds a new edge with an empty style.
   */
  public Object insertEdge(final Object parent, final String id, final Object value,
      final Object source, final Object target) {
    return this.insertEdge(parent, id, value, source, target, null);
  }

  /**
   * Adds a new edge into the given parent using value as the user object and the given source and
   * target as the terminals of the new edge. The Id and style are used for the respective
   * properties of the new cell, which is returned.
   *
   * @param parent Cell that specifies the parent of the new edge.
   * @param id Optional string that defines the Id of the new edge.
   * @param value Object to be used as the user object.
   * @param source Cell that defines the source of the edge.
   * @param target Cell that defines the target of the edge.
   * @param style Optional string that defines the cell style.
   * @return Returns the new edge that has been inserted.
   */
  public Object insertEdge(final Object parent, final String id, final Object value,
      final Object source, final Object target, final String style) {
    final Object edge = this.createEdge(parent, id, value, source, target, style);

    return this.addEdge(edge, parent, source, target, null);
  }

  /**
   * Creates and adds a new vertex with an empty style.
   */
  public Object insertVertex(final Object parent, final String id, final Object value,
      final double x, final double y, final double width, final double height) {
    return this.insertVertex(parent, id, value, x, y, width, height, null);
  }

  /**
   * Adds a new vertex into the given parent using value as the user object and the given
   * coordinates as the geometry of the new vertex. The id and style are used for the respective
   * properties of the new cell, which is returned.
   *
   * @param parent Cell that specifies the parent of the new vertex.
   * @param id Optional string that defines the Id of the new vertex.
   * @param value Object to be used as the user object.
   * @param x Integer that defines the x coordinate of the vertex.
   * @param y Integer that defines the y coordinate of the vertex.
   * @param width Integer that defines the width of the vertex.
   * @param height Integer that defines the height of the vertex.
   * @param style Optional string that defines the cell style.
   * @return Returns the new vertex that has been inserted.
   */
  public Object insertVertex(final Object parent, final String id, final Object value,
      final double x, final double y, final double width, final double height, final String style) {
    return this.insertVertex(parent, id, value, x, y, width, height, style, false);
  }

  /**
   * Adds a new vertex into the given parent using value as the user object and the given
   * coordinates as the geometry of the new vertex. The id and style are used for the respective
   * properties of the new cell, which is returned.
   *
   * @param parent Cell that specifies the parent of the new vertex.
   * @param id Optional string that defines the Id of the new vertex.
   * @param value Object to be used as the user object.
   * @param x Integer that defines the x coordinate of the vertex.
   * @param y Integer that defines the y coordinate of the vertex.
   * @param width Integer that defines the width of the vertex.
   * @param height Integer that defines the height of the vertex.
   * @param style Optional string that defines the cell style.
   * @param relative Specifies if the geometry should be relative.
   * @return Returns the new vertex that has been inserted.
   */
  public Object insertVertex(final Object parent, final String id, final Object value,
      final double x, final double y, final double width, final double height, final String style,
      final boolean relative) {
    final Object vertex =
        this.createVertex(parent, id, value, x, y, width, height, style, relative);

    return this.addCell(vertex, parent);
  }

  /**
   * Returns allowDanglingEdges
   */
  public boolean isAllowDanglingEdges() {
    return this.allowDanglingEdges;
  }

  //
  // Cell validation
  //

  /**
   * Returns allowLoops.
   */
  public boolean isAllowLoops() {
    return this.allowLoops;
  }

  /**
   * Returns isAllowNegativeCoordinates.
   *
   * @return the allowNegativeCoordinates
   */
  public boolean isAllowNegativeCoordinates() {
    return this.allowNegativeCoordinates;
  }

  /**
   * Returns true if the given cell is allowed to be placed outside of the parents area.
   *
   * @param cell
   * @return Returns true if the given cell may overlap its parent.
   */
  public boolean isAllowOverlapParent(final Object cell) {
    return false;
  }

  /**
   * Returns autoOrigin.
   */
  public boolean isAutoOrigin() {
    return this.autoOrigin;
  }

  /**
   * Returns true if the size of the given cell should automatically be updated after a change of
   * the label. This implementation returns autoSize for all given cells or checks if the cell style
   * does specify mxConstants.STYLE_AUTOSIZE to be 1.
   *
   * @param cell Cell that should be resized.
   * @return Returns true if the size of the given cell should be updated.
   */
  public boolean isAutoSizeCell(final Object cell) {
    final mxCellState state = this.view.getState(cell);
    final Map<String, Object> style = state != null ? state.getStyle() : this.getCellStyle(cell);

    return this.isAutoSizeCells() || mxUtils.isTrue(style, mxConstants.STYLE_AUTOSIZE, false);
  }

  /**
   * Returns true if the size of the given cell should automatically be updated after a change of
   * the label. This implementation returns autoSize for all given cells.
   */
  public boolean isAutoSizeCells() {
    return this.autoSizeCells;
  }

  /**
   * Returns true if the given cell is bendable. This implementation returns bendable. This is used
   * in mxElbowEdgeHandler to determine if the middle handle should be shown.
   *
   * @param cell Cell whose bendable state should be returned.
   * @return Returns true if the cell is bendable.
   */
  public boolean isCellBendable(final Object cell) {
    final mxCellState state = this.view.getState(cell);
    final Map<String, Object> style = state != null ? state.getStyle() : this.getCellStyle(cell);

    return this.isCellsBendable() && !this.isCellLocked(cell)
        && mxUtils.isTrue(style, mxConstants.STYLE_BENDABLE, true);
  }

  //
  // Graph appearance
  //

  /**
   * Returns the constant true. This does not use the cloneable field to return a value for a given
   * cell, it is simply a hook for subclassers to disallow cloning of individual cells.
   */
  public boolean isCellCloneable(final Object cell) {
    final mxCellState state = this.view.getState(cell);
    final Map<String, Object> style = state != null ? state.getStyle() : this.getCellStyle(cell);

    return this.isCellsCloneable() && mxUtils.isTrue(style, mxConstants.STYLE_CLONEABLE, true);
  }

  /**
   * Returns true if the given cell is collapsed in this graph. This implementation uses
   * <mxGraphModel.isCollapsed>. Subclassers can override this to implement specific collapsed
   * states for cells in only one graph, that is, without affecting the collapsed state of the cell.
   *
   * When using dynamic filter expressions for the collapsed state, then the graph should be
   * revalidated after the filter expression has changed.
   *
   * @param cell Cell whose collapsed state should be returned.
   * @return Returns the collapsed state of the cell.
   */
  public boolean isCellCollapsed(final Object cell) {
    return this.model.isCollapsed(cell);
  }

  /**
   * Returns true if the given cell is connectable in this graph. This implementation uses
   * <mxGraphModel.isConnectable>. Subclassers can override this to implement specific connectable
   * states for cells in only one graph, that is, without affecting the connectable state of the
   * cell in the model.
   *
   * @param cell Cell whose connectable state should be returned.
   * @return Returns the connectable state of the cell.
   */
  public boolean isCellConnectable(final Object cell) {
    return this.model.isConnectable(cell);
  }

  /**
   * Returns true if the given cell is movable. This implementation always returns true.
   *
   * @param cell Cell whose movable state should be returned.
   * @return Returns true if the cell is movable.
   */
  public boolean isCellDeletable(final Object cell) {
    final mxCellState state = this.view.getState(cell);
    final Map<String, Object> style = state != null ? state.getStyle() : this.getCellStyle(cell);

    return this.isCellsDeletable() && mxUtils.isTrue(style, mxConstants.STYLE_DELETABLE, true);
  }

  /**
   * Returns true if the given cell is disconnectable from the source or target terminal. This
   * returns <disconnectable> for all given cells if <isLocked> does not return true for the given
   * cell.
   *
   * @param cell <mxCell> whose disconnectable state should be returned.
   * @param terminal <mxCell> that represents the source or target terminal.
   * @param source Boolean indicating if the source or target terminal is to be disconnected.
   * @return Returns true if the given edge can be disconnected from the given terminal.
   */
  public boolean isCellDisconnectable(final Object cell, final Object terminal,
      final boolean source) {
    return this.isCellsDisconnectable() && !this.isCellLocked(cell);
  }

  /**
   * Returns true if the given cell is movable. This implementation returns editable.
   *
   * @param cell Cell whose editable state should be returned.
   * @return Returns true if the cell is editable.
   */
  public boolean isCellEditable(final Object cell) {
    final mxCellState state = this.view.getState(cell);
    final Map<String, Object> style = state != null ? state.getStyle() : this.getCellStyle(cell);

    return this.isCellsEditable() && !this.isCellLocked(cell)
        && mxUtils.isTrue(style, mxConstants.STYLE_EDITABLE, true);
  }

  /**
   * Returns true if the given cell is expandable. This implementation returns true if the cell has
   * at least one child and its style does not specify mxConstants.STYLE_FOLDABLE to be 0.
   *
   * @param cell <mxCell> whose expandable state should be returned.
   * @return Returns true if the given cell is expandable.
   */
  public boolean isCellFoldable(final Object cell, final boolean collapse) {
    final mxCellState state = this.view.getState(cell);
    final Map<String, Object> style = state != null ? state.getStyle() : this.getCellStyle(cell);

    return this.model.getChildCount(cell) > 0
        && mxUtils.isTrue(style, mxConstants.STYLE_FOLDABLE, true);
  }

  /**
   * Returns true if the given cell may not be moved, sized, bended, disconnected, edited or
   * selected. This implementation returns true for all vertices with a relative geometry if
   * cellsLocked is false.
   *
   * @param cell Cell whose locked state should be returned.
   * @return Returns true if the given cell is locked.
   */
  public boolean isCellLocked(final Object cell) {
    final mxGeometry geometry = this.model.getGeometry(cell);

    return this.isCellsLocked()
        || geometry != null && this.model.isVertex(cell) && geometry.isRelative();
  }

  /**
   * Returns true if the given cell is movable. This implementation returns movable.
   *
   * @param cell Cell whose movable state should be returned.
   * @return Returns true if the cell is movable.
   */
  public boolean isCellMovable(final Object cell) {
    final mxCellState state = this.view.getState(cell);
    final Map<String, Object> style = state != null ? state.getStyle() : this.getCellStyle(cell);

    return this.isCellsMovable() && !this.isCellLocked(cell)
        && mxUtils.isTrue(style, mxConstants.STYLE_MOVABLE, true);
  }

  /**
   * Returns true if the given cell is resizable. This implementation returns cellsSizable for all
   * cells.
   *
   * @param cell Cell whose resizable state should be returned.
   * @return Returns true if the cell is sizable.
   */
  public boolean isCellResizable(final Object cell) {
    final mxCellState state = this.view.getState(cell);
    final Map<String, Object> style = state != null ? state.getStyle() : this.getCellStyle(cell);

    return this.isCellsResizable() && !this.isCellLocked(cell)
        && mxUtils.isTrue(style, mxConstants.STYLE_RESIZABLE, true);
  }

  /**
   * Returns cellsBendable.
   */
  public boolean isCellsBendable() {
    return this.cellsBendable;
  }

  /**
   * Returns cellsCloneable.
   */
  public boolean isCellsCloneable() {
    return this.cellsCloneable;
  }

  /**
   * Returns cellsDeletable.
   */
  public boolean isCellsDeletable() {
    return this.cellsDeletable;
  }

  /**
   * Returns cellsDisconnectable.
   */
  public boolean isCellsDisconnectable() {
    return this.cellsDisconnectable;
  }

  /**
   * Returns true if editing is allowed in this graph.
   *
   * @return Returns true if the graph is editable.
   */
  public boolean isCellsEditable() {
    return this.cellsEditable;
  }

  /**
   * Returns true if the given cell is selectable. This implementation returns <selectable>.
   *
   * @param cell <mxCell> whose selectable state should be returned.
   * @return Returns true if the given cell is selectable.
   */
  public boolean isCellSelectable(final Object cell) {
    return this.isCellsSelectable();
  }

  //
  // Cells and labels control options
  //

  /**
   *
   * @param cell
   * @return Returns true if the given cell is selected.
   */
  public boolean isCellSelected(final Object cell) {
    return this.selectionModel.isSelected(cell);
  }

  /**
   * Returns cellsLocked, the default return value for isCellLocked.
   */
  public boolean isCellsLocked() {
    return this.cellsLocked;
  }

  /**
   * Returns cellsMovable.
   */
  public boolean isCellsMovable() {
    return this.cellsMovable;
  }

  /**
   * Returns true if the given cell is resizable. This implementation return sizable.
   */
  public boolean isCellsResizable() {
    return this.cellsResizable;
  }

  /**
   * Returns cellsSelectable.
   */
  public boolean isCellsSelectable() {
    return this.cellsSelectable;
  }

  /**
   * Returns true if the given cell is visible in this graph. This implementation uses
   * <mxGraphModel.isVisible>. Subclassers can override this to implement specific visibility for
   * cells in only one graph, that is, without affecting the visible state of the cell.
   *
   * When using dynamic filter expressions for cell visibility, then the graph should be revalidated
   * after the filter expression has changed.
   *
   * @param cell Cell whose visible state should be returned.
   * @return Returns the visible state of the cell.
   */
  public boolean isCellVisible(final Object cell) {
    return this.model.isVisible(cell);
  }

  /**
   * Returns cloneInvalidEdges.
   */
  public boolean isCloneInvalidEdges() {
    return this.cloneInvalidEdges;
  }

  /**
   * Returns collapseToPreferredSize.
   *
   * @return the collapseToPreferredSize
   */
  public boolean isCollapseToPreferredSize() {
    return this.collapseToPreferredSize;
  }

  /**
   * Returns connectableEdges.
   */
  public boolean isConnectableEdges() {
    return this.connectableEdges;
  }

  /**
   * Returns true if the given cell should be kept inside the bounds of its parent according to the
   * rules defined by getOverlap and isAllowOverlapParent. This implementation returns false for all
   * children of edges and isConstrainChildren() otherwise.
   */
  public boolean isConstrainChild(final Object cell) {
    return this.isConstrainChildren() && !this.getModel().isEdge(this.getModel().getParent(cell));
  }

  /**
   * Returns constrainChildren.
   *
   * @return the keepInsideParentOnMove
   */
  public boolean isConstrainChildren() {
    return this.constrainChildren;
  }

  /**
   * Returns disconnectOnMove
   */
  public boolean isDisconnectOnMove() {
    return this.disconnectOnMove;
  }

  /**
   * Returns true if the graph allows drop into other cells.
   */
  public boolean isDropEnabled() {
    return this.dropEnabled;
  }

  /**
   * Returns edgeLabelsMovable.
   */
  public boolean isEdgeLabelsMovable() {
    return this.edgeLabelsMovable;
  }

  /**
   * Checks if the return value of getEdgeValidationError for the given arguments is null.
   *
   * @param edge Cell that represents the edge to validate.
   * @param source Cell that represents the source terminal.
   * @param target Cell that represents the target terminal.
   */
  public boolean isEdgeValid(final Object edge, final Object source, final Object target) {
    return this.getEdgeValidationError(edge, source, target) == null;
  }

  /**
   * Returns true if the graph is <enabled>.
   *
   * @return Returns true if the graph is enabled.
   */
  public boolean isEnabled() {
    return this.enabled;
  }

  /**
   * Returns true if the parent of the given cell should be extended if the child has been resized
   * so that it overlaps the parent. This implementation returns ExtendParents if cell is not an
   * edge.
   *
   * @param cell Cell that has been resized.
   */
  public boolean isExtendParent(final Object cell) {
    return !this.getModel().isEdge(cell) && this.isExtendParents();
  }

  /**
   * Returns extendParents.
   */
  public boolean isExtendParents() {
    return this.extendParents;
  }

  /**
   * Returns extendParentsOnAdd.
   */
  public boolean isExtendParentsOnAdd() {
    return this.extendParentsOnAdd;
  }

  /**
   * Returns true if the grid is enabled.
   *
   * @return Returns the enabled state of the grid.
   */
  public boolean isGridEnabled() {
    return this.gridEnabled;
  }

  /**
   * Returns true if the label must be rendered as HTML markup. The default implementation returns
   * <htmlLabels>.
   *
   * @param cell <mxCell> whose label should be displayed as HTML markup.
   * @return Returns true if the given cell label is HTML markup.
   */
  public boolean isHtmlLabel(final Object cell) {
    return this.isHtmlLabels();
  }

  /**
   *
   */
  public boolean isHtmlLabels() {
    return this.htmlLabels;
  }

  /**
   * @return Returns true if edges are rendered in the background.
   */
  public boolean isKeepEdgesInBackground() {
    return this.keepEdgesInBackground;
  }

  /**
   * @return Returns true if edges are rendered in the foreground.
   */
  public boolean isKeepEdgesInForeground() {
    return this.keepEdgesInForeground;
  }

  /**
   * Returns true if the overflow portion of labels should be hidden. If this returns true then
   * vertex labels will be clipped to the size of the vertices. This implementation returns true if
   * <mxConstants.STYLE_OVERFLOW> in the style of the given cell is "hidden".
   *
   * @param cell Cell whose label should be clipped.
   * @return Returns true if the cell label should be clipped.
   */
  public boolean isLabelClipped(final Object cell) {
    if (!this.isLabelsClipped()) {
      final mxCellState state = this.view.getState(cell);
      final Map<String, Object> style = state != null ? state.getStyle() : this.getCellStyle(cell);

      return style != null
          ? mxUtils.getString(style, mxConstants.STYLE_OVERFLOW, "").equals("hidden") : false;
    }

    return this.isLabelsClipped();
  }

  /**
   * Returns true if the given edges's label is moveable. This returns <movable> for all given cells
   * if <isLocked> does not return true for the given cell.
   *
   * @param cell <mxCell> whose label should be moved.
   * @return Returns true if the label of the given cell is movable.
   */
  public boolean isLabelMovable(final Object cell) {
    return !this.isCellLocked(cell) && (this.model.isEdge(cell) && this.isEdgeLabelsMovable()
        || this.model.isVertex(cell) && this.isVertexLabelsMovable());
  }

  /**
   * Returns labelsClipped.
   */
  public boolean isLabelsClipped() {
    return this.labelsClipped;
  }

  /**
   * @return the labelsVisible
   */
  public boolean isLabelsVisible() {
    return this.labelsVisible;
  }

  /**
   * Returns true if the given cell state is a loop.
   *
   * @param state <mxCellState> that represents a potential loop.
   * @return Returns true if the given cell is a loop.
   */
  public boolean isLoop(final mxCellState state) {
    final Object src = state.getVisibleTerminalState(true);
    final Object trg = state.getVisibleTerminalState(false);

    return src != null && src == trg;
  }

  /**
   * Returns multigraph.
   */
  public boolean isMultigraph() {
    return this.multigraph;
  }

  /**
   * Returns true if perimeter points should be computed such that the resulting edge has only
   * horizontal or vertical segments.
   *
   * @param edge Cell state that represents the edge.
   */
  public boolean isOrthogonal(final mxCellState edge) {
    if (edge.getStyle().containsKey(mxConstants.STYLE_ORTHOGONAL)) {
      return mxUtils.isTrue(edge.getStyle(), mxConstants.STYLE_ORTHOGONAL);
    }

    final mxEdgeStyle.mxEdgeStyleFunction tmp = this.view.getEdgeStyle(edge, null, null, null);

    return tmp == mxEdgeStyle.SegmentConnector || tmp == mxEdgeStyle.ElbowConnector
        || tmp == mxEdgeStyle.SideToSide || tmp == mxEdgeStyle.TopToBottom
        || tmp == mxEdgeStyle.EntityRelation || tmp == mxEdgeStyle.OrthConnector;
  }

  /**
   * Returns true if the given cell is a "port", that is, when connecting to it, the cell returned
   * by getTerminalForPort should be used as the terminal and the port should be referenced by the
   * ID in either the mxConstants.STYLE_SOURCE_PORT or the or the mxConstants.STYLE_TARGET_PORT.
   * Note that a port should not be movable. This implementation always returns false.
   *
   * A typical implementation of this method looks as follows:
   *
   * <code>
   * public boolean isPort(Object cell)
   * {
   *   mxGeometry geo = getCellGeometry(cell);
   *
   *   return (geo != null) ? geo.isRelative() : false;
   * }
   * </code>
   *
   * @param cell Cell that represents the port.
   * @return Returns true if the cell is a port.
   */
  public boolean isPort(final Object cell) {
    return false;
  }

  /**
   * Returns true if ports are enabled.
   *
   * @return Returns the enabled state of the ports.
   */
  public boolean isPortsEnabled() {
    return this.portsEnabled;
  }

  /**
   * Returns resetEdgesOnConnect.
   */
  public boolean isResetEdgesOnConnect() {
    return this.resetEdgesOnConnect;
  }

  /**
   * Returns resetEdgesOnMove.
   */
  public boolean isResetEdgesOnMove() {
    return this.resetEdgesOnMove;
  }

  /**
   * Returns resetEdgesOnResize.
   */
  public boolean isResetEdgesOnResize() {
    return this.resetEdgesOnResize;
  }

  /**
   * Returns resetViewOnRootChange.
   */
  public boolean isResetViewOnRootChange() {
    return this.resetViewOnRootChange;
  }

  /**
   *
   * @return Returns true if the selection is empty.
   */
  public boolean isSelectionEmpty() {
    return this.selectionModel.isEmpty();
  }

  /**
   * Affects the return values of isValidDropTarget to allow for edges as drop targets. The
   * splitEdge method is called in mxGraphHandler if mxGraphComponent.isSplitEvent returns true for
   * a given configuration.
   */
  public boolean isSplitEnabled() {
    return this.splitEnabled;
  }

  //
  // Graph control options
  //

  /**
   * Returns true if split is enabled and the given edge may be splitted into two edges with the
   * given cell as a new terminal between the two.
   *
   * @param target Object that represents the edge to be splitted.
   * @param cells Array of cells to add into the given edge.
   * @return Returns true if the given edge may be splitted by the given cell.
   */
  public boolean isSplitTarget(final Object target, final Object[] cells) {
    if (target != null && cells != null && cells.length == 1) {
      final Object src = this.model.getTerminal(target, true);
      final Object trg = this.model.getTerminal(target, false);

      return this.model.isEdge(target) && this.isCellConnectable(cells[0])
          && this.getEdgeValidationError(target, this.model.getTerminal(target, true),
              cells[0]) == null
          && !this.model.isAncestor(cells[0], src) && !this.model.isAncestor(cells[0], trg);
    }

    return false;
  }

  /**
   * Returns true if the given cell is a swimlane. This implementation always returns false.
   *
   * @param cell Cell that should be checked.
   * @return Returns true if the cell is a swimlane.
   */
  public boolean isSwimlane(final Object cell) {
    if (cell != null) {
      if (this.model.getParent(cell) != this.model.getRoot()) {
        final mxCellState state = this.view.getState(cell);
        final Map<String, Object> style =
            state != null ? state.getStyle() : this.getCellStyle(cell);

        if (style != null && !this.model.isEdge(cell)) {
          return mxUtils.getString(style, mxConstants.STYLE_SHAPE, "")
              .equals(mxConstants.SHAPE_SWIMLANE);
        }
      }
    }

    return false;
  }

  /**
   * Returns swimlaneNesting.
   */
  public boolean isSwimlaneNesting() {
    return this.swimlaneNesting;
  }

  /**
   * Function: isTerminalPointMovable
   *
   * Returns true if the given terminal point is movable. This is independent from isCellConnectable
   * and isCellDisconnectable and controls if terminal points can be moved in the graph if the edge
   * is not connected. Note that it is required for this to return true to connect unconnected
   * edges. This implementation returns true.
   *
   * @param cell Cell whose terminal point should be moved.
   * @param source Boolean indicating if the source or target terminal should be moved.
   */
  public boolean isTerminalPointMovable(final Object cell, final boolean source) {
    return true;
  }

  /**
   * Returns whether or not the specified parent is a valid ancestor of the specified cell, either
   * direct or indirectly based on whether ancestor recursion is enabled.
   *
   * @param cell the possible child cell
   * @param parent the possible parent cell
   * @param recurse whether or not to recurse the child ancestors
   * @return whether or not the specified parent is a valid ancestor of the specified cell, either
   *         direct or indirectly based on whether ancestor recursion is enabled.
   */
  public boolean isValidAncestor(final Object cell, final Object parent, final boolean recurse) {
    return recurse ? this.model.isAncestor(parent, cell) : this.model.getParent(cell) == parent;
  }

  /**
   * Returns true if the given target cell is a valid target for source. This is a boolean
   * implementation for not allowing connections between certain pairs of vertices and is called by
   * <getEdgeValidationError>. This implementation returns true if <isValidSource> returns true for
   * the source and <isValidTarget> returns true for the target.
   *
   * @param source Object that represents the source cell.
   * @param target Object that represents the target cell.
   * @return Returns true if the the connection between the given terminals is valid.
   */
  public boolean isValidConnection(final Object source, final Object target) {
    return this.isValidSource(source) && this.isValidTarget(target)
        && (this.isAllowLoops() || source != target);
  }

  /**
   * Returns true if the given cell is a valid drop target for the specified cells. This returns
   * true if the cell is a swimlane, has children and is not collapsed, or if splitEnabled is true
   * and isSplitTarget returns true for the given arguments
   *
   * @param cell Object that represents the possible drop target.
   * @param cells Objects that are going to be dropped.
   * @return Returns true if the cell is a valid drop target for the given cells.
   */
  public boolean isValidDropTarget(final Object cell, final Object[] cells) {
    return cell != null && (this.isSplitEnabled() && this.isSplitTarget(cell, cells)
        || !this.model.isEdge(cell) && (this.isSwimlane(cell)
            || this.model.getChildCount(cell) > 0 && !this.isCellCollapsed(cell)));
  }

  /**
   * Returns true if the given cell is a valid root for the cell display hierarchy. This
   * implementation returns true for all non-null values.
   *
   * @param cell <mxCell> which should be checked as a possible root.
   * @return Returns true if the given cell is a valid root.
   */
  public boolean isValidRoot(final Object cell) {
    return cell != null;
  }

  /**
   * Returns true if the given cell is a valid source for new connections. This implementation
   * returns true for all non-null values and is called by is called by <isValidConnection>.
   *
   * @param cell Object that represents a possible source or null.
   * @return Returns true if the given cell is a valid source terminal.
   */
  public boolean isValidSource(final Object cell) {
    return cell == null && this.allowDanglingEdges || cell != null
        && (!this.model.isEdge(cell) || this.isConnectableEdges()) && this.isCellConnectable(cell);
  }

  /**
   * Returns isValidSource for the given cell. This is called by isValidConnection.
   *
   * @param cell Object that represents a possible target or null.
   * @return Returns true if the given cell is a valid target.
   */
  public boolean isValidTarget(final Object cell) {
    return this.isValidSource(cell);
  }

  /**
   * Returns vertexLabelsMovable.
   */
  public boolean isVertexLabelsMovable() {
    return this.vertexLabelsMovable;
  }

  /**
   * Moves the cells by the given amount. This is a shortcut method.
   */
  public Object[] moveCells(final Object[] cells, final double dx, final double dy) {
    return this.moveCells(cells, dx, dy, false);
  }

  /**
   * Moves or clones the cells and moves the cells or clones by the given amount. This is a shortcut
   * method.
   */
  public Object[] moveCells(final Object[] cells, final double dx, final double dy,
      final boolean clone) {
    return this.moveCells(cells, dx, dy, clone, null, null);
  }

  /**
   * Moves or clones the specified cells and moves the cells or clones by the given amount, adding
   * them to the optional target cell. The location is the position of the mouse pointer as the
   * mouse was released. The change is carried out using cellsMoved. This method fires
   * mxEvent.MOVE_CELLS while the transaction is in progress.
   *
   * @param cells Array of cells to be moved, cloned or added to the target.
   * @param dx Integer that specifies the x-coordinate of the vector.
   * @param dy Integer that specifies the y-coordinate of the vector.
   * @param clone Boolean indicating if the cells should be cloned.
   * @param target Cell that represents the new parent of the cells.
   * @param location Location where the mouse was released.
   * @return Returns the cells that were moved.
   */
  public Object[] moveCells(Object[] cells, final double dx, final double dy, final boolean clone,
      Object target, final Point location) {
    if (cells != null && (dx != 0 || dy != 0 || clone || target != null)) {
      this.model.beginUpdate();
      try {
        if (clone) {
          cells = this.cloneCells(cells, this.isCloneInvalidEdges());

          if (target == null) {
            target = this.getDefaultParent();
          }
        }

        // Need to disable allowNegativeCoordinates if target not null to
        // allow for temporary negative numbers until cellsAdded is called.
        final boolean previous = this.isAllowNegativeCoordinates();

        if (target != null) {
          this.setAllowNegativeCoordinates(true);
        }

        this.cellsMoved(cells, dx, dy,
            !clone && this.isDisconnectOnMove() && this.isAllowDanglingEdges(), target == null);

        this.setAllowNegativeCoordinates(previous);

        if (target != null) {
          final Integer index = this.model.getChildCount(target);
          this.cellsAdded(cells, target, index, null, null, true);
        }

        this.fireEvent(new mxEventObject(mxEvent.MOVE_CELLS, "cells", cells, "dx", dx, "dy", dy,
            "clone", clone, "target", target, "location", location));
      } finally {
        this.model.endUpdate();
      }
    }

    return cells;
  }

  /**
   * Moves the selection cells to the front or back. This is a shortcut method.
   *
   * @param back Specifies if the cells should be moved to back.
   */
  public Object[] orderCells(final boolean back) {
    return this.orderCells(back, null);
  }

  /**
   * Moves the given cells to the front or back. The change is carried out using cellsOrdered. This
   * method fires mxEvent.ORDER_CELLS while the transaction is in progress.
   *
   * @param back Specifies if the cells should be moved to back.
   * @param cells Array of cells whose order should be changed. If null is specified then the
   *        selection cells are used.
   */
  public Object[] orderCells(final boolean back, Object[] cells) {
    if (cells == null) {
      cells = mxUtils.sortCells(this.getSelectionCells(), true);
    }

    this.model.beginUpdate();
    try {
      this.cellsOrdered(cells, back);
      this.fireEvent(new mxEventObject(mxEvent.ORDER_CELLS, "cells", cells, "back", back));
    } finally {
      this.model.endUpdate();
    }

    return cells;
  }

  /**
   * Tries to resolve the value for the image style in the image bundles and turns short data URIs
   * as defined in mxImageBundle to data URIs as defined in RFC 2397 of the IETF.
   */
  protected Map<String, Object> postProcessCellStyle(final Map<String, Object> style) {
    if (style != null) {
      final String key = mxUtils.getString(style, mxConstants.STYLE_IMAGE);
      String image = this.getImageFromBundles(key);

      if (image != null) {
        style.put(mxConstants.STYLE_IMAGE, image);
      } else {
        image = key;
      }

      // Converts short data uris to normal data uris
      if (image != null && image.startsWith("data:image/")) {
        final int comma = image.indexOf(',');

        if (comma > 0) {
          image = image.substring(0, comma) + ";base64," + image.substring(comma + 1);
        }

        style.put(mxConstants.STYLE_IMAGE, image);
      }
    }

    return style;
  }

  /**
   * Processes the given change and invalidates the respective cached data in <view>. This fires a
   * <root> event if the root has changed in the model.
   */
  public mxRectangle processChange(final mxUndoableChange change, final boolean invalidate,
      final boolean ignoreDirty) {
    mxRectangle result = null;

    if (change instanceof mxRootChange) {
      result = ignoreDirty ? null : this.getGraphBounds();

      if (invalidate) {
        this.clearSelection();
        this.removeStateForCell(((mxRootChange) change).getPrevious());

        if (this.isResetViewOnRootChange()) {
          this.view.setEventsEnabled(false);

          try {
            this.view.scaleAndTranslate(1, 0, 0);
          } finally {
            this.view.setEventsEnabled(true);
          }
        }

      }

      this.fireEvent(new mxEventObject(mxEvent.ROOT));
    } else if (change instanceof mxChildChange) {
      final mxChildChange cc = (mxChildChange) change;

      // Repaints the parent area if it is a rendered cell (vertex or
      // edge) otherwise only the child area is repainted, same holds
      // if the parent and previous are the same object, in which case
      // only the child area needs to be repainted (change of order)
      if (!ignoreDirty) {
        if (cc.getParent() != cc.getPrevious()) {
          if (this.model.isVertex(cc.getParent()) || this.model.isEdge(cc.getParent())) {
            result = this.getBoundingBox(cc.getParent(), true, true);
          }

          if (this.model.isVertex(cc.getPrevious()) || this.model.isEdge(cc.getPrevious())) {
            if (result != null) {
              result.add(this.getBoundingBox(cc.getPrevious(), true, true));
            } else {
              result = this.getBoundingBox(cc.getPrevious(), true, true);
            }
          }
        }

        if (result == null) {
          result = this.getBoundingBox(cc.getChild(), true, true);
        }
      }

      if (invalidate) {
        if (cc.getParent() != null) {
          this.view.clear(cc.getChild(), false, true);
        } else {
          this.removeStateForCell(cc.getChild());
        }
      }
    } else if (change instanceof mxTerminalChange) {
      final Object cell = ((mxTerminalChange) change).getCell();

      if (!ignoreDirty) {
        result = this.getBoundingBox(cell, true);
      }

      if (invalidate) {
        this.view.invalidate(cell);
      }
    } else if (change instanceof mxValueChange) {
      final Object cell = ((mxValueChange) change).getCell();

      if (!ignoreDirty) {
        result = this.getBoundingBox(cell);
      }

      if (invalidate) {
        this.view.clear(cell, false, false);
      }
    } else if (change instanceof mxStyleChange) {
      final Object cell = ((mxStyleChange) change).getCell();

      if (!ignoreDirty) {
        result = this.getBoundingBox(cell, true);
      }

      if (invalidate) {
        // TODO: Add includeEdges argument to clear method for
        // not having to call invalidate in this case (where it
        // is possible that the perimeter has changed, which
        // means the connected edges need to be invalidated)
        this.view.clear(cell, false, false);
        this.view.invalidate(cell);
      }
    } else if (change instanceof mxGeometryChange) {
      final Object cell = ((mxGeometryChange) change).getCell();

      if (!ignoreDirty) {
        result = this.getBoundingBox(cell, true, true);
      }

      if (invalidate) {
        this.view.invalidate(cell);
      }
    } else if (change instanceof mxCollapseChange) {
      final Object cell = ((mxCollapseChange) change).getCell();

      if (!ignoreDirty) {
        result = this.getBoundingBox(((mxCollapseChange) change).getCell(), true, true);
      }

      if (invalidate) {
        this.removeStateForCell(cell);
      }
    } else if (change instanceof mxVisibleChange) {
      final Object cell = ((mxVisibleChange) change).getCell();

      if (!ignoreDirty) {
        result = this.getBoundingBox(((mxVisibleChange) change).getCell(), true, true);
      }

      if (invalidate) {
        this.removeStateForCell(cell);
      }
    }

    return result;
  }

  /**
   * Processes the changes and returns the minimal rectangle to be repainted in the buffer. A return
   * value of null means no repaint is required.
   */
  public mxRectangle processChanges(final List<mxUndoableChange> changes, final boolean invalidate,
      final boolean ignoreDirty) {
    mxRectangle bounds = null;
    final Iterator<mxUndoableChange> it = changes.iterator();

    while (it.hasNext()) {
      final mxRectangle rect = this.processChange(it.next(), invalidate, ignoreDirty);

      if (bounds == null) {
        bounds = rect;
      } else {
        bounds.add(rect);
      }
    }

    return bounds;
  }

  /**
   * Clears all cell states or the states for the hierarchy starting at the given cell and validates
   * the graph.
   */
  public void refresh() {
    this.view.reload();
    this.repaint();
  }

  /**
   * Removes the selection cells from the graph.
   *
   * @return Returns the cells that have been removed.
   */
  public Object[] removeCells() {
    return this.removeCells(null);
  }

  /**
   * Removes the given cells from the graph.
   *
   * @param cells Array of cells to remove.
   * @return Returns the cells that have been removed.
   */
  public Object[] removeCells(final Object[] cells) {
    return this.removeCells(cells, true);
  }

  /**
   * Removes the given cells from the graph including all connected edges if includeEdges is true.
   * The change is carried out using cellsRemoved. This method fires mxEvent.REMOVE_CELLS while the
   * transaction is in progress.
   *
   * @param cells Array of cells to remove. If null is specified then the selection cells which are
   *        deletable are used.
   * @param includeEdges Specifies if all connected edges should be removed as well.
   */
  public Object[] removeCells(Object[] cells, final boolean includeEdges) {
    if (cells == null) {
      cells = this.getDeletableCells(this.getSelectionCells());
    }

    // Adds all edges to the cells
    if (includeEdges) {
      cells = this.getDeletableCells(this.addAllEdges(cells));
    }

    this.model.beginUpdate();
    try {
      this.cellsRemoved(cells);
      this.fireEvent(
          new mxEventObject(mxEvent.REMOVE_CELLS, "cells", cells, "includeEdges", includeEdges));
    } finally {
      this.model.endUpdate();
    }

    return cells;
  }

  /**
   * Removes the selection cells from their parents and adds them to the default parent returned by
   * getDefaultParent.
   */
  public Object[] removeCellsFromParent() {
    return this.removeCellsFromParent(null);
  }

  /**
   * Removes the specified cells from their parents and adds them to the default parent.
   *
   * @param cells Array of cells to be removed from their parents.
   * @return Returns the cells that were removed from their parents.
   */
  public Object[] removeCellsFromParent(Object[] cells) {
    if (cells == null) {
      cells = this.getSelectionCells();
    }

    this.model.beginUpdate();
    try {
      final Object parent = this.getDefaultParent();
      final int index = this.model.getChildCount(parent);

      this.cellsAdded(cells, parent, index, null, null, true);
      this.fireEvent(new mxEventObject(mxEvent.REMOVE_CELLS_FROM_PARENT, "cells", cells));
    } finally {
      this.model.endUpdate();
    }

    return cells;
  }

  /**
   * Removes the specified bundle.
   */
  public void removeImageBundle(final mxImageBundle bundle) {
    mxGraph.imageBundles.remove(bundle);
  }

  /**
   * @param listener
   * @see java.beans.PropertyChangeSupport#removePropertyChangeListener(java.beans.PropertyChangeListener)
   */
  public void removePropertyChangeListener(final PropertyChangeListener listener) {
    this.changeSupport.removePropertyChangeListener(listener);
  }

  /**
   * @param propertyName
   * @param listener
   * @see java.beans.PropertyChangeSupport#removePropertyChangeListener(java.lang.String,
   *      java.beans.PropertyChangeListener)
   */
  public void removePropertyChangeListener(final String propertyName,
      final PropertyChangeListener listener) {
    this.changeSupport.removePropertyChangeListener(propertyName, listener);
  }

  /**
   *
   */
  public void removeSelectionCell(final Object cell) {
    this.selectionModel.removeCell(cell);
  }

  /**
   *
   */
  public void removeSelectionCells(final Object[] cells) {
    this.selectionModel.removeCells(cells);
  }

  /**
   * Removes all cached information for the given cell and its descendants. This is called when a
   * cell was removed from the model.
   *
   * @param cell Cell that was removed from the model.
   */
  protected void removeStateForCell(final Object cell) {
    final int childCount = this.model.getChildCount(cell);

    for (int i = 0; i < childCount; i++) {
      this.removeStateForCell(this.model.getChildAt(cell, i));
    }

    this.view.invalidate(cell);
    this.view.removeState(cell);
  }

  /**
   * Fires a repaint event.
   */
  public void repaint() {
    this.repaint(null);
  }

  /**
   * Fires a repaint event. The optional region is the rectangle that needs to be repainted.
   */
  public void repaint(final mxRectangle region) {
    this.fireEvent(new mxEventObject(mxEvent.REPAINT, "region", region));
  }

  /**
   * Resets the control points of the given edge.
   */
  public Object resetEdge(final Object edge) {
    mxGeometry geo = this.model.getGeometry(edge);

    if (geo != null) {
      // Resets the control points
      final List<mxPoint> points = geo.getPoints();

      if (points != null && !points.isEmpty()) {
        geo = (mxGeometry) geo.clone();
        geo.setPoints(null);
        this.model.setGeometry(edge, geo);
      }
    }

    return edge;
  }

  /**
   * Resets the control points of the edges that are connected to the given cells if not both ends
   * of the edge are in the given cells array.
   *
   * @param cells Array of mxCells for which the connected edges should be reset.
   */
  public void resetEdges(final Object[] cells) {
    if (cells != null) {
      // Prepares a hashtable for faster cell lookups
      final HashSet<Object> set = new HashSet<Object>(Arrays.asList(cells));

      this.model.beginUpdate();
      try {
        for (int i = 0; i < cells.length; i++) {
          final Object[] edges = mxGraphModel.getEdges(this.model, cells[i]);

          if (edges != null) {
            for (int j = 0; j < edges.length; j++) {
              final mxCellState state = this.view.getState(edges[j]);
              final Object source = state != null ? state.getVisibleTerminal(true)
                  : this.view.getVisibleTerminal(edges[j], true);
              final Object target = state != null ? state.getVisibleTerminal(false)
                  : this.view.getVisibleTerminal(edges[j], false);

              // Checks if one of the terminals is not in the given array
              if (!set.contains(source) || !set.contains(target)) {
                this.resetEdge(edges[j]);
              }
            }
          }

          this.resetEdges(mxGraphModel.getChildren(this.model, cells[i]));
        }
      } finally {
        this.model.endUpdate();
      }
    }
  }

  /**
   * Sets the bounds of the given cell using resizeCells. Returns the cell which was passed to the
   * function.
   *
   * @param cell <mxCell> whose bounds should be changed.
   * @param bounds <mxRectangle> that represents the new bounds.
   */
  public Object resizeCell(final Object cell, final mxRectangle bounds) {
    return this.resizeCells(new Object[] {cell}, new mxRectangle[] {bounds})[0];
  }

  /**
   * Sets the bounds of the given cells and fires a mxEvent.RESIZE_CELLS event. while the
   * transaction is in progress. Returns the cells which have been passed to the function.
   *
   * @param cells Array of cells whose bounds should be changed.
   * @param bounds Array of rectangles that represents the new bounds.
   */
  public Object[] resizeCells(final Object[] cells, final mxRectangle[] bounds) {
    this.model.beginUpdate();
    try {
      this.cellsResized(cells, bounds);
      this.fireEvent(new mxEventObject(mxEvent.RESIZE_CELLS, "cells", cells, "bounds", bounds));
    } finally {
      this.model.endUpdate();
    }

    return cells;
  }

  /**
   *
   */
  public void selectAll() {
    this.selectAll(null);
  }

  /**
   * Selects all children of the given parent cell or the children of the default parent if no
   * parent is specified. To select leaf vertices and/or edges use <selectCells>.
   *
   * @param parent Optional <mxCell> whose children should be selected. Default is <defaultParent>.
   */
  public void selectAll(Object parent) {
    if (parent == null) {
      parent = this.getDefaultParent();
    }

    final Object[] children = mxGraphModel.getChildren(this.model, parent);

    if (children != null) {
      this.setSelectionCells(children);
    }
  }

  /**
   * Selects the next, parent, first child or previous cell, if all arguments are false.
   *
   * @param isNext
   * @param isParent
   * @param isChild
   */
  public void selectCell(final boolean isNext, final boolean isParent, final boolean isChild) {
    final Object cell = this.getSelectionCell();

    if (this.getSelectionCount() > 1) {
      this.clearSelection();
    }

    final Object parent = cell != null ? this.model.getParent(cell) : this.getDefaultParent();
    final int childCount = this.model.getChildCount(parent);

    if (cell == null && childCount > 0) {
      final Object child = this.model.getChildAt(parent, 0);
      this.setSelectionCell(child);
    } else if ((cell == null || isParent) && this.view.getState(parent) != null
        && this.model.getGeometry(parent) != null) {
      if (this.getCurrentRoot() != parent) {
        this.setSelectionCell(parent);
      }
    } else if (cell != null && isChild) {
      final int tmp = this.model.getChildCount(cell);

      if (tmp > 0) {
        final Object child = this.model.getChildAt(cell, 0);
        this.setSelectionCell(child);
      }
    } else if (childCount > 0) {
      int i = ((mxICell) parent).getIndex((mxICell) cell);

      if (isNext) {
        i++;
        this.setSelectionCell(this.model.getChildAt(parent, i % childCount));
      } else {
        i--;
        final int index = i < 0 ? childCount - 1 : i;
        this.setSelectionCell(this.model.getChildAt(parent, index));
      }
    }
  }

  /**
   * Selects all vertices and/or edges depending on the given boolean arguments recursively,
   * starting at the default parent. Use <code>selectAll</code> to select all cells.
   *
   * @param vertices Boolean indicating if vertices should be selected.
   * @param edges Boolean indicating if edges should be selected.
   */
  public void selectCells(final boolean vertices, final boolean edges) {
    this.selectCells(vertices, edges, null);
  }

  /**
   * Selects all vertices and/or edges depending on the given boolean arguments recursively,
   * starting at the given parent or the default parent if no parent is specified. Use
   * <code>selectAll</code> to select all cells.
   *
   * @param vertices Boolean indicating if vertices should be selected.
   * @param edges Boolean indicating if edges should be selected.
   * @param parent Optional cell that acts as the root of the recursion. Default is
   *        <code>defaultParent</code>.
   */
  public void selectCells(final boolean vertices, final boolean edges, Object parent) {
    if (parent == null) {
      parent = this.getDefaultParent();
    }

    final Collection<Object> cells =
        mxGraphModel.filterDescendants(this.getModel(), new mxGraphModel.Filter() {

          /**
           *
           */
          @Override
          public boolean filter(final Object cell) {
            return mxGraph.this.view.getState(cell) != null
                && mxGraph.this.model.getChildCount(cell) == 0
                && (mxGraph.this.model.isVertex(cell) && vertices
                    || mxGraph.this.model.isEdge(cell) && edges);
          }

        });
    this.setSelectionCells(cells);
  }

  /**
   * Selects the first child cell.
   */
  public void selectChildCell() {
    this.selectCell(false, false, true);
  }

  /**
   * Selects all vertices inside the default parent.
   */
  public void selectEdges() {
    this.selectEdges(null);
  }

  /**
   * Selects all vertices inside the given parent or the default parent if no parent is given.
   */
  public void selectEdges(final Object parent) {
    this.selectCells(false, true, parent);
  }

  /**
   * Selects the next cell.
   */
  public void selectNextCell() {
    this.selectCell(true, false, false);
  }

  /**
   * Selects the parent cell.
   */
  public void selectParentCell() {
    this.selectCell(false, true, false);
  }

  /**
   * Selects the previous cell.
   */
  public void selectPreviousCell() {
    this.selectCell(false, false, false);
  }

  /**
   * Selects all vertices inside the default parent.
   */
  public void selectVertices() {
    this.selectVertices(null);
  }

  /**
   * Selects all vertices inside the given parent or the default parent if no parent is given.
   */
  public void selectVertices(final Object parent) {
    this.selectCells(true, false, parent);
  }

  /**
   * Sets allowDanglingEdges.
   */
  public void setAllowDanglingEdges(final boolean value) {
    final boolean oldValue = this.allowDanglingEdges;
    this.allowDanglingEdges = value;

    this.changeSupport.firePropertyChange("allowDanglingEdges", oldValue, this.allowDanglingEdges);
  }

  /**
   * Sets allowLoops.
   */
  public void setAllowLoops(final boolean value) {
    final boolean oldValue = this.allowLoops;
    this.allowLoops = value;

    this.changeSupport.firePropertyChange("allowLoops", oldValue, this.allowLoops);
  }

  /**
   * @param value the allowNegativeCoordinates to set
   */
  public void setAllowNegativeCoordinates(final boolean value) {
    final boolean oldValue = this.allowNegativeCoordinates;
    this.allowNegativeCoordinates = value;

    this.changeSupport.firePropertyChange("allowNegativeCoordinates", oldValue,
        this.allowNegativeCoordinates);
  }

  /**
   * Sets alternateEdgeStyle.
   */
  public void setAlternateEdgeStyle(final String value) {
    final String oldValue = this.alternateEdgeStyle;
    this.alternateEdgeStyle = value;

    this.changeSupport.firePropertyChange("alternateEdgeStyle", oldValue, this.alternateEdgeStyle);
  }

  /**
   * @param value the autoOrigin to set
   */
  public void setAutoOrigin(final boolean value) {
    final boolean oldValue = this.autoOrigin;
    this.autoOrigin = value;

    this.changeSupport.firePropertyChange("autoOrigin", oldValue, this.autoOrigin);
  }

  /**
   * Specifies if cell sizes should be automatically updated after a label change. This
   * implementation sets autoSize to the given parameter.
   *
   * @param value Boolean indicating if cells should be resized automatically.
   */
  public void setAutoSizeCells(final boolean value) {
    final boolean oldValue = this.autoSizeCells;
    this.autoSizeCells = value;

    this.changeSupport.firePropertyChange("autoSizeCells", oldValue, this.autoSizeCells);
  }

  /**
   * Sets the value of <border>.
   *
   * @param value Positive integer that represents the border to be used.
   */
  public void setBorder(final int value) {
    this.border = value;
  }

  /**
   * Sets cellsBendable.
   */
  public void setCellsBendable(final boolean value) {
    final boolean oldValue = this.cellsBendable;
    this.cellsBendable = value;

    this.changeSupport.firePropertyChange("cellsBendable", oldValue, this.cellsBendable);
  }

  /**
   * Specifies if the graph should allow cloning of cells by holding down the control key while
   * cells are being moved. This implementation updates cellsCloneable.
   *
   * @param value Boolean indicating if the graph should be cloneable.
   */
  public void setCellsCloneable(final boolean value) {
    final boolean oldValue = this.cellsCloneable;
    this.cellsCloneable = value;

    this.changeSupport.firePropertyChange("cellsCloneable", oldValue, this.cellsCloneable);
  }

  /**
   * Sets cellsDeletable.
   */
  public void setCellsDeletable(final boolean value) {
    final boolean oldValue = this.cellsDeletable;
    this.cellsDeletable = value;

    this.changeSupport.firePropertyChange("cellsDeletable", oldValue, this.cellsDeletable);
  }

  /**
   * Sets cellsDisconnectable.
   *
   * @param value Boolean indicating if the graph should allow disconnecting of edges.
   */
  public void setCellsDisconnectable(final boolean value) {
    final boolean oldValue = this.cellsDisconnectable;
    this.cellsDisconnectable = value;

    this.changeSupport.firePropertyChange("cellsDisconnectable", oldValue,
        this.cellsDisconnectable);
  }

  /**
   * Sets if the graph is editable.
   */
  public void setCellsEditable(final boolean value) {
    final boolean oldValue = this.cellsEditable;
    this.cellsEditable = value;

    this.changeSupport.firePropertyChange("cellsEditable", oldValue, this.cellsEditable);
  }

  /**
   * Sets cellsLocked, the default return value for isCellLocked and fires a property change event
   * for cellsLocked.
   */
  public void setCellsLocked(final boolean value) {
    final boolean oldValue = this.cellsLocked;
    this.cellsLocked = value;

    this.changeSupport.firePropertyChange("cellsLocked", oldValue, this.cellsLocked);
  }

  /**
   * Sets cellsMovable.
   */
  public void setCellsMovable(final boolean value) {
    final boolean oldValue = this.cellsMovable;
    this.cellsMovable = value;

    this.changeSupport.firePropertyChange("cellsMovable", oldValue, this.cellsMovable);
  }

  /**
   * Sets if the graph is resizable.
   */
  public void setCellsResizable(final boolean value) {
    final boolean oldValue = this.cellsResizable;
    this.cellsResizable = value;

    this.changeSupport.firePropertyChange("cellsResizable", oldValue, this.cellsResizable);
  }

  /**
   * Sets cellsSelectable.
   */
  public void setCellsSelectable(final boolean value) {
    final boolean oldValue = this.cellsSelectable;
    this.cellsSelectable = value;

    this.changeSupport.firePropertyChange("cellsSelectable", oldValue, this.cellsSelectable);
  }

  /**
   * Sets the style of the selection cells to the given value.
   *
   * @param style String representing the new style of the cells.
   */
  public Object[] setCellStyle(final String style) {
    return this.setCellStyle(style, null);
  }

  /**
   * Sets the style of the specified cells. If no cells are given, then the selection cells are
   * changed.
   *
   * @param style String representing the new style of the cells.
   * @param cells Optional array of <mxCells> to set the style for. Default is the selection cells.
   */
  public Object[] setCellStyle(final String style, Object[] cells) {
    if (cells == null) {
      cells = this.getSelectionCells();
    }

    if (cells != null) {
      this.model.beginUpdate();
      try {
        for (int i = 0; i < cells.length; i++) {
          this.model.setStyle(cells[i], style);
        }
      } finally {
        this.model.endUpdate();
      }
    }

    return cells;
  }

  /**
   * Sets or toggles the given bit for the given key in the styles of the selection cells.
   *
   * @param key String representing the key to toggle the flag in.
   * @param flag Integer that represents the bit to be toggled.
   * @param value Boolean value to be used or null if the value should be toggled.
   */
  public Object[] setCellStyleFlags(final String key, final int flag, final boolean value) {
    return this.setCellStyleFlags(key, flag, value, null);
  }

  /**
   * Sets or toggles the given bit for the given key in the styles of the specified cells.
   *
   * @param key String representing the key to toggle the flag in.
   * @param flag Integer that represents the bit to be toggled.
   * @param value Boolean value to be used or null if the value should be toggled.
   * @param cells Optional array of cells to change the style for. If no cells are specified then
   *        the selection cells are used.
   */
  public Object[] setCellStyleFlags(final String key, final int flag, Boolean value,
      Object[] cells) {
    if (cells == null) {
      cells = this.getSelectionCells();
    }

    if (cells != null && cells.length > 0) {
      if (value == null) {
        final mxCellState state = this.view.getState(cells[0]);
        final Map<String, Object> style =
            state != null ? state.getStyle() : this.getCellStyle(cells[0]);

        if (style != null) {
          final int current = mxUtils.getInt(style, key);
          value = !((current & flag) == flag);
        }
      }

      mxStyleUtils.setCellStyleFlags(this.model, cells, key, flag, value);
    }

    return cells;
  }

  /**
   * Sets the key to value in the styles of the selection cells.
   *
   * @param key String representing the key to be assigned.
   * @param value String representing the new value for the key.
   */
  public Object[] setCellStyles(final String key, final String value) {
    return this.setCellStyles(key, value, null);
  }

  /**
   * Sets the key to value in the styles of the given cells. This will modify the existing cell
   * styles in-place and override any existing assignment for the given key. If no cells are
   * specified, then the selection cells are changed. If no value is specified, then the respective
   * key is removed from the styles.
   *
   * @param key String representing the key to be assigned.
   * @param value String representing the new value for the key.
   * @param cells Array of cells to change the style for.
   */
  public Object[] setCellStyles(final String key, final String value, Object[] cells) {
    if (cells == null) {
      cells = this.getSelectionCells();
    }

    mxStyleUtils.setCellStyles(this.model, cells, key, value);

    return cells;
  }

  /**
   * @param value the changesRepaintThreshold to set
   */
  public void setChangesRepaintThreshold(final int value) {
    final int oldValue = this.changesRepaintThreshold;
    this.changesRepaintThreshold = value;

    this.changeSupport.firePropertyChange("changesRepaintThreshold", oldValue,
        this.changesRepaintThreshold);
  }

  /**
   * Sets cloneInvalidEdge.
   */
  public void setCloneInvalidEdges(final boolean value) {
    final boolean oldValue = this.cloneInvalidEdges;
    this.cloneInvalidEdges = value;

    this.changeSupport.firePropertyChange("cloneInvalidEdges", oldValue, this.cloneInvalidEdges);
  }

  /**
   * @param value the collapseToPreferredSize to set
   */
  public void setCollapseToPreferredSize(final boolean value) {
    final boolean oldValue = this.collapseToPreferredSize;
    this.collapseToPreferredSize = value;

    this.changeSupport.firePropertyChange("collapseToPreferredSize", oldValue,
        this.collapseToPreferredSize);
  };

  //
  // Cell retrieval
  //

  /**
   * Sets connetableEdges.
   */
  public void setConnectableEdges(final boolean value) {
    final boolean oldValue = this.connectableEdges;
    this.connectableEdges = value;

    this.changeSupport.firePropertyChange("connectableEdges", oldValue, this.connectableEdges);

  }

  /**
   * Sets the connection constraint that describes the given connection point. If no constraint is
   * given then nothing is changed. To remove an existing constraint from the given edge, use an
   * empty constraint instead.
   *
   * @param edge Cell that represents the edge.
   * @param terminal Cell that represents the terminal.
   * @param source Boolean indicating if the terminal is the source or target.
   * @param constraint Optional connection constraint to be used for this connection.
   */
  public void setConnectionConstraint(final Object edge, final Object terminal,
      final boolean source, final mxConnectionConstraint constraint) {
    if (constraint != null) {
      this.model.beginUpdate();
      try {
        final Object[] cells = new Object[] {edge};

        // FIXME, constraint can't be null, we've checked that above
        if (constraint == null || constraint.point == null) {
          this.setCellStyles(source ? mxConstants.STYLE_EXIT_X : mxConstants.STYLE_ENTRY_X, null,
              cells);
          this.setCellStyles(source ? mxConstants.STYLE_EXIT_Y : mxConstants.STYLE_ENTRY_Y, null,
              cells);
          this.setCellStyles(
              source ? mxConstants.STYLE_EXIT_PERIMETER : mxConstants.STYLE_ENTRY_PERIMETER, null,
              cells);
        } else if (constraint.point != null) {
          this.setCellStyles(source ? mxConstants.STYLE_EXIT_X : mxConstants.STYLE_ENTRY_X,
              String.valueOf(constraint.point.getX()), cells);
          this.setCellStyles(source ? mxConstants.STYLE_EXIT_Y : mxConstants.STYLE_ENTRY_Y,
              String.valueOf(constraint.point.getY()), cells);

          // Only writes 0 since 1 is default
          if (!constraint.perimeter) {
            this.setCellStyles(
                source ? mxConstants.STYLE_EXIT_PERIMETER : mxConstants.STYLE_ENTRY_PERIMETER, "0",
                cells);
          } else {
            this.setCellStyles(
                source ? mxConstants.STYLE_EXIT_PERIMETER : mxConstants.STYLE_ENTRY_PERIMETER, null,
                cells);
          }
        }
      } finally {
        this.model.endUpdate();
      }
    }
  }

  /**
   * @param value the constrainChildren to set
   */
  public void setConstrainChildren(final boolean value) {
    final boolean oldValue = this.constrainChildren;
    this.constrainChildren = value;

    this.changeSupport.firePropertyChange("constrainChildren", oldValue, this.constrainChildren);
  }

  /**
   * Sets the default style used for loops.
   *
   * @param value Default style to be used for loops.
   */
  public void setDefaultLoopStyle(final mxEdgeStyle.mxEdgeStyleFunction value) {
    final mxEdgeStyle.mxEdgeStyleFunction oldValue = this.defaultLoopStyle;
    this.defaultLoopStyle = value;

    this.changeSupport.firePropertyChange("defaultLoopStyle", oldValue, this.defaultLoopStyle);
  }

  /**
   * Sets defaultOverlap.
   */
  public void setDefaultOverlap(final double value) {
    final double oldValue = this.defaultOverlap;
    this.defaultOverlap = value;

    this.changeSupport.firePropertyChange("defaultOverlap", oldValue, value);
  }

  /**
   * Sets the default parent to be returned by getDefaultParent. Set this to null to return the
   * first child of the root in getDefaultParent.
   */
  public void setDefaultParent(final Object value) {
    this.defaultParent = value;
  }

  /**
   * Sets disconnectOnMove.
   */
  public void setDisconnectOnMove(final boolean value) {
    final boolean oldValue = this.disconnectOnMove;
    this.disconnectOnMove = value;

    this.changeSupport.firePropertyChange("disconnectOnMove", oldValue, this.disconnectOnMove);

  }

  /**
   * Sets dropEnabled.
   */
  public void setDropEnabled(final boolean value) {
    final boolean oldValue = this.dropEnabled;
    this.dropEnabled = value;

    this.changeSupport.firePropertyChange("dropEnabled", oldValue, this.dropEnabled);
  }

  /**
   * Returns edgeLabelsMovable.
   */
  public void setEdgeLabelsMovable(final boolean value) {
    final boolean oldValue = this.edgeLabelsMovable;
    this.edgeLabelsMovable = value;

    this.changeSupport.firePropertyChange("edgeLabelsMovable", oldValue, this.edgeLabelsMovable);
  }

  /**
   * Specifies if the graph should allow any interactions. This implementation updates <enabled>.
   *
   * @param value Boolean indicating if the graph should be enabled.
   */
  public void setEnabled(final boolean value) {
    final boolean oldValue = this.enabled;
    this.enabled = value;

    this.changeSupport.firePropertyChange("enabled", oldValue, this.enabled);
  }

  /**
   * Sets extendParents.
   */
  public void setExtendParents(final boolean value) {
    final boolean oldValue = this.extendParents;
    this.extendParents = value;

    this.changeSupport.firePropertyChange("extendParents", oldValue, this.extendParents);
  }

  /**
   * Sets extendParentsOnAdd.
   */
  public void setExtendParentsOnAdd(final boolean value) {
    final boolean oldValue = this.extendParentsOnAdd;
    this.extendParentsOnAdd = value;

    this.changeSupport.firePropertyChange("extendParentsOnAdd", oldValue, this.extendParentsOnAdd);
  }

  /**
   * Sets if the grid is enabled.
   *
   * @param value Specifies if the grid should be enabled.
   */
  public void setGridEnabled(final boolean value) {
    final boolean oldValue = this.gridEnabled;
    this.gridEnabled = value;

    this.changeSupport.firePropertyChange("gridEnabled", oldValue, this.gridEnabled);
  }

  /**
   * Sets the grid size and fires a property change event for gridSize.
   *
   * @param value New grid size to be used.
   */
  public void setGridSize(final int value) {
    final int oldValue = this.gridSize;
    this.gridSize = value;

    this.changeSupport.firePropertyChange("gridSize", oldValue, this.gridSize);
  }

  /**
   * @param value the htmlLabels to set
   */
  public void setHtmlLabels(final boolean value) {
    final boolean oldValue = this.htmlLabels;
    this.htmlLabels = value;

    this.changeSupport.firePropertyChange("htmlLabels", oldValue, this.htmlLabels);
  }

  /**
   * @param value the keepEdgesInBackground to set
   */
  public void setKeepEdgesInBackground(final boolean value) {
    final boolean oldValue = this.keepEdgesInBackground;
    this.keepEdgesInBackground = value;

    this.changeSupport.firePropertyChange("keepEdgesInBackground", oldValue,
        this.keepEdgesInBackground);
  }

  /**
   * @param value the keepEdgesInForeground to set
   */
  public void setKeepEdgesInForeground(final boolean value) {
    final boolean oldValue = this.keepEdgesInForeground;
    this.keepEdgesInForeground = value;

    this.changeSupport.firePropertyChange("keepEdgesInForeground", oldValue,
        this.keepEdgesInForeground);
  }

  /**
   * Sets labelsClipped.
   */
  public void setLabelsClipped(final boolean value) {
    final boolean oldValue = this.labelsClipped;
    this.labelsClipped = value;

    this.changeSupport.firePropertyChange("labelsClipped", oldValue, this.labelsClipped);
  }

  /**
   * @param value the labelsVisible to set
   */
  public void setLabelsVisible(final boolean value) {
    final boolean oldValue = this.labelsVisible;
    this.labelsVisible = value;

    this.changeSupport.firePropertyChange("labelsVisible", oldValue, this.labelsVisible);
  }

  /**
   * @param value the maximumGraphBounds to set
   */
  public void setMaximumGraphBounds(final mxRectangle value) {
    final mxRectangle oldValue = this.maximumGraphBounds;
    this.maximumGraphBounds = value;

    this.changeSupport.firePropertyChange("maximumGraphBounds", oldValue, this.maximumGraphBounds);
  }

  /**
   * @param value the minimumGraphSize to set
   */
  public void setMinimumGraphSize(final mxRectangle value) {
    final mxRectangle oldValue = this.minimumGraphSize;
    this.minimumGraphSize = value;

    this.changeSupport.firePropertyChange("minimumGraphSize", oldValue, value);
  }

  /**
   * Sets the graph model that contains the data, and fires an mxEvent.CHANGE followed by an
   * mxEvent.REPAINT event.
   *
   * @param value Model that contains the graph data
   */
  public void setModel(final mxIGraphModel value) {
    if (this.model != null) {
      this.model.removeListener(this.graphModelChangeHandler);
    }

    final Object oldModel = this.model;
    this.model = value;

    if (this.view != null) {
      this.view.revalidate();
    }

    this.model.addListener(mxEvent.CHANGE, this.graphModelChangeHandler);
    this.changeSupport.firePropertyChange("model", oldModel, this.model);
    this.repaint();
  }

  /**
   * Sets multigraph.
   */
  public void setMultigraph(final boolean value) {
    final boolean oldValue = this.multigraph;
    this.multigraph = value;

    this.changeSupport.firePropertyChange("multigraph", oldValue, this.multigraph);
  }

  /**
   *
   */
  public void setMultiplicities(final mxMultiplicity[] value) {
    final mxMultiplicity[] oldValue = this.multiplicities;
    this.multiplicities = value;

    this.changeSupport.firePropertyChange("multiplicities", oldValue, this.multiplicities);
  }

  /**
   * @param value the origin to set
   */
  public void setOrigin(final mxPoint value) {
    final mxPoint oldValue = this.origin;
    this.origin = value;

    this.changeSupport.firePropertyChange("origin", oldValue, this.origin);
  }

  /**
   * Sets if ports are enabled.
   *
   * @param value Specifies if the ports should be enabled.
   */
  public void setPortsEnabled(final boolean value) {
    final boolean oldValue = this.portsEnabled;
    this.portsEnabled = value;

    this.changeSupport.firePropertyChange("portsEnabled", oldValue, this.portsEnabled);
  }

  /**
   * Sets resetEdgesOnConnect.
   */
  public void setResetEdgesOnConnect(final boolean value) {
    final boolean oldValue = this.resetEdgesOnConnect;
    this.resetEdgesOnConnect = value;

    this.changeSupport.firePropertyChange("resetEdgesOnConnect", oldValue, this.resetEdgesOnResize);
  }

  /**
   * Sets resetEdgesOnMove.
   */
  public void setResetEdgesOnMove(final boolean value) {
    final boolean oldValue = this.resetEdgesOnMove;
    this.resetEdgesOnMove = value;

    this.changeSupport.firePropertyChange("resetEdgesOnMove", oldValue, this.resetEdgesOnMove);
  }

  //
  // Selection
  //

  /**
   * Sets resetEdgesOnResize.
   */
  public void setResetEdgesOnResize(final boolean value) {
    final boolean oldValue = this.resetEdgesOnResize;
    this.resetEdgesOnResize = value;

    this.changeSupport.firePropertyChange("resetEdgesOnResize", oldValue, this.resetEdgesOnResize);
  }

  /**
   * Sets resetEdgesOnResize.
   */
  public void setResetViewOnRootChange(final boolean value) {
    final boolean oldValue = this.resetViewOnRootChange;
    this.resetViewOnRootChange = value;

    this.changeSupport.firePropertyChange("resetViewOnRootChange", oldValue,
        this.resetViewOnRootChange);
  }

  /**
   *
   * @param cell
   */
  public void setSelectionCell(final Object cell) {
    this.selectionModel.setCell(cell);
  }

  /**
   *
   * @param cells
   */
  public void setSelectionCells(final Collection<Object> cells) {
    if (cells != null) {
      this.setSelectionCells(cells.toArray());
    }
  }

  /**
   *
   */
  public void setSelectionCells(final Object[] cells) {
    this.selectionModel.setCells(cells);
  }

  /**
   * Sets splitEnabled.
   */
  public void setSplitEnabled(final boolean value) {
    this.splitEnabled = value;
  }

  /**
   * Sets the stylesheet that provides the style.
   *
   * @param value Stylesheet that provides the style.
   */
  public void setStylesheet(final mxStylesheet value) {
    final mxStylesheet oldValue = this.stylesheet;
    this.stylesheet = value;

    this.changeSupport.firePropertyChange("stylesheet", oldValue, this.stylesheet);
  }

  /**
   * Sets swimlaneNesting.
   */
  public void setSwimlaneNesting(final boolean value) {
    final boolean oldValue = this.swimlaneNesting;
    this.swimlaneNesting = value;

    this.changeSupport.firePropertyChange("swimlaneNesting", oldValue, this.swimlaneNesting);
  }

  /**
   * Sets vertexLabelsMovable.
   */
  public void setVertexLabelsMovable(final boolean value) {
    final boolean oldValue = this.vertexLabelsMovable;
    this.vertexLabelsMovable = value;

    this.changeSupport.firePropertyChange("vertexLabelsMovable", oldValue,
        this.vertexLabelsMovable);
  }

  /**
   * Sets the view that contains the cell states.
   *
   * @param value View that contains the cell states
   */
  public void setView(final mxGraphView value) {
    if (this.view != null) {
      this.view.removeListener(this.fullRepaintHandler);
      this.view.removeListener(this.updateOriginHandler);
    }

    final Object oldView = this.view;
    this.view = value;

    if (this.view != null) {
      this.view.revalidate();
    }

    // Listens to changes in the view
    this.view.addListener(mxEvent.SCALE, this.fullRepaintHandler);
    this.view.addListener(mxEvent.SCALE, this.updateOriginHandler);
    this.view.addListener(mxEvent.TRANSLATE, this.fullRepaintHandler);
    this.view.addListener(mxEvent.SCALE_AND_TRANSLATE, this.fullRepaintHandler);
    this.view.addListener(mxEvent.SCALE_AND_TRANSLATE, this.updateOriginHandler);
    this.view.addListener(mxEvent.UP, this.fullRepaintHandler);
    this.view.addListener(mxEvent.DOWN, this.fullRepaintHandler);

    this.changeSupport.firePropertyChange("view", oldView, this.view);
  }

  /**
   * Snaps the given numeric value to the grid if <gridEnabled> is true.
   *
   * @param value Numeric value to be snapped to the grid.
   * @return Returns the value aligned to the grid.
   */
  public double snap(double value) {
    if (this.gridEnabled) {
      value = Math.round(value / this.gridSize) * this.gridSize;
    }

    return value;
  }

  /**
   *
   */
  public Object splitEdge(final Object edge, final Object[] cells) {
    return this.splitEdge(edge, cells, null, 0, 0);
  }

  /**
   *
   */
  public Object splitEdge(final Object edge, final Object[] cells, final double dx,
      final double dy) {
    return this.splitEdge(edge, cells, null, dx, dy);
  }

  /**
   * Splits the given edge by adding a newEdge between the previous source and the given cell and
   * reconnecting the source of the given edge to the given cell. Fires mxEvent.SPLIT_EDGE while the
   * transaction is in progress.
   *
   * @param edge Object that represents the edge to be splitted.
   * @param cells Array that contains the cells to insert into the edge.
   * @param newEdge Object that represents the edge to be inserted.
   * @return Returns the new edge that has been inserted.
   */
  public Object splitEdge(final Object edge, final Object[] cells, Object newEdge, final double dx,
      final double dy) {
    if (newEdge == null) {
      newEdge = this.cloneCells(new Object[] {edge})[0];
    }

    final Object parent = this.model.getParent(edge);
    final Object source = this.model.getTerminal(edge, true);

    this.model.beginUpdate();
    try {
      this.cellsMoved(cells, dx, dy, false, false);
      this.cellsAdded(cells, parent, this.model.getChildCount(parent), null, null, true);
      this.cellsAdded(new Object[] {newEdge}, parent, this.model.getChildCount(parent), source,
          cells[0], false);
      this.cellConnected(edge, cells[0], true, null);
      this.fireEvent(new mxEventObject(mxEvent.SPLIT_EDGE, "edge", edge, "cells", cells, "newEdge",
          newEdge, "dx", dx, "dy", dy));
    } finally {
      this.model.endUpdate();
    }

    return newEdge;
  }

  /**
   * Swaps the alternate and the actual bounds in the geometry of the given cell invoking
   * updateAlternateBounds before carrying out the swap.
   *
   * @param cell Cell for which the bounds should be swapped.
   * @param willCollapse Boolean indicating if the cell is going to be collapsed.
   */
  public void swapBounds(final Object cell, final boolean willCollapse) {
    if (cell != null) {
      mxGeometry geo = this.model.getGeometry(cell);

      if (geo != null) {
        geo = (mxGeometry) geo.clone();

        this.updateAlternateBounds(cell, geo, willCollapse);
        geo.swap();

        this.model.setGeometry(cell, geo);
      }
    }
  }

  /**
   * Sets the visible state of the selection cells. This is a shortcut method.
   *
   * @param show Boolean that specifies the visible state to be assigned.
   * @return Returns the cells whose visible state was changed.
   */
  public Object[] toggleCells(final boolean show) {
    return this.toggleCells(show, null);
  }

  /**
   * Sets the visible state of the specified cells. This is a shortcut method.
   *
   * @param show Boolean that specifies the visible state to be assigned.
   * @param cells Array of cells whose visible state should be changed.
   * @return Returns the cells whose visible state was changed.
   */
  public Object[] toggleCells(final boolean show, final Object[] cells) {
    return this.toggleCells(show, cells, true);
  }

  /**
   * Sets the visible state of the specified cells and all connected edges if includeEdges is true.
   * The change is carried out using cellsToggled. This method fires mxEvent.TOGGLE_CELLS while the
   * transaction is in progress.
   *
   * @param show Boolean that specifies the visible state to be assigned.
   * @param cells Array of cells whose visible state should be changed. If null is specified then
   *        the selection cells are used.
   * @return Returns the cells whose visible state was changed.
   */
  public Object[] toggleCells(final boolean show, Object[] cells, final boolean includeEdges) {
    if (cells == null) {
      cells = this.getSelectionCells();
    }

    // Adds all connected edges recursively
    if (includeEdges) {
      cells = this.addAllEdges(cells);
    }

    this.model.beginUpdate();
    try {
      this.cellsToggled(cells, show);
      this.fireEvent(new mxEventObject(mxEvent.TOGGLE_CELLS, "show", show, "cells", cells,
          "includeEdges", includeEdges));
    } finally {
      this.model.endUpdate();
    }

    return cells;
  }

  /**
   * Toggles the boolean value for the given key in the style of the given cell. If no cell is
   * specified then the selection cell is used.
   *
   * @param key Key for the boolean value to be toggled.
   * @param defaultValue Default boolean value if no value is defined.
   * @param cell Cell whose style should be modified.
   */
  public Object toggleCellStyle(final String key, final boolean defaultValue, final Object cell) {
    return this.toggleCellStyles(key, defaultValue, new Object[] {cell})[0];
  }

  /**
   * Toggles the given bit for the given key in the styles of the selection cells.
   *
   * @param key String representing the key to toggle the flag in.
   * @param flag Integer that represents the bit to be toggled.
   */
  public Object[] toggleCellStyleFlags(final String key, final int flag) {
    return this.toggleCellStyleFlags(key, flag, null);
  }

  /**
   * Toggles the given bit for the given key in the styles of the specified cells.
   *
   * @param key String representing the key to toggle the flag in.
   * @param flag Integer that represents the bit to be toggled.
   * @param cells Optional array of <mxCells> to change the style for. Default is the selection
   *        cells.
   */
  public Object[] toggleCellStyleFlags(final String key, final int flag, final Object[] cells) {
    return this.setCellStyleFlags(key, flag, null, cells);
  }

  /**
   * Toggles the boolean value for the given key in the style of the selection cells.
   *
   * @param key Key for the boolean value to be toggled.
   * @param defaultValue Default boolean value if no value is defined.
   */
  public Object[] toggleCellStyles(final String key, final boolean defaultValue) {
    return this.toggleCellStyles(key, defaultValue, null);
  }

  /**
   * Toggles the boolean value for the given key in the style of the given cells. If no cells are
   * specified, then the selection cells are used. For example, this can be used to toggle
   * mxConstants.STYLE_ROUNDED or any other style with a boolean value.
   *
   * @param key String representing the key of the boolean style to be toggled.
   * @param defaultValue Default boolean value if no value is defined.
   * @param cells Cells whose styles should be modified.
   */
  public Object[] toggleCellStyles(final String key, final boolean defaultValue, Object[] cells) {
    if (cells == null) {
      cells = this.getSelectionCells();
    }

    if (cells != null && cells.length > 0) {
      final mxCellState state = this.view.getState(cells[0]);
      final Map<String, Object> style =
          state != null ? state.getStyle() : this.getCellStyle(cells[0]);

      if (style != null) {
        final String value = mxUtils.isTrue(style, key, defaultValue) ? "0" : "1";
        this.setCellStyles(key, value, cells);
      }
    }

    return cells;
  }

  /**
   * Translates the geometry of the given cell and stores the new, translated geometry in the model
   * as an atomic change.
   */
  public void translateCell(final Object cell, final double dx, final double dy) {
    mxGeometry geo = this.model.getGeometry(cell);

    if (geo != null) {
      geo = (mxGeometry) geo.clone();
      geo.translate(dx, dy);

      if (!geo.isRelative() && this.model.isVertex(cell) && !this.isAllowNegativeCoordinates()) {
        geo.setX(Math.max(0, geo.getX()));
        geo.setY(Math.max(0, geo.getY()));
      }

      if (geo.isRelative() && !this.model.isEdge(cell)) {
        if (geo.getOffset() == null) {
          geo.setOffset(new mxPoint(dx, dy));
        } else {
          final mxPoint offset = geo.getOffset();

          offset.setX(offset.getX() + dx);
          offset.setY(offset.getY() + dy);
        }
      }

      this.model.setGeometry(cell, geo);
    }
  }

  /**
   * Traverses the tree starting at the given vertex. Here is how to use this method for a given
   * vertex (root) which is typically the root of a tree: <code>
   * graph.traverse(root, true, new mxICellVisitor()
   * {
   *   public boolean visit(Object vertex, Object edge)
   *   {
   *     System.out.println("edge="+graph.convertValueToString(edge)+
   *       " vertex="+graph.convertValueToString(vertex));
   *
   *     return true;
   *   }
   * });
   * </code>
   *
   * @param vertex
   * @param directed
   * @param visitor
   */
  public void traverse(final Object vertex, final boolean directed, final mxICellVisitor visitor) {
    this.traverse(vertex, directed, visitor, null, null);
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
   * @param visitor Visitor that takes the current vertex and the incoming edge. The traversal stops
   *        if the function returns false.
   * @param edge Optional <mxCell> that represents the incoming edge. This is null for the first
   *        step of the traversal.
   * @param visited Optional array of cell paths for the visited cells.
   */
  public void traverse(final Object vertex, final boolean directed, final mxICellVisitor visitor,
      final Object edge, Set<Object> visited) {
    if (vertex != null && visitor != null) {
      if (visited == null) {
        visited = new HashSet<Object>();
      }

      if (!visited.contains(vertex)) {
        visited.add(vertex);

        if (visitor.visit(vertex, edge)) {
          final int edgeCount = this.model.getEdgeCount(vertex);

          if (edgeCount > 0) {
            for (int i = 0; i < edgeCount; i++) {
              final Object e = this.model.getEdgeAt(vertex, i);
              final boolean isSource = this.model.getTerminal(e, true) == vertex;

              if (!directed || isSource) {
                final Object next = this.model.getTerminal(e, !isSource);
                this.traverse(next, directed, visitor, e, visited);
              }
            }
          }
        }
      }
    }
  }

  /**
   * Ungroups the selection cells. This is a shortcut method.
   */
  public Object[] ungroupCells() {
    return this.ungroupCells(null);
  }

  //
  // Images and drawing
  //

  /**
   * Ungroups the given cells by moving the children the children to their parents parent and
   * removing the empty groups.
   *
   * @param cells Array of cells to be ungrouped. If null is specified then the selection cells are
   *        used.
   * @return Returns the children that have been removed from the groups.
   */
  public Object[] ungroupCells(Object[] cells) {
    final List<Object> result = new ArrayList<Object>();

    if (cells == null) {
      cells = this.getSelectionCells();

      // Finds the cells with children
      final List<Object> tmp = new ArrayList<Object>(cells.length);

      for (int i = 0; i < cells.length; i++) {
        if (this.model.getChildCount(cells[i]) > 0) {
          tmp.add(cells[i]);
        }
      }

      cells = tmp.toArray();
    }

    if (cells != null && cells.length > 0) {
      this.model.beginUpdate();
      try {
        for (int i = 0; i < cells.length; i++) {
          final Object[] children = mxGraphModel.getChildren(this.model, cells[i]);

          if (children != null && children.length > 0) {
            final Object parent = this.model.getParent(cells[i]);
            final int index = this.model.getChildCount(parent);

            this.cellsAdded(children, parent, index, null, null, true);
            result.addAll(Arrays.asList(children));
          }
        }

        this.cellsRemoved(this.addAllEdges(cells));
        this.fireEvent(new mxEventObject(mxEvent.UNGROUP_CELLS, "cells", cells));
      } finally {
        this.model.endUpdate();
      }
    }

    return result.toArray();
  }

  /**
   * Updates or sets the alternate bounds in the given geometry for the given cell depending on
   * whether the cell is going to be collapsed. If no alternate bounds are defined in the geometry
   * and collapseToPreferredSize is true, then the preferred size is used for the alternate bounds.
   * The top, left corner is always kept at the same location.
   *
   * @param cell Cell for which the geometry is being udpated.
   * @param geo Geometry for which the alternate bounds should be updated.
   * @param willCollapse Boolean indicating if the cell is going to be collapsed.
   */
  public void updateAlternateBounds(final Object cell, final mxGeometry geo,
      final boolean willCollapse) {
    if (cell != null && geo != null) {
      if (geo.getAlternateBounds() == null) {
        mxRectangle bounds = null;

        if (this.isCollapseToPreferredSize()) {
          bounds = this.getPreferredSizeForCell(cell);

          if (this.isSwimlane(cell)) {
            final mxRectangle size = this.getStartSize(cell);

            bounds.setHeight(Math.max(bounds.getHeight(), size.getHeight()));
            bounds.setWidth(Math.max(bounds.getWidth(), size.getWidth()));
          }
        }

        if (bounds == null) {
          bounds = geo;
        }

        geo.setAlternateBounds(
            new mxRectangle(geo.getX(), geo.getY(), bounds.getWidth(), bounds.getHeight()));
      } else {
        geo.getAlternateBounds().setX(geo.getX());
        geo.getAlternateBounds().setY(geo.getY());
      }
    }
  }

  /**
   * Updates the size of the given cell in the model using getPreferredSizeForCell to get the new
   * size. This function fires beforeUpdateSize and afterUpdateSize events.
   *
   * @param cell <mxCell> for which the size should be changed.
   */
  public Object updateCellSize(final Object cell) {
    return this.updateCellSize(cell, false);
  }

  /**
   * Updates the size of the given cell in the model using getPreferredSizeForCell to get the new
   * size. This function fires mxEvent.UPDATE_CELL_SIZE.
   *
   * @param cell Cell for which the size should be changed.
   */
  public Object updateCellSize(final Object cell, final boolean ignoreChildren) {
    this.model.beginUpdate();
    try {
      this.cellSizeUpdated(cell, ignoreChildren);
      this.fireEvent(new mxEventObject(mxEvent.UPDATE_CELL_SIZE, "cell", cell, "ignoreChildren",
          ignoreChildren));
    } finally {
      this.model.endUpdate();
    }

    return cell;
  }

  /**
   * Updates the bounds of the given array of groups so that it includes all child vertices.
   */
  public Object[] updateGroupBounds() {
    return this.updateGroupBounds(null);
  }

  /**
   * Updates the bounds of the given array of groups so that it includes all child vertices.
   *
   * @param cells The groups whose bounds should be updated.
   */
  public Object[] updateGroupBounds(final Object[] cells) {
    return this.updateGroupBounds(cells, 0);
  }

  //
  // Redirected to change support
  //

  /**
   * Updates the bounds of the given array of groups so that it includes all child vertices.
   *
   * @param cells The groups whose bounds should be updated.
   * @param border The border to be added in the group.
   */
  public Object[] updateGroupBounds(final Object[] cells, final int border) {
    return this.updateGroupBounds(cells, border, false);
  }

  /**
   * Updates the bounds of the given array of groups so that it includes all child vertices.
   *
   * @param cells The groups whose bounds should be updated.
   * @param border The border to be added in the group.
   * @param moveParent Specifies if the group should be moved.
   */
  public Object[] updateGroupBounds(Object[] cells, final int border, final boolean moveParent) {
    if (cells == null) {
      cells = this.getSelectionCells();
    }

    this.model.beginUpdate();
    try {
      for (int i = 0; i < cells.length; i++) {
        mxGeometry geo = this.getCellGeometry(cells[i]);

        if (geo != null) {
          final Object[] children = this.getChildCells(cells[i]);

          if (children != null && children.length > 0) {
            final mxRectangle childBounds = this.getBoundingBoxFromGeometry(children);

            if (childBounds.getWidth() > 0 && childBounds.getHeight() > 0) {
              final mxRectangle size =
                  this.isSwimlane(cells[i]) ? this.getStartSize(cells[i]) : new mxRectangle();

              geo = (mxGeometry) geo.clone();

              if (moveParent) {
                geo.setX(geo.getX() + childBounds.getX() - size.getWidth() - border);
                geo.setY(geo.getY() + childBounds.getY() - size.getHeight() - border);
              }

              geo.setWidth(childBounds.getWidth() + size.getWidth() + 2 * border);
              geo.setHeight(childBounds.getHeight() + size.getHeight() + 2 * border);

              this.model.setGeometry(cells[i], geo);
              this.moveCells(children, -childBounds.getX() + size.getWidth() + border,
                  -childBounds.getY() + size.getHeight() + border);
            }
          }
        }
      }
    } finally {
      this.model.endUpdate();
    }

    return cells;
  }

  /**
   * Extends the canvas by doing another validation with a shifted global translation if the bounds
   * of the graph are below (0,0).
   *
   * The first validation is required to compute the bounds of the graph while the second validation
   * is required to apply the new translate.
   */
  protected void updateOrigin() {
    final mxRectangle bounds = this.getGraphBounds();

    if (bounds != null) {
      final double scale = this.getView().getScale();
      final double x = bounds.getX() / scale - this.getBorder();
      final double y = bounds.getY() / scale - this.getBorder();

      if (x < 0 || y < 0) {
        final double x0 = Math.min(0, x);
        final double y0 = Math.min(0, y);

        this.origin.setX(this.origin.getX() + x0);
        this.origin.setY(this.origin.getY() + y0);

        final mxPoint t = this.getView().getTranslate();
        this.getView().setTranslate(new mxPoint(t.getX() - x0, t.getY() - y0));
      } else if ((x > 0 || y > 0) && (this.origin.getX() < 0 || this.origin.getY() < 0)) {
        final double dx = Math.min(-this.origin.getX(), x);
        final double dy = Math.min(-this.origin.getY(), y);

        this.origin.setX(this.origin.getX() + dx);
        this.origin.setY(this.origin.getY() + dy);

        final mxPoint t = this.getView().getTranslate();
        this.getView().setTranslate(new mxPoint(t.getX() - dx, t.getY() - dy));
      }
    }
  }

  /**
   * Hook method for subclassers to return an error message for the given cell and validation
   * context. This implementation returns null.
   *
   * @param cell Cell that represents the cell to validate.
   * @param context Hashtable that represents the global validation state.
   */
  public String validateCell(final Object cell, final Hashtable<Object, Object> context) {
    return null;
  }

  /**
   * Hook method for subclassers to return an error message for the given edge and terminals. This
   * implementation returns null.
   *
   * @param edge Cell that represents the edge to validate.
   * @param source Cell that represents the source terminal.
   * @param target Cell that represents the target terminal.
   */
  public String validateEdge(final Object edge, final Object source, final Object target) {
    return null;
  }

}
