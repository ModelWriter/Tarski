/*
 * Alloy Analyzer 4 -- Copyright (c) 2006-2009, Felix Chang
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.mit.csail.sdg.alloy4graph;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Mutable; represents a graphical node.
 *
 * <p>
 * <b>Thread Safety:</b> Can be called only by the AWT event thread.
 */

public final strictfp class GraphNode {

  // =============================== adjustable options
  // ==================================================

  /** This determines the minimum width of a dummy node. */
  private static final int dummyWidth = 30;

  /** This determines the minimum height of a dummy node. */
  private static final int dummyHeight = 10;

  /**
   * This determines the minimum amount of padding added above, left, right, and below the text
   * label.
   */
  private static final int labelPadding = 5;

  /** Color to use to show a highlighted node. */
  private static final Color COLOR_CHOSENNODE = Color.LIGHT_GRAY;

  // =============================== cached for performance ===================================

  /**
   * Caches the value of sqrt(3.0). The extra digits in the definition will be truncated by the Java
   * compiler.
   */
  private static final double sqrt3 = 1.7320508075688772935274463415058723669428052538103806280558D;

  /**
   * Caches the value of sin(36 degree). The extra digits in the definition will be truncated by the
   * Java compiler.
   */
  private static final double sin36 = 0.5877852522924731291687059546390727685976524376431459910723D;

  /**
   * Caches the value of cos(36 degree). The extra digits in the definition will be truncated by the
   * Java compiler.
   */
  private static final double cos36 = 0.8090169943749474241022934171828190588601545899028814310677D;

  /**
   * Caches the value of cos(18 degree). The extra digits in the definition will be truncated by the
   * Java compiler.
   */
  private static final double cos18 = 0.9510565162951535721164393333793821434056986341257502224473D;

  /**
   * Caches the value of tan(18 degree). The extra digits in the definition will be truncated by the
   * Java compiler.
   */
  private static final double tan18 = 0.3249196962329063261558714122151344649549034715214751003078D;

  public static int xLabel, yLabel;

  // =============================== these fields do not affect the computed bounds
  // ===============================================

  /**
   * The maximum ascent and descent. We deliberately do NOT make this field "static" because only
   * AWT thread can call Artist.
   */
  private final int ad = Artist.getMaxAscentAndDescent();

  /**
   * a user-provided annotation that will be associated with this node (can be null) (need not be
   * unique)
   */
  public final Object uuid;

  /**
   * The X coordinate of the center of the node; modified by tweak(), layout_computeX(), layout(),
   * and relayout_edges()
   */
  private int centerX = 0;

  /**
   * The Y coordinate of the center of the node; modified by tweak(), layout_computeX(), layout(),
   * and relayout_edges()
   */
  private int centerY = 0;

  /**
   * The graph that this node belongs to; must stay in sync with Graph.nodelist and Graph.layerlist
   */
  final Graph graph;

  /** The layer that this node is in; must stay in sync with Graph.layerlist */
  private int layer = 0;

  /**
   * The current position of this node in the graph's node list; must stay in sync with
   * Graph.nodelist
   */
  int pos;

  /**
   * The "in" edges not including "self" edges; must stay in sync with GraphEdge.a and GraphEdge.b
   */
  final LinkedList<GraphEdge> ins = new LinkedList<GraphEdge>();

  // =============================== these fields affect the computed bounds
  // ===================================================

  /**
   * The "out" edges not including "self" edges; must stay in sync with GraphEdge.a and GraphEdge.b
   */
  final LinkedList<GraphEdge> outs = new LinkedList<GraphEdge>();

  /**
   * The "self" edges; must stay in sync with GraphEdge.a and GraphEdge.b
   * <p>
   * When this value changes, we should invalidate the previously computed bounds information.
   */
  final LinkedList<GraphEdge> selfs = new LinkedList<GraphEdge>();

  /**
   * The font boldness.
   * <p>
   * When this value changes, we should invalidate the previously computed bounds information.
   */
  private boolean fontBold = false;

  /**
   * The node labels; if null or empty, then the node has no labels.
   * <p>
   * When this value changes, we should invalidate the previously computed bounds information.
   */
  private List<String> labels = null;

  /**
   * The node color; never null.
   * <p>
   * When this value changes, we should invalidate the previously computed bounds information.
   */
  private Color color = Color.WHITE;

  /**
   * The line style; never null.
   * <p>
   * When this value changes, we should invalidate the previously computed bounds information.
   */
  private DotStyle style = DotStyle.SOLID;

  // ============================ these fields are computed by calcBounds()
  // =========================================

  /**
   * The node shape; if null, then the node is a dummy node.
   * <p>
   * When this value changes, we should invalidate the previously computed bounds information.
   */
  private DotShape shape = DotShape.BOX;

  /** If (updown>=0), this is the distance from the center to the top edge. */
  private int updown = -1;

  /** If (updown>=0), this is the distance from the center to the left edge. */
  private int side = 0;

  /**
   * If (updown>=0), this is the vertical distance between the center of the text label and the
   * center of the node.
   */
  private int yShift = 0;

  /** If (updown>=0), this is the width of the text label. */
  private int width = 0;

  /** If (updown>=0), this is the height of the text label. */
  private int height = 0;

  /**
   * If (updown>=0), this is the amount of space on the right set-aside for self-loops (which is 0
   * if node has no self loops)
   */
  private int reserved = 0;

  /**
   * If (updown>=0 and shape!=null), this is the bounding polygon. Note: if not null, it must be
   * either a GeneralPath or a Polygon.
   */
  private Shape poly = null;

  /**
   * If (updown>=0 and shape!=null and poly2!=null), then poly2 will also be drawn during the draw()
   * method. Note: if not null, it must be either a GeneralPath or a Polygon.
   */
  private Shape poly2 = null;

  /**
   * If (updown>=0 and shape!=null and poly3!=null), then poly3 will also be drawn during the draw()
   * method. Note: if not null, it must be either a GeneralPath or a Polygon.
   */
  private Shape poly3 = null;

  public Artist artist;

  // ===================================================================================================

  /** Create a new node with the given list of labels, then add it to the given graph. */
  public GraphNode(final Graph graph, final Object uuid, final String... labels) {
    this.uuid = uuid;
    this.graph = graph;
    this.pos = graph.nodelist.size();
    graph.nodelist.add(this);
    if (graph.layerlist.size() == 0) {
      graph.layerlist.add(new ArrayList<GraphNode>());
    }
    graph.layerlist.get(0).add(this);
    if (labels != null && labels.length > 0) {
      this.labels = new ArrayList<String>(labels.length);
      for (int i = 0; i < labels.length; i++) {
        this.labels.add(labels[i]);
      }
    }
  }

  /** Add the given label after the existing labels, then invalidate the computed bounds. */
  public GraphNode addLabel(final String label) {
    if (label == null || label.length() == 0) {
      return this;
    }
    if (this.labels == null) {
      this.labels = new ArrayList<String>();
    }
    this.labels.add(label);
    this.updown = -1;
    return this;
  }

  /** (Re-)calculate this node's bounds. */
  void calcBounds() {
    this.reserved = this.yShift = 0;
    this.width = 2 * GraphNode.labelPadding;
    if (this.width < GraphNode.dummyWidth) {
      this.side = GraphNode.dummyWidth / 2;
    }
    this.height = this.width;
    if (this.height < GraphNode.dummyHeight) {
      this.updown = GraphNode.dummyHeight / 2;
    }
    this.poly = this.poly2 = this.poly3 = null;
    if (this.shape == null) {
      return;
    }
    Polygon poly = new Polygon();
    if (this.labels != null) {
      for (int i = 0; i < this.labels.size(); i++) {
        final String t = this.labels.get(i);
        final Rectangle2D rect = Artist.getBounds(this.fontBold, t);
        final int ww = (int) rect.getWidth() + 1; // Round it up
        if (this.width < ww) {
          this.width = ww;
        }
        this.height = this.height + this.ad;
      }
    }
    int hw = (this.width + 1) / 2 + GraphNode.labelPadding;
    if (hw < this.ad / 2) {
      hw = this.ad / 2;
    }
    this.width = hw * 2;
    this.side = hw;
    int hh = (this.height + 1) / 2 + GraphNode.labelPadding;
    if (hh < this.ad / 2) {
      hh = this.ad / 2;
    }
    this.height = hh * 2;
    this.updown = hh;
    switch (this.shape) {
      case HOUSE: {
        this.yShift = this.ad / 2;
        this.updown = this.updown + this.yShift;
        poly.addPoint(-hw, this.yShift - hh);
        poly.addPoint(0, -this.updown);
        poly.addPoint(hw, this.yShift - hh);
        poly.addPoint(hw, this.yShift + hh);
        poly.addPoint(-hw, this.yShift + hh);
        break;
      }
      case INV_HOUSE: {
        this.yShift = -this.ad / 2;
        this.updown = this.updown - this.yShift;
        poly.addPoint(-hw, this.yShift - hh);
        poly.addPoint(hw, this.yShift - hh);
        poly.addPoint(hw, this.yShift + hh);
        poly.addPoint(0, this.updown);
        poly.addPoint(-hw, this.yShift + hh);
        break;
      }
      case TRIANGLE:
      case INV_TRIANGLE: {
        int dx = (int) (this.height / GraphNode.sqrt3);
        dx = dx + 1;
        if (dx < 6) {
          dx = 6;
        }
        int dy = (int) (hw * GraphNode.sqrt3);
        dy = dy + 1;
        if (dy < 6) {
          dy = 6;
        }
        dy = dy / 2 * 2;
        this.side += dx;
        this.updown += dy / 2;
        if (this.shape == DotShape.TRIANGLE) {
          this.yShift = dy / 2;
          poly.addPoint(0, -this.updown);
          poly.addPoint(hw + dx, this.updown);
          poly.addPoint(-hw - dx, this.updown);
        } else {
          this.yShift = -dy / 2;
          poly.addPoint(0, this.updown);
          poly.addPoint(hw + dx, -this.updown);
          poly.addPoint(-hw - dx, -this.updown);
        }
        break;
      }
      case HEXAGON: {
        this.side += this.ad;
        poly.addPoint(-hw - this.ad, 0);
        poly.addPoint(-hw, -hh);
        poly.addPoint(hw, -hh);
        poly.addPoint(hw + this.ad, 0);
        poly.addPoint(hw, hh);
        poly.addPoint(-hw, hh);
        break;
      }
      case TRAPEZOID: {
        this.side += this.ad;
        poly.addPoint(-hw, -hh);
        poly.addPoint(hw, -hh);
        poly.addPoint(hw + this.ad, hh);
        poly.addPoint(-hw - this.ad, hh);
        break;
      }
      case INV_TRAPEZOID: {
        this.side += this.ad;
        poly.addPoint(-hw - this.ad, -hh);
        poly.addPoint(hw + this.ad, -hh);
        poly.addPoint(hw, hh);
        poly.addPoint(-hw, hh);
        break;
      }
      case PARALLELOGRAM: {
        this.side += this.ad;
        poly.addPoint(-hw, -hh);
        poly.addPoint(hw + this.ad, -hh);
        poly.addPoint(hw, hh);
        poly.addPoint(-hw - this.ad, hh);
        break;
      }
      case M_DIAMOND:
      case DIAMOND: {
        if (this.shape == DotShape.M_DIAMOND) {
          if (hw < 10) {
            hw = 10;
            this.side = 10;
            this.width = 20;
          }
          if (hh < 10) {
            hh = 10;
            this.updown = 10;
            this.height = 20;
          }
        }
        this.updown += hw;
        this.side += hh;
        poly.addPoint(-hw - hh, 0);
        poly.addPoint(0, -hh - hw);
        poly.addPoint(hw + hh, 0);
        poly.addPoint(0, hh + hw);
        break;
      }
      case M_SQUARE: {
        if (hh < hw) {
          hh = hw;
        } else {
          hw = hh;
        }
        if (hh < 6) {
          hh = 6;
          hw = 6;
        }
        this.width = hw * 2;
        this.side = hw;
        this.height = hh * 2;
        this.updown = hh;
        this.side += 4;
        this.updown += 4;
        poly.addPoint(-hw - 4, -hh - 4);
        poly.addPoint(hw + 4, -hh - 4);
        poly.addPoint(hw + 4, hh + 4);
        poly.addPoint(-hw - 4, hh + 4);
        break;
      }
      case OCTAGON:
      case DOUBLE_OCTAGON:
      case TRIPLE_OCTAGON: {
        final int dx = this.width / 3, dy = this.ad;
        this.updown += dy;
        poly.addPoint(-hw, -hh);
        poly.addPoint(-hw + dx, -hh - dy);
        poly.addPoint(hw - dx, -hh - dy);
        poly.addPoint(hw, -hh);
        poly.addPoint(hw, hh);
        poly.addPoint(hw - dx, hh + dy);
        poly.addPoint(-hw + dx, hh + dy);
        poly.addPoint(-hw, hh);
        if (this.shape == DotShape.OCTAGON) {
          break;
        }
        final double c = StrictMath.sqrt(dx * dx + dy * dy), a = dx * dy / c, k = (a + 5) * dy / dx,
            r = StrictMath.sqrt((a + 5) * (a + 5) + k * k) - dy;
        final double dx1 = (r - 5) * dx / dy, dy1 = -((dx + 5D) * dy / dx - dy - r);
        int x1 = (int) StrictMath.round(dx1), y1 = (int) StrictMath.round(dy1);
        this.updown += 5;
        this.side += 5;
        this.poly2 = poly;
        poly = new Polygon();
        poly.addPoint(-hw - 5, -hh - y1);
        poly.addPoint(-hw + dx - x1, -hh - dy - 5);
        poly.addPoint(hw - dx + x1, -hh - dy - 5);
        poly.addPoint(hw + 5, -hh - y1);
        poly.addPoint(hw + 5, hh + y1);
        poly.addPoint(hw - dx + x1, hh + dy + 5);
        poly.addPoint(-hw + dx - x1, hh + dy + 5);
        poly.addPoint(-hw - 5, hh + y1);
        if (this.shape == DotShape.DOUBLE_OCTAGON) {
          break;
        }
        this.updown += 5;
        this.side += 5;
        this.poly3 = poly;
        poly = new Polygon();
        x1 = (int) StrictMath.round(dx1 * 2);
        y1 = (int) StrictMath.round(dy1 * 2);
        poly.addPoint(-hw - 10, -hh - y1);
        poly.addPoint(-hw + dx - x1, -hh - dy - 10);
        poly.addPoint(hw - dx + x1, -hh - dy - 10);
        poly.addPoint(hw + 10, -hh - y1);
        poly.addPoint(hw + 10, hh + y1);
        poly.addPoint(hw - dx + x1, hh + dy + 10);
        poly.addPoint(-hw + dx - x1, hh + dy + 10);
        poly.addPoint(-hw - 10, hh + y1);
        break;
      }
      case M_CIRCLE:
      case CIRCLE:
      case DOUBLE_CIRCLE: {
        int radius = (int) StrictMath.sqrt(hw * (double) hw + (double) hh * hh) + 2;
        if (this.shape == DotShape.DOUBLE_CIRCLE) {
          radius = radius + 5;
        }
        final int L = (int) (radius / GraphNode.cos18) + 2, a = (int) (L * GraphNode.sin36),
            b = (int) (L * GraphNode.cos36), c = (int) (radius * GraphNode.tan18);
        poly.addPoint(-L, 0);
        poly.addPoint(-b, a);
        poly.addPoint(-c, L);
        poly.addPoint(c, L);
        poly.addPoint(b, a);
        poly.addPoint(L, 0);
        poly.addPoint(b, -a);
        poly.addPoint(c, -L);
        poly.addPoint(-c, -L);
        poly.addPoint(-b, -a);
        this.updown = L;
        this.side = L;
        break;
      }
      case EGG:
      case ELLIPSE: {
        final int pad = this.ad / 2;
        this.side += pad;
        this.updown += pad;
        final int d = this.shape == DotShape.ELLIPSE ? 0 : this.ad / 2;
        final GeneralPath path = new GeneralPath();
        path.moveTo(-this.side, d);
        path.quadTo(-this.side, -this.updown, 0, -this.updown);
        path.quadTo(this.side, -this.updown, this.side, d);
        path.quadTo(this.side, this.updown, 0, this.updown);
        path.quadTo(-this.side, this.updown, -this.side, d);
        path.closePath();
        this.poly = path;
      }
      default: { // BOX
        if (this.shape != DotShape.BOX) {
          final int d = this.ad / 2;
          hw = hw + d;
          this.side = hw;
          hh = hh + d;
          this.updown = hh;
        }
        poly.addPoint(-hw, -hh);
        poly.addPoint(hw, -hh);
        poly.addPoint(hw, hh);
        poly.addPoint(-hw, hh);
      }
    }
    if (this.shape != DotShape.EGG && this.shape != DotShape.ELLIPSE) {
      this.poly = poly;
    }
    for (int i = 0; i < this.selfs.size(); i++) {
      if (i == 0) {
        this.reserved = this.side + Graph.selfLoopA;
        continue;
      }
      final String label = this.selfs.get(i - 1).label();
      this.reserved = this.reserved + (int) Artist.getBounds(false, label).getWidth()
          + Graph.selfLoopGL + Graph.selfLoopGR;
    }
    if (this.reserved > 0) {
      final String label = this.selfs.get(this.selfs.size() - 1).label();
      this.reserved = this.reserved + (int) Artist.getBounds(false, label).getWidth()
          + Graph.selfLoopGL + Graph.selfLoopGR;
    }
  }

  /** Returns true if the node contains the given point or not. */
  boolean contains(final double x, final double y) {
    if (this.shape == null) {
      return false;
    } else if (this.updown < 0) {
      this.calcBounds();
    }
    return this.poly.contains(x - this.centerX, y - this.centerY);
  }

  /**
   * Draws this node at its current (x, y) location; this method will call calcBounds() if
   * necessary.
   */
  void draw(final Artist gr, final double scale, final boolean highlight) {
    if (this.shape == null) {
      return;
    } else if (this.updown < 0) {
      this.calcBounds();
    }
    final int top = this.graph.getTop(), left = this.graph.getLeft();
    gr.set(this.style, scale);
    gr.translate(this.centerX - left, this.centerY - top);
    gr.setFont(this.fontBold);
    if (highlight) {
      gr.setColor(GraphNode.COLOR_CHOSENNODE);
    } else {
      gr.setColor(this.color);
    }
    if (this.shape == DotShape.CIRCLE || this.shape == DotShape.M_CIRCLE
        || this.shape == DotShape.DOUBLE_CIRCLE) {
      final int hw = this.width / 2, hh = this.height / 2;
      int radius = (int) StrictMath.sqrt(hw * (double) hw + (double) hh * hh) + 2;
      if (this.shape == DotShape.DOUBLE_CIRCLE) {
        radius = radius + 5;
      }
      gr.fillCircle(radius);
      gr.setColor(Color.BLACK);
      gr.drawCircle(radius);
      if (this.style == DotStyle.DOTTED || this.style == DotStyle.DASHED) {
        gr.set(DotStyle.SOLID, scale);
      }
      if (this.shape == DotShape.M_CIRCLE && 10 * radius >= 25 && radius > 5) {
        final int d = (int) StrictMath.sqrt(10 * radius - 25.0D);
        if (d > 0) {
          gr.drawLine(-d, -radius + 5, d, -radius + 5);
          gr.drawLine(-d, radius - 5, d, radius - 5);
        }
      }
      if (this.shape == DotShape.DOUBLE_CIRCLE) {
        gr.drawCircle(radius - 5);
      }
    } else {
      gr.draw(this.poly, true);
      gr.setColor(Color.BLACK);
      gr.draw(this.poly, false);
      if (this.poly2 != null) {
        gr.draw(this.poly2, false);
      }
      if (this.poly3 != null) {
        gr.draw(this.poly3, false);
      }
      if (this.style == DotStyle.DOTTED || this.style == DotStyle.DASHED) {
        gr.set(DotStyle.SOLID, scale);
      }
      if (this.shape == DotShape.M_DIAMOND) {
        gr.drawLine(-this.side + 8, -8, -this.side + 8, 8);
        gr.drawLine(-8, -this.side + 8, 8, -this.side + 8);
        gr.drawLine(this.side - 8, -8, this.side - 8, 8);
        gr.drawLine(-8, this.side - 8, 8, this.side - 8);
      }
      if (this.shape == DotShape.M_SQUARE) {
        gr.drawLine(-this.side, -this.side + 8, -this.side + 8, -this.side);
        gr.drawLine(this.side, -this.side + 8, this.side - 8, -this.side);
        gr.drawLine(-this.side, this.side - 8, -this.side + 8, this.side);
        gr.drawLine(this.side, this.side - 8, this.side - 8, this.side);
      }
    }
    gr.set(DotStyle.SOLID, scale);
    final int clr = this.color.getRGB() & 0xFFFFFF;
    gr.setColor(clr == 0x000000 || clr == 0xff0000 || clr == 0x0000ff ? Color.WHITE : Color.BLACK);
    if (this.labels != null && this.labels.size() > 0) {
      final int x = -this.width / 2;
      int y = this.yShift + -this.labels.size() * this.ad / 2;
      for (int i = 0; i < this.labels.size(); i++) {
        final String t = this.labels.get(i);
        int w = (int) Artist.getBounds(this.fontBold, t).getWidth() + 1; // Round it up
        if (this.width > w) {
          w = (this.width - w) / 2;
        } else {
          w = 0;
        }
        gr.drawString(t, x + w, y + Artist.getMaxAscent());
        this.artist = gr;
        GraphNode.xLabel = x + w;
        GraphNode.yLabel = y + Artist.getMaxAscent();

        y = y + this.ad;
      }
    }
    gr.translate(left - this.centerX, top - this.centerY);
  }

  /**
   * Returns the bounding rectangle (with 2*xfluff added to the width, and 2*yfluff added to the
   * height)
   */
  Rectangle2D getBoundingBox(final int xfluff, final int yfluff) {
    if (this.updown < 0) {
      this.calcBounds();
    }
    return new Rectangle2D.Double(this.x() - this.side - xfluff, this.y() - this.updown - yfluff,
        this.side + this.side + xfluff + xfluff, this.updown + this.updown + yfluff + yfluff);
  }

  /** Returns the node height. */
  int getHeight() {
    if (this.updown < 0) {
      this.calcBounds();
    }
    return this.updown + this.updown;
  }

  /**
   * Returns the amount of space we need to reserve on the right hand side for the self edges (0 if
   * this has no self edges now)
   */
  int getReserved() {
    if (this.selfs.isEmpty()) {
      return 0;
    } else if (this.updown < 0) {
      this.calcBounds();
    }
    return this.reserved;
  }

  /** Returns the node width. */
  int getWidth() {
    if (this.updown < 0) {
      this.calcBounds();
    }
    return this.side + this.side;
  }

  /** Returns an unmodifiable view of the list of "in" edges. */
  public List<GraphEdge> inEdges() {
    return Collections.unmodifiableList(this.ins);
  }

  /** Returns the layer that this node is in. */
  int layer() {
    return this.layer;
  }

  /** Returns an unmodifiable view of the list of "out" edges. */
  public List<GraphEdge> outEdges() {
    return Collections.unmodifiableList(this.outs);
  }

  /**
   * Returns the node's current position in the node list, which is always between 0 and
   * node.size()-1
   */
  int pos() {
    return this.pos;
  }

  /** Returns an unmodifiable view of the list of "self" edges. */
  public List<GraphEdge> selfEdges() {
    return Collections.unmodifiableList(this.selfs);
  }

  /** Changes the node color, then invalidate the computed bounds. */
  public GraphNode set(final Color color) {
    if (this.color != color && color != null) {
      this.color = color;
      this.updown = -1;
    }
    return this;
  }

  /**
   * Changes the node shape (where null means change the node into a dummy node), then invalidate
   * the computed bounds.
   */
  public GraphNode set(final DotShape shape) {
    if (this.shape != shape) {
      this.shape = shape;
      this.updown = -1;
    }
    return this;
  }

  /** Changes the line style, then invalidate the computed bounds. */
  public GraphNode set(final DotStyle style) {
    if (this.style != style && style != null) {
      this.style = style;
      this.updown = -1;
    }
    return this;
  }

  /** Changes the font boldness, then invalidate the computed bounds. */
  public GraphNode setFontBoldness(final boolean bold) {
    if (this.fontBold != bold) {
      this.fontBold = bold;
      this.updown = -1;
    }
    return this;
  }

  /**
   * Changes the layer that this node is in; the new layer must be 0 or greater.
   * <p>
   * If a node is removed from a layer, the order of the other nodes in that layer remain unchanged.
   * <p>
   * If a node is added to a new layer, then it is added to the right of the original rightmost node
   * in that layer.
   */
  void setLayer(final int newLayer) {
    if (newLayer < 0) {
      throw new IllegalArgumentException("The layer cannot be negative!");
    }
    if (this.layer == newLayer) {
      return;
    }
    this.graph.layerlist.get(this.layer).remove(this);
    this.layer = newLayer;
    while (this.layer >= this.graph.layerlist.size()) {
      this.graph.layerlist.add(new ArrayList<GraphNode>());
    }
    this.graph.layerlist.get(this.layer).add(this);
  }

  /**
   * Changes the X coordinate of the center of the node, without invalidating the computed bounds.
   */
  void setX(final int x) {
    this.centerX = x;
  }

  /**
   * Changes the Y coordinate of the center of the node, without invalidating the computed bounds.
   */
  void setY(final int y) {
    this.centerY = y;
  }

  /** Helper method that sets the Y coordinate of every node in a given layer. */
  private void setY(final int layer, final int y) {
    for (final GraphNode n : this.graph.layer(layer)) {
      n.centerY = y;
    }
  }

  /** Returns the node shape (or null if the node is a dummy node). */
  DotShape shape() {
    return this.shape;
  }

  /** Helper method that shifts a node down. */
  private void shiftDown(int y) {
    final int[] ph = this.graph.layerPH;
    final int yJump = Graph.yJump / 6;
    int i = this.layer();
    this.setY(i, y);
    y = y + ph[i] / 2; // y is now the bottom-most edge of this layer
    for (i--; i >= 0; i--) {
      final List<GraphNode> list = this.graph.layer(i);
      final GraphNode first = list.get(0);
      if (first.centerY - ph[i] / 2 - yJump < y) {
        this.setY(i, y + ph[i] / 2 + yJump);
      }
      y = first.centerY + ph[i] / 2;
    }
    this.graph.relayout_edges(false);
  }

  /** Helper method that shifts a node left. */
  private void shiftLeft(final List<GraphNode> peers, int i, int x) {
    final int xJump = Graph.xJump / 3;
    this.centerX = x;
    x = x - (this.shape == null ? 0 : this.side); // x is now the left-most edge of this node
    for (i--; i >= 0; i--) {
      final GraphNode node = peers.get(i);
      final int side = node.shape == null ? 0 : node.side;
      if (node.centerX + side + node.getReserved() + xJump > x) {
        node.centerX = x - side - node.getReserved() - xJump;
      }
      x = node.centerX - side;
    }
  }

  /** Helper method that shifts a node right. */
  private void shiftRight(final List<GraphNode> peers, int i, int x) {
    final int xJump = Graph.xJump / 3;
    this.centerX = x;
    x = x + (this.shape == null ? 0 : this.side) + this.getReserved(); // x is now the right most
                                                                       // edge of this node
    for (i++; i < peers.size(); i++) {
      final GraphNode node = peers.get(i);
      final int side = node.shape == null ? 0 : node.side;
      if (node.centerX - side - xJump < x) {
        node.centerX = x + side + xJump;
      }
      x = node.centerX + side + node.getReserved();
    }
  }

  /** Helper method that shifts a node up. */
  private void shiftUp(int y) {
    final int[] ph = this.graph.layerPH;
    final int yJump = Graph.yJump / 6;
    int i = this.layer();
    this.setY(i, y);
    y = y - ph[i] / 2; // y is now the top-most edge of this layer
    for (i++; i < this.graph.layers(); i++) {
      final List<GraphNode> list = this.graph.layer(i);
      final GraphNode first = list.get(0);
      if (first.centerY + ph[i] / 2 + yJump > y) {
        this.setY(i, y - ph[i] / 2 - yJump);
      }
      y = first.centerY - ph[i] / 2;
    }
    this.graph.relayout_edges(false);
  }

  /** Helper method that swaps a node towards the left. */
  private void swapLeft(final List<GraphNode> peers, int i, final int x) {
    final int side = this.shape == null ? 2 : this.side;
    final int left = x - side;
    while (true) {
      if (i == 0) {
        this.centerX = x;
        return;
      } // no clash possible
      final GraphNode other = peers.get(i - 1);
      final int otherSide = other.shape == null ? 0 : other.side;
      final int otherRight = other.centerX + otherSide + other.getReserved();
      if (otherRight < left) {
        this.centerX = x;
        return;
      } // no clash
      this.graph.swapNodes(this.layer(), i, i - 1);
      i--;
      if (other.shape != null) {
        other.shiftRight(peers, i + 1, x + side + this.getReserved() + otherSide);
      }
    }
  }

  /** Helper method that swaps a node towards the right. */
  private void swapRight(final List<GraphNode> peers, int i, final int x) {
    final int side = this.shape == null ? 2 : this.side;
    final int right = x + side + this.getReserved();
    while (true) {
      if (i == peers.size() - 1) {
        this.centerX = x;
        return;
      } // no clash possible
      final GraphNode other = peers.get(i + 1);
      final int otherSide = other.shape == null ? 0 : other.side;
      final int otherLeft = other.centerX - otherSide;
      if (otherLeft > right) {
        this.centerX = x;
        return;
      } // no clash
      this.graph.swapNodes(this.layer(), i, i + 1);
      i++;
      if (other.shape != null) {
        other.shiftLeft(peers, i - 1, x - side - other.getReserved() - otherSide);
      }
    }
  }

  /** Returns a DOT representation of this node (or "" if this is a dummy node) */
  @Override
  public String toString() {
    if (this.shape == null) {
      return ""; // This means it's a virtual node
    }
    final int rgb = this.color.getRGB() & 0xFFFFFF;
    final String text = rgb == 0xFF0000 || rgb == 0x0000FF || rgb == 0 ? "FFFFFF" : "000000";
    String main = Integer.toHexString(rgb);
    while (main.length() < 6) {
      main = "0" + main;
    }
    final StringBuilder out = new StringBuilder();
    out.append("\"N" + this.pos + "\"");
    out.append(" [");
    out.append("uuid=\"");
    if (this.uuid != null) {
      out.append(Graph.esc(this.uuid.toString()));
    }
    out.append("\", label=\"");
    boolean first = true;
    if (this.labels != null) {
      for (final String label : this.labels) {
        if (label.length() > 0) {
          out.append((first ? "" : "\\n") + Graph.esc(label));
          first = false;
        }
      }
    }
    out.append("\", color=\"#" + main + "\"");
    out.append(", fontcolor = \"#" + text + "\"");
    out.append(", shape = \"" + this.shape.getDotText() + "\"");
    out.append(", style = \"filled, " + this.style.getDotText() + "\"");
    out.append("]\n");
    return out.toString();
  }

  /**
   * Assuming the graph is already laid out, this shifts this node (and re-layouts nearby
   * nodes/edges as necessary)
   */
  void tweak(final int x, final int y) {
    if (this.centerX == x && this.centerY == y) {
      return; // If no change, then return right away
    }
    final List<GraphNode> layer = this.graph.layer(this.layer());
    final int n = layer.size();
    int i;
    for (i = 0; i < n; i++) {
      if (layer.get(i) == this) {
        break; // Figure out this node's position in its layer
      }
    }
    if (this.centerX > x) {
      this.swapLeft(layer, i, x);
    } else if (this.centerX < x) {
      this.swapRight(layer, i, x);
    }
    if (this.centerY > y) {
      this.shiftUp(y);
    } else if (this.centerY < y) {
      this.shiftDown(y);
    } else {
      this.graph.relayout_edges(this.layer());
    }
    this.graph.recalcBound(false);
  }

  // ===================================================================================================

  /** Returns the X coordinate of the center of the node. */
  public int x() {
    return this.centerX;
  }

  // ===================================================================================================

  /** Returns the Y coordinate of the center of the node. */
  public int y() {
    return this.centerY;
  }
}
