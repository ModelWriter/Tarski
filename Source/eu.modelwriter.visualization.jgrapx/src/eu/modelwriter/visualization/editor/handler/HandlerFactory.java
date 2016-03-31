package eu.modelwriter.visualization.editor.handler;

public class HandlerFactory {
  public static ChangeAtomTypeHandler changeAtomTypeHandler() {
    return new ChangeAtomTypeHandler();
  }

  public static CreateAtomHandler createAtomHandler() {
    return new CreateAtomHandler();
  }

  public static CreateMappingHandler createMappingHandler() {
    return new CreateMappingHandler();
  }

  public static Move2LowerHandler move2LowerHandler() {
    return new Move2LowerHandler();
  }

  public static Move2UpperHandler move2UpperHandler() {
    return new Move2UpperHandler();
  }

  public static RemoveCellHandler removeCellHandler() {
    return new RemoveCellHandler();
  }

  public static SwitchEdgeColorsHandler switchEdgeColorsHandler() {
    return new SwitchEdgeColorsHandler();
  }
}
