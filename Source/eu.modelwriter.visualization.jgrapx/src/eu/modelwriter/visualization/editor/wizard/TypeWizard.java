package eu.modelwriter.visualization.editor.wizard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import eu.modelwriter.visualization.editor.Graph;
import eu.modelwriter.visualization.editor.util.GraphUtil;

public abstract class TypeWizard extends JFrame {
  private static final long serialVersionUID = -6509600055568319396L;
  final JButton finishButton;
  final Graph graph;
  final Object onWhat;
  final JList<Object> list;

  /**
   * Create the frame.
   */
  public TypeWizard(final Graph graph, final Object onWhat, final List<Object> list) {
    this.graph = graph;
    this.onWhat = onWhat;

    this.setTitle("Change Atom Type Wizard");
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setBounds(100, 100, 450, 300);
    this.getContentPane().setLayout(new BorderLayout(0, 0));

    final JScrollPane scrollPane = new JScrollPane();
    this.getContentPane().add(scrollPane, BorderLayout.CENTER);

    this.list = new JList<Object>();
    this.list.setFont(new Font("Times New Roman", Font.PLAIN, 12));
    this.list.setBorder(new LineBorder(new Color(0, 0, 0)));
    this.list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    this.list.setModel(new TypeListModel(list));
    scrollPane.setViewportView(this.list);

    final JPanel buttonPanel = new JPanel();
    this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    buttonPanel.setLayout(new BorderLayout(0, 0));

    this.finishButton = new JButton("Finish");
    this.finishButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
    this.finishButton.setMnemonic('F');
    buttonPanel.add(this.finishButton, BorderLayout.EAST);

    this.finishButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent arg) {
        TypeWizard.this.performFinish();
        GraphUtil.getInstance().layout();
        TypeWizard.this.dispose();
      }
    });
  }

  public void performFinish() {}
}
