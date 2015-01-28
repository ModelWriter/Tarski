/**
 * <copyright>
 * </copyright>
 *
 * $Id: HierarchyImpl.java,v 1.4 2009/05/15 13:13:32 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.Hierarchy;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hierarchy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.HierarchyImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link doc2modelMapping.impl.HierarchyImpl#getSubHierarchy <em>Sub Hierarchy</em>}</li>
 *   <li>{@link doc2modelMapping.impl.HierarchyImpl#getStyleValue <em>Style Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HierarchyImpl extends DynamicElementImpl implements Hierarchy
{
    /**
     * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLevel()
     * @generated
     * @ordered
     */
    protected static final String LEVEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLevel()
     * @generated
     * @ordered
     */
    protected String level = LEVEL_EDEFAULT;

    /**
     * The cached value of the '{@link #getSubHierarchy() <em>Sub Hierarchy</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSubHierarchy()
     * @generated
     * @ordered
     */
    protected Hierarchy subHierarchy;

    /**
     * The cached value of the '{@link #getStyleValue() <em>Style Value</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStyleValue()
     * @generated
     * @ordered
     */
    protected EList<String> styleValue;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected HierarchyImpl()
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
        return Doc2modelMappingPackage.Literals.HIERARCHY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLevel()
    {
        return level;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLevel(String newLevel)
    {
        String oldLevel = level;
        level = newLevel;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.HIERARCHY__LEVEL, oldLevel, level));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Hierarchy getSubHierarchy()
    {
        return subHierarchy;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSubHierarchy(Hierarchy newSubHierarchy, NotificationChain msgs)
    {
        Hierarchy oldSubHierarchy = subHierarchy;
        subHierarchy = newSubHierarchy;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.HIERARCHY__SUB_HIERARCHY, oldSubHierarchy, newSubHierarchy);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSubHierarchy(Hierarchy newSubHierarchy)
    {
        if (newSubHierarchy != subHierarchy)
        {
            NotificationChain msgs = null;
            if (subHierarchy != null)
                msgs = ((InternalEObject)subHierarchy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Doc2modelMappingPackage.HIERARCHY__SUB_HIERARCHY, null, msgs);
            if (newSubHierarchy != null)
                msgs = ((InternalEObject)newSubHierarchy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Doc2modelMappingPackage.HIERARCHY__SUB_HIERARCHY, null, msgs);
            msgs = basicSetSubHierarchy(newSubHierarchy, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.HIERARCHY__SUB_HIERARCHY, newSubHierarchy, newSubHierarchy));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getStyleValue()
    {
        if (styleValue == null)
        {
            styleValue = new EDataTypeUniqueEList<String>(String.class, this, Doc2modelMappingPackage.HIERARCHY__STYLE_VALUE);
        }
        return styleValue;
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
            case Doc2modelMappingPackage.HIERARCHY__SUB_HIERARCHY:
                return basicSetSubHierarchy(null, msgs);
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
            case Doc2modelMappingPackage.HIERARCHY__LEVEL:
                return getLevel();
            case Doc2modelMappingPackage.HIERARCHY__SUB_HIERARCHY:
                return getSubHierarchy();
            case Doc2modelMappingPackage.HIERARCHY__STYLE_VALUE:
                return getStyleValue();
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
            case Doc2modelMappingPackage.HIERARCHY__LEVEL:
                setLevel((String)newValue);
                return;
            case Doc2modelMappingPackage.HIERARCHY__SUB_HIERARCHY:
                setSubHierarchy((Hierarchy)newValue);
                return;
            case Doc2modelMappingPackage.HIERARCHY__STYLE_VALUE:
                getStyleValue().clear();
                getStyleValue().addAll((Collection<? extends String>)newValue);
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
            case Doc2modelMappingPackage.HIERARCHY__LEVEL:
                setLevel(LEVEL_EDEFAULT);
                return;
            case Doc2modelMappingPackage.HIERARCHY__SUB_HIERARCHY:
                setSubHierarchy((Hierarchy)null);
                return;
            case Doc2modelMappingPackage.HIERARCHY__STYLE_VALUE:
                getStyleValue().clear();
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
            case Doc2modelMappingPackage.HIERARCHY__LEVEL:
                return LEVEL_EDEFAULT == null ? level != null : !LEVEL_EDEFAULT.equals(level);
            case Doc2modelMappingPackage.HIERARCHY__SUB_HIERARCHY:
                return subHierarchy != null;
            case Doc2modelMappingPackage.HIERARCHY__STYLE_VALUE:
                return styleValue != null && !styleValue.isEmpty();
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
        result.append(" (level: ");
        result.append(level);
        result.append(", styleValue: ");
        result.append(styleValue);
        result.append(')');
        return result.toString();
    }

} //HierarchyImpl
