package eu.modelwriter.model.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
  private final List<Observer> observers = new ArrayList<Observer>();

  public void addObserver(final Observer o) {
    if (o == null) {
      throw new NullPointerException();
    }
    if (!this.observers.contains(o)) {
      this.observers.add(o);
    }
  }

  public void clearObservers() {
    this.observers.clear();
  }

  public void deleteObserver(final Observer o) {
    this.observers.remove(o);
  }

  public void notifyAllObservers(final Object updatedObject, final Object updateType) {
    for (int i = this.observers.size() - 1; i >= 0; i--) {
      this.observers.get(i).update(updatedObject, updateType);
    }
  }
}
