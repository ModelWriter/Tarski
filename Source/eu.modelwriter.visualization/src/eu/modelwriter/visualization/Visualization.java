package eu.modelwriter.visualization;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;

public class Visualization {

  private static String xmlfile;

  public Visualization(Universe universe) {
    super();
    xmlfile = "temp\\" + UUID.randomUUID() + ".xml";
    @SuppressWarnings("unused")
    XmlCreator xmlCreator = new XmlCreator(universe, xmlfile);
  }

  public void visualize() {
    Frame frame = getGraph();
    frame.setVisible(true);
    frame.setAlwaysOnTop(true);
    frame.setSize(500, 500);
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  }

  public Frame getGraph() {
    File f = new File(xmlfile);
    try {
      if (!f.exists()) {
        throw new IOException("File " + xmlfile + " does not exist.");
      }
      final AlloyInstance instance = StaticInstanceReader.parseInstance(f);
      VizState myState = new VizState(instance);
      Frame frame = new Frame("Visualization");
      VizGraphPanel graph = new VizGraphPanel(myState, false);
      frame.removeAll();
      frame.add(graph);
      graph.alloyGetViewer().alloyRepaint();

      return frame;
    } catch (IOException | Err e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

}
