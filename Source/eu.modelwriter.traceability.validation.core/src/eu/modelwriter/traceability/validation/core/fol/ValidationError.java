package eu.modelwriter.traceability.validation.core.fol;

public class ValidationError {

  private final int line;

  private final int offset;

  private final String message;

  public ValidationError(final int line, final int offset, final String message) {
    this.line = line;
    this.offset = offset;
    this.message = message;
  }

  public int getLine() {
    return this.line;
  }

  public String getMessage() {
    return this.message;
  }

  public int getOffset() {
    return this.offset;
  }
}
