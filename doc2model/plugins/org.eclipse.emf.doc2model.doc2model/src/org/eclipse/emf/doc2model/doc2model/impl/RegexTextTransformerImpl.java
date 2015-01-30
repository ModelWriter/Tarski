package org.eclipse.emf.doc2model.doc2model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;
import org.eclipse.emf.doc2model.doc2model.RegexTextTransformer;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Regex Text Transformer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.doc2model.doc2model.impl.RegexTextTransformerImpl#getPatternForGroupingAndRegex <em>Pattern For Grouping And Regex</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegexTextTransformerImpl extends TransformHandledTextImpl implements RegexTextTransformer {
	/**
	 * The default value of the '{@link #getPatternForGroupingAndRegex() <em>Pattern For Grouping And Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatternForGroupingAndRegex()
	 * @generated
	 * @ordered
	 */
	protected static final String PATTERN_FOR_GROUPING_AND_REGEX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPatternForGroupingAndRegex() <em>Pattern For Grouping And Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPatternForGroupingAndRegex()
	 * @generated
	 * @ordered
	 */
	protected String patternForGroupingAndRegex = PATTERN_FOR_GROUPING_AND_REGEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegexTextTransformerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Doc2modelPackage.Literals.REGEX_TEXT_TRANSFORMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPatternForGroupingAndRegex() {
		return patternForGroupingAndRegex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPatternForGroupingAndRegex(String newPatternForGroupingAndRegex) {
		String oldPatternForGroupingAndRegex = patternForGroupingAndRegex;
		patternForGroupingAndRegex = newPatternForGroupingAndRegex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Doc2modelPackage.REGEX_TEXT_TRANSFORMER__PATTERN_FOR_GROUPING_AND_REGEX, oldPatternForGroupingAndRegex, patternForGroupingAndRegex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Doc2modelPackage.REGEX_TEXT_TRANSFORMER__PATTERN_FOR_GROUPING_AND_REGEX:
				return getPatternForGroupingAndRegex();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Doc2modelPackage.REGEX_TEXT_TRANSFORMER__PATTERN_FOR_GROUPING_AND_REGEX:
				setPatternForGroupingAndRegex((String)newValue);
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
			case Doc2modelPackage.REGEX_TEXT_TRANSFORMER__PATTERN_FOR_GROUPING_AND_REGEX:
				setPatternForGroupingAndRegex(PATTERN_FOR_GROUPING_AND_REGEX_EDEFAULT);
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
			case Doc2modelPackage.REGEX_TEXT_TRANSFORMER__PATTERN_FOR_GROUPING_AND_REGEX:
				return PATTERN_FOR_GROUPING_AND_REGEX_EDEFAULT == null ? patternForGroupingAndRegex != null : !PATTERN_FOR_GROUPING_AND_REGEX_EDEFAULT.equals(patternForGroupingAndRegex);
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
		result.append(" (patternForGroupingAndRegex: ");
		result.append(patternForGroupingAndRegex);
		result.append(')');
		return result.toString();
	}

} //RegexTextTransformerImpl
