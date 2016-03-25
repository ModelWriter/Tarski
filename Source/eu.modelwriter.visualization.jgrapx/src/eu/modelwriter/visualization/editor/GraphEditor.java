package eu.modelwriter.visualization.editor;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import eu.modelwriter.visualization.editor.listener.ListenerFactory;

public class GraphEditor extends JPanel {
  private static final long serialVersionUID = 8909390597370292504L;

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
    // new mxRubberband(StaticEditorManager.graphComponent);
    new KeyboardHandler(StaticEditorManager.graphComponent);
  }

  protected void installListeners() {
    // Installs mouse wheel listener for zooming
    StaticEditorManager.graphComponent.getGraphControl()
        .addMouseWheelListener(ListenerFactory.mouseWheelListener());

    // Installs the popup menu in the graph component
    StaticEditorManager.graphComponent.getGraphControl()
        .addMouseListener(ListenerFactory.mouseAdapter());

    // Installs a mouse motion listener to display the mouse location
    StaticEditorManager.graphComponent.getGraphControl()
        .addMouseMotionListener(ListenerFactory.mouseMotionListener());
  }
}
