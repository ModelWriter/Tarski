/**
 * Copyright (c) 2007, Gaudenz Alder
 */
package com.mxgraph.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.mxgraph.examples.swing.viz.VisualizationGraph;

/**
 * Cells are the elements of the graph model. They represent the state of the groups, vertices and
 * edges in a graph.
 *
 * <h4>Edge Labels</h4>
 *
 * Using the x- and y-coordinates of a cell's geometry it is possible to position the label on edges
 * on a specific location on the actual edge shape as it appears on the screen. The x-coordinate of
 * an edge's geometry is used to describe the distance from the center of the edge from -1 to 1 with
 * 0 being the center of the edge and the default value. The y-coordinate of an edge's geometry is
 * used to describe the absolute, orthogonal distance in pixels from that point. In addition, the
 * mxGeometry.offset is used as a absolute offset vector from the resulting point.
 *
 * The width and height of an edge geometry are ignored.
 *
 * To add more than one edge label, add a child vertex with a relative geometry. The x- and
 * y-coordinates of that geometry will have the same semantiv as the above for edge labels.
 */
public class mxCell implements mxICell, Cloneable, Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 910211337632342672L;

  /**
   * Holds the Id. Default is null.
   */
  protected String id;

  /**
   * Holds the user object. Default is null.
   */
  protected Object value;

  /**
   * Holds the geometry. Default is null.
   */
  protected mxGeometry geometry;

  /**
   * Holds the style as a string of the form stylename[;key=value]. Default is null.
   */
  protected String style;

  /**
   * Specifies whether the cell is a vertex or edge and whether it is connectable, visible and
   * collapsed. Default values are false, false, true, true and false respectively.
   */
  protected boolean vertex = false, edge = false, connectable = true, visible = true,
      collapsed = false;

  private int layer = 0;

  /** If (updown>=0), this is the distance from the center to the left edge. */
  private double side = 0;

  /** If (updown>=0), this is the distance from the center to the top edge. */
  private double updown = -1;

  /**
   * If (updown>=0), this is the vertical distance between the center of the text label and the
   * center of the node.
   */
  private int yShift = 0;

  /**
   * If (updown>=0), this is the amount of space on the right set-aside for self-loops (which is 0
   * if node has no self loops)
   */
  private double reserved = 0;

  /**
   * Reference to the parent cell and source and target terminals for edges.
   */
  protected mxICell parent, source, target;

  /**
   * Holds the child cells and connected edges.
   */
  protected List<Object> children, edges;

  private int ad;

  /**
   * Constructs a new cell with an empty user object.
   */
  public mxCell() {
    this(null);
  }

  /**
   * Constructs a new cell for the given user object.
   *
   * @param value Object that represents the value of the cell.
   */
  public mxCell(final Object value) {
    this(value, null, null);
  }

  /**
   * Constructs a new cell for the given parameters.
   *
   * @param value Object that represents the value of the cell.
   * @param geometry Specifies the geometry of the cell.
   * @param style Specifies the style as a formatted string.
   */
  public mxCell(final Object value, final mxGeometry geometry, final String style) {
    this.setValue(value);
    this.setGeometry(geometry);
    this.setStyle(style);
  }

  /** (Re-)calculate this node's bounds. */
  void calcBounds(final VisualizationGraph graph) {
    this.reserved = this.yShift = 0;
    this.getGeometry().setWidth(2 * 5);
    if (this.getGeometry().getWidth() < 30) {
      this.side = 30 / 2;
    }
    this.getGeometry().setHeight(this.getGeometry().getWidth());
    if (this.getGeometry().getHeight() < 10) {
      this.updown = 10 / 2;
    }

    // if (graph.getLabel(this) != null) {
    // final String t = this.labels.get(i);
    // final Rectangle2D rect = Artist.getBounds(this.fontBold, t);
    // final int ww = (int) rect.getWidth() + 1; // Round it up
    // if (this.getGeometry().getWidth() < ww) {
    // this.getGeometry().setWidth(ww);
    // }
    // this.getGeometry().setHeight(this.getGeometry().getHeight() + this.ad);
    // }
    double hw = (this.getGeometry().getWidth() + 1) / 2 + 5;
    if (hw < this.ad / 2) {
      hw = this.ad / 2;
    }
    this.getGeometry().setWidth(hw * 2);
    this.side = hw;
    double hh = (this.getGeometry().getHeight() + 1) / 2 + 5;
    if (hh < this.ad / 2) {
      hh = this.ad / 2;
    }
    this.getGeometry().setHeight(hh * 2);
    this.updown = hh;

    // for (int i = 0; i < this.selfs.size(); i++) {
    // if (i == 0) {
    // this.reserved = this.side + 40;
    // continue;
    // }
    // final String label = this.selfs.get(i - 1).label();
    // this.reserved = this.reserved + (int) Artist.getBounds(false, label).getWidth() + 2 + 20;
    // }
    // if (this.reserved > 0) {
    // final String label = this.selfs.get(this.selfs.size() - 1).label();
    // this.reserved = this.reserved + (int) Artist.getBounds(false, label).getWidth() + 2 + 20;
    // }
  }

  void calcReserved(final VisualizationGraph graph) {
    this.reserved = 0;
    final List<mxCell> selfEdges = new ArrayList<mxCell>();

    for (final Object object : graph.getEdgeList()) {
      if (((mxCell) object).getTarget().equals(((mxCell) object).getSource())) {
        selfEdges.add((mxCell) object);
      }
    }

    // for (int i = 0; i < selfEdges.size(); i++) {
    // if (i == 0) {
    // this.reserved = this.side + 40;
    // continue;
    // }
    // final String label = selfEdges.get(i - 1).getAttribute("name");
    // this.reserved = this.reserved + (int) Artist.getBounds(false, label).getWidth() + 2 + 20;
    // }
    // if (this.reserved > 0) {
    // final String label = selfEdges.get(selfEdges.size() - 1).getAttribute("name");
    // this.reserved = this.reserved + (int) Artist.getBounds(false, label).getWidth() + 2 + 20;
    // }
  }

  /**
   * Returns a clone of the cell.
   */
  @Override
  public Object clone() throws CloneNotSupportedException {
    final mxCell clone = (mxCell) super.clone();

    clone.setValue(this.cloneValue());
    clone.setStyle(this.getStyle());
    clone.setCollapsed(this.isCollapsed());
    clone.setConnectable(this.isConnectable());
    clone.setEdge(this.isEdge());
    clone.setVertex(this.isVertex());
    clone.setVisible(this.isVisible());
    clone.setParent(null);
    clone.setSource(null);
    clone.setTarget(null);
    clone.children = null;
    clone.edges = null;

    final mxGeometry geometry = this.getGeometry();

    if (geometry != null) {
      clone.setGeometry((mxGeometry) geometry.clone());
    }

    return clone;
  }

  /**
   * Returns a clone of the user object. This implementation clones any XML nodes or otherwise
   * returns the same user object instance.
   */
  protected Object cloneValue() {
    Object value = this.getValue();

    if (value instanceof Node) {
      value = ((Node) value).cloneNode(true);
    }

    return value;
  }

  /**
   * Returns the specified attribute from the user object if it is an XML node.
   *
   * @param name Name of the attribute whose value should be returned.
   * @return Returns the value of the given attribute or null.
   */
  public String getAttribute(final String name) {
    return this.getAttribute(name, null);
  }

  /**
   * Returns the specified attribute from the user object if it is an XML node.
   *
   * @param name Name of the attribute whose value should be returned.
   * @param defaultValue Default value to use if the attribute has no value.
   * @return Returns the value of the given attribute or defaultValue.
   */
  public String getAttribute(final String name, final String defaultValue) {
    final Object userObject = this.getValue();
    String val = null;

    if (userObject instanceof Element) {
      final Element element = (Element) userObject;
      val = element.getAttribute(name);
    }

    if (val == null) {
      val = defaultValue;
    }

    return val;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#getChildAt(int)
   */
  @Override
  public mxICell getChildAt(final int index) {
    return this.children != null ? (mxICell) this.children.get(index) : null;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#getChildCount()
   */
  @Override
  public int getChildCount() {
    return this.children != null ? this.children.size() : 0;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#getEdgeAt(int)
   */
  @Override
  public mxICell getEdgeAt(final int index) {
    return this.edges != null ? (mxICell) this.edges.get(index) : null;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#getEdgeCount()
   */
  @Override
  public int getEdgeCount() {
    return this.edges != null ? this.edges.size() : 0;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#getEdgeIndex(com.mxgraph.model.mxICell)
   */
  @Override
  public int getEdgeIndex(final mxICell edge) {
    return this.edges != null ? this.edges.indexOf(edge) : -1;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#getGeometry()
   */
  @Override
  public mxGeometry getGeometry() {
    return this.geometry;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#getId()
   */
  @Override
  public String getId() {
    return this.id;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#getIndex(com.mxgraph.model.mxICell)
   */
  @Override
  public int getIndex(final mxICell child) {
    return this.children != null ? this.children.indexOf(child) : -1;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#getParent()
   */
  @Override
  public mxICell getParent() {
    return this.parent;
  }

  /**
   * Returns the amount of space we need to reserve on the right hand side for the self edges (0 if
   * this has no self edges now)
   */
  public double getReserved(final VisualizationGraph graph) {
    final List<mxCell> selfEdges = new ArrayList<mxCell>();
    for (final Object object : graph.getEdgeList()) {
      if (((mxCell) object).getTarget().equals(((mxCell) object).getSource())) {
        selfEdges.add((mxCell) object);
      }
    }

    if (selfEdges.isEmpty()) {
      return 0;
    } else if (this.updown < 0) {
      this.calcReserved(graph);
    }
    return this.reserved;
  }

  /**
   * Returns the source terminal.
   */
  public mxICell getSource() {
    return this.source;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#getStyle()
   */
  @Override
  public String getStyle() {
    return this.style;
  }

  /**
   * Returns the target terminal.
   */
  public mxICell getTarget() {
    return this.target;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#getTerminal(boolean)
   */
  @Override
  public mxICell getTerminal(final boolean source) {
    return source ? this.getSource() : this.getTarget();
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#getValue()
   */
  @Override
  public Object getValue() {
    return this.value;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#insert(com.mxgraph.model.mxICell)
   */
  @Override
  public mxICell insert(final mxICell child) {
    int index = this.getChildCount();

    if (child.getParent() == this) {
      index--;
    }

    return this.insert(child, index);
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#insert(com.mxgraph.model.mxICell, int)
   */
  @Override
  public mxICell insert(final mxICell child, final int index) {
    if (child != null) {
      child.removeFromParent();
      child.setParent(this);

      if (this.children == null) {
        this.children = new ArrayList<Object>();
        this.children.add(child);
      } else {
        this.children.add(index, child);
      }
    }

    return child;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#insertEdge(com.mxgraph.model.mxICell, boolean)
   */
  @Override
  public mxICell insertEdge(final mxICell edge, final boolean isOutgoing) {
    if (edge != null) {
      edge.removeFromTerminal(isOutgoing);
      edge.setTerminal(this, isOutgoing);

      if (this.edges == null || edge.getTerminal(!isOutgoing) != this
          || !this.edges.contains(edge)) {
        if (this.edges == null) {
          this.edges = new ArrayList<Object>();
        }

        this.edges.add(edge);
      }
    }

    return edge;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#isCollapsed()
   */
  @Override
  public boolean isCollapsed() {
    return this.collapsed;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#isConnectable()
   */
  @Override
  public boolean isConnectable() {
    return this.connectable;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#isEdge()
   */
  @Override
  public boolean isEdge() {
    return this.edge;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#isVertex()
   */
  @Override
  public boolean isVertex() {
    return this.vertex;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#isVisible()
   */
  @Override
  public boolean isVisible() {
    return this.visible;
  }

  public int layer() {
    return this.layer;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#remove(int)
   */
  @Override
  public mxICell remove(final int index) {
    mxICell child = null;

    if (this.children != null && index >= 0) {
      child = this.getChildAt(index);
      this.remove(child);
    }

    return child;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#remove(com.mxgraph.model.mxICell)
   */
  @Override
  public mxICell remove(final mxICell child) {
    if (child != null && this.children != null) {
      this.children.remove(child);
      child.setParent(null);
    }

    return child;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#removeEdge(com.mxgraph.model.mxICell, boolean)
   */
  @Override
  public mxICell removeEdge(final mxICell edge, final boolean isOutgoing) {
    if (edge != null) {
      if (edge.getTerminal(!isOutgoing) != this && this.edges != null) {
        this.edges.remove(edge);
      }

      edge.setTerminal(null, isOutgoing);
    }

    return edge;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#removeFromParent()
   */
  @Override
  public void removeFromParent() {
    if (this.parent != null) {
      this.parent.remove(this);
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#removeFromTerminal(boolean)
   */
  @Override
  public void removeFromTerminal(final boolean isSource) {
    final mxICell terminal = this.getTerminal(isSource);

    if (terminal != null) {
      terminal.removeEdge(this, isSource);
    }
  }

  /**
   * Sets the specified attribute on the user object if it is an XML node.
   *
   * @param name Name of the attribute whose value should be set.
   * @param value New value of the attribute.
   */
  public void setAttribute(final String name, final String value) {
    final Object userObject = this.getValue();

    if (userObject instanceof Element) {
      final Element element = (Element) userObject;
      element.setAttribute(name, value);
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#setCollapsed(boolean)
   */
  @Override
  public void setCollapsed(final boolean collapsed) {
    this.collapsed = collapsed;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#setConnectable(boolean)
   */
  public void setConnectable(final boolean connectable) {
    this.connectable = connectable;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#setEdge(boolean)
   */
  public void setEdge(final boolean edge) {
    this.edge = edge;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#setGeometry(com.mxgraph.model.mxGeometry)
   */
  @Override
  public void setGeometry(final mxGeometry geometry) {
    this.geometry = geometry;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#setId(String)
   */
  @Override
  public void setId(final String id) {
    this.id = id;
  }

  public void setLayer(final VisualizationGraph graph, final int newLayer) {
    if (newLayer < 0) {
      throw new IllegalArgumentException("The layer cannot be negative!");
    }
    if (this.layer == newLayer) {
      return;
    }
    graph.layerlist.get(this.layer).remove(this);
    this.layer = newLayer;
    while (this.layer >= graph.layerlist.size()) {
      graph.layerlist.add(new ArrayList<mxCell>());
    }
    graph.layerlist.get(this.layer).add(this);
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#setParent(com.mxgraph.model.mxICell)
   */
  @Override
  public void setParent(final mxICell parent) {
    this.parent = parent;
  }

  /**
   * Sets the source terminal.
   *
   * @param source Cell that represents the new source terminal.
   */
  public void setSource(final mxICell source) {
    this.source = source;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#setStyle(String)
   */
  @Override
  public void setStyle(final String style) {
    this.style = style;
  }

  /**
   * Sets the target terminal.
   *
   * @param target Cell that represents the new target terminal.
   */
  public void setTarget(final mxICell target) {
    this.target = target;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#setTerminal(com.mxgraph.model.mxICell, boolean)
   */
  @Override
  public mxICell setTerminal(final mxICell terminal, final boolean isSource) {
    if (isSource) {
      this.setSource(terminal);
    } else {
      this.setTarget(terminal);
    }

    return terminal;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#setValue(Object)
   */
  @Override
  public void setValue(final Object value) {
    this.value = value;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#setVertex(boolean)
   */
  public void setVertex(final boolean vertex) {
    this.vertex = vertex;
  }

  /*
   * (non-Javadoc)
   *
   * @see com.mxgraph.model.mxICell#setVisible(boolean)
   */
  @Override
  public void setVisible(final boolean visible) {
    this.visible = visible;
  }

  @Override
  public String toString() {
    if (this.isVertex()) {
      final Element value = (Element) this.value;
      return value.getAttribute("name") + ": " + this.geometry.toString();
    } else if (this.isEdge()) {
      return this.value.toString() + ": " + this.geometry.toString();
    } else {
      return "Unknown type";
    }
  }
}
