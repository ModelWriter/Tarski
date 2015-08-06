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
package org.eclipse.mylyn.docs.intent.mapping.tests.testmapping.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.mylyn.docs.intent.mapping.MappingPackage;

import org.eclipse.mylyn.docs.intent.mapping.tests.testmapping.TestLocation;
import org.eclipse.mylyn.docs.intent.mapping.tests.testmapping.TestmappingFactory;
import org.eclipse.mylyn.docs.intent.mapping.tests.testmapping.TestmappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestmappingPackageImpl extends EPackageImpl implements TestmappingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testLocationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.mylyn.docs.intent.mapping.tests.testmapping.TestmappingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TestmappingPackageImpl() {
		super(eNS_URI, TestmappingFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TestmappingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TestmappingPackage init() {
		if (isInited) return (TestmappingPackage)EPackage.Registry.INSTANCE.getEPackage(TestmappingPackage.eNS_URI);

		// Obtain or create and register package
		TestmappingPackageImpl theTestmappingPackage = (TestmappingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TestmappingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TestmappingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MappingPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTestmappingPackage.createPackageContents();

		// Initialize created meta-data
		theTestmappingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTestmappingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TestmappingPackage.eNS_URI, theTestmappingPackage);
		return theTestmappingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestLocation() {
		return testLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestmappingFactory getTestmappingFactory() {
		return (TestmappingFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		testLocationEClass = createEClass(TEST_LOCATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		MappingPackage theMappingPackage = (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		testLocationEClass.getESuperTypes().add(theMappingPackage.getLocation());

		// Initialize classes, features, and operations; add parameters
		initEClass(testLocationEClass, TestLocation.class, "TestLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //TestmappingPackageImpl
