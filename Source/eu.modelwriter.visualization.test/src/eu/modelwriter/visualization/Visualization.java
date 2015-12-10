package eu.modelwriter.visualization;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.AlloyModel;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;

public class Visualization {

  public Visualization() {
    super();
  }

  public JFrame getGraph(final AlloyInstance instance) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e1) {
      e1.printStackTrace();
    }

    final VizState myState = new VizState(instance);
    final JFrame frame = new JFrame("Visualization");
    final VizGraphPanel graph = new VizGraphPanel(myState, false);

    frame.add(graph);
    graph.alloyGetViewer().alloyRepaint();

    return frame;
  }

  public void showMetamodel() {
    final AlloyModel model = SampleAlloyInstanceCreator.createAlloyModel();
    final AlloyInstance instance = SampleAlloyInstanceCreator.createAlloyInstance(model, true);

    final JFrame frame = this.getGraph(instance);
    frame.setVisible(true);
    frame.setSize(500, 500);
  }

  public void showModel() {
    final AlloyModel model = SampleAlloyInstanceCreator.createAlloyModel();
    final AlloyInstance instance = SampleAlloyInstanceCreator.createAlloyInstance(model, false);
    final JFrame frame = this.getGraph(instance);
    frame.setVisible(true);
    frame.setSize(500, 500);
  }
}
