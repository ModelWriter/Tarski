/**
 * <copyright>
 * </copyright>
 *
 * $Id: InstanceCreationInjectionImpl.java,v 1.1 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.InstanceCreationInjection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Creation Injection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.InstanceCreationInjectionImpl#getSpecificNamespaceURI <em>Specific Namespace URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InstanceCreationInjectionImpl extends EObjectImpl implements InstanceCreationInjection
{
    /**
     * The default value of the '{@link #getSpecificNamespaceURI() <em>Specific Namespace URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSpecificNamespaceURI()
     * @generated
     * @ordered
     */
    protected static final String SPECIFIC_NAMESPACE_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSpecificNamespaceURI() <em>Specific Namespace URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSpecificNamespaceURI()
     * @generated
     * @ordered
     */
    protected String specificNamespaceURI = SPECIFIC_NAMESPACE_URI_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected InstanceCreationInjectionImpl()
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
        return Doc2modelMappingPackage.Literals.INSTANCE_CREATION_INJECTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSpecificNamespaceURI()
    {
        return specificNamespaceURI;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSpecificNamespaceURI(String newSpecificNamespaceURI)
    {
        String oldSpecificNamespaceURI = specificNamespaceURI;
        specificNamespaceURI = newSpecificNamespaceURI;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.INSTANCE_CREATION_INJECTION__SPECIFIC_NAMESPACE_URI, oldSpecificNamespaceURI, specificNamespaceURI));
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
            case Doc2modelMappingPackage.INSTANCE_CREATION_INJECTION__SPECIFIC_NAMESPACE_URI:
                return getSpecificNamespaceURI();
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
            case Doc2modelMappingPackage.INSTANCE_CREATION_INJECTION__SPECIFIC_NAMESPACE_URI:
                setSpecificNamespaceURI((String)newValue);
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
            case Doc2modelMappingPackage.INSTANCE_CREATION_INJECTION__SPECIFIC_NAMESPACE_URI:
                setSpecificNamespaceURI(SPECIFIC_NAMESPACE_URI_EDEFAULT);
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
            case Doc2modelMappingPackage.INSTANCE_CREATION_INJECTION__SPECIFIC_NAMESPACE_URI:
                return SPECIFIC_NAMESPACE_URI_EDEFAULT == null ? specificNamespaceURI != null : !SPECIFIC_NAMESPACE_URI_EDEFAULT.equals(specificNamespaceURI);
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
        result.append(" (specificNamespaceURI: ");
        result.append(specificNamespaceURI);
        result.append(')');
        return result.toString();
    }

} //InstanceCreationInjectionImpl
