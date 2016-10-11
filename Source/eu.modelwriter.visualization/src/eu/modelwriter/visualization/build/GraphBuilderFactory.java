package eu.modelwriter.visualization.build;

import eu.modelwriter.visualization.input.IGraphInput;

public class GraphBuilderFactory {
  private GraphBuilderFactory() {}

  public static IGraphBuilder createGraphBuilderAlloy(final IGraphInput graphInput) {
    return new GraphBuilderAlloy(graphInput);
  }

  public static IGraphBuilder createGraphBuilderJGraphx(final IGraphInput graphInput) {
    return new GraphBuilderJGraphx(graphInput);
  }
}
