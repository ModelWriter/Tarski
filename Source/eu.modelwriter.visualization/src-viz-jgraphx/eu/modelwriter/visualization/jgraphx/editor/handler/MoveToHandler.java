package eu.modelwriter.visualization.jgraphx.editor.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mxgraph.model.mxCell;

import eu.modelwriter.model.ModelElement;
import eu.modelwriter.model.exception.NoSuchModelElementException;
import eu.modelwriter.visualization.jgraphx.editor.StaticEditorManager;
import eu.modelwriter.visualization.jgraphx.editor.handler.StaticHandlerManager.BoundType;

public class MoveToHandler implements ActionListener {
  private final BoundType type;

  public MoveToHandler(final BoundType bound) {
    type = bound;
  }

  @Override
  public void actionPerformed(final ActionEvent e) {
    final mxCell onWhat = (mxCell) StaticHandlerManager.onWhat;
    try {
      StaticEditorManager.builder.getManager().boundAboutToChange((ModelElement) onWhat.getValue(),
          type.name());
    } catch (final NoSuchModelElementException ex) {
      ex.printStackTrace();
      return;
    }
  }
}
