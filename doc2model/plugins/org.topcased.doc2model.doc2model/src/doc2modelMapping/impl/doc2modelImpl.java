/**
 * <copyright>
 * </copyright>
 *
 * $Id: doc2modelImpl.java,v 1.4 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping.impl;

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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>doc2model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.doc2modelImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link doc2modelMapping.impl.doc2modelImpl#getHierarchy <em>Hierarchy</em>}</li>
 *   <li>{@link doc2modelMapping.impl.doc2modelImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link doc2modelMapping.impl.doc2modelImpl#getMetamodelURI <em>Metamodel URI</em>}</li>
 *   <li>{@link doc2modelMapping.impl.doc2modelImpl#getProfileURI <em>Profile URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class doc2modelImpl extends DynamicElementImpl implements doc2model
{
    /**
     * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLinks()
     * @generated
     * @ordered
     */
    protected EList<LinkedElement> links;

    /**
     * The cached value of the '{@link #getHierarchy() <em>Hierarchy</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHierarchy()
     * @generated
     * @ordered
     */
    protected Hierarchy hierarchy;

    /**
     * The default value of the '{@link #getExtension() <em>Extension</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExtension()
     * @generated
     * @ordered
     */
    protected static final String EXTENSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExtension() <em>Extension</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExtension()
     * @generated
     * @ordered
     */
    protected String extension = EXTENSION_EDEFAULT;

    /**
     * The default value of the '{@link #getMetamodelURI() <em>Metamodel URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMetamodelURI()
     * @generated
     * @ordered
     */
    protected static final String METAMODEL_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMetamodelURI() <em>Metamodel URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMetamodelURI()
     * @generated
     * @ordered
     */
    protected String metamodelURI = METAMODEL_URI_EDEFAULT;

    /**
     * The default value of the '{@link #getProfileURI() <em>Profile URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProfileURI()
     * @generated
     * @ordered
     */
    protected static final String PROFILE_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getProfileURI() <em>Profile URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProfileURI()
     * @generated
     * @ordered
     */
    protected String profileURI = PROFILE_URI_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected doc2modelImpl()
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
        return Doc2modelMappingPackage.Literals.DOC2MODEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<LinkedElement> getLinks()
    {
        if (links == null)
        {
            links = new EObjectContainmentWithInverseEList<LinkedElement>(LinkedElement.class, this, Doc2modelMappingPackage.DOC2MODEL__LINKS, Doc2modelMappingPackage.LINKED_ELEMENT__OWNER);
        }
        return links;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Hierarchy getHierarchy()
    {
        return hierarchy;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetHierarchy(Hierarchy newHierarchy, NotificationChain msgs)
    {
        Hierarchy oldHierarchy = hierarchy;
        hierarchy = newHierarchy;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.DOC2MODEL__HIERARCHY, oldHierarchy, newHierarchy);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHierarchy(Hierarchy newHierarchy)
    {
        if (newHierarchy != hierarchy)
        {
            NotificationChain msgs = null;
            if (hierarchy != null)
                msgs = ((InternalEObject)hierarchy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Doc2modelMappingPackage.DOC2MODEL__HIERARCHY, null, msgs);
            if (newHierarchy != null)
                msgs = ((InternalEObject)newHierarchy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Doc2modelMappingPackage.DOC2MODEL__HIERARCHY, null, msgs);
            msgs = basicSetHierarchy(newHierarchy, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.DOC2MODEL__HIERARCHY, newHierarchy, newHierarchy));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExtension()
    {
        return extension;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExtension(String newExtension)
    {
        String oldExtension = extension;
        extension = newExtension;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.DOC2MODEL__EXTENSION, oldExtension, extension));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getMetamodelURI()
    {
        return metamodelURI;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMetamodelURI(String newMetamodelURI)
    {
        String oldMetamodelURI = metamodelURI;
        metamodelURI = newMetamodelURI;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.DOC2MODEL__METAMODEL_URI, oldMetamodelURI, metamodelURI));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getProfileURI()
    {
        return profileURI;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProfileURI(String newProfileURI)
    {
        String oldProfileURI = profileURI;
        profileURI = newProfileURI;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.DOC2MODEL__PROFILE_URI, oldProfileURI, profileURI));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case Doc2modelMappingPackage.DOC2MODEL__LINKS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getLinks()).basicAdd(otherEnd, msgs);
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
            case Doc2modelMappingPackage.DOC2MODEL__LINKS:
                return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
            case Doc2modelMappingPackage.DOC2MODEL__HIERARCHY:
                return basicSetHierarchy(null, msgs);
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
            case Doc2modelMappingPackage.DOC2MODEL__LINKS:
                return getLinks();
            case Doc2modelMappingPackage.DOC2MODEL__HIERARCHY:
                return getHierarchy();
            case Doc2modelMappingPackage.DOC2MODEL__EXTENSION:
                return getExtension();
            case Doc2modelMappingPackage.DOC2MODEL__METAMODEL_URI:
                return getMetamodelURI();
            case Doc2modelMappingPackage.DOC2MODEL__PROFILE_URI:
                return getProfileURI();
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
            case Doc2modelMappingPackage.DOC2MODEL__LINKS:
                getLinks().clear();
                getLinks().addAll((Collection<? extends LinkedElement>)newValue);
                return;
            case Doc2modelMappingPackage.DOC2MODEL__HIERARCHY:
                setHierarchy((Hierarchy)newValue);
                return;
            case Doc2modelMappingPackage.DOC2MODEL__EXTENSION:
                setExtension((String)newValue);
                return;
            case Doc2modelMappingPackage.DOC2MODEL__METAMODEL_URI:
                setMetamodelURI((String)newValue);
                return;
            case Doc2modelMappingPackage.DOC2MODEL__PROFILE_URI:
                setProfileURI((String)newValue);
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
            case Doc2modelMappingPackage.DOC2MODEL__LINKS:
                getLinks().clear();
                return;
            case Doc2modelMappingPackage.DOC2MODEL__HIERARCHY:
                setHierarchy((Hierarchy)null);
                return;
            case Doc2modelMappingPackage.DOC2MODEL__EXTENSION:
                setExtension(EXTENSION_EDEFAULT);
                return;
            case Doc2modelMappingPackage.DOC2MODEL__METAMODEL_URI:
                setMetamodelURI(METAMODEL_URI_EDEFAULT);
                return;
            case Doc2modelMappingPackage.DOC2MODEL__PROFILE_URI:
                setProfileURI(PROFILE_URI_EDEFAULT);
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
            case Doc2modelMappingPackage.DOC2MODEL__LINKS:
                return links != null && !links.isEmpty();
            case Doc2modelMappingPackage.DOC2MODEL__HIERARCHY:
                return hierarchy != null;
            case Doc2modelMappingPackage.DOC2MODEL__EXTENSION:
                return EXTENSION_EDEFAULT == null ? extension != null : !EXTENSION_EDEFAULT.equals(extension);
            case Doc2modelMappingPackage.DOC2MODEL__METAMODEL_URI:
                return METAMODEL_URI_EDEFAULT == null ? metamodelURI != null : !METAMODEL_URI_EDEFAULT.equals(metamodelURI);
            case Doc2modelMappingPackage.DOC2MODEL__PROFILE_URI:
                return PROFILE_URI_EDEFAULT == null ? profileURI != null : !PROFILE_URI_EDEFAULT.equals(profileURI);
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
        result.append(" (extension: ");
        result.append(extension);
        result.append(", metamodelURI: ");
        result.append(metamodelURI);
        result.append(", profileURI: ");
        result.append(profileURI);
        result.append(')');
        return result.toString();
    }

} //doc2modelImpl
