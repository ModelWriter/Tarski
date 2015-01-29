head	1.2;
access;
symbols;
locks; strict;
comment	@# @;


1.2
date	2010.03.02.22.43.36;	author tfaure;	state Exp;
branches;
next	1.1;
commitid	83574b8d94834567;

1.1
date	2010.03.02.22.19.50;	author tfaure;	state Exp;
branches;
next	;
commitid	66574b8d8ee24567;


desc
@@


1.2
log
@drop unused action : call activity. an activity as it is referenced is directly called
@
text
@/**
 * Copyright (c) 2010 ATOS ORIGIN INTEGRATION.
 * 
 *     
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@@atosorigin.com - Initial API and implementation
 */
package org.eclipse.emf.doc2model.doc2model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage
 * @@generated
 */
public interface Doc2modelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	Doc2modelFactory eINSTANCE = org.eclipse.emf.doc2model.doc2model.impl.Doc2modelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Doc2 Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Doc2 Model</em>'.
	 * @@generated
	 */
	Doc2Model createDoc2Model();

	/**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Configuration</em>'.
	 * @@generated
	 */
	Configuration createConfiguration();

	/**
	 * Returns a new object of class '<em>Initial Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Initial Model</em>'.
	 * @@generated
	 */
	InitialModel createInitialModel();

	/**
	 * Returns a new object of class '<em>Match</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Match</em>'.
	 * @@generated
	 */
	Match createMatch();

	/**
	 * Returns a new object of class '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Rule</em>'.
	 * @@generated
	 */
	Rule createRule();

	/**
	 * Returns a new object of class '<em>Current Container Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Current Container Selection</em>'.
	 * @@generated
	 */
	CurrentContainerSelection createCurrentContainerSelection();

	/**
	 * Returns a new object of class '<em>Last Element Created Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Last Element Created Selection</em>'.
	 * @@generated
	 */
	LastElementCreatedSelection createLastElementCreatedSelection();

	/**
	 * Returns a new object of class '<em>Static Element Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Static Element Selection</em>'.
	 * @@generated
	 */
	StaticElementSelection createStaticElementSelection();

	/**
	 * Returns a new object of class '<em>Last Container Considering Match Order</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Last Container Considering Match Order</em>'.
	 * @@generated
	 */
	LastContainerConsideringMatchOrder createLastContainerConsideringMatchOrder();

	/**
	 * Returns a new object of class '<em>Create Element Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Create Element Action</em>'.
	 * @@generated
	 */
	CreateElementAction createCreateElementAction();

	/**
	 * Returns a new object of class '<em>Fill Attribute Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Fill Attribute Action</em>'.
	 * @@generated
	 */
	FillAttributeAction createFillAttributeAction();

	/**
	 * Returns a new object of class '<em>EPackage Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>EPackage Reference</em>'.
	 * @@generated
	 */
	EPackageReference createEPackageReference();

	/**
	 * Returns a new object of class '<em>Regex Text Transformer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Regex Text Transformer</em>'.
	 * @@generated
	 */
	RegexTextTransformer createRegexTextTransformer();

	/**
	 * Returns a new object of class '<em>String Replacement Text Transformer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>String Replacement Text Transformer</em>'.
	 * @@generated
	 */
	StringReplacementTextTransformer createStringReplacementTextTransformer();

	/**
	 * Returns a new object of class '<em>Reference Static Element Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Reference Static Element Action</em>'.
	 * @@generated
	 */
	ReferenceStaticElementAction createReferenceStaticElementAction();

	/**
	 * Returns a new object of class '<em>Container Selection Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Container Selection Object</em>'.
	 * @@generated
	 */
	ContainerSelectionObject createContainerSelectionObject();

	/**
	 * Returns a new object of class '<em>Parameter Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Parameter Object</em>'.
	 * @@generated
	 */
	ParameterObject createParameterObject();

	/**
	 * Returns a new object of class '<em>Action Result Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Action Result Object</em>'.
	 * @@generated
	 */
	ActionResultObject createActionResultObject();

	/**
	 * Returns a new object of class '<em>Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Activity</em>'.
	 * @@generated
	 */
	Activity createActivity();

	/**
	 * Returns a new object of class '<em>Matching Result Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Matching Result Object</em>'.
	 * @@generated
	 */
	MatchingResultObject createMatchingResultObject();

	/**
	 * Returns a new object of class '<em>Reference Element Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Reference Element Action</em>'.
	 * @@generated
	 */
	ReferenceElementAction createReferenceElementAction();

	/**
	 * Returns a new object of class '<em>Set Container Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Set Container Action</em>'.
	 * @@generated
	 */
	SetContainerAction createSetContainerAction();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the package supported by this factory.
	 * @@generated
	 */
	Doc2modelPackage getDoc2modelPackage();

} //Doc2modelFactory
@


1.1
log
@first commit for doc2model api
@
text
@a232 9
	 * Returns a new object of class '<em>Call Activity Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return a new object of class '<em>Call Activity Action</em>'.
	 * @@generated
	 */
	CallActivityAction createCallActivityAction();

	/**
@

