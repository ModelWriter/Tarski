package eu.modelwriter.visualization.editor.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

public class ListenerFactory {
  public static MouseAdapter mouseAdapter() {
    return new EditorMouseAdapter();
  }

  public static MouseMotionListener mouseMotionListener() {
    return new EditorMouseMotionListener();
  }

  public static MouseWheelListener mouseWheelListener() {
    return new EditorMouseWheelListener();
  }
}
