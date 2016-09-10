package eu.modelwriter.configuration.generation;

public abstract class AbstractGeneration {

  // states
  public static final int RUNNING = 1, NOT_STARTED = 0, FINISHED = 2;
  private int state = NOT_STARTED;

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  abstract public void onException(Exception e);

}
