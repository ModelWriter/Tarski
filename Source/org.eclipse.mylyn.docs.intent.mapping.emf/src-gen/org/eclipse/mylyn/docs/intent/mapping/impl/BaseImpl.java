/**
 *  Copyright (c) 2015 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *     Obeo - initial API and implementation and/or initial documentation
 *     ...
 * 
 */
package org.eclipse.mylyn.docs.intent.mapping.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.mylyn.docs.intent.mapping.Base;
import org.eclipse.mylyn.docs.intent.mapping.IBase;
import org.eclipse.mylyn.docs.intent.mapping.IBaseListener;
import org.eclipse.mylyn.docs.intent.mapping.ILocation;
import org.eclipse.mylyn.docs.intent.mapping.Location;
import org.eclipse.mylyn.docs.intent.mapping.LocationFactory;
import org.eclipse.mylyn.docs.intent.mapping.MappingPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Base</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.impl.BaseImpl#getRootLocations <em>Root Locations</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.impl.BaseImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BaseImpl extends MinimalEObjectImpl.Container implements Base {
	/**
	 * The cached value of the '{@link #getRootLocations() <em>Root Locations</em>}' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRootLocations()
	 * @generated NOT
	 * @ordered
	 */
	protected EList<ILocation> rootLocations;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.BASE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<ILocation> getRootLocations() {
		if (rootLocations == null) {
			rootLocations = new EObjectContainmentEList<ILocation>(Location.class, this,
					MappingPackage.BASE__ROOT_LOCATIONS);
		}
		return rootLocations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.BASE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.BASE__ROOT_LOCATIONS:
				return ((InternalEList<?>)getRootLocations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingPackage.BASE__ROOT_LOCATIONS:
				return getRootLocations();
			case MappingPackage.BASE__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MappingPackage.BASE__ROOT_LOCATIONS:
				getRootLocations().clear();
				getRootLocations().addAll((Collection<? extends Location>)newValue);
				return;
			case MappingPackage.BASE__NAME:
				setName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MappingPackage.BASE__ROOT_LOCATIONS:
				getRootLocations().clear();
				return;
			case MappingPackage.BASE__NAME:
				setName(NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MappingPackage.BASE__ROOT_LOCATIONS:
				return rootLocations != null && !rootLocations.isEmpty();
			case MappingPackage.BASE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@link IBase} adapter.
	 *
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	private final class BaseAdapter extends AdapterImpl {

		/**
		 * The {@link IBaseListener} to forward notification to.
		 */
		private final IBaseListener listener;

		/**
		 * Constructor.
		 * 
		 * @param listener
		 *            the {@link IBaseListener} to forward notification to
		 */
		private BaseAdapter(IBaseListener listener) {
			this.listener = listener;
		}

		@SuppressWarnings("unchecked")
		@Override
		public void notifyChanged(Notification msg) {
			switch (msg.getFeatureID(Base.class)) {
				case MappingPackage.BASE__NAME:
					for (Adapter adapter : eAdapters()) {
						if (adapter instanceof BaseAdapter) {
							((BaseAdapter)adapter).listener.nameChanged((String)msg.getNewValue());
						}
					}
					break;
				case MappingPackage.BASE__ROOT_LOCATIONS:
					switch (msg.getEventType()) {
						case Notification.ADD:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof BaseAdapter) {
									((BaseAdapter)adapter).listener.rootLocationAdded((ILocation)msg
											.getNewValue());
								}
							}
							break;
						case Notification.ADD_MANY:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof BaseAdapter) {
									for (ILocation location : (List<ILocation>)msg.getNewValue()) {
										((BaseAdapter)adapter).listener.rootLocationAdded(location);
									}
								}
							}
							break;
						case Notification.REMOVE:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof BaseAdapter) {
									((BaseAdapter)adapter).listener.rootLocationRemoved((ILocation)msg
											.getOldValue());
								}
							}
							break;
						case Notification.REMOVE_MANY:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof BaseAdapter) {
									for (ILocation location : (List<ILocation>)msg.getOldValue()) {
										((BaseAdapter)adapter).listener.rootLocationRemoved(location);
									}
								}
							}
							break;
					}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.mylyn.docs.intent.mapping.IBase#addListener(org.eclipse.mylyn.docs.intent.mapping.IBaseListener)
	 * @generated NOT
	 */
	public void addListener(IBaseListener listener) {
		eAdapters().add(new BaseAdapter(listener));
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.mylyn.docs.intent.mapping.IBase#removeListener(org.eclipse.mylyn.docs.intent.mapping.IBaseListener)
	 * @generated NOT
	 */
	public void removeListener(IBaseListener listener) {
		final Iterator<Adapter> it = eAdapters().iterator();
		while (it.hasNext()) {
			final Adapter adapter = it.next();
			if (adapter instanceof BaseAdapter && ((BaseAdapter)adapter).listener == listener) {
				it.remove();
			}
		}
	}

	/**
	 * The {@link LocationFactory}.
	 * 
	 * @generated NOT
	 */
	private final LocationFactory factory = new LocationFactory();

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.mylyn.docs.intent.mapping.IBase#getFactory()
	 * @generated NOT
	 */
	public LocationFactory getFactory() {
		return factory;
	}

} // BaseImpl
