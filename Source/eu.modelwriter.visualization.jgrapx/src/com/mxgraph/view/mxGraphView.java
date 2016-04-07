/**
 * Copyright (c) 2007-2010, Gaudenz Alder, David Benson
 */
package com.mxgraph.view;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.mxgraph.model.mxGeometry;
import com.mxgraph.model.mxGraphModel;
import com.mxgraph.model.mxIGraphModel;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource;
import com.mxgraph.util.mxPoint;
import com.mxgraph.util.mxRectangle;
import com.mxgraph.util.mxUndoableEdit;
import com.mxgraph.util.mxUndoableEdit.mxUndoableChange;
import com.mxgraph.util.mxUtils;
import com.mxgraph.view.mxEdgeStyle.mxEdgeStyleFunction;
import com.mxgraph.view.mxPerimeter.mxPerimeterFunction;

/**
 * Implements a view for the graph. This class is in charge of computing the absolute coordinates
 * for the relative child geometries, the points for perimeters and edge styles and keeping them
 * cached in cell states for faster retrieval. The states are updated whenever the model or the view
 * state (translate, scale) changes. The scale and translate are honoured in the bounds.
 *
 * This class fires the following events:
 *
 * mxEvent.UNDO fires after the root was changed in setCurrentRoot. The <code>edit</code> property
 * contains the mxUndoableEdit which contains the mxCurrentRootChange.
 *
 * mxEvent.SCALE_AND_TRANSLATE fires after the scale and transle have been changed in
 * scaleAndTranslate. The <code>scale</code>, <code>previousScale</code>, <code>translate</code> and
 * <code>previousTranslate</code> properties contain the new and previous scale and translate,
 * respectively.
 *
 * mxEvent.SCALE fires after the scale was changed in setScale. The <code>scale</code> and
 * <code>previousScale</code> properties contain the new and previous scale.
 *
 * mxEvent.TRANSLATE fires after the translate was changed in setTranslate. The
 * <code>translate</code> and <code>previousTranslate</code> properties contain the new and previous
 * value for translate.
 *
 * mxEvent.UP and mxEvent.DOWN fire if the current root is changed by executing a
 * mxCurrentRootChange. The event name depends on the location of the root in the cell hierarchy
 * with respect to the current root. The <code>root</code> and <code>previous</code> properties
 * contain the new and previous root, respectively.
 */
public class mxGraphView extends mxEventSource {
  /**
   * Action to change the current root in a view.
   */
  public static class mxCurrentRootChange implements mxUndoableChange {

    /**
     *
     */
    protected mxGraphView view;

    /**
     *
     */
    protected Object root, previous;

    /**
     *
     */
    protected boolean up;

    /**
     * Constructs a change of the current root in the given view.
     */
    public mxCurrentRootChange(final mxGraphView view, final Object root) {
      this.view = view;
      this.root = root;
      this.previous = this.root;
      this.up = root == null;

      if (!this.up) {
        Object tmp = view.getCurrentRoot();
        final mxIGraphModel model = view.graph.getModel();

        while (tmp != null) {
          if (tmp == root) {
            this.up = true;
            break;
          }

          tmp = model.getParent(tmp);
        }
      }
    }

    /**
     * Changes the current root of the view.
     */
    @Override
    public void execute() {
      final Object tmp = this.view.getCurrentRoot();
      this.view.currentRoot = this.previous;
      this.previous = tmp;

      final mxPoint translate = this.view.graph.getTranslateForRoot(this.view.getCurrentRoot());

      if (translate != null) {
        this.view.translate = new mxPoint(-translate.getX(), translate.getY());
      }

      // Removes all existing cell states and revalidates
      this.view.reload();
      this.up = !this.up;

      final String eventName = this.up ? mxEvent.UP : mxEvent.DOWN;
      this.view.fireEvent(
          new mxEventObject(eventName, "root", this.view.currentRoot, "previous", this.previous));
    }

    /**
     * Returns the previous root.
     */
    public Object getPrevious() {
      return this.previous;
    }

    /**
     * Returns the root.
     */
    public Object getRoot() {
      return this.root;
    }

    /**
     * Returns the graph view where the change happened.
     */
    public mxGraphView getView() {
      return this.view;
    }

    /**
     * Returns true if the drilling went upwards.
     */
    public boolean isUp() {
      return this.up;
    }

  }

  /**
   *
   */
  private static mxPoint EMPTY_POINT = new mxPoint();

  /**
   * Reference to the enclosing graph.
   */
  protected mxGraph graph;

  /**
   * mxCell that acts as the root of the displayed cell hierarchy.
   */
  protected Object currentRoot = null;

  /**
   * Caches the current bounds of the graph.
   */
  protected mxRectangle graphBounds = new mxRectangle();

  /**
   * Specifies the scale. Default is 1 (100%).
   */
  protected double scale = 1;

  /**
   * Point that specifies the current translation. Default is a new empty point.
   */
  protected mxPoint translate = new mxPoint(0, 0);

  /**
   * Maps from cells to cell states.
   */
  protected Hashtable<Object, mxCellState> states = new Hashtable<Object, mxCellState>();

  /**
   * Constructs a new view for the given graph.
   *
   * @param graph Reference to the enclosing graph.
   */
  public mxGraphView(final mxGraph graph) {
    this.graph = graph;
  }

  /**
   * Removes the state of the given cell and all descendants if the given cell is not the current
   * root.
   *
   * @param cell
   * @param force
   * @param recurse
   */
  public void clear(final Object cell, final boolean force, final boolean recurse) {
    this.removeState(cell);

    if (recurse && (force || cell != this.currentRoot)) {
      final mxIGraphModel model = this.graph.getModel();
      final int childCount = model.getChildCount(cell);

      for (int i = 0; i < childCount; i++) {
        this.clear(model.getChildAt(cell, i), force, recurse);
      }
    } else {
      this.invalidate(cell);
    }
  }

  /**
   * Creates and returns a cell state for the given cell.
   *
   * @param cell Cell for which a new state should be created.
   * @return Returns a new state for the given cell.
   */
  public mxCellState createState(final Object cell) {
    return new mxCellState(this, cell, this.graph.getCellStyle(cell));
  }

  /**
   * Shortcut to validateCell with visible set to true.
   */
  public mxRectangle getBoundingBox(final mxCellState state) {
    return this.getBoundingBox(state, true);
  }

  /**
   * Returns the bounding box of the shape and the label for the given cell state and its children
   * if recurse is true.
   *
   * @param state Cell state whose bounding box should be returned.
   * @param recurse Boolean indicating if the children should be included.
   */
  public mxRectangle getBoundingBox(final mxCellState state, final boolean recurse) {
    mxRectangle bbox = null;

    if (state != null) {
      if (state.getBoundingBox() != null) {
        bbox = (mxRectangle) state.getBoundingBox().clone();
      }

      if (recurse) {
        final mxIGraphModel model = this.graph.getModel();
        final int childCount = model.getChildCount(state.getCell());

        for (int i = 0; i < childCount; i++) {
          final mxRectangle bounds =
              this.getBoundingBox(this.getState(model.getChildAt(state.getCell(), i)), true);

          if (bounds != null) {
            if (bbox == null) {
              bbox = bounds;
            } else {
              bbox.add(bounds);
            }
          }
        }
      }
    }

    return bbox;
  }

  /**
   * Returns the bounding box for an array of cells or null, if no cells are specified.
   *
   * @param cells
   * @return Returns the bounding box for the given cells.
   */
  public mxRectangle getBoundingBox(final Object[] cells) {
    return this.getBounds(cells, true);
  }

  /**
   * Returns the bounding box for an array of cells or null, if no cells are specified.
   *
   * @param cells
   * @return Returns the bounding box for the given cells.
   */
  public mxRectangle getBounds(final Object[] cells) {
    return this.getBounds(cells, false);
  }

  /**
   * Returns the bounding box for an array of cells or null, if no cells are specified.
   *
   * @param cells
   * @return Returns the bounding box for the given cells.
   */
  public mxRectangle getBounds(final Object[] cells, final boolean boundingBox) {
    mxRectangle result = null;

    if (cells != null && cells.length > 0) {
      final mxIGraphModel model = this.graph.getModel();

      for (int i = 0; i < cells.length; i++) {
        if (model.isVertex(cells[i]) || model.isEdge(cells[i])) {
          final mxCellState state = this.getState(cells[i]);

          if (state != null) {
            final mxRectangle tmp = boundingBox ? state.getBoundingBox() : state;

            if (tmp != null) {
              if (result == null) {
                result = new mxRectangle(tmp);
              } else {
                result.add(tmp);
              }
            }
          }
        }
      }
    }

    return result;
  }

  /**
   * Returns the states for the given array of cells. The array contains all states that are not
   * null, that is, the returned array may have less elements than the given array.
   */
  public mxCellState[] getCellStates(final Object[] cells) {
    final List<mxCellState> result = new ArrayList<mxCellState>(cells.length);

    for (int i = 0; i < cells.length; i++) {
      final mxCellState state = this.getState(cells[i]);

      if (state != null) {
        result.add(state);
      }
    }

    final mxCellState[] resultArray = new mxCellState[result.size()];
    return result.toArray(resultArray);
  }

  /**
   * Returns the current root.
   */
  public Object getCurrentRoot() {
    return this.currentRoot;
  }

  /**
   * Returns the edge style function to be used to compute the absolute points for the given state,
   * control points and terminals.
   */
  public mxEdgeStyleFunction getEdgeStyle(final mxCellState edge, final List<mxPoint> points,
      final Object source, final Object target) {
    Object edgeStyle = null;

    if (source != null && source == target) {
      edgeStyle = edge.getStyle().get(mxConstants.STYLE_LOOP);

      if (edgeStyle == null) {
        edgeStyle = this.graph.getDefaultLoopStyle();
      }
    } else if (!mxUtils.isTrue(edge.getStyle(), mxConstants.STYLE_NOEDGESTYLE, false)) {
      edgeStyle = edge.getStyle().get(mxConstants.STYLE_EDGE);
    }

    // Converts string values to objects
    if (edgeStyle instanceof String) {
      final String str = String.valueOf(edgeStyle);
      Object tmp = mxStyleRegistry.getValue(str);

      if (tmp == null) {
        tmp = mxUtils.eval(str);
      }

      edgeStyle = tmp;
    }

    if (edgeStyle instanceof mxEdgeStyleFunction) {
      return (mxEdgeStyleFunction) edgeStyle;
    }

    return null;
  }

  /**
   * Returns the enclosing graph.
   *
   * @return Returns the enclosing graph.
   */
  public mxGraph getGraph() {
    return this.graph;
  }

  /**
   * Returns the cached diagram bounds.
   *
   * @return Returns the diagram bounds.
   */
  public mxRectangle getGraphBounds() {
    return this.graphBounds;
  }

  /**
   * Returns the nearest point in the list of absolute points or the center of the opposite
   * terminal.
   *
   * @param edge Cell state that represents the edge.
   * @param opposite Cell state that represents the opposite terminal.
   * @param source Boolean indicating if the next point for the source or target should be returned.
   * @return Returns the nearest point of the opposite side.
   */
  public mxPoint getNextPoint(final mxCellState edge, final mxCellState opposite,
      final boolean source) {
    final List<mxPoint> pts = edge.getAbsolutePoints();
    mxPoint point = null;

    if (pts != null && pts.size() >= 2) {
      final int count = pts.size();
      final int index = source ? Math.min(1, count - 1) : Math.max(0, count - 2);
      point = pts.get(index);
    }

    if (point == null && opposite != null) {
      point = new mxPoint(opposite.getCenterX(), opposite.getCenterY());
    }

    return point;
  }

  /**
   * Returns the perimeter bounds for the given terminal, edge pair.
   */
  public mxRectangle getPerimeterBounds(final mxCellState terminal, double border) {
    if (terminal != null) {
      border += mxUtils.getDouble(terminal.getStyle(), mxConstants.STYLE_PERIMETER_SPACING);
    }

    return terminal.getPerimeterBounds(border * this.scale);
  }

  /**
   * Returns the perimeter function for the given state.
   */
  public mxPerimeterFunction getPerimeterFunction(final mxCellState state) {
    Object perimeter = state.getStyle().get(mxConstants.STYLE_PERIMETER);

    // Converts string values to objects
    if (perimeter instanceof String) {
      final String str = String.valueOf(perimeter);
      Object tmp = mxStyleRegistry.getValue(str);

      if (tmp == null) {
        tmp = mxUtils.eval(str);
      }

      perimeter = tmp;
    }

    if (perimeter instanceof mxPerimeterFunction) {
      return (mxPerimeterFunction) perimeter;
    }

    return null;
  }

  /**
   * Returns a point that defines the location of the intersection point between the perimeter and
   * the line between the center of the shape and the given point.
   */
  public mxPoint getPerimeterPoint(final mxCellState terminal, final mxPoint next,
      final boolean orthogonal) {
    return this.getPerimeterPoint(terminal, next, orthogonal, 0);
  }

  /**
   * Returns a point that defines the location of the intersection point between the perimeter and
   * the line between the center of the shape and the given point.
   *
   * @param terminal Cell state for the source or target terminal.
   * @param next Point that lies outside of the given terminal.
   * @param orthogonal Boolean that specifies if the orthogonal projection onto the perimeter should
   *        be returned. If this is false then the intersection of the perimeter and the line
   *        between the next and the center point is returned.
   * @param border Optional border between the perimeter and the shape.
   */
  public mxPoint getPerimeterPoint(final mxCellState terminal, final mxPoint next,
      final boolean orthogonal, final double border) {
    mxPoint point = null;

    if (terminal != null) {
      final mxPerimeterFunction perimeter = this.getPerimeterFunction(terminal);

      if (perimeter != null && next != null) {
        final mxRectangle bounds = this.getPerimeterBounds(terminal, border);

        if (bounds.getWidth() > 0 || bounds.getHeight() > 0) {
          point = perimeter.apply(bounds, terminal, next, orthogonal);
        }
      }

      if (point == null) {
        point = this.getPoint(terminal);
      }
    }

    return point;
  }

  /**
   * Returns the absolute center point along the given edge.
   */
  public mxPoint getPoint(final mxCellState state) {
    return this.getPoint(state, null);
  }

  /**
   * Returns the absolute point on the edge for the given relative geometry as a point. The edge is
   * represented by the given cell state.
   *
   * @param state Represents the state of the parent edge.
   * @param geometry Optional geometry that represents the relative location.
   * @return Returns the mxpoint that represents the absolute location of the given relative
   *         geometry.
   */
  public mxPoint getPoint(final mxCellState state, final mxGeometry geometry) {
    double x = state.getCenterX();
    double y = state.getCenterY();

    if (state.getSegments() != null && (geometry == null || geometry.isRelative())) {
      final double gx = geometry != null ? geometry.getX() / 2 : 0;
      final int pointCount = state.getAbsolutePointCount();
      final double dist = (gx + 0.5) * state.getLength();
      final double[] segments = state.getSegments();
      double segment = segments[0];
      double length = 0;
      int index = 1;

      while (dist > length + segment && index < pointCount - 1) {
        length += segment;
        segment = segments[index++];
      }


      final double factor = segment == 0 ? 0 : (dist - length) / segment;
      final mxPoint p0 = state.getAbsolutePoint(index - 1);
      final mxPoint pe = state.getAbsolutePoint(index);


      if (p0 != null && pe != null) {
        double gy = 0;
        double offsetX = 0;
        double offsetY = 0;

        if (geometry != null) {
          gy = geometry.getY();
          final mxPoint offset = geometry.getOffset();

          if (offset != null) {
            offsetX = offset.getX();
            offsetY = offset.getY();
          }
        }

        final double dx = pe.getX() - p0.getX();
        final double dy = pe.getY() - p0.getY();
        final double nx = segment == 0 ? 0 : dy / segment;
        final double ny = segment == 0 ? 0 : dx / segment;

        x = p0.getX() + dx * factor + (nx * gy + offsetX) * this.scale;
        y = p0.getY() + dy * factor - (ny * gy - offsetY) * this.scale;
      }
    } else if (geometry != null) {
      final mxPoint offset = geometry.getOffset();

      if (offset != null) {
        x += offset.getX();
        y += offset.getY();
      }
    }

    return new mxPoint(x, y);
  }

  /**
   * Gets the relative point that describes the given, absolute label position for the given edge
   * state.
   */
  public mxPoint getRelativePoint(final mxCellState edgeState, final double x, final double y) {
    final mxIGraphModel model = this.graph.getModel();
    final mxGeometry geometry = model.getGeometry(edgeState.getCell());

    if (geometry != null) {
      final int pointCount = edgeState.getAbsolutePointCount();

      if (geometry.isRelative() && pointCount > 1) {
        final double totalLength = edgeState.getLength();
        final double[] segments = edgeState.getSegments();

        // Works which line segment the point of the label is closest to
        mxPoint p0 = edgeState.getAbsolutePoint(0);
        mxPoint pe = edgeState.getAbsolutePoint(1);
        Line2D line = new Line2D.Double(p0.getPoint(), pe.getPoint());
        double minDist = line.ptSegDistSq(x, y);

        int index = 0;
        double tmp = 0;
        double length = 0;

        for (int i = 2; i < pointCount; i++) {
          tmp += segments[i - 2];
          pe = edgeState.getAbsolutePoint(i);

          line = new Line2D.Double(p0.getPoint(), pe.getPoint());
          final double dist = line.ptSegDistSq(x, y);

          if (dist < minDist) {
            minDist = dist;
            index = i - 1;
            length = tmp;
          }

          p0 = pe;
        }

        final double seg = segments[index];
        p0 = edgeState.getAbsolutePoint(index);
        pe = edgeState.getAbsolutePoint(index + 1);

        final double x2 = p0.getX();
        final double y2 = p0.getY();

        final double x1 = pe.getX();
        final double y1 = pe.getY();

        double px = x;
        double py = y;

        final double xSegment = x2 - x1;
        final double ySegment = y2 - y1;

        px -= x1;
        py -= y1;
        double projlenSq = 0;

        px = xSegment - px;
        py = ySegment - py;
        final double dotprod = px * xSegment + py * ySegment;

        if (dotprod <= 0.0) {
          projlenSq = 0;
        } else {
          projlenSq = dotprod * dotprod / (xSegment * xSegment + ySegment * ySegment);
        }

        double projlen = Math.sqrt(projlenSq);

        if (projlen > seg) {
          projlen = seg;
        }

        double yDistance = Line2D.ptLineDist(p0.getX(), p0.getY(), pe.getX(), pe.getY(), x, y);
        final int direction = Line2D.relativeCCW(p0.getX(), p0.getY(), pe.getX(), pe.getY(), x, y);

        if (direction == -1) {
          yDistance = -yDistance;
        }

        // Constructs the relative point for the label
        return new mxPoint(Math.round((totalLength / 2 - length - projlen) / totalLength * -2),
            Math.round(yDistance / this.scale));
      }
    }

    return new mxPoint();
  }

  /**
   * Returns the x-coordinate of the center point for automatic routing.
   *
   * @return Returns the x-coordinate of the routing center point.
   */
  public double getRoutingCenterX(final mxCellState state) {
    final float f = state.getStyle() != null
        ? mxUtils.getFloat(state.getStyle(), mxConstants.STYLE_ROUTING_CENTER_X) : 0;

    return state.getCenterX() + f * state.getWidth();
  }

  /**
   * Returns the y-coordinate of the center point for automatic routing.
   *
   * @return Returns the y-coordinate of the routing center point.
   */
  public double getRoutingCenterY(final mxCellState state) {
    final float f = state.getStyle() != null
        ? mxUtils.getFloat(state.getStyle(), mxConstants.STYLE_ROUTING_CENTER_Y) : 0;

    return state.getCenterY() + f * state.getHeight();
  }

  /**
   * Returns the current scale.
   *
   * @return Returns the scale.
   */
  public double getScale() {
    return this.scale;
  }

  /**
   * Returns the state for the given cell or null if no state is defined for the cell.
   *
   * @param cell Cell whose state should be returned.
   * @return Returns the state for the given cell.
   */
  public mxCellState getState(final Object cell) {
    return this.getState(cell, false);
  }

  /**
   * Returns the cell state for the given cell. If create is true, then the state is created if it
   * does not yet exist.
   *
   * @param cell Cell for which a new state should be returned.
   * @param create Boolean indicating if a new state should be created if it does not yet exist.
   * @return Returns the state for the given cell.
   */
  public mxCellState getState(final Object cell, final boolean create) {
    mxCellState state = null;

    if (cell != null) {
      state = this.states.get(cell);

      if (state == null && create && this.graph.isCellVisible(cell)) {
        state = this.createState(cell);
        this.states.put(cell, state);
      }
    }

    return state;
  }

  /**
   * Returns the dictionary that maps from cells to states.
   */
  public Hashtable<Object, mxCellState> getStates() {
    return this.states;
  }

  /**
   * Returns a cell state that represents the source or target terminal or port for the given edge.
   */
  public mxCellState getTerminalPort(final mxCellState state, mxCellState terminal,
      final boolean source) {
    final String key = source ? mxConstants.STYLE_SOURCE_PORT : mxConstants.STYLE_TARGET_PORT;
    final String id = mxUtils.getString(state.style, key);

    if (id != null && this.graph.getModel() instanceof mxGraphModel) {
      final mxCellState tmp = this.getState(((mxGraphModel) this.graph.getModel()).getCell(id));

      // Only uses ports where a cell state exists
      if (tmp != null) {
        terminal = tmp;
      }
    }

    return terminal;
  }

  /**
   * Returns the current translation.
   *
   * @return Returns the translation.
   */
  public mxPoint getTranslate() {
    return this.translate;
  }

  /**
   * Returns the nearest ancestor terminal that is visible. The edge appears to be connected to this
   * terminal on the display.
   *
   * @param edge Cell whose visible terminal should be returned.
   * @param source Boolean that specifies if the source or target terminal should be returned.
   * @return Returns the visible source or target terminal.
   */
  public Object getVisibleTerminal(final Object edge, final boolean source) {
    final mxIGraphModel model = this.graph.getModel();
    Object result = model.getTerminal(edge, source);
    Object best = result;

    while (result != null && result != this.currentRoot) {
      if (!this.graph.isCellVisible(best) || this.graph.isCellCollapsed(result)) {
        best = result;
      }

      result = model.getParent(result);
    }

    // Checks if the result is not a layer
    if (model.getParent(best) == model.getRoot()) {
      best = null;
    }

    return best;
  }

  /**
   * Returns the width for wrapping the label of the given state at scale 1.
   */
  public double getWordWrapWidth(final mxCellState state) {
    final Map<String, Object> style = state.getStyle();
    final boolean horizontal = mxUtils.isTrue(style, mxConstants.STYLE_HORIZONTAL, true);
    double w = 0;

    // Computes the available width for the wrapped label
    if (horizontal) {
      w = state.getWidth() / this.scale - 2 * mxConstants.LABEL_INSET
          - 2 * mxUtils.getDouble(style, mxConstants.STYLE_SPACING)
          - mxUtils.getDouble(style, mxConstants.STYLE_SPACING_LEFT)
          - mxUtils.getDouble(style, mxConstants.STYLE_SPACING_RIGHT);
    } else {
      w = state.getHeight() / this.scale - 2 * mxConstants.LABEL_INSET
          - 2 * mxUtils.getDouble(style, mxConstants.STYLE_SPACING)
          - mxUtils.getDouble(style, mxConstants.STYLE_SPACING_TOP)
          + mxUtils.getDouble(style, mxConstants.STYLE_SPACING_BOTTOM);
    }

    return w;
  }

  /**
   * Invalidates all cell states.
   */
  public void invalidate() {
    this.invalidate(null);
  }

  /**
   * Invalidates the state of the given cell, all its descendants and connected edges.
   */
  public void invalidate(Object cell) {
    final mxIGraphModel model = this.graph.getModel();
    cell = cell != null ? cell : model.getRoot();
    final mxCellState state = this.getState(cell);

    if (state == null || !state.isInvalid()) {
      if (state != null) {
        state.setInvalid(true);
      }

      // Recursively invalidates all descendants
      final int childCount = model.getChildCount(cell);

      for (int i = 0; i < childCount; i++) {
        final Object child = model.getChildAt(cell, i);
        this.invalidate(child);
      }

      // Propagates invalidation to all connected edges
      final int edgeCount = model.getEdgeCount(cell);

      for (int i = 0; i < edgeCount; i++) {
        this.invalidate(model.getEdgeAt(cell, i));
      }
    }
  }

  /**
   * Removes all existing cell states and invokes validate.
   */
  public void reload() {
    this.states.clear();
    this.validate();
  }

  /**
   * Removes and returns the mxCellState for the given cell.
   *
   * @param cell mxCell for which the mxCellState should be removed.
   * @return Returns the mxCellState that has been removed.
   */
  public mxCellState removeState(final Object cell) {
    return cell != null ? (mxCellState) this.states.remove(cell) : null;
  }

  /**
   *
   */
  public void revalidate() {
    this.invalidate();
    this.validate();
  }

  /**
   * Sets the scale and translation. Fires a "scaleAndTranslate" event after calling revalidate.
   * Revalidate is only called if isEventsEnabled.
   *
   * @param scale Decimal value that specifies the new scale (1 is 100%).
   * @param dx X-coordinate of the translation.
   * @param dy Y-coordinate of the translation.
   */
  public void scaleAndTranslate(final double scale, final double dx, final double dy) {
    final double previousScale = this.scale;
    final Object previousTranslate = this.translate.clone();

    if (scale != this.scale || dx != this.translate.getX() || dy != this.translate.getY()) {
      this.scale = scale;
      this.translate = new mxPoint(dx, dy);

      if (this.isEventsEnabled()) {
        this.revalidate();
      }
    }

    this.fireEvent(new mxEventObject(mxEvent.SCALE_AND_TRANSLATE, "scale", scale, "previousScale",
        previousScale, "translate", this.translate, "previousTranslate", previousTranslate));
  }

  /**
   * Sets and returns the current root and fires an undo event.
   *
   * @param root mxCell that specifies the root of the displayed cell hierarchy.
   * @return Returns the object that represents the current root.
   */
  public Object setCurrentRoot(final Object root) {
    if (this.currentRoot != root) {
      final mxCurrentRootChange change = new mxCurrentRootChange(this, root);
      change.execute();
      final mxUndoableEdit edit = new mxUndoableEdit(this, false);
      edit.add(change);
      this.fireEvent(new mxEventObject(mxEvent.UNDO, "edit", edit));
    }

    return root;
  }

  /**
   * Sets the graph bounds.
   */
  public void setGraphBounds(final mxRectangle value) {
    this.graphBounds = value;
  }

  /**
   * Sets the current scale and revalidates the view. Fires a "scale" event after calling
   * revalidate. Revalidate is only called if isEventsEnabled.
   *
   * @param value New scale to be used.
   */
  public void setScale(final double value) {
    final double previousScale = this.scale;

    if (this.scale != value) {
      this.scale = value;

      if (this.isEventsEnabled()) {
        this.revalidate();
      }
    }

    this.fireEvent(
        new mxEventObject(mxEvent.SCALE, "scale", this.scale, "previousScale", previousScale));
  }

  /**
   * Returns the dictionary that maps from cells to states.
   */
  public void setStates(final Hashtable<Object, mxCellState> states) {
    this.states = states;
  }

  /**
   * Sets the current translation and invalidates the view. Fires a property change event for
   * "translate" after calling revalidate. Revalidate is only called if isEventsEnabled.
   *
   * @param value New translation to be used.
   */
  public void setTranslate(final mxPoint value) {
    final Object previousTranslate = this.translate.clone();

    if (value != null
        && (value.getX() != this.translate.getX() || value.getY() != this.translate.getY())) {
      this.translate = value;

      if (this.isEventsEnabled()) {
        this.revalidate();
      }
    }

    this.fireEvent(new mxEventObject(mxEvent.TRANSLATE, "translate", this.translate,
        "previousTranslate", previousTranslate));
  }

  /**
   * Transforms the given control point to an absolute point.
   */
  public mxPoint transformControlPoint(final mxCellState state, final mxPoint pt) {
    final mxPoint origin = state.getOrigin();

    return new mxPoint(this.scale * (pt.getX() + this.translate.getX() + origin.getX()),
        this.scale * (pt.getY() + this.translate.getY() + origin.getY()));
  }

  /**
   * Updates the bounding box in the given cell state.
   *
   * @param state Cell state whose bounding box should be updated.
   */
  public mxRectangle updateBoundingBox(final mxCellState state) {
    // Gets the cell bounds and adds shadows and markers
    final mxRectangle rect = new mxRectangle(state);
    final Map<String, Object> style = state.getStyle();

    // Adds extra pixels for the marker and stroke assuming
    // that the border stroke is centered around the bounds
    // and the first pixel is drawn inside the bounds
    double strokeWidth = Math.max(1,
        Math.round(mxUtils.getInt(style, mxConstants.STYLE_STROKEWIDTH, 1) * this.scale));
    strokeWidth -= Math.max(1, strokeWidth / 2);

    if (this.graph.getModel().isEdge(state.getCell())) {
      int ms = 0;

      if (style.containsKey(mxConstants.STYLE_ENDARROW)
          || style.containsKey(mxConstants.STYLE_STARTARROW)) {
        ms = (int) Math.round(mxConstants.DEFAULT_MARKERSIZE * this.scale);
      }

      // Adds the strokewidth
      rect.grow(ms + strokeWidth);

      // Adds worst case border for an arrow shape
      if (mxUtils.getString(style, mxConstants.STYLE_SHAPE, "").equals(mxConstants.SHAPE_ARROW)) {
        rect.grow(mxConstants.ARROW_WIDTH / 2);
      }
    } else {
      rect.grow(strokeWidth);
    }

    // Adds extra pixels for the shadow
    if (mxUtils.isTrue(style, mxConstants.STYLE_SHADOW)) {
      rect.setWidth(rect.getWidth() + mxConstants.SHADOW_OFFSETX);
      rect.setHeight(rect.getHeight() + mxConstants.SHADOW_OFFSETY);
    }

    // Adds oversize images in labels
    if (mxUtils.getString(style, mxConstants.STYLE_SHAPE, "").equals(mxConstants.SHAPE_LABEL)) {
      if (mxUtils.getString(style, mxConstants.STYLE_IMAGE) != null) {
        final double w =
            mxUtils.getInt(style, mxConstants.STYLE_IMAGE_WIDTH, mxConstants.DEFAULT_IMAGESIZE)
                * this.scale;
        final double h =
            mxUtils.getInt(style, mxConstants.STYLE_IMAGE_HEIGHT, mxConstants.DEFAULT_IMAGESIZE)
                * this.scale;

        double x = state.getX();
        double y = 0;

        final String imgAlign =
            mxUtils.getString(style, mxConstants.STYLE_IMAGE_ALIGN, mxConstants.ALIGN_LEFT);
        final String imgValign = mxUtils.getString(style, mxConstants.STYLE_IMAGE_VERTICAL_ALIGN,
            mxConstants.ALIGN_MIDDLE);

        if (imgAlign.equals(mxConstants.ALIGN_RIGHT)) {
          x += state.getWidth() - w;
        } else if (imgAlign.equals(mxConstants.ALIGN_CENTER)) {
          x += (state.getWidth() - w) / 2;
        }

        if (imgValign.equals(mxConstants.ALIGN_TOP)) {
          y = state.getY();
        } else if (imgValign.equals(mxConstants.ALIGN_BOTTOM)) {
          y = state.getY() + state.getHeight() - h;
        } else
        // MIDDLE
        {
          y = state.getY() + (state.getHeight() - h) / 2;
        }

        rect.add(new mxRectangle(x, y, w, h));
      }
    }

    // Adds the rotated bounds to the bounding box if the
    // shape is rotated
    final double rotation = mxUtils.getDouble(style, mxConstants.STYLE_ROTATION);
    final mxRectangle bbox = mxUtils.getBoundingBox(rect, rotation);

    // Add the rotated bounding box to the non-rotated so
    // that all handles are also covered
    rect.add(bbox);

    // Unifies the cell bounds and the label bounds
    rect.add(state.getLabelBounds());

    state.setBoundingBox(rect);

    return rect;
  }

  /**
   * Updates the given cell state.
   *
   * @param state Cell state to be updated.
   */
  public void updateCellState(final mxCellState state) {
    state.getAbsoluteOffset().setX(0);
    state.getAbsoluteOffset().setY(0);
    state.getOrigin().setX(0);
    state.getOrigin().setY(0);
    state.setLength(0);

    if (state.getCell() != this.currentRoot) {
      final mxIGraphModel model = this.graph.getModel();
      final mxCellState pState = this.getState(model.getParent(state.getCell()));

      if (pState != null && pState.getCell() != this.currentRoot) {
        state.getOrigin().setX(state.getOrigin().getX() + pState.getOrigin().getX());
        state.getOrigin().setY(state.getOrigin().getY() + pState.getOrigin().getY());
      }

      mxPoint offset = this.graph.getChildOffsetForCell(state.getCell());

      if (offset != null) {
        state.getOrigin().setX(state.getOrigin().getX() + offset.getX());
        state.getOrigin().setY(state.getOrigin().getY() + offset.getY());
      }

      final mxGeometry geo = this.graph.getCellGeometry(state.getCell());

      if (geo != null) {
        if (!model.isEdge(state.getCell())) {
          final mxPoint origin = state.getOrigin();
          offset = geo.getOffset();

          if (offset == null) {
            offset = mxGraphView.EMPTY_POINT;
          }

          if (geo.isRelative() && pState != null) {
            if (model.isEdge(pState.getCell())) {
              final mxPoint orig = this.getPoint(pState, geo);

              if (orig != null) {
                origin.setX(origin.getX() + orig.getX() / this.scale - pState.getOrigin().getX()
                    - this.translate.getX());
                origin.setY(origin.getY() + orig.getY() / this.scale - pState.getOrigin().getY()
                    - this.translate.getY());
              }
            } else {
              origin.setX(
                  origin.getX() + geo.getX() * pState.getWidth() / this.scale + offset.getX());
              origin.setY(
                  origin.getY() + geo.getY() * pState.getHeight() / this.scale + offset.getY());
            }
          } else {
            state.setAbsoluteOffset(
                new mxPoint(this.scale * offset.getX(), this.scale * offset.getY()));
            origin.setX(origin.getX() + geo.getX());
            origin.setY(origin.getY() + geo.getY());
          }
        }

        state.setX(this.scale * (this.translate.getX() + state.getOrigin().getX()));
        state.setY(this.scale * (this.translate.getY() + state.getOrigin().getY()));
        state.setWidth(this.scale * geo.getWidth());
        state.setHeight(this.scale * geo.getHeight());

        if (model.isVertex(state.getCell())) {
          this.updateVertexState(state, geo);
        }

        if (model.isEdge(state.getCell())) {
          this.updateEdgeState(state, geo);
        }

        // Updates the cached label
        this.updateLabel(state);
      }
    }
  }

  /**
   * Updates the given state using the bounding box of the absolute points. Also updates terminal
   * distance, length and segments.
   *
   * @param state Cell state whose bounds should be updated.
   */
  public void updateEdgeBounds(final mxCellState state) {
    final List<mxPoint> points = state.getAbsolutePoints();
    mxPoint p0 = points.get(0);
    mxPoint pe = points.get(points.size() - 1);

    /* ARROW'S HEAD AND TAIL LOCATION IS CONFIGURING NOW __ANIL */
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    final mxPoint nearestS = points.get(1);
    final mxPoint nearestT = points.get(points.size() - 2);

    final mxPoint intersectSource = state.visibleSourceState.intersectLine(p0.getX(), p0.getY(),
        nearestS.getX(), nearestS.getY());
    final mxPoint intersectTarget = state.visibleTargetState.intersectLine(pe.getX(), pe.getY(),
        nearestT.getX(), nearestT.getY());

    if (intersectSource == null || intersectTarget == null) {

    } else {
      final List<mxPoint> newPoints = new ArrayList<mxPoint>(points.size());
      p0 = intersectSource;
      pe = intersectTarget;

      newPoints.add(p0);
      for (int i = 1; i < points.size() - 1; i++) {
        newPoints.add(i, points.get(i));
      }
      newPoints.add(pe);

      state.setAbsolutePoints(newPoints);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    if (p0.getX() != pe.getX() || p0.getY() != pe.getY()) {
      final double dx = pe.getX() - p0.getX();
      final double dy = pe.getY() - p0.getY();
      state.setTerminalDistance(Math.sqrt(dx * dx + dy * dy));
    } else {
      state.setTerminalDistance(0);
    }

    double length = 0;
    final double[] segments = new double[points.size() - 1];
    mxPoint pt = p0;

    double minX = pt.getX();
    double minY = pt.getY();
    double maxX = minX;
    double maxY = minY;

    for (int i = 1; i < points.size(); i++) {
      final mxPoint tmp = points.get(i);

      if (tmp != null) {
        final double dx = pt.getX() - tmp.getX();
        final double dy = pt.getY() - tmp.getY();

        final double segment = Math.sqrt(dx * dx + dy * dy);
        segments[i - 1] = segment;
        length += segment;
        pt = tmp;

        minX = Math.min(pt.getX(), minX);
        minY = Math.min(pt.getY(), minY);
        maxX = Math.max(pt.getX(), maxX);
        maxY = Math.max(pt.getY(), maxY);
      }
    }

    state.setLength(length);
    state.setSegments(segments);
    final double markerSize = 1; // TODO: include marker size

    state.setX(minX);
    state.setY(minY);
    state.setWidth(Math.max(markerSize, maxX - minX));
    state.setHeight(Math.max(markerSize, maxY - minY));
  }

  /**
   * Validates the given cell state.
   */
  public void updateEdgeState(final mxCellState state, final mxGeometry geo) {
    final mxCellState source = state.getVisibleTerminalState(true);
    final mxCellState target = state.getVisibleTerminalState(false);

    // This will remove edges with no terminals and no terminal points
    // as such edges are invalid and produce NPEs in the edge styles.
    // Also removes connected edges that have no visible terminals.
    if (this.graph.getModel().getTerminal(state.getCell(), true) != null && source == null
        || source == null && geo.getTerminalPoint(true) == null
        || this.graph.getModel().getTerminal(state.getCell(), false) != null && target == null
        || target == null && geo.getTerminalPoint(false) == null) {
      this.clear(state.getCell(), true, true);
    } else {
      this.updateFixedTerminalPoints(state, source, target);
      this.updatePoints(state, geo.getPoints(), source, target);
      this.updateFloatingTerminalPoints(state, source, target);

      if (state.getCell() != this.getCurrentRoot()
          && (state.getAbsolutePointCount() < 2 || state.getAbsolutePoint(0) == null
              || state.getAbsolutePoint(state.getAbsolutePointCount() - 1) == null)) {
        // This will remove edges with invalid points from the list of
        // states in the view.
        // Happens if the one of the terminals and the corresponding
        // terminal point is null.
        this.clear(state.getCell(), true, true);
      } else {
        this.updateEdgeBounds(state);
        state.setAbsoluteOffset(this.getPoint(state, geo));
      }
    }
  }

  /**
   * Sets the fixed source or target terminal point on the given edge.
   *
   * @param edge Cell state whose initial terminal points should be updated.
   */
  public void updateFixedTerminalPoint(final mxCellState edge, final mxCellState terminal,
      final boolean source, final mxConnectionConstraint constraint) {
    mxPoint pt = null;

    if (constraint != null) {
      pt = this.graph.getConnectionPoint(terminal, constraint);
    }

    if (pt == null && terminal == null) {
      final mxPoint orig = edge.getOrigin();
      final mxGeometry geo = this.graph.getCellGeometry(edge.getCell());
      pt = geo.getTerminalPoint(source);

      if (pt != null) {
        pt = new mxPoint(this.scale * (this.translate.getX() + pt.getX() + orig.getX()),
            this.scale * (this.translate.getY() + pt.getY() + orig.getY()));
      }
    }

    edge.setAbsoluteTerminalPoint(pt, source);
  }

  /**
   * Sets the initial absolute terminal points in the given state before the edge style is computed.
   *
   * @param edge Cell state whose initial terminal points should be updated.
   * @param source Cell state which represents the source terminal.
   * @param target Cell state which represents the target terminal.
   */
  public void updateFixedTerminalPoints(final mxCellState edge, final mxCellState source,
      final mxCellState target) {
    this.updateFixedTerminalPoint(edge, source, true,
        this.graph.getConnectionConstraint(edge, source, true));
    this.updateFixedTerminalPoint(edge, target, false,
        this.graph.getConnectionConstraint(edge, target, false));
  }

  /**
   * Updates the absolute terminal point in the given state for the given start and end state, where
   * start is the source if source is true.
   *
   * @param edge Cell state whose terminal point should be updated.
   * @param start Cell state for the terminal on "this" side of the edge.
   * @param end Cell state for the terminal on the other side of the edge.
   * @param source Boolean indicating if start is the source terminal state.
   */
  public void updateFloatingTerminalPoint(final mxCellState edge, mxCellState start,
      final mxCellState end, final boolean source) {
    start = this.getTerminalPort(edge, start, source);
    final mxPoint next = this.getNextPoint(edge, end, source);
    double border = mxUtils.getDouble(edge.getStyle(), mxConstants.STYLE_PERIMETER_SPACING);
    border += mxUtils.getDouble(edge.getStyle(), source ? mxConstants.STYLE_SOURCE_PERIMETER_SPACING
        : mxConstants.STYLE_TARGET_PERIMETER_SPACING);
    final mxPoint pt = this.getPerimeterPoint(start, next, this.graph.isOrthogonal(edge), border);
    edge.setAbsoluteTerminalPoint(pt, source);
  }

  /**
   * Updates the terminal points in the given state after the edge style was computed for the edge.
   *
   * @param state Cell state whose terminal points should be updated.
   * @param source Cell state that represents the source terminal.
   * @param target Cell state that represents the target terminal.
   */
  public void updateFloatingTerminalPoints(final mxCellState state, final mxCellState source,
      final mxCellState target) {
    final mxPoint p0 = state.getAbsolutePoint(0);
    final mxPoint pe = state.getAbsolutePoint(state.getAbsolutePointCount() - 1);

    if (pe == null && target != null) {
      this.updateFloatingTerminalPoint(state, target, source, false);
    }

    if (p0 == null && source != null) {
      this.updateFloatingTerminalPoint(state, source, target, true);
    }
  }

  /**
   * Updates the label of the given state.
   */
  public void updateLabel(final mxCellState state) {
    String label = this.graph.getLabel(state.getCell());
    final Map<String, Object> style = state.getStyle();

    // Applies word wrapping to non-HTML labels and stores the result in the
    // state
    if (label != null && label.length() > 0 && !this.graph.isHtmlLabel(state.getCell())
        && !this.graph.getModel().isEdge(state.getCell())
        && mxUtils.getString(style, mxConstants.STYLE_WHITE_SPACE, "nowrap").equals("wrap")) {
      final double w = this.getWordWrapWidth(state);

      // The lines for wrapping within the given width are calculated for
      // no
      // scale. The reason for this is the granularity of actual displayed
      // font can cause the displayed lines to change based on scale. A
      // factor
      // is used to allow for different overalls widths, it ensures the
      // largest
      // font size/scale factor still stays within the bounds. All this
      // ensures
      // the wrapped lines are constant overing scaling, at the expense
      // the
      // label bounds will vary.
      final String[] lines =
          mxUtils.wordWrap(label, mxUtils.getFontMetrics(mxUtils.getFont(state.getStyle())),
              w * mxConstants.LABEL_SCALE_BUFFER);

      if (lines.length > 0) {
        final StringBuffer buffer = new StringBuffer();

        for (final String line : lines) {
          buffer.append(line + '\n');
        }

        label = buffer.substring(0, buffer.length() - 1);
      }
    }

    state.setLabel(label);
  }

  /**
   * Updates the label bounds in the given state.
   */
  public void updateLabelBounds(final mxCellState state) {
    final Object cell = state.getCell();
    final Map<String, Object> style = state.getStyle();
    final String overflow = mxUtils.getString(style, mxConstants.STYLE_OVERFLOW, "");

    if (overflow.equals("fill")) {
      state.setLabelBounds(new mxRectangle(state));
    } else if (state.getLabel() != null) {
      // For edges, the width of the geometry is used for wrapping HTML
      // labels or no wrapping is applied if the width is set to 0
      mxRectangle vertexBounds = state;

      if (this.graph.getModel().isEdge(cell)) {
        final mxGeometry geo = this.graph.getCellGeometry(cell);

        if (geo != null && geo.getWidth() > 0) {
          vertexBounds = new mxRectangle(0, 0, geo.getWidth() * this.getScale(), 0);
        } else {
          vertexBounds = null;
        }
      }

      state.setLabelBounds(mxUtils.getLabelPaintBounds(state.getLabel(), style,
          this.graph.isHtmlLabel(cell), state.getAbsoluteOffset(), vertexBounds, this.scale,
          this.graph.getModel().isEdge(cell)));

      if (overflow.equals("width")) {
        state.getLabelBounds().setX(state.getX());
        state.getLabelBounds().setWidth(state.getWidth());
      }
    }
  }

  /**
   * Updates the absolute points in the given state using the specified array of points as the
   * relative points.
   *
   * @param edge Cell state whose absolute points should be updated.
   * @param points Array of points that constitute the relative points.
   * @param source Cell state that represents the source terminal.
   * @param target Cell state that represents the target terminal.
   */
  public void updatePoints(final mxCellState edge, final List<mxPoint> points,
      final mxCellState source, final mxCellState target) {
    if (edge != null) {
      final List<mxPoint> pts = new ArrayList<mxPoint>();
      pts.add(edge.getAbsolutePoint(0));
      final mxEdgeStyleFunction edgeStyle = this.getEdgeStyle(edge, points, source, target);

      if (edgeStyle != null) {
        final mxCellState src = this.getTerminalPort(edge, source, true);
        final mxCellState trg = this.getTerminalPort(edge, target, false);

        edgeStyle.apply(edge, src, trg, points, pts);
      } else if (points != null) {
        for (int i = 0; i < points.size(); i++) {
          pts.add(this.transformControlPoint(edge, points.get(i)));
        }
      }

      pts.add(edge.getAbsolutePoint(edge.getAbsolutePointCount() - 1));
      edge.setAbsolutePoints(pts);
    }
  }

  /**
   * Updates the absoluteOffset of the given vertex cell state. This takes into account the label
   * position styles.
   *
   * @param state Cell state whose absolute offset should be updated.
   */
  public void updateVertexLabelOffset(final mxCellState state) {
    final String horizontal = mxUtils.getString(state.getStyle(), mxConstants.STYLE_LABEL_POSITION,
        mxConstants.ALIGN_CENTER);

    if (horizontal.equals(mxConstants.ALIGN_LEFT)) {
      state.absoluteOffset.setX(state.absoluteOffset.getX() - state.getWidth());
    } else if (horizontal.equals(mxConstants.ALIGN_RIGHT)) {
      state.absoluteOffset.setX(state.absoluteOffset.getX() + state.getWidth());
    }

    final String vertical = mxUtils.getString(state.getStyle(),
        mxConstants.STYLE_VERTICAL_LABEL_POSITION, mxConstants.ALIGN_MIDDLE);

    if (vertical.equals(mxConstants.ALIGN_TOP)) {
      state.absoluteOffset.setY(state.absoluteOffset.getY() - state.getHeight());
    } else if (vertical.equals(mxConstants.ALIGN_BOTTOM)) {
      state.absoluteOffset.setY(state.absoluteOffset.getY() + state.getHeight());
    }
  }

  /**
   * Validates the given cell state.
   */
  public void updateVertexState(final mxCellState state, final mxGeometry geo) {
    // LATER: Add support for rotation
    this.updateVertexLabelOffset(state);
  }

  /**
   * First validates all bounds and then validates all points recursively on all visible cells.
   */
  public void validate() {
    final mxRectangle graphBounds = this.getBoundingBox(this.validateCellState(this.validateCell(
        this.currentRoot != null ? this.currentRoot : this.graph.getModel().getRoot())));
    this.setGraphBounds(graphBounds != null ? graphBounds : new mxRectangle());
  }

  /**
   * Shortcut to validateCell with visible set to true.
   */
  public Object validateCell(final Object cell) {
    return this.validateCell(cell, true);
  }

  /**
   * Recursively creates the cell state for the given cell if visible is true and the given cell is
   * visible. If the cell is not visible but the state exists then it is removed using removeState.
   *
   * @param cell Cell whose cell state should be created.
   * @param visible Boolean indicating if the cell should be visible.
   */
  public Object validateCell(final Object cell, boolean visible) {
    if (cell != null) {
      visible = visible && this.graph.isCellVisible(cell);
      final mxCellState state = this.getState(cell, visible);

      if (state != null && !visible) {
        this.removeState(cell);
      } else {
        final mxIGraphModel model = this.graph.getModel();
        final int childCount = model.getChildCount(cell);

        for (int i = 0; i < childCount; i++) {
          this.validateCell(model.getChildAt(cell, i),
              visible && (!this.graph.isCellCollapsed(cell) || cell == this.currentRoot));
        }
      }
    }

    return cell;
  }

  /**
   * Shortcut to validateCellState with recurse set to true.
   */
  public mxCellState validateCellState(final Object cell) {
    return this.validateCellState(cell, true);
  }

  /**
   * Validates the cell state for the given cell.
   *
   * @param cell Cell whose cell state should be validated.
   * @param recurse Boolean indicating if the children of the cell should be validated.
   */
  public mxCellState validateCellState(final Object cell, final boolean recurse) {
    mxCellState state = null;

    if (cell != null) {
      state = this.getState(cell);

      if (state != null) {
        final mxIGraphModel model = this.graph.getModel();

        if (state.isInvalid()) {
          state.setInvalid(false);

          if (cell != this.currentRoot) {
            this.validateCellState(model.getParent(cell), false);
          }

          state.setVisibleTerminalState(
              this.validateCellState(this.getVisibleTerminal(cell, true), false), true);
          state.setVisibleTerminalState(
              this.validateCellState(this.getVisibleTerminal(cell, false), false), false);

          this.updateCellState(state);

          if (model.isEdge(cell) || model.isVertex(cell)) {
            this.updateLabelBounds(state);
            this.updateBoundingBox(state);
          }
        }

        if (recurse) {
          final int childCount = model.getChildCount(cell);

          for (int i = 0; i < childCount; i++) {
            this.validateCellState(model.getChildAt(cell, i));
          }
        }
      }
    }

    return state;
  }

}
