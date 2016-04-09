package eu.modelwriter.visualization.editor;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import eu.modelwriter.model.ModelManager;
import eu.modelwriter.visualization.editor.util.GraphUtil;
import eu.modelwriter.visualization.model.GraphBuilder;

public class Frame extends JFrame {
  private static Frame instance;
  private static final long serialVersionUID = 1L;

  public static Frame getInstance(final ModelManager manager) {
    if (Frame.instance == null) {
      Frame.instance = new Frame(manager);
    }

    try {
      UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    }
    return Frame.instance;
  }

  public Frame(final ModelManager manager) {
    this.setTitle("Visualization");
    this.getContentPane().setLayout(new BorderLayout(0, 0));

    final GraphEditor vge = new GraphEditor();

    StaticEditorManager.builder = new GraphBuilder(manager);
    StaticEditorManager.builder.build();

    GraphUtil.getInstance().layout();

    // Initial validation
    StaticEditorManager.graphComponent.validateGraph();

    // this.addComponentListener(new ComponentListener() {
    //
    // @Override
    // public void componentHidden(final ComponentEvent e) {}
    //
    // @Override
    // public void componentMoved(final ComponentEvent e) {}
    //
    // @Override
    // public void componentResized(final ComponentEvent e) {
    // if (e.getID() == ComponentEvent.COMPONENT_RESIZED) {
    // final Rectangle bounds = e.getComponent().getBounds();
    // final JViewport viewport = StaticEditorManager.graphComponent.getViewport();
    // }
    // }
    //
    // @Override
    // public void componentShown(final ComponentEvent e) {}
    // });

    this.getContentPane().add(vge, BorderLayout.CENTER);
  }

  public void showModel() {
    this.setSize((int) GraphUtil.width, (int) GraphUtil.height);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }
}
