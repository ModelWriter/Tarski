/**
 * <copyright>
 * </copyright>
 *
 * $Id: AttributeInjectionImpl.java,v 1.4 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.AttributeInjection;
import doc2modelMapping.Doc2modelMappingPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Injection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.AttributeInjectionImpl#getInstanceAttribute <em>Instance Attribute</em>}</li>
 *   <li>{@link doc2modelMapping.impl.AttributeInjectionImpl#getStereotypeAttribute <em>Stereotype Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeInjectionImpl extends DependantInjectionImpl implements AttributeInjection
{
    /**
     * The default value of the '{@link #getInstanceAttribute() <em>Instance Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstanceAttribute()
     * @generated
     * @ordered
     */
    protected static final String INSTANCE_ATTRIBUTE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getInstanceAttribute() <em>Instance Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstanceAttribute()
     * @generated
     * @ordered
     */
    protected String instanceAttribute = INSTANCE_ATTRIBUTE_EDEFAULT;

    /**
     * The default value of the '{@link #getStereotypeAttribute() <em>Stereotype Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStereotypeAttribute()
     * @generated
     * @ordered
     */
    protected static final String STEREOTYPE_ATTRIBUTE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getStereotypeAttribute() <em>Stereotype Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStereotypeAttribute()
     * @generated
     * @ordered
     */
    protected String stereotypeAttribute = STEREOTYPE_ATTRIBUTE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AttributeInjectionImpl()
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
        return Doc2modelMappingPackage.Literals.ATTRIBUTE_INJECTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getInstanceAttribute()
    {
        return instanceAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInstanceAttribute(String newInstanceAttribute)
    {
        String oldInstanceAttribute = instanceAttribute;
        instanceAttribute = newInstanceAttribute;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.ATTRIBUTE_INJECTION__INSTANCE_ATTRIBUTE, oldInstanceAttribute, instanceAttribute));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getStereotypeAttribute()
    {
        return stereotypeAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStereotypeAttribute(String newStereotypeAttribute)
    {
        String oldStereotypeAttribute = stereotypeAttribute;
        stereotypeAttribute = newStereotypeAttribute;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.ATTRIBUTE_INJECTION__STEREOTYPE_ATTRIBUTE, oldStereotypeAttribute, stereotypeAttribute));
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
            case Doc2modelMappingPackage.ATTRIBUTE_INJECTION__INSTANCE_ATTRIBUTE:
                return getInstanceAttribute();
            case Doc2modelMappingPackage.ATTRIBUTE_INJECTION__STEREOTYPE_ATTRIBUTE:
                return getStereotypeAttribute();
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
            case Doc2modelMappingPackage.ATTRIBUTE_INJECTION__INSTANCE_ATTRIBUTE:
                setInstanceAttribute((String)newValue);
                return;
            case Doc2modelMappingPackage.ATTRIBUTE_INJECTION__STEREOTYPE_ATTRIBUTE:
                setStereotypeAttribute((String)newValue);
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
            case Doc2modelMappingPackage.ATTRIBUTE_INJECTION__INSTANCE_ATTRIBUTE:
                setInstanceAttribute(INSTANCE_ATTRIBUTE_EDEFAULT);
                return;
            case Doc2modelMappingPackage.ATTRIBUTE_INJECTION__STEREOTYPE_ATTRIBUTE:
                setStereotypeAttribute(STEREOTYPE_ATTRIBUTE_EDEFAULT);
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
            case Doc2modelMappingPackage.ATTRIBUTE_INJECTION__INSTANCE_ATTRIBUTE:
                return INSTANCE_ATTRIBUTE_EDEFAULT == null ? instanceAttribute != null : !INSTANCE_ATTRIBUTE_EDEFAULT.equals(instanceAttribute);
            case Doc2modelMappingPackage.ATTRIBUTE_INJECTION__STEREOTYPE_ATTRIBUTE:
                return STEREOTYPE_ATTRIBUTE_EDEFAULT == null ? stereotypeAttribute != null : !STEREOTYPE_ATTRIBUTE_EDEFAULT.equals(stereotypeAttribute);
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
        result.append(" (instanceAttribute: ");
        result.append(instanceAttribute);
        result.append(", stereotypeAttribute: ");
        result.append(stereotypeAttribute);
        result.append(')');
        return result.toString();
    }

} //AttributeInjectionImpl
