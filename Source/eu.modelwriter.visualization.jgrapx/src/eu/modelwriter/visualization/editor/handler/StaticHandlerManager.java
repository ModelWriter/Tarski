package eu.modelwriter.visualization.editor.handler;

import java.awt.event.MouseEvent;

public class StaticHandlerManager {
  public static enum BoundType {
    lower, upper, exact
  }

  public static MouseEvent e;

  public static Object onWhat;
}
