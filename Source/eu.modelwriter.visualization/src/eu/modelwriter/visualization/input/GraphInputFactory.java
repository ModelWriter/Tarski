package eu.modelwriter.visualization.input;

public class GraphInputFactory {
  private GraphInputFactory() {}

  public static GraphInputJGraphx createGraphInputJGraphx(final Object input) {
    return new GraphInputJGraphx(input);
  }

  public static GraphInputAlloy createGraphInputAlloy(final Object input) {
    return new GraphInputAlloy(input);
  }
}
