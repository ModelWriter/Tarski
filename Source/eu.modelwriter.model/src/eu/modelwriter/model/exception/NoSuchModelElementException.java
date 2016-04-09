package eu.modelwriter.model.exception;

public class NoSuchModelElementException extends Exception {

  private static final long serialVersionUID = 13053687922656638L;

  @Override
  public String getMessage() {
    return "Element cannot be found in the universe.";
  }
}
