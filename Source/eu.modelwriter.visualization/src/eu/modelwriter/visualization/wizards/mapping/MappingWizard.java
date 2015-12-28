package eu.modelwriter.visualization.wizards.mapping;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import edu.mit.csail.sdg.alloy4.Util;
import eu.modelwriter.visualization.Utility;
import eu.modelwriter.visualization.Visualization;

@SuppressWarnings("serial")
public class MappingWizard extends JFrame {

  private JPanel relationContentPane;
  private JPanel atomContentPane;
  String type;
  int index;
  private JList list;
  private JTree tree;
  private String relation;

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

  /**
   * Create the frame.
   */
  public MappingWizard(String type, int index) {
    this.type = type;
    this.index = index;
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    createRelationContent();
    setContentPane(relationContentPane);
  }

  @SuppressWarnings("unchecked")
  private void createRelationContent() {
    setTitle("Relations");
    relationContentPane = new JPanel();
    relationContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    relationContentPane.setLayout(new BorderLayout(0, 0));

    list = new JList();
    list.setBorder(new LineBorder(new Color(0, 0, 0)));
    JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    relationContentPane.add(scrollPane, BorderLayout.CENTER);

    ArrayList<String> relations = Utility.getSuitableRelations(type);
    DefaultListModel<String> model = new DefaultListModel<>();
    list.setModel(model);
    list.setCellRenderer(new ListCellRender());

    for (String rel : relations) {
      model.addElement(rel);
    }

    JPanel panel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) panel.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    relationContentPane.add(panel, BorderLayout.SOUTH);

    JButton btnNewButton = new JButton("Next");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!list.isSelectionEmpty()) {
          createAtomContent();
          setContentPane(atomContentPane);
          revalidate();
        }
      }
    });
    panel.add(btnNewButton);

    JButton btnNewButton_1 = new JButton("Cancel");
    btnNewButton_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        disposeThis();
      }
    });
    panel.add(btnNewButton_1);
  }

  private void createAtomContent() {
    setTitle("Atoms");

    atomContentPane = new JPanel();
    atomContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    atomContentPane.setLayout(new BorderLayout(0, 0));

    MutableTreeNode atoms = new DefaultMutableTreeNode("Atoms");
    tree = new JTree(atoms);
    tree.setBorder(new LineBorder(new Color(0, 0, 0)));
    JScrollPane scrollPane = new JScrollPane(tree, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    atomContentPane.add(scrollPane, BorderLayout.CENTER);
    tree.setCellRenderer(new CellRenderer());

    String selectedValueOfList = (String) list.getSelectedValue();
    relation = selectedValueOfList.substring(0, selectedValueOfList.indexOf(" "));
    String selectedType = selectedValueOfList.substring(selectedValueOfList.indexOf(": ") + 2,
        selectedValueOfList.indexOf(" ->"));
    ArrayList<ArrayList<String>> suitableAtoms =
        Utility.getSuitableSecondSideTypesOfRelation(relation, selectedType);

    String atomType = "";
    MutableTreeNode typeNode = null;

    for (ArrayList<String> suitable : suitableAtoms) {
      if (!atomType.equals(suitable.get(0))) {
        typeNode = new DefaultMutableTreeNode(suitable.get(0));
        atomType = suitable.get(0);
        atoms.insert(typeNode, atoms.getChildCount());
      }
      String atomName = suitable.get(1) + " { " + suitable.get(2) + " }";
      MutableTreeNode atomNode = new DefaultMutableTreeNode(atomName);
      typeNode.insert(atomNode, typeNode.getChildCount());
    }

    TreeNode root = (TreeNode) tree.getModel().getRoot();
    expandAll(tree, new TreePath(root));

    JPanel panel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) panel.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    atomContentPane.add(panel, BorderLayout.SOUTH);

    JButton btnNewButton = new JButton("Back");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        createRelationContent();
        setContentPane(relationContentPane);
        revalidate();
      }
    });
    panel.add(btnNewButton);

    JButton btnNewButton_1 = new JButton("Finish");
    btnNewButton_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        TreePath path = tree.getSelectionModel().getSelectionPath();
        if (path == null || path.getLastPathComponent() == null)
          return;
        String selectedOnTree = path.getLastPathComponent().toString();
        String selectedItemType = path.getParentPath().getLastPathComponent().toString();
        String strIndexOfSelected =
            selectedOnTree.substring(selectedItemType.length(), selectedOnTree.indexOf(" "));
        int indexOfSelected = 0;
        if (!strIndexOfSelected.isEmpty()) {
          try {
            indexOfSelected = Integer.parseInt(strIndexOfSelected);
          } catch (NumberFormatException e1) {
          }
        }
        Utility.addRelation2Markers(Utility.itemIdByIndex(type, index),
            Utility.itemIdByIndex(selectedItemType, indexOfSelected), relation);
        Visualization.getInstance(null).revalidate();
        disposeThis();
      }
    });
    panel.add(btnNewButton_1);

    JButton btnCancel = new JButton("Cancel");
    btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        disposeThis();
      }
    });
    panel.add(btnCancel);
  }

  private void disposeThis() {
    this.dispose();
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


  @SuppressWarnings("rawtypes")
  class ListCellRender implements ListCellRenderer {
    private JLabel label;

    public ListCellRender() {
      label = new JLabel();
    }


    @Override
    public Component getListCellRendererComponent(JList arg0, Object arg1, int arg2, boolean arg3,
        boolean arg4) {

      Object object = arg1;
      if (object instanceof String) {
        URL imageUrl = getClass().getClassLoader().getResource("relation.png");
        label.setText((String) object);
        label.setIcon(new ImageIcon(imageUrl));
      }

      if (arg3 && arg4) {
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
        URL imageUrl = getClass().getClassLoader().getResource("atom.png");
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
