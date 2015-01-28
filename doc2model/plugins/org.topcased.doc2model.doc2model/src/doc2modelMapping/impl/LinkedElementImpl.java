/**
 * <copyright>
 * </copyright>
 *
 * $Id: LinkedElementImpl.java,v 1.3 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.Attribute;
import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.Hierarchy;
import doc2modelMapping.LinkedElement;
import doc2modelMapping.doc2model;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Linked Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.LinkedElementImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link doc2modelMapping.impl.LinkedElementImpl#getMax <em>Max</em>}</li>
 *   <li>{@link doc2modelMapping.impl.LinkedElementImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LinkedElementImpl extends DynamicElementImpl implements LinkedElement
{
    /**
     * The cached value of the '{@link #getMax() <em>Max</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMax()
     * @generated
     * @ordered
     */
    protected Hierarchy max;

    /**
     * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttributes()
     * @generated
     * @ordered
     */
    protected EList<Attribute> attributes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LinkedElementImpl()
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
        return Doc2modelMappingPackage.Literals.LINKED_ELEMENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public doc2model getOwner()
    {
        if (eContainerFeatureID != Doc2modelMappingPackage.LINKED_ELEMENT__OWNER) return null;
        return (doc2model)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOwner(doc2model newOwner, NotificationChain msgs)
    {
        msgs = eBasicSetContainer((InternalEObject)newOwner, Doc2modelMappingPackage.LINKED_ELEMENT__OWNER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOwner(doc2model newOwner)
    {
        if (newOwner != eInternalContainer() || (eContainerFeatureID != Doc2modelMappingPackage.LINKED_ELEMENT__OWNER && newOwner != null))
        {
            if (EcoreUtil.isAncestor(this, newOwner))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOwner != null)
                msgs = ((InternalEObject)newOwner).eInverseAdd(this, Doc2modelMappingPackage.DOC2MODEL__LINKS, doc2model.class, msgs);
            msgs = basicSetOwner(newOwner, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.LINKED_ELEMENT__OWNER, newOwner, newOwner));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Hierarchy getMax()
    {
        if (max != null && max.eIsProxy())
        {
            InternalEObject oldMax = (InternalEObject)max;
            max = (Hierarchy)eResolveProxy(oldMax);
            if (max != oldMax)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Doc2modelMappingPackage.LINKED_ELEMENT__MAX, oldMax, max));
            }
        }
        return max;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Hierarchy basicGetMax()
    {
        return max;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMax(Hierarchy newMax)
    {
        Hierarchy oldMax = max;
        max = newMax;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.LINKED_ELEMENT__MAX, oldMax, max));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Attribute> getAttributes()
    {
        if (attributes == null)
        {
            attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, Doc2modelMappingPackage.LINKED_ELEMENT__ATTRIBUTES);
        }
        return attributes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case Doc2modelMappingPackage.LINKED_ELEMENT__OWNER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOwner((doc2model)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
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
            case Doc2modelMappingPackage.LINKED_ELEMENT__OWNER:
                return basicSetOwner(null, msgs);
            case Doc2modelMappingPackage.LINKED_ELEMENT__ATTRIBUTES:
                return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
    {
        switch (eContainerFeatureID)
        {
            case Doc2modelMappingPackage.LINKED_ELEMENT__OWNER:
                return eInternalContainer().eInverseRemove(this, Doc2modelMappingPackage.DOC2MODEL__LINKS, doc2model.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
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
            case Doc2modelMappingPackage.LINKED_ELEMENT__OWNER:
                return getOwner();
            case Doc2modelMappingPackage.LINKED_ELEMENT__MAX:
                if (resolve) return getMax();
                return basicGetMax();
            case Doc2modelMappingPackage.LINKED_ELEMENT__ATTRIBUTES:
                return getAttributes();
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
            case Doc2modelMappingPackage.LINKED_ELEMENT__OWNER:
                setOwner((doc2model)newValue);
                return;
            case Doc2modelMappingPackage.LINKED_ELEMENT__MAX:
                setMax((Hierarchy)newValue);
                return;
            case Doc2modelMappingPackage.LINKED_ELEMENT__ATTRIBUTES:
                getAttributes().clear();
                getAttributes().addAll((Collection<? extends Attribute>)newValue);
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
            case Doc2modelMappingPackage.LINKED_ELEMENT__OWNER:
                setOwner((doc2model)null);
                return;
            case Doc2modelMappingPackage.LINKED_ELEMENT__MAX:
                setMax((Hierarchy)null);
                return;
            case Doc2modelMappingPackage.LINKED_ELEMENT__ATTRIBUTES:
                getAttributes().clear();
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
            case Doc2modelMappingPackage.LINKED_ELEMENT__OWNER:
                return getOwner() != null;
            case Doc2modelMappingPackage.LINKED_ELEMENT__MAX:
                return max != null;
            case Doc2modelMappingPackage.LINKED_ELEMENT__ATTRIBUTES:
                return attributes != null && !attributes.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //LinkedElementImpl
