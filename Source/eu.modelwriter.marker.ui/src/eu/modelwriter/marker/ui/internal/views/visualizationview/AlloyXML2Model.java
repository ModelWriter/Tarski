package eu.modelwriter.marker.ui.internal.views.visualizationview;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.model.ModelManager;
import eu.modelwriter.model.exception.InvalidArityException;

public class AlloyXML2Model {
  public static final AlloyXML2Model instance = new AlloyXML2Model();

  private AlloyXML2Model() {}

  public ModelManager convert() {
    ModelManager modelManager = null;
    try {
      modelManager = AlloyUtilities.convert2Model();
    } catch (final InvalidArityException e) {
      e.printStackTrace();
    }
    return modelManager;
  }
}
