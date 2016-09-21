/**
 * Copyright (c) 2007, Gaudenz Alder
 */
package com.mxgraph.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

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

  /**
   * Reference to the parent cell and source and target terminals for edges.
   */
  protected mxICell parent, source, target;

  /**
   * Holds the child cells and connected edges.
   */
  protected List<Object> children, edges;

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

  // @Override
  // public boolean equals(final Object obj) {
  // if (obj instanceof mxCell) {
  // final mxCell other = (mxCell) obj;
  // if (other.getValue() != null && !other.getValue().equals(this.getValue())) {
  // return false;
  // } else if (other.getId() != null && !other.getId().equals(this.getId())) {
  // return false;
  // } else if (other.getAttribute("name") != null
  // && !other.getAttribute("name").equals(this.getAttribute("name"))) {
  // return false;
  // }
  // }
  // return true;
  // }

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
    } else if (userObject instanceof String) {
      return (String) userObject;
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

  // @Override
  // public String toString() {
  // if (this.isVertex()) {
  // return this.getAttribute("name") + " : " + this.getGeometry().toString();
  // } else {
  // return this.getSource().toString() + "--" + (String) this.getValue() + "-->"
  // + this.getTarget().toString() + "\n";
  // }
  // }
}
