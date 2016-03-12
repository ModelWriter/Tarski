package eu.modelwriter.visualization.editor;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphOutline;
import com.mxgraph.swing.handler.mxRubberband;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxResources;

import eu.modelwriter.visualization.editor.util.NodeUtil;

public class GraphEditor extends JPanel {
  private static final long serialVersionUID = 8909390597370292504L;

  public static void main(final String[] args) {
    final JFrame frame = new JFrame("Visualization");
    frame.setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(750, 750);
    frame.getContentPane().add(new GraphEditor(), BorderLayout.CENTER);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  private final Graph graph;
  private final GraphComponent graphComponent;
  private boolean modified;
  private mxRubberband rubberband;
  private KeyboardHandler keyboardHandler;
  private double oldCenterX;
  private double oldCenterY;
  private double oldMouseX;
  private double oldMouseY;
  private Object onWhat;

  public GraphEditor() {
    this.graph = new Graph();
    this.graphComponent = new GraphComponent(this.graph);
    this.setLayout(new BorderLayout());
    this.installHandlers();
    this.installListeners();
  }

  protected JLabel createStatusBar() {
    final JLabel statusBar = new JLabel(mxResources.get("ready"));
    statusBar.setBorder(BorderFactory.createEmptyBorder(2, 4, 2, 4));

    return statusBar;
  }

  public void exit() {}

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
    final MouseWheelListener wheelTracker = new MouseWheelListener() {
      @Override
      public void mouseWheelMoved(final MouseWheelEvent e) {
        if (e.getSource() instanceof mxGraphOutline || e.isControlDown()) {
          GraphEditor.this.mouseWheelMoved(e);
        }
      }
    };

    // Handles mouse wheel events in the outline and graph component
    this.graphComponent.addMouseWheelListener(wheelTracker);

    // Installs the popup menu in the graph component
    this.graphComponent.getGraphControl().addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(final MouseEvent e) {
        // Handles context menu on the Mac where the trigger is on mousepressed
        GraphEditor.this.onWhat = GraphEditor.this.graphComponent.getCellAt(e.getX(), e.getY());
        if (GraphEditor.this.onWhat != null) {
          GraphEditor.this.oldMouseX = e.getX();
          GraphEditor.this.oldMouseY = e.getY();
          GraphEditor.this.oldCenterX =
              ((mxCell) GraphEditor.this.onWhat).getGeometry().getCenterX();
          GraphEditor.this.oldCenterY =
              ((mxCell) GraphEditor.this.onWhat).getGeometry().getCenterY();
        }
      }

      @Override
      public void mouseReleased(final MouseEvent e) {
        GraphEditor.this.tweakCell(e);
        if (e.isPopupTrigger()) {
          GraphEditor.this.showGraphPopupMenu(e);
        }
      }
    });

    // Installs a mouse motion listener to display the mouse location
    this.graphComponent.getGraphControl().addMouseMotionListener(new MouseMotionListener() {
      @Override
      public void mouseDragged(final MouseEvent e) {
        GraphEditor.this.tweakCell(e);
      }

      @Override
      public void mouseMoved(final MouseEvent e) {
        GraphEditor.this.graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, null,
            new Object[] {GraphEditor.this.onWhat});
        GraphEditor.this.onWhat = GraphEditor.this.graphComponent.getCellAt(e.getX(), e.getY());
        if (GraphEditor.this.onWhat != null) {
          GraphEditor.this.graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, "yellow",
              new Object[] {GraphEditor.this.onWhat});
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

  public void setModified(final boolean modified) {
    final boolean oldValue = this.modified;
    this.modified = modified;

    this.firePropertyChange("modified", oldValue, modified);
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
        final int newX =
            (int) (GraphEditor.this.oldCenterX + (e.getX() - GraphEditor.this.oldMouseX));
        final int newY =
            (int) (GraphEditor.this.oldCenterY + (e.getY() - GraphEditor.this.oldMouseY));
        NodeUtil.getInstance(GraphEditor.this.graph, GraphEditor.this.graphComponent).tweak(cell,
            (int) this.oldCenterX, (int) this.oldCenterY, newX, newY);
      }
    }
  }
}
