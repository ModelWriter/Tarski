package eu.modelwriter.visualization.editor.listener;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxPoint;

import eu.modelwriter.visualization.editor.PopupMenu;
import eu.modelwriter.visualization.editor.StaticEditorManager;
import eu.modelwriter.visualization.editor.util.EdgeUtil;
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
    // Handles context menu on the Mac where the trigger is on
    // mousepressed
    StaticListenerManager.onWhat = StaticEditorManager.graphComponent.getCellAt(e.getX(), e.getY());
    if (StaticListenerManager.onWhat != null) {
      StaticListenerManager.oldMouseX = e.getX();
      StaticListenerManager.oldMouseY = e.getY();
      final mxCell cell = (mxCell) StaticListenerManager.onWhat;
      if (cell.isVertex()) {
        StaticListenerManager.oldCenterX =
            ((mxCell) StaticListenerManager.onWhat).getGeometry().getCenterX();
        StaticListenerManager.oldCenterY =
            ((mxCell) StaticListenerManager.onWhat).getGeometry().getCenterY();
      } else if (cell.isEdge()) {
        StaticListenerManager.controlPointOrder =
            EdgeUtil.getInstance().getControlPointOrder(cell, e.getY());
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
        final NodeUtil instance = NodeUtil.getInstance();
        instance.tweak(cell, (int) StaticListenerManager.newCenterX,
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
