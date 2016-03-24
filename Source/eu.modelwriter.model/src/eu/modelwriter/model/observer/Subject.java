package eu.modelwriter.model.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
  private final List<Observer> observers = new ArrayList<Observer>();
  private boolean changed;

  public void addObserver(final Observer o) {
    if (o == null) {
      throw new NullPointerException();
    }
    if (!this.observers.contains(o)) {
      this.observers.add(o);
    }
  }

  public void clearChanged() {
    this.changed = false;
  }

  public void clearObservers() {
    this.observers.clear();
  }

  public void deleteObserver(final Observer o) {
    this.observers.remove(o);
  }

  public boolean hasChanged() {
    return this.changed;
  }

  public void notifyAllObservers() {
    this.notifyAllObservers(null);
  }

  public void notifyAllObservers(final Object updateType) {
    if (!this.hasChanged()) {
      return;
    }
    this.clearChanged();

    for (int i = this.observers.size() - 1; i >= 0; i--) {
      this.observers.get(i).update(this, updateType);
    }
  }

  public void setChanged() {
    this.changed = true;
  }
}
