package eu.modelwriter.visualization.editor.wizard;

import java.util.List;
import java.util.stream.Collectors;

import eu.modelwriter.model.ModelElement.BOUND;
import eu.modelwriter.visualization.editor.Graph;
import eu.modelwriter.visualization.editor.StaticEditorManager;

public class CreateAtomWizard extends TypeWizard {
  private static final long serialVersionUID = 7727853438620088827L;

  public CreateAtomWizard(final Graph graph, final Object onWhat, final List<Object> list) {
    super(graph, onWhat, list);
  }

  @Override
  public void performFinish() {
    StaticEditorManager.builder.addAtom(
        this.list.getSelectedValuesList().stream()
            .map(object -> (object != null ? (String) object : null)).collect(Collectors.toList()),
        null, BOUND.LOWER_BOUND);
  }
}
