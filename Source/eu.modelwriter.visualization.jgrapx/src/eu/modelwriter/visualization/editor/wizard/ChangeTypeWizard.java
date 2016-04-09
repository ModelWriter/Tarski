package eu.modelwriter.visualization.editor.wizard;

import java.util.List;
import java.util.stream.Collectors;

import com.mxgraph.model.mxCell;

import eu.modelwriter.model.ModelElement;
import eu.modelwriter.model.exception.InvalidArityException;
import eu.modelwriter.model.exception.NoSuchModelElementException;
import eu.modelwriter.visualization.editor.Graph;
import eu.modelwriter.visualization.editor.StaticEditorManager;

public class ChangeTypeWizard extends TypeWizard {
  private static final long serialVersionUID = -2481700416568760515L;

  public ChangeTypeWizard(final Graph graph, final Object onWhat, final List<Object> list) {
    super(graph, onWhat, list);
  }

  @Override
  public void performFinish() {
    ChangeTypeWizard.this.graph.getModel().beginUpdate();
    final ModelElement element = (ModelElement) ((mxCell) ChangeTypeWizard.this.onWhat).getValue();
    final List<String> selectedValuesList = ChangeTypeWizard.this.list.getSelectedValuesList()
        .stream().map(object -> (object != null ? (String) object : null)) // hani sheqiliz ya.
        .collect(Collectors.toList());
    try {
      StaticEditorManager.builder.getManager().changeRelationSetsOfAtom(element.getID(),
          selectedValuesList);
    } catch (final InvalidArityException | NoSuchModelElementException e) {
      e.printStackTrace();
    }

    ChangeTypeWizard.this.graph
        .removeCells(ChangeTypeWizard.this.graph.getEdges(ChangeTypeWizard.this.onWhat));
    ChangeTypeWizard.this.graph.getModel().endUpdate();
  }
}
