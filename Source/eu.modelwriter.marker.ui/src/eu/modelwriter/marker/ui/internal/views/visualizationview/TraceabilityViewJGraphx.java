package eu.modelwriter.marker.ui.internal.views.visualizationview;

import java.awt.Frame;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import eu.modelwriter.model.ModelManager;
import eu.modelwriter.model.example.ExampleGenerator;

public class TraceabilityViewJGraphx extends ViewPart {
  private static ModelManager modelManager = null;
  private static Composite parent;

  public TraceabilityViewJGraphx() {
    super();
  }

  @Override
  public void createPartControl(final Composite parent) {
    if (TraceabilityViewJGraphx.getModelManager() == null) {
      return;
    }
    TraceabilityViewJGraphx.parent = parent;
    TraceabilityViewJGraphx.show();
  }

  @Override
  public void setFocus() {}

  public static ModelManager getModelManager() {
    // TraceabilityViewJGraphx.modelManager.addObserver(new VisualizationObserver());
    return TraceabilityViewJGraphx.modelManager;
  }

  static void setModelManager(final ModelManager modelManager) {
    TraceabilityViewJGraphx.modelManager = modelManager;
    // TraceabilityViewJGraphx.modelManager.addObserver(new VisualizationObserver());
  }

  public static void show() {
    final Composite cmp =
        new Composite(TraceabilityViewJGraphx.parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
    final Frame frame = SWT_AWT.new_Frame(cmp);
    final Frame frm =
        new eu.modelwriter.visualization.editor.Frame(ExampleGenerator.createFileSystemExample());
    frame.add(frm.getComponent(0));
    frame.setVisible(true);
    frame.setAlwaysOnTop(true);
    frame.pack();
  }
}
