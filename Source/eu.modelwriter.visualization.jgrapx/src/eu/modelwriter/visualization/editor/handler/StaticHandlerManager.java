package eu.modelwriter.visualization.editor.handler;

import java.awt.event.MouseEvent;

public class StaticHandlerManager {
  public static enum BoundType {
    LOWER_BOUND, UPPER_BOUND, EXACT_BOUND
  }

  public static MouseEvent e;

  public static Object onWhat;
}
