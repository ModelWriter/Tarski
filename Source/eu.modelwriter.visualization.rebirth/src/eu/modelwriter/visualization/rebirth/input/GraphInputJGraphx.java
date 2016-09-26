package eu.modelwriter.visualization.rebirth.input;

import eu.modelwriter.model.ModelManager;
import eu.modelwriter.visualization.rebirth.adapt.IModelAdapter;
import eu.modelwriter.visualization.rebirth.adapt.PersistenceModelAdapter;

public class GraphInputJGraphx extends AbstractGraphInput {
  public GraphInputJGraphx(final Object input) {
    super(input);
  }

  @Override
  public boolean checkIfTrueInput(final Object input) {
    return input instanceof ModelManager ? true : false;
  }

  @Override
  protected IModelAdapter createModelAdapter() {
    return PersistenceModelAdapter.instance;
  }
}
