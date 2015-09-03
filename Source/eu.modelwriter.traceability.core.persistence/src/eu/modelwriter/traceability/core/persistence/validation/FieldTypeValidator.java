/**
 *
 * $Id$
 */
package eu.modelwriter.traceability.core.persistence.validation;

import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.TypesType;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link eu.modelwriter.traceability.core.persistence.FieldType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface FieldTypeValidator {
  boolean validate();

  boolean validateTuple(EList<TupleType> value);
  boolean validateTypes(EList<TypesType> value);

  boolean validateTypes(TypesType value);
  boolean validateAtom(EList<AtomType> value);
  boolean validateAbstract(String value);
  boolean validateID(int value);
  boolean validateLabel(String value);
  boolean validateParentID(int value);
}
