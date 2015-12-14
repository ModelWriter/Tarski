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
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

/**
 * Mutable; represents a graphical edge.
 *
 * <p>
 * <b>Thread Safety:</b> Can be called only by the AWT event thread.
 */

public final strictfp class GraphEdge {

  // =============================== adjustable options
  // ===========================================================================

  /** The angle (in radian) to fan out the arrow head, if the line is not bold. */
  private final double smallFan = StrictMath.toRadians(16);

  /** The angle (in radian) to fan out the arrow head, if the line is bold. */
  private final double bigFan = StrictMath.toRadians(32);

  // =============================== cached for performance efficiency
  // ============================================================

  /**
   * The maximum ascent and descent. We deliberately do NOT make this field "static" because only
   * AWT thread can call Artist.
   */
  private final int ad = Artist.getMaxAscentAndDescent();

  // =============================== fields
  // =======================================================================================

  /**
   * a user-provided annotation that will be associated with this edge (can be null) (need not be
   * unique)
   */
  public final Object uuid;

  /**
   * a user-provided annotation that will be associated with this edge (all edges with same group
   * will be highlighted together)
   */
  public final Object group;

  /**
   * The "from" node; must stay in sync with GraphNode.ins and GraphNode.outs and GraphNode.selfs
   */
  private GraphNode a;

  /** The "to" node; must stay in sync with GraphNode.ins and GraphNode.outs and GraphNode.selfs */
  private GraphNode b;

  /**
   * The label (can be ""); NOTE: label will be drawn only if the start node is not a dummy node.
   */
  private final String label;

  /** Whether to draw an arrow head on the "from" node; default is false. */
  private boolean ahead = false;

  /** Whether to draw an arrow head on the "to" node; default is true. */
  private boolean bhead = true;

  /** The color of the edge; default is BLACK; never null. */
  private Color color = Color.BLACK;

  /** The line-style of the edge; default is SOLID; never null. */
  private DotStyle style = DotStyle.SOLID;

  /** The edge weight; default is 1; always between 1 and 10000 inclusively. */
  private int weight = 1;

  /** The location and size of the label box; initially (0, 0, label.width, label.height) */
  private final AvailableSpace.Box labelbox;

  /** The actual path corresponding to this edge; initially null until it's computed. */
  private Curve path = null;

  // =========================================================================s====================================================

  /**
   * Construct an edge from "from" to "to" with the given arrow head settings, then add the edge to
   * the graph.
   */
  GraphEdge(final GraphNode from, final GraphNode to, final Object uuid, final String label,
      final boolean drawArrowHeadOnFrom, final boolean drawArrowHeadOnTo, final DotStyle style,
      final Color color, Object group) {
    if (group instanceof GraphNode) {
      throw new IllegalArgumentException("group cannot be a GraphNode");
    }
    if (group instanceof GraphEdge) {
      throw new IllegalArgumentException("group cannot be a GraphEdge");
    }
    if (group == null) {
      group = new Object();
    }
    this.a = from;
    this.b = to;
    if (this.a.graph != this.b.graph) {
      throw new IllegalArgumentException("You cannot draw an edge between two different graphs.");
    }
    if (this.a == this.b) {
      this.a.selfs.add(this);
    } else {
      this.a.outs.add(this);
      this.b.ins.add(this);
    }
    this.a.graph.edgelist.add(this);
    this.uuid = uuid;
    this.group = group;
    this.label = label == null ? "" : label;
    this.ahead = drawArrowHeadOnFrom;
    this.bhead = drawArrowHeadOnTo;
    if (style != null) {
      this.style = style;
    }
    if (color != null) {
      this.color = color;
    }
    if (this.label.length() > 0) {
      final Rectangle2D box = Artist.getBounds(false, label);
      this.labelbox = new AvailableSpace.Box(0, 0, (int) box.getWidth(), (int) box.getHeight());
    } else {
      this.labelbox = new AvailableSpace.Box(0, 0, 0, 0);
    }
  }

  /** Construct an edge from "from" to "to", then add the edge to the graph. */
  public GraphEdge(final GraphNode from, final GraphNode to, final Object uuid, final String label,
      final Object group) {
    this(from, to, uuid, label, false, true, null, null, group);
  }

  /** Returns the "from" node. */
  public GraphNode a() {
    return this.a;
  }

  /** Returns true if we will draw an arrow head on the "from" node. */
  public boolean ahead() {
    return this.ahead;
  }

  /** Returns the "to" node. */
  public GraphNode b() {
    return this.b;
  }

  /** Returns true if we will draw an arrow head on the "to" node. */
  public boolean bhead() {
    return this.bhead;
  }

  /** Changes the "to" node to the given node. */
  void change(final GraphNode newTo) {
    if (this.b.graph != newTo.graph) {
      throw new IllegalArgumentException("You cannot draw an edge between two different graphs.");
    }
    if (this.a == this.b) {
      this.a.selfs.remove(this);
    } else {
      this.a.outs.remove(this);
      this.b.ins.remove(this);
    }
    this.b = newTo;
    if (this.a == this.b) {
      this.a.selfs.add(this);
    } else {
      this.a.outs.add(this);
      this.b.ins.add(this);
    }
  }

  /** Returns the line color; never null. */
  public Color color() {
    return this.color;
  }

  /**
   * Assuming this edge's coordinates have been properly assigned, and given the current zoom scale,
   * draw the edge.
   */
  void draw(final Artist gr, final double scale, final GraphEdge highEdge, final Object highGroup) {
    final int top = this.a.graph.getTop(), left = this.a.graph.getLeft();
    gr.translate(-left, -top);
    if (highEdge == this) {
      gr.setColor(this.color);
      gr.set(DotStyle.BOLD, scale);
    } else if (highEdge == null && highGroup == null || highGroup == this.group) {
      gr.setColor(this.color);
      gr.set(this.style, scale);
    } else {
      gr.setColor(Color.LIGHT_GRAY);
      gr.set(this.style, scale);
    }
    if (this.a == this.b) {
      gr.draw(this.path);
    } else {
      // Concatenate this path and its connected segments into a single VizPath object, then draw it
      Curve p = null;
      GraphEdge e = this;
      while (e.a.shape() == null) {
        e = e.a.ins.get(0); // Let e be the first segment of this chain of connected segments
      }
      while (true) {
        p = p == null ? e.path : p.join(e.path);
        if (e.b.shape() != null) {
          break;
        }
        e = e.b.outs.get(0);
      }
      gr.drawSmoothly(p);
    }
    gr.set(DotStyle.SOLID, scale);
    gr.translate(left, top);
    if (highEdge == null && highGroup == null && this.label.length() > 0) {
      this.drawLabel(gr, this.color, null);
    }
    this.drawArrowhead(gr, scale, highEdge, highGroup);
  }

  /**
   * Assuming this edge's coordinates have been assigned, and given the current zoom scale, draw the
   * arrow heads.
   */
  private void drawArrowhead(final Artist gr, final double scale, final GraphEdge highEdge,
      final Object highGroup) {
    final double tipLength = this.ad * 0.6D;
    final int top = this.a.graph.getTop(), left = this.a.graph.getLeft();
    // Check to see if this edge is highlighted or not
    double fan = this.style == DotStyle.BOLD ? this.bigFan : this.smallFan;
    if (highEdge == this) {
      fan = this.bigFan;
      gr.setColor(this.color);
      gr.set(DotStyle.BOLD, scale);
    } else if (highEdge == null && highGroup == null || highGroup == this.group) {
      gr.setColor(this.color);
      gr.set(this.style, scale);
    } else {
      gr.setColor(Color.LIGHT_GRAY);
      gr.set(this.style, scale);
    }
    for (GraphEdge e = this;; e = e.b.outs.get(0)) {
      if (e.ahead && e.a.shape() != null || e.bhead && e.b.shape() != null) {
        final Curve cv = e.path();
        if (e.ahead && e.a.shape() != null) {
          final CubicCurve2D.Double bez = cv.list.get(0);
          final double ax = bez.x1, ay = bez.y1, bx = bez.ctrlx1, by = bez.ctrly1;
          final double t = StrictMath.PI + StrictMath.atan2(ay - by, ax - bx);
          final double gx1 = ax + tipLength * StrictMath.cos(t - fan),
              gy1 = ay + tipLength * StrictMath.sin(t - fan);
          final double gx2 = ax + tipLength * StrictMath.cos(t + fan),
              gy2 = ay + tipLength * StrictMath.sin(t + fan);
          final GeneralPath gp = new GeneralPath();
          gp.moveTo((float) (gx1 - left), (float) (gy1 - top));
          gp.lineTo((float) (ax - left), (float) (ay - top));
          gp.lineTo((float) (gx2 - left), (float) (gy2 - top));
          gp.closePath();
          gr.draw(gp, true);

        }
        if (e.bhead && e.b.shape() != null) {
          final CubicCurve2D.Double bez = cv.list.get(cv.list.size() - 1);
          final double bx = bez.x2, by = bez.y2, ax = bez.ctrlx2, ay = bez.ctrly2;
          final double t = StrictMath.PI + StrictMath.atan2(by - ay, bx - ax);
          final double gx1 = bx + tipLength * StrictMath.cos(t - fan),
              gy1 = by + tipLength * StrictMath.sin(t - fan);
          final double gx2 = bx + tipLength * StrictMath.cos(t + fan),
              gy2 = by + tipLength * StrictMath.sin(t + fan);
          final GeneralPath gp = new GeneralPath();
          gp.moveTo((float) (gx1 - left), (float) (gy1 - top));
          gp.lineTo((float) (bx - left), (float) (by - top));
          gp.lineTo((float) (gx2 - left), (float) (gy2 - top));
          gp.closePath();
          gr.draw(gp, true);

        }
      }
      if (e.b.shape() != null) {
        break;
      }
    }
  }

  /**
   * Assuming this edge's coordinates have been properly assigned, and given the desired color, draw
   * the edge label.
   */
  void drawLabel(final Artist gr, final Color color, final Color erase) {
    if (this.label.length() > 0) {
      final int top = this.a.graph.getTop(), left = this.a.graph.getLeft();
      gr.translate(-left, -top);
      if (erase != null && this.a != this.b) {
        final Rectangle2D.Double rect = new Rectangle2D.Double(this.labelbox.x, this.labelbox.y,
            this.labelbox.w, this.labelbox.h);
        gr.setColor(erase);
        gr.draw(rect, true);
      }
      gr.setColor(color);
      gr.drawString(this.label, this.labelbox.x, this.labelbox.y + Artist.getMaxAscent());
      // if (((AlloyTuple) uuid).getAtoms().get(0).changed
      // && ((AlloyTuple) uuid).getAtoms().get(1).impacted)
      // gr.drawString(" !", labelbox.x - 15, labelbox.y + Artist.getMaxAscent());
      gr.translate(left, top);
      return;
    }
  }

  /** Return the height of the label box. */
  public int getLabelH() {
    return this.labelbox.h;
  }

  /** Return the width of the label box. */
  public int getLabelW() {
    return this.labelbox.w;
  }

  /** Return the X coordinate of the top-left corner of the label box. */
  public int getLabelX() {
    return this.labelbox.x;
  }

  /** Return the Y coordinate of the top-left corner of the label box. */
  public int getLabelY() {
    return this.labelbox.y;
  }

  /** Returns the label on this edge. */
  public String label() {
    return this.label;
  }

  /** Positions the arrow heads of the given edge properly. */
  void layout_arrowHead() {
    final Curve c = this.path();
    if (this.ahead() && this.a.shape() != null) {
      double in = 0D, out = 1D;
      while (StrictMath.abs(out - in) > 0.0001D) {
        final double t = (in + out) / 2;
        if (this.a.contains(c.getX(t), c.getY(t))) {
          in = t;
        } else {
          out = t;
        }
      }
      c.chopStart(in);
    }
    if (this.bhead() && this.b.shape() != null) {
      double in = 1D, out = this.a == this.b ? 0.5D : 0D;
      while (StrictMath.abs(out - in) > 0.0001D) {
        final double t = (in + out) / 2;
        if (this.b.contains(c.getX(t), c.getY(t))) {
          in = t;
        } else {
          out = t;
        }
      }
      c.chopEnd(in);
    }
  }

  /**
   * Returns the current path; if the path was not yet assigned, it returns a straight line from
   * "from" node to "to" node.
   */
  Curve path() {
    if (this.path == null) {
      this.resetPath();
    }
    return this.path;
  }

  /**
   * Given that this edge is already well-laid-out, this method moves the label hoping to
   * avoid/minimize overlap.
   */
  void repositionLabel(final AvailableSpace sp) {
    if (this.label.length() == 0 || this.a == this.b) {
      return; // labels on self-edges are already re-positioned by GraphEdge.resetPath()
    }
    final int gap = this.style == DotStyle.BOLD ? 4 : 2; // If the line is bold, we need to shift
                                                         // the
    // label to the right a little bit
    boolean failed = false;
    Curve p = this.path;
    for (GraphNode a = this.a; a.shape() == null;) {
      final GraphEdge e = a.ins.get(0);
      a = e.a;
      p = e.path().join(p);
    }
    for (GraphNode b = this.b; b.shape() == null;) {
      final GraphEdge e = b.outs.get(0);
      b = e.b;
      p = p.join(e.path());
    }
    for (double t = 0.5D;; t = t + 0.05D) {
      if (t >= 1D) {
        failed = true;
        t = 0.7D;
      }
      double x1 = p.getX(t), y = p.getY(t), x2 = p.getXatY(y + this.labelbox.h, t, 1D, x1);
      int x = (int) (x1 < x2 ? x2 + gap : x1 + gap);
      if (failed || sp.ok(x, (int) y, this.labelbox.w, this.labelbox.h)) {
        sp.add(this.labelbox.x = x, this.labelbox.y = (int) y, this.labelbox.w, this.labelbox.h);
        return;
      }
      final double t2 = 1D - t;
      x1 = p.getX(t2);
      y = p.getY(t2);
      x2 = p.getXatY(y + this.labelbox.h, t2, 1D, x1);
      x = (int) (x1 < x2 ? x2 + gap : x1 + gap);
      if (sp.ok(x, (int) y, this.labelbox.w, this.labelbox.h)) {
        sp.add(this.labelbox.x = x, this.labelbox.y = (int) y, this.labelbox.w, this.labelbox.h);
        return;
      }
    }
  }

  /**
   * Reset the path as a straightline from the center of the "from" node to the center of the "to"
   * node.
   */
  void resetPath() {
    final double ax = this.a.x(), ay = this.a.y();
    if (this.a == this.b) {
      double w = 0;
      for (int n = this.a.selfs.size(), i = 0; i < n; i++) {
        if (i == 0) {
          w = this.a.getWidth() / 2 + Graph.selfLoopA;
        } else {
          w = w + Artist.getBounds(false, this.a.selfs.get(i - 1).label()).getWidth()
              + Graph.selfLoopGL + Graph.selfLoopGR;
        }
        final GraphEdge e = this.a.selfs.get(i);
        if (e != this) {
          continue;
        }
        final double h = this.a.getHeight() / 2D * 0.7D, k = 0.55238D,
            wa = this.a.getWidth() / 2.0D, wb = w - wa;
        e.path = new Curve(ax, ay);
        e.path.cubicTo(ax, ay - k * h, ax + wa - k * wa, ay - h, ax + wa, ay - h);
        e.path.cubicTo(ax + wa + k * wb, ay - h, ax + wa + wb, ay - k * h, ax + wa + wb, ay);
        e.path.cubicTo(ax + wa + wb, ay + k * h, ax + wa + k * wb, ay + h, ax + wa, ay + h);
        e.path.cubicTo(ax + wa - k * wa, ay + h, ax, ay + k * h, ax, ay);
        e.labelbox.x = (int) (ax + w + Graph.selfLoopGL);
        e.labelbox.y = (int) (ay - Artist.getBounds(false, e.label()).getHeight() / 2);
        break;
      }
    } else {
      int i = 0, n = 0;
      for (final GraphEdge e : this.a.outs) {
        if (e == this) {
          i = n++;
        } else if (e.b == this.b) {
          n++;
        }
      }
      final double cx = this.b.x(), cy = this.b.y();
      double bx = (ax + cx) / 2;
      final double by = (ay + cy) / 2;
      this.path = new Curve(ax, ay);
      if (n > 1 && (n & 1) == 1) {
        if (i < n / 2) {
          bx = bx - (n / 2 - i) * 10;
        } else if (i > n / 2) {
          bx = bx + (i - n / 2) * 10;
        }
        this.path.lineTo(bx, by).lineTo(cx, cy);
      } else if (n > 1) {
        if (i < n / 2) {
          bx = bx - (n / 2 - i) * 10 + 5;
        } else {
          bx = bx + (i - n / 2) * 10 + 5;
        }
        this.path.lineTo(bx, by).lineTo(cx, cy);
      } else {
        this.path.lineTo(cx, cy);
      }
    }
  }

  /** Swaps the "from" node and "to" node. */
  void reverse() {
    if (this.a == this.b) {
      return;
    }
    this.a.outs.remove(this);
    this.b.ins.remove(this);
    this.a.ins.add(this);
    this.b.outs.add(this);
    final GraphNode x = this.a;
    this.a = this.b;
    this.b = x;
  }

  /**
   * Sets whether we will draw an arrow head on the "from" node, and whether we will draw an arrow
   * head on the "to" node.
   */
  public GraphEdge set(final boolean from, final boolean to) {
    this.ahead = from;
    this.bhead = to;
    return this;
  }

  /** Sets the line color. */
  public GraphEdge set(final Color color) {
    if (color != null) {
      this.color = color;
    }
    return this;
  }

  /** Sets the line style. */
  public GraphEdge set(final DotStyle style) {
    if (style != null) {
      this.style = style;
    }
    return this;
  }

  /** Sets the edge weight between 1 and 10000. */
  public GraphEdge set(int weightBetween1And10000) {
    if (weightBetween1And10000 < 1) {
      weightBetween1And10000 = 1;
    }
    if (weightBetween1And10000 > 10000) {
      weightBetween1And10000 = 10000;
    }
    this.weight = weightBetween1And10000;
    return this;
  }

  /** Returns the line style; never null. */
  public DotStyle style() {
    return this.style;
  }

  /** Returns a DOT representation of this edge (or "" if the start node is a dummy node) */
  @Override
  public String toString() {
    final GraphNode a = this.a;
    GraphNode b = this.b;
    if (a.shape() == null) {
      return ""; // This means this edge is virtual
    }
    while (b.shape() == null) {
      b = b.outs.get(0).b;
    }
    String color = Integer.toHexString(this.color.getRGB() & 0xFFFFFF);
    while (color.length() < 6) {
      color = "0" + color;
    }
    final StringBuilder out = new StringBuilder();
    out.append("\"N" + a.pos() + "\"");
    out.append(" -> ");
    out.append("\"N" + b.pos() + "\"");
    out.append(" [");
    out.append("uuid = \"" + (this.uuid == null ? "" : Graph.esc(this.uuid.toString())) + "\"");
    out.append(", color = \"#" + color + "\"");
    out.append(", fontcolor = \"#" + color + "\"");
    out.append(", style = \"" + this.style.getDotText() + "\"");
    out.append(", label = \"" + Graph.esc(this.label) + "\"");
    out.append(", dir = \"" + (this.ahead && this.bhead ? "both" : this.bhead ? "forward" : "back")
        + "\"");
    out.append(", weight = \"" + this.weight + "\"");
    out.append("]\n");
    return out.toString();
  }

  /** Returns the edge weight (which is always between 1 and 10000 inclusively). */
  public int weight() {
    return this.weight;
  }
}
