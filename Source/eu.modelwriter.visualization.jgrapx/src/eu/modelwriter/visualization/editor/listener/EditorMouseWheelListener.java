package eu.modelwriter.visualization.editor.listener;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class EditorMouseWheelListener implements MouseWheelListener {
  @Override
  public void mouseWheelMoved(final MouseWheelEvent e) {
    if (e.isControlDown()) {
      StaticListenerManager.wheelMoved(e);
    }
  }
}
