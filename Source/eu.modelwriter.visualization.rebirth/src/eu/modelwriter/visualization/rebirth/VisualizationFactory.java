package eu.modelwriter.visualization.rebirth;

import eu.modelwriter.visualization.rebirth.input.GraphInputAlloy;
import eu.modelwriter.visualization.rebirth.input.GraphInputJGraphx;

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
