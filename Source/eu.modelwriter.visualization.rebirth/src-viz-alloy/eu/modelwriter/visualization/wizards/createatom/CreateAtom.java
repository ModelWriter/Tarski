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


  class CellRenderer implements TreeCellRenderer {
    private final JLabel label;

    public CellRenderer() {
      this.label = new JLabel();
    }

    @Override
    public Component getTreeCellRendererComponent(final JTree tree, final Object value,
        final boolean selected, final boolean expanded, final boolean leaf, final int row,
        final boolean hasFocus) {

      final Object object = ((DefaultMutableTreeNode) value).getUserObject();
      if (object instanceof String) {
        final URL imageUrl = this.getClass().getClassLoader().getResource("sig.png");
        this.label.setText((String) object);
        this.label.setIcon(new ImageIcon(imageUrl));
      }

      if (selected && hasFocus) {
        this.label.setOpaque(true);
        this.label.setBackground(new Color(199, 229, 255));
        this.label.setBorder(BorderFactory.createLineBorder(new Color(144, 204, 255)));
      } else {
        this.label.setOpaque(false);
        this.label.setBorder(BorderFactory.createLineBorder(Color.WHITE));
      }

      return this.label;
    }
  }

  private final JPanel contentPanel = new JPanel();
  private JTextField textField;
  private JTree tree;

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

  private final AlloyAtom beforeAtom;

  /**
   * Create the frame.
   */
  public CreateAtom(final AlloyAtom beforeAtom) {
    this.beforeAtom = beforeAtom;
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setTitle("Create Atom");
    this.setBounds(100, 100, 450, 300);
    this.getContentPane().setLayout(new BorderLayout());
    this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    this.getContentPane().add(this.contentPanel, BorderLayout.CENTER);
    this.contentPanel.setLayout(new BorderLayout(0, 0));
    {
      final MutableTreeNode univ = new DefaultMutableTreeNode("Univ");
      this.tree = new JTree(univ);
      this.tree.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
      this.contentPanel.add(this.tree, BorderLayout.CENTER);
      this.tree.setCellRenderer(new CellRenderer());

      final List<MutableTreeNode> topElement = Utility.getTypeHierarchyForTree();

      for (final MutableTreeNode mutableTreeNode : topElement) {
        univ.insert(mutableTreeNode, univ.getChildCount());
      }
      final TreeNode root = (TreeNode) this.tree.getModel().getRoot();
      this.expandAll(this.tree, new TreePath(root));
    }
    if (this.beforeAtom == null) {
      final JPanel panel = new JPanel();
      this.contentPanel.add(panel, BorderLayout.NORTH);
      panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
      {
        final JLabel lblNewLabel = new JLabel("Atom Name : ");
        panel.add(lblNewLabel);
      }
      {
        this.textField = new JTextField();
        panel.add(this.textField);
        this.textField.setColumns(30);
      }
    }
    {
      final JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      this.getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        final JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(final ActionEvent arg0) {
            if (CreateAtom.this.performFinish()) {
              Visualization.getInstance(null).revalidate();
              CreateAtom.this.disposeThis();
            }
          }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        this.getRootPane().setDefaultButton(okButton);
      }
      {
        final JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(final ActionEvent e) {
            CreateAtom.this.disposeThis();
          }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
      }
    }
  }

  private void disposeThis() {
    this.dispose();
  }

  private void expandAll(final JTree tree, final TreePath parent) {
    final TreeNode node = (TreeNode) parent.getLastPathComponent();
    if (node.getChildCount() >= 0) {
      for (@SuppressWarnings("rawtypes")
      final Enumeration e = node.children(); e.hasMoreElements();) {
        final TreeNode n = (TreeNode) e.nextElement();
        final TreePath path = parent.pathByAddingChild(n);
        this.expandAll(tree, path);
      }
    }
    tree.expandPath(parent);
    // tree.collapsePath(parent);
  }

  private boolean performFinish() {
    final TreePath path = this.tree.getSelectionModel().getSelectionPath();
    if (path == null || path.getLastPathComponent() == null) {
      return false;
    }

    final String relationName = path.getLastPathComponent().toString();
    final String inRelationName = Utility.getType(relationName);

    if (this.beforeAtom == null) {
      final String name = this.textField.getText();
      if (inRelationName != null) {
        Utility.addAtomToSigType(inRelationName, name);
      }
      Utility.addAtomToSigType(relationName, name);
      final List<Notifier> notifierList = Visualization.getInstance().getNotifierList();
      final List<String> tupleList = new ArrayList<>();
      tupleList.add(name);
      for (final Notifier notifier : notifierList) {
        if (inRelationName != null) {
          notifier.addTupleNotify(relationName, inRelationName, tupleList,
              Visualization.getInstance().isLower() ? "lower" : "upper");
        } else {
          notifier.addTupleNotify(relationName, tupleList,
              Visualization.getInstance().isLower() ? "lower" : "upper");
        }
      }
    } else {
      Utility.changeAtomType(this.beforeAtom, !relationName.equals(inRelationName) ? inRelationName : relationName);
    }

    return true;
  }

}
