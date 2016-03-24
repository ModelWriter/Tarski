package eu.modelwriter.model;

import java.util.ArrayList;

import eu.modelwriter.model.observer.Subject;

public class ModelManager extends Subject {
  private static ModelManager manager;
  private static Universe universe;

  public static ModelManager getInstance() {
    if (ModelManager.manager == null) {
      ModelManager.manager = new ModelManager();
    }
    return ModelManager.manager;
  }

  private ModelManager() {
    ModelManager.universe = new Universe();
  }

  public ArrayList<Relation> getRelations() {
    return ModelManager.universe.getRelations();
  }

  public void setUniverse(final Universe universe) {
    ModelManager.universe = universe;
  }
}
