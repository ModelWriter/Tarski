package eu.modelwriter.visualization.editor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.function.BiConsumer;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxResources;
import com.mxgraph.util.mxUtils;

import eu.modelwriter.visualization.editor.handler.ChangeAtomTypeHandler;
import eu.modelwriter.visualization.editor.handler.CreateAtomHandler;
import eu.modelwriter.visualization.editor.handler.CreateMappingHandler;
import eu.modelwriter.visualization.editor.handler.Move2LowerHandler;
import eu.modelwriter.visualization.editor.handler.Move2UpperHandler;
import eu.modelwriter.visualization.editor.handler.RemoveAtomHandler;
import eu.modelwriter.visualization.editor.handler.RemoveRelationHandler;
import eu.modelwriter.visualization.editor.util.GraphUtil;
import eu.modelwriter.visualization.model.EdgeColor;

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

  public PopupMenu(final Object onWhat) {
    this.miCreateMapping.addActionListener(new CreateMappingHandler());
    this.miChangeAtomType.addActionListener(new ChangeAtomTypeHandler());
    this.miRemoveAtom.addActionListener(new RemoveAtomHandler());
    this.miMoveToUpper.addActionListener(new Move2UpperHandler());
    this.miMoveToLower.addActionListener(new Move2LowerHandler());
    this.miRemoveRelation.addActionListener(new RemoveRelationHandler());
    this.miCreateAtom.addActionListener(new CreateAtomHandler());
    this.miVerticalLayout
        .addActionListener(this.createVerticalLayoutListener("verticalHierarchical"));
    this.miSwitchEdgeColors.addActionListener(this.switchEdgeColors());

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
      this.add(this.miVerticalLayout);
      this.add(this.miSwitchEdgeColors);
    }
  }

  @SuppressWarnings("serial")
  public Action createVerticalLayoutListener(final String key) {
    return new AbstractAction(mxResources.get(key)) {
      @Override
      public void actionPerformed(final ActionEvent e) {
        GraphUtil.getInstance().layout();
      }
    };
  }

  private ActionListener switchEdgeColors() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        EdgeColor.INSTANCE.clear();
        StaticEditorManager.builder.getRelName2Color().forEach(new BiConsumer<String, Color>() {

          @Override
          public void accept(final String s, Color c) {
            c = EdgeColor.INSTANCE.randomUniqueColor();
            final String styleName = "edgeStyle$" + s;
            final Map<String, Object> cellStyle =
                StaticEditorManager.graph.getStylesheet().getCellStyle(styleName, null);
            if (cellStyle == null) {
              return;
            }
            cellStyle.put(mxConstants.STYLE_STROKECOLOR, mxUtils.getHexColorString(c));
            StaticEditorManager.graph.getStylesheet().putCellStyle(styleName, cellStyle);
          }
        });
        StaticEditorManager.graphComponent.refresh();
      }
    };
  }
}
