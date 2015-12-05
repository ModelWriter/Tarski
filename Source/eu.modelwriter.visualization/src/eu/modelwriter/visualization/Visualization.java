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

  private String xmlfile;
  private boolean metamodel;
  private Universe universe;

  public Visualization(final Universe universe) {
    super();
    setUniverse(universe);
  }

  public JFrame getGraph() {
    final File f = new File(xmlfile);
    try {
      if (!f.exists()) {
        throw new IOException("File " + xmlfile + " does not exist.");
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

  public boolean isMetamodel() {
    return metamodel;
  }

  public void setMetamodel(boolean metamodel) {
    this.metamodel = metamodel;
  }

  public Universe getUniverse() {
    return universe;
  }

  public void setUniverse(Universe universe) {
    this.universe = universe;
    xmlfile = "temp\\" + UUID.randomUUID() + ".xml";
    @SuppressWarnings("unused")
    final XmlCreator xmlCreator = new XmlCreator(universe, xmlfile, metamodel);
  }

}
