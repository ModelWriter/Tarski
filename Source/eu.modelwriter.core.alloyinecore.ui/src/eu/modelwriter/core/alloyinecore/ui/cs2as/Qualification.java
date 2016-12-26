package eu.modelwriter.core.alloyinecore.ui.cs2as;

public enum Qualification {
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
  NOT_RESOLVE;
  @Override
  public String toString() {
    return super.toString().toLowerCase().replaceAll("not_", "!");
  }

  public String getAnnotationSource() {
    switch (this) {
      case VISIBILITY:
        return AnnotationSources.VISIBILTY;
      case STATIC:
        return AnnotationSources.STATIC;
      case PRIMITIVE:
        return AnnotationSources.DATATYPE_PRIMITIVE;
      case CALLABLE:
        return AnnotationSources.INVARIANT;
      case MODEL:
        return AnnotationSources.MODEL;
      case GHOST:
        return AnnotationSources.GHOST;
      case NULLABLE:
        return AnnotationSources.NULLABLE;
      default:
        return AnnotationSources.QUALIFIER;
    }
  }
}
