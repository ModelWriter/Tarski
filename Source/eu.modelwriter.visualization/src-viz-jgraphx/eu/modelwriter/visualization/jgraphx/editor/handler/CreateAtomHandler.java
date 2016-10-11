package eu.modelwriter.visualization.jgraphx.editor.handler;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.UIManager;

import eu.modelwriter.visualization.jgraphx.editor.StaticEditorManager;
import eu.modelwriter.visualization.jgraphx.editor.wizard.CreateAtomWizard;

public class CreateAtomHandler implements ActionListener {
  @Override
  public void actionPerformed(final ActionEvent e) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
          final CreateAtomWizard frame =
              new CreateAtomWizard(StaticEditorManager.graph, StaticHandlerManager.onWhat,
                  new ArrayList<Object>(StaticEditorManager.builder.getUnaryRelationNames()));
          frame.setLocationRelativeTo(StaticEditorManager.graphComponent.getTopLevelAncestor());
          frame.setVisible(true);
        } catch (final Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
