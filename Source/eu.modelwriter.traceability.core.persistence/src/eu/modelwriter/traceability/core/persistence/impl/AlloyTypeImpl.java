/**
 */
package eu.modelwriter.traceability.core.persistence.impl;

import eu.modelwriter.traceability.core.persistence.AlloyType;
import eu.modelwriter.traceability.core.persistence.InstanceType;
import eu.modelwriter.traceability.core.persistence.RepositoryType;
import eu.modelwriter.traceability.core.persistence.SourceType;
import eu.modelwriter.traceability.core.persistence.persistencePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alloy Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.AlloyTypeImpl#getInstance <em>Instance</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.AlloyTypeImpl#getRepository <em>Repository</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.AlloyTypeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link eu.modelwriter.traceability.core.persistence.impl.AlloyTypeImpl#getBuilddate <em>Builddate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AlloyTypeImpl extends MinimalEObjectImpl.Container implements AlloyType {
  /**
   * The cached value of the '{@link #getInstance() <em>Instance</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstance()
   * @generated
   * @ordered
   */
  protected InstanceType instance;

  /**
   * The cached value of the '{@link #getRepository() <em>Repository</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRepository()
   * @generated
   * @ordered
   */
  protected RepositoryType repository;

  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected EList<SourceType> source;

  /**
   * The default value of the '{@link #getBuilddate() <em>Builddate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBuilddate()
   * @generated
   * @ordered
   */
  protected static final String BUILDDATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBuilddate() <em>Builddate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBuilddate()
   * @generated
   * @ordered
   */
  protected String builddate = BUILDDATE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AlloyTypeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return persistencePackage.Literals.ALLOY_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstanceType getInstance() {
    return instance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInstance(InstanceType newInstance, NotificationChain msgs) {
    InstanceType oldInstance = instance;
    instance = newInstance;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, persistencePackage.ALLOY_TYPE__INSTANCE, oldInstance, newInstance);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInstance(InstanceType newInstance) {
    if (newInstance != instance) {
      NotificationChain msgs = null;
      if (instance != null)
        msgs = ((InternalEObject)instance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - persistencePackage.ALLOY_TYPE__INSTANCE, null, msgs);
      if (newInstance != null)
        msgs = ((InternalEObject)newInstance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - persistencePackage.ALLOY_TYPE__INSTANCE, null, msgs);
      msgs = basicSetInstance(newInstance, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.ALLOY_TYPE__INSTANCE, newInstance, newInstance));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RepositoryType getRepository() {
    return repository;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRepository(RepositoryType newRepository, NotificationChain msgs) {
    RepositoryType oldRepository = repository;
    repository = newRepository;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, persistencePackage.ALLOY_TYPE__REPOSITORY, oldRepository, newRepository);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRepository(RepositoryType newRepository) {
    if (newRepository != repository) {
      NotificationChain msgs = null;
      if (repository != null)
        msgs = ((InternalEObject)repository).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - persistencePackage.ALLOY_TYPE__REPOSITORY, null, msgs);
      if (newRepository != null)
        msgs = ((InternalEObject)newRepository).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - persistencePackage.ALLOY_TYPE__REPOSITORY, null, msgs);
      msgs = basicSetRepository(newRepository, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.ALLOY_TYPE__REPOSITORY, newRepository, newRepository));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SourceType> getSource() {
    if (source == null) {
      source = new EObjectContainmentEList<SourceType>(SourceType.class, this, persistencePackage.ALLOY_TYPE__SOURCE);
    }
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBuilddate() {
    return builddate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBuilddate(String newBuilddate) {
    String oldBuilddate = builddate;
    builddate = newBuilddate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, persistencePackage.ALLOY_TYPE__BUILDDATE, oldBuilddate, builddate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case persistencePackage.ALLOY_TYPE__INSTANCE:
        return basicSetInstance(null, msgs);
      case persistencePackage.ALLOY_TYPE__REPOSITORY:
        return basicSetRepository(null, msgs);
      case persistencePackage.ALLOY_TYPE__SOURCE:
        return ((InternalEList<?>)getSource()).basicRemove(otherEnd, msgs);
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
      case persistencePackage.ALLOY_TYPE__INSTANCE:
        return getInstance();
      case persistencePackage.ALLOY_TYPE__REPOSITORY:
        return getRepository();
      case persistencePackage.ALLOY_TYPE__SOURCE:
        return getSource();
      case persistencePackage.ALLOY_TYPE__BUILDDATE:
        return getBuilddate();
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
      case persistencePackage.ALLOY_TYPE__INSTANCE:
        setInstance((InstanceType)newValue);
        return;
      case persistencePackage.ALLOY_TYPE__REPOSITORY:
        setRepository((RepositoryType)newValue);
        return;
      case persistencePackage.ALLOY_TYPE__SOURCE:
        getSource().clear();
        getSource().addAll((Collection<? extends SourceType>)newValue);
        return;
      case persistencePackage.ALLOY_TYPE__BUILDDATE:
        setBuilddate((String)newValue);
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
      case persistencePackage.ALLOY_TYPE__INSTANCE:
        setInstance((InstanceType)null);
        return;
      case persistencePackage.ALLOY_TYPE__REPOSITORY:
        setRepository((RepositoryType)null);
        return;
      case persistencePackage.ALLOY_TYPE__SOURCE:
        getSource().clear();
        return;
      case persistencePackage.ALLOY_TYPE__BUILDDATE:
        setBuilddate(BUILDDATE_EDEFAULT);
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
      case persistencePackage.ALLOY_TYPE__INSTANCE:
        return instance != null;
      case persistencePackage.ALLOY_TYPE__REPOSITORY:
        return repository != null;
      case persistencePackage.ALLOY_TYPE__SOURCE:
        return source != null && !source.isEmpty();
      case persistencePackage.ALLOY_TYPE__BUILDDATE:
        return BUILDDATE_EDEFAULT == null ? builddate != null : !BUILDDATE_EDEFAULT.equals(builddate);
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
    result.append(" (builddate: ");
    result.append(builddate);
    result.append(')');
    return result.toString();
  }

} //AlloyTypeImpl
