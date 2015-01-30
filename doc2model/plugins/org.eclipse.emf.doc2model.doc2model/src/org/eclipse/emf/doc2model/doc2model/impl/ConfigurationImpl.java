package org.eclipse.emf.doc2model.doc2model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.doc2model.doc2model.Configuration;
import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;
import org.eclipse.emf.doc2model.doc2model.EPackageReference;
import org.eclipse.emf.doc2model.doc2model.InitialModel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.ConfigurationImpl#getInitialModel <em>Initial Model</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.ConfigurationImpl#getEPackages <em>EPackages</em>}</li>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.ConfigurationImpl#getExtension <em>Extension</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends EObjectImpl implements Configuration {
	/**
	 * The cached value of the '{@link #getInitialModel() <em>Initial Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialModel()
	 * @generated
	 * @ordered
	 */
	protected InitialModel initialModel;

	/**
	 * The cached value of the '{@link #getEPackages() <em>EPackages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<EPackageReference> ePackages;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Doc2modelPackage.Literals.CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitialModel getInitialModel() {
		return initialModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialModel(InitialModel newInitialModel, NotificationChain msgs) {
		InitialModel oldInitialModel = initialModel;
		initialModel = newInitialModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Doc2modelPackage.CONFIGURATION__INITIAL_MODEL, oldInitialModel, newInitialModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialModel(InitialModel newInitialModel) {
		if (newInitialModel != initialModel) {
			NotificationChain msgs = null;
			if (initialModel != null)
				msgs = ((InternalEObject)initialModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Doc2modelPackage.CONFIGURATION__INITIAL_MODEL, null, msgs);
			if (newInitialModel != null)
				msgs = ((InternalEObject)newInitialModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Doc2modelPackage.CONFIGURATION__INITIAL_MODEL, null, msgs);
			msgs = basicSetInitialModel(newInitialModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.CONFIGURATION__INITIAL_MODEL, newInitialModel, newInitialModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPackageReference> getEPackages() {
		if (ePackages == null) {
			ePackages = new EObjectContainmentEList<EPackageReference>(EPackageReference.class, this, Doc2modelPackage.CONFIGURATION__EPACKAGES);
		}
		return ePackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtension(String newExtension) {
		String oldExtension = extension;
		extension = newExtension;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.CONFIGURATION__EXTENSION, oldExtension, extension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Doc2modelPackage.CONFIGURATION__INITIAL_MODEL:
				return basicSetInitialModel(null, msgs);
			case Doc2modelPackage.CONFIGURATION__EPACKAGES:
				return ((InternalEList<?>)getEPackages()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Doc2modelPackage.CONFIGURATION__INITIAL_MODEL:
				return getInitialModel();
			case Doc2modelPackage.CONFIGURATION__EPACKAGES:
				return getEPackages();
			case Doc2modelPackage.CONFIGURATION__EXTENSION:
				return getExtension();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Doc2modelPackage.CONFIGURATION__INITIAL_MODEL:
				setInitialModel((InitialModel)newValue);
				return;
			case Doc2modelPackage.CONFIGURATION__EPACKAGES:
				getEPackages().clear();
				getEPackages().addAll((Collection<? extends EPackageReference>)newValue);
				return;
			case Doc2modelPackage.CONFIGURATION__EXTENSION:
				setExtension((String)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case Doc2modelPackage.CONFIGURATION__INITIAL_MODEL:
				setInitialModel((InitialModel)null);
				return;
			case Doc2modelPackage.CONFIGURATION__EPACKAGES:
				getEPackages().clear();
				return;
			case Doc2modelPackage.CONFIGURATION__EXTENSION:
				setExtension(EXTENSION_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Doc2modelPackage.CONFIGURATION__INITIAL_MODEL:
				return initialModel != null;
			case Doc2modelPackage.CONFIGURATION__EPACKAGES:
				return ePackages != null && !ePackages.isEmpty();
			case Doc2modelPackage.CONFIGURATION__EXTENSION:
				return EXTENSION_EDEFAULT == null ? extension != null : !EXTENSION_EDEFAULT.equals(extension);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (extension: ");
		result.append(extension);
		result.append(')');
		return result.toString();
	}

} //ConfigurationImpl
