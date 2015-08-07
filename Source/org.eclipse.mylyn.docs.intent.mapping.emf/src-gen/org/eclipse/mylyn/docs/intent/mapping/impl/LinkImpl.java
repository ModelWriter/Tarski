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

import java.util.Iterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.mylyn.docs.intent.mapping.ILink;
import org.eclipse.mylyn.docs.intent.mapping.ILinkListener;
import org.eclipse.mylyn.docs.intent.mapping.ILocation;
import org.eclipse.mylyn.docs.intent.mapping.Link;
import org.eclipse.mylyn.docs.intent.mapping.Location;
import org.eclipse.mylyn.docs.intent.mapping.MappingPackage;
import org.eclipse.mylyn.docs.intent.mapping.Status;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Link</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.impl.LinkImpl#getStatus <em>Status</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.impl.LinkImpl#getDescription <em>Description</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.impl.LinkImpl#getSource <em>Source</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.impl.LinkImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkImpl extends MinimalEObjectImpl.Container implements Link {
	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final Status STATUS_EDEFAULT = Status.VALID;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected Status status = STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Location target;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected LinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.LINK;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setStatus(Status newStatus) {
		Status oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.LINK__STATUS, oldStatus,
					status));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.LINK__DESCRIPTION,
					oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Location getSource() {
		if (eContainerFeatureID() != MappingPackage.LINK__SOURCE)
			return null;
		return (Location)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSource(Location newSource, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSource, MappingPackage.LINK__SOURCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSource(Location newSource) {
		if (newSource != eInternalContainer()
				|| (eContainerFeatureID() != MappingPackage.LINK__SOURCE && newSource != null)) {
			if (EcoreUtil.isAncestor(this, newSource))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, MappingPackage.LOCATION__TARGET_LINKS,
						Location.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.LINK__SOURCE, newSource,
					newSource));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Location getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Location)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.LINK__TARGET,
							oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Location basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetTarget(Location newTarget, NotificationChain msgs) {
		Location oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MappingPackage.LINK__TARGET, oldTarget, newTarget);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTarget(Location newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, MappingPackage.LOCATION__SOURCE_LINKS,
						Location.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, MappingPackage.LOCATION__SOURCE_LINKS,
						Location.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.LINK__TARGET, newTarget,
					newTarget));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.LINK__SOURCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSource((Location)otherEnd, msgs);
			case MappingPackage.LINK__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this,
							MappingPackage.LOCATION__SOURCE_LINKS, Location.class, msgs);
				return basicSetTarget((Location)otherEnd, msgs);
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
			case MappingPackage.LINK__SOURCE:
				return basicSetSource(null, msgs);
			case MappingPackage.LINK__TARGET:
				return basicSetTarget(null, msgs);
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
			case MappingPackage.LINK__SOURCE:
				return eInternalContainer().eInverseRemove(this, MappingPackage.LOCATION__TARGET_LINKS,
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
			case MappingPackage.LINK__STATUS:
				return getStatus();
			case MappingPackage.LINK__DESCRIPTION:
				return getDescription();
			case MappingPackage.LINK__SOURCE:
				return getSource();
			case MappingPackage.LINK__TARGET:
				if (resolve)
					return getTarget();
				return basicGetTarget();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MappingPackage.LINK__STATUS:
				setStatus((Status)newValue);
				return;
			case MappingPackage.LINK__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case MappingPackage.LINK__SOURCE:
				setSource((Location)newValue);
				return;
			case MappingPackage.LINK__TARGET:
				setTarget((Location)newValue);
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
			case MappingPackage.LINK__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case MappingPackage.LINK__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case MappingPackage.LINK__SOURCE:
				setSource((Location)null);
				return;
			case MappingPackage.LINK__TARGET:
				setTarget((Location)null);
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
			case MappingPackage.LINK__STATUS:
				return status != STATUS_EDEFAULT;
			case MappingPackage.LINK__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT
						.equals(description);
			case MappingPackage.LINK__SOURCE:
				return getSource() != null;
			case MappingPackage.LINK__TARGET:
				return target != null;
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
		result.append(" (status: ");
		result.append(status);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.mylyn.docs.intent.mapping.ILink#getLinkStatus()
	 * @generated NOT
	 */
	public LinkStatus getLinkStatus() {
		return getLinkStatus(getStatus());
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.mylyn.docs.intent.mapping.ILink#setSource(org.eclipse.mylyn.docs.intent.mapping.ILocation)
	 * @generated NOT
	 */
	public void setSource(ILocation location) {
		assert location instanceof Location;
		setSource((Location)location);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.mylyn.docs.intent.mapping.ILink#setTarget(org.eclipse.mylyn.docs.intent.mapping.ILocation)
	 * @generated NOT
	 */
	public void setTarget(ILocation location) {
		assert location instanceof Location;
		setTarget((Location)location);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.mylyn.docs.intent.mapping.ILink#markAsValid()
	 * @generated NOT
	 */
	public void markAsValid() {
		setStatus(Status.VALID);
	}

	/**
	 * {@link ILink} adapter.
	 *
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	private final class LinkAdapter extends AdapterImpl {

		/**
		 * The {@link ILinkListener} to forward notification to.
		 */
		private final ILinkListener listener;

		/**
		 * Constructor.
		 * 
		 * @param listener
		 *            the {@link ILinkListener} to forward notification to
		 */
		private LinkAdapter(ILinkListener listener) {
			this.listener = listener;
		}

		@Override
		public void notifyChanged(Notification msg) {
			switch (msg.getFeatureID(Link.class)) {
				case MappingPackage.LINK__DESCRIPTION:
					for (Adapter adapter : eAdapters()) {
						if (adapter instanceof LinkAdapter) {
							((LinkAdapter)adapter).listener.descriptionChanged((String)msg.getNewValue());
						}
					}
					break;
				case MappingPackage.LINK__STATUS:
					for (Adapter adapter : eAdapters()) {
						if (adapter instanceof LinkAdapter) {
							((LinkAdapter)adapter).listener.statusChanged(getLinkStatus((Status)msg
									.getNewValue()));
						}
					}
					break;
				case MappingPackage.LINK__SOURCE:
					for (Adapter adapter : eAdapters()) {
						if (adapter instanceof LinkAdapter) {
							((LinkAdapter)adapter).listener.sourceChanged((Location)msg.getNewValue());
						}
					}
					break;
				case MappingPackage.LINK__TARGET:
					for (Adapter adapter : eAdapters()) {
						if (adapter instanceof LinkAdapter) {
							((LinkAdapter)adapter).listener.targetChanged((Location)msg.getNewValue());
						}
					}
					break;
			}
		}

	}

	/**
	 * Gets the {@link LinkStatus} corresponding to the given {@link Status}.
	 * 
	 * @param status
	 *            the {@link Status}
	 * @return the {@link LinkStatus} corresponding to the given {@link Status}
	 */
	private LinkStatus getLinkStatus(Status status) {
		final LinkStatus res;

		switch (status) {
			case CHANGED_SOURCE:
				res = LinkStatus.CHANGED_SOURCE;
				break;
			case CHANGED_TARGET:
				res = LinkStatus.CHANGED_TARGET;
				break;
			case DELETED_SOURCE:
				res = LinkStatus.DELETED_SOURCE;
				break;
			case DELETED_TARGET:
				res = LinkStatus.DELETED_TARGET;
				break;
			case VALID:
				res = LinkStatus.VALID;
				break;
			default:
				throw new IllegalStateException("missing case for " + status);
		}

		return res;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.mylyn.docs.intent.mapping.ILink#addListener(org.eclipse.mylyn.docs.intent.mapping.ILinkListener)
	 * @generated NOT
	 */
	public void addListener(ILinkListener listener) {
		eAdapters().add(new LinkAdapter(listener));
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.mylyn.docs.intent.mapping.ILink#removeListener(org.eclipse.mylyn.docs.intent.mapping.ILinkListener)
	 * @generated NOT
	 */
	public void removeListener(ILinkListener listener) {
		final Iterator<Adapter> it = eAdapters().iterator();
		while (it.hasNext()) {
			final Adapter adapter = it.next();
			if (adapter instanceof LinkAdapter && ((LinkAdapter)adapter).listener == listener) {
				it.remove();
			}
		}
	}

} // LinkImpl
