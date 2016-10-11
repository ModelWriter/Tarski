package eu.modelwriter.visualization.input;

import eu.modelwriter.visualization.adapt.IModelAdapter;

public abstract class AbstractGraphInput implements IGraphInput {
  private final Object input;

  public AbstractGraphInput(final Object input) {
    if (checkIfTrueInput(input)) {
      this.input = input;
    } else {
      this.input = transformModel(input);
    }
  }

  @Override
  public Object get() {
    return input;
  }

  public abstract boolean checkIfTrueInput(Object input);

  protected abstract IModelAdapter createModelAdapter();

  public Object transformModel(final Object input) {
    final IModelAdapter iModelAdapter = createModelAdapter();
    return iModelAdapter.adapt(input);
  }
}
