package eu.modelwriter.visualization.editor.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;

import eu.modelwriter.visualization.editor.StaticEditorManager;
import eu.modelwriter.visualization.editor.util.EdgeUtil;

public class EditorMouseMotionListener implements MouseMotionListener {
  @Override
  public void mouseDragged(final MouseEvent e) {
    if (e.getSource() == StaticEditorManager.graphComponent.getGraphControl()) {
      StaticListenerManager.newCenterX =
          (int) (StaticListenerManager.oldCenterX + (e.getX() - StaticListenerManager.oldMouseX));
      StaticListenerManager.newCenterY =
          (int) (StaticListenerManager.oldCenterY + (e.getY() - StaticListenerManager.oldMouseY));
      if (SwingUtilities.isLeftMouseButton(e)) {
        StaticListenerManager.tweakCell(e);
        StaticListenerManager.isDragStart = true;
      }
    }
  }

  @Override
  public void mouseMoved(final MouseEvent e) {
    StaticListenerManager.clear();
    StaticListenerManager.onWhat = StaticEditorManager.graphComponent.getCellAt(e.getX(), e.getY());
    if (StaticListenerManager.onWhat != null) {
      final mxCell cell = (mxCell) StaticListenerManager.onWhat;
      if (cell.isVertex()) {
        StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, "yellow",
            new Object[] {StaticListenerManager.onWhat});
      } else if (cell.isEdge()) {
        StaticListenerManager.objs[0] = cell.getSource();
        StaticListenerManager.objs[1] = cell.getTarget();
        StaticListenerManager.reverses =
            EdgeUtil.getInstance().getReverseEdges(EdgeUtil.getInstance().getEdgeName(cell));
        StaticListenerManager.sameEdges =
            EdgeUtil.getInstance().getSameEdges(EdgeUtil.getInstance().getEdgeName(cell));

        StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, "yellow",
            StaticListenerManager.objs);
        StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_STROKECOLOR, "lightgray",
            StaticListenerManager.reverses.toArray());
        StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_STROKEWIDTH, "4",
            StaticListenerManager.reverses.toArray());
        StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_NOLABEL, "true",
            StaticListenerManager.reverses.toArray());
        StaticEditorManager.graph.setCellStyles(mxConstants.STYLE_STROKEWIDTH, "4",
            StaticListenerManager.sameEdges.toArray());
      } else {
        // do nothing
      }
    }
  }
}
