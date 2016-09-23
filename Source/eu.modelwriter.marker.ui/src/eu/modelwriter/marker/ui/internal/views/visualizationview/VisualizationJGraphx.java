package eu.modelwriter.marker.ui.internal.views.visualizationview;

import java.awt.Frame;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import eu.modelwriter.model.ModelManager;

public class VisualizationJGraphx extends ViewPart {
  private static ModelManager modelManager = null;
  private static Composite parent;

  public VisualizationJGraphx() {
    super();
  }

  @Override
  public void createPartControl(final Composite parent) {
    if (VisualizationJGraphx.getModelManager() == null) {
      return;
    }
    VisualizationJGraphx.parent = parent;
    VisualizationJGraphx.show();
  }

  @Override
  public void setFocus() {}

  public static ModelManager getModelManager() {
    VisualizationJGraphx.modelManager = AlloyXML2Model.instance.convert();
    // VisualizationJGraphx.modelManager.addObserver(new VisualizationObserver());
    return VisualizationJGraphx.modelManager;
  }

  static void setModelManager(final ModelManager modelManager) {
    VisualizationJGraphx.modelManager = modelManager;
    // VisualizationJGraphx.modelManager.addObserver(new VisualizationObserver());
  }

  public static void show() {
    final Composite cmp =
        new Composite(VisualizationJGraphx.parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
    final Frame frame = SWT_AWT.new_Frame(cmp);
    final Frame frm =
        new eu.modelwriter.visualization.editor.Frame(VisualizationJGraphx.modelManager);
    frame.add(frm.getComponent(0));
    frame.setVisible(true);
    frame.setAlwaysOnTop(true);
    frame.pack();
  }
}
