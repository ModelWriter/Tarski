package com.mxgraph.examples.swing.visualization;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.layout.mxEdgeLabelLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.layout.mxOrganicLayout;
import com.mxgraph.layout.mxParallelEdgeLayout;
import com.mxgraph.layout.mxPartitionLayout;
import com.mxgraph.layout.mxStackLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxCell;
import com.mxgraph.swing.util.mxMorphing;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.util.mxRectangle;
import com.mxgraph.util.mxResources;
import com.mxgraph.view.mxGraph;

public class VisualizationPopupMenu extends JPopupMenu {
  private static final long serialVersionUID = -1726551578352281567L;
  final JMenuItem miCreateMapping = new JMenuItem("Create Mapping");
  final JMenuItem miChangeAtomType = new JMenuItem("Change Atom Type");
  final JMenuItem miRemoveAtom = new JMenuItem("Remove Atom");
  final JMenuItem miMoveToUpper = new JMenuItem("Move To Upper");
  final JMenuItem miMoveToLower = new JMenuItem("Move To Lower");
  final JMenuItem miRemoveRelation = new JMenuItem("Remove Relation");
  final JMenuItem miCreateAtom = new JMenuItem("Create Atom");
  final JMenuItem hierLayoutVertical = new JMenuItem("Vertical Hierarchical Layout");
  final JMenuItem hierLayoutHorizontal = new JMenuItem("Horizontal Hierarchical Layout");
  private final VisualizationGraphComponent graphComponent;

  public VisualizationPopupMenu(final VisualizationGraphComponent graphComponent,
      final Object onWhat) {
    this.graphComponent = graphComponent;
    this.miCreateMapping.addActionListener(this.createMappingListener());
    this.miChangeAtomType.addActionListener(this.changeAtomTypeListener());
    this.miRemoveAtom.addActionListener(this.removeAtomListener());
    this.miMoveToUpper.addActionListener(this.moveToUpperListener());
    this.miMoveToLower.addActionListener(this.moveToLowerListener());
    this.miRemoveRelation.addActionListener(this.removeRelationListener());
    this.miCreateAtom.addActionListener(this.createAtomListener());
    this.hierLayoutHorizontal.addActionListener(this.graphLayout("horizontalHierarchical", false));
    this.hierLayoutVertical.addActionListener(this.graphLayout("verticalHierarchical", false));
    this.add(this.hierLayoutHorizontal);
    this.add(this.hierLayoutVertical);

    if (onWhat instanceof mxCell) {
      final mxCell cell = (mxCell) onWhat;
      if (cell.isVertex()) {
        this.add(this.miCreateMapping);
        this.add(this.miChangeAtomType);
        this.add(this.miRemoveAtom);
        this.add(this.miMoveToUpper);
        this.add(this.miMoveToLower);
      } else {
        this.add(this.miMoveToUpper);
        this.add(this.miMoveToLower);
        this.add(this.miRemoveRelation);
      }
    } else {
      this.add(this.miCreateAtom);
    }
  }

  private ActionListener changeAtomTypeListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        System.out.println("Change Atom Type");
      }
    };
  }

  private ActionListener createAtomListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        System.out.println("Create Atom");
      }
    };
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
            return VisualizationPopupMenu.this.graphComponent.getLayoutAreaSize();
          }
        };
      } else if (ident.equals("horizontalPartition")) {
        layout = new mxPartitionLayout(graph, true) {
          /**
           * Overrides the empty implementation to return the size of the graph control.
           */
          @Override
          public mxRectangle getContainerSize() {
            return VisualizationPopupMenu.this.graphComponent.getLayoutAreaSize();
          }
        };
      } else if (ident.equals("verticalStack")) {
        layout = new mxStackLayout(graph, false) {
          /**
           * Overrides the empty implementation to return the size of the graph control.
           */
          @Override
          public mxRectangle getContainerSize() {
            return VisualizationPopupMenu.this.graphComponent.getLayoutAreaSize();
          }
        };
      } else if (ident.equals("horizontalStack")) {
        layout = new mxStackLayout(graph, true) {
          /**
           * Overrides the empty implementation to return the size of the graph control.
           */
          @Override
          public mxRectangle getContainerSize() {
            return VisualizationPopupMenu.this.graphComponent.getLayoutAreaSize();
          }
        };
      } else if (ident.equals("circleLayout")) {
        layout = new mxCircleLayout(graph);
      }
    }

    return layout;
  }

  private ActionListener createMappingListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        System.out.println("Create Mapping");
      }
    };
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
          final mxGraph graph = VisualizationPopupMenu.this.graphComponent.getGraph();
          Object cell = graph.getSelectionCell();

          if (cell == null || graph.getModel().getChildCount(cell) == 0) {
            cell = graph.getDefaultParent();
          }

          graph.getModel().beginUpdate();
          try {
            layout.execute(cell);
          } finally {
            final mxMorphing morph =
                new mxMorphing(VisualizationPopupMenu.this.graphComponent, 0, 0, 0);

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
          JOptionPane.showMessageDialog(VisualizationPopupMenu.this.graphComponent,
              mxResources.get("noLayout"));
        }

      };
    }
  }

  private ActionListener moveToLowerListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        System.out.println("Move To Lower");
      }
    };
  }

  private ActionListener moveToUpperListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        System.out.println("Move To Upper");
      }
    };
  }

  private ActionListener removeAtomListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        System.out.println("Remove Atom");
      }
    };
  }

  private ActionListener removeRelationListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        System.out.println("Remove Relation");
      }
    };
  }
}
