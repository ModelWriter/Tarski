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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.mylyn.docs.intent.mapping.ILink;
import org.eclipse.mylyn.docs.intent.mapping.ILocation;
import org.eclipse.mylyn.docs.intent.mapping.ILocationListener;
import org.eclipse.mylyn.docs.intent.mapping.IScope;
import org.eclipse.mylyn.docs.intent.mapping.Link;
import org.eclipse.mylyn.docs.intent.mapping.Location;
import org.eclipse.mylyn.docs.intent.mapping.MappingPackage;
import org.eclipse.mylyn.docs.intent.mapping.Scope;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Location</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.impl.LocationImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.impl.LocationImpl#getScope <em>Scope</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.impl.LocationImpl#getSourceLinks <em>Source Links</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.impl.LocationImpl#getTargetLinks <em>Target Links</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.impl.LocationImpl#getContents <em>Contents</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.impl.LocationImpl#getContainer <em>Container</em>}</li>
 * <li>{@link org.eclipse.mylyn.docs.intent.mapping.impl.LocationImpl#getReferencingScopes <em>Referencing
 * Scopes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LocationImpl extends MinimalEObjectImpl.Container implements Location {
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
	 * The cached value of the '{@link #getScope() <em>Scope</em>}' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected Scope scope;

	/**
	 * The cached value of the '{@link #getSourceLinks() <em>Source Links</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSourceLinks()
	 * @generated NOT
	 * @ordered
	 */
	protected EList<ILink> sourceLinks;

	/**
	 * The cached value of the '{@link #getTargetLinks() <em>Target Links</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTargetLinks()
	 * @generated NOT
	 * @ordered
	 */
	protected EList<ILink> targetLinks;

	/**
	 * The cached value of the '{@link #getContents() <em>Contents</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContents()
	 * @generated NOT
	 * @ordered
	 */
	protected EList<ILocation> contents;

	/**
	 * The cached value of the '{@link #getReferencingScopes() <em>Referencing Scopes</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReferencingScopes()
	 * @generated NOT
	 * @ordered
	 */
	protected EList<IScope> referencingScopes;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected LocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.LOCATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.LOCATION__NAME, oldName,
					name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Scope getScope() {
		return scope;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetScope(Scope newScope, NotificationChain msgs) {
		Scope oldScope = scope;
		scope = newScope;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MappingPackage.LOCATION__SCOPE, oldScope, newScope);
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
	public void setScope(Scope newScope) {
		if (newScope != scope) {
			NotificationChain msgs = null;
			if (scope != null)
				msgs = ((InternalEObject)scope).eInverseRemove(this, MappingPackage.SCOPE__HOLDER,
						Scope.class, msgs);
			if (newScope != null)
				msgs = ((InternalEObject)newScope).eInverseAdd(this, MappingPackage.SCOPE__HOLDER,
						Scope.class, msgs);
			msgs = basicSetScope(newScope, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.LOCATION__SCOPE, newScope,
					newScope));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<ILink> getSourceLinks() {
		if (sourceLinks == null) {
			sourceLinks = new EObjectWithInverseResolvingEList<ILink>(Link.class, this,
					MappingPackage.LOCATION__SOURCE_LINKS, MappingPackage.LINK__TARGET);
		}
		return sourceLinks;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<ILink> getTargetLinks() {
		if (targetLinks == null) {
			targetLinks = new EObjectContainmentWithInverseEList<ILink>(Link.class, this,
					MappingPackage.LOCATION__TARGET_LINKS, MappingPackage.LINK__SOURCE);
		}
		return targetLinks;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<ILocation> getContents() {
		if (contents == null) {
			contents = new EObjectContainmentWithInverseEList<ILocation>(Location.class, this,
					MappingPackage.LOCATION__CONTENTS, MappingPackage.LOCATION__CONTAINER);
		}
		return contents;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.mylyn.docs.intent.mapping.ILocation#setContainer(org.eclipse.mylyn.docs.intent.mapping.ILocation)
	 * @generated NOT
	 */
	public void setContainer(ILocation location) {
		location.getContents().add(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Location getContainer() {
		if (eContainerFeatureID() != MappingPackage.LOCATION__CONTAINER)
			return null;
		return (Location)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetContainer(Location newContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainer, MappingPackage.LOCATION__CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setContainer(Location newContainer) {
		if (newContainer != eInternalContainer()
				|| (eContainerFeatureID() != MappingPackage.LOCATION__CONTAINER && newContainer != null)) {
			if (EcoreUtil.isAncestor(this, newContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, MappingPackage.LOCATION__CONTENTS,
						Location.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.LOCATION__CONTAINER,
					newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<IScope> getReferencingScopes() {
		if (referencingScopes == null) {
			referencingScopes = new EObjectWithInverseResolvingEList.ManyInverse<IScope>(Scope.class, this,
					MappingPackage.LOCATION__REFERENCING_SCOPES, MappingPackage.SCOPE__LOCATIONS);
		}
		return referencingScopes;
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
			case MappingPackage.LOCATION__SCOPE:
				if (scope != null)
					msgs = ((InternalEObject)scope).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
							- MappingPackage.LOCATION__SCOPE, null, msgs);
				return basicSetScope((Scope)otherEnd, msgs);
			case MappingPackage.LOCATION__SOURCE_LINKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSourceLinks()).basicAdd(
						otherEnd, msgs);
			case MappingPackage.LOCATION__TARGET_LINKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTargetLinks()).basicAdd(
						otherEnd, msgs);
			case MappingPackage.LOCATION__CONTENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContents()).basicAdd(otherEnd,
						msgs);
			case MappingPackage.LOCATION__CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainer((Location)otherEnd, msgs);
			case MappingPackage.LOCATION__REFERENCING_SCOPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReferencingScopes()).basicAdd(
						otherEnd, msgs);
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
			case MappingPackage.LOCATION__SCOPE:
				return basicSetScope(null, msgs);
			case MappingPackage.LOCATION__SOURCE_LINKS:
				return ((InternalEList<?>)getSourceLinks()).basicRemove(otherEnd, msgs);
			case MappingPackage.LOCATION__TARGET_LINKS:
				return ((InternalEList<?>)getTargetLinks()).basicRemove(otherEnd, msgs);
			case MappingPackage.LOCATION__CONTENTS:
				return ((InternalEList<?>)getContents()).basicRemove(otherEnd, msgs);
			case MappingPackage.LOCATION__CONTAINER:
				return basicSetContainer(null, msgs);
			case MappingPackage.LOCATION__REFERENCING_SCOPES:
				return ((InternalEList<?>)getReferencingScopes()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.LOCATION__CONTAINER:
				return eInternalContainer().eInverseRemove(this, MappingPackage.LOCATION__CONTENTS,
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
			case MappingPackage.LOCATION__NAME:
				return getName();
			case MappingPackage.LOCATION__SCOPE:
				return getScope();
			case MappingPackage.LOCATION__SOURCE_LINKS:
				return getSourceLinks();
			case MappingPackage.LOCATION__TARGET_LINKS:
				return getTargetLinks();
			case MappingPackage.LOCATION__CONTENTS:
				return getContents();
			case MappingPackage.LOCATION__CONTAINER:
				return getContainer();
			case MappingPackage.LOCATION__REFERENCING_SCOPES:
				return getReferencingScopes();
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
			case MappingPackage.LOCATION__NAME:
				setName((String)newValue);
				return;
			case MappingPackage.LOCATION__SCOPE:
				setScope((Scope)newValue);
				return;
			case MappingPackage.LOCATION__SOURCE_LINKS:
				getSourceLinks().clear();
				getSourceLinks().addAll((Collection<? extends Link>)newValue);
				return;
			case MappingPackage.LOCATION__TARGET_LINKS:
				getTargetLinks().clear();
				getTargetLinks().addAll((Collection<? extends Link>)newValue);
				return;
			case MappingPackage.LOCATION__CONTENTS:
				getContents().clear();
				getContents().addAll((Collection<? extends Location>)newValue);
				return;
			case MappingPackage.LOCATION__CONTAINER:
				setContainer((Location)newValue);
				return;
			case MappingPackage.LOCATION__REFERENCING_SCOPES:
				getReferencingScopes().clear();
				getReferencingScopes().addAll((Collection<? extends Scope>)newValue);
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
			case MappingPackage.LOCATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MappingPackage.LOCATION__SCOPE:
				setScope((Scope)null);
				return;
			case MappingPackage.LOCATION__SOURCE_LINKS:
				getSourceLinks().clear();
				return;
			case MappingPackage.LOCATION__TARGET_LINKS:
				getTargetLinks().clear();
				return;
			case MappingPackage.LOCATION__CONTENTS:
				getContents().clear();
				return;
			case MappingPackage.LOCATION__CONTAINER:
				setContainer((Location)null);
				return;
			case MappingPackage.LOCATION__REFERENCING_SCOPES:
				getReferencingScopes().clear();
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
			case MappingPackage.LOCATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MappingPackage.LOCATION__SCOPE:
				return scope != null;
			case MappingPackage.LOCATION__SOURCE_LINKS:
				return sourceLinks != null && !sourceLinks.isEmpty();
			case MappingPackage.LOCATION__TARGET_LINKS:
				return targetLinks != null && !targetLinks.isEmpty();
			case MappingPackage.LOCATION__CONTENTS:
				return contents != null && !contents.isEmpty();
			case MappingPackage.LOCATION__CONTAINER:
				return getContainer() != null;
			case MappingPackage.LOCATION__REFERENCING_SCOPES:
				return referencingScopes != null && !referencingScopes.isEmpty();
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
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.mylyn.docs.intent.mapping.ILocation#getSemanticName()
	 * @generated NOT
	 */
	public String getSemanticName() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.mylyn.docs.intent.mapping.ILocation#markAsChanged()
	 * @generated NOT
	 */
	public void markAsChanged() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.mylyn.docs.intent.mapping.ILocation#markAsDeleted()
	 * @generated NOT
	 */
	public void markAsDeleted() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.mylyn.docs.intent.mapping.ILocation#setScope(org.eclipse.mylyn.docs.intent.mapping.IScope)
	 * @generated NOT
	 */
	public void setScope(IScope scope) {
		assert scope instanceof Scope;
		setScope((Scope)scope);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.mylyn.docs.intent.mapping.ILocation#getContentLocation(java.lang.String)
	 * @generated NOT
	 */
	public ILocation getContentLocation(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@link ILocation} adapter.
	 *
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	private final class LocationAdapter extends AdapterImpl {

		/**
		 * The {@link ILocationListener} to forward notification to.
		 */
		private final ILocationListener listener;

		/**
		 * Constructor.
		 * 
		 * @param listener
		 *            the {@link ILocationListener} to forward notification to
		 */
		private LocationAdapter(ILocationListener listener) {
			this.listener = listener;
		}

		@SuppressWarnings("unchecked")
		@Override
		public void notifyChanged(Notification msg) {
			switch (msg.getFeatureID(Location.class)) {
				case MappingPackage.LOCATION__NAME:
					for (Adapter adapter : eAdapters()) {
						if (adapter instanceof LocationAdapter) {
							((LocationAdapter)adapter).listener.nameChanged((String)msg.getNewValue());
						}
					}
					break;
				case MappingPackage.LOCATION__SCOPE:
					for (Adapter adapter : eAdapters()) {
						if (adapter instanceof LocationAdapter) {
							((LocationAdapter)adapter).listener.scopeChanged((Scope)msg.getNewValue());
						}
					}
					break;
				case MappingPackage.LOCATION__SOURCE_LINKS:
					switch (msg.getEventType()) {
						case Notification.ADD:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof LocationAdapter) {
									((LocationAdapter)adapter).listener.sourceLinkAdded((ILink)msg
											.getNewValue());
								}
							}
							break;
						case Notification.ADD_MANY:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof LocationAdapter) {
									for (ILink link : (List<ILink>)msg.getNewValue()) {
										((LocationAdapter)adapter).listener.sourceLinkAdded(link);
									}
								}
							}
							break;
						case Notification.REMOVE:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof LocationAdapter) {
									((LocationAdapter)adapter).listener.sourceLinkRemoved((ILink)msg
											.getOldValue());
								}
							}
							break;
						case Notification.REMOVE_MANY:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof LocationAdapter) {
									for (ILink link : (List<ILink>)msg.getOldValue()) {
										((LocationAdapter)adapter).listener.sourceLinkRemoved(link);
									}
								}
							}
							break;
					}
					break;
				case MappingPackage.LOCATION__TARGET_LINKS:
					switch (msg.getEventType()) {
						case Notification.ADD:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof LocationAdapter) {
									((LocationAdapter)adapter).listener.targetLinkAdded((ILink)msg
											.getNewValue());
								}
							}
							break;
						case Notification.ADD_MANY:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof LocationAdapter) {
									for (ILink link : (List<ILink>)msg.getNewValue()) {
										((LocationAdapter)adapter).listener.targetLinkAdded(link);
									}
								}
							}
							break;
						case Notification.REMOVE:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof LocationAdapter) {
									((LocationAdapter)adapter).listener.targetLinkRemoved((ILink)msg
											.getOldValue());
								}
							}
							break;
						case Notification.REMOVE_MANY:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof LocationAdapter) {
									for (ILink link : (List<ILink>)msg.getOldValue()) {
										((LocationAdapter)adapter).listener.targetLinkRemoved(link);
									}
								}
							}
							break;
					}
					break;
				case MappingPackage.LOCATION__CONTENTS:
					switch (msg.getEventType()) {
						case Notification.ADD:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof LocationAdapter) {
									((LocationAdapter)adapter).listener.contentLocationAdded((ILocation)msg
											.getNewValue());
								}
							}
							break;
						case Notification.ADD_MANY:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof LocationAdapter) {
									for (ILocation location : (List<ILocation>)msg.getNewValue()) {
										((LocationAdapter)adapter).listener.contentLocationAdded(location);
									}
								}
							}
							break;
						case Notification.REMOVE:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof LocationAdapter) {
									((LocationAdapter)adapter).listener.contentLocationRemoved((ILocation)msg
											.getOldValue());
								}
							}
							break;
						case Notification.REMOVE_MANY:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof LocationAdapter) {
									for (ILocation location : (List<ILocation>)msg.getOldValue()) {
										((LocationAdapter)adapter).listener.contentLocationRemoved(location);
									}
								}
							}
							break;
					}
					break;

				case MappingPackage.LOCATION__REFERENCING_SCOPES:
					switch (msg.getEventType()) {
						case Notification.ADD:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof LocationAdapter) {
									((LocationAdapter)adapter).listener.referencingScopeAdded((IScope)msg
											.getNewValue());
								}
							}
							break;
						case Notification.ADD_MANY:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof LocationAdapter) {
									for (IScope scope : (List<IScope>)msg.getNewValue()) {
										((LocationAdapter)adapter).listener.referencingScopeAdded(scope);
									}
								}
							}
							break;
						case Notification.REMOVE:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof LocationAdapter) {
									((LocationAdapter)adapter).listener.referencingScopeRemoved((IScope)msg
											.getOldValue());
								}
							}
							break;
						case Notification.REMOVE_MANY:
							for (Adapter adapter : eAdapters()) {
								if (adapter instanceof LocationAdapter) {
									for (IScope scope : (List<IScope>)msg.getOldValue()) {
										((LocationAdapter)adapter).listener.referencingScopeRemoved(scope);
									}
								}
							}
							break;
					}
					break;

			}
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.mylyn.docs.intent.mapping.ILocation#addListener(org.eclipse.mylyn.docs.intent.mapping.ILocationListener)
	 * @generated NOT
	 */
	public void addListener(ILocationListener listener) {
		eAdapters().add(new LocationAdapter(listener));
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.mylyn.docs.intent.mapping.ILocation#removeListener(org.eclipse.mylyn.docs.intent.mapping.ILocationListener)
	 * @generated NOT
	 */
	public void removeListener(ILocationListener listener) {
		final Iterator<Adapter> it = eAdapters().iterator();
		while (it.hasNext()) {
			final Adapter adapter = it.next();
			if (adapter instanceof LocationAdapter && ((LocationAdapter)adapter).listener == listener) {
				it.remove();
			}
		}
	}

} // LocationImpl
