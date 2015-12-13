package eu.modelwriter.visualization;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;

public class Visualization {

  private String xmlfile;
  private Universe universe;
  private XmlCreator xmlCreator;

  public Visualization(final Universe universe) {
    super();
    setUniverse(universe);
  }

  public JFrame getGraph() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e1) {

      e1.printStackTrace();
    }
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

  public void showModel() {
    xmlCreator.setMetamodel(false);
    final JFrame frame = this.getGraph();
    frame.setVisible(true);
    // frame.setAlwaysOnTop(true);
    frame.setSize(500, 500);
  }

  public void showMetamodel() {
    xmlCreator.setMetamodel(true);
    final JFrame frame = this.getGraph();
    frame.setVisible(true);
    // frame.setAlwaysOnTop(true);
    frame.setSize(500, 500);
  }

  public Universe getUniverse() {
    return universe;
  }

  public void setUniverse(Universe universe) {
    this.universe = universe;
    xmlfile = "temp\\" + UUID.randomUUID() + ".xml";
    this.xmlCreator = new XmlCreator(universe, xmlfile);
  }
}
