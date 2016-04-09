package eu.modelwriter.visualization.editor.wizard;

import java.util.List;

import javax.swing.ListSelectionModel;

import eu.modelwriter.visualization.editor.Graph;

public class CreateMappingWizard extends TypeWizard {
  private static final long serialVersionUID = -85109403293169462L;

  public CreateMappingWizard(final Graph graph, final Object onWhat, final List<Object> list) {
    super(graph, onWhat, list);
    this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
  }

  @Override
  public void performFinish() {
    // StaticEditorManager.builder.addTuple(this.list.getSelectedValue().toString(), null,
    // BOUND.LOWER_BOUND, 2, ATOMS);
  }
}
