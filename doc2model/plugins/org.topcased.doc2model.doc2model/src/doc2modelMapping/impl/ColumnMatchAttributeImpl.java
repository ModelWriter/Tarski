/**
 * <copyright>
 * </copyright>
 *
 * $Id: ColumnMatchAttributeImpl.java,v 1.1 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.Attribute;
import doc2modelMapping.ColumnMatchAttribute;
import doc2modelMapping.DependantInjection;
import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.DynamicElement;
import doc2modelMapping.InjectionElement;
import java.util.Collection;
import doc2modelMapping.RegExMatchingElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column Match Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.ColumnMatchAttributeImpl#getInjection <em>Injection</em>}</li>
 *   <li>{@link doc2modelMapping.impl.ColumnMatchAttributeImpl#getAttributeValue <em>Attribute Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColumnMatchAttributeImpl extends ColumnElementImpl implements ColumnMatchAttribute
{
    /**
     * The cached value of the '{@link #getInjection() <em>Injection</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInjection()
     * @generated
     * @ordered
     */
    protected InjectionElement injection;

    /**
     * The default value of the '{@link #getAttributeValue() <em>Attribute Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttributeValue()
     * @generated
     * @ordered
     */
    protected static final String ATTRIBUTE_VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAttributeValue() <em>Attribute Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttributeValue()
     * @generated
     * @ordered
     */
    protected String attributeValue = ATTRIBUTE_VALUE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ColumnMatchAttributeImpl()
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
        return Doc2modelMappingPackage.Literals.COLUMN_MATCH_ATTRIBUTE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InjectionElement getInjection()
    {
        return injection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInjection(InjectionElement newInjection, NotificationChain msgs)
    {
        InjectionElement oldInjection = injection;
        injection = newInjection;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE__INJECTION, oldInjection, newInjection);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInjection(InjectionElement newInjection)
    {
        if (newInjection != injection)
        {
            NotificationChain msgs = null;
            if (injection != null)
                msgs = ((InternalEObject)injection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE__INJECTION, null, msgs);
            if (newInjection != null)
                msgs = ((InternalEObject)newInjection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE__INJECTION, null, msgs);
            msgs = basicSetInjection(newInjection, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE__INJECTION, newInjection, newInjection));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAttributeValue()
    {
        return attributeValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAttributeValue(String newAttributeValue)
    {
        String oldAttributeValue = attributeValue;
        attributeValue = newAttributeValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE__ATTRIBUTE_VALUE, oldAttributeValue, attributeValue));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE__INJECTION:
                return basicSetInjection(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
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
            case Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE__INJECTION:
                return getInjection();
            case Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE__ATTRIBUTE_VALUE:
                return getAttributeValue();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE__INJECTION:
                setInjection((InjectionElement)newValue);
                return;
            case Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE__ATTRIBUTE_VALUE:
                setAttributeValue((String)newValue);
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
            case Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE__INJECTION:
                setInjection((InjectionElement)null);
                return;
            case Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE__ATTRIBUTE_VALUE:
                setAttributeValue(ATTRIBUTE_VALUE_EDEFAULT);
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
            case Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE__INJECTION:
                return injection != null;
            case Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE__ATTRIBUTE_VALUE:
                return ATTRIBUTE_VALUE_EDEFAULT == null ? attributeValue != null : !ATTRIBUTE_VALUE_EDEFAULT.equals(attributeValue);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
    {
        if (baseClass == DynamicElement.class)
        {
            switch (derivedFeatureID)
            {
                case Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE__INJECTION: return Doc2modelMappingPackage.DYNAMIC_ELEMENT__INJECTION;
                default: return -1;
            }
        }
        if (baseClass == Attribute.class)
        {
            switch (derivedFeatureID)
            {
                case Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE__ATTRIBUTE_VALUE: return Doc2modelMappingPackage.ATTRIBUTE__ATTRIBUTE_VALUE;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
    {
        if (baseClass == DynamicElement.class)
        {
            switch (baseFeatureID)
            {
                case Doc2modelMappingPackage.DYNAMIC_ELEMENT__INJECTION: return Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE__INJECTION;
                default: return -1;
            }
        }
        if (baseClass == Attribute.class)
        {
            switch (baseFeatureID)
            {
                case Doc2modelMappingPackage.ATTRIBUTE__ATTRIBUTE_VALUE: return Doc2modelMappingPackage.COLUMN_MATCH_ATTRIBUTE__ATTRIBUTE_VALUE;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
        result.append(" (attributeValue: ");
        result.append(attributeValue);
        result.append(')');
        return result.toString();
    }

} //ColumnMatchAttributeImpl
