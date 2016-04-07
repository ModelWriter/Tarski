package eu.modelwriter.visualization.editor.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mxgraph.model.mxCell;

import eu.modelwriter.model.ModelElement;
import eu.modelwriter.visualization.editor.handler.StaticHandlerManager.BoundType;
import eu.modelwriter.visualization.editor.util.NodeUtil;

public class MoveToHandler implements ActionListener {

  private final BoundType type;

  public MoveToHandler(final BoundType bound) {
    this.type = bound;
  }

  @Override
  public void actionPerformed(final ActionEvent e) {
    final ModelElement element = (ModelElement) ((mxCell) StaticHandlerManager.onWhat).getValue();
    element.setAttribute(NodeUtil.BOUND, this.type.name());
  }
}
