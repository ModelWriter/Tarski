/**
 * <copyright>
 * </copyright>
 *
 * $Id: ReferenceInjectionImpl.java,v 1.5 2009/05/18 07:47:02 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.ReferenceInjection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Injection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.ReferenceInjectionImpl#getAttributeToFind <em>Attribute To Find</em>}</li>
 *   <li>{@link doc2modelMapping.impl.ReferenceInjectionImpl#getClassReferenced <em>Class Referenced</em>}</li>
 *   <li>{@link doc2modelMapping.impl.ReferenceInjectionImpl#getReferenceAttribute <em>Reference Attribute</em>}</li>
 *   <li>{@link doc2modelMapping.impl.ReferenceInjectionImpl#isIsStereotypeReference <em>Is Stereotype Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceInjectionImpl extends DependantInjectionImpl implements ReferenceInjection
{
    /**
     * The default value of the '{@link #getAttributeToFind() <em>Attribute To Find</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttributeToFind()
     * @generated
     * @ordered
     */
    protected static final String ATTRIBUTE_TO_FIND_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAttributeToFind() <em>Attribute To Find</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttributeToFind()
     * @generated
     * @ordered
     */
    protected String attributeToFind = ATTRIBUTE_TO_FIND_EDEFAULT;

    /**
     * The default value of the '{@link #getClassReferenced() <em>Class Referenced</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getClassReferenced()
     * @generated
     * @ordered
     */
    protected static final String CLASS_REFERENCED_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getClassReferenced() <em>Class Referenced</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getClassReferenced()
     * @generated
     * @ordered
     */
    protected String classReferenced = CLASS_REFERENCED_EDEFAULT;

    /**
     * The default value of the '{@link #getReferenceAttribute() <em>Reference Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReferenceAttribute()
     * @generated
     * @ordered
     */
    protected static final String REFERENCE_ATTRIBUTE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getReferenceAttribute() <em>Reference Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReferenceAttribute()
     * @generated
     * @ordered
     */
    protected String referenceAttribute = REFERENCE_ATTRIBUTE_EDEFAULT;

    /**
     * The default value of the '{@link #isIsStereotypeReference() <em>Is Stereotype Reference</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsStereotypeReference()
     * @generated
     * @ordered
     */
    protected static final boolean IS_STEREOTYPE_REFERENCE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIsStereotypeReference() <em>Is Stereotype Reference</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsStereotypeReference()
     * @generated
     * @ordered
     */
    protected boolean isStereotypeReference = IS_STEREOTYPE_REFERENCE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ReferenceInjectionImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass()
    {
        return Doc2modelMappingPackage.Literals.REFERENCE_INJECTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAttributeToFind()
    {
        return attributeToFind;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAttributeToFind(String newAttributeToFind)
    {
        String oldAttributeToFind = attributeToFind;
        attributeToFind = newAttributeToFind;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.REFERENCE_INJECTION__ATTRIBUTE_TO_FIND, oldAttributeToFind, attributeToFind));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getClassReferenced()
    {
        return classReferenced;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setClassReferenced(String newClassReferenced)
    {
        String oldClassReferenced = classReferenced;
        classReferenced = newClassReferenced;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.REFERENCE_INJECTION__CLASS_REFERENCED, oldClassReferenced, classReferenced));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getReferenceAttribute()
    {
        return referenceAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReferenceAttribute(String newReferenceAttribute)
    {
        String oldReferenceAttribute = referenceAttribute;
        referenceAttribute = newReferenceAttribute;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.REFERENCE_INJECTION__REFERENCE_ATTRIBUTE, oldReferenceAttribute, referenceAttribute));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIsStereotypeReference()
    {
        return isStereotypeReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIsStereotypeReference(boolean newIsStereotypeReference)
    {
        boolean oldIsStereotypeReference = isStereotypeReference;
        isStereotypeReference = newIsStereotypeReference;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.REFERENCE_INJECTION__IS_STEREOTYPE_REFERENCE, oldIsStereotypeReference, isStereotypeReference));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType)
    {
        switch (featureID)
        {
            case Doc2modelMappingPackage.REFERENCE_INJECTION__ATTRIBUTE_TO_FIND:
                return getAttributeToFind();
            case Doc2modelMappingPackage.REFERENCE_INJECTION__CLASS_REFERENCED:
                return getClassReferenced();
            case Doc2modelMappingPackage.REFERENCE_INJECTION__REFERENCE_ATTRIBUTE:
                return getReferenceAttribute();
            case Doc2modelMappingPackage.REFERENCE_INJECTION__IS_STEREOTYPE_REFERENCE:
                return isIsStereotypeReference() ? Boolean.TRUE : Boolean.FALSE;
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case Doc2modelMappingPackage.REFERENCE_INJECTION__ATTRIBUTE_TO_FIND:
                setAttributeToFind((String)newValue);
                return;
            case Doc2modelMappingPackage.REFERENCE_INJECTION__CLASS_REFERENCED:
                setClassReferenced((String)newValue);
                return;
            case Doc2modelMappingPackage.REFERENCE_INJECTION__REFERENCE_ATTRIBUTE:
                setReferenceAttribute((String)newValue);
                return;
            case Doc2modelMappingPackage.REFERENCE_INJECTION__IS_STEREOTYPE_REFERENCE:
                setIsStereotypeReference(((Boolean)newValue).booleanValue());
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID)
    {
        switch (featureID)
        {
            case Doc2modelMappingPackage.REFERENCE_INJECTION__ATTRIBUTE_TO_FIND:
                setAttributeToFind(ATTRIBUTE_TO_FIND_EDEFAULT);
                return;
            case Doc2modelMappingPackage.REFERENCE_INJECTION__CLASS_REFERENCED:
                setClassReferenced(CLASS_REFERENCED_EDEFAULT);
                return;
            case Doc2modelMappingPackage.REFERENCE_INJECTION__REFERENCE_ATTRIBUTE:
                setReferenceAttribute(REFERENCE_ATTRIBUTE_EDEFAULT);
                return;
            case Doc2modelMappingPackage.REFERENCE_INJECTION__IS_STEREOTYPE_REFERENCE:
                setIsStereotypeReference(IS_STEREOTYPE_REFERENCE_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case Doc2modelMappingPackage.REFERENCE_INJECTION__ATTRIBUTE_TO_FIND:
                return ATTRIBUTE_TO_FIND_EDEFAULT == null ? attributeToFind != null : !ATTRIBUTE_TO_FIND_EDEFAULT.equals(attributeToFind);
            case Doc2modelMappingPackage.REFERENCE_INJECTION__CLASS_REFERENCED:
                return CLASS_REFERENCED_EDEFAULT == null ? classReferenced != null : !CLASS_REFERENCED_EDEFAULT.equals(classReferenced);
            case Doc2modelMappingPackage.REFERENCE_INJECTION__REFERENCE_ATTRIBUTE:
                return REFERENCE_ATTRIBUTE_EDEFAULT == null ? referenceAttribute != null : !REFERENCE_ATTRIBUTE_EDEFAULT.equals(referenceAttribute);
            case Doc2modelMappingPackage.REFERENCE_INJECTION__IS_STEREOTYPE_REFERENCE:
                return isStereotypeReference != IS_STEREOTYPE_REFERENCE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString()
    {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (attributeToFind: ");
        result.append(attributeToFind);
        result.append(", classReferenced: ");
        result.append(classReferenced);
        result.append(", referenceAttribute: ");
        result.append(referenceAttribute);
        result.append(", isStereotypeReference: ");
        result.append(isStereotypeReference);
        result.append(')');
        return result.toString();
    }

} //ReferenceInjectionImpl
