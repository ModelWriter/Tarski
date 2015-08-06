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

import org.eclipse.mylyn.docs.intent.mapping.impl.LocationImpl;

import org.eclipse.mylyn.docs.intent.mapping.tests.testmapping.TestLocation;
import org.eclipse.mylyn.docs.intent.mapping.tests.testmapping.TestmappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TestLocationImpl extends LocationImpl implements TestLocation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestLocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestmappingPackage.Literals.TEST_LOCATION;
	}

} //TestLocationImpl
