package eu.modelwriter.visualization.editor.handler;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.function.BiConsumer;

import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxUtils;

import eu.modelwriter.visualization.editor.StaticEditorManager;
import eu.modelwriter.visualization.model.EdgeColor;

public class SwitchEdgeColorsHandler implements ActionListener {
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
}
