package eu.modelwriter.visualization;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public interface IVisualization {
  JPanel getGraph();
  JPanel refresh();
  JPopupMenu getPopupMenu();
  JComponent getGraphControl();
}
