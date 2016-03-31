package eu.modelwriter.visualization.editor.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eu.modelwriter.visualization.editor.StaticEditorManager;
import eu.modelwriter.visualization.editor.util.GraphUtil;

public class RemoveCellHandler implements ActionListener {
  @Override
  public void actionPerformed(final ActionEvent e) {
    final Object o = StaticHandlerManager.onWhat;
    StaticEditorManager.graph.removeCells(new Object[] {o});
    GraphUtil.getInstance().layout();
    StaticEditorManager.graphComponent.refresh();
  }
}
