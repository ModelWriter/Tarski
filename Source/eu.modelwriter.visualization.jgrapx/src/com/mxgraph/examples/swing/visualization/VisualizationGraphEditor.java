package com.mxgraph.examples.swing.visualization;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import com.mxgraph.examples.swing.editor.EditorKeyboardHandler;
import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.layout.mxEdgeLabelLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.layout.mxOrganicLayout;
import com.mxgraph.layout.mxParallelEdgeLayout;
import com.mxgraph.layout.mxPartitionLayout;
import com.mxgraph.layout.mxStackLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphOutline;
import com.mxgraph.swing.handler.mxRubberband;
import com.mxgraph.swing.util.mxMorphing;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.util.mxRectangle;
import com.mxgraph.util.mxResources;
import com.mxgraph.util.mxUndoManager;
import com.mxgraph.util.mxUndoableEdit;
import com.mxgraph.util.mxUndoableEdit.mxUndoableChange;
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
  private final mxUndoManager undoManager;
  private boolean modified;
  private final mxGraphOutline graphOutline;
  private mxRubberband rubberband;
  private EditorKeyboardHandler keyboardHandler;
  private final JLabel statusBar;
  private final mxIEventListener undoHandler = new mxIEventListener() {
    @Override
    public void invoke(final Object sender, final mxEventObject evt) {
      VisualizationGraphEditor.this.undoManager
          .undoableEditHappened((mxUndoableEdit) evt.getProperty("edit"));
    }
  };
  private final mxIEventListener changeTracker = new mxIEventListener() {
    @Override
    public void invoke(final Object sender, final mxEventObject evt) {
      VisualizationGraphEditor.this.setModified(true);
    }
  };
  private final mxIEventListener validator = new mxIEventListener() {
    @Override
    public void invoke(final Object sender, final mxEventObject evt) {
      VisualizationGraphEditor.this.graphComponent.validateGraph();
    }
  };

  public VisualizationGraphEditor() {
    this.graph = new VisualizationGraph();
    this.graphComponent = new VisualizationGraphComponent(this.graph);
    this.setLayout(new BorderLayout());

    this.undoManager = this.createUndoManager();

    // Updates the modified flag if the graph model changes
    this.graph.getModel().addListener(mxEvent.CHANGE, this.changeTracker);

    // Validates graph for each model changes
    this.graph.getModel().addListener(mxEvent.CHANGE, this.validator);

    // Adds the command history to the model and view
    this.graph.getModel().addListener(mxEvent.UNDO, this.undoHandler);
    this.graph.getView().addListener(mxEvent.UNDO, this.undoHandler);

    // Keeps the selection in sync with the command history
    final mxIEventListener undoHandler = new mxIEventListener() {
      @Override
      public void invoke(final Object source, final mxEventObject evt) {
        final List<mxUndoableChange> changes =
            ((mxUndoableEdit) evt.getProperty("edit")).getChanges();
        VisualizationGraphEditor.this.graph.setSelectionCells(
            VisualizationGraphEditor.this.graph.getSelectionCellsForChanges(changes));
      }
    };

    this.undoManager.addListener(mxEvent.UNDO, undoHandler);
    this.undoManager.addListener(mxEvent.REDO, undoHandler);

    // Creates the graph outline component
    this.graphOutline = new mxGraphOutline(this.graphComponent);

    // Creates the status bar
    this.statusBar = this.createStatusBar();

    // Creates the library pane that contains the tabs with the palettes
    final JTabbedPane libraryPane = new JTabbedPane();

    // Creates the inner split pane that contains the library with the
    // palettes and the graph outline on the left side of the window
    final JSplitPane inner =
        new JSplitPane(JSplitPane.VERTICAL_SPLIT, libraryPane, this.graphOutline);
    inner.setDividerLocation(320);
    inner.setResizeWeight(1);
    inner.setDividerSize(6);
    inner.setBorder(null);

    // Creates the outer split pane that contains the inner split pane and
    // the graph component on the right side of the window
    final JSplitPane outer =
        new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, inner, this.graphComponent);
    outer.setOneTouchExpandable(true);
    outer.setDividerLocation(200);
    outer.setDividerSize(6);
    outer.setBorder(null);

    this.setLayout(new BorderLayout());
    this.add(outer, BorderLayout.CENTER);
    this.add(this.statusBar, BorderLayout.SOUTH);

    this.installHandlers();
    this.installListeners();
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
      } else if (ident.equals("verticalTree")) {
        layout = new mxCompactTreeLayout(graph, false);
      } else if (ident.equals("horizontalTree")) {
        layout = new mxCompactTreeLayout(graph, true);
      } else if (ident.equals("parallelEdges")) {
        layout = new mxParallelEdgeLayout(graph);
      } else if (ident.equals("placeEdgeLabels")) {
        layout = new mxEdgeLabelLayout(graph);
      } else if (ident.equals("organicLayout")) {
        layout = new mxOrganicLayout(graph);
      }
      if (ident.equals("verticalPartition")) {
        layout = new mxPartitionLayout(graph, false) {
          /**
           * Overrides the empty implementation to return the size of the graph control.
           */
          @Override
          public mxRectangle getContainerSize() {
            return VisualizationGraphEditor.this.graphComponent.getLayoutAreaSize();
          }
        };
      } else if (ident.equals("horizontalPartition")) {
        layout = new mxPartitionLayout(graph, true) {
          /**
           * Overrides the empty implementation to return the size of the graph control.
           */
          @Override
          public mxRectangle getContainerSize() {
            return VisualizationGraphEditor.this.graphComponent.getLayoutAreaSize();
          }
        };
      } else if (ident.equals("verticalStack")) {
        layout = new mxStackLayout(graph, false) {
          /**
           * Overrides the empty implementation to return the size of the graph control.
           */
          @Override
          public mxRectangle getContainerSize() {
            return VisualizationGraphEditor.this.graphComponent.getLayoutAreaSize();
          }
        };
      } else if (ident.equals("horizontalStack")) {
        layout = new mxStackLayout(graph, true) {
          /**
           * Overrides the empty implementation to return the size of the graph control.
           */
          @Override
          public mxRectangle getContainerSize() {
            return VisualizationGraphEditor.this.graphComponent.getLayoutAreaSize();
          }
        };
      } else if (ident.equals("circleLayout")) {
        layout = new mxCircleLayout(graph);
      }
    }

    return layout;
  }

  protected JLabel createStatusBar() {
    final JLabel statusBar = new JLabel(mxResources.get("ready"));
    statusBar.setBorder(BorderFactory.createEmptyBorder(2, 4, 2, 4));

    return statusBar;
  }

  private mxUndoManager createUndoManager() {
    return new mxUndoManager();
  }

  public VisualizationGraph getGraph() {
    return this.graph;
  }

  public VisualizationGraphComponent getGraphComponent() {
    return this.graphComponent;
  }

  /**
   * Creates an action that executes the specified layout.
   *
   * @param key Key to be used for getting the label from mxResources and also to create the layout
   *        instance for the commercial graph editor example.
   * @return an action that executes the specified layout
   */
  @SuppressWarnings("serial")
  public Action graphLayout(final String key, final boolean animate) {
    final mxIGraphLayout layout = this.createLayout(key, animate);

    if (layout != null) {
      return new AbstractAction(mxResources.get(key)) {
        @Override
        public void actionPerformed(final ActionEvent e) {
          final mxGraph graph = VisualizationGraphEditor.this.graphComponent.getGraph();
          Object cell = graph.getSelectionCell();

          if (cell == null || graph.getModel().getChildCount(cell) == 0) {
            cell = graph.getDefaultParent();
          }

          graph.getModel().beginUpdate();
          try {
            final long t0 = System.currentTimeMillis();
            layout.execute(cell);
            VisualizationGraphEditor.this
                .status("Layout: " + (System.currentTimeMillis() - t0) + " ms");
          } finally {
            final mxMorphing morph =
                new mxMorphing(VisualizationGraphEditor.this.graphComponent, 20, 1.2, 20);

            morph.addListener(mxEvent.DONE, new mxIEventListener() {

              @Override
              public void invoke(final Object sender, final mxEventObject evt) {
                graph.getModel().endUpdate();
              }

            });

            morph.startAnimation();
          }

        }

      };
    } else {
      return new AbstractAction(mxResources.get(key)) {

        @Override
        public void actionPerformed(final ActionEvent e) {
          JOptionPane.showMessageDialog(VisualizationGraphEditor.this.graphComponent,
              mxResources.get("noLayout"));
        }

      };
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
    this.graphOutline.addMouseWheelListener(wheelTracker);
    this.graphComponent.addMouseWheelListener(wheelTracker);

    // Installs the popup menu in the outline
    this.graphOutline.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(final MouseEvent e) {
        // Handles context menu on the Mac where the trigger is on mousepressed
        this.mouseReleased(e);
      }

      @Override
      public void mouseReleased(final MouseEvent e) {
        if (e.isPopupTrigger()) {
          VisualizationGraphEditor.this.showOutlinePopupMenu(e);
        }
      }

    });

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
      public void mouseDragged(final MouseEvent e) {
        VisualizationGraphEditor.this.mouseLocationChanged(e);
      }

      @Override
      public void mouseMoved(final MouseEvent e) {
        this.mouseDragged(e);
      }

    });
  }

  protected void mouseLocationChanged(final MouseEvent e) {
    this.status(e.getX() + ", " + e.getY());
  }

  protected void mouseWheelMoved(final MouseWheelEvent e) {
    if (e.getWheelRotation() < 0) {
      this.graphComponent.zoomIn();
    } else {
      this.graphComponent.zoomOut();
    }

    this.status(mxResources.get("scale") + ": "
        + (int) (100 * this.graphComponent.getGraph().getView().getScale()) + "%");
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

  protected void showOutlinePopupMenu(final MouseEvent e) {
    final Point pt =
        SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), this.graphComponent);
    final JCheckBoxMenuItem item = new JCheckBoxMenuItem(mxResources.get("magnifyPage"));
    item.setSelected(this.graphOutline.isFitPage());

    item.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        VisualizationGraphEditor.this.graphOutline
            .setFitPage(!VisualizationGraphEditor.this.graphOutline.isFitPage());
        VisualizationGraphEditor.this.graphOutline.repaint();
      }
    });

    final JCheckBoxMenuItem item2 = new JCheckBoxMenuItem(mxResources.get("showLabels"));
    item2.setSelected(this.graphOutline.isDrawLabels());

    item2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        VisualizationGraphEditor.this.graphOutline
            .setDrawLabels(!VisualizationGraphEditor.this.graphOutline.isDrawLabels());
        VisualizationGraphEditor.this.graphOutline.repaint();
      }
    });

    final JCheckBoxMenuItem item3 = new JCheckBoxMenuItem(mxResources.get("buffering"));
    item3.setSelected(this.graphOutline.isTripleBuffered());

    item3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        VisualizationGraphEditor.this.graphOutline
            .setTripleBuffered(!VisualizationGraphEditor.this.graphOutline.isTripleBuffered());
        VisualizationGraphEditor.this.graphOutline.repaint();
      }
    });

    final JPopupMenu menu = new JPopupMenu();
    menu.add(item);
    menu.add(item2);
    menu.add(item3);
    menu.show(this.graphComponent, pt.x, pt.y);

    e.consume();
  }

  public void status(final String msg) {
    this.statusBar.setText(msg);
  }
}
