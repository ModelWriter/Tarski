package eu.modelwriter.marker.ui.internal.views;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.Util;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;
import eu.modelwriter.configuration.internal.AlloyUtilities;

public class MetaModel extends ViewPart {

  public static final String ID = "eu.modelwriter.marker.ui.views.metamodelview";
  private static VizState myState = null;
  private static VizGraphPanel graph;
  private static Frame frame;
  private static File f = null;
  public static Object rightClickedAnnotation;

  final static String xmlFileName = Util.canon(AlloyUtilities.getLocation());

  public static Composite container;

  public static void showViz(final Composite container) {
    if (container == null) {
      return;
    }
    if (!AlloyUtilities.isExists()) {
      if (MetaModel.frame != null) {
        if (MetaModel.frame.getComponentCount() > 0) {
          MetaModel.frame.removeAll();
        }
        MetaModel.frame.add(new JPanel());
      } else if (MetaModel.frame == null) {
        MetaModel.frame = SWT_AWT.new_Frame(container);
        MetaModel.frame.add(new JPanel());
      }
      return;
    }
    MetaModel.f = new File(MetaModel.xmlFileName);
    try {
      if (!MetaModel.f.exists()) {
        throw new IOException("File " + MetaModel.xmlFileName + " does not exist.");
      }
      AlloyUtilities.setMetamodel(true);
      final AlloyInstance instance = StaticInstanceReader.parseInstance(MetaModel.f);
      AlloyUtilities.setMetamodel(false);

      MetaModel.myState = new VizState(instance);

      if (MetaModel.frame == null) {
        MetaModel.frame = SWT_AWT.new_Frame(container);
      }

      if (MetaModel.graph != null && MetaModel.frame.getComponent(0) != null) {
        MetaModel.frame.remove(MetaModel.graph);
      }

      MetaModel.graph = new VizGraphPanel(MetaModel.myState, false);
      MetaModel.frame.removeAll();
      MetaModel.frame.add(MetaModel.graph);
      MetaModel.frame.setVisible(true);
      MetaModel.frame.setAlwaysOnTop(true);
      MetaModel.graph.alloyGetViewer().alloyRepaint();

    } catch (final Err e1) {
      e1.printStackTrace();
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void createPartControl(final Composite parent) {
    MetaModel.container = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
    MetaModel.showViz(MetaModel.container);
  }

  @Override
  public void setFocus() {}
}
