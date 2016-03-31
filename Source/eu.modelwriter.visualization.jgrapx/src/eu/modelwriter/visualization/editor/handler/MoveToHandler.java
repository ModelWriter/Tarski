package eu.modelwriter.visualization.editor.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eu.modelwriter.visualization.editor.handler.StaticHandlerManager.BoundType;

public class MoveToHandler implements ActionListener {

  private final BoundType type;

  public MoveToHandler(final BoundType bound) {
    this.type = bound;
  }

  @Override
  public void actionPerformed(final ActionEvent e) {

  }
}
