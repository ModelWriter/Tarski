package eu.modelwriter.core.alloyinecore.ui.cs2as;

import eu.modelwriter.core.alloyinecore.ui.model.AnnotationSources;

public enum Qualification {
  VISIBILITY,
  STATIC,
  PRIMITIVE,
  SERIALIZABLE,
  CALLABLE,
  DERIVED,
  NOT_DERIVED,
  ORDERED,
  NOT_ORDERED,
  UNIQUE,
  NOT_UNIQUE,
  ID,
  NOT_ID,
  READONLY,
  NOT_READONLY,
  TRANSIENT,
  NOT_TRANSIENT,
  UNSETTABLE,
  NOT_UNSETTABLE,
  VOLATILE,
  NOT_VOLATILE,
  COMPOSES,
  NOT_COMPOSES,
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
      default:
        return AnnotationSources.QUALIFIER;
    }
  }
}
