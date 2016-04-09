package eu.modelwriter.visualization.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.mxgraph.model.mxCell;

import eu.modelwriter.visualization.editor.handler.HandlerFactory;
import eu.modelwriter.visualization.editor.handler.StaticHandlerManager;
import eu.modelwriter.visualization.editor.util.GraphUtil;

public class PopupMenu extends JPopupMenu {
  private static final long serialVersionUID = -1726551578352281567L;
  final JMenuItem miCreateMapping = new JMenuItem("Create Mapping");
  final JMenuItem miChangeAtomType = new JMenuItem("Change Atom Type");
  final JMenuItem miRemoveAtom = new JMenuItem("Remove Atom");
  final JMenuItem miMoveToUpper = new JMenuItem("Move To Upper");
  final JMenuItem miMoveToLower = new JMenuItem("Move To Lower");
  final JMenuItem miRemoveRelation = new JMenuItem("Remove Relation");
  final JMenuItem miCreateAtom = new JMenuItem("Create Atom");
  final JMenuItem miVerticalLayout = new JMenuItem("Vertical Hierarchical Layout");
  final JMenuItem miSwitchEdgeColors = new JMenuItem("Switch Edge Colors");

  public PopupMenu(final MouseEvent e) {
    StaticHandlerManager.e = e;
    StaticHandlerManager.onWhat = StaticEditorManager.graphComponent.getCellAt(e.getX(), e.getY());

    this.installListeners();
    this.setMenuItems();
  }

  private void installListeners() {
    this.miCreateMapping.addActionListener(HandlerFactory.createMappingHandler());
    this.miChangeAtomType.addActionListener(HandlerFactory.changeAtomTypeHandler());
    this.miRemoveAtom.addActionListener(HandlerFactory.removeCellHandler());
    this.miMoveToUpper.addActionListener(
        HandlerFactory.moveToHandler(StaticHandlerManager.BoundType.UPPER_BOUND));
    this.miMoveToLower.addActionListener(
        HandlerFactory.moveToHandler(StaticHandlerManager.BoundType.LOWER_BOUND));
    this.miRemoveRelation.addActionListener(HandlerFactory.removeCellHandler());
    this.miCreateAtom.addActionListener(HandlerFactory.createAtomHandler());
    this.miVerticalLayout.addActionListener(this.verticalLayoutListener());
    this.miSwitchEdgeColors.addActionListener(HandlerFactory.switchEdgeColorsHandler());
  }

  private void setMenuItems() {
    if (StaticHandlerManager.onWhat instanceof mxCell) {
      final mxCell cell = (mxCell) StaticHandlerManager.onWhat;
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
      this.add(this.miVerticalLayout);
      this.add(this.miSwitchEdgeColors);
    }
  }

  public ActionListener verticalLayoutListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        GraphUtil.getInstance().layout();
      }
    };
  }
}
