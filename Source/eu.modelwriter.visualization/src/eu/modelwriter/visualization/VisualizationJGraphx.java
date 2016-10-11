package eu.modelwriter.visualization;

import javax.swing.JPanel;

import eu.modelwriter.visualization.build.GraphBuilderFactory;
import eu.modelwriter.visualization.build.IGraphBuilder;
import eu.modelwriter.visualization.input.IGraphInput;

public class VisualizationJGraphx extends AbstractVisualization {

  public VisualizationJGraphx(final IGraphInput graphInput) {
    super(graphInput);
  }

  @Override
  public JPanel refresh() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected IGraphBuilder createGraphBuilder() {
    return GraphBuilderFactory.createGraphBuilderJGraphx(getGraphInput());
  }
}
