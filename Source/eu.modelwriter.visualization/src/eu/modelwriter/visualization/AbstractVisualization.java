package eu.modelwriter.visualization;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import eu.modelwriter.visualization.build.IGraphBuilder;
import eu.modelwriter.visualization.input.IGraphInput;

public abstract class AbstractVisualization implements IVisualization {
  private IGraphBuilder graphBuilder;
  private final IGraphInput graphInput;

  public AbstractVisualization(final IGraphInput graphInput) {
    this.graphInput = graphInput;
    init();
  }

  private void init() {
    graphBuilder = createGraphBuilder();
  }

  @Override
  public JPanel getGraph() {
    return getGraphBuilder().build();
  }

  protected abstract IGraphBuilder createGraphBuilder();

  public IGraphBuilder getGraphBuilder() {
    return graphBuilder;
  }

  public IGraphInput getGraphInput() {
    return graphInput;
  }

  @Override
  public JPopupMenu getPopupMenu() {
    return getGraphBuilder().getPopupMenu();
  }

  @Override
  public JComponent getGraphControl() {
    return getGraphBuilder().getGraphControl();
  }
}
