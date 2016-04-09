package eu.modelwriter.visualization.editor;

import java.awt.Color;

import com.mxgraph.swing.mxGraphComponent;

public class GraphComponent extends mxGraphComponent {
  private static final long serialVersionUID = -973809093898383471L;
  private static GraphComponent graphComponent;

  public static GraphComponent getLastInstance() {
    if (GraphComponent.graphComponent == null) {
      GraphComponent.graphComponent = new GraphComponent(new Graph());
    }
    return GraphComponent.graphComponent;
  }

  public GraphComponent(final Graph graph) {
    super(graph);
    this.getConnectionHandler().setEnabled(false);
    this.setToolTips(true);
    this.setDragEnabled(false);
    this.setAutoScroll(true);
    this.setPreviewAlpha(0);

    // Sets the background to white
    this.getViewport().setOpaque(true);
    this.getViewport().setBackground(Color.WHITE);
  }
}
