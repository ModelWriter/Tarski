/**
 *
 * $Id$
 */
package eu.modelwriter.alloyxmlapi.validation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.util.FeatureMap;

import eu.modelwriter.alloyxmlapi.FieldType;
import eu.modelwriter.alloyxmlapi.SigType;

/**
 * A sample validator interface for {@link eu.modelwriter.alloyxmlapi.InstanceType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface InstanceTypeValidator {
  boolean validate();

  boolean validateGroup(FeatureMap value);
  boolean validateSig(EList<SigType> value);
  boolean validateField(EList<FieldType> value);
  boolean validateBitwidth(byte value);
  boolean validateCommand(String value);
  boolean validateFilename(String value);
  boolean validateMaxseq(byte value);
}