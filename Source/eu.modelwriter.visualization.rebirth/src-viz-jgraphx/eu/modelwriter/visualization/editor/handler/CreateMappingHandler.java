package eu.modelwriter.visualization.editor.handler;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.UIManager;

import eu.modelwriter.visualization.editor.StaticEditorManager;
import eu.modelwriter.visualization.editor.wizard.CreateMappingWizard;

public class CreateMappingHandler implements ActionListener {
  @Override
  public void actionPerformed(final ActionEvent e) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
          final CreateMappingWizard frame =
              new CreateMappingWizard(StaticEditorManager.graph, StaticHandlerManager.onWhat,
                  new ArrayList<Object>(StaticEditorManager.builder.getN_aryRelationNames()));
          frame.setLocationRelativeTo(StaticEditorManager.graphComponent.getTopLevelAncestor());
          frame.setVisible(true);
        } catch (final Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
