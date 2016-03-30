package eu.modelwriter.visualization.editor.wizard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class ChangeTypeWizard extends JFrame {

  /**
   *
   */
  private static final long serialVersionUID = -6509600055568319396L;

  /**
   * Launch the application.
   */
  public static void main(final String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
          final ChangeTypeWizard frame = new ChangeTypeWizard(null);
          frame.setLocationRelativeTo(null);
          frame.setVisible(true);
        } catch (final Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   *
   * @param list2
   *
   * @param list2
   */
  public ChangeTypeWizard(final List<Object> list2) {
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setBounds(100, 100, 450, 300);
    this.getContentPane().setLayout(new BorderLayout(0, 0));

    final JPanel listPanel = new JPanel();
    this.getContentPane().add(listPanel, BorderLayout.CENTER);
    listPanel.setLayout(new BorderLayout(0, 0));

    final JList<Object> list = new JList<Object>();
    list.setVisibleRowCount(8);
    list.setFont(new Font("Times New Roman", Font.PLAIN, 12));
    list.setBorder(new LineBorder(new Color(0, 0, 0)));
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    list.setModel(new TypeListModel(list2));

    listPanel.add(list, BorderLayout.CENTER);

    final JPanel buttonPanel = new JPanel();
    this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    buttonPanel.setLayout(new BorderLayout(0, 0));

    final JButton nextButton = new JButton("Next");
    nextButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
    nextButton.setMnemonic('N');
    buttonPanel.add(nextButton, BorderLayout.EAST);
  }
}
