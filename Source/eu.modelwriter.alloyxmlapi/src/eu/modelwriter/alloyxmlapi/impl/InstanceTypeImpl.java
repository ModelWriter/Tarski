/**
 */
package eu.modelwriter.alloyxmlapi.impl;

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

import eu.modelwriter.alloyxmlapi.AlloyXSDFilePackage;
import eu.modelwriter.alloyxmlapi.FieldType;
import eu.modelwriter.alloyxmlapi.InstanceType;
import eu.modelwriter.alloyxmlapi.SigType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Instance Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link eu.modelwriter.alloyxmlapi.impl.InstanceTypeImpl#getGroup <em>Group</em>}</li>
 * <li>{@link eu.modelwriter.alloyxmlapi.impl.InstanceTypeImpl#getSig <em>Sig</em>}</li>
 * <li>{@link eu.modelwriter.alloyxmlapi.impl.InstanceTypeImpl#getField <em>Field</em>}</li>
 * <li>{@link eu.modelwriter.alloyxmlapi.impl.InstanceTypeImpl#getBitwidth <em>Bitwidth</em>}</li>
 * <li>{@link eu.modelwriter.alloyxmlapi.impl.InstanceTypeImpl#getCommand <em>Command</em>}</li>
 * <li>{@link eu.modelwriter.alloyxmlapi.impl.InstanceTypeImpl#getFilename <em>Filename</em>}</li>
 * <li>{@link eu.modelwriter.alloyxmlapi.impl.InstanceTypeImpl#getMaxseq <em>Maxseq</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InstanceTypeImpl extends MinimalEObjectImpl.Container implements InstanceType {
  /**
   * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getGroup()
   * @generated
   * @ordered
   */
  protected FeatureMap group;

  /**
   * The default value of the '{@link #getBitwidth() <em>Bitwidth</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getBitwidth()
   * @generated
   * @ordered
   */
  protected static final byte BITWIDTH_EDEFAULT = 0x00;

  /**
   * The cached value of the '{@link #getBitwidth() <em>Bitwidth</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getBitwidth()
   * @generated
   * @ordered
   */
  protected byte bitwidth = BITWIDTH_EDEFAULT;

  /**
   * This is true if the Bitwidth attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  protected boolean bitwidthESet;

  /**
   * The default value of the '{@link #getCommand() <em>Command</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getCommand()
   * @generated
   * @ordered
   */
  protected static final String COMMAND_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCommand() <em>Command</em>}' attribute. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * 
   * @see #getCommand()
   * @generated
   * @ordered
   */
  protected String command = COMMAND_EDEFAULT;

  /**
   * The default value of the '{@link #getFilename() <em>Filename</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getFilename()
   * @generated
   * @ordered
   */
  protected static final String FILENAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFilename() <em>Filename</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getFilename()
   * @generated
   * @ordered
   */
  protected String filename = FILENAME_EDEFAULT;

  /**
   * The default value of the '{@link #getMaxseq() <em>Maxseq</em>}' attribute. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * 
   * @see #getMaxseq()
   * @generated
   * @ordered
   */
  protected static final byte MAXSEQ_EDEFAULT = 0x00;

  /**
   * The cached value of the '{@link #getMaxseq() <em>Maxseq</em>}' attribute. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * 
   * @see #getMaxseq()
   * @generated
   * @ordered
   */
  protected byte maxseq = MAXSEQ_EDEFAULT;

  /**
   * This is true if the Maxseq attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @generated
   * @ordered
   */
  protected boolean maxseqESet;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected InstanceTypeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return AlloyXSDFilePackage.Literals.INSTANCE_TYPE;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public FeatureMap getGroup() {
    if (group == null) {
      group = new BasicFeatureMap(this, AlloyXSDFilePackage.INSTANCE_TYPE__GROUP);
    }
    return group;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EList<SigType> getSig() {
    return getGroup().list(AlloyXSDFilePackage.Literals.INSTANCE_TYPE__SIG);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EList<FieldType> getField() {
    return getGroup().list(AlloyXSDFilePackage.Literals.INSTANCE_TYPE__FIELD);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public byte getBitwidth() {
    return bitwidth;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setBitwidth(byte newBitwidth) {
    byte oldBitwidth = bitwidth;
    bitwidth = newBitwidth;
    boolean oldBitwidthESet = bitwidthESet;
    bitwidthESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          AlloyXSDFilePackage.INSTANCE_TYPE__BITWIDTH, oldBitwidth, bitwidth, !oldBitwidthESet));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void unsetBitwidth() {
    byte oldBitwidth = bitwidth;
    boolean oldBitwidthESet = bitwidthESet;
    bitwidth = BITWIDTH_EDEFAULT;
    bitwidthESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET,
          AlloyXSDFilePackage.INSTANCE_TYPE__BITWIDTH, oldBitwidth, BITWIDTH_EDEFAULT,
          oldBitwidthESet));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean isSetBitwidth() {
    return bitwidthESet;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String getCommand() {
    return command;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setCommand(String newCommand) {
    String oldCommand = command;
    command = newCommand;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          AlloyXSDFilePackage.INSTANCE_TYPE__COMMAND, oldCommand, command));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String getFilename() {
    return filename;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setFilename(String newFilename) {
    String oldFilename = filename;
    filename = newFilename;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          AlloyXSDFilePackage.INSTANCE_TYPE__FILENAME, oldFilename, filename));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public byte getMaxseq() {
    return maxseq;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setMaxseq(byte newMaxseq) {
    byte oldMaxseq = maxseq;
    maxseq = newMaxseq;
    boolean oldMaxseqESet = maxseqESet;
    maxseqESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          AlloyXSDFilePackage.INSTANCE_TYPE__MAXSEQ, oldMaxseq, maxseq, !oldMaxseqESet));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void unsetMaxseq() {
    byte oldMaxseq = maxseq;
    boolean oldMaxseqESet = maxseqESet;
    maxseq = MAXSEQ_EDEFAULT;
    maxseqESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET,
          AlloyXSDFilePackage.INSTANCE_TYPE__MAXSEQ, oldMaxseq, MAXSEQ_EDEFAULT, oldMaxseqESet));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean isSetMaxseq() {
    return maxseqESet;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch (featureID) {
      case AlloyXSDFilePackage.INSTANCE_TYPE__GROUP:
        return ((InternalEList<?>) getGroup()).basicRemove(otherEnd, msgs);
      case AlloyXSDFilePackage.INSTANCE_TYPE__SIG:
        return ((InternalEList<?>) getSig()).basicRemove(otherEnd, msgs);
      case AlloyXSDFilePackage.INSTANCE_TYPE__FIELD:
        return ((InternalEList<?>) getField()).basicRemove(otherEnd, msgs);
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
      case AlloyXSDFilePackage.INSTANCE_TYPE__GROUP:
        if (coreType)
          return getGroup();
        return ((FeatureMap.Internal) getGroup()).getWrapper();
      case AlloyXSDFilePackage.INSTANCE_TYPE__SIG:
        return getSig();
      case AlloyXSDFilePackage.INSTANCE_TYPE__FIELD:
        return getField();
      case AlloyXSDFilePackage.INSTANCE_TYPE__BITWIDTH:
        return getBitwidth();
      case AlloyXSDFilePackage.INSTANCE_TYPE__COMMAND:
        return getCommand();
      case AlloyXSDFilePackage.INSTANCE_TYPE__FILENAME:
        return getFilename();
      case AlloyXSDFilePackage.INSTANCE_TYPE__MAXSEQ:
        return getMaxseq();
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
      case AlloyXSDFilePackage.INSTANCE_TYPE__GROUP:
        ((FeatureMap.Internal) getGroup()).set(newValue);
        return;
      case AlloyXSDFilePackage.INSTANCE_TYPE__SIG:
        getSig().clear();
        getSig().addAll((Collection<? extends SigType>) newValue);
        return;
      case AlloyXSDFilePackage.INSTANCE_TYPE__FIELD:
        getField().clear();
        getField().addAll((Collection<? extends FieldType>) newValue);
        return;
      case AlloyXSDFilePackage.INSTANCE_TYPE__BITWIDTH:
        setBitwidth((Byte) newValue);
        return;
      case AlloyXSDFilePackage.INSTANCE_TYPE__COMMAND:
        setCommand((String) newValue);
        return;
      case AlloyXSDFilePackage.INSTANCE_TYPE__FILENAME:
        setFilename((String) newValue);
        return;
      case AlloyXSDFilePackage.INSTANCE_TYPE__MAXSEQ:
        setMaxseq((Byte) newValue);
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
      case AlloyXSDFilePackage.INSTANCE_TYPE__GROUP:
        getGroup().clear();
        return;
      case AlloyXSDFilePackage.INSTANCE_TYPE__SIG:
        getSig().clear();
        return;
      case AlloyXSDFilePackage.INSTANCE_TYPE__FIELD:
        getField().clear();
        return;
      case AlloyXSDFilePackage.INSTANCE_TYPE__BITWIDTH:
        unsetBitwidth();
        return;
      case AlloyXSDFilePackage.INSTANCE_TYPE__COMMAND:
        setCommand(COMMAND_EDEFAULT);
        return;
      case AlloyXSDFilePackage.INSTANCE_TYPE__FILENAME:
        setFilename(FILENAME_EDEFAULT);
        return;
      case AlloyXSDFilePackage.INSTANCE_TYPE__MAXSEQ:
        unsetMaxseq();
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
      case AlloyXSDFilePackage.INSTANCE_TYPE__GROUP:
        return group != null && !group.isEmpty();
      case AlloyXSDFilePackage.INSTANCE_TYPE__SIG:
        return !getSig().isEmpty();
      case AlloyXSDFilePackage.INSTANCE_TYPE__FIELD:
        return !getField().isEmpty();
      case AlloyXSDFilePackage.INSTANCE_TYPE__BITWIDTH:
        return isSetBitwidth();
      case AlloyXSDFilePackage.INSTANCE_TYPE__COMMAND:
        return COMMAND_EDEFAULT == null ? command != null : !COMMAND_EDEFAULT.equals(command);
      case AlloyXSDFilePackage.INSTANCE_TYPE__FILENAME:
        return FILENAME_EDEFAULT == null ? filename != null : !FILENAME_EDEFAULT.equals(filename);
      case AlloyXSDFilePackage.INSTANCE_TYPE__MAXSEQ:
        return isSetMaxseq();
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
    result.append(" (group: ");
    result.append(group);
    result.append(", bitwidth: ");
    if (bitwidthESet)
      result.append(bitwidth);
    else
      result.append("<unset>");
    result.append(", command: ");
    result.append(command);
    result.append(", filename: ");
    result.append(filename);
    result.append(", maxseq: ");
    if (maxseqESet)
      result.append(maxseq);
    else
      result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} // InstanceTypeImpl
