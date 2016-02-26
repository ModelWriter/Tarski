package com.mxgraph.examples.swing.visualization;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.mxgraph.model.mxCell;

public class VisualizationPopupMenu extends JPopupMenu {
  private static final long serialVersionUID = -1726551578352281567L;
  final JMenuItem miCreateMapping = new JMenuItem("Create Mapping");
  final JMenuItem miChangeAtomType = new JMenuItem("Change Atom Type");
  final JMenuItem miRemoveAtom = new JMenuItem("Remove Atom");
  final JMenuItem miMoveToUpper = new JMenuItem("Move To Upper");
  final JMenuItem miMoveToLower = new JMenuItem("Move To Lower");
  final JMenuItem miRemoveRelation = new JMenuItem("Remove Relation");
  final JMenuItem miCreateAtom = new JMenuItem("Create Atom");

  public VisualizationPopupMenu(final VisualizationGraphEditor editor, final Object onWhat) {
    this.miCreateMapping.addActionListener(this.createMappingListener());
    this.miChangeAtomType.addActionListener(this.changeAtomTypeListener());
    this.miRemoveAtom.addActionListener(this.removeAtomListener());
    this.miMoveToUpper.addActionListener(this.moveToUpperListener());
    this.miMoveToLower.addActionListener(this.moveToLowerListener());
    this.miRemoveRelation.addActionListener(this.removeRelationListener());
    this.miCreateAtom.addActionListener(this.createAtomListener());

    if (onWhat instanceof mxCell) {
      final mxCell cell = (mxCell) onWhat;
      if (cell.isVertex()) {
        this.add(this.miCreateMapping);
        this.add(this.miChangeAtomType);
        this.add(this.miRemoveAtom);
        this.add(this.miMoveToUpper);
        this.add(this.miMoveToLower);
      } else {
        this.add(this.miMoveToUpper);
        this.add(this.miMoveToLower);
        this.add(this.miRemoveRelation);
      }
    } else {
      this.add(this.miCreateAtom);
    }
  }

  private ActionListener changeAtomTypeListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        System.out.println("Change Atom Type");
      }
    };
  }

  private ActionListener createAtomListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        System.out.println("Create Atom");
      }
    };
  }

  private ActionListener createMappingListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        System.out.println("Create Mapping");
      }
    };
  }

  private ActionListener moveToLowerListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        System.out.println("Move To Lower");
      }
    };
  }

  private ActionListener moveToUpperListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        System.out.println("Move To Upper");
      }
    };
  }

  private ActionListener removeAtomListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        System.out.println("Remove Atom");
      }
    };
  }

  private ActionListener removeRelationListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        System.out.println("Remove Relation");
      }
    };
  }
}
