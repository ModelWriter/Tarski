package eu.modelwriter.visualization.editor;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphOutline;
import com.mxgraph.swing.handler.mxRubberband;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxPoint;

import eu.modelwriter.visualization.editor.util.EdgeUtil;
import eu.modelwriter.visualization.editor.util.NodeUtil;

public class GraphEditor extends JPanel {
  private static final long serialVersionUID = 8909390597370292504L;

  private final Graph graph;
  private final GraphComponent graphComponent;
  private mxRubberband rubberband;
  private KeyboardHandler keyboardHandler;
  private double oldCenterX;
  private double oldCenterY;
  private double newCenterX;
  private double newCenterY;
  private int controlPointNumber;
  private double oldMouseX;
  private double oldMouseY;
  private Object onWhat;
  private boolean isDragStart = false;

  private final Object[] objs = new Object[2];
  private ArrayList<mxCell> reverses = new ArrayList<mxCell>();
  private ArrayList<mxCell> sameEdges = new ArrayList<mxCell>();

  public GraphEditor() {
    this.setLayout(new BorderLayout(0, 0));
    this.graph = new Graph();
    this.graphComponent = new GraphComponent(this.graph);
    this.add(this.graphComponent, BorderLayout.CENTER);
    this.installHandlers();
    this.installListeners();
  }

  public Graph getGraph() {
    return this.graph;
  }

  public GraphComponent getGraphComponent() {
    return this.graphComponent;
  }

  protected void installHandlers() {
    // this.rubberband = new mxRubberband(this.graphComponent);
    this.keyboardHandler = new KeyboardHandler(this.graphComponent);
  }

  protected void installListeners() {
    // Installs mouse wheel listener for zooming
    this.graphComponent.getGraphControl().addMouseWheelListener(new MouseWheelListener() {
      @Override
      public void mouseWheelMoved(final MouseWheelEvent e) {
        if (e.getSource() instanceof mxGraphOutline || e.isControlDown()) {
          GraphEditor.this.mouseWheelMoved(e);
        }
      }
    });

    // Installs the popup menu in the graph component
    this.graphComponent.getGraphControl().addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(final MouseEvent e) {
        // Handles context menu on the Mac where the trigger is on mousepressed
        GraphEditor.this.onWhat = GraphEditor.this.graphComponent.getCellAt(e.getX(), e.getY());
        if (GraphEditor.this.onWhat != null) {
          GraphEditor.this.oldMouseX = e.getX();
          GraphEditor.this.oldMouseY = e.getY();
          final mxCell cell = (mxCell) GraphEditor.this.onWhat;
          if (cell.isVertex()) {
            GraphEditor.this.oldCenterX =
                ((mxCell) GraphEditor.this.onWhat).getGeometry().getCenterX();
            GraphEditor.this.oldCenterY =
                ((mxCell) GraphEditor.this.onWhat).getGeometry().getCenterY();
          } else if (cell.isEdge()) {
            final List<mxPoint> points = cell.getGeometry().getPoints();
            mxPoint point = null;
            GraphEditor.this.controlPointNumber = -1;
            for (int i = 0; i < points.size(); i++) {
              point = points.get(i);
              if (e.getX() + 3 >= point.getX() && e.getX() - 3 <= point.getX()
                  && e.getY() + 3 >= point.getY() && e.getY() - 3 <= point.getY()) {
                GraphEditor.this.controlPointNumber = i;
                break;
              }
            }
            if (point == null) {
              return;
            }
            GraphEditor.this.oldCenterX = point.getX();
            GraphEditor.this.oldCenterY = point.getY();
          }
        }
      }

      @Override
      public void mouseReleased(final MouseEvent e) {
        if (GraphEditor.this.isDragStart) {
          GraphEditor.this.tweakCell(e);
          GraphEditor.this.isDragStart = false;
        }
        if (e.isPopupTrigger()) {
          GraphEditor.this.showGraphPopupMenu(e);
        }
      }
    });

    // Installs a mouse motion listener to display the mouse location
    this.graphComponent.getGraphControl().addMouseMotionListener(new MouseMotionListener() {
      private void clear() {
        GraphEditor.this.graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, null,
            new Object[] {GraphEditor.this.onWhat});
        GraphEditor.this.graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, null,
            GraphEditor.this.objs);
        GraphEditor.this.graph.setCellStyles(mxConstants.STYLE_STROKECOLOR, null,
            GraphEditor.this.reverses.toArray());
        GraphEditor.this.graph.setCellStyles(mxConstants.STYLE_STROKEWIDTH, null,
            GraphEditor.this.reverses.toArray());
        GraphEditor.this.graph.setCellStyles(mxConstants.STYLE_NOLABEL, null,
            GraphEditor.this.reverses.toArray());
        GraphEditor.this.graph.setCellStyles(mxConstants.STYLE_STROKEWIDTH, null,
            GraphEditor.this.sameEdges.toArray());
      }

      @Override
      public void mouseDragged(final MouseEvent e) {
        GraphEditor.this.newCenterX =
            (int) (GraphEditor.this.oldCenterX + (e.getX() - GraphEditor.this.oldMouseX));
        GraphEditor.this.newCenterY =
            (int) (GraphEditor.this.oldCenterY + (e.getY() - GraphEditor.this.oldMouseY));
        if (SwingUtilities.isLeftMouseButton(e)) {
          GraphEditor.this.tweakCell(e);
          GraphEditor.this.isDragStart = true;
        }
      }

      @Override
      public void mouseMoved(final MouseEvent e) {
        this.clear();
        GraphEditor.this.onWhat = GraphEditor.this.graphComponent.getCellAt(e.getX(), e.getY());
        if (GraphEditor.this.onWhat != null) {
          final mxCell cell = (mxCell) GraphEditor.this.onWhat;
          if (cell.isVertex()) {
            GraphEditor.this.graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, "yellow",
                new Object[] {GraphEditor.this.onWhat});
          } else if (cell.isEdge()) {
            GraphEditor.this.objs[0] = cell.getSource();
            GraphEditor.this.objs[1] = cell.getTarget();
            GraphEditor.this.reverses =
                EdgeUtil.getInstance(GraphEditor.this.graph, GraphEditor.this.graphComponent)
                    .getReverseEdges(EdgeUtil
                        .getInstance(GraphEditor.this.graph, GraphEditor.this.graphComponent)
                        .getEdgeName(cell));
            GraphEditor.this.sameEdges =
                EdgeUtil.getInstance(GraphEditor.this.graph, GraphEditor.this.graphComponent)
                    .getSameEdges(EdgeUtil
                        .getInstance(GraphEditor.this.graph, GraphEditor.this.graphComponent)
                        .getEdgeName(cell));

            GraphEditor.this.graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, "yellow",
                GraphEditor.this.objs);
            GraphEditor.this.graph.setCellStyles(mxConstants.STYLE_STROKECOLOR, "lightgray",
                GraphEditor.this.reverses.toArray());
            GraphEditor.this.graph.setCellStyles(mxConstants.STYLE_STROKEWIDTH, "3",
                GraphEditor.this.reverses.toArray());
            GraphEditor.this.graph.setCellStyles(mxConstants.STYLE_NOLABEL, "true",
                GraphEditor.this.reverses.toArray());
            GraphEditor.this.graph.setCellStyles(mxConstants.STYLE_STROKEWIDTH, "3",
                GraphEditor.this.sameEdges.toArray());
          } else {
            // do nothing
          }
        }
      }
    });
  }

  protected void mouseWheelMoved(final MouseWheelEvent e) {
    if (e.getWheelRotation() < 0) {
      this.graphComponent.zoomIn();
    } else {
      this.graphComponent.zoomOut();
    }
  }

  protected void showGraphPopupMenu(final MouseEvent e) {
    final Point pt =
        SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), this.graphComponent);
    final PopupMenu menu = new PopupMenu(this.graph, this.getGraphComponent(), this.onWhat);
    menu.show(this.graphComponent, pt.x, pt.y);
    e.consume();
  }

  private void tweakCell(final MouseEvent e) {
    if (GraphEditor.this.onWhat != null) {
      final mxCell cell = (mxCell) GraphEditor.this.onWhat;
      if (cell.isVertex()) {
        final NodeUtil instance = NodeUtil.getInstance(this.graph, this.graphComponent);
        instance.tweak(cell, (int) this.oldCenterX, (int) this.oldCenterY, (int) this.newCenterX,
            (int) this.newCenterY);

        this.graphComponent.scrollCellToVisible(cell);
        if (cell.getGeometry().getY() < 0) {
          cell.getGeometry().setY(0.0);
        }
        if (cell.getGeometry().getX() < 0) {
          cell.getGeometry().setX(0.0);
        }
      } else if (cell.isEdge()) {
        final mxPoint point = EdgeUtil.getInstance(this.graph, this.graphComponent)
            .getControlPoint(cell, this.controlPointNumber);
        if (point == null) {
          return;
        }
        NodeUtil.getInstance(this.graph, this.graphComponent).tweakControlPoint(cell,
            this.controlPointNumber, (int) this.oldCenterY, (int) this.newCenterY);
        point.setX(e.getX());
        point.setY(e.getY());
        if (point.getY() < 0) {
          point.setY(0);
        }
        if (point.getX() < 0) {
          point.setX(0);
        }
      }
      this.graphComponent.refresh();
    }
  }
}
