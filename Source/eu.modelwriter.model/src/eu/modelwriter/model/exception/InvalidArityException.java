package eu.modelwriter.model.exception;

public class InvalidArityException extends Exception {

  private static final long serialVersionUID = 8892715346352339032L;

  @Override
  public String getMessage() {
    return "Tuple arity is not equal with Relation arity.";
  }
}
