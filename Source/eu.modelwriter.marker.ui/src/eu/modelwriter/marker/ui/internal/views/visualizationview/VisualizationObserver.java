package eu.modelwriter.marker.ui.internal.views.visualizationview;

import eu.modelwriter.model.ModelElement;
import eu.modelwriter.model.observer.Observer;
import eu.modelwriter.model.observer.UpdateType;

public class VisualizationObserver implements Observer {
  @Override
  public void update(final Object updatedObject, final Object updateType) {
    switch ((UpdateType) updateType) {
      case REMOVE_ATOM:
        final ModelElement atom = (ModelElement) updatedObject;
        break;

      default:
        break;
    }
  }
}
