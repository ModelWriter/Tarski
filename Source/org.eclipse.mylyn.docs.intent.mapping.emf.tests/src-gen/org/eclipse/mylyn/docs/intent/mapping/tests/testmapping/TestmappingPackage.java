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
package org.eclipse.mylyn.docs.intent.mapping.tests.testmapping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.mylyn.docs.intent.mapping.MappingPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.mylyn.docs.intent.mapping.tests.testmapping.TestmappingFactory
 * @model kind="package"
 * @generated
 */
public interface TestmappingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "testmapping";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.modelwriter.eu/testmapping";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "testmapping";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestmappingPackage eINSTANCE = org.eclipse.mylyn.docs.intent.mapping.tests.testmapping.impl.TestmappingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.mylyn.docs.intent.mapping.tests.testmapping.impl.TestLocationImpl <em>Test Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.mylyn.docs.intent.mapping.tests.testmapping.impl.TestLocationImpl
	 * @see org.eclipse.mylyn.docs.intent.mapping.tests.testmapping.impl.TestmappingPackageImpl#getTestLocation()
	 * @generated
	 */
	int TEST_LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_LOCATION__NAME = MappingPackage.LOCATION__NAME;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_LOCATION__SCOPE = MappingPackage.LOCATION__SCOPE;

	/**
	 * The feature id for the '<em><b>Source Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_LOCATION__SOURCE_LINKS = MappingPackage.LOCATION__SOURCE_LINKS;

	/**
	 * The feature id for the '<em><b>Target Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_LOCATION__TARGET_LINKS = MappingPackage.LOCATION__TARGET_LINKS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_LOCATION__CONTENTS = MappingPackage.LOCATION__CONTENTS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_LOCATION__CONTAINER = MappingPackage.LOCATION__CONTAINER;

	/**
	 * The feature id for the '<em><b>Referencing Scopes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_LOCATION__REFERENCING_SCOPES = MappingPackage.LOCATION__REFERENCING_SCOPES;

	/**
	 * The number of structural features of the '<em>Test Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_LOCATION_FEATURE_COUNT = MappingPackage.LOCATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Test Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_LOCATION_OPERATION_COUNT = MappingPackage.LOCATION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.mylyn.docs.intent.mapping.tests.testmapping.TestLocation <em>Test Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Location</em>'.
	 * @see org.eclipse.mylyn.docs.intent.mapping.tests.testmapping.TestLocation
	 * @generated
	 */
	EClass getTestLocation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestmappingFactory getTestmappingFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.mylyn.docs.intent.mapping.tests.testmapping.impl.TestLocationImpl <em>Test Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.mylyn.docs.intent.mapping.tests.testmapping.impl.TestLocationImpl
		 * @see org.eclipse.mylyn.docs.intent.mapping.tests.testmapping.impl.TestmappingPackageImpl#getTestLocation()
		 * @generated
		 */
		EClass TEST_LOCATION = eINSTANCE.getTestLocation();

	}

} //TestmappingPackage
