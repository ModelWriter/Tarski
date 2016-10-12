package eu.modelwriter.marker.ui.internal.views.visualizationview;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.core.resources.IMarker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.services.ISourceProviderService;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.Util;
import edu.mit.csail.sdg.alloy4graph.GraphViewer;
import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.views.visualizationview.commands.PopupMenu;
import eu.modelwriter.marker.ui.internal.views.visualizationview.commands.VisualizationMouseListenerFactory;

public class Visualization extends ViewPart {

  public static final String ID = "eu.modelwriter.marker.ui.views.visualizationview";
  private static VizState myState = null;
  private static VizGraphPanel graph;
  public static JPanel graphPanel;
  public static GraphViewer viewer;
  public static Frame frame;
  public static JMenu modelWriterMenu;
  public static JMenu analysisMenu;
  private static File f = null;
  public static Object rightClickedAnnotation;
  final static String xmlFileName = Util.canon(AlloyUtilities.getLocation());
  public static Composite container;
  public static AnalysisSourceProvider sourceProvider;
  public static String relation;

  public static IMarker getMarker(final AlloyAtom highLightedAtom) {
    final String atomType = highLightedAtom.getType().getName();
    final String stringIndex = highLightedAtom.toString().substring(atomType.length());
    int index = 0;
    if (!stringIndex.isEmpty()) {
      index = Integer.parseInt(stringIndex);
    }

    final IMarker marker = AlloyUtilities.findMarker(atomType, index);

    return marker;
  }

  public static void showViz() {
    if (Visualization.container == null) {
      return;
    }
    if (!AlloyUtilities.isExists()) {
      if (Visualization.frame != null) {
        if (Visualization.frame.getComponentCount() > 0) {
          Visualization.frame.removeAll();
        }
        Visualization.frame.add(new JPanel());
      } else if (Visualization.frame == null) {
        Visualization.frame = SWT_AWT.new_Frame(Visualization.container);
        Visualization.frame.add(new JPanel());
      }
      return;
    }
    Visualization.f = new File(Visualization.xmlFileName);
    try {
      if (!Visualization.f.exists()) {
        throw new IOException("File " + Visualization.xmlFileName + " does not exist.");
      }
      final AlloyInstance instance = StaticInstanceReader.parseInstance(Visualization.f);

      AlloyUtilities.setAllImpactsAndChanges(instance);
      AlloyUtilities.setAllReasonedTuples(instance);
      AlloyUtilities.setAllReasonedAtoms(instance);

      Visualization.myState = new VizState(instance);

      // FE
      Visualization.myState.mergeArrows.put(null, false);

      if (Visualization.frame == null) {
        Visualization.frame = SWT_AWT.new_Frame(Visualization.container);
      }

      if (Visualization.graph != null && Visualization.frame.getComponent(0) != null) {
        Visualization.frame.remove(Visualization.graph);
      }

      try {
        /*
         * TODO BUG
         * 
         * A Fatal Error occurs while setting GTK look and feel on Ubuntu 16.04
         * (com.sun.java.swing.plaf.gtk.GTKLookAndFeel).
         * 
         */
        final String LaF = UIManager.getSystemLookAndFeelClassName();
        if ("com.sun.java.swing.plaf.gtk.GTKLookAndFeel".equals(LaF)) {
          UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } else {
          UIManager.setLookAndFeel(LaF);
        }
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
          | UnsupportedLookAndFeelException e1) {

        e1.printStackTrace();
      }
      Visualization.graph = new VizGraphPanel(Visualization.myState, false);
      Visualization.graphPanel = Visualization.graph.getGraphPanel();
      Visualization.viewer = Visualization.graph.alloyGetViewer();
      Visualization.frame.removeAll();
      Visualization.frame.add(Visualization.graph);
      Visualization.frame.setVisible(true);
      Visualization.frame.setAlwaysOnTop(true);
      Visualization.graph.alloyGetViewer().alloyRepaint();

      final ISourceProviderService service =
          Activator.getDefault().getWorkbench().getService(ISourceProviderService.class);
      Visualization.sourceProvider =
          (AnalysisSourceProvider) service.getSourceProvider(AnalysisSourceProvider.ANALYSIS_STATE);
    } catch (final Err e1) {
      e1.printStackTrace();
    } catch (final IOException e) {
      e.printStackTrace();
    }

    new PopupMenu(Visualization.graph.alloyGetViewer().pop);

    Visualization.graph.alloyGetViewer()
    .addMouseMotionListener(VisualizationMouseListenerFactory.instance.mouseMotionAdapter());
    Visualization.graphPanel
    .addMouseMotionListener(VisualizationMouseListenerFactory.instance.mouseMotionAdapter());
    Visualization.graph.alloyGetViewer()
    .addMouseListener(VisualizationMouseListenerFactory.instance.mouseAdapter());
    Visualization.graphPanel
    .addMouseListener(VisualizationMouseListenerFactory.instance.mouseAdapter());
  }

  @Override
  public void createPartControl(final Composite parent) {
    Visualization.container = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
    Visualization.frame = null;
    Visualization.f = null;
    Visualization.graph = null;
    Visualization.myState = null;
    Visualization.showViz();
  }

  @Override
  public void setFocus() {}
}
