package eu.modelwriter.visualization.jgraphx.editor.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditorMouseAdapter extends MouseAdapter {
  @Override
  public void mousePressed(final MouseEvent e) {
    StaticListenerManager.calculateClickedState(e);
    StaticListenerManager.copingStone(e);
  }

  @Override
  public void mouseReleased(final MouseEvent e) {
    StaticListenerManager.copingStone(e);
  }
}
