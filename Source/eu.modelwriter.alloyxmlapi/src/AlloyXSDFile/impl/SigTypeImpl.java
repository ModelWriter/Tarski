/**
 */
package AlloyXSDFile.impl;

import AlloyXSDFile.AlloyXSDFilePackage;
import AlloyXSDFile.AtomType;
import AlloyXSDFile.SigType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sig Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link AlloyXSDFile.impl.SigTypeImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.SigTypeImpl#getAtom <em>Atom</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.SigTypeImpl#getAbstract <em>Abstract</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.SigTypeImpl#getBuiltin <em>Builtin</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.SigTypeImpl#getEnum <em>Enum</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.SigTypeImpl#getID <em>ID</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.SigTypeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.SigTypeImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.SigTypeImpl#getLone <em>Lone</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.SigTypeImpl#getMeta <em>Meta</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.SigTypeImpl#getOne <em>One</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.SigTypeImpl#getParentID <em>Parent ID</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.SigTypeImpl#getPrivate <em>Private</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.SigTypeImpl#getSome <em>Some</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.SigTypeImpl#getSubset <em>Subset</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.SigTypeImpl#getSubsig <em>Subsig</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SigTypeImpl extends MinimalEObjectImpl.Container implements SigType {
  /**
   * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMixed()
   * @generated
   * @ordered
   */
  protected FeatureMap mixed;

  /**
   * The default value of the '{@link #getAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAbstract()
   * @generated
   * @ordered
   */
  protected static final String ABSTRACT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAbstract()
   * @generated
   * @ordered
   */
  protected String abstract_ = ABSTRACT_EDEFAULT;

  /**
   * The default value of the '{@link #getBuiltin() <em>Builtin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBuiltin()
   * @generated
   * @ordered
   */
  protected static final String BUILTIN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBuiltin() <em>Builtin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBuiltin()
   * @generated
   * @ordered
   */
  protected String builtin = BUILTIN_EDEFAULT;

  /**
   * The default value of the '{@link #getEnum() <em>Enum</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnum()
   * @generated
   * @ordered
   */
  protected static final String ENUM_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEnum() <em>Enum</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnum()
   * @generated
   * @ordered
   */
  protected String enum_ = ENUM_EDEFAULT;

  /**
   * The default value of the '{@link #getID() <em>ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getID()
   * @generated
   * @ordered
   */
  protected static final byte ID_EDEFAULT = 0x00;

  /**
   * The cached value of the '{@link #getID() <em>ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getID()
   * @generated
   * @ordered
   */
  protected byte iD = ID_EDEFAULT;

  /**
   * This is true if the ID attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean iDESet;

  /**
   * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLabel()
   * @generated
   * @ordered
   */
  protected static final String LABEL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLabel()
   * @generated
   * @ordered
   */
  protected String label = LABEL_EDEFAULT;

  /**
   * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocation()
   * @generated
   * @ordered
   */
  protected static final Object LOCATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocation()
   * @generated
   * @ordered
   */
  protected Object location = LOCATION_EDEFAULT;

  /**
   * The default value of the '{@link #getLone() <em>Lone</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLone()
   * @generated
   * @ordered
   */
  protected static final String LONE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLone() <em>Lone</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLone()
   * @generated
   * @ordered
   */
  protected String lone = LONE_EDEFAULT;

  /**
   * The default value of the '{@link #getMeta() <em>Meta</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMeta()
   * @generated
   * @ordered
   */
  protected static final String META_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMeta() <em>Meta</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMeta()
   * @generated
   * @ordered
   */
  protected String meta = META_EDEFAULT;

  /**
   * The default value of the '{@link #getOne() <em>One</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOne()
   * @generated
   * @ordered
   */
  protected static final String ONE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOne() <em>One</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOne()
   * @generated
   * @ordered
   */
  protected String one = ONE_EDEFAULT;

  /**
   * The default value of the '{@link #getParentID() <em>Parent ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParentID()
   * @generated
   * @ordered
   */
  protected static final byte PARENT_ID_EDEFAULT = 0x00;

  /**
   * The cached value of the '{@link #getParentID() <em>Parent ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParentID()
   * @generated
   * @ordered
   */
  protected byte parentID = PARENT_ID_EDEFAULT;

  /**
   * This is true if the Parent ID attribute has been set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  protected boolean parentIDESet;

  /**
   * The default value of the '{@link #getPrivate() <em>Private</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrivate()
   * @generated
   * @ordered
   */
  protected static final String PRIVATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPrivate() <em>Private</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrivate()
   * @generated
   * @ordered
   */
  protected String private_ = PRIVATE_EDEFAULT;

  /**
   * The default value of the '{@link #getSome() <em>Some</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSome()
   * @generated
   * @ordered
   */
  protected static final String SOME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSome() <em>Some</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSome()
   * @generated
   * @ordered
   */
  protected String some = SOME_EDEFAULT;

  /**
   * The default value of the '{@link #getSubset() <em>Subset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubset()
   * @generated
   * @ordered
   */
  protected static final String SUBSET_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSubset() <em>Subset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubset()
   * @generated
   * @ordered
   */
  protected String subset = SUBSET_EDEFAULT;

  /**
   * The default value of the '{@link #getSubsig() <em>Subsig</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubsig()
   * @generated
   * @ordered
   */
  protected static final String SUBSIG_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSubsig() <em>Subsig</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubsig()
   * @generated
   * @ordered
   */
  protected String subsig = SUBSIG_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SigTypeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return AlloyXSDFilePackage.Literals.SIG_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureMap getMixed() {
    if (mixed == null) {
      mixed = new BasicFeatureMap(this, AlloyXSDFilePackage.SIG_TYPE__MIXED);
    }
    return mixed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AtomType> getAtom() {
    return getMixed().list(AlloyXSDFilePackage.Literals.SIG_TYPE__ATOM);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAbstract() {
    return abstract_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAbstract(String newAbstract) {
    String oldAbstract = abstract_;
    abstract_ = newAbstract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlloyXSDFilePackage.SIG_TYPE__ABSTRACT, oldAbstract, abstract_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBuiltin() {
    return builtin;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBuiltin(String newBuiltin) {
    String oldBuiltin = builtin;
    builtin = newBuiltin;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlloyXSDFilePackage.SIG_TYPE__BUILTIN, oldBuiltin, builtin));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEnum() {
    return enum_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnum(String newEnum) {
    String oldEnum = enum_;
    enum_ = newEnum;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlloyXSDFilePackage.SIG_TYPE__ENUM, oldEnum, enum_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public byte getID() {
    return iD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setID(byte newID) {
    byte oldID = iD;
    iD = newID;
    boolean oldIDESet = iDESet;
    iDESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlloyXSDFilePackage.SIG_TYPE__ID, oldID, iD, !oldIDESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetID() {
    byte oldID = iD;
    boolean oldIDESet = iDESet;
    iD = ID_EDEFAULT;
    iDESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, AlloyXSDFilePackage.SIG_TYPE__ID, oldID, ID_EDEFAULT, oldIDESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetID() {
    return iDESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLabel() {
    return label;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLabel(String newLabel) {
    String oldLabel = label;
    label = newLabel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlloyXSDFilePackage.SIG_TYPE__LABEL, oldLabel, label));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object getLocation() {
    return location;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLocation(Object newLocation) {
    Object oldLocation = location;
    location = newLocation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlloyXSDFilePackage.SIG_TYPE__LOCATION, oldLocation, location));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLone() {
    return lone;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLone(String newLone) {
    String oldLone = lone;
    lone = newLone;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlloyXSDFilePackage.SIG_TYPE__LONE, oldLone, lone));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMeta() {
    return meta;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMeta(String newMeta) {
    String oldMeta = meta;
    meta = newMeta;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlloyXSDFilePackage.SIG_TYPE__META, oldMeta, meta));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOne() {
    return one;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOne(String newOne) {
    String oldOne = one;
    one = newOne;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlloyXSDFilePackage.SIG_TYPE__ONE, oldOne, one));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public byte getParentID() {
    return parentID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParentID(byte newParentID) {
    byte oldParentID = parentID;
    parentID = newParentID;
    boolean oldParentIDESet = parentIDESet;
    parentIDESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlloyXSDFilePackage.SIG_TYPE__PARENT_ID, oldParentID, parentID, !oldParentIDESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void unsetParentID() {
    byte oldParentID = parentID;
    boolean oldParentIDESet = parentIDESet;
    parentID = PARENT_ID_EDEFAULT;
    parentIDESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, AlloyXSDFilePackage.SIG_TYPE__PARENT_ID, oldParentID, PARENT_ID_EDEFAULT, oldParentIDESet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSetParentID() {
    return parentIDESet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPrivate() {
    return private_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrivate(String newPrivate) {
    String oldPrivate = private_;
    private_ = newPrivate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlloyXSDFilePackage.SIG_TYPE__PRIVATE, oldPrivate, private_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSome() {
    return some;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSome(String newSome) {
    String oldSome = some;
    some = newSome;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlloyXSDFilePackage.SIG_TYPE__SOME, oldSome, some));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSubset() {
    return subset;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubset(String newSubset) {
    String oldSubset = subset;
    subset = newSubset;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlloyXSDFilePackage.SIG_TYPE__SUBSET, oldSubset, subset));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSubsig() {
    return subsig;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubsig(String newSubsig) {
    String oldSubsig = subsig;
    subsig = newSubsig;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlloyXSDFilePackage.SIG_TYPE__SUBSIG, oldSubsig, subsig));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case AlloyXSDFilePackage.SIG_TYPE__MIXED:
        return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
      case AlloyXSDFilePackage.SIG_TYPE__ATOM:
        return ((InternalEList<?>)getAtom()).basicRemove(otherEnd, msgs);
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
      case AlloyXSDFilePackage.SIG_TYPE__MIXED:
        if (coreType) return getMixed();
        return ((FeatureMap.Internal)getMixed()).getWrapper();
      case AlloyXSDFilePackage.SIG_TYPE__ATOM:
        return getAtom();
      case AlloyXSDFilePackage.SIG_TYPE__ABSTRACT:
        return getAbstract();
      case AlloyXSDFilePackage.SIG_TYPE__BUILTIN:
        return getBuiltin();
      case AlloyXSDFilePackage.SIG_TYPE__ENUM:
        return getEnum();
      case AlloyXSDFilePackage.SIG_TYPE__ID:
        return getID();
      case AlloyXSDFilePackage.SIG_TYPE__LABEL:
        return getLabel();
      case AlloyXSDFilePackage.SIG_TYPE__LOCATION:
        return getLocation();
      case AlloyXSDFilePackage.SIG_TYPE__LONE:
        return getLone();
      case AlloyXSDFilePackage.SIG_TYPE__META:
        return getMeta();
      case AlloyXSDFilePackage.SIG_TYPE__ONE:
        return getOne();
      case AlloyXSDFilePackage.SIG_TYPE__PARENT_ID:
        return getParentID();
      case AlloyXSDFilePackage.SIG_TYPE__PRIVATE:
        return getPrivate();
      case AlloyXSDFilePackage.SIG_TYPE__SOME:
        return getSome();
      case AlloyXSDFilePackage.SIG_TYPE__SUBSET:
        return getSubset();
      case AlloyXSDFilePackage.SIG_TYPE__SUBSIG:
        return getSubsig();
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
      case AlloyXSDFilePackage.SIG_TYPE__MIXED:
        ((FeatureMap.Internal)getMixed()).set(newValue);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__ATOM:
        getAtom().clear();
        getAtom().addAll((Collection<? extends AtomType>)newValue);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__ABSTRACT:
        setAbstract((String)newValue);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__BUILTIN:
        setBuiltin((String)newValue);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__ENUM:
        setEnum((String)newValue);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__ID:
        setID((Byte)newValue);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__LABEL:
        setLabel((String)newValue);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__LOCATION:
        setLocation(newValue);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__LONE:
        setLone((String)newValue);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__META:
        setMeta((String)newValue);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__ONE:
        setOne((String)newValue);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__PARENT_ID:
        setParentID((Byte)newValue);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__PRIVATE:
        setPrivate((String)newValue);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__SOME:
        setSome((String)newValue);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__SUBSET:
        setSubset((String)newValue);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__SUBSIG:
        setSubsig((String)newValue);
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
      case AlloyXSDFilePackage.SIG_TYPE__MIXED:
        getMixed().clear();
        return;
      case AlloyXSDFilePackage.SIG_TYPE__ATOM:
        getAtom().clear();
        return;
      case AlloyXSDFilePackage.SIG_TYPE__ABSTRACT:
        setAbstract(ABSTRACT_EDEFAULT);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__BUILTIN:
        setBuiltin(BUILTIN_EDEFAULT);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__ENUM:
        setEnum(ENUM_EDEFAULT);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__ID:
        unsetID();
        return;
      case AlloyXSDFilePackage.SIG_TYPE__LABEL:
        setLabel(LABEL_EDEFAULT);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__LOCATION:
        setLocation(LOCATION_EDEFAULT);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__LONE:
        setLone(LONE_EDEFAULT);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__META:
        setMeta(META_EDEFAULT);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__ONE:
        setOne(ONE_EDEFAULT);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__PARENT_ID:
        unsetParentID();
        return;
      case AlloyXSDFilePackage.SIG_TYPE__PRIVATE:
        setPrivate(PRIVATE_EDEFAULT);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__SOME:
        setSome(SOME_EDEFAULT);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__SUBSET:
        setSubset(SUBSET_EDEFAULT);
        return;
      case AlloyXSDFilePackage.SIG_TYPE__SUBSIG:
        setSubsig(SUBSIG_EDEFAULT);
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
      case AlloyXSDFilePackage.SIG_TYPE__MIXED:
        return mixed != null && !mixed.isEmpty();
      case AlloyXSDFilePackage.SIG_TYPE__ATOM:
        return !getAtom().isEmpty();
      case AlloyXSDFilePackage.SIG_TYPE__ABSTRACT:
        return ABSTRACT_EDEFAULT == null ? abstract_ != null : !ABSTRACT_EDEFAULT.equals(abstract_);
      case AlloyXSDFilePackage.SIG_TYPE__BUILTIN:
        return BUILTIN_EDEFAULT == null ? builtin != null : !BUILTIN_EDEFAULT.equals(builtin);
      case AlloyXSDFilePackage.SIG_TYPE__ENUM:
        return ENUM_EDEFAULT == null ? enum_ != null : !ENUM_EDEFAULT.equals(enum_);
      case AlloyXSDFilePackage.SIG_TYPE__ID:
        return isSetID();
      case AlloyXSDFilePackage.SIG_TYPE__LABEL:
        return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
      case AlloyXSDFilePackage.SIG_TYPE__LOCATION:
        return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
      case AlloyXSDFilePackage.SIG_TYPE__LONE:
        return LONE_EDEFAULT == null ? lone != null : !LONE_EDEFAULT.equals(lone);
      case AlloyXSDFilePackage.SIG_TYPE__META:
        return META_EDEFAULT == null ? meta != null : !META_EDEFAULT.equals(meta);
      case AlloyXSDFilePackage.SIG_TYPE__ONE:
        return ONE_EDEFAULT == null ? one != null : !ONE_EDEFAULT.equals(one);
      case AlloyXSDFilePackage.SIG_TYPE__PARENT_ID:
        return isSetParentID();
      case AlloyXSDFilePackage.SIG_TYPE__PRIVATE:
        return PRIVATE_EDEFAULT == null ? private_ != null : !PRIVATE_EDEFAULT.equals(private_);
      case AlloyXSDFilePackage.SIG_TYPE__SOME:
        return SOME_EDEFAULT == null ? some != null : !SOME_EDEFAULT.equals(some);
      case AlloyXSDFilePackage.SIG_TYPE__SUBSET:
        return SUBSET_EDEFAULT == null ? subset != null : !SUBSET_EDEFAULT.equals(subset);
      case AlloyXSDFilePackage.SIG_TYPE__SUBSIG:
        return SUBSIG_EDEFAULT == null ? subsig != null : !SUBSIG_EDEFAULT.equals(subsig);
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
    result.append(" (mixed: ");
    result.append(mixed);
    result.append(", abstract: ");
    result.append(abstract_);
    result.append(", builtin: ");
    result.append(builtin);
    result.append(", enum: ");
    result.append(enum_);
    result.append(", iD: ");
    if (iDESet) result.append(iD); else result.append("<unset>");
    result.append(", label: ");
    result.append(label);
    result.append(", location: ");
    result.append(location);
    result.append(", lone: ");
    result.append(lone);
    result.append(", meta: ");
    result.append(meta);
    result.append(", one: ");
    result.append(one);
    result.append(", parentID: ");
    if (parentIDESet) result.append(parentID); else result.append("<unset>");
    result.append(", private: ");
    result.append(private_);
    result.append(", some: ");
    result.append(some);
    result.append(", subset: ");
    result.append(subset);
    result.append(", subsig: ");
    result.append(subsig);
    result.append(')');
    return result.toString();
  }

} //SigTypeImpl
