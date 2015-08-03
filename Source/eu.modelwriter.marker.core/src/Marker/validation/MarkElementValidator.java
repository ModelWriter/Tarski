/**
 *
 * $Id$
 */
package Marker.validation;

import Marker.MarkElement;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link Marker.MarkElement}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface MarkElementValidator {
  boolean validate();

  boolean validateId(String value);
  boolean validateOffset(int value);
  boolean validateLength(int value);
  boolean validateMessage(String value);
  boolean validateLineNumber(int value);
  boolean validateFullPath(String value);
  boolean validateTarget(EList<MarkElement> value);
  boolean validateSource(EList<MarkElement> value);
}
