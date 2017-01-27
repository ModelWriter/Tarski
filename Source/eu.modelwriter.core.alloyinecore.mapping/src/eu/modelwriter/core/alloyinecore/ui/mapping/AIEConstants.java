package eu.modelwriter.core.alloyinecore.ui.mapping;

public enum AIEConstants {
  VISIBILITY,
  INTERFACE,
  STATIC,
  PRIMITIVE,
  SERIALIZABLE,
  CALLABLE,
  MESSAGE,
  FORMULA,
  EXPRESSION,
  MODEL,
  GHOST,
  NAME,
  DERIVED,
  NOT_DERIVED,
  ORDERED,
  NOT_ORDERED,
  UNIQUE,
  NOT_UNIQUE,
  ID,
  NOT_ID,
  READONLY,
  TRANSIENT,
  UNSETTABLE,
  NOT_UNSETTABLE,
  VOLATILE,
  COMPOSES,
  NOT_COMPOSES,
  NULLABLE,
  RESOLVE,
  NOT_RESOLVE,
  NOT_SERIALIZABLE,
  SOURCE;

  public static final String SEPARATOR = "::";

  @Override
  public String toString() {
    return super.toString().toLowerCase().replaceAll("not_", "!");
  }

  public static AIEConstants getValue(final String arg0) {
    return AIEConstants.valueOf(arg0.replaceAll("!", "not_").toUpperCase());
  }
}
