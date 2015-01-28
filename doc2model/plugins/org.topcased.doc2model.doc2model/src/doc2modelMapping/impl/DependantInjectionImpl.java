/**
 * <copyright>
 * </copyright>
 *
 * $Id: DependantInjectionImpl.java,v 1.3 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.DependantInjection;
import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.ElementCreationInjection;
import doc2modelMapping.INewClassInjection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependant Injection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.DependantInjectionImpl#getDependsWith <em>Depends With</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DependantInjectionImpl extends InjectionElementImpl implements DependantInjection
{
    /**
     * The cached value of the '{@link #getDependsWith() <em>Depends With</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDependsWith()
     * @generated
     * @ordered
     */
    protected ElementCreationInjection dependsWith;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DependantInjectionImpl()
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
        return Doc2modelMappingPackage.Literals.DEPENDANT_INJECTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ElementCreationInjection getDependsWith()
    {
        if (dependsWith != null && dependsWith.eIsProxy())
        {
            InternalEObject oldDependsWith = (InternalEObject)dependsWith;
            dependsWith = (ElementCreationInjection)eResolveProxy(oldDependsWith);
            if (dependsWith != oldDependsWith)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Doc2modelMappingPackage.DEPENDANT_INJECTION__DEPENDS_WITH, oldDependsWith, dependsWith));
            }
        }
        return dependsWith;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ElementCreationInjection basicGetDependsWith()
    {
        return dependsWith;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDependsWith(ElementCreationInjection newDependsWith)
    {
        ElementCreationInjection oldDependsWith = dependsWith;
        dependsWith = newDependsWith;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.DEPENDANT_INJECTION__DEPENDS_WITH, oldDependsWith, dependsWith));
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
            case Doc2modelMappingPackage.DEPENDANT_INJECTION__DEPENDS_WITH:
                if (resolve) return getDependsWith();
                return basicGetDependsWith();
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
            case Doc2modelMappingPackage.DEPENDANT_INJECTION__DEPENDS_WITH:
                setDependsWith((ElementCreationInjection)newValue);
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
            case Doc2modelMappingPackage.DEPENDANT_INJECTION__DEPENDS_WITH:
                setDependsWith((ElementCreationInjection)null);
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
            case Doc2modelMappingPackage.DEPENDANT_INJECTION__DEPENDS_WITH:
                return dependsWith != null;
        }
        return super.eIsSet(featureID);
    }

} //DependantInjectionImpl
