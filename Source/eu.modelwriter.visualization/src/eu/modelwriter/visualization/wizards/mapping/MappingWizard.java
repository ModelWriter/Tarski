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
package eu.modelwriter.visualization.wizards.mapping;

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
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import eu.modelwriter.visualization.Notifier;
import eu.modelwriter.visualization.Utility;
import eu.modelwriter.visualization.Visualization;

@SuppressWarnings("serial")
public class MappingWizard extends JFrame {

  @SuppressWarnings("rawtypes")
  class ListCellRender implements ListCellRenderer {
    private final JLabel label;

    public ListCellRender() {
      this.label = new JLabel();
    }


    @Override
    public Component getListCellRendererComponent(final JList arg0, final Object arg1,
        final int arg2, final boolean arg3, final boolean arg4) {

      final Object object = arg1;
      if (object instanceof String) {
        final URL imageUrl = this.getClass().getClassLoader().getResource("relation.png");
        this.label.setText((String) object);
        this.label.setIcon(new ImageIcon(imageUrl));
      }

      if (arg3 && arg4) {
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
  class TreeCellRender implements TreeCellRenderer {
    private final JCheckBox label;

    public TreeCellRender() {
      this.label = new JCheckBox();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Component getTreeCellRendererComponent(final JTree tree, final Object value,
        final boolean selected, final boolean expanded, final boolean leaf, final int row,
        final boolean hasFocus) {

      final Object object = ((DefaultMutableTreeNode) value).getUserObject();
      ArrayList<String> listObject = null;
      if (object instanceof ArrayList) {
        listObject = (ArrayList<String>) object;
        this.label.setIcon(null);
        this.label.setText(listObject.get(4));
        if (listObject.get(5).equals("true")) {
          this.label.setSelected(true);
        } else {
          this.label.setSelected(false);
        }

      } else {
        final URL imageUrl = this.getClass().getClassLoader().getResource("atom.png");
        this.label.setIcon(new ImageIcon(imageUrl));
        this.label.setText((String) object);
        this.label.setSelected(false);
      }

      if (selected && hasFocus) {
        this.label.setOpaque(true);
        this.label.setBackground(new Color(199, 229, 255));
        this.label.setBorder(BorderFactory.createLineBorder(new Color(144, 204, 255)));

        if (listObject != null) {
          if (listObject.get(5).equals("true")) {
            listObject.set(5, "false");
            this.label.setSelected(false);
          } else {
            listObject.set(5, "true");
            this.label.setSelected(true);
          }
        }
      } else {
        this.label.setOpaque(false);
        this.label.setBorder(BorderFactory.createLineBorder(Color.WHITE));
      }

      return this.label;
    }
  }

  private JPanel relationContentPane;
  private JPanel atomContentPane;
  String type;
  int index;
  @SuppressWarnings("rawtypes")
  private JList list;
  private JTree tree;

  /**
   * Launch the application.
   */
  // public static void main(String[] args) {
  // EventQueue.invokeLater(new Runnable() {
  // public void run() {
  // try {
  // RelationPage frame = new RelationPage();
  // frame.setVisible(true);
  // } catch (Exception e) {
  // e.printStackTrace();
  // }
  // }
  // });
  // }

  private String relation;

  private final String id;

  /**
   * Create the frame.
   */
  public MappingWizard(final String type, final int index) {
    this.type = type;
    this.index = index;
    this.id = Utility.itemIdByIndex(type, index);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setBounds(100, 100, 450, 300);
    this.createRelationContent();
    this.setContentPane(this.relationContentPane);
  }

  private void createAtomContent() {
    this.setTitle("Atoms");

    this.atomContentPane = new JPanel();
    this.atomContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    this.atomContentPane.setLayout(new BorderLayout(0, 0));

    final MutableTreeNode atoms = new DefaultMutableTreeNode("Atoms");
    this.tree = new JTree(atoms);
    this.tree.setBorder(new LineBorder(new Color(0, 0, 0)));
    final JScrollPane scrollPane = new JScrollPane(this.tree,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    this.atomContentPane.add(scrollPane, BorderLayout.CENTER);
    this.tree.setCellRenderer(new TreeCellRender());

    final String selectedValueOfList = (String) this.list.getSelectedValue();
    this.relation = selectedValueOfList.substring(0, selectedValueOfList.indexOf(" "));
    final String selectedType = selectedValueOfList.substring(selectedValueOfList.indexOf(": ") + 2,
        selectedValueOfList.indexOf(" ->"));
    final ArrayList<ArrayList<String>> suitableAtoms =
        Utility.getSuitableSecondSideTypesOfRelation(this.relation, selectedType, this.id);

    String atomType = "";
    MutableTreeNode typeNode = null;

    for (final ArrayList<String> suitable : suitableAtoms) {
      if (!atomType.equals(suitable.get(0))) {
        typeNode = new DefaultMutableTreeNode(suitable.get(0));
        atomType = suitable.get(0);
        atoms.insert(typeNode, atoms.getChildCount());
      }
      suitable.add(suitable.get(1) + " { " + suitable.get(2) + " }");
      suitable.add(suitable.get(3));
      final MutableTreeNode atomNode = new DefaultMutableTreeNode(suitable);
      typeNode.insert(atomNode, typeNode.getChildCount());
    }

    final TreeNode root = (TreeNode) this.tree.getModel().getRoot();
    this.expandAll(this.tree, new TreePath(root));

    final JPanel panel = new JPanel();
    final FlowLayout flowLayout = (FlowLayout) panel.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    this.atomContentPane.add(panel, BorderLayout.SOUTH);

    final JButton btnNewButton = new JButton("Back");
    btnNewButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        MappingWizard.this.createRelationContent();
        MappingWizard.this.setContentPane(MappingWizard.this.relationContentPane);
        MappingWizard.this.revalidate();
      }
    });
    panel.add(btnNewButton);

    final JButton btnNewButton_1 = new JButton("Finish");
    btnNewButton_1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        final List<Notifier> notifierList = Visualization.getInstance().getNotifierList();

        for (final ArrayList<String> suitable : suitableAtoms) {
          if (!suitable.get(3).equals(suitable.get(5))) {
            final String toIndex = suitable.get(1).substring(suitable.get(0).length());
            final String toItemId =
                Utility.itemIdByIndex(suitable.get(0), Integer.parseInt(toIndex));
            final String toAtomName = Utility.getAtomNameById(toItemId);
            final String fromAtomName = Utility.getAtomNameById(MappingWizard.this.id);
            final List<String> tupleList = new ArrayList<>();
            tupleList.add(fromAtomName);
            tupleList.add(toAtomName);
            if (suitable.get(5).equals("false")) {
              Utility.removeRelation(MappingWizard.this.id, toItemId, MappingWizard.this.relation);
              for (final Notifier notifier : notifierList) {
                notifier.removeTupleNotify(MappingWizard.this.relation, tupleList,
                    Visualization.getInstance().isLower() ? "lower" : "upper");
              }
            } else {
              Utility.addRelation2Atoms(MappingWizard.this.id, toItemId,
                  MappingWizard.this.relation);
              for (final Notifier notifier : notifierList) {
                notifier.addTupleNotify(MappingWizard.this.relation, tupleList,
                    Visualization.getInstance().isLower() ? "lower" : "upper");
              }
            }
          }
        }

        // TreePath path = tree.getSelectionModel().getSelectionPath();
        // if (path == null || path.getLastPathComponent() == null)
        // return;
        // String selectedOnTree = path.getLastPathComponent().toString();
        // String selectedItemType = path.getParentPath().getLastPathComponent().toString();
        // String strIndexOfSelected =
        // selectedOnTree.substring(selectedItemType.length(), selectedOnTree.indexOf(" "));
        // int indexOfSelected = 0;
        // if (!strIndexOfSelected.isEmpty()) {
        // try {
        // indexOfSelected = Integer.parseInt(strIndexOfSelected);
        // } catch (NumberFormatException e1) {
        // }
        // }
        // Utility.addRelation2Atoms(Utility.itemIdByIndex(type, index),
        // Utility.itemIdByIndex(selectedItemType, indexOfSelected), relation);
        Visualization.getInstance(null).revalidate();
        MappingWizard.this.disposeThis();
      }
    });
    panel.add(btnNewButton_1);

    final JButton btnCancel = new JButton("Cancel");
    btnCancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        MappingWizard.this.disposeThis();
      }
    });
    panel.add(btnCancel);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  private void createRelationContent() {
    this.setTitle("Relations");
    this.relationContentPane = new JPanel();
    this.relationContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    this.relationContentPane.setLayout(new BorderLayout(0, 0));

    this.list = new JList();
    this.list.setBorder(new LineBorder(new Color(0, 0, 0)));
    final JScrollPane scrollPane = new JScrollPane(this.list,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    this.relationContentPane.add(scrollPane, BorderLayout.CENTER);

    final ArrayList<String> relations = Utility.getSuitableRelations(this.type);
    final DefaultListModel<String> model = new DefaultListModel<>();
    this.list.setModel(model);
    this.list.setCellRenderer(new ListCellRender());

    for (final String rel : relations) {
      model.addElement(rel);
    }

    final JPanel panel = new JPanel();
    final FlowLayout flowLayout = (FlowLayout) panel.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    this.relationContentPane.add(panel, BorderLayout.SOUTH);

    final JButton btnNewButton = new JButton("Next");
    btnNewButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        if (!MappingWizard.this.list.isSelectionEmpty()) {
          MappingWizard.this.createAtomContent();
          MappingWizard.this.setContentPane(MappingWizard.this.atomContentPane);
          MappingWizard.this.revalidate();
        }
      }
    });
    panel.add(btnNewButton);

    final JButton btnNewButton_1 = new JButton("Cancel");
    btnNewButton_1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent arg0) {
        MappingWizard.this.disposeThis();
      }
    });
    panel.add(btnNewButton_1);
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

}
