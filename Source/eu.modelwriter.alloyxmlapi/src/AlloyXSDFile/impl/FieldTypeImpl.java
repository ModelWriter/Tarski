/**
 */
package AlloyXSDFile.impl;

import AlloyXSDFile.AlloyXSDFilePackage;
import AlloyXSDFile.FieldType;
import AlloyXSDFile.TupleType;
import AlloyXSDFile.TypesType;

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
 * An implementation of the model object '<em><b>Field Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link AlloyXSDFile.impl.FieldTypeImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.FieldTypeImpl#getTuple <em>Tuple</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.FieldTypeImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.FieldTypeImpl#getID <em>ID</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.FieldTypeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.FieldTypeImpl#getParentID <em>Parent ID</em>}</li>
 *   <li>{@link AlloyXSDFile.impl.FieldTypeImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FieldTypeImpl extends MinimalEObjectImpl.Container implements FieldType {
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
   * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected static final String EXPRESSION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected String expression = EXPRESSION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FieldTypeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return AlloyXSDFilePackage.Literals.FIELD_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureMap getMixed() {
    if (mixed == null) {
      mixed = new BasicFeatureMap(this, AlloyXSDFilePackage.FIELD_TYPE__MIXED);
    }
    return mixed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TupleType> getTuple() {
    return getMixed().list(AlloyXSDFilePackage.Literals.FIELD_TYPE__TUPLE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypesType getTypes() {
    return (TypesType)getMixed().get(AlloyXSDFilePackage.Literals.FIELD_TYPE__TYPES, true);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypes(TypesType newTypes, NotificationChain msgs) {
    return ((FeatureMap.Internal)getMixed()).basicAdd(AlloyXSDFilePackage.Literals.FIELD_TYPE__TYPES, newTypes, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypes(TypesType newTypes) {
    ((FeatureMap.Internal)getMixed()).set(AlloyXSDFilePackage.Literals.FIELD_TYPE__TYPES, newTypes);
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
      eNotify(new ENotificationImpl(this, Notification.SET, AlloyXSDFilePackage.FIELD_TYPE__ID, oldID, iD, !oldIDESet));
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
      eNotify(new ENotificationImpl(this, Notification.UNSET, AlloyXSDFilePackage.FIELD_TYPE__ID, oldID, ID_EDEFAULT, oldIDESet));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AlloyXSDFilePackage.FIELD_TYPE__LABEL, oldLabel, label));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AlloyXSDFilePackage.FIELD_TYPE__PARENT_ID, oldParentID, parentID, !oldParentIDESet));
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
      eNotify(new ENotificationImpl(this, Notification.UNSET, AlloyXSDFilePackage.FIELD_TYPE__PARENT_ID, oldParentID, PARENT_ID_EDEFAULT, oldParentIDESet));
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
  public String getExpression() {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(String newExpression) {
    String oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlloyXSDFilePackage.FIELD_TYPE__EXPRESSION, oldExpression, expression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case AlloyXSDFilePackage.FIELD_TYPE__MIXED:
        return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
      case AlloyXSDFilePackage.FIELD_TYPE__TUPLE:
        return ((InternalEList<?>)getTuple()).basicRemove(otherEnd, msgs);
      case AlloyXSDFilePackage.FIELD_TYPE__TYPES:
        return basicSetTypes(null, msgs);
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
      case AlloyXSDFilePackage.FIELD_TYPE__MIXED:
        if (coreType) return getMixed();
        return ((FeatureMap.Internal)getMixed()).getWrapper();
      case AlloyXSDFilePackage.FIELD_TYPE__TUPLE:
        return getTuple();
      case AlloyXSDFilePackage.FIELD_TYPE__TYPES:
        return getTypes();
      case AlloyXSDFilePackage.FIELD_TYPE__ID:
        return getID();
      case AlloyXSDFilePackage.FIELD_TYPE__LABEL:
        return getLabel();
      case AlloyXSDFilePackage.FIELD_TYPE__PARENT_ID:
        return getParentID();
      case AlloyXSDFilePackage.FIELD_TYPE__EXPRESSION:
        return getExpression();
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
      case AlloyXSDFilePackage.FIELD_TYPE__MIXED:
        ((FeatureMap.Internal)getMixed()).set(newValue);
        return;
      case AlloyXSDFilePackage.FIELD_TYPE__TUPLE:
        getTuple().clear();
        getTuple().addAll((Collection<? extends TupleType>)newValue);
        return;
      case AlloyXSDFilePackage.FIELD_TYPE__TYPES:
        setTypes((TypesType)newValue);
        return;
      case AlloyXSDFilePackage.FIELD_TYPE__ID:
        setID((Byte)newValue);
        return;
      case AlloyXSDFilePackage.FIELD_TYPE__LABEL:
        setLabel((String)newValue);
        return;
      case AlloyXSDFilePackage.FIELD_TYPE__PARENT_ID:
        setParentID((Byte)newValue);
        return;
      case AlloyXSDFilePackage.FIELD_TYPE__EXPRESSION:
        setExpression((String)newValue);
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
      case AlloyXSDFilePackage.FIELD_TYPE__MIXED:
        getMixed().clear();
        return;
      case AlloyXSDFilePackage.FIELD_TYPE__TUPLE:
        getTuple().clear();
        return;
      case AlloyXSDFilePackage.FIELD_TYPE__TYPES:
        setTypes((TypesType)null);
        return;
      case AlloyXSDFilePackage.FIELD_TYPE__ID:
        unsetID();
        return;
      case AlloyXSDFilePackage.FIELD_TYPE__LABEL:
        setLabel(LABEL_EDEFAULT);
        return;
      case AlloyXSDFilePackage.FIELD_TYPE__PARENT_ID:
        unsetParentID();
        return;
      case AlloyXSDFilePackage.FIELD_TYPE__EXPRESSION:
        setExpression(EXPRESSION_EDEFAULT);
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
      case AlloyXSDFilePackage.FIELD_TYPE__MIXED:
        return mixed != null && !mixed.isEmpty();
      case AlloyXSDFilePackage.FIELD_TYPE__TUPLE:
        return !getTuple().isEmpty();
      case AlloyXSDFilePackage.FIELD_TYPE__TYPES:
        return getTypes() != null;
      case AlloyXSDFilePackage.FIELD_TYPE__ID:
        return isSetID();
      case AlloyXSDFilePackage.FIELD_TYPE__LABEL:
        return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
      case AlloyXSDFilePackage.FIELD_TYPE__PARENT_ID:
        return isSetParentID();
      case AlloyXSDFilePackage.FIELD_TYPE__EXPRESSION:
        return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
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
    result.append(", iD: ");
    if (iDESet) result.append(iD); else result.append("<unset>");
    result.append(", label: ");
    result.append(label);
    result.append(", parentID: ");
    if (parentIDESet) result.append(parentID); else result.append("<unset>");
    result.append(", expression: ");
    result.append(expression);
    result.append(')');
    return result.toString();
  }

} //FieldTypeImpl
