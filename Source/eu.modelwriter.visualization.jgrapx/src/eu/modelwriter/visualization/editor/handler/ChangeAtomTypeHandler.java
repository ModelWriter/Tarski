package eu.modelwriter.visualization.editor.handler;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import eu.modelwriter.visualization.editor.StaticEditorManager;
import eu.modelwriter.visualization.editor.wizard.ChangeTypeWizard;

public class ChangeAtomTypeHandler implements ActionListener {
  @Override
  public void actionPerformed(final ActionEvent e) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
          final ChangeTypeWizard frame =
              new ChangeTypeWizard(StaticEditorManager.builder.getTypes());
          frame.setLocationRelativeTo(null);
          frame.setVisible(true);
        } catch (final Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
