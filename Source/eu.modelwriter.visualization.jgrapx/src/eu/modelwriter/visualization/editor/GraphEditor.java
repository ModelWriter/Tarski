package eu.modelwriter.visualization.editor;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.handler.mxRubberband;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxPoint;

import eu.modelwriter.visualization.editor.util.EdgeUtil;
import eu.modelwriter.visualization.editor.util.GraphUtil;
import eu.modelwriter.visualization.editor.util.NodeUtil;

public class GraphEditor extends JPanel {
  private static final long serialVersionUID = 8909390597370292504L;

  private mxRubberband rubberband;
  private KeyboardHandler keyboardHandler;
  private double oldCenterX;
  private double oldCenterY;
  private double newCenterX;
  private double newCenterY;
  private int controlPointOrder;
  private int layerOfControlPoint;
  private double oldMouseX;
  private double oldMouseY;
  private Object onWhat;
  private boolean isDragStart = false;

  private final Object[] objs = new Object[2];
  private ArrayList<mxCell> reverses = new ArrayList<mxCell>();
  private ArrayList<mxCell> sameEdges = new ArrayList<mxCell>();

  public GraphEditor() {
    this.setLayout(new BorderLayout(0, 0));
    StaticEditorManager.graph = new Graph();
    StaticEditorManager.graphComponent = new GraphComponent(StaticEditorManager.graph);
    this.add(StaticEditorManager.graphComponent, BorderLayout.CENTER);
    this.installHandlers();
    this.installListeners();
  }

  public GraphComponent getGraphComponent() {
    return StaticEditorManager.graphComponent;
  }

  protected void installHandlers() {
    // this.rubberband = new mxRubberband(StaticEditorManager.graphComponent);
    this.keyboardHandler = new KeyboardHandler(StaticEditorManager.graphComponent);
  }

  protected void installListeners() {
    // Installs mouse wheel listener for zooming
    StaticEditorManager.graphComponent.getGraphControl()
        .addMouseWheelListener(new MouseWheelListener() {
          @Override
          public void mouseWheelMoved(final MouseWheelEvent e) {
            if (e.isControlDown()) {
              GraphEditor.this.mouseWheelMoved(e);
            }
          }
        });

    // Installs the popup menu in the graph component
    StaticEditorManager.graphComponent.getGraphControl().addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(final MouseEvent e) {
        // Handles context menu on the Mac where the trigger is on
        // mousepressed
        GraphEditor.this.onWhat = StaticEditorManager.graphComponent.getCellAt(e.getX(), e.getY());
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
            GraphEditor.this.controlPointOrder =
                EdgeUtil.getInstance(StaticEditorManager.graph, StaticEditorManager.graphComponent)
                    .getControlPointOrder(cell, e.getX(), e.getY());
            if (GraphEditor.this.controlPointOrder == -1) {
              return;
            }
            GraphEditor.this.layerOfControlPoint =
                EdgeUtil.getInstance(StaticEditorManager.graph, StaticEditorManager.graphComponent)
                    .layer(cell, GraphEditor.this.controlPointOrder);
            final mxPoint point =
                EdgeUtil.getInstance(StaticEditorManager.graph, StaticEditorManager.graphComponent)
                    .getControlPoint(cell, GraphEditor.this.controlPointOrder);
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
    StaticEditorManager.graphComponent.getGraphControl()
        .addMouseMotionListener(new MouseMotionListener() {
          private void clear() {
            StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, null,
                new Object[] {GraphEditor.this.onWhat});
            StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, null,
                GraphEditor.this.objs);
            StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_STROKECOLOR, null,
                GraphEditor.this.reverses.toArray());
            StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_STROKEWIDTH, null,
                GraphEditor.this.reverses.toArray());
            StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_NOLABEL, null,
                GraphEditor.this.reverses.toArray());
            StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_STROKEWIDTH, null,
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
            GraphEditor.this.onWhat =
                StaticEditorManager.graphComponent.getCellAt(e.getX(), e.getY());
            if (GraphEditor.this.onWhat != null) {
              final mxCell cell = (mxCell) GraphEditor.this.onWhat;
              if (cell.isVertex()) {
                StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, "yellow",
                    new Object[] {GraphEditor.this.onWhat});
              } else if (cell.isEdge()) {
                GraphEditor.this.objs[0] = cell.getSource();
                GraphEditor.this.objs[1] = cell.getTarget();
                GraphEditor.this.reverses = EdgeUtil
                    .getInstance(StaticEditorManager.graph, StaticEditorManager.graphComponent)
                    .getReverseEdges(EdgeUtil
                        .getInstance(StaticEditorManager.graph, StaticEditorManager.graphComponent)
                        .getEdgeName(cell));
                GraphEditor.this.sameEdges = EdgeUtil
                    .getInstance(StaticEditorManager.graph, StaticEditorManager.graphComponent)
                    .getSameEdges(EdgeUtil
                        .getInstance(StaticEditorManager.graph, StaticEditorManager.graphComponent)
                        .getEdgeName(cell));

                StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, "yellow",
                    GraphEditor.this.objs);
                StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_STROKECOLOR, "lightgray",
                    GraphEditor.this.reverses.toArray());
                StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_STROKEWIDTH, "4",
                    GraphEditor.this.reverses.toArray());
                StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_NOLABEL, "true",
                    GraphEditor.this.reverses.toArray());
                StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_STROKEWIDTH, "4",
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
      StaticEditorManager.graphComponent.zoomIn();
    } else {
      StaticEditorManager.graphComponent.zoomOut();
    }
  }

  protected void showGraphPopupMenu(final MouseEvent e) {
    final Point pt = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(),
        StaticEditorManager.graphComponent);
    final PopupMenu menu =
        new PopupMenu(StaticEditorManager.graph, this.getGraphComponent(), this.onWhat);
    menu.show(StaticEditorManager.graphComponent, pt.x, pt.y);
    e.consume();
  }

  private void tweakCell(final MouseEvent e) {
    if (GraphEditor.this.onWhat != null) {
      final mxCell cell = (mxCell) GraphEditor.this.onWhat;
      if (cell.isVertex()) {
        final NodeUtil instance =
            NodeUtil.getInstance(StaticEditorManager.graph, StaticEditorManager.graphComponent);
        instance.tweak(cell, (int) this.newCenterX, (int) this.newCenterY);

        StaticEditorManager.graphComponent.scrollCellToVisible(cell);
      } else if (cell.isEdge()) {
        final mxPoint point =
            EdgeUtil.getInstance(StaticEditorManager.graph, StaticEditorManager.graphComponent)
                .getControlPoint(cell, this.controlPointOrder);
        if (point == null) {
          return;
        }
        NodeUtil.getInstance(StaticEditorManager.graph, StaticEditorManager.graphComponent)
            .tweakControlPoint(cell, this.controlPointOrder, (int) this.oldCenterY,
                (int) this.newCenterY);
        point.setX(e.getX());
        point.setY(e.getY());
        if (point.getY() < 0) {
          point.setY(0);
        }
        if (point.getX() < 0) {
          point.setX(0);
        }
        final int sum = GraphUtil
            .getInstance(StaticEditorManager.graph, StaticEditorManager.graphComponent)
            .runLayerMinY()[this.layerOfControlPoint]
            + GraphUtil.getInstance(StaticEditorManager.graph, StaticEditorManager.graphComponent)
                .layerPH()[this.layerOfControlPoint] / 2;
        if (this.newCenterY < sum) {
          final mxPoint controlPoint =
              EdgeUtil.getInstance(StaticEditorManager.graph, StaticEditorManager.graphComponent)
                  .getControlPoint((mxCell) this.onWhat, this.controlPointOrder);
          controlPoint.setY(sum);
        }
      }
      StaticEditorManager.graphComponent.refresh();
    }
  }
}
