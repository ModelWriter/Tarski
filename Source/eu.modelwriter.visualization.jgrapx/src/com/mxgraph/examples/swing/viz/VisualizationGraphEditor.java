package com.mxgraph.examples.swing.viz;

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

import com.mxgraph.examples.swing.editor.EditorKeyboardHandler;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphOutline;
import com.mxgraph.swing.handler.mxRubberband;
import com.mxgraph.swing.util.mxMorphing;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.util.mxResources;
import com.mxgraph.view.mxGraph;

public class VisualizationGraphEditor extends JPanel {
  private static final long serialVersionUID = 8909390597370292504L;

  public static void main(final String[] args) {
    final JFrame frame = new JFrame("Visualization");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(750, 750);
    frame.setVisible(true);
    frame.getContentPane().add(new VisualizationGraphEditor());
  }

  private final VisualizationGraph graph;

  private final VisualizationGraphComponent graphComponent;
  private boolean modified;
  private mxRubberband rubberband;
  private EditorKeyboardHandler keyboardHandler;

  public VisualizationGraphEditor() {
    this.graph = new VisualizationGraph();
    this.graphComponent = new VisualizationGraphComponent(this.graph);
    this.setLayout(new BorderLayout());
    this.installHandlers();
    this.installListeners();
    this.init();
  }

  public void autoLayout() {
    final mxIGraphLayout layout =
        VisualizationGraphEditor.this.createLayout("verticalHierarchical", false);
    if (layout != null) {
      final mxGraph graph = VisualizationGraphEditor.this.getGraph();
      Object cell = graph.getSelectionCell();

      if (cell == null || graph.getModel().getChildCount(cell) == 0) {
        cell = graph.getDefaultParent();
      }

      graph.getModel().beginUpdate();
      try {
        layout.execute(cell);
      } finally {
        final mxMorphing morph =
            new mxMorphing(VisualizationGraphEditor.this.graphComponent, 20, 1.25, 1);

        morph.addListener(mxEvent.DONE, new mxIEventListener() {
          @Override
          public void invoke(final Object sender, final mxEventObject evt) {
            graph.getModel().endUpdate();
          }
        });
        morph.startAnimation();
      }
    }
  }

  /**
   * Creates a layout instance for the given identifier.
   */
  protected mxIGraphLayout createLayout(final String ident, final boolean animate) {
    mxIGraphLayout layout = null;

    if (ident != null) {
      final mxGraph graph = this.graphComponent.getGraph();
      if (ident.equals("verticalHierarchical")) {
        layout = new mxHierarchicalLayout(graph);
      } else if (ident.equals("horizontalHierarchical")) {
        layout = new mxHierarchicalLayout(graph, JLabel.WEST);
      }
    }

    return layout;
  }

  protected JLabel createStatusBar() {
    final JLabel statusBar = new JLabel(mxResources.get("ready"));
    statusBar.setBorder(BorderFactory.createEmptyBorder(2, 4, 2, 4));

    return statusBar;
  }

  public VisualizationGraph getGraph() {
    return this.graph;
  }

  public VisualizationGraphComponent getGraphComponent() {
    return this.graphComponent;
  }

  private void init() {
    final mxIGraphLayout layout =
        VisualizationGraphEditor.this.createLayout("verticalHierarchical", false);

    if (layout != null) {
      final mxGraph graph = VisualizationGraphEditor.this.getGraph();
      Object cell = graph.getSelectionCell();

      if (cell == null || graph.getModel().getChildCount(cell) == 0) {
        cell = graph.getDefaultParent();
      }

      graph.getModel().beginUpdate();
      try {
        layout.execute(cell);
      } finally {
        final mxMorphing morph =
            new mxMorphing(VisualizationGraphEditor.this.graphComponent, 20, 1.25, 1);

        morph.addListener(mxEvent.DONE, new mxIEventListener() {
          @Override
          public void invoke(final Object sender, final mxEventObject evt) {
            graph.getModel().endUpdate();
          }
        });
        morph.startAnimation();
      }
    }

  }

  protected void installHandlers() {
    this.rubberband = new mxRubberband(this.graphComponent);
    this.keyboardHandler = new EditorKeyboardHandler(this.graphComponent);
  }

  protected void installListeners() {
    // Installs mouse wheel listener for zooming
    final MouseWheelListener wheelTracker = new MouseWheelListener() {
      @Override
      public void mouseWheelMoved(final MouseWheelEvent e) {
        if (e.getSource() instanceof mxGraphOutline || e.isControlDown()) {
          VisualizationGraphEditor.this.mouseWheelMoved(e);
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
        this.mouseReleased(e);
      }

      @Override
      public void mouseReleased(final MouseEvent e) {
        if (e.isPopupTrigger()) {
          VisualizationGraphEditor.this.showGraphPopupMenu(e);
        }
      }
    });

    // Installs a mouse motion listener to display the mouse location
    this.graphComponent.getGraphControl().addMouseMotionListener(new MouseMotionListener() {
      @Override
      public void mouseDragged(final MouseEvent e) {}

      @Override
      public void mouseMoved(final MouseEvent e) {}
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
    final Object onWhat = this.graphComponent.getCellAt(e.getX(), e.getY());
    final VisualizationPopupMenu menu =
        new VisualizationPopupMenu(this.getGraphComponent(), onWhat);
    menu.show(this.graphComponent, pt.x, pt.y);

    e.consume();
  }
}
