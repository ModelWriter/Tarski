package eu.modelwriter.visualization.convertAlloyInstance;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;
import eu.modelwriter.visualization.convertAlloyInstance.StaticInstanceMaker;
import eu.modelwriter.visualization.convertAlloyInstance.model.Universe;

public class Visualization {
  Universe universe;

  public Visualization() {
    super();
  }

  public JFrame getGraph() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e1) {
      e1.printStackTrace();
    }

    final AlloyInstance instance = StaticInstanceMaker.createInstance(this.universe);
    final VizState myState = new VizState(instance);
    final JFrame frame = new JFrame("Visualization");
    final VizGraphPanel graph = new VizGraphPanel(myState, false);

    frame.add(graph);
    graph.alloyGetViewer().alloyRepaint();

    return frame;
  }

  public void show(final Universe universe) {
    this.universe = universe;
    final JFrame frame = this.getGraph();
    frame.setVisible(true);
    frame.setSize(500, 500);
  }
}
