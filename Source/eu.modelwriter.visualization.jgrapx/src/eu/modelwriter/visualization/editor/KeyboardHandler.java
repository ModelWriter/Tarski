package eu.modelwriter.visualization.editor;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;

import com.mxgraph.swing.handler.mxKeyboardHandler;


public class KeyboardHandler extends mxKeyboardHandler {
  /**
   *
   * @param graphComponent
   */
  public KeyboardHandler(final GraphComponent graphComponent) {
    super(graphComponent);
  }

  /**
   * Return the mapping between JTree's input map and JGraph's actions.
   */
  @Override
  protected ActionMap createActionMap() {
    final ActionMap map = super.createActionMap();

    // map.put("save", new EditorActions.SaveAction(false));
    // map.put("saveAs", new EditorActions.SaveAction(true));
    // map.put("new", new EditorActions.NewAction());
    // map.put("open", new EditorActions.OpenAction());
    // map.put("undo", new EditorActions.HistoryAction(true));
    // map.put("redo", new EditorActions.HistoryAction(false));
    // map.put("selectVertices", mxGraphActions.getSelectVerticesAction());
    // map.put("selectEdges", mxGraphActions.getSelectEdgesAction());

    return map;
  }

  /**
   * Return JTree's input map.
   */
  @Override
  protected InputMap getInputMap(final int condition) {
    final InputMap map = super.getInputMap(condition);

    if (condition == JComponent.WHEN_FOCUSED && map != null) {
      // map.put(KeyStroke.getKeyStroke("control S"), "save");
      // map.put(KeyStroke.getKeyStroke("control shift S"), "saveAs");
      // map.put(KeyStroke.getKeyStroke("control N"), "new");
      // map.put(KeyStroke.getKeyStroke("control O"), "open");
      //
      // map.put(KeyStroke.getKeyStroke("control Z"), "undo");
      // map.put(KeyStroke.getKeyStroke("control Y"), "redo");
      // map.put(KeyStroke.getKeyStroke("control shift V"), "selectVertices");
      // map.put(KeyStroke.getKeyStroke("control shift E"), "selectEdges");
    }

    return map;
  }

}
