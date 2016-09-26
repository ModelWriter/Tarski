package eu.modelwriter.visualization.editor.wizard;

import java.util.List;
import java.util.stream.Collectors;

import com.mxgraph.model.mxCell;

import eu.modelwriter.visualization.editor.Graph;
import eu.modelwriter.visualization.editor.StaticEditorManager;
import eu.modelwriter.visualization.editor.handler.StaticHandlerManager;

public class ChangeTypeWizard extends TypeWizard {
  private static final long serialVersionUID = -2481700416568760515L;

  public ChangeTypeWizard(final Graph graph, final Object onWhat, final List<Object> list) {
    super(graph, onWhat, list);
  }

  @Override
  public void performFinish() {
    final List<String> selectedValuesList = this.list.getSelectedValuesList().stream()
        .map(object -> (object != null ? (String) object : null)).collect(Collectors.toList());
    StaticEditorManager.builder.changeAtomType((mxCell) StaticHandlerManager.onWhat,
        selectedValuesList);
  }
}
