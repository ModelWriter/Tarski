package eu.modelwriter.visualization.build;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public interface IGraphBuilder {
  JPanel build();
  JPopupMenu getPopupMenu();

  JComponent getGraphControl();
}
