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
package org.eclipse.mylyn.docs.intent.mapping;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Status</b></em>', and
 * utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see org.eclipse.mylyn.docs.intent.mapping.MappingPackage#getStatus()
 * @model
 * @generated
 */
public enum Status implements Enumerator {
	/**
	 * The '<em><b>VALID</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #VALID_VALUE
	 * @generated
	 * @ordered
	 */
	VALID(0, "VALID", "VALID"),

	/**
	 * The '<em><b>CHANGED SOURCE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #CHANGED_SOURCE_VALUE
	 * @generated
	 * @ordered
	 */
	CHANGED_SOURCE(1, "CHANGED_SOURCE", "CHANGED_SOURCE"),

	/**
	 * The '<em><b>CHANGED TARGET</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #CHANGED_TARGET_VALUE
	 * @generated
	 * @ordered
	 */
	CHANGED_TARGET(2, "CHANGED_TARGET", "CHANGED_TARGET"),

	/**
	 * The '<em><b>DELETED SOURCE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #DELETED_SOURCE_VALUE
	 * @generated
	 * @ordered
	 */
	DELETED_SOURCE(3, "DELETED_SOURCE", "DELETED_SOURCE"),

	/**
	 * The '<em><b>DELETED TARGET</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #DELETED_TARGET_VALUE
	 * @generated
	 * @ordered
	 */
	DELETED_TARGET(4, "DELETED_TARGET", "DELETED_TARGET");

	/**
	 * The '<em><b>VALID</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VALID</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #VALID
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VALID_VALUE = 0;

	/**
	 * The '<em><b>CHANGED SOURCE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHANGED SOURCE</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CHANGED_SOURCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHANGED_SOURCE_VALUE = 1;

	/**
	 * The '<em><b>CHANGED TARGET</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHANGED TARGET</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CHANGED_TARGET
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHANGED_TARGET_VALUE = 2;

	/**
	 * The '<em><b>DELETED SOURCE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DELETED SOURCE</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DELETED_SOURCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DELETED_SOURCE_VALUE = 3;

	/**
	 * The '<em><b>DELETED TARGET</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DELETED TARGET</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DELETED_TARGET
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DELETED_TARGET_VALUE = 4;

	/**
	 * An array of all the '<em><b>Status</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final Status[] VALUES_ARRAY = new Status[] {VALID, CHANGED_SOURCE, CHANGED_TARGET,
			DELETED_SOURCE, DELETED_TARGET, };

	/**
	 * A public read-only list of all the '<em><b>Status</b></em>' enumerators. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<Status> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Status</b></em>' literal with the specified literal value. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Status get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Status result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Status</b></em>' literal with the specified name. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static Status getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Status result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Status</b></em>' literal with the specified integer value. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Status get(int value) {
		switch (value) {
			case VALID_VALUE:
				return VALID;
			case CHANGED_SOURCE_VALUE:
				return CHANGED_SOURCE;
			case CHANGED_TARGET_VALUE:
				return CHANGED_TARGET;
			case DELETED_SOURCE_VALUE:
				return DELETED_SOURCE;
			case DELETED_TARGET_VALUE:
				return DELETED_TARGET;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private Status(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
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
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // Status
