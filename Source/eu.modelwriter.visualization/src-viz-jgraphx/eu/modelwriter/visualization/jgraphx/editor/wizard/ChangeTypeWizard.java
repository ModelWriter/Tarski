package eu.modelwriter.visualization.jgraphx.editor.wizard;

import java.util.List;
import java.util.stream.Collectors;

import com.mxgraph.model.mxCell;

import eu.modelwriter.visualization.jgraphx.editor.Graph;
import eu.modelwriter.visualization.jgraphx.editor.StaticEditorManager;
import eu.modelwriter.visualization.jgraphx.editor.handler.StaticHandlerManager;

public class ChangeTypeWizard extends TypeWizard {
  private static final long serialVersionUID = -2481700416568760515L;

  public ChangeTypeWizard(final Graph graph, final Object onWhat, final List<Object> list) {
    super(graph, onWhat, list);
  }

  @Override
  public void performFinish() {
    final List<String> selectedValuesList = list.getSelectedValuesList().stream()
        .map(object -> (object != null ? (String) object : null)).collect(Collectors.toList());
    StaticEditorManager.builder.changeAtomType((mxCell) StaticHandlerManager.onWhat,
        selectedValuesList);
  }
}
