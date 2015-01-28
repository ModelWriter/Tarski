/**
 * <copyright>
 * </copyright>
 *
 * $Id: InjectionElementImpl.java,v 1.3 2009/05/11 06:38:57 tfaure Exp $
 */
package doc2modelMapping.impl;

import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.InjectionElement;

import doc2modelMapping.TextFormatter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Injection Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link doc2modelMapping.impl.InjectionElementImpl#getStringFormat <em>String Format</em>}</li>
 *   <li>{@link doc2modelMapping.impl.InjectionElementImpl#getStandardOptionalInjections <em>Standard Optional Injections</em>}</li>
 *   <li>{@link doc2modelMapping.impl.InjectionElementImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InjectionElementImpl extends EObjectImpl implements InjectionElement
{
    /**
     * The cached value of the '{@link #getStringFormat() <em>String Format</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStringFormat()
     * @generated
     * @ordered
     */
    protected TextFormatter stringFormat;

    /**
     * The cached value of the '{@link #getStandardOptionalInjections() <em>Standard Optional Injections</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStandardOptionalInjections()
     * @generated
     * @ordered
     */
    protected EList<InjectionElement> standardOptionalInjections;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = "noname";

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected InjectionElementImpl()
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
        return Doc2modelMappingPackage.Literals.INJECTION_ELEMENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TextFormatter getStringFormat()
    {
        return stringFormat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetStringFormat(TextFormatter newStringFormat, NotificationChain msgs)
    {
        TextFormatter oldStringFormat = stringFormat;
        stringFormat = newStringFormat;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.INJECTION_ELEMENT__STRING_FORMAT, oldStringFormat, newStringFormat);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStringFormat(TextFormatter newStringFormat)
    {
        if (newStringFormat != stringFormat)
        {
            NotificationChain msgs = null;
            if (stringFormat != null)
                msgs = ((InternalEObject)stringFormat).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Doc2modelMappingPackage.INJECTION_ELEMENT__STRING_FORMAT, null, msgs);
            if (newStringFormat != null)
                msgs = ((InternalEObject)newStringFormat).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Doc2modelMappingPackage.INJECTION_ELEMENT__STRING_FORMAT, null, msgs);
            msgs = basicSetStringFormat(newStringFormat, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.INJECTION_ELEMENT__STRING_FORMAT, newStringFormat, newStringFormat));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<InjectionElement> getStandardOptionalInjections()
    {
        if (standardOptionalInjections == null)
        {
            standardOptionalInjections = new EObjectContainmentEList<InjectionElement>(InjectionElement.class, this, Doc2modelMappingPackage.INJECTION_ELEMENT__STANDARD_OPTIONAL_INJECTIONS);
        }
        return standardOptionalInjections;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName)
    {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelMappingPackage.INJECTION_ELEMENT__NAME, oldName, name));
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
            case Doc2modelMappingPackage.INJECTION_ELEMENT__STRING_FORMAT:
                return basicSetStringFormat(null, msgs);
            case Doc2modelMappingPackage.INJECTION_ELEMENT__STANDARD_OPTIONAL_INJECTIONS:
                return ((InternalEList<?>)getStandardOptionalInjections()).basicRemove(otherEnd, msgs);
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
            case Doc2modelMappingPackage.INJECTION_ELEMENT__STRING_FORMAT:
                return getStringFormat();
            case Doc2modelMappingPackage.INJECTION_ELEMENT__STANDARD_OPTIONAL_INJECTIONS:
                return getStandardOptionalInjections();
            case Doc2modelMappingPackage.INJECTION_ELEMENT__NAME:
                return getName();
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
            case Doc2modelMappingPackage.INJECTION_ELEMENT__STRING_FORMAT:
                setStringFormat((TextFormatter)newValue);
                return;
            case Doc2modelMappingPackage.INJECTION_ELEMENT__STANDARD_OPTIONAL_INJECTIONS:
                getStandardOptionalInjections().clear();
                getStandardOptionalInjections().addAll((Collection<? extends InjectionElement>)newValue);
                return;
            case Doc2modelMappingPackage.INJECTION_ELEMENT__NAME:
                setName((String)newValue);
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
            case Doc2modelMappingPackage.INJECTION_ELEMENT__STRING_FORMAT:
                setStringFormat((TextFormatter)null);
                return;
            case Doc2modelMappingPackage.INJECTION_ELEMENT__STANDARD_OPTIONAL_INJECTIONS:
                getStandardOptionalInjections().clear();
                return;
            case Doc2modelMappingPackage.INJECTION_ELEMENT__NAME:
                setName(NAME_EDEFAULT);
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
            case Doc2modelMappingPackage.INJECTION_ELEMENT__STRING_FORMAT:
                return stringFormat != null;
            case Doc2modelMappingPackage.INJECTION_ELEMENT__STANDARD_OPTIONAL_INJECTIONS:
                return standardOptionalInjections != null && !standardOptionalInjections.isEmpty();
            case Doc2modelMappingPackage.INJECTION_ELEMENT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //InjectionElementImpl
