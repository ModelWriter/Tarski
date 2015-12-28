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

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import eu.modelwriter.visualization.Utility;

@SuppressWarnings("serial")
public class MappingWizard extends JFrame {

  private JPanel relationContentPane;
  private JPanel atomContentPane;
  String type;
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

  /**
   * Create the frame.
   */
  public MappingWizard(String type) {
    this.type = type;
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
    relationContentPane.add(list, BorderLayout.CENTER);

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
        createAtomContent();
        setContentPane(atomContentPane);
        revalidate();
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
    atomContentPane.add(tree, BorderLayout.CENTER);
    tree.setCellRenderer(new CellRenderer());

    String selecteValueOfList = (String) list.getSelectedValue();
    String relation = selecteValueOfList.substring(0, selecteValueOfList.indexOf(" "));
    ArrayList<ArrayList<String>> suitableAtoms =
        Utility.getSuitableSecondSideTypesOfRelation(relation, type);

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
      public void actionPerformed(ActionEvent e) {}
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
