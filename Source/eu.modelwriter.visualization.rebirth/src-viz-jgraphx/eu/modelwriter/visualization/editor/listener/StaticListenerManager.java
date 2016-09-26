package eu.modelwriter.visualization.editor.listener;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.SwingUtilities;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxPoint;

import eu.modelwriter.visualization.editor.PopupMenu;
import eu.modelwriter.visualization.editor.StaticEditorManager;
import eu.modelwriter.visualization.editor.util.EdgeUtil;
import eu.modelwriter.visualization.editor.util.GraphUtil;
import eu.modelwriter.visualization.editor.util.NodeUtil;

public class StaticListenerManager {
  protected static double oldCenterX;
  protected static double oldCenterY;
  protected static double newCenterX;
  protected static double newCenterY;
  protected static int controlPointOrder;
  protected static int layerOfControlPoint;
  protected static double oldMouseX;
  protected static double oldMouseY;
  protected static Object onWhat;
  protected static boolean isDragStart = false;

  protected static ArrayList<mxCell> reverses = new ArrayList<mxCell>();
  protected static ArrayList<mxCell> sameEdges = new ArrayList<mxCell>();

  protected static Object[] objs = new Object[2];

  protected static void calculateClickedState(final MouseEvent e) {
    // Handles context menu on the Mac where the trigger is on mousepressed
    final Point p = StaticListenerManager.checkAndGetCollisionPt(e.getPoint());

    StaticListenerManager.onWhat = StaticEditorManager.graphComponent.getCellAt(p.x, p.y);
    if (StaticListenerManager.onWhat != null) {
      StaticListenerManager.oldMouseX = p.x;
      StaticListenerManager.oldMouseY = p.y;
      final mxCell cell = (mxCell) StaticListenerManager.onWhat;
      if (cell.isVertex()) {
        StaticListenerManager.oldCenterX =
            ((mxCell) StaticListenerManager.onWhat).getGeometry().getCenterX();
        StaticListenerManager.oldCenterY =
            ((mxCell) StaticListenerManager.onWhat).getGeometry().getCenterY();
      } else if (cell.isEdge()) {
        StaticListenerManager.controlPointOrder =
            EdgeUtil.getInstance().getControlPointOrder(cell, p.y);
        if (StaticListenerManager.controlPointOrder == -1) {
          return;
        }
        StaticListenerManager.layerOfControlPoint =
            EdgeUtil.getInstance().layer(cell, StaticListenerManager.controlPointOrder);
        final mxPoint point =
            EdgeUtil.getInstance().getControlPoint(cell, StaticListenerManager.controlPointOrder);
        if (point == null) {
          return;
        }
        StaticListenerManager.oldCenterX = point.getX();
        StaticListenerManager.oldCenterY = point.getY();
      }
    }
  }

  private static Point checkAndGetCollisionPt(final Point p) {
    final Rectangle mouseRect = StaticListenerManager.getMouseRect(p.x, p.y);
    final List<Map<Rectangle, Point>> controlPtsRectList =
        GraphUtil.getInstance().controlPtsRectList();
    for (final Map<Rectangle, Point> yAndRect : controlPtsRectList) {
      for (final Rectangle ctrlRect : yAndRect.keySet()) {
        if (mouseRect.intersects(ctrlRect)) {
          return yAndRect.get(ctrlRect);
        }
      }
    }
    return p;
  }

  protected static void clear() {
    StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, null,
        new Object[] {StaticListenerManager.onWhat});
    StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, null,
        StaticListenerManager.objs);
    StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_STROKECOLOR, null,
        StaticListenerManager.reverses.toArray());
    StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_STROKEWIDTH, null,
        StaticListenerManager.reverses.toArray());
    StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_NOLABEL, null,
        StaticListenerManager.reverses.toArray());
    StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_STROKEWIDTH, null,
        StaticListenerManager.sameEdges.toArray());
  }

  /**
   * The method which is called from MouseReleased event.
   *
   * @param e
   */
  public static void copingStone(final MouseEvent e) {
    if (StaticListenerManager.isDragStart) {
      StaticListenerManager.tweakCell(e);
      StaticListenerManager.isDragStart = false;
    }
    if (e.isPopupTrigger()) {
      StaticListenerManager.showGraphPopupMenu(e);
    }
  }

  private static Rectangle getMouseRect(final int x, final int y) {
    final int tol = 4;
    final Rectangle rect = new Rectangle(x - tol / 2, y - tol / 2, tol, tol);

    return rect;
  }

  /**
   * The method which is called while doing cope stone.
   *
   * @param e
   */
  protected static void showGraphPopupMenu(final MouseEvent e) {
    final Point pt = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(),
        StaticEditorManager.graphComponent);
    final PopupMenu menu = new PopupMenu(e);
    menu.show(StaticEditorManager.graphComponent, pt.x, pt.y);
    e.consume();
  }

  protected static void tweakCell(final MouseEvent e) {
    if (StaticListenerManager.onWhat != null) {
      final mxCell cell = (mxCell) StaticListenerManager.onWhat;
      if (cell.isVertex()) {
        NodeUtil.getInstance().tweak(cell, (int) StaticListenerManager.newCenterX,
            (int) StaticListenerManager.newCenterY);

        StaticEditorManager.graphComponent.scrollCellToVisible(cell);
      } else if (cell.isEdge()) {
        final mxPoint point =
            EdgeUtil.getInstance().getControlPoint(cell, StaticListenerManager.controlPointOrder);
        if (point == null) {
          return;
        }
        NodeUtil.getInstance().tweakControlPoint(cell, StaticListenerManager.controlPointOrder,
            point, (int) StaticListenerManager.newCenterX, (int) StaticListenerManager.newCenterY);
      }

      StaticEditorManager.graphComponent.refresh();
    }
  }

  protected static void wheelMoved(final MouseWheelEvent e) {
    if (e.getWheelRotation() < 0) {
      StaticEditorManager.graphComponent.zoomIn();
    } else {
      StaticEditorManager.graphComponent.zoomOut();
    }
  }
}
