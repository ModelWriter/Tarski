package eu.modelwriter.visualization;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.swing.JFrame;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;

public class Visualization {

  private static String xmlfile;

  public Visualization(final Universe universe) {
    super();
    Visualization.xmlfile = "temp\\" + UUID.randomUUID() + ".xml";
    @SuppressWarnings("unused")
    final XmlCreator xmlCreator = new XmlCreator(universe, Visualization.xmlfile);
  }

  public JFrame getGraph() {
    final File f = new File(Visualization.xmlfile);
    try {
      if (!f.exists()) {
        throw new IOException("File " + Visualization.xmlfile + " does not exist.");
      }
      final AlloyInstance instance = StaticInstanceReader.parseInstance(f);
      final VizState myState = new VizState(instance);
      final JFrame frame = new JFrame("Visualization");
      final VizGraphPanel graph = new VizGraphPanel(myState, false);
      // frame.removeAll();
      frame.add(graph);
      graph.alloyGetViewer().alloyRepaint();

      return frame;
    } catch (IOException | Err e) {
      e.printStackTrace();
    }
    return null;
  }

  public void visualize() {
    final JFrame frame = this.getGraph();
    frame.setVisible(true);
    frame.setAlwaysOnTop(true);
    frame.setSize(500, 500);
    // frame.addWindowListener(new WindowAdapter() {
    // @Override
    // public void windowClosing(final WindowEvent we) {
    // System.exit(0);
    // }
    // });
  }
}
