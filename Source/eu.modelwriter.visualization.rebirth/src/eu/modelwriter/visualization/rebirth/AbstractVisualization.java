package eu.modelwriter.visualization.rebirth;

import javax.swing.JPanel;

import eu.modelwriter.visualization.rebirth.build.IGraphBuilder;
import eu.modelwriter.visualization.rebirth.input.IGraphInput;

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
}
