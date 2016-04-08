package eu.modelwriter.visualization.editor.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mxgraph.model.mxCell;

import eu.modelwriter.model.ModelElement;
import eu.modelwriter.model.exception.NoSuchModelElementException;
import eu.modelwriter.visualization.editor.StaticEditorManager;
import eu.modelwriter.visualization.editor.util.GraphUtil;

public class RemoveCellHandler implements ActionListener {
  @Override
  public void actionPerformed(final ActionEvent e) {
    final mxCell onWhat = (mxCell) StaticHandlerManager.onWhat;
    try {
      StaticEditorManager.builder.getManager().removeModelElement((ModelElement) onWhat.getValue());
    } catch (final NoSuchModelElementException ex) {
      ex.printStackTrace();
      return;
    }
    StaticEditorManager.graph.removeCells(new Object[] {onWhat});
    GraphUtil.getInstance().layout();
  }
}
