package eu.modelwriter.marker.ui.internal.views.visualizationview;

import java.awt.Frame;

import javax.swing.JPanel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.visualization.IVisualization;
import eu.modelwriter.visualization.VisualizationFactory;
import eu.modelwriter.visualization.input.GraphInputFactory;

public class TraceabilityViewJGraphx extends ViewPart {
  private static Composite parent;

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
    final JPanel graph = visualization.getGraph();

    final Composite cmp =
        new Composite(TraceabilityViewJGraphx.parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
    final Frame frame = SWT_AWT.new_Frame(cmp);
    frame.add(graph);
    frame.setVisible(true);
    frame.setAlwaysOnTop(true);
    frame.pack();
  }
}
