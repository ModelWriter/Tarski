package eu.modelwriter.visualization;

import eu.modelwriter.visualization.input.GraphInputAlloy;
import eu.modelwriter.visualization.input.GraphInputJGraphx;

public class VisualizationFactory {
  private VisualizationFactory() {};

  public static IVisualization createVisualizationAlloy(final GraphInputAlloy graphInputAlloy) {
    return new VisualizationAlloy(graphInputAlloy);
  }

  public static IVisualization createVisualizationJGraphx(
      final GraphInputJGraphx graphInputJGraphx) {
    return new VisualizationJGraphx(graphInputJGraphx);
  }
}
