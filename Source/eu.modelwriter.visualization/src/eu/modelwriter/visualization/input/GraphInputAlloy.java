package eu.modelwriter.visualization.input;

import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.visualization.adapt.IModelAdapter;
import eu.modelwriter.visualization.adapt.ModelPersistenceAdapter;

public class GraphInputAlloy extends AbstractGraphInput {
  public GraphInputAlloy(final Object input) {
    super(input);
  }

  @Override
  public DocumentRoot get() {
    return (DocumentRoot) super.get();
  }

  @Override
  public boolean checkIfTrueInput(final Object input) {
    return input instanceof DocumentRoot ? true : false;
  }

  @Override
  protected IModelAdapter createModelAdapter() {
    return ModelPersistenceAdapter.instance;
  }
}
