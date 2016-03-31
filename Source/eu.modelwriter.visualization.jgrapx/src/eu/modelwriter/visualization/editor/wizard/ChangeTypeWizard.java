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
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import com.mxgraph.model.mxCell;

import eu.modelwriter.visualization.editor.Graph;
import eu.modelwriter.visualization.editor.util.GraphUtil;

public class ChangeTypeWizard extends JFrame {

  private static final long serialVersionUID = -6509600055568319396L;

  /**
   * Create the frame.
   */
  public ChangeTypeWizard(final Graph graph, final Object onWhat, final List<Object> list2) {
    this.setTitle("Change Atom Type Wizard");
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

    final JButton finishButton = new JButton("Finish");
    finishButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent arg) {
        graph.getModel().beginUpdate();
        ((mxCell) onWhat).setAttribute("name", list.getSelectedValue().toString());
        graph.removeCells(graph.getEdges(onWhat));
        graph.getModel().endUpdate();
        GraphUtil.getInstance().layout();
        ChangeTypeWizard.this.dispose();
      }
    });
    finishButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
    finishButton.setMnemonic('F');
    buttonPanel.add(finishButton, BorderLayout.EAST);
  }
}
