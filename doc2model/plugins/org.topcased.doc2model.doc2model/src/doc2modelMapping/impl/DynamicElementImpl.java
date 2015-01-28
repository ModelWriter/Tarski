/**
 * <copyright>
 * </copyright>
 *
 * $Id: DynamicElementImpl.java,v 1.3 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.DynamicElement;
import doc2modelMapping.InjectionElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dynamic Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.DynamicElementImpl#getInjection <em>Injection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DynamicElementImpl extends EObjectImpl implements DynamicElement
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DynamicElementImpl()
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
        return Doc2modelMappingPackage.Literals.DYNAMIC_ELEMENT;
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.DYNAMIC_ELEMENT__INJECTION, oldInjection, newInjection);
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
                msgs = ((InternalEObject)injection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Doc2modelMappingPackage.DYNAMIC_ELEMENT__INJECTION, null, msgs);
            if (newInjection != null)
                msgs = ((InternalEObject)newInjection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Doc2modelMappingPackage.DYNAMIC_ELEMENT__INJECTION, null, msgs);
            msgs = basicSetInjection(newInjection, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.DYNAMIC_ELEMENT__INJECTION, newInjection, newInjection));
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
            case Doc2modelMappingPackage.DYNAMIC_ELEMENT__INJECTION:
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
            case Doc2modelMappingPackage.DYNAMIC_ELEMENT__INJECTION:
                return getInjection();
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
            case Doc2modelMappingPackage.DYNAMIC_ELEMENT__INJECTION:
                setInjection((InjectionElement)newValue);
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
            case Doc2modelMappingPackage.DYNAMIC_ELEMENT__INJECTION:
                setInjection((InjectionElement)null);
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
            case Doc2modelMappingPackage.DYNAMIC_ELEMENT__INJECTION:
                return injection != null;
        }
        return super.eIsSet(featureID);
    }

} //DynamicElementImpl
