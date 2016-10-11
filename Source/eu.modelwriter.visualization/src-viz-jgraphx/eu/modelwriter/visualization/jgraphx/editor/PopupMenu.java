package eu.modelwriter.visualization.jgraphx.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.mxgraph.model.mxCell;

import eu.modelwriter.visualization.jgraphx.editor.handler.HandlerFactory;
import eu.modelwriter.visualization.jgraphx.editor.handler.StaticHandlerManager;
import eu.modelwriter.visualization.jgraphx.editor.util.GraphUtil;

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

    installListeners();
    setMenuItems();
  }

  private void installListeners() {
    miCreateMapping.addActionListener(HandlerFactory.createMappingHandler());
    miChangeAtomType.addActionListener(HandlerFactory.changeAtomTypeHandler());
    miRemoveAtom.addActionListener(HandlerFactory.removeCellHandler());
    miMoveToUpper.addActionListener(
        HandlerFactory.moveToHandler(StaticHandlerManager.BoundType.UPPER_BOUND));
    miMoveToLower.addActionListener(
        HandlerFactory.moveToHandler(StaticHandlerManager.BoundType.LOWER_BOUND));
    miRemoveRelation.addActionListener(HandlerFactory.removeCellHandler());
    miCreateAtom.addActionListener(HandlerFactory.createAtomHandler());
    miVerticalLayout.addActionListener(verticalLayoutListener());
    miSwitchEdgeColors.addActionListener(HandlerFactory.switchEdgeColorsHandler());
  }

  private void setMenuItems() {
    if (StaticHandlerManager.onWhat instanceof mxCell) {
      final mxCell cell = (mxCell) StaticHandlerManager.onWhat;
      if (cell.isVertex()) {
        this.add(miCreateMapping);
        this.add(miChangeAtomType);
        this.add(miRemoveAtom);
        this.add(miMoveToUpper);
        this.add(miMoveToLower);
      } else {
        this.add(miMoveToUpper);
        this.add(miMoveToLower);
        this.add(miRemoveRelation);
      }
    } else {
      this.add(miCreateAtom);
      this.add(miVerticalLayout);
      this.add(miSwitchEdgeColors);
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
