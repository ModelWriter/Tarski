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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.mylyn.docs.intent.mapping.ILocation;
import org.eclipse.mylyn.docs.intent.mapping.IScope;
import org.eclipse.mylyn.docs.intent.mapping.IScopeListener;
import org.eclipse.mylyn.docs.intent.mapping.Location;
import org.eclipse.mylyn.docs.intent.mapping.MappingPackage;
import org.eclipse.mylyn.docs.intent.mapping.Scope;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Scope</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.impl.ScopeImpl#getLocations <em>Locations</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.impl.ScopeImpl#getHolder <em>Holder</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScopeImpl extends MinimalEObjectImpl.Container implements Scope {
	/**
	 * The cached value of the '{@link #getLocations() <em>Locations</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLocations()
	 * @generated NOT
	 * @ordered
	 */
	protected EList<ILocation> locations;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ScopeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.SCOPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<ILocation> getLocations() {
		if (locations == null) {
			locations = new EObjectWithInverseResolvingEList.ManyInverse<ILocation>(Location.class, this,
					MappingPackage.SCOPE__LOCATIONS, MappingPackage.LOCATION__REFERENCING_SCOPES);
		}
		return locations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Location getHolder() {
		if (eContainerFeatureID() != MappingPackage.SCOPE__HOLDER)
			return null;
		return (Location)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetHolder(Location newHolder, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newHolder, MappingPackage.SCOPE__HOLDER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setHolder(Location newHolder) {
		if (newHolder != eInternalContainer()
				|| (eContainerFeatureID() != MappingPackage.SCOPE__HOLDER && newHolder != null)) {
			if (EcoreUtil.isAncestor(this, newHolder))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newHolder != null)
				msgs = ((InternalEObject)newHolder).eInverseAdd(this, MappingPackage.LOCATION__SCOPE,
						Location.class, msgs);
			msgs = basicSetHolder(newHolder, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.SCOPE__HOLDER, newHolder,
					newHolder));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.SCOPE__LOCATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLocations()).basicAdd(otherEnd,
						msgs);
			case MappingPackage.SCOPE__HOLDER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetHolder((Location)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.SCOPE__LOCATIONS:
				return ((InternalEList<?>)getLocations()).basicRemove(otherEnd, msgs);
			case MappingPackage.SCOPE__HOLDER:
				return basicSetHolder(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case MappingPackage.SCOPE__HOLDER:
				return eInternalContainer().eInverseRemove(this, MappingPackage.LOCATION__SCOPE,
						Location.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingPackage.SCOPE__LOCATIONS:
				return getLocations();
			case MappingPackage.SCOPE__HOLDER:
				return getHolder();
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
			case MappingPackage.SCOPE__LOCATIONS:
				getLocations().clear();
				getLocations().addAll((Collection<? extends Location>)newValue);
				return;
			case MappingPackage.SCOPE__HOLDER:
				setHolder((Location)newValue);
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
			case MappingPackage.SCOPE__LOCATIONS:
				getLocations().clear();
				return;
			case MappingPackage.SCOPE__HOLDER:
				setHolder((Location)null);
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
			case MappingPackage.SCOPE__LOCATIONS:
				return locations != null && !locations.isEmpty();
			case MappingPackage.SCOPE__HOLDER:
				return getHolder() != null;
		}
		return super.eIsSet(featureID);
	}

	public void setHolder(ILocation location) {
		assert location instanceof Location;
		setHolder((Location)location);
	}

	/**
	 * {@link IScope} adapter.
	 *
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 * @generated NOT
	 */
	private final class ScopeAdapter extends AdapterImpl {

		/**
		 * The {@link IScopeListener} to forward notification to.
		 */
		private final IScopeListener listener;

		/**
		 * Constructor.
		 * 
		 * @param listener
		 *            the {@link IScopeListener} to forward notification to
		 */
		private ScopeAdapter(IScopeListener listener) {
			this.listener = listener;
		}

		@SuppressWarnings("unchecked")
		@Override
		public void notifyChanged(Notification msg) {
			switch (msg.getFeatureID(Scope.class)) {
				case MappingPackage.SCOPE__HOLDER:
					for (Adapter adapter : eAdapters()) {
						if (adapter instanceof ScopeAdapter) {
							((ScopeAdapter)adapter).listener.holderChanged((ILocation)msg.getNewValue());
						}
					}
					break;
				case MappingPackage.SCOPE__LOCATIONS:
					switch (msg.getEventType()) {
						case Notification.ADD:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof ScopeAdapter) {
									((ScopeAdapter)adapter).listener.locationAdded((ILocation)msg
											.getNewValue());
								}
							}
							break;
						case Notification.ADD_MANY:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof ScopeAdapter) {
									for (ILocation location : (List<ILocation>)msg.getNewValue()) {
										((ScopeAdapter)adapter).listener.locationAdded(location);
									}
								}
							}
							break;
						case Notification.REMOVE:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof ScopeAdapter) {
									((ScopeAdapter)adapter).listener.locationRemoved((ILocation)msg
											.getOldValue());
								}
							}
							break;
						case Notification.REMOVE_MANY:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof ScopeAdapter) {
									for (ILocation location : (List<ILocation>)msg.getOldValue()) {
										((ScopeAdapter)adapter).listener.locationRemoved(location);
									}
								}
							}
							break;
					}
					break;
			}
		}

	}

	public void addListener(IScopeListener listener) {
		eAdapters().add(new ScopeAdapter(listener));
	}

	public void removeListener(IScopeListener listener) {
		final Iterator<Adapter> it = eAdapters().iterator();
		while (it.hasNext()) {
			final Adapter adapter = it.next();
			if (adapter instanceof ScopeAdapter && ((ScopeAdapter)adapter).listener == listener) {
				it.remove();
			}
		}
	}

} // ScopeImpl
