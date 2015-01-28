/**
 * <copyright>
 * </copyright>
 *
 * $Id: Doc2modelMappingSwitch.java,v 1.5 2009/05/15 13:13:32 tfaure Exp $
 */
package doc2modelMapping.util;

import doc2modelMapping.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see doc2modelMapping.Doc2modelMappingPackage
 * @generated
 */
public class Doc2modelMappingSwitch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static Doc2modelMappingPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Doc2modelMappingSwitch()
    {
        if (modelPackage == null)
        {
            modelPackage = Doc2modelMappingPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(EObject theEObject)
    {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(EClass theEClass, EObject theEObject)
    {
        if (theEClass.eContainer() == modelPackage)
        {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else
        {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(int classifierID, EObject theEObject)
    {
        switch (classifierID)
        {
            case Doc2modelMappingPackage.DOC2MODEL:
            {
                doc2model doc2model = (doc2model)theEObject;
                T result = casedoc2model(doc2model);
                if (result == null) result = caseDynamicElement(doc2model);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.LINKED_ELEMENT:
            {
                LinkedElement linkedElement = (LinkedElement)theEObject;
                T result = caseLinkedElement(linkedElement);
                if (result == null) result = caseDynamicElement(linkedElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.DOC_STYLE:
            {
                DocStyle docStyle = (DocStyle)theEObject;
                T result = caseDocStyle(docStyle);
                if (result == null) result = caseLinkedElement(docStyle);
                if (result == null) result = caseDynamicElement(docStyle);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.HIERARCHY:
            {
                Hierarchy hierarchy = (Hierarchy)theEObject;
                T result = caseHierarchy(hierarchy);
                if (result == null) result = caseDynamicElement(hierarchy);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.ATTRIBUTE_TAG:
            {
                AttributeTag attributeTag = (AttributeTag)theEObject;
                T result = caseAttributeTag(attributeTag);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.TAG_ELEMENT:
            {
                TagElement tagElement = (TagElement)theEObject;
                T result = caseTagElement(tagElement);
                if (result == null) result = caseLinkedElement(tagElement);
                if (result == null) result = caseDynamicElement(tagElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.TAG_ATTRIBUTE:
            {
                TagAttribute tagAttribute = (TagAttribute)theEObject;
                T result = caseTagAttribute(tagAttribute);
                if (result == null) result = caseDynamicElement(tagAttribute);
                if (result == null) result = caseAttribute(tagAttribute);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.DYNAMIC_ELEMENT:
            {
                DynamicElement dynamicElement = (DynamicElement)theEObject;
                T result = caseDynamicElement(dynamicElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.STYLE_ATTRIBUTE:
            {
                StyleAttribute styleAttribute = (StyleAttribute)theEObject;
                T result = caseStyleAttribute(styleAttribute);
                if (result == null) result = caseAttribute(styleAttribute);
                if (result == null) result = caseDynamicElement(styleAttribute);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.ATTRIBUTE:
            {
                Attribute attribute = (Attribute)theEObject;
                T result = caseAttribute(attribute);
                if (result == null) result = caseDynamicElement(attribute);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.INJECTION_ELEMENT:
            {
                InjectionElement injectionElement = (InjectionElement)theEObject;
                T result = caseInjectionElement(injectionElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION:
            {
                NewClassInjection newClassInjection = (NewClassInjection)theEObject;
                T result = caseNewClassInjection(newClassInjection);
                if (result == null) result = caseINewClassInjection(newClassInjection);
                if (result == null) result = caseStereotpyeApplicableInjection(newClassInjection);
                if (result == null) result = caseInstanceCreationInjection(newClassInjection);
                if (result == null) result = caseElementCreationInjection(newClassInjection);
                if (result == null) result = caseInjectionElement(newClassInjection);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.COMPOSITION_INJECTION:
            {
                CompositionInjection compositionInjection = (CompositionInjection)theEObject;
                T result = caseCompositionInjection(compositionInjection);
                if (result == null) result = caseDependantInjection(compositionInjection);
                if (result == null) result = caseStereotpyeApplicableInjection(compositionInjection);
                if (result == null) result = caseInstanceCreationInjection(compositionInjection);
                if (result == null) result = caseElementCreationInjection(compositionInjection);
                if (result == null) result = caseInjectionElement(compositionInjection);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.ATTRIBUTE_INJECTION:
            {
                AttributeInjection attributeInjection = (AttributeInjection)theEObject;
                T result = caseAttributeInjection(attributeInjection);
                if (result == null) result = caseDependantInjection(attributeInjection);
                if (result == null) result = caseInjectionElement(attributeInjection);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.DEPENDANT_INJECTION:
            {
                DependantInjection dependantInjection = (DependantInjection)theEObject;
                T result = caseDependantInjection(dependantInjection);
                if (result == null) result = caseInjectionElement(dependantInjection);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.REFERENCE_INJECTION:
            {
                ReferenceInjection referenceInjection = (ReferenceInjection)theEObject;
                T result = caseReferenceInjection(referenceInjection);
                if (result == null) result = caseDependantInjection(referenceInjection);
                if (result == null) result = caseInjectionElement(referenceInjection);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.REG_EX_ATTRIBUTE:
            {
                RegExAttribute regExAttribute = (RegExAttribute)theEObject;
                T result = caseRegExAttribute(regExAttribute);
                if (result == null) result = caseAttribute(regExAttribute);
                if (result == null) result = caseGroupElement(regExAttribute);
                if (result == null) result = caseDynamicElement(regExAttribute);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.REG_EX:
            {
                RegEx regEx = (RegEx)theEObject;
                T result = caseRegEx(regEx);
                if (result == null) result = caseLinkedElement(regEx);
                if (result == null) result = caseRegExMatchingElement(regEx);
                if (result == null) result = caseGroupElement(regEx);
                if (result == null) result = caseDynamicElement(regEx);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION_COMPOSITE:
            {
                NewClassInjectionComposite newClassInjectionComposite = (NewClassInjectionComposite)theEObject;
                T result = caseNewClassInjectionComposite(newClassInjectionComposite);
                if (result == null) result = caseINewClassInjection(newClassInjectionComposite);
                if (result == null) result = caseElementCreationInjection(newClassInjectionComposite);
                if (result == null) result = caseInjectionElement(newClassInjectionComposite);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.INEW_CLASS_INJECTION:
            {
                INewClassInjection iNewClassInjection = (INewClassInjection)theEObject;
                T result = caseINewClassInjection(iNewClassInjection);
                if (result == null) result = caseInjectionElement(iNewClassInjection);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.STEREOTPYE_APPLICABLE_INJECTION:
            {
                StereotpyeApplicableInjection stereotpyeApplicableInjection = (StereotpyeApplicableInjection)theEObject;
                T result = caseStereotpyeApplicableInjection(stereotpyeApplicableInjection);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.COLUMN_MATCH_ELEMENT:
            {
                ColumnMatchElement columnMatchElement = (ColumnMatchElement)theEObject;
                T result = caseColumnMatchElement(columnMatchElement);
                if (result == null) result = caseLinkedElement(columnMatchElement);
                if (result == null) result = caseColumnElement(columnMatchElement);
                if (result == null) result = caseDynamicElement(columnMatchElement);
                if (result == null) result = caseRegExMatchingElement(columnMatchElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.REG_EX_MATCHING_ELEMENT:
            {
                RegExMatchingElement regExMatchingElement = (RegExMatchingElement)theEObject;
                T result = caseRegExMatchingElement(regExMatchingElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.INSTANCE_CREATION_INJECTION:
            {
                InstanceCreationInjection instanceCreationInjection = (InstanceCreationInjection)theEObject;
                T result = caseInstanceCreationInjection(instanceCreationInjection);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE:
            {
                ColumnMatchAttribute columnMatchAttribute = (ColumnMatchAttribute)theEObject;
                T result = caseColumnMatchAttribute(columnMatchAttribute);
                if (result == null) result = caseColumnElement(columnMatchAttribute);
                if (result == null) result = caseAttribute(columnMatchAttribute);
                if (result == null) result = caseRegExMatchingElement(columnMatchAttribute);
                if (result == null) result = caseDynamicElement(columnMatchAttribute);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.COLUMN_ELEMENT:
            {
                ColumnElement columnElement = (ColumnElement)theEObject;
                T result = caseColumnElement(columnElement);
                if (result == null) result = caseRegExMatchingElement(columnElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.ELEMENT_CREATION_INJECTION:
            {
                ElementCreationInjection elementCreationInjection = (ElementCreationInjection)theEObject;
                T result = caseElementCreationInjection(elementCreationInjection);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.TEXT_FORMATTER:
            {
                TextFormatter textFormatter = (TextFormatter)theEObject;
                T result = caseTextFormatter(textFormatter);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Doc2modelMappingPackage.GROUP_ELEMENT:
            {
                GroupElement groupElement = (GroupElement)theEObject;
                T result = caseGroupElement(groupElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>doc2model</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>doc2model</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casedoc2model(doc2model object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Linked Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Linked Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLinkedElement(LinkedElement object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Doc Style</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Doc Style</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDocStyle(DocStyle object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Hierarchy</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Hierarchy</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseHierarchy(Hierarchy object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attribute Tag</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attribute Tag</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAttributeTag(AttributeTag object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Tag Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tag Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTagElement(TagElement object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Tag Attribute</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tag Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTagAttribute(TagAttribute object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Dynamic Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Dynamic Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDynamicElement(DynamicElement object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Style Attribute</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Style Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStyleAttribute(StyleAttribute object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAttribute(Attribute object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Injection Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Injection Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInjectionElement(InjectionElement object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>New Class Injection</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>New Class Injection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNewClassInjection(NewClassInjection object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Composition Injection</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Composition Injection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCompositionInjection(CompositionInjection object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attribute Injection</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attribute Injection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAttributeInjection(AttributeInjection object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Dependant Injection</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Dependant Injection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDependantInjection(DependantInjection object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Reference Injection</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Reference Injection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseReferenceInjection(ReferenceInjection object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Reg Ex Attribute</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Reg Ex Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRegExAttribute(RegExAttribute object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Reg Ex</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Reg Ex</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRegEx(RegEx object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>New Class Injection Composite</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>New Class Injection Composite</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNewClassInjectionComposite(NewClassInjectionComposite object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>INew Class Injection</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>INew Class Injection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseINewClassInjection(INewClassInjection object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Stereotpye Applicable Injection</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Stereotpye Applicable Injection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStereotpyeApplicableInjection(StereotpyeApplicableInjection object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Column Match Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Column Match Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseColumnMatchElement(ColumnMatchElement object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Reg Ex Matching Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Reg Ex Matching Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRegExMatchingElement(RegExMatchingElement object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Instance Creation Injection</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Instance Creation Injection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInstanceCreationInjection(InstanceCreationInjection object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Column Match Attribute</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Column Match Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseColumnMatchAttribute(ColumnMatchAttribute object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Column Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Column Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseColumnElement(ColumnElement object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Element Creation Injection</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Element Creation Injection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseElementCreationInjection(ElementCreationInjection object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Text Formatter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Text Formatter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTextFormatter(TextFormatter object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Group Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Group Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGroupElement(GroupElement object)
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T defaultCase(EObject object)
    {
        return null;
    }

} //Doc2modelMappingSwitch
