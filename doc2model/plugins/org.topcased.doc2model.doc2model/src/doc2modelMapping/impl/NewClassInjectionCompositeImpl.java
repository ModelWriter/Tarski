/**
 * <copyright>
 * </copyright>
 *
 * $Id: NewClassInjectionCompositeImpl.java,v 1.2 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.NewClassInjection;
import doc2modelMapping.NewClassInjectionComposite;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Class Injection Composite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.NewClassInjectionCompositeImpl#getInjections <em>Injections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NewClassInjectionCompositeImpl extends INewClassInjectionImpl implements NewClassInjectionComposite
{
    /**
     * The cached value of the '{@link #getInjections() <em>Injections</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInjections()
     * @generated
     * @ordered
     */
    protected EList<NewClassInjection> injections;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected NewClassInjectionCompositeImpl()
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
        return Doc2modelMappingPackage.Literals.NEW_CLASS_INJECTION_COMPOSITE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<NewClassInjection> getInjections()
    {
        if (injections == null)
        {
            injections = new EObjectContainmentEList<NewClassInjection>(NewClassInjection.class, this, Doc2modelMappingPackage.NEW_CLASS_INJECTION_COMPOSITE__INJECTIONS);
        }
        return injections;
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
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION_COMPOSITE__INJECTIONS:
                return ((InternalEList<?>)getInjections()).basicRemove(otherEnd, msgs);
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
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION_COMPOSITE__INJECTIONS:
                return getInjections();
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
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION_COMPOSITE__INJECTIONS:
                getInjections().clear();
                getInjections().addAll((Collection<? extends NewClassInjection>)newValue);
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
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION_COMPOSITE__INJECTIONS:
                getInjections().clear();
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
            case Doc2modelMappingPackage.NEW_CLASS_INJECTION_COMPOSITE__INJECTIONS:
                return injections != null && !injections.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //NewClassInjectionCompositeImpl
