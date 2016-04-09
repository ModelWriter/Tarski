package eu.modelwriter.visualization.editor.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eu.modelwriter.visualization.editor.StaticEditorManager;

public class SwitchEdgeColorsHandler implements ActionListener {
  @Override
  public void actionPerformed(final ActionEvent e) {
    StaticEditorManager.builder.specificEdgeStylesWithRandomColor();
    StaticEditorManager.graphComponent.refresh();
  }
}
