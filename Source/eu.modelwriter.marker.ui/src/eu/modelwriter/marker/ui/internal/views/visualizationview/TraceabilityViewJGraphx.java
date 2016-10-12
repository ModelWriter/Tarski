package eu.modelwriter.marker.ui.internal.views.visualizationview;

import java.awt.Frame;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import org.eclipse.core.resources.IMarker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.mxgraph.model.mxICell;

import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.ui.internal.views.visualizationview.commands.PopupMenuJGraphx;
import eu.modelwriter.marker.ui.internal.views.visualizationview.commands.VisualizationMouseListenerFactoryJGraphx;
import eu.modelwriter.visualization.IVisualization;
import eu.modelwriter.visualization.VisualizationFactory;
import eu.modelwriter.visualization.input.GraphInputFactory;

public class TraceabilityViewJGraphx extends ViewPart {
  private static Composite parent;
  public static JComponent graphControl;
  public static JPopupMenu pop;
  public static JPanel graph;
  public static JMenu modelWriterMenu;
  public static JMenu analysisMenu;
  public static Object rightClickedAnnotation;
  public static Frame frame;
  public static AnalysisSourceProvider sourceProvider;
  public static String relation;
  public static Composite container;
  public TraceabilityViewJGraphx() {
    super();
  }

  @Override
  public void createPartControl(final Composite parent) {
    TraceabilityViewJGraphx.parent = parent;
    TraceabilityViewJGraphx.show();
  }

  @Override
  public void setFocus() {}

  public static void show() {
    final IVisualization visualization = VisualizationFactory.createVisualizationJGraphx(
        GraphInputFactory.createGraphInputJGraphx(AlloyUtilities.getDocumentRoot()));
    TraceabilityViewJGraphx.graph = visualization.getGraph();
    TraceabilityViewJGraphx.graphControl = visualization.getGraphControl();
    TraceabilityViewJGraphx.pop = visualization.getPopupMenu();

    Visualization.modelWriterMenu = new JMenu("Management");
    Visualization.analysisMenu = new JMenu("Analysis");
    new PopupMenuJGraphx(TraceabilityViewJGraphx.pop);

    TraceabilityViewJGraphx.graphControl.addMouseMotionListener(
        VisualizationMouseListenerFactoryJGraphx.instance.mouseMotionAdapter());
    TraceabilityViewJGraphx.graphControl
    .addMouseListener(VisualizationMouseListenerFactoryJGraphx.instance.mouseAdapter());

    TraceabilityViewJGraphx.container =
        new Composite(TraceabilityViewJGraphx.parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
    TraceabilityViewJGraphx.frame = SWT_AWT.new_Frame(TraceabilityViewJGraphx.container);
    TraceabilityViewJGraphx.frame.add(TraceabilityViewJGraphx.graph);
    TraceabilityViewJGraphx.frame.setVisible(true);
    TraceabilityViewJGraphx.frame.setAlwaysOnTop(true);
    TraceabilityViewJGraphx.frame.pack();
  }

  public static IMarker getMarker(final mxICell cell) {
    final String cellName = cell.getValue().toString();
    return null;
  }
}
