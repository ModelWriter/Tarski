package eu.modelwriter.configuration.alloy.trace;

public class TraceException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = -4595785190626648593L;

  private final String message;

  public TraceException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
