/*******************************************************************************
 * Copyright (c) 2016 UNIT Information Technologies R&D Ltd All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ferhat Erata - initial API and implementation H. Emre Kirmizi - initial API and
 * implementation Serhat Celik - initial API and implementation U. Anil Ozturk - initial API and
 * implementation
 *******************************************************************************/
package eu.modelwriter.visualization.wizards.createatom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import eu.modelwriter.visualization.Notifier;
import eu.modelwriter.visualization.Utility;
import eu.modelwriter.visualization.Visualization;

@SuppressWarnings("serial")
public class CreateAtom extends JFrame {


  private final JPanel contentPanel = new JPanel();
  private JTextField textField;
  private JTree tree;
  private AlloyAtom beforeAtom;

  // /**
  // * Launch the application.
  // */
  // public static void main(String[] args) {
  // EventQueue.invokeLater(new Runnable() {
  // public void run() {
  // try {
  // CreateAtom frame = new CreateAtom();
  // frame.setVisible(true);
  // } catch (Exception e) {
  // e.printStackTrace();
  // }
  // }
  // });
  // }

  /**
   * Create the frame.
   */
  public CreateAtom(AlloyAtom beforeAtom) {
    this.beforeAtom = beforeAtom;
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setTitle("Create Atom");
    setBounds(100, 100, 450, 300);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(new BorderLayout(0, 0));
    {
      MutableTreeNode univ = new DefaultMutableTreeNode("Univ");
      tree = new JTree(univ);
      tree.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
      contentPanel.add(tree, BorderLayout.CENTER);
      tree.setCellRenderer(new CellRenderer());

      List<MutableTreeNode> topElement = Utility.getTypeHierarchyForTree();

      for (MutableTreeNode mutableTreeNode : topElement) {
        univ.insert(mutableTreeNode, univ.getChildCount());
      }
      TreeNode root = (TreeNode) tree.getModel().getRoot();
      expandAll(tree, new TreePath(root));
    }
    if (this.beforeAtom == null) {
      JPanel panel = new JPanel();
      contentPanel.add(panel, BorderLayout.NORTH);
      panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
      {
        JLabel lblNewLabel = new JLabel("Atom Name : ");
        panel.add(lblNewLabel);
      }
      {
        textField = new JTextField();
        panel.add(textField);
        textField.setColumns(30);
      }
    }
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            if (performFinish()) {
              Visualization.getInstance(null).revalidate();
              disposeThis();
            }
          }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
      }
      {
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            disposeThis();
          }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
      }
    }
  }

  private void expandAll(JTree tree, TreePath parent) {
    TreeNode node = (TreeNode) parent.getLastPathComponent();
    if (node.getChildCount() >= 0) {
      for (@SuppressWarnings("rawtypes")
      Enumeration e = node.children(); e.hasMoreElements();) {
        TreeNode n = (TreeNode) e.nextElement();
        TreePath path = parent.pathByAddingChild(n);
        expandAll(tree, path);
      }
    }
    tree.expandPath(parent);
    // tree.collapsePath(parent);
  }

  private void disposeThis() {
    this.dispose();
  }

  private boolean performFinish() {
    TreePath path = tree.getSelectionModel().getSelectionPath();
    if (path == null || path.getLastPathComponent() == null)
      return false;
    String type = path.getLastPathComponent().toString();

    if (this.beforeAtom == null) {
      String name = textField.getText();
      Utility.addAtomToSigType(type, name);
      List<Notifier> notifierList = Visualization.getInstance().getNotifierList();
      List<String> tupleList = new ArrayList<>();
      tupleList.add(name);
      for (Notifier notifier : notifierList) {
        notifier.addTupleNotify(type, tupleList,
            Visualization.getInstance().isLower() ? "lower" : "upper");
      }
    } else {
      Utility.changeAtomType(beforeAtom, type);
    }

    return true;
  }

  class CellRenderer implements TreeCellRenderer {
    private JLabel label;

    public CellRenderer() {
      label = new JLabel();
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
        boolean expanded, boolean leaf, int row, boolean hasFocus) {

      Object object = ((DefaultMutableTreeNode) value).getUserObject();
      if (object instanceof String) {
        URL imageUrl = getClass().getClassLoader().getResource("sig.png");
        label.setText((String) object);
        label.setIcon(new ImageIcon(imageUrl));
      }

      if (selected && hasFocus) {
        label.setOpaque(true);
        label.setBackground(new Color(199, 229, 255));
        label.setBorder(BorderFactory.createLineBorder(new Color(144, 204, 255)));
      } else {
        label.setOpaque(false);
        label.setBorder(BorderFactory.createLineBorder(Color.WHITE));
      }

      return label;
    }
  }

}
